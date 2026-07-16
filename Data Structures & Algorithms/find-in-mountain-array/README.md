# Find in Mountain Array

| Field | Value |
|-------|-------|
| Topic | Binary Search |
| Difficulty | Hard |
| Primary Pattern | Binary Search (peak find + two directed searches) |
| Secondary Pattern | Mountain array decomposition |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given a mountain array (strictly increasing then strictly decreasing) through a restricted API (`get(index)`, `length()`), find the **leftmost** index of a target value. Return -1 if not found. Minimize API calls.

---

## Constraints (typical)

- API calls cost — must use O(log n)
- Values are distinct in each half
- Mountain has at least 3 elements

---

## Brute Force

Linear scan: `O(n)` API calls. Too many.

---

## Core Observation

A mountain array is two monotone halves joined at a peak. Find the peak with binary search, then binary search the ascending side, then (if not found) the descending side with reversed comparisons.

---

## Thinking Process

1. **Find peak:** BS on `[0, n-1]`. At mid:
   - `nums[mid-1] > nums[mid]` → peak is left: `r = mid - 1`
   - `nums[mid+1] > nums[mid]` → peak is right: `l = mid + 1`
   - else `mid` is peak: return `mid`
2. **Search ascending** `[0, peak]`: standard BS.
3. **Search descending** `[peak+1, n-1]`: same BS but flip less/greater moves (`num < target` → `r = mid - 1`).
4. Return first hit (check ascending first for leftmost).

`submission-0` is correct. `submission-1` has a debug `println` and a wrong `r = mountainArr.length()` (off-by-one) on descending search.

---

## Why the Approach Works

Peak splits array into two sorted sequences with known monotone direction. Binary search on each with the correct comparison direction gives O(log n) API calls total.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Binary Search with direction flag |
| Step 1 | Peak finding by neighbor comparison |

### Pattern Recognition Clues

- "Sorted but has a peak/valley — two monotone halves"
- API-constrained → minimize calls

Cross-ref: [Binary Search](../Binary%20Search/README.md) · [PATTERNS.md](../../PATTERNS.md#binary-search-templates)

---

## Alternative Approaches

Linear scan — O(n) calls, too many. No better than O(log n) possible given information-theoretic lower bound.

---

## Critical Implementation Details

- Peak BS: guard `m > 0` before accessing `nums[m-1]`; guard `m < n-1` before `nums[m+1]`
- Descending BS: `num < target` → `r = mid - 1` (go left to find larger values)
- Ascending search first ensures leftmost index returned on duplicate values across halves (mountain guarantees distinct values so practically not an issue)

---

## Edge Cases

- Target equals peak value
- Target only in descending half
- Target not in array → return -1

---

## Common Mistakes

- Using the same BS logic on both halves without flipping comparisons
- `submission-1`'s bug: `mountainArr.length()` as `r` on descending search (should be `mountainArr.length() - 1`)

---

## Complexity

| | |
|--|--|
| Time | O(log n) API calls |
| Space | O(1) |

---

## Similar Problems

- [find-peak-element](../find-peak-element/README.md) — same peak-finding BS
- [find-target-in-rotated-sorted-array](../find-target-in-rotated-sorted-array/README.md) — two-half monotone BS

---

## One-line Takeaway

**Mountain = peak + two sorted halves; find peak, BS ascending, BS descending with flipped comparisons.**

---

## Revision Checklist

- [ ] Three-step: peak BS, then ascending BS, then descending BS?
- [ ] What changes in the descending binary search?
- [ ] Boundary guards for peak-neighbor access?

---

## Revision History

| Date | Note |
|------|------|
| — | `submission-0` correct; `submission-1` has debug print and off-by-one descending bound |
