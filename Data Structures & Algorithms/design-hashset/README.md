# Design HashSet

| Field | Value |
|-------|-------|
| Topic | Design |
| Difficulty | Easy |
| Primary Pattern | Direct-address boolean array |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Implement a HashSet without using built-in library sets: `add(key)`, `remove(key)`, `contains(key)`.

---

## Constraints (typical)

- `0 ≤ key ≤ 10⁶`
- At most `10⁴` operations

---

## Brute Force

LinkedList of keys with linear scan for `contains`/`remove` → O(n). Correct but slow.

---

## Core Observation

Keys are bounded `[0, 10⁶]` — same as HashMap. A `boolean[1_000_001]` acts as a perfect bitset; each index is true if and only if that key is in the set.

---

## Thinking Process

1. `boolean[] mset = new boolean[1_000_001]`; `Arrays.fill(mset, false)`.
2. `add(key)` → `mset[key] = true`.
3. `remove(key)` → `mset[key] = false`.
4. `contains(key)` → `return mset[key]`.

---

## Why the Approach Works

Presence is a single bit per possible key. Direct indexing gives O(1) for all three operations. No hash collisions, no chaining.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Direct-address bit array |
| Upgrade | `BitSet` for denser memory if needed |

### Pattern Recognition Clues

- "Implement set" + bounded integer keys
- Only need add/remove/contains (no key-value mapping)

---

## Alternative Approaches

**Chaining hash set:** array of LinkedLists; `hash(key) % buckets`. O(1) amortized for general keys. Overkill here.

---

## Critical Implementation Details

- Array size must be `10⁶ + 1` (index `10⁶` must be valid)
- `boolean[]` default is already `false` — `Arrays.fill` is optional but explicit
- `add` on already-present key is a no-op (idempotent)
- `remove` on absent key is a no-op

---

## Edge Cases

- `add(0)`, `contains(0)` — minimum boundary
- `add(1000000)`, `contains(1000000)` — maximum boundary
- `remove` then `add` same key

---

## Common Mistakes

- Array size `10⁶` instead of `10⁶ + 1` (index out of bounds on max key)
- Implementing as LinkedList instead of using the bounded-key insight

---

## Complexity

| | |
|--|--|
| Time | O(1) per operation |
| Space | O(10⁶) — fixed |

---

## Similar Problems

- [design-hashmap](../design-hashmap/README.md) — same pattern, stores values too
- [duplicate-integer](../duplicate-integer/README.md) — set-based duplicate detection

---

## One-line Takeaway

**Bounded keys → `boolean[10⁶+1]`; add/remove/contains are array reads/writes.**

---

## Revision Checklist

- [ ] Why size `10⁶ + 1`?
- [ ] Difference vs HashMap design?
- [ ] When would chaining be necessary?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0.java` |
