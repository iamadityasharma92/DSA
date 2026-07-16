# Max Water Container

| Field | Value |
|-------|-------|
| Topic | Two Pointers |
| Difficulty | Medium |
| Primary Pattern | Two Pointers |
| Secondary Pattern | Greedy |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `max-water-container`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Width shrinks every step—only moving shorter line can improve area.

---

## Thinking Process

1. Two ends
2. Compute area update max
3. If h[l]<h[r] l++ else r--
4. Until l<r

**Best understanding:** l=0,r=n-1; area=min(h[l],h[r])*(r-l); move shorter side inward

---

## Why the Approach Works

Moving taller side cannot increase min height while width decreases.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Two Pointers |
| Secondary | Greedy |

### Pattern Recognition Clues

- Max area between lines
- Greedy pointer move

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Brute all pairs O(n²).

---

## Critical Implementation Details

- Move shorter height pointer
- Area uses min heights

---

## Edge Cases

- Two lines
- All equal heights

---

## Common Mistakes

- Moving taller side
- Using max not min height

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) |

---

## Similar Problems

- [trapping-rain-water](../trapping-rain-water/README.md)
- [two-integer-sum-ii](../two-integer-sum-ii/README.md)

---

## One-line Takeaway

**Container water → two pointers move shorter side.**

---

## Revision Checklist

- [ ] min height area
- [ ] shorter moves

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-3 |
