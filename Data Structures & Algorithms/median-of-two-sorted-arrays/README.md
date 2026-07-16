# Median of Two Sorted Arrays

| Field | Value |
|-------|-------|
| Topic | Binary Search |
| Difficulty | Hard |
| Primary Pattern | Binary Search — partition on smaller array |
| Secondary Pattern | Virtual boundary values |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given two sorted arrays `nums1` and `nums2`, return the **median** of the combined sorted array. Must be O(log(m+n)).

---

## Constraints (typical)

- `0 ≤ m, n ≤ 1000`, `m + n ≥ 1`
- Arrays are sorted ascending
- Must be O(log(min(m, n)))

---

## Brute Force

Merge both arrays, find median → O(m + n). Exceeds O(log) constraint.

---

## Core Observation

Binary search a **partition of the smaller array** such that the left halves of both arrays together contain exactly `(m+n+1)/2` elements, and `max(left) ≤ min(right)` globally. The median is then determined by the boundary elements.

---

## Thinking Process

1. Ensure `nums1` is the smaller array (swap if needed).
2. BS on `mid1 ∈ [0, n1]` (partition of nums1). `mid2 = (n1+n2+1)/2 - mid1` (partition of nums2).
3. Compute `l1, l2, r1, r2` — boundary values (use `INT_MIN`/`INT_MAX` at edges).
4. If `l1 <= r2 && l2 <= r1` → valid partition:
   - Even total: `(max(l1,l2) + min(r1,r2)) / 2.0`
   - Odd total: `max(l1, l2)`
5. Else if `l1 > r2` → move partition left: `r = mid1 - 1`
6. Else → move right: `l = mid1 + 1`

---

## Why the Approach Works

A valid partition divides all `m+n` elements into two equal-sized groups where every element on the left is ≤ every element on the right. Binary search on `mid1` finds this partition in O(log(n1)) steps.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | BS on partition index (not value) |
| Virtual | INT_MIN/INT_MAX as sentinels for out-of-bounds partitions |

### Pattern Recognition Clues

- "Median of two sorted arrays, O(log) required"
- Partition two arrays jointly

Cross-ref: [Binary Search](../Binary%20Search/README.md) · [PATTERNS.md](../../PATTERNS.md#binary-search-templates)

---

## Alternative Approaches

Merge + find middle — O(m+n), not O(log). Only use if O(log) not required.

---

## Critical Implementation Details

- BS on the **smaller array** to keep `mid2 ≥ 0` always
- `mid2 = (n1+n2+1)/2 - mid1` — the `+1` handles odd totals (left side gets the extra element)
- Boundary `l1 = mid1 == 0 ? INT_MIN : nums1[mid1-1]` — handles empty left partition
- Even total: average of boundary maxs+mins. Odd total: `max(l1, l2)` directly

---

## Edge Cases

- One empty array → median of the other
- Arrays of length 1 each
- Even vs odd combined lengths

---

## Common Mistakes

- Not ensuring smaller array is binary-searched (mid2 can become negative)
- Using `(n1+n2)/2` without `+1` (wrong for odd totals — left side should be larger)
- Incorrect virtual boundaries at empty partitions

---

## Complexity

| | |
|--|--|
| Time | O(log(min(m, n))) |
| Space | O(1) |

---

## Similar Problems

- [find-k-closest-elements](../find-k-closest-elements/README.md) — binary search on partition
- [binary-search](../binary-search/README.md) — simpler BS foundation

---

## One-line Takeaway

**BS on smaller array's partition index; valid when max(left halves) ≤ min(right halves).**

---

## Revision Checklist

- [ ] Which array does binary search run on, and why?
- [ ] Formula for `mid2`? Why `(n1+n2+1)/2`?
- [ ] Sentinel values for boundary elements at edges?
- [ ] Even vs odd combined length: how does median formula differ?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-5.java` |
