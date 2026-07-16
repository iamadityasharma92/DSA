# Minimum Stack

| Field | Value |
|-------|-------|
| Topic | Stack |
| Difficulty | Medium |
| Primary Pattern | Auxiliary min-stack |
| Secondary Pattern | Lazy sync (push only new minimums) |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Design a stack supporting `push`, `pop`, `top`, and `getMin` — all in O(1) time. `getMin` returns the minimum element in the current stack.

---

## Constraints (typical)

- At most `3 × 10⁴` operations
- Stack non-empty when `pop`, `top`, `getMin` called

---

## Brute Force

Scan all elements on each `getMin` → O(n). Too slow.

---

## Core Observation

Maintain a **parallel min-stack** that always has the current minimum at its top. Only push to minStack when the new value is ≤ the current minimum. Pop from minStack only when the popped main value equals the current min.

---

## Thinking Process

1. `push(val)`: push `val` onto `s`. If `minStack.isEmpty() || val <= minStack.peek()` → push to `minStack`.
2. `pop()`: pop from `s`. If popped value `== minStack.peek()` → pop from `minStack`.
3. `top()` → `s.peek()`.
4. `getMin()` → `minStack.peek()`.

---

## Why the Approach Works

The min-stack only tracks values that are minimums at some point. When the current minimum is removed from the main stack, it's removed from the min-stack too, revealing the previous minimum. `getMin` is always O(1).

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Auxiliary monotonic stack (non-decreasing from bottom) |
| Contrast | Another variant: push `{val, currentMin}` pairs on the main stack |

### Pattern Recognition Clues

- "Stack with O(1) minimum"
- Monotone auxiliary tracking

Cross-ref: [Stack](../Stack/README.md)

---

## Alternative Approaches

**Pair stack:** push `int[]{val, currentMin}` on the main stack. O(n) space same, but no separate minStack — simpler code.

---

## Critical Implementation Details

- Push to minStack when `val <= minStack.peek()` (not just `<`) — handles equal minimums (multiple copies of the same min value)
- Pop from minStack only when popped value `== minStack.peek()` — not every pop
- Both stacks must remain in sync: after `pop`, check before removing from minStack

---

## Edge Cases

- Push same value twice → both pushes recorded in minStack
- Pop one of the duplicate minimums → minStack still has the other copy
- Pop all elements → both stacks empty

---

## Common Mistakes

- Using `<` instead of `<=` for minStack push (loses track of duplicate minimums)
- Popping from minStack on every `pop` (removes minimum too aggressively)
- Not checking `minStack.isEmpty()` before comparing in `push`

---

## Complexity

| | |
|--|--|
| Time | O(1) per operation |
| Space | O(n) — both stacks |

---

## Similar Problems

- [online-stock-span](../online-stock-span/README.md) — monotonic stack tracking spans

---

## One-line Takeaway

**Parallel min-stack: push when ≤ current min; pop when value == current min.**

---

## Revision Checklist

- [ ] Why `<=` not `<` when pushing to minStack?
- [ ] When is minStack popped (not every main pop)?
- [ ] Alternative: pair-stack approach?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-2.java` |
