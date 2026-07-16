# Capacity to Ship Packages Within D Days

| Field | Value |
|-------|-------|
| Topic | Binary Search |
| Difficulty | Medium |
| Primary Pattern | Binary Search on Answer |
| Secondary Pattern | Greedy feasibility check |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given an array `weights` and an integer `days`, return the minimum ship capacity such that all packages can be shipped within `days` days. Packages must be shipped in order; the ship cannot exceed its capacity on any day.

---

## Constraints (typical)

- `1 ≤ weights[i] ≤ 500`, `1 ≤ n ≤ 500`, `1 ≤ days ≤ n`
- Ship loads packages sequentially — cannot reorder
- Lower bound capacity = `max(weights)` (can't skip heaviest package)
- Upper bound = `sum(weights)` (ship everything in one day)

---

## Brute Force

Try every capacity from `max(weight)` to `sum(weights)` and check feasibility → O(n · Σw). Far too slow.

---

## Core Observation

Feasibility is **monotone in capacity**: if capacity `c` works, any `c' > c` also works. So binary search over the capacity space and validate each mid with a linear greedy check.

---

## Thinking Process

1. Set `l = max(weights)`, `r = sum(weights)`.
2. While `l < r`: `m = l + (r-l)/2`.
3. `canShip(m)`: greedily pack — accumulate weights into current day; when `sum + w > m`, start a new day (`d++`, `sum = w`).
4. If `d ≤ days` → feasible, so try lower: `r = m`.
5. Else `l = m + 1`.
6. Return `l`.

---

## Why the Approach Works

The `canShip` check runs in O(n). The answer space `[max, sum]` has at most Σw values; binary search reduces this to O(log Σw) calls. Total: O(n log Σw).

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Binary Search on Answer (value space) |
| Secondary | Greedy linear feasibility check |
| Contrast | Binary search on *index* finds a position; this finds an optimal value |

### Pattern Recognition Clues

- "Minimum capacity / speed such that task completes within D days"
- Feasibility check is monotone (once true, stays true as value grows)

Cross-ref: [Binary Search](../Binary%20Search/README.md) · [PATTERNS.md](../../PATTERNS.md#binary-search-on-answer)

---

## Alternative Approaches

Linear scan from `max` to `sum` with `canShip` — correct, but O(n · Σw).

Same BS skeleton as [eating-bananas](../eating-bananas/README.md) and [split-array-largest-sum](../split-array-largest-sum/README.md).

---

## Critical Implementation Details

- `l = max(weights)`, **not 0 or 1** — capacity below the heaviest package is impossible
- On overflow: `d++; sum = w` — the new weight starts the next day; do NOT skip it
- Feasible → `r = m` (try smaller); infeasible → `l = m + 1`
- `d` starts at 1 (first day always begins)

---

## Edge Cases

- `days == n` → each package can go on its own day; answer = `max(weights)`
- `days == 1` → ship everything at once; answer = `sum(weights)`
- Single package → trivially its own weight

---

## Common Mistakes

- Setting lower bound to 1 or 0 (misses cases where max weight is large)
- Forgetting `sum = w` on overflow (the overflowing weight must still be loaded)
- Using `<=` in while → off-by-one causing infinite loop or skipping answer

---

## Complexity

| | |
|--|--|
| Time | O(n log Σw) |
| Space | O(1) |

---

## Similar Problems

- [eating-bananas](../eating-bananas/README.md) — identical BS-on-answer skeleton
- [split-array-largest-sum](../split-array-largest-sum/README.md) — same pattern, minimize max subarray sum

---

## One-line Takeaway

**Minimum feasible capacity = BS in [max(w), sum(w)] + greedy pack-by-day validator.**

---

## Revision Checklist

- [ ] Why is the lower bound `max(weights)` and not 1?
- [ ] What does `canShip` return, and in which direction does feasibility change?
- [ ] Why does `sum = w` (not `sum = 0`) when starting a new day?
- [ ] Is this `while(l < r)` or `while(l <= r)` — which and why?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0.java` |
