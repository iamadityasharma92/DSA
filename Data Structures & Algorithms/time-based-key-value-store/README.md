# Time Based Key-Value Store

| Field | Value |
|-------|-------|
| Topic | Binary Search |
| Difficulty | Medium |
| Primary Pattern | Binary Search on sorted timestamp list |
| Secondary Pattern | HashMap + List |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Design a time-based key-value store: `set(key, value, timestamp)` stores values; `get(key, timestamp)` returns the value with the largest timestamp ≤ given timestamp. Returns `""` if no such value exists.

---

## Constraints (typical)

- Timestamps for `set` calls are strictly increasing per key
- `get` must return value with largest timestamp ≤ target
- At most `10⁵` set/get calls

---

## Brute Force

Linear scan over all timestamps per key → O(n) per `get`. Too slow.

---

## Core Observation

Timestamps are inserted in strictly increasing order — the list for each key is always sorted. Binary search the list for the largest timestamp ≤ `timestamp`.

---

## Thinking Process

1. `HashMap<String, List<TimeStampValue>> map`.
2. `set(key, value, t)`: append `{t, value}` to `map.get(key)` (or create list). Guaranteed increasing → always sorted.
3. `get(key, t)`:
   - `l = 0`, `r = list.size()-1`, `ans = ""`.
   - While `l <= r`: `m = l + (r-l)/2`.
   - If `list[m].timestamp <= t` → `ans = list[m].value`, `l = m+1` (try to find later valid time).
   - Else → `r = m-1`.
4. Return `ans`.

---

## Why the Approach Works

Timestamps strictly increasing → list is sorted. Binary search finds the **rightmost** entry with timestamp ≤ target. The `ans` variable captures the best (latest valid) value seen as `l` advances.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Binary search for largest value ≤ target (floor/predecessor) |
| Container | HashMap of sorted lists |

### Pattern Recognition Clues

- "Most recent value at or before timestamp"
- Timestamps always increasing → list always sorted → BS applicable

Cross-ref: [Binary Search](../Binary%20Search/README.md) · [PATTERNS.md](../../PATTERNS.md#binary-search-templates)

---

## Alternative Approaches

`TreeMap<Integer, String>` per key with `floorKey(timestamp)` — O(log n) same, Java-idiomatic.

---

## Critical Implementation Details

- `ans = list[m].value; l = m+1` when timestamp ≤ target — captures valid value and tries to find a later one
- Return `""` if `ans` was never updated (no timestamp ≤ target found)
- Using a custom `TimeStampValue` class vs simple `int[]` — both work; arrays are more compact

---

## Edge Cases

- `get` before any `set` → returns `""`
- `timestamp` exactly matches a stored timestamp
- `timestamp` smaller than all stored timestamps for key

---

## Common Mistakes

- Not saving `ans` on each valid match — only returning last `l` (misses valid intermediate)
- Not handling null list (key never set)
- Using `<` instead of `<=` in the condition (`==` match should also be valid)

---

## Complexity

| | |
|--|--|
| Time | `set` O(1); `get` O(log n) |
| Space | O(n) |

---

## Similar Problems

- [binary-search](../binary-search/README.md) — same BS template
- [search-insert-position](../search-insert-position/README.md) — floor/insert position variant

---

## One-line Takeaway

**Strictly increasing timestamps → sorted list per key → BS for largest timestamp ≤ target.**

---

## Revision Checklist

- [ ] Why is the list always sorted?
- [ ] BS: capture `ans` when timestamp ≤ target, then `l = m+1`?
- [ ] Alternative: `TreeMap.floorKey()`?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0.java` |
