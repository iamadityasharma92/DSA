# Search 2D Matrix

| Field | Value |
|-------|-------|
| Topic | Binary Search |
| Difficulty | Medium |
| Primary Pattern | Binary Search |
| Secondary Pattern | Matrix |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `search-2d-matrix`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Row-major sorted matrix is one virtual sorted array for BS.

---

## Thinking Process

1. l=0,r=m*n-1
2. mid value at matrix[mid/c][mid%c]
3. Standard BS compare target
4. Return found or false

**Best understanding:** Treat as sorted 1D array index mid→(mid/cols,mid%cols)

---

## Why the Approach Works

Monotonic row ordering with row-end < next-row-start gives global order.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Binary Search |
| Secondary | Matrix |

### Pattern Recognition Clues

- Each row sorted last < next row first
- O(log mn) search

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Start top-right staircase—O(m+n).

---

## Critical Implementation Details

- Index mapping mid/cols mid%cols
- Integer division for row

---

## Edge Cases

- Single cell
- Target corners

---

## Common Mistakes

- BS on rows only
- Wrong col index

---

## Complexity

| | |
|--|--|
| Time | O(log(mn)) |
| Space | O(1) |

---

## Similar Problems

- [search-insert-position](../search-insert-position/README.md)
- [find-target-in-rotated-sorted-array](../find-target-in-rotated-sorted-array/README.md)

---

## One-line Takeaway

**Fully sorted matrix → BS on flattened index.**

---

## Revision Checklist

- [ ] mid to row col
- [ ] 1D BS

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-3 |
