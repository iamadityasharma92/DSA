# Evaluate Reverse Polish Notation

| Field | Value |
|-------|-------|
| Topic | Stack |
| Difficulty | Medium |
| Primary Pattern | Stack |
| Secondary Pattern | Parsing |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `evaluate-reverse-polish-notation`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Postfix order—operands ready on stack before operator applied.

---

## Thinking Process

1. Scan tokens
2. Number → push
3. Operator → pop b,a compute push
4. Final stack top is answer

**Best understanding:** Stack numbers; on operator pop two, compute, push result

---

## Why the Approach Works

Stack holds pending operands in correct postfix evaluation order.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Stack |
| Secondary | Parsing |

### Pattern Recognition Clues

- Postfix tokens
- + - * / on integers

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Recursive evaluation from end.

---

## Critical Implementation Details

- Pop order: second pop is right operand
- Integer division trunc toward zero

---

## Edge Cases

- Single number
- Division truncates

---

## Common Mistakes

- Wrong operand order on - and /
- Not handling negative parse

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(n) |

---

## Similar Problems

- [validate-parentheses](../validate-parentheses/README.md)
- [minimum-stack](../minimum-stack/README.md)

---

## One-line Takeaway

**RPN → stack; pop order matters for non-commutative ops.**

---

## Revision Checklist

- [ ] Operand order
- [ ] Push numbers

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-1 |
