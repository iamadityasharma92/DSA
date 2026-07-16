# Implement Stack Using Queues

| Field | Value |
|-------|-------|
| Topic | Stack |
| Difficulty | Easy |
| Primary Pattern | Queue rotation on push |
  Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Implement a LIFO stack using only queue operations (`offer`, `poll`, `peek`, `isEmpty`). Support `push(x)`, `pop()`, `top()`, `empty()`.

---

## Constraints (typical)

- `1 ≤ x ≤ 9`
- At most 100 operations
- `pop`/`top` only called when stack non-empty

---

## Brute Force

Two queues with full swap on every push — correct but O(n) per push. Single queue rotation is cleaner.

---

## Core Observation

After `offer(x)`, rotate the queue by cycling all **previous** elements to the back — moving `x` to the front. Then `poll()` always returns the most recently pushed element (LIFO).

---

## Thinking Process

1. `push(x)`:
   - `q.offer(x)`
   - Rotate: for `i = q.size() - 1` down to `1`: `q.offer(q.poll())`
   - Now `x` is at the front.
2. `pop()` → `q.poll()` (front = most recent = stack top).
3. `top()` → `q.peek()`.
4. `empty()` → `q.isEmpty()`.

---

## Why the Approach Works

After rotation, the queue front always holds the most recently pushed element. `pop` and `top` become O(1). `push` pays O(n) to maintain this invariant — trade-off vs two-queue approach.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Queue rotation: rearrange on insert |
| Contrast | Implement queue with stacks uses lazy transfer; this uses eager rotation |

### Pattern Recognition Clues

- "Implement LIFO using FIFO"
- Accept O(n) push for O(1) pop/top

Cross-ref: [Stack](../Stack/README.md)

---

## Alternative Approaches

**Two queues (transfer on pop):** push into q1; on pop, move all but last to q2, swap queues. O(n) pop, O(1) push. Symmetric trade-off.

---

## Critical Implementation Details

- Rotation loop count is `q.size() - 1` (not `q.size()`) — the just-added element `x` must NOT be rotated out
- Single queue sufficient — no second queue needed
- `top()` is `q.peek()`, not `q.poll()`

---

## Edge Cases

- Single element push then pop
- Multiple pushes then multiple pops

---

## Common Mistakes

- Rotating `q.size()` times instead of `q.size() - 1` (moves `x` to the back instead of front)
- Using two queues when one suffices

---

## Complexity

| | |
|--|--|
| Time | push O(n); pop/top O(1) |
| Space | O(n) |

---

## Similar Problems

- [implement-queue-using-stacks](../implement-queue-using-stacks/README.md) — symmetric, O(1) amortized all ops

---

## One-line Takeaway

**After each push, rotate queue so newest element is at front — O(n) push, O(1) pop/top.**

---

## Revision Checklist

- [ ] Rotation count: `size - 1` not `size`?
- [ ] After rotation, which end holds the latest push?
- [ ] Compare with lazy-transfer queue implementation?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0.java` |
