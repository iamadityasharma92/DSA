# Single Number

| Field | Value |
|-------|-------|
| Topic | Bit Manipulation |
| Difficulty | Easy |
| Primary Pattern | Bit Manipulation |
| Secondary Pattern | XOR |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `single-number`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

a^a=0 and a^0=a—XOR accumulates unpaired element.

---

## Thinking Process

1. res=0
2. For each num res^=num
3. Return res
4. Works with pairs

**Best understanding:** XOR all nums; pairs cancel to 0 leaving singleton

---

## Why the Approach Works

Commutative XOR eliminates duplicates leaving unique.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Bit Manipulation |
| Secondary | XOR |

### Pattern Recognition Clues

- Every element twice except one
- O(1) space

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

HashSet add/remove.

---

## Critical Implementation Details

- Initialize res=0
- XOR not sum

---

## Edge Cases

- Single element array
- Negative numbers work

---

## Common Mistakes

- Using sum overflow
- Hash when XOR asked

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) |

---

## Similar Problems

- [number-of-one-bits](../number-of-one-bits/README.md)
- [counting-bits](../counting-bits/README.md)

---

## One-line Takeaway

**Single among pairs → XOR all.**

---

## Revision Checklist

- [ ] res^=num
- [ ] zero init

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-0 |
