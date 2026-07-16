# Top K Elements in List

| Field | Value |
|-------|-------|
| Topic | Heap / Priority Queue |
| Difficulty | Medium |
| Primary Pattern | Min Heap |
| Secondary Pattern | Hashing |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `top-k-elements-in-list`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

K most frequent tracked by size-k min heap on frequency.

---

## Thinking Process

1. HashMap count
2. Heap push (freq,num)
3. If size>k pop smallest freq
4. Drain heap to result

**Best understanding:** Count frequencies; min-heap size k on freq; extract k most frequent

---

## Why the Approach Works

Min heap root is weakest among top k—evict when better freq arrives.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Min Heap |
| Secondary | Hashing |

### Pattern Recognition Clues

- K most frequent elements
- Frequency ranking

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Bucket sort by frequency O(n).

---

## Critical Implementation Details

- Heap compares frequency not value
- Size k not n

---

## Edge Cases

- k equals distinct count
- Ties any order often ok

---

## Common Mistakes

- Max heap wrong eviction
- Forgetting freq map

---

## Complexity

| | |
|--|--|
| Time | O(n log k) |
| Space | O(n) |

---

## Similar Problems

- [kth-largest-integer-in-a-stream](../kth-largest-integer-in-a-stream/README.md)
- [majority-element](../majority-element/README.md)

---

## One-line Takeaway

**Top k frequent → count + size-k min-heap.**

---

## Revision Checklist

- [ ] freq map
- [ ] min heap k

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-1 |
