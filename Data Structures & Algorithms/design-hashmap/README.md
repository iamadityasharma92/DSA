# Design HashMap

| Field | Value |
|-------|-------|
| Topic | Design |
| Difficulty | Easy |
| Primary Pattern | Direct-address array |
| Secondary Pattern | Sentinel for absent keys |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Implement a HashMap without using the built-in library: `put(key, value)`, `get(key)` (returns `-1` if not found), `remove(key)`.

---

## Constraints (typical)

- `0 ≤ key ≤ 10⁶` — bounded integer keys
- `0 ≤ value ≤ 10⁶`
- At most `10⁴` operations

---

## Brute Force

LinkedList of (key, value) pairs with linear scan → O(n) get/remove. Correct but slow.

---

## Core Observation

Keys are bounded `[0, 10⁶]` — this allows direct address indexing. No hash function or collision handling needed; an `int[1_000_001]` array acts as a perfect hash.

---

## Thinking Process

1. `int[] map = new int[1_000_001]`; `Arrays.fill(map, -1)`.
2. `put(key, value)` → `map[key] = value`.
3. `get(key)` → `map[key]` (returns `-1` if never set or removed).
4. `remove(key)` → `map[key] = -1`.

---

## Why the Approach Works

When key range is bounded, the key itself is the index — no hashing or collision resolution needed. `O(1)` for all operations.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Direct-address table |
| Real-world | Hash table with chaining for unbounded/string keys |

### Pattern Recognition Clues

- "Implement hash map" + bounded integer key range
- Constraints explicitly cap the key range

---

## Alternative Approaches

**Array of LinkedLists (chaining):** hash key to bucket, chain entries. O(1) amortized, O(n/b) worst. Needed for string keys or unbounded ranges.

---

## Critical Implementation Details

- Sentinel is `-1` because it is outside the valid value range `[0, 10⁶]`; `0` cannot be used as absent since `0` is a valid value
- `Arrays.fill(map, -1)` in constructor — default `int[]` is 0 which would be wrong
- No tombstone needed: `remove` simply writes `-1`

---

## Edge Cases

- `put(key, 0)` then `get(key)` — must return `0`, not treat as absent
- `remove` then `get` — must return `-1`
- `put` same key twice — second value overwrites first

---

## Common Mistakes

- Using `0` as the absent sentinel when `0` is a valid value
- Forgetting to `fill(-1)` in the constructor (leaving default `0` which is wrong)
- Over-engineering with a real hash function when the key range is small and bounded

---

## Complexity

| | |
|--|--|
| Time | O(1) per operation |
| Space | O(10⁶) — fixed regardless of how many entries stored |

---

## Similar Problems

- [design-hashset](../design-hashset/README.md) — same trick for presence-only
- [lru-cache](../lru-cache/README.md) — O(1) get/put with eviction order

---

## One-line Takeaway

**Bounded integer keys → use the key as direct array index; -1 sentinel for absent.**

---

## Revision Checklist

- [ ] Why `-1` as sentinel (not `0`)?
- [ ] What `Arrays.fill` does and when it's needed?
- [ ] When would you need chaining instead?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0.java` |
