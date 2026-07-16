# Guess Number Higher or Lower

| Field | Value |
|-------|-------|
| Topic | Binary Search |
| Difficulty | Easy |
| Primary Pattern | Binary Search (API-driven monotone predicate) |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

A number `1..n` is picked. Use `guess(num)` API which returns `-1` (your guess too high), `1` (too low), or `0` (correct). Find the picked number in minimum calls.

---

## Constraints (typical)

- `1 ≤ n ≤ 2³¹ - 1`
- Exactly one correct answer
- Must be O(log n)

---

## Brute Force

`submission-0`: linear scan from 1 to n → O(n). Correct but defeats the purpose.

---

## Core Observation

`guess()` provides exactly the same information as a standard binary search comparison. Binary search on `[1, n]` with `guess(mid)` as the comparator.

---

## Thinking Process

1. `l = 1`, `r = n` (closed interval here; note: `submission-1` uses `l = 0` which also works).
2. While `l < r`: `m = l + (r-l)/2`.
3. `g = guess(m)`:
   - `g == 0` → return `m`
   - `g == 1` → too low: `l = m + 1`
   - `g == -1` → too high: `r = m` (half-open; `r = m` not `m-1` to avoid skipping the answer)
4. Return `n` as fallback (loop exits when `l == r == answer`).

---

## Why the Approach Works

`guess()` is a monotone predicate: answers transition from "too high" to "correct" to "too low" as `m` increases. Binary search exploits this.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Binary search with external comparator |
| Template | Half-open `[l, r)` with `r = m` / `l = m+1` |

### Pattern Recognition Clues

- "Minimize API calls to find a value in a range"
- Predicate is monotone (binary feedback)

Cross-ref: [Binary Search](../Binary%20Search/README.md) · [PATTERNS.md](../../PATTERNS.md#binary-search-templates)

---

## Alternative Approaches

Exponential search (double range until overshoot, then BS) — useful when `n` is unknown. Here `n` is given, so direct BS.

---

## Critical Implementation Details

- `guess(m) == -1` means `m` is too high → `r = m` (not `r = m-1`) in half-open variant to keep `m` in range
- `guess(m) == 1` means `m` is too low → `l = m + 1`
- Safe mid `l + (r-l)/2` avoids overflow for large `n` (32-bit values)

---

## Edge Cases

- `n = 1` → answer is 1 immediately
- Picked number is `n` or `1` (boundary)

---

## Common Mistakes

- Confusing `1` (too low) and `-1` (too high) — read API spec carefully
- Using `r = m - 1` when answer could be `m` (misses it)
- `(l + r) / 2` overflows when both are large `int` values

---

## Complexity

| | |
|--|--|
| Time | O(log n) |
| Space | O(1) |

---

## Similar Problems

- [binary-search](../binary-search/README.md) — same template, direct array access
- [find-peak-element](../find-peak-element/README.md) — BS by local property

---

## One-line Takeaway

**Replace the array comparison with `guess()` — standard binary search with correct direction from API return value.**

---

## Revision Checklist

- [ ] `guess == 1` means too low → move which pointer?
- [ ] `guess == -1` means too high → `r = m` not `r = m-1` (why)?
- [ ] Overflow-safe mid formula?

---

## Revision History

| Date | Note |
|------|------|
| — | `submission-0` (linear) → `submission-1` (binary search) |
