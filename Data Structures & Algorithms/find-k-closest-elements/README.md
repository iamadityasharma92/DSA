# Find K Closest Elements

| Field | Value |
|-------|-------|
| Topic | Binary Search |
| Difficulty | Medium |
| Primary Pattern | Binary Search on window start |
| Secondary Pattern | Fixed-size window |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given a sorted integer array `arr`, integer `k`, and integer `x`, return the `k` closest elements to `x` in the array. The result should be sorted. Tie-break: prefer the smaller element.

---

## Constraints (typical)

- `1 ≤ k ≤ arr.length ≤ 10⁴`
- Array is sorted ascending
- Result must be sorted

---

## Brute Force

Expand from the nearest index, greedily adding the closer of the two boundary candidates → O(log n + k). Valid, but binary search on window start is the canonical approach.

---

## Core Observation

The answer is always a **contiguous subarray** of length exactly `k` in the sorted `arr`. Binary search the **left boundary** of this window in `[0, arr.length - k]`.

---

## Thinking Process

1. `l = 0`, `r = arr.length - k` (search space for left index of k-window).
2. While `l < r`: `m = (l + r) / 2`.
3. Compare left distance `x - arr[m]` vs right distance `arr[m + k] - x`:
   - If `x - arr[m] > arr[m + k] - x` → window should move right: `l = m + 1`
   - Else → `r = m`
4. Return `arr[l .. l+k-1]`.

---

## Why the Approach Works

When the window starting at `m` has a left element farther from `x` than the element just outside its right edge (`arr[m+k]`), shifting the window right improves the set. This monotone comparison enables binary search.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | BS on window left boundary |
| Contrast | BS on value (find target), not position |

### Pattern Recognition Clues

- "K closest elements in sorted array"
- Output is a contiguous sorted window

Cross-ref: [Binary Search](../Binary%20Search/README.md) · [PATTERNS.md](../../PATTERNS.md#binary-search-templates)

---

## Alternative Approaches

**Two-pointer expand:** find nearest element, expand L/R choosing closer side. O(log n + k) same.

---

## Critical Implementation Details

- Search space upper bound is `arr.length - k`, not `arr.length - 1` — ensures window of size `k` always fits
- Tie-break: `>` (strictly) on left distance means equal → keep left (smaller element wins)
- After BS: collect `arr[l]` through `arr[l + k - 1]`

---

## Edge Cases

- `k = arr.length` → entire array
- `x` outside array range (smaller than min or larger than max)
- All elements equidistant from `x`

---

## Common Mistakes

- Using `>=` in comparison instead of `>` (wrong tie-breaking, returns larger element on tie)
- Wrong `r` bound: `arr.length - 1` instead of `arr.length - k` (window goes out of bounds)

---

## Complexity

| | |
|--|--|
| Time | O(log(n - k) + k) |
| Space | O(k) — output |

---

## Similar Problems

- [binary-search](../binary-search/README.md) — same half-open BS template
- [find-minimum-in-rotated-sorted-array](../find-minimum-in-rotated-sorted-array/README.md) — BS on monotone property

---

## One-line Takeaway

**BS the window's left index in [0, n-k]; shift right when left element is farther than right neighbor.**

---

## Revision Checklist

- [ ] Why `r = arr.length - k` not `arr.length - 1`?
- [ ] Which comparison direction shifts window right?
- [ ] Tie-break: `>` vs `>=` and which favors smaller element?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0.java` |
