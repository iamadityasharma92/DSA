# Sort an Array

| Field | Value |
|-------|-------|
| Topic | Arrays & Hashing |
| Difficulty | Medium |
| Primary Pattern | Merge Sort |
| Secondary Pattern | Divide and Conquer |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `sort-an-array`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Comparison sort requirement—standard divide conquer merge pattern.

---

## Thinking Process

1. mergesort(nums,l,r)
2. mid split recurse
3. merge two sorted halves
4. Return sorted array

**Best understanding:** Merge sort or quicksort O(n log n)—divide halves merge sorted

---

## Why the Approach Works

Merge sort guaranteed O(n log n) stable divide structure.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Merge Sort |
| Secondary | Divide and Conquer |

### Pattern Recognition Clues

- Sort integers O(n log n)
- Not counting sort range

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Heap sort in-place O(1) extra.

---

## Critical Implementation Details

- Temp buffer on merge
- Base l>=r return

---

## Edge Cases

- Already sorted
- Duplicates

---

## Common Mistakes

- O(n²) bubble on large n
- Merge index bugs

---

## Complexity

| | |
|--|--|
| Time | O(n log n) |
| Space | O(n) merge sort |

---

## Similar Problems

- [sort-colors](../sort-colors/README.md)
- [merge-sorted-array](../merge-sorted-array/README.md)

---

## One-line Takeaway

**General sort → merge/quick O(n log n) divide conquer.**

---

## Revision Checklist

- [ ] split recurse
- [ ] merge halves

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-0 |
