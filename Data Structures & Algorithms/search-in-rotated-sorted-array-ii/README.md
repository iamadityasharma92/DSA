# Search in Rotated Sorted Array II

| Field | Value |
|-------|-------|
| Topic | Binary Search |
| Difficulty | Medium |
| Primary Pattern | Binary Search |
| Secondary Pattern | Rotated Array |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `search-in-rotated-sorted-array-ii`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Duplicates break monotonic half identification—trim equals when ambiguous.

---

## Thinking Process

1. Standard rotated BS when strict half known
2. If l==mid==r increment l decrement r
3. Else pick sorted half test target
4. Continue BS

**Best understanding:** BS with duplicate handling: when nums[l]==nums[mid]==nums[r] shrink both ends

---

## Why the Approach Works

Cannot discard half when all three equal; linear trim is worst case O(n).

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Binary Search |
| Secondary | Rotated Array |

### Pattern Recognition Clues

- Rotated with duplicates
- Target search

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Linear scan when many duplicates.

---

## Critical Implementation Details

- l==mid==r shrink case
- Otherwise same as unique rotated

---

## Edge Cases

- All duplicates target maybe any index
- Not rotated sorted

---

## Common Mistakes

- Ignoring duplicate triple case
- Wrong half discard

---

## Complexity

| | |
|--|--|
| Time | O(log n) average O(n) worst |
| Space | O(1) |

---

## Similar Problems

- [find-target-in-rotated-sorted-array](../find-target-in-rotated-sorted-array/README.md)
- [find-minimum-in-rotated-sorted-array](../find-minimum-in-rotated-sorted-array/README.md)

---

## One-line Takeaway

**Rotated II → rotated BS + l==mid==r trim.**

---

## Revision Checklist

- [ ] duplicate shrink
- [ ] sorted half test

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-3 |
