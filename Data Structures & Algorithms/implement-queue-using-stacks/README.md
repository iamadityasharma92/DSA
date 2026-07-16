# Implement Queue Using Stacks

| Field | Value |
|-------|-------|
| Topic | Stack |
| Difficulty | Easy |
| Primary Pattern | Two-stack lazy transfer |
| Secondary Pattern | Amortized O(1) |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Implement a FIFO queue using only stack operations (`push`, `pop`, `peek`, `empty`). Support `push(x)`, `pop()`, `peek()`, `empty()`.

---

## Constraints (typical)

- `1 ≤ x ≤ 9`
- At most 100 operations
- `pop`/`peek` called only when queue not empty

---

## Brute Force

On every `push`, rotate a single stack fully → O(n) per push. Correct but expensive.

---

## Core Observation

Use two stacks: `s1` is the push stack (newest at top), `s2` is the pop stack (oldest at top). Only pour `s1 → s2` **lazily** when `s2` is empty and a pop/peek is needed. Each element moves at most twice → amortized O(1) per operation.

---

## Thinking Process

1. `push(x)` → `s1.push(x)` always.
2. `pop()`/`peek()`:
   - If `s2.isEmpty()`: pour all of `s1` into `s2` (reversing order).
   - Pop/peek from `s2`.
3. `empty()` → `s1.isEmpty() && s2.isEmpty()`.

---

## Why the Approach Works

Pouring `s1 → s2` reverses insertion order, converting LIFO back to FIFO. Doing it lazily means elements only get transferred once — so total work across all operations is O(n) → amortized O(1) per op.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Lazy two-stack reversal |
| Contrast | Eager transfer: correct but O(n) per push |

### Pattern Recognition Clues

- "Implement FIFO using LIFO"
- Amortized O(1) key phrase

Cross-ref: [Stack](../Stack/README.md)

---

## Alternative Approaches

**Eager transfer:** on each `push`, move all of `s2 → s1`, push new element, move all back. O(n) per push, O(1) pop. Valid but slow.

---

## Critical Implementation Details

- Only transfer `s1 → s2` when `s2` is empty (lazy, not eager)
- Never push into `s2` directly during `push()` — `s2` is pop-only
- `empty()` must check **both** stacks

---

## Edge Cases

- `peek()` after multiple pushes without any pop
- `empty()` when only one stack has elements

---

## Common Mistakes

- Transferring `s1 → s2` on every `pop/peek` even when `s2` has elements (unnecessary work)
- Pushing new elements into `s2` which breaks FIFO order
- `empty()` only checking `s1`

---

## Complexity

| | |
|--|--|
| Time | push O(1); pop/peek amortized O(1) |
| Space | O(n) |

---

## Similar Problems

- [implement-stack-using-queues](../implement-stack-using-queues/README.md) — symmetric problem

---

## One-line Takeaway

**Push always into s1; pour s1 → s2 only when s2 empty; amortized O(1) per op.**

---

## Revision Checklist

- [ ] Why lazy (not eager) transfer?
- [ ] Which operations force a transfer?
- [ ] `empty()` checks both stacks?
- [ ] Amortized O(1) argument: each element moved ≤ twice?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0.java` |
