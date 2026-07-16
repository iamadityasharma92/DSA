# Linked List Cycle Detection

| Field | Value |
|-------|-------|
| Topic | Linked List |
| Difficulty | Easy |
| Primary Pattern | Floyd Cycle Detection |
| Secondary Pattern | Two Pointers |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `linked-list-cycle-detection`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Fast gains 1 step per iteration—inside cycle they must collide.

---

## Thinking Process

1. slow=fast=head
2. While fast and fast.next advance slow 1 fast 2
3. Meet → true
4. Fast hits null → false

**Best understanding:** Slow+fast pointers; if they meet cycle exists

---

## Why the Approach Works

Relative speed 2:1 guarantees meeting inside cycle if present.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Floyd Cycle Detection |
| Secondary | Two Pointers |

### Pattern Recognition Clues

- Detect cycle boolean
- O(1) space

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

HashSet of visited nodes—O(n) space.

---

## Critical Implementation Details

- Check fast and fast.next before advance
- Same meeting logic as duplicate number

---

## Edge Cases

- No cycle
- Cycle not at head

---

## Common Mistakes

- Only moving fast one step
- Null pointer on fast.next

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) |

---

## Similar Problems

- [find-duplicate-integer](../find-duplicate-integer/README.md)
- [remove-node-from-end-of-linked-list](../remove-node-from-end-of-linked-list/README.md)

---

## One-line Takeaway

**Cycle detect → Floyd slow/fast until meet or null.**

---

## Revision Checklist

- [ ] Fast moves 2
- [ ] Null guard

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-2 |
