# Implement Queue using Stacks

| Field | Value |
|-------|-------|
| Topic | Stack |
| Difficulty | Easy |
| Primary Pattern | Stack |
| Secondary Pattern | Design |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `implement-queue-using-stacks`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Reversing twice restores FIFO—amortized O(1) pop.

---

## Thinking Process

1. push → in stack
2. pop: if out empty transfer all in→out
3. pop/peek from out
4. Amortized cheap

**Best understanding:** Two stacks: push to in; pop/peek pour in→out when out empty

---

## Why the Approach Works

Pouring reverses order so oldest element surfaces on out stack.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Stack |
| Secondary | Design |

### Pattern Recognition Clues

- FIFO with LIFO primitives
- Amortized analysis question

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Costly pop every time—always pour.

---

## Critical Implementation Details

- Pour only when out empty
- Peek same as pop source

---

## Edge Cases

- Pop from empty after push only
- Many pushes then pops

---

## Common Mistakes

- Pouring every pop
- Wrong stack for push

---

## Complexity

| | |
|--|--|
| Time | O(1) amortized push/pop |
| Space | O(n) |

---

## Similar Problems

- [implement-stack-using-queues](../implement-stack-using-queues/README.md)
- [design-circular-queue](../design-circular-queue/README.md)

---

## One-line Takeaway

**Queue via two stacks—lazy pour in→out.**

---

## Revision Checklist

- [ ] Pour when out empty
- [ ] Push to in

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-0 |
