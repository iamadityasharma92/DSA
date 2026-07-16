# Capacity To Ship Packages Within D Days

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

Interview problem `capacity-to-ship-packages-within-d-days`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Feasible capacity is monotonic—if cap works in D days, any larger cap works.

---

## Thinking Process

1. Bounds: lo = max(weights), hi = sum(weights)
2. Mid → greedy day count packing in order
3. days ≤ D shrink search right; else raise lo
4. Return minimum feasible capacity

**Best understanding:** BS on capacity [max weight, sum]; greedy canShip packs contiguously without splitting

---

## Why the Approach Works

Greedy packing is optimal per fixed cap; monotonic feasibility enables answer binary search.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Binary Search on Answer |
| Secondary | Greedy |

### Pattern Recognition Clues

- Minimize maximum under contiguous day partitions
- Cannot reorder packages

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Linear scan capacities—O(n·range).

---

## Critical Implementation Details

- lo = max weight not 0
- New day only when current load + weight > cap
- hi = mid when feasible

---

## Edge Cases

- Single weight
- days equals array length

---

## Common Mistakes

- Splitting a package across days
- Starting lo at 0

---

## Complexity

| | |
|--|--|
| Time | O(n log S), S = sum(weights) |
| Space | O(1) |

---

## Similar Problems

- [split-array-largest-sum](../split-array-largest-sum/README.md)
- [eating-bananas](../eating-bananas/README.md)

---

## One-line Takeaway

**Contiguous partition with min max-sum → BS answer + greedy verify.**

---

## Revision Checklist

- [ ] Greedy canShip
- [ ] Monotonic BS bounds

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-0 |
