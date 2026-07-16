# Split Array Largest Sum

| Field | Value |
|-------|-------|
| Topic | Binary Search |
| Difficulty | Medium |
| Primary Pattern | Binary Search on Answer |
| Secondary Pattern | Greedy |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `split-array-largest-sum`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Minimize largest partition sum—monotonic feasibility on answer.

---

## Thinking Process

1. lo=max(nums), hi=sum
2. Mid max sum → greedy split count
3. If splits≤k feasible shrink hi
4. Return best res

**Best understanding:** BS on max subarray sum; canSplit greedily counts parts ≤ k

---

## Why the Approach Works

Same BS+greedy partition template as ship packages.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Binary Search on Answer |
| Secondary | Greedy |

### Pattern Recognition Clues

- Split into k subarrays minimize max sum
- Contiguous partitions

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

DP O(n²k)—heavier.

---

## Critical Implementation Details

- Greedy start new part when sum>m
- Track parts count

---

## Edge Cases

- k=1 whole array
- k=n each element

---

## Common Mistakes

- Allowing non-contiguous groups
- Wrong BS direction

---

## Complexity

| | |
|--|--|
| Time | O(n log S) |
| Space | O(1) |

---

## Similar Problems

- [capacity-to-ship-packages-within-d-days](../capacity-to-ship-packages-within-d-days/README.md)
- [eating-bananas](../eating-bananas/README.md)

---

## One-line Takeaway

**Min max partition sum → BS answer + greedy split count.**

---

## Revision Checklist

- [ ] canSplit greedy
- [ ] BS bounds max..sum

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-0 |
