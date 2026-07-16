# Guess Number Higher or Lower

| Field | Value |
|-------|-------|
| Topic | Binary Search |
| Difficulty | Easy |
| Primary Pattern | Binary Search |
| Secondary Pattern | Interactive |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `guess-number-higher-or-lower`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Monotonic answer—guess API eliminates half each time.

---

## Thinking Process

1. Initialize bounds 1..n
2. mid = lo+(hi-lo)/2
3. API -1: hi=mid-1; 1: lo=mid+1; 0: return
4. Logarithmic guesses

**Best understanding:** lo=1, hi=n; mid guess; -1 lower hi, 1 higher lo

---

## Why the Approach Works

Classic binary search on hidden sorted value.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Binary Search |
| Secondary | Interactive |

### Pattern Recognition Clues

- Higher/lower feedback
- 1..n range

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Linear guess—TLE.

---

## Critical Implementation Details

- Avoid overflow mid
- Stop on 0

---

## Edge Cases

- n=1
- Target at boundary

---

## Common Mistakes

- hi=mid instead of mid-1 on -1
- Infinite loop on lo/hi

---

## Complexity

| | |
|--|--|
| Time | O(log n) |
| Space | O(1) |

---

## Similar Problems

- [search-insert-position](../search-insert-position/README.md)
- [sqrtx](../sqrtx/README.md)

---

## One-line Takeaway

**Guess game on 1..n → vanilla binary search.**

---

## Revision Checklist

- [ ] Mid guess
- [ ] Adjust lo/hi

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-1 |
