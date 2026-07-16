# Sqrt(x)

| Field | Value |
|-------|-------|
| Topic | Binary Search |
| Difficulty | Easy |
| Primary Pattern | Binary Search |
| Secondary Pattern | Math |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `sqrtx`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Integer sqrt is monotonic predicate on mid—classic answer BS.

---

## Thinking Process

1. l=0,r=x
2. mid*mid vs x
3. If <=x store ans l=mid+1 else r=mid-1
4. Return floor sqrt

**Best understanding:** BS on answer 0..x; largest mid with mid*mid<=x

---

## Why the Approach Works

Sqrt function monotonic enables binary search for floor value.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Binary Search |
| Secondary | Math |

### Pattern Recognition Clues

- Integer square root
- No floating sqrt

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Newton iteration.

---

## Critical Implementation Details

- Use long for mid*mid overflow
- Floor not ceil

---

## Edge Cases

- x=0
- Perfect squares

---

## Common Mistakes

- mid*mid int overflow
- Returning hi not ans

---

## Complexity

| | |
|--|--|
| Time | O(log x) |
| Space | O(1) |

---

## Similar Problems

- [guess-number-higher-or-lower](../guess-number-higher-or-lower/README.md)
- [search-insert-position](../search-insert-position/README.md)

---

## One-line Takeaway

**Integer sqrt → BS on mid with mid*mid<=x.**

---

## Revision Checklist

- [ ] overflow safe multiply
- [ ] floor answer

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-2 |
