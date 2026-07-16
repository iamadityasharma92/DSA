# Remove Node From End of Linked List

| Field | Value |
|-------|-------|
| Topic | Linked List |
| Difficulty | Easy |
| Primary Pattern | Two Pointers |
| Secondary Pattern | Linked List |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `remove-node-from-end-of-linked-list`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Gap of n+1 finds node before target to remove nth-from-end.

---

## Thinking Process

1. Dummy head
2. Advance fast n+1 steps
3. Move slow/fast until fast null
4. slow.next=slow.next.next

**Best understanding:** Fast pointer n steps ahead; move both until fast null; delete slow.next

---

## Why the Approach Works

Fixed gap positions slow at predecessor of nth-from-end.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Two Pointers |
| Secondary | Linked List |

### Pattern Recognition Clues

- Delete nth from end one pass
- Dummy handles head removal

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Stack of nodes or length count then second pass.

---

## Critical Implementation Details

- n+1 gap not n
- Dummy before head

---

## Edge Cases

- Remove head n=len
- Single node

---

## Common Mistakes

- Gap of n off-by-one
- No dummy on head delete

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) |

---

## Similar Problems

- [linked-list-cycle-detection](../linked-list-cycle-detection/README.md)
- [merge-two-sorted-linked-lists](../merge-two-sorted-linked-lists/README.md)

---

## One-line Takeaway

**Remove nth from end → dummy + n+1 gap pointers.**

---

## Revision Checklist

- [ ] n+1 advance
- [ ] dummy head

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-2 |
