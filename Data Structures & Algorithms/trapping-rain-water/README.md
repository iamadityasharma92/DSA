# Trapping Rain Water

| Field | Value |
|-------|-------|
| Topic | Two Pointers |
| Difficulty | Hard |
| Primary Pattern | Two Pointers |
| Secondary Pattern | Greedy |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `trapping-rain-water`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Water at index limited by min of max left and max right; two pointers track bounds.

---

## Thinking Process

1. l=0,r=n-1,lm,rm
2. If lm<rm process left else right
3. Update max and add max-height at moved side
4. Sum trapped

**Best understanding:** l,r with lm,rm max heights; process shorter side adding trapped water

---

## Why the Approach Works

Shorter boundary determines safe fill level on that side without knowing other max fully.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Two Pointers |
| Secondary | Greedy |

### Pattern Recognition Clues

- Elevation map rainwater
- O(1) space two pointers

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Prefix max arrays O(n) space or monotonic stack.

---

## Critical Implementation Details

- Move shorter max side
- Add lm-height[l] not height alone

---

## Edge Cases

- Flat array zero
- Monotonic hill zero

---

## Common Mistakes

- Processing wrong side
- Using current height not max boundary

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) |

---

## Similar Problems

- [max-water-container](../max-water-container/README.md)
- [daily-temperatures](../daily-temperatures/README.md)

---

## One-line Takeaway

**Trap rain → two pointers from ends move shorter max side.**

---

## Revision Checklist

- [ ] lm rm tracking
- [ ] add max-side delta

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-3 |
