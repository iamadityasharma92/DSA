# Number of 1 Bits (Hamming Weight)

| Field | Value |
|-------|-------|
| Topic | Bit Manipulation |
| Difficulty | Easy |
| Primary Pattern | Bit counting tricks |
| Secondary Pattern | Brian Kernighan's algorithm |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Return the number of `1` bits in the binary representation of an integer `n` (its "popcount" or Hamming weight).

---

## Constraints (typical)

- `n` is a 32-bit unsigned integer

---

## Brute Force

Check each of 32 bits via `n & 1` and right shift → O(32) = O(1). Always works.

---

## Core Observation

Three approaches, each O(1) for 32-bit integers:

1. **`Integer.bitCount(n)`** — built-in (`submission-2`).
2. **Brian Kernighan:** `while(n != 0) { n = n & (n-1); count++; }` — each step removes the lowest set bit.
3. **Right-shift loop:** `while(n != 0) { count += n & 1; n >>>= 1; }` — use unsigned right shift `>>>` in Java.

---

## Thinking Process

`submission-2` uses `Integer.bitCount` — correct and optimal constant time. For interviews, the Brian Kernighan explanation is expected:

- `n & (n-1)` clears the **lowest set bit** (subtracting 1 flips all bits from LSB to the first 1, then AND clears them). Repeat until 0; count = number of 1-bits.

---

## Why the Approach Works

**Brian Kernighan:** each `n & (n-1)` removes exactly one set bit. So the loop runs exactly `popcount(n)` times.

**`Integer.bitCount`:** uses a parallel-prefix popcount in constant time (hardware or software bit tricks).

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | `n & (n-1)` — remove lowest set bit |
| Related | `n & 1` + right shift — bit-by-bit scan |
| DP upgrade | counting-bits: `res[i] = res[i>>1] + (i&1)` |

### Pattern Recognition Clues

- "Count set bits in single number"
- `n & (n-1)` trick appears in balanced-binary-tree checks too

Cross-ref: [Bit Manipulation](../Bit%20Manipulation/README.md) · [PATTERNS.md](../../PATTERNS.md#bit-tricks)

---

## Alternative Approaches

All three are O(1) for 32-bit. Prefer Brian Kernighan in interviews (shows understanding of the bit trick).

---

## Critical Implementation Details

- Java: use `>>>` (unsigned right shift) not `>>` (arithmetic) when testing `n & 1` in a loop — avoids issues with sign bit for negative numbers
- `n & (n-1)` trick: works correctly for 0 (loop doesn't execute)

---

## Edge Cases

- `n = 0` → 0 bits set
- `n = -1` (all 1s in two's complement) → 32 bits set
- Power of 2 → exactly 1 bit set (verified by `n & (n-1) == 0`)

---

## Common Mistakes

- Using `>>` instead of `>>>` for signed integers when shifting right in the loop approach
- Confusing this with `counting-bits` (this is for one number; that is for all 0..n)

---

## Complexity

| | |
|--|--|
| Time | O(1) — 32 bits fixed |
| Space | O(1) |

---

## Similar Problems

- [counting-bits](../counting-bits/README.md) — popcount for all 0..n (DP)
- [single-number](../single-number/README.md) — XOR bit trick

---

## One-line Takeaway

**`n & (n-1)` removes lowest set bit; repeat and count iterations = Hamming weight.**

---

## Revision Checklist

- [ ] What does `n & (n-1)` do to `n`?
- [ ] Why `>>>` not `>>` in Java right-shift approach?
- [ ] Three approaches and their trade-offs?

---

## Revision History

| Date | Note |
|------|------|
| — | `submission-2` uses `Integer.bitCount`; interview expects Brian Kernighan |
