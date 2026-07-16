# Find Peak Element

| Field | Value |
|-------|-------|
| Topic | Binary Search |
| Difficulty | Medium |
| Primary Pattern | Binary Search (move toward larger neighbor) |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Find **any** peak element in an array (a peak is strictly greater than its neighbors). Elements outside the array are considered `-∞`. Must run in O(log n).

---

## Constraints (typical)

- `nums[-1] = nums[n] = -∞` conceptually
- Multiple peaks may exist; return any
- Must be O(log n)

---

## Brute Force

`submission-0`: linear scan checking both neighbors → O(n). Correct but doesn't meet O(log n).

---

## Core Observation

From any element, if the right neighbor is larger, move right — there must be a peak to the right (since the boundary is `-∞`). If the left neighbor is larger, move left. If neither, current element is a peak. This is a gradient ascent that binary search can exploit.

---

## Thinking Process

1. `l = 0`, `r = n` (half-open).
2. While `l <= r`: `m = l + (r-l)/2`.
3. If `m > 0 && nums[m-1] > nums[m]` → peak is left: `r = m - 1`.
4. Else if `m < n-1 && nums[m] < nums[m+1]` → peak is right: `l = m + 1`.
5. Else → `nums[m]` is a peak: return `m`.

---

## Why the Approach Works

The guaranteed boundary condition (`-∞` at edges) means: if `nums[m] < nums[m+1]`, there must be a peak somewhere to the right of `m` (values can't increase forever with a `-∞` boundary). Binary search exploits this monotone guarantee.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Binary Search by gradient: move toward larger neighbor |
| Contrast | Classic BS has a target; this follows local gradient |

### Pattern Recognition Clues

- "Find a peak (any), O(log n)"
- Boundary values are `-∞`

Cross-ref: [Binary Search](../Binary%20Search/README.md) · [PATTERNS.md](../../PATTERNS.md#binary-search-templates)

---

## Alternative Approaches

Linear scan — O(n), fails the time constraint. Binary search on gradient is the required approach.

---

## Critical Implementation Details

- Guard `m > 0` before accessing `nums[m-1]`; guard `m < n-1` before `nums[m+1]`
- Check left neighbor first — if ascending from the left, moving right is safe
- `submission-3` half-open style with `r = n` needs care: `while(l <= r)` with `r = m-1` covers all cases

---

## Edge Cases

- Single element (always a peak)
- Strictly increasing array (peak is last element)
- Strictly decreasing array (peak is first element)

---

## Common Mistakes

- Accessing `nums[m-1]` without checking `m > 0` (ArrayIndexOutOfBoundsException)
- Using `>=` in neighbor comparisons (equal neighbors are not strictly greater)

---

## Complexity

| | |
|--|--|
| Time | O(log n) |
| Space | O(1) |

---

## Similar Problems

- [find-in-mountain-array](../find-in-mountain-array/README.md) — uses peak finding as step 1
- [find-minimum-in-rotated-sorted-array](../find-minimum-in-rotated-sorted-array/README.md) — also reasons about which half to search

---

## One-line Takeaway

**Move toward the larger neighbor — peaks exist at both ends, so you always converge.**

---

## Revision Checklist

- [ ] Why are boundary conditions `-∞` useful here?
- [ ] Guard conditions before neighbor access?
- [ ] When can you immediately return `m` as a peak?

---

## Revision History

| Date | Note |
|------|------|
| — | `submission-0` (linear) → `submission-3` (binary search, optimal) |
