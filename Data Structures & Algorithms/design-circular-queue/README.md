# Design Circular Queue

| Field | Value |
|-------|-------|
| Topic | Design |
| Difficulty | Medium |
| Primary Pattern | Queue design (linked list) |
| Secondary Pattern | Dummy head sentinel |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Implement a circular queue with a fixed capacity `k` supporting: `enQueue(val)`, `deQueue()`, `Front()`, `Rear()`, `isEmpty()`, `isFull()` — all in O(1).

---

## Constraints (typical)

- `1 ≤ k ≤ 1000`, values ≥ 0
- Operations guaranteed valid (won't dequeue empty, won't read front of empty)
- O(1) per operation

---

## Brute Force

An ArrayList with `add`/`remove(0)` — O(1) append but O(n) front removal. Not acceptable.

---

## Core Observation

Track **front (left), rear (right), and free space** explicitly. Linked list nodes give O(1) insert at tail and O(1) remove at head. A dummy head sentinel avoids special-casing the empty state.

---

## Thinking Process

1. Dummy `left` node; `right = left` (rear starts at dummy).
2. `enQueue`: if `!isFull()`, create node, append at `right.next`, update `right = newNode`, `space--`.
3. `deQueue`: if `!isEmpty()`, `left.next = left.next.next`, `space++`. If now empty, reset `right = left`.
4. `Front()`: `left.next.val`; `Rear()`: `right.val`.
5. `isEmpty()`: `left.next == null`; `isFull()`: `space == 0`.

---

## Why the Approach Works

The dummy avoids null checks on `right` when empty. Tracking `space` separately makes `isFull` O(1) without counting nodes.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Dummy head linked list with tail pointer |
| Alternative | Array ring buffer with `%k` indexing |

### Pattern Recognition Clues

- Fixed-capacity FIFO API
- O(1) front dequeue AND rear enqueue required

Cross-ref: [Design](../Design/README.md)

---

## Alternative Approaches

**Array ring buffer:** `int[k+1]` with `head`, `tail` pointers and modular arithmetic. O(1) same complexity, O(k) fixed space, no node allocation. Preferred in memory-constrained settings.

---

## Critical Implementation Details

- `isEmpty` checks `left.next == null`, not `space == k`
- After `deQueue` empties the queue: reset `right = left` so `Rear()` doesn't return stale value
- `enQueue` handles both "was empty" and "was non-empty" the same — just append at `right.next`

---

## Edge Cases

- `k = 1` — enqueue then dequeue; ensure `right` resets to `left`
- Enqueue to a full queue → return false
- Front/Rear on empty → conventionally `-1`

---

## Common Mistakes

- Forgetting to reset `right` when the queue becomes empty (Rear returns wrong value)
- Using node count check instead of `space` counter for `isFull`
- Off-by-one on capacity (accepting `k+1` items instead of `k`)

---

## Complexity

| | |
|--|--|
| Time | O(1) per operation |
| Space | O(k) |

---

## Similar Problems

- [implement-queue-using-stacks](../implement-queue-using-stacks/README.md) — different queue implementation
- [design-hashmap](../design-hashmap/README.md) — direct-array design

---

## One-line Takeaway

**Dummy head + tail pointer + space counter gives O(1) circular queue without modular arithmetic.**

---

## Revision Checklist

- [ ] What does the dummy head simplify?
- [ ] When must `right` be reset to `left`?
- [ ] `isEmpty` vs `isFull` conditions?
- [ ] Array ring buffer alternative: how does `%k` work?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0.java` |
