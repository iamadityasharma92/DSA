# Sliding Window Maximum

| Field | Value |
|-------|-------|
| Topic | Heap / Priority Queue |
| Difficulty | Hard |
| Primary Pattern | Monotonic Deque |
| Secondary Pattern | Heap |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `sliding-window-maximum`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Max in each window needs structure dropping expired/outdated candidates.

---

## Thinking Process

1. Maintain deque of useful indices
2. Pop back while smaller than new nums[i]
3. Push i; pop front if out of window
4. Record deque front value

**Best understanding:** Deque stores indices decreasing values; front is max; lazy heap variant in submission-1

---

## Why the Approach Works

Monotonic deque keeps only potential maxima in O(1) amortized per index.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Monotonic Deque |
| Secondary | Heap |

### Pattern Recognition Clues

- Max of each size-k window
- Deque or heap

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Max-heap with lazy index removal O(n log k).

---

## Critical Implementation Details

- Store indices for expiry
- Remove i-k from front

---

## Edge Cases

- k=1 returns each element
- Strictly decreasing deque

---

## Common Mistakes

- Not evicting expired index
- Storing values not indices in deque

---

## Complexity

| | |
|--|--|
| Time | O(n) deque O(n log k) heap |
| Space | O(k) |

---

## Similar Problems

- [longest-repeating-substring-with-replacement](../longest-repeating-substring-with-replacement/README.md)
- [online-stock-span](../online-stock-span/README.md)

---

## One-line Takeaway

**Window max → monotonic deque of indices or lazy heap.**

---

## Revision Checklist

- [ ] index deque
- [ ] evict out of window

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-1 |
