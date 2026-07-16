# Kth Largest Element in a Stream

| Field | Value |
|-------|-------|
| Topic | Heap / Priority Queue |
| Difficulty | Easy |
| Primary Pattern | Min-heap of size k |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Design a class `KthLargest` that finds the k-th largest element in a stream. Initialize with `k` and an initial array `nums`. `add(val)` inserts a value and returns the current k-th largest.

---

## Constraints (typical)

- `1 ≤ k ≤ nums.length + number of add calls`
- `-10⁴ ≤ val ≤ 10⁴`

---

## Brute Force

Keep a sorted list, insert in position, return `list[list.length - k]` → O(n) per insert. Too slow.

---

## Core Observation

The k-th largest = the **smallest element among the k largest**. Maintain a **min-heap of exactly k elements**: the heap always holds the k largest seen. Its minimum (root) is the k-th largest.

---

## Thinking Process

1. Constructor: `minHeap = new PriorityQueue<>(k)`.
2. Add initial `nums` to heap.
3. `add(val)`:
   - `minHeap.add(val)`.
   - While `minHeap.size() > k`: `minHeap.poll()` (remove smallest, keeping only top k).
   - Return `minHeap.peek()` (k-th largest).

`submission-0` and `submission-1` are identical.

---

## Why the Approach Works

By always maintaining exactly k elements and pruning the smallest, the heap root is the k-th largest by definition — it is the smallest of the top-k.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Min-heap of size k = top-k tracker |
| Contrast | Max-heap would give the largest, not kth |

### Pattern Recognition Clues

- "K-th largest in a stream"
- Need an efficient way to maintain a running order statistic

Cross-ref: [Heap](../Heap/README.md) · [PATTERNS.md](../../PATTERNS.md#heap--top-k)

---

## Alternative Approaches

**Sort on each `add`:** O(n log n) per call — too slow.  
**Balanced BST with order stats:** O(log n) per op but much more complex.

---

## Critical Implementation Details

- Min-heap (default `PriorityQueue` in Java) — do NOT use max-heap
- Poll while `size > k` — not if, while (in case multiple elements added or k changes)
- Constructor does NOT trim to size k — first `add()` call may do the trimming

---

## Edge Cases

- `add()` inserts a value smaller than all current k elements — heap unchanged (polled immediately)
- Multiple elements equal to the k-th largest

---

## Common Mistakes

- Using a max-heap (gives largest, not k-th largest)
- Forgetting to poll after every add (heap grows unboundedly)
- Returning `minHeap.poll()` instead of `peek()` — destroys the state

---

## Complexity

| | |
|--|--|
| Time | `add` O(log k); constructor O(n log k) |
| Space | O(k) |

---

## Similar Problems

- [top-k-elements-in-list](../top-k-elements-in-list/README.md) — static top k
- [sliding-window-maximum](../sliding-window-maximum/README.md) — max in window, heap approach

---

## One-line Takeaway

**Min-heap of size k: root = k-th largest; add value, poll smallest excess, peek.**

---

## Revision Checklist

- [ ] Why min-heap not max-heap?
- [ ] After add: poll or peek?
- [ ] Size trim: if vs while?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0` / `submission-1` (identical) |
