# Eating Bananas

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

Interview problem `eating-bananas`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Eating speed monotonic—faster speed finishes in fewer hours.

---

## Thinking Process

1. lo=1, hi=max pile
2. Mid speed → total hours via ceil per pile
3. hours≤h: try slower (r=mid-1)
4. Return lo as min speed

**Best understanding:** BS speed k in [1,max pile]; sum ceil(pile/k) hours ≤ h feasible

---

## Why the Approach Works

Hour count decreases as k increases—classic answer BS.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Binary Search on Answer |
| Secondary | Greedy |

### Pattern Recognition Clues

- Minimize rate to meet deadline
- Per-item ceil division cost

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Linear k from 1—too slow.

---

## Critical Implementation Details

- Ceil division per pile
- hi shrinks when feasible

---

## Edge Cases

- h equals n
- Single pile

---

## Common Mistakes

- Integer division instead of ceil
- Wrong bounds on k

---

## Complexity

| | |
|--|--|
| Time | O(n log max pile) |
| Space | O(1) |

---

## Similar Problems

- [capacity-to-ship-packages-within-d-days](../capacity-to-ship-packages-within-d-days/README.md)
- [split-array-largest-sum](../split-array-largest-sum/README.md)

---

## One-line Takeaway

**Min eating/shipping rate → BS on k with greedy hour/day count.**

---

## Revision Checklist

- [ ] Ceil pile/k
- [ ] Monotonic feasibility

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-3 |
