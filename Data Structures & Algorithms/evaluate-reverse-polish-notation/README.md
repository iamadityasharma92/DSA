# Evaluate Reverse Polish Notation

| Field | Value |
|-------|-------|
| Topic | Stack |
| Difficulty | Easy |
| Primary Pattern | Stack evaluation |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Evaluate an arithmetic expression in Reverse Polish Notation (postfix). Tokens are integers or operators `+`, `-`, `*`, `/`. Division truncates toward zero. Guaranteed valid expression.

---

## Constraints (typical)

- `1 ≤ tokens.length ≤ 10⁴`
- Operands are valid 32-bit integers
- Division by zero won't occur
- Result fits in 32-bit integer

---

## Brute Force

Parse into a tree / infix form first — unnecessary. Stack naturally models postfix.

---

## Core Observation

In postfix, each operator immediately follows its two operands. A stack makes this evaluation direct: push operands; when an operator appears, pop two, compute, push result.

---

## Thinking Process

1. Iterate tokens left to right.
2. If token is a number: `push(parseInt(token))`.
3. If token is an operator (`+`, `-`, `*`, `/`):
   - `a = pop()` (right operand)
   - `b = pop()` (left operand)
   - push `b op a`
4. After all tokens: `pop()` is the result.

---

## Why the Approach Works

Postfix is designed for stack machines — operators always have their operands ready at the stack top. The pop order (first pop = right, second = left) matches natural left-to-right expression order.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Stack — defer operands until operator arrives |
| Same family | Baseball game, validate-parentheses |

### Pattern Recognition Clues

- "Evaluate expression token by token"
- Operators consume the two most recent values

Cross-ref: [Stack](../Stack/README.md)

---

## Alternative Approaches

Recursive descent parsing from an infix string — much more complex. Postfix avoids precedence and parentheses entirely.

---

## Critical Implementation Details

- **Pop order matters for `-` and `/`:** first pop is `a` (right), second pop is `b` (left) → compute `b - a`, `b / a`
- Java integer division already truncates toward zero — no extra handling needed
- Use `.equals()` to compare strings, not `==`
- `Integer.parseInt()` to convert number tokens

---

## Edge Cases

- Single number token → return it
- Negative operands (`"-3"` is a valid number token)
- `b / a` with truncation toward zero (not floor)

---

## Common Mistakes

- Reversing operands for `-` and `/` (`a - b` instead of `b - a`)
- Using `==` to compare string operators instead of `.equals()`
- Confusing floor division with truncation-toward-zero

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(n) — stack in worst case (all operands before one big operator) |

---

## Similar Problems

- [baseball-game](../baseball-game/README.md) — stack with operation rules on score history
- [validate-parentheses](../validate-parentheses/README.md) — stack matching

---

## One-line Takeaway

**Stack RPN: push numbers, operators pop right then left and push result.**

---

## Revision Checklist

- [ ] Which pop is the right operand and which is left?
- [ ] Why does Java division already truncate toward zero?
- [ ] Why `.equals()` not `==` for string comparison?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-1.java` |
