# Find in Mountain Array

| Field | Value |
|-------|-------|
| Topic | Binary Search |
| Difficulty | Hard |
| Primary Pattern | Binary Search |
| Secondary Pattern | Two Phase Search |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `find-in-mountain-array`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Mountain = strict increase then strict decrease—two monotonic segments.

---

## Thinking Process

1. Peak BS comparing i-1 and i+1 neighbors
2. Target BS on [0,peak] ascending
3. If miss, BS on [peak+1,n) descending inverted
4. Minimize API calls

**Best understanding:** BS find peak index; BS ascending left half then descending right half

---

## Why the Approach Works

Each segment is monotonic so standard BS applies with flipped logic on descent.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Binary Search |
| Secondary | Two Phase Search |

### Pattern Recognition Clues

- Bitonic array
- Limited get() API

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Linear scan—violates call limit.

---

## Critical Implementation Details

- Descending BS reverses compare
- Peak when neither neighbor larger

---

## Edge Cases

- Target only on ascent
- Peak at ends

---

## Common Mistakes

- Same compare on both sides
- Off-by-one segment bounds

---

## Complexity

| | |
|--|--|
| Time | O(log n) API calls |
| Space | O(1) |

---

## Similar Problems

- [find-peak-element](../find-peak-element/README.md)
- [find-target-in-rotated-sorted-array](../find-target-in-rotated-sorted-array/README.md)

---

## One-line Takeaway

**Mountain array → peak BS then two directed BS passes.**

---

## Revision Checklist

- [ ] Find peak first
- [ ] Flip compare on descent

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-1 |
