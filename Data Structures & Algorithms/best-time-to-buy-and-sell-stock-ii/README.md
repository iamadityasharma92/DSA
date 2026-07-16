# Best Time to Buy and Sell Stock II

| Field | Value |
|-------|-------|
| Topic | Greedy |
| Difficulty | Medium |
| Primary Pattern | Greedy (sum uphill slopes) |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Prices over days; unlimited transactions (no overlapping holds). Maximize profit.

---

## Brute Force

DFS over buy/sell decisions → exponential.

---

## Core Observation

Optimal profit = sum of **all positive adjacent differences**. Every uphill segment can be taken (equivalent to buying at valley bottoms and selling at peaks).

---

## Thinking Process

`profit += max(0, prices[i] - prices[i-1])` for each day.

---

## Why the Approach Works

Any multi-day rise equals the sum of its one-day rises; skipping a small uphill never helps when unlimited transactions are allowed.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Greedy accumulate gains |
| Contrast | Stock I = one transaction → min-so-far / kadane-style |

See: [Greedy](../Greedy/README.md), [PATTERNS.md](../../PATTERNS.md#greedy--adjacent-gains).

---

## Alternative Approaches

Valley-peak explicit scan — same result, more code. DP states — overkill here.

---

## Critical Implementation Details

- Do not subtract negative days
- `n == 1` → 0

---

## Edge Cases

- Strictly decreasing → 0
- Flat → 0

---

## Common Mistakes

- Applying Stock I logic (single buy/sell)
- Forcing non-adjacent sells only

---

## Complexity

Time O(n), Space O(1).

---

## Similar Problems

- [buy-and-sell-crypto](../buy-and-sell-crypto/README.md) — often Stock I
- Stock with cooldown / fee — DP extensions

---

## One-line Takeaway

**Unlimited sells → sum every positive day-to-day gain.**

---

## Revision Checklist

- [ ] Contrast with one-transaction version
- [ ] Prove adjacent-sum ≡ valley-peak

---

## Revision History

| Date | Note |
|------|------|
| — | From `submission-0.java` |
