# Find Minimum in Rotated Sorted Array

| Field | Value |
|-------|-------|
| Topic | Binary Search |
| Difficulty | Medium |
| Primary Pattern | Binary Search |
| Secondary Pattern | Rotated Array |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `find-minimum-in-rotated-sorted-array`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Rotation breaks order at one pivot—smaller half contains minimum.

---

## Thinking Process

1. l=0,r=n-1
2. If nums[mid]>nums[r] l=mid+1
3. Else r=mid
4. nums[l] is minimum

**Best understanding:** BS: if nums[mid]>nums[r] min in right else min in left incl mid

---

## Why the Approach Works

Mid greater than right means min strictly right of mid.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Binary Search |
| Secondary | Rotated Array |

### Pattern Recognition Clues

- Rotated sorted unique
- Find min not target

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Find pivot index linearly.

---

## Critical Implementation Details

- Compare mid to r not l
- r=mid not mid-1

---

## Edge Cases

- No rotation sorted
- Two elements

---

## Common Mistakes

- Compare to left incorrectly
- Returning mid too early

---

## Complexity

| | |
|--|--|
| Time | O(log n) |
| Space | O(1) |

---

## Similar Problems

- [find-target-in-rotated-sorted-array](../find-target-in-rotated-sorted-array/README.md)
- [search-in-rotated-sorted-array-ii](../search-in-rotated-sorted-array-ii/README.md)

---

## One-line Takeaway

**Rotated min → BS compare nums[mid] vs nums[r].**

---

## Revision Checklist

- [ ] mid vs right
- [ ] r=mid shrink

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-1 |
