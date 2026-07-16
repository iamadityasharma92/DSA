# Range Sum Query 2D Immutable

| Field | Value |
|-------|-------|
| Topic | Prefix Sum |
| Difficulty | Medium |
| Primary Pattern | Prefix Sum |
| Secondary Pattern | Design |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `range-sum-query-2d-immutable`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Rectangle sum from four prefix corners minus overlaps plus double count fix.

---

## Thinking Process

1. Build ps with ps[r][c]=val+left+top-diagonal
2. Query (r1,c1,r2,c2) combine ps corners
3. Subtract overlapping strips
4. Return sum

**Best understanding:** 2D prefix ps[r][c]=sum top-left rectangle; query via inclusion-exclusion

---

## Why the Approach Works

Prefix tensor reduces any axis-aligned rectangle query to O(1).

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Prefix Sum |
| Secondary | Design |

### Pattern Recognition Clues

- Many rectangle sum queries
- Immutable matrix

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Brute sum each query O(rows*cols).

---

## Critical Implementation Details

- Extra row/col of zeros padding
- Inclusion-exclusion formula

---

## Edge Cases

- Single cell query
- Full matrix query

---

## Common Mistakes

- Off-by-one on inclusive bounds
- Wrong diagonal subtract

---

## Complexity

| | |
|--|--|
| Time | O(mn) build O(1) query |
| Space | O(mn) |

---

## Similar Problems

- [subarray-sum-equals-k](../subarray-sum-equals-k/README.md)
- [search-2d-matrix](../search-2d-matrix/README.md)

---

## One-line Takeaway

**2D range sum → 2D prefix + inclusion-exclusion.**

---

## Revision Checklist

- [ ] Build ps table
- [ ] Four-corner query

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-3 |
