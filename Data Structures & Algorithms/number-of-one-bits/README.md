# Number of One Bits

| Field | Value |
|-------|-------|
| Topic | Bit Manipulation |
| Difficulty | Easy |
| Primary Pattern | Bit Manipulation |
| Secondary Pattern | Math |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `number-of-one-bits`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

n&(n-1) drops lowest set bit—count equals popcount.

---

## Thinking Process

1. count=0
2. While n>0: n&=n-1 count++
3. Return count
4. Alternative loop i<32 check bit

**Best understanding:** While n: n &= n-1 clears LSB; count iterations

---

## Why the Approach Works

Each Kernighan step removes one 1-bit; iterations = popcount.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Bit Manipulation |
| Secondary | Math |

### Pattern Recognition Clues

- Hamming weight
- Unsigned 32-bit

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Shift and test each bit—fixed 32 loops.

---

## Critical Implementation Details

- Treat as unsigned for Java >>> if needed
- n&=n-1 termination

---

## Edge Cases

- n=0
- Power of two → 1

---

## Common Mistakes

- Signed shift bugs in Java
- Infinite loop on negative

---

## Complexity

| | |
|--|--|
| Time | O(k) k=set bits |
| Space | O(1) |

---

## Similar Problems

- [counting-bits](../counting-bits/README.md)
- [single-number](../single-number/README.md)

---

## One-line Takeaway

**Popcount → n &= n-1 loop or 32-bit scan.**

---

## Revision Checklist

- [ ] Kernighan trick
- [ ] Unsigned handling

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-2 |
