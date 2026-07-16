# Reverse String

| Field | Value |
|-------|-------|
| Topic | Two Pointers |
| Difficulty | Easy |
| Primary Pattern | Two Pointers (in-place swap) |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Reverse a character array in-place. Do not allocate extra space.

---

## Constraints (typical)

- In-place O(1) extra space
- Modify the input array directly

---

## Brute Force

Create a new array in reverse order → O(n) space. Violates in-place constraint.

---

## Core Observation

Two pointers from both ends converging to center. Swap `s[l]` and `s[r]`, advance inward.

---

## Thinking Process

1. `l = 0`, `r = s.length - 1`.
2. While `l < r`: swap `s[l]` and `s[r]`, `l++`, `r--`.

---

## Why the Approach Works

Swapping from both ends inward reverses all positions. The loop runs exactly `n/2` times; each swap handles two positions.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Two-pointer in-place swap |
| Foundation | Used in rotate-array (triple reverse), palindrome check |

### Pattern Recognition Clues

- "Reverse in-place"
- No extra allocation allowed

---

## Alternative Approaches

Stack-based reversal — O(n) space. Not appropriate here. XOR swap without temp variable — tricky if `l == r`.

---

## Critical Implementation Details

- `l < r` not `l <= r` (when `l == r` it's the middle element of an odd array — no swap needed)
- Temp variable needed for swap (Java doesn't have tuple/destructuring)

---

## Edge Cases

- Empty or single char → loop doesn't execute, correct
- Two chars → one swap

---

## Common Mistakes

- `l <= r` (swaps middle element with itself — harmless but unnecessary)
- Forgetting `r--` or `l++` (infinite loop)

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) |

---

## Similar Problems

- [rotate-array](../rotate-array/README.md) — uses three reverses of this exact operation
- [is-palindrome](../is-palindrome/README.md) — convergent two-pointer comparison

---

## One-line Takeaway

**Two pointers from ends: swap and converge; `l < r` stops at center.**

---

## Revision Checklist

- [ ] Loop condition `l < r` not `l <= r`?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0.java` |
