# Find Target in Rotated Sorted Array

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

Interview problem `find-target-in-rotated-sorted-array`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

One of [l,mid] or [mid,r] is always sorted in rotated array.

---

## Thinking Process

1. BS with l,r
2. If left half sorted check target in [nums[l],nums[mid]]
3. Else check right sorted half
4. Narrow to one half each step

**Best understanding:** BS: identify sorted half; check if target in range else search other half

---

## Why the Approach Works

Sorted half gives O(1) target-in-range test to discard half.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Binary Search |
| Secondary | Rotated Array |

### Pattern Recognition Clues

- Rotated sorted search
- Distinct values

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Find pivot then two BS—more code.

---

## Critical Implementation Details

- Identify sorted side first
- Inclusive range check for target

---

## Edge Cases

- Not rotated
- Target not present -1

---

## Common Mistakes

- Wrong sorted half
- Off-by-one in range test

---

## Complexity

| | |
|--|--|
| Time | O(log n) |
| Space | O(1) |

---

## Similar Problems

- [search-in-rotated-sorted-array-ii](../search-in-rotated-sorted-array-ii/README.md)
- [find-minimum-in-rotated-sorted-array](../find-minimum-in-rotated-sorted-array/README.md)

---

## One-line Takeaway

**Rotated search → find sorted half, test target in range.**

---

## Revision Checklist

- [ ] Sorted half
- [ ] Range contains target

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-4 |
