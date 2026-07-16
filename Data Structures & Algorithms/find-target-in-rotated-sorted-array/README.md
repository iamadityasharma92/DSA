# Search in Rotated Sorted Array

| Field | Value |
|-------|-------|
| Topic | Binary Search |
| Difficulty | Medium |
| Primary Pattern | Binary Search — identify sorted half |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

A sorted array was rotated at an unknown pivot. Given a target, return its index or -1. No duplicates. Must be O(log n).

---

## Constraints (typical)

- All values unique
- `1 ≤ n ≤ 5000`
- Must be O(log n)

---

## Brute Force

`submission-0`: linear scan → O(n). Correct but too slow.

---

## Core Observation

In any rotated sorted array, when you pick a mid point, **at least one of the two halves is fully sorted**. Check `nums[mid] >= nums[l]` to determine which half is sorted. Then check whether target falls in that sorted range to decide which half to search.

---

## Thinking Process

1. `l = 0`, `r = n-1`.
2. While `l <= r`: `m = l + (r-l)/2`.
3. If `nums[m] == target` → return `m`.
4. If `nums[m] >= nums[l]` → **left half is sorted** `[l..m]`:
   - If `nums[l] <= target < nums[m]` → search left: `r = m - 1`
   - Else search right: `l = m + 1`
5. Else → **right half is sorted** `[m..r]`:
   - If `nums[m] < target <= nums[r]` → search right: `l = m + 1`
   - Else search left: `r = m - 1`

---

## Why the Approach Works

Rotation creates at most one "break point". At any mid, one side is contiguous and sorted. Testing if target fits in that sorted range lets you safely discard half the array each step.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | BS with sorted-half identification |
| Step | Determine sorted side, then range-check target |

### Pattern Recognition Clues

- "Rotated sorted array, find target"
- Can't use direct comparison; need extra condition

Cross-ref: [Binary Search](../Binary%20Search/README.md) · [PATTERNS.md](../../PATTERNS.md#binary-search-templates)

---

## Alternative Approaches

Find minimum (pivot) first, then determine which half to binary search. Two BS calls — slightly more code, same complexity.

---

## Critical Implementation Details

- `nums[mid] >= nums[l]` (not `>`) — handles the case where `l == mid` (single element left half)
- Both range checks are inclusive on the sorted side
- `submission-4` uses `>=` for the left-sorted test correctly

---

## Edge Cases

- Not rotated → standard BS
- `n = 1`
- Target not in array

---

## Common Mistakes

- Using `>` instead of `>=` when comparing mid to left boundary (misses single-element left half)
- Wrong inclusive/exclusive bounds when checking if target is in the sorted range

---

## Complexity

| | |
|--|--|
| Time | O(log n) |
| Space | O(1) |

---

## Similar Problems

- [search-in-rotated-sorted-array-ii](../search-in-rotated-sorted-array-ii/README.md) — with duplicates, adds `l++` escape
- [find-minimum-in-rotated-sorted-array](../find-minimum-in-rotated-sorted-array/README.md) — same sorted-half reasoning

---

## One-line Takeaway

**At any mid, one half is sorted; check if target in that half, otherwise search the other.**

---

## Revision Checklist

- [ ] Which comparison identifies the left-sorted half?
- [ ] Range check bounds for target in sorted half (inclusive/exclusive)?
- [ ] What changes in the duplicates variant?

---

## Revision History

| Date | Note |
|------|------|
| — | `submission-0` (brute) → `submission-4` (binary search, optimal) |
