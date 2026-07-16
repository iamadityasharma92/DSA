# Find K Closest Elements

| Field | Value |
|-------|-------|
| Topic | Heap / Priority Queue |
| Difficulty | Medium |
| Primary Pattern | Two Pointers |
| Secondary Pattern | Binary Search |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `find-k-closest-elements`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Contiguous k elements closest to x—window start determined by comparing ends.

---

## Thinking Process

1. BS on window left bound 0..n-k
2. Compare x-nums[mid] vs nums[mid+k]-x
3. Shrink from ends with two pointers alternative
4. Return sublist

**Best understanding:** BS window start so subarray length k has x closest; or two pointers shrink range

---

## Why the Approach Works

Closest k must be contiguous in sorted array; compare outer gaps to shrink.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Two Pointers |
| Secondary | Binary Search |

### Pattern Recognition Clues

- Sorted array subarray length k
- Minimize distance to x

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Max-heap of size k—O(n log k).

---

## Critical Implementation Details

- Window length exactly k
- Tie prefer smaller on equal distance

---

## Edge Cases

- k equals n
- x outside array range

---

## Common Mistakes

- Non-contiguous picks
- Wrong tie-break

---

## Complexity

| | |
|--|--|
| Time | O(log n + k) BS window |
| Space | O(1) |

---

## Similar Problems

- [find-target-in-rotated-sorted-array](../find-target-in-rotated-sorted-array/README.md)
- [merge-two-sorted-linked-lists](../merge-two-sorted-linked-lists/README.md)

---

## One-line Takeaway

**K closest in sorted array → BS window start or two-pointer shrink.**

---

## Revision Checklist

- [ ] Contiguous k
- [ ] End distance compare

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-0 |
