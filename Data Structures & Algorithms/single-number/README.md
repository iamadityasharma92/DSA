# Single Number

| Field | Value |
|-------|-------|
| Topic | Bit Manipulation |
| Difficulty | Easy |
| Primary Pattern | XOR identity |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given an array where every element appears exactly twice except for one element which appears once, find that single element. Must be O(n) time and O(1) space.

---

## Constraints (typical)

- `1 ≤ n ≤ 3 × 10⁴`, `n` is odd
- Every element except one appears exactly twice

---

## Brute Force

HashMap frequency count → O(n) time, O(n) space. Violates O(1) space.

---

## Core Observation

XOR properties: `a ^ a = 0`, `a ^ 0 = a`, XOR is commutative and associative. XOR all elements: pairs cancel to 0, the single element remains.

---

## Thinking Process

1. `ans = 0`.
2. For each `n` in `nums`: `ans ^= n`.
3. Return `ans`.

---

## Why the Approach Works

`(a ^ a ^ b) = (0 ^ b) = b`. Any pair XORs to 0. All pairs cancel, leaving the single element. Order doesn't matter (XOR is commutative).

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | XOR self-cancellation |
| Extensions | Single-number-II (each element appears 3 times, need bit counting per position) |

### Pattern Recognition Clues

- "All appear twice except one, O(1) space"
- XOR is always the answer for this pattern

Cross-ref: [Bit Manipulation](../Bit%20Manipulation/README.md) · [PATTERNS.md](../../PATTERNS.md#bit-tricks)

---

## Alternative Approaches

Sort and find the un-paired element — O(n log n). HashMap — O(n) space.

---

## Critical Implementation Details

- Initialize `ans = 0` (XOR identity)
- Works because XOR is commutative and associative — order of elements doesn't matter
- Single line: `int ans = 0; for(int n : nums) ans ^= n; return ans;`

---

## Edge Cases

- Single element in array → returned as-is (no pairs to cancel)
- Large values — XOR works on all int values

---

## Common Mistakes

- Using HashMap (violates O(1) space)
- Not initializing to 0 (any non-zero start shifts the result)

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) |

---

## Similar Problems

- [number-of-one-bits](../number-of-one-bits/README.md) — bit counting
- [counting-bits](../counting-bits/README.md) — XOR/bit tricks

---

## One-line Takeaway

**XOR all elements: pairs cancel (a^a=0), single element survives (x^0=x).**

---

## Revision Checklist

- [ ] XOR property: `a ^ a = ?` and `a ^ 0 = ?`
- [ ] Why order doesn't matter?
- [ ] Upgrade: each appears 3 times → how?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0.java` |
