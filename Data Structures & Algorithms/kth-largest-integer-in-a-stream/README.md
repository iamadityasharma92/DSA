# Kth Largest Integer in a Stream

| Field | Value |
|-------|-------|
| Topic | Heap / Priority Queue |
| Difficulty | Medium |
| Primary Pattern | Min Heap |
| Secondary Pattern | Design |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `kth-largest-integer-in-a-stream`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Maintain k largest seen—smallest of them at min-heap root.

---

## Thinking Process

1. Heap capacity k
2. add: push val
3. While size>k poll min
4. Return peek

**Best understanding:** Min-heap size k; if size>k pop smallest; top is kth largest

---

## Why the Approach Works

Min-heap of size k discards smaller elements keeping k largest.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Min Heap |
| Secondary | Design |

### Pattern Recognition Clues

- Streaming kth largest
- Dynamic adds

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Sorted list insertion—slower.

---

## Critical Implementation Details

- Min heap not max
- Poll when size exceeds k

---

## Edge Cases

- Fewer than k elements—return min of heap
- Duplicates allowed

---

## Common Mistakes

- Max heap wrong size
- Not polling excess

---

## Complexity

| | |
|--|--|
| Time | O(log k) per add |
| Space | O(k) |

---

## Similar Problems

- [top-k-elements-in-list](../top-k-elements-in-list/README.md)
- [sliding-window-maximum](../sliding-window-maximum/README.md)

---

## One-line Takeaway

**Kth largest stream → size-k min-heap, root is answer.**

---

## Revision Checklist

- [ ] Min heap size k
- [ ] Poll overflow

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-1 |
