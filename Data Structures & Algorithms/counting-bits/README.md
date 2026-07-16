# Counting Bits

| Field | Value |
|-------|-------|
| Topic | Bit Manipulation |
| Difficulty | Easy |
| Primary Pattern | Dynamic Programming |
| Secondary Pattern | Bit Manipulation |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `counting-bits`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Popcount of i equals popcount of i/2 plus its least significant bit.

---

## Thinking Process

1. dp[0]=0
2. For i=1..n: dp[i]=dp[i>>1]+(i&1)
3. Return dp
4. Avoid per-number loop to n log n

**Best understanding:** dp[i] = dp[i>>1] + (i&1)

---

## Why the Approach Works

Right shift removes LSB; i&1 tells if it was set.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Dynamic Programming |
| Secondary | Bit Manipulation |

### Pattern Recognition Clues

- Popcount for every 0..n
- Batch not per-number brute

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Brian Kernighan per i—slower.

---

## Critical Implementation Details

- Use i>>1 not i-1
- Inclusive 0..n

---

## Edge Cases

- n=0
- Powers of two → 1

---

## Common Mistakes

- Wrong recurrence
- Off-by-one range

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(n) |

---

## Similar Problems

- [number-of-one-bits](../number-of-one-bits/README.md)
- [single-number](../single-number/README.md)

---

## One-line Takeaway

**dp[i]=dp[i>>1]+(i&1) is the popcount DP to memorize.**

---

## Revision Checklist

- [ ] Shift recurrence
- [ ] Base dp[0]=0

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-0 |
