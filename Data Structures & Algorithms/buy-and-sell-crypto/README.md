# Buy and Sell Crypto

| Field | Value |
|-------|-------|
| Topic | Greedy / Arrays |
| Difficulty | Easy |
| Primary Pattern | One-transaction max profit |
| Secondary Pattern | Running minimum (two pointers framing) |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

NeetCode name for **Best Time to Buy and Sell Stock I**: at most one buy and one sell; maximize `sell - buy` (sell after buy).

---

## Brute Force

All pairs `i < j` → O(n²).

---

## Core Observation

For each day as sell day, best buy is the **minimum price before it**. Track min (or left pointer at min) while scanning right.

---

## Thinking Process

`l` = best buy index so far; `r` scans:

- If `prices[r] < prices[l]` → move buy to `r`
- Else update max profit with `prices[r] - prices[l]`

Equivalent: `mini` variable + one loop.

---

## Why the Approach Works

Optimal sell day has an optimal buy = min on prefix before it; one forward pass maintains that prefix min.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Running minimum |
| Contrast | Stock II = sum all uphill ([best-time-to-buy-and-sell-stock-ii](../best-time-to-buy-and-sell-stock-ii/README.md)) |

See: [Greedy](../Greedy/README.md), [PATTERNS.md](../../PATTERNS.md#greedy--adjacent-gains).

---

## Critical Implementation Details

- Sell strictly after buy (single forward scan enforces)
- Profit 0 if prices only fall

---

## Edge Cases

- Length 1; strictly decreasing; peak at end

---

## Common Mistakes

- Allowing sell before buy
- Using Stock II adjacent-sum here

---

## Complexity

O(n) time, O(1) space.

---

## Similar Problems

- [best-time-to-buy-and-sell-stock-ii](../best-time-to-buy-and-sell-stock-ii/README.md)

---

## One-line Takeaway

**One transaction → track prefix minimum while scanning for max diff.**

---

## Revision Checklist

- [ ] Stock I vs II in one sentence each
- [ ] Implement with `mini` or two indices

---

## Revision History

| Date | Note |
|------|------|
| — | From `submission-1.java` |
