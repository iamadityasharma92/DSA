# Reverse a Linked List

| Field | Value |
|-------|-------|
| Topic | Linked List |
| Difficulty | Easy |
| Primary Pattern | Linked List |
| Secondary Pattern | Iteration |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `reverse-a-linked-list`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Flip next pointers one node at a time preserving rest of list.

---

## Thinking Process

1. prev=null, curr=head
2. Save next, curr.next=prev
3. prev=curr, curr=next
4. Return prev as new head

**Best understanding:** Iterative prev=null; curr.next=prev; advance prev and curr

---

## Why the Approach Works

Local reversal builds global reverse in one pass.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Linked List |
| Secondary | Iteration |

### Pattern Recognition Clues

- Reverse singly linked list
- Iterative O(1) space

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Recursive reverse—O(n) stack.

---

## Critical Implementation Details

- Store next before overwrite
- Return prev at end

---

## Edge Cases

- Empty null
- Single node

---

## Common Mistakes

- Losing rest of list
- Returning curr not prev

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) |

---

## Similar Problems

- [reverse-linked-list-ii](../reverse-linked-list-ii/README.md)
- [reorder-linked-list](../reorder-linked-list/README.md)

---

## One-line Takeaway

**Reverse list → three-pointer iterative flip.**

---

## Revision Checklist

- [ ] save next
- [ ] prev curr advance

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-0 |
