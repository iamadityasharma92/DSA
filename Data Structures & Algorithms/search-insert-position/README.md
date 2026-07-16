# Search Insert Position

| Field | Value |
|-------|-------|
| Topic | Binary Search |
| Difficulty | Easy |
| Primary Pattern | Binary Search |
| Secondary Pattern | Array |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `search-insert-position`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Lower bound binary search: lo ends at first index ≥ target.

---

## Thinking Process

1. l=0,r=n-1
2. Standard BS on sorted nums
3. If found return mid
4. Else return l

**Best understanding:** BS for target; return lo when not found—insert position

---

## Why the Approach Works

Invariant: answer is leftmost feasible insert index.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Binary Search |
| Secondary | Array |

### Pattern Recognition Clues

- Sorted array insert index
- Classic BS template

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Linear scan.

---

## Critical Implementation Details

- Return l not r after loop
- Avoid overflow mid

---

## Edge Cases

- Target greater than all → n
- Target less than all → 0

---

## Common Mistakes

- Returning r
- Wrong loop condition

---

## Complexity

| | |
|--|--|
| Time | O(log n) |
| Space | O(1) |

---

## Similar Problems

- [binary-search](../binary-search/README.md)
- [find-peak-element](../find-peak-element/README.md)

---

## One-line Takeaway

**Search insert → BS return lo as lower bound.**

---

## Revision Checklist

- [ ] return lo
- [ ] sorted invariant

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-0 |
