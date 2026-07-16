# Implement Stack using Queues

| Field | Value |
|-------|-------|
| Topic | Stack |
| Difficulty | Easy |
| Primary Pattern | Queue |
| Secondary Pattern | Design |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `implement-stack-using-queues`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Rotate after enqueue makes newest element at dequeue front = stack top.

---

## Thinking Process

1. push: enqueue then dequeue n-1 times
2. pop/peek: front of queue
3. Maintains LIFO order
4. O(n) push single queue

**Best understanding:** One queue: push then rotate size-1 moves new top to front

---

## Why the Approach Works

Rotation simulates stack top at queue head.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Queue |
| Secondary | Design |

### Pattern Recognition Clues

- LIFO using queue ops
- Single or double queue variants

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Two queues—move all but last on push.

---

## Critical Implementation Details

- Rotate size-1 after each push
- pop uses dequeue

---

## Edge Cases

- First push
- pop until empty

---

## Common Mistakes

- Wrong rotation count
- Using wrong end as top

---

## Complexity

| | |
|--|--|
| Time | O(n) push O(1) pop |
| Space | O(n) |

---

## Similar Problems

- [implement-queue-using-stacks](../implement-queue-using-stacks/README.md)
- [minimum-stack](../minimum-stack/README.md)

---

## One-line Takeaway

**Stack with one queue → enqueue + rotate n-1.**

---

## Revision Checklist

- [ ] Rotate after push
- [ ] pop from front

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-0 |
