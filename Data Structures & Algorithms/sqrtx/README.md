# Sqrt(x)

| Field | Value |
|-------|-------|
| Topic | Binary Search |
| Difficulty | Easy |
| Primary Pattern | Binary Search on answer (integer square root) |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given a non-negative integer `x`, return the integer square root (floor of the actual sqrt). Do not use built-in `sqrt`.

---

## Constraints (typical)

- `0 ≤ x ≤ 2³¹ - 1`
- Return floor of `sqrt(x)` — largest integer `r` where `r² ≤ x`

---

## Brute Force

Linear scan from 1 upward until `i² > x` → O(√x). Too slow for large `x`.

---

## Core Observation

Binary search for the largest `m` where `m² ≤ x`. Search space `[0, x]` with early exit on exact square.

---

## Thinking Process

1. Handle `x = 0` and `x = 1` (return same).
2. `l = 0`, `r = x` (`long` to prevent overflow when `r = 2³¹ - 1`).
3. While `l < r`: `m = l + (r-l)/2`.
4. `sqr = m * m`.
5. `sqr == x` → return `m`.
6. `sqr > x` → `r = m` (try smaller).
7. `sqr < x` → `l = m + 1`.
8. Return `l - 1` (`l` is the first integer where `l² > x`; `l-1` is the floor sqrt).

---

## Why the Approach Works

The feasibility of `m² ≤ x` is monotone — true for `m = 0..⌊√x⌋`, false beyond. Binary search finds the boundary. At exit, `l` is the first position where `l² > x`, so floor sqrt = `l - 1`.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | BS on integer value (find largest `m` with `m² ≤ x`) |
| Template | Half-open `[l, r)` with `r = m` on overshoot |

### Pattern Recognition Clues

- "Integer sqrt without built-in"
- Find largest value satisfying a quadratic monotone condition

Cross-ref: [Binary Search](../Binary%20Search/README.md) · [PATTERNS.md](../../PATTERNS.md#binary-search-on-answer)

---

## Alternative Approaches

Newton's method: `x_new = (x + n/x) / 2` — converges quadratically. O(log log x) iterations. More complex but faster.

---

## Critical Implementation Details

- Use `long` for `l`, `r`, `m`, and `m*m` — `x` can be `2³¹-1`; `m*m` can overflow `int`
- Return `l - 1` not `l` when using this template (halfopen, `l` overshoots by 1)
- Base cases `x = 0` → 0, `x = 1` → 1 (submission handles explicitly)

---

## Edge Cases

- `x = 0` → 0
- `x = 1` → 1
- Perfect square (e.g., `x = 4`) → caught by `sqr == x` early return
- `x = INT_MAX` → `r` must be `long`

---

## Common Mistakes

- Using `int` for `m * m` → overflow for large `x`
- Returning `l` instead of `l - 1` (when not using early-return for perfect squares)
- `r = x` in int → overflow before the long cast

---

## Complexity

| | |
|--|--|
| Time | O(log x) |
| Space | O(1) |

---

## Similar Problems

- [search-insert-position](../search-insert-position/README.md) — same lower-bound BS pattern
- [guess-number-higher-or-lower](../guess-number-higher-or-lower/README.md) — same BS template with external oracle

---

## One-line Takeaway

**BS `[0, x]` with `long`; `r = m` on overshoot; return `l - 1` (first where `l² > x`).**

---

## Revision Checklist

- [ ] Why `long` for bounds and product?
- [ ] Return `l - 1` not `l`?
- [ ] What does the exit condition `l == r` mean here?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-2.java` |
