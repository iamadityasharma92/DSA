# Find the Duplicate Number

| Field | Value |
|-------|-------|
| Topic | Linked List |
| Difficulty | Medium |
| Primary Pattern | Floyd's Cycle Detection |
| Secondary Pattern | In-place index marking |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given an array `nums` of length `n + 1` where every element is in `[1, n]`, exactly one value appears **at least twice**. Find that duplicate without modifying the array and using O(1) extra space.

---

## Constraints (typical)

- `n + 1` elements, values in `[1, n]`
- Only one duplicate (may appear more than twice)
- Must not modify the array; O(1) extra space

---

## Brute Force

`submission-0`: HashMap frequency count → O(n) time, O(n) space. Works but violates O(1) space constraint.  
`submission-1`: HashSet, same idea.

---

## Core Observation

Values in `[1, n]` in an array of size `n + 1` define an **implicit linked list** where `i → nums[i]`. Since one value repeats, two indices point to the same "next", forming a cycle. The cycle entrance = the duplicate value. This is exactly Floyd's Tortoise and Hare.

---

## Thinking Process

**Phase 1 — find meeting point inside the cycle:**
1. `slow = nums[slow]`, `fast = nums[nums[fast]]`
2. Repeat until `slow == fast`.

**Phase 2 — find cycle entrance:**
1. Reset `slow2 = 0` (or `nums[0]` in some variants, but start = 0 here).
2. `slow = nums[slow]`, `slow2 = nums[slow2]`
3. When `slow == slow2`: that value is the duplicate.

`submission-4` is the canonical O(1) space solution. `submission-3` uses negative marking (O(1) space but mutates).

---

## Why the Approach Works

Floyd's theorem: after the meeting point, one pointer from the array start and one from the meeting point both take the same distance to reach the cycle entry. The cycle entry corresponds to the duplicated index — i.e. the duplicate value.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Floyd's Cycle Detection (find entry) |
| Alternative | In-place negation marking (submission-3) — O(1) but mutates |
| Simple | HashSet (O(n) space) |

### Pattern Recognition Clues

- "Find duplicate in [1..n] array of size n+1, O(1) space"
- Treat value→index mapping as a linked list

Cross-ref: [Linked List](../Linked%20List/README.md) · [PATTERNS.md](../../PATTERNS.md#floyd-cycle-fast--slow)

---

## Alternative Approaches

**Negative marking (`submission-3`):** for each `num`, flip `nums[abs(num)-1]` negative; if already negative, `abs(num)` is duplicate. O(1) space but modifies the array — violates strict constraints.

---

## Critical Implementation Details

- Traversal is `nums[pointer]`, NOT `pointer + 1` — the *value* is the next node
- Phase 2 `slow2` starts at `0` (the "head" of the implicit list), not at the meeting point
- Phase 1 must use `nums[nums[fast]]` for fast (skip two links per step)

---

## Edge Cases

- Duplicate appears many times
- `n = 1`, array `[1, 1]`

---

## Common Mistakes

- Using `pointer++` instead of `nums[pointer]` as next
- Starting Phase 2 both pointers from the meeting point (wrong — one must restart from 0)
- Confusing with linked-list-cycle-detection (that only detects, not finds entry)

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) (Floyd); O(n) (HashSet alternatives) |

---

## Similar Problems

- [linked-list-cycle-detection](../linked-list-cycle-detection/README.md) — detect only, same fast/slow idea
- [first-missing-positive](../first-missing-positive/README.md) — also uses index-as-marker trick

---

## One-line Takeaway

**nums[i] as pointer → Floyd cycle find entry = duplicate value.**

---

## Revision Checklist

- [ ] How does index→value create an implicit linked list?
- [ ] Phase 1: where do the two pointers meet, and why?
- [ ] Phase 2: why does `slow2` restart from 0?
- [ ] When would negative-marking be acceptable?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0` (HashSet) → `submission-3` (negation) → `submission-4` (Floyd, best) |
