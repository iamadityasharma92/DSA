# Remove Duplicates from Sorted Array

| Field | Value |
|-------|-------|
| Topic | Two Pointers |
| Difficulty | Easy |
| Primary Pattern | Two Pointers (slow-fast in-place dedup) |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given a sorted array, remove duplicates **in-place** so each element appears only once. Return the count of unique elements `k`. The first `k` elements of the array should contain the unique values in order.

---

## Constraints (typical)

- Sorted ascending
- In-place (O(1) extra space)
- Values beyond `k` in the array don't matter

---

## Brute Force

Copy unique values to a separate array → O(n) but O(n) extra space. Violates in-place constraint.

---

## Core Observation

Two pointers: `l` marks the "write position" (last unique element written); `r` scans right. When `nums[r] != nums[l]`, write `nums[r]` to `nums[l+1]`.

---

## Thinking Process

1. `l = r = 0`.
2. While `r < n`:
   - If `nums[l] == nums[r]` → `r++` (skip duplicate).
   - Else → `nums[++l] = nums[r++]` (write next unique, advance both).
3. Return `++l` (1-based count = position of last unique + 1).

---

## Why the Approach Works

Because the array is sorted, duplicates are contiguous. `l` only advances when a new distinct value is found. The final value of `l+1` equals the count of unique elements.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Slow-fast two pointer for in-place dedup in sorted array |
| Contrast | remove-element removes a specific value; this removes all duplicates |

### Pattern Recognition Clues

- "Remove duplicates in sorted array, in-place"
- Slow pointer = write head; fast pointer = read head

Cross-ref: [Two Pointers](../Two%20Pointers/README.md)

---

## Alternative Approaches

Collect all unique values into a list then copy back — O(n) time but O(n) space.

---

## Critical Implementation Details

- `++l` (pre-increment) writes to the next slot before the assignment
- Return `++l` (pre-increment again) — converts 0-based `l` to 1-based count
- Both pointers start at 0; `r` leads

---

## Edge Cases

- `n == 1` → return 1 immediately
- All same elements → return 1
- All unique → return n

---

## Common Mistakes

- Post-increment `l++` instead of pre-increment `++l` (writes to wrong slot)
- Off-by-one: `return l` vs `return l+1` (missing the 1-based count conversion)
- Not handling `n == 1` (both pointers at 0, loop runs but `l` never advances, `++l` at return = 1 ✓)

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) |

---

## Similar Problems

- [remove-element](../remove-element/README.md) — remove specific value in-place
- [sort-colors](../sort-colors/README.md) — in-place partitioning

---

## One-line Takeaway

**Sorted array: `r` scans, `l` writes; on new value `nums[++l] = nums[r++]`; return `++l`.**

---

## Revision Checklist

- [ ] Why pre-increment `++l` not post-increment `l++`?
- [ ] Return `++l` vs `l` — why?
- [ ] What does `l` represent at end of loop?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0.java` |
