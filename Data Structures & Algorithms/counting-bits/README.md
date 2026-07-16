# Counting Bits

| Field | Value |
|-------|-------|
| Topic | Bit Manipulation |
| Difficulty | Easy |
| Primary Pattern | Bit Manipulation |
| Secondary Pattern | DP (optimal upgrade) |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given an integer `n`, return an array `ans` of length `n + 1` where `ans[i]` is the number of `1` bits in `i` (its "popcount").

---

## Constraints (typical)

- `0 ≤ n ≤ 10⁵`
- Output: `ans[0..n]` inclusive

---

## Brute Force

`Integer.bitCount(i)` for each `i` — O(log i) per call → O(n log n) total. This is what `submission-0` does. Accepted but not the intended O(n) DP.

---

## Core Observation

Every number `i` shares all bits with `i >> 1` (right-shift drops the LSB) plus the LSB itself:
`popcount(i) = popcount(i >> 1) + (i & 1)`

This is a one-line DP that builds the array left to right in O(n).

---

## Thinking Process

1. `res = new int[n+1]`
2. `res[0] = 0` (base)
3. For `i = 1..n`: `res[i] = res[i >> 1] + (i & 1)`
4. Return `res`

`submission-0` uses `Integer.bitCount` per index — correct but misses the DP insight expected in interviews.

---

## Why the Approach Works

`i >> 1` is a previously computed index (`< i`), so the DP recurrence has no cycles. The LSB is either 0 (even) or 1 (odd), directly readable with `i & 1`.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Bit manipulation recurrence |
| Alternative | Brian Kernighan loop per element |
| Contrast | `Integer.bitCount` is O(log i) per call |

### Pattern Recognition Clues

- "Count 1-bits for all numbers 0..n"
- Pattern in popcount across consecutive integers

Cross-ref: [Bit Manipulation](../Bit%20Manipulation/README.md) · [PATTERNS.md](../../PATTERNS.md#bit-tricks)

---

## Alternative Approaches

**Brian Kernighan per element:** `while(n) { n &= n-1; count++; }` — O(k) per number. Still O(n log n) overall.

**DP with lowest set bit:** `res[i] = res[i & (i-1)] + 1` — same O(n), slightly different phrasing.

---

## Critical Implementation Details

- Array size is `n + 1` (indices 0 through n inclusive)
- `res[0] = 0` is the base case; loop starts at `i = 1`
- `res[i >> 1]` is always already computed when processing `i`
- `(i & 1)` extracts the LSB (0 or 1)

---

## Edge Cases

- `n = 0` → `[0]`
- `n = 1` → `[0, 1]`

---

## Common Mistakes

- Off-by-one: array size `n` instead of `n+1`
- Using `bitCount` per element (correct but weaker interview answer)
- `res[i/2]` instead of `res[i >> 1]` (same thing, but `>>` makes the bit relationship explicit)

---

## Complexity

| | |
|--|--|
| Time | O(n) with DP; O(n log n) with bitCount |
| Space | O(1) extra beyond output |

---

## Similar Problems

- [number-of-one-bits](../number-of-one-bits/README.md) — single integer popcount
- [single-number](../single-number/README.md) — XOR bit trick

---

## One-line Takeaway

**`res[i] = res[i >> 1] + (i & 1)` — inherit parent's popcount, add LSB.**

---

## Revision Checklist

- [ ] State the DP recurrence from memory
- [ ] Why is `res[i >> 1]` always available?
- [ ] What does `i & 1` compute?
- [ ] Contrast with `Integer.bitCount` approach

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0` (bitCount); note DP upgrade for interviews |
