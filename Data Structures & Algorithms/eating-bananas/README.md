# Koko Eating Bananas

| Field | Value |
|-------|-------|
| Topic | Binary Search |
| Difficulty | Medium |
| Primary Pattern | Binary Search on Answer |
| Secondary Pattern | Ceiling division |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Koko has `n` piles of bananas. She can eat at most `k` bananas per hour. Each hour she picks one pile and eats up to `k` from it (cannot eat across piles in the same hour). Return the minimum integer `k` such that she can eat all bananas within `h` hours.

---

## Constraints (typical)

- `1 ≤ piles.length ≤ 10⁴`, `piles[i] ≤ 10⁹`
- `piles.length ≤ h ≤ 10⁹` — always solvable (k = max pile at worst)

---

## Brute Force

Try `k = 1, 2, 3, …` until `canFinish(k)` — O(max_pile · n). Way too slow.

---

## Core Observation

As eating speed `k` increases, required hours decrease monotonically. So binary search on `k` in `[1, max(piles)]`.

---

## Thinking Process

1. `l = 1`, `r = max(piles)`.
2. While `l <= r`: `m = l + (r-l)/2`.
3. Compute `time = Σ ceil(pile / m)` for all piles.
4. If `time <= h` → feasible, try lower: `r = m - 1`.
5. Else too slow: `l = m + 1`.
6. Return `l` (first speed that works).

`submission-1` tracks `res = m` then returns `res`; `submission-3` returns `l` directly — cleaner.

---

## Why the Approach Works

`[1, max(piles)]` is the valid answer range — `k = max(piles)` always finishes in exactly `n` hours. Binary search on this range with a linear check gives O(n log max_pile).

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Binary Search on Answer |
| Check | Linear scan → `Σ ceil(pile/k) ≤ h` |
| Same family | capacity-to-ship, split-array-largest-sum |

### Pattern Recognition Clues

- "Minimum speed / rate such that task finishes within limit"
- Monotone feasibility: faster is always at least as feasible

Cross-ref: [Binary Search](../Binary%20Search/README.md) · [PATTERNS.md](../../PATTERNS.md#binary-search-on-answer)

---

## Alternative Approaches

Linear scan from 1 to max — correct but O(n · max_pile). Binary search cuts to O(n log max_pile).

---

## Critical Implementation Details

- `ceil(pile / m)`: use `(int) Math.ceil((double)pile / m)` or equivalently `(pile + m - 1) / m`
- Upper bound is `max(piles)`, NOT `sum(piles)` — she eats from one pile per hour
- `l <= r` (inclusive) because valid values include both endpoints

---

## Edge Cases

- `h == piles.length` → minimum `k` is `max(piles)` (one pile per hour, must finish each)
- `h` very large → `k = 1` may work
- Single pile

---

## Common Mistakes

- Integer division `pile / m` instead of ceiling — wrong for non-divisible piles
- Upper bound `sum(piles)` instead of `max(piles)` — wastes search space
- Forgetting to cast to `double` before dividing for `Math.ceil`

---

## Complexity

| | |
|--|--|
| Time | O(n log max_pile) |
| Space | O(1) |

---

## Similar Problems

- [capacity-to-ship-packages-within-d-days](../capacity-to-ship-packages-within-d-days/README.md) — identical skeleton
- [split-array-largest-sum](../split-array-largest-sum/README.md) — same BS-on-answer pattern

---

## One-line Takeaway

**Min eating speed = BS in [1, max(pile)] + validate Σ ceil(pile/k) ≤ h.**

---

## Revision Checklist

- [ ] Why upper bound `max(piles)` not `sum(piles)`?
- [ ] Ceiling division formula?
- [ ] `while(l <= r)` and return `l` — why?
- [ ] Contrast feasible→lower vs infeasible→higher direction?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-1` → `submission-3` (cleaner, returns `l`) |
