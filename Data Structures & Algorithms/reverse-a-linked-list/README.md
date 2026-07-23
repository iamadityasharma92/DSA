# Reverse a Linked List

| Field | Value                      |
|-------|----------------------------|
| Topic | Linked List                |
| Difficulty | Easy                       |
| Primary Pattern | Iterative pointer reversal |
| Secondary Pattern | —                          |
| Confidence | HIGH                       |
| Last Revision | 22/06/2026                 |

---

## Problem Summary

Reverse a singly linked list and return the new head.

---

## Constraints (typical)

- `0 ≤ n ≤ 5000`
- Return the new head (old tail becomes new head)

---

## Brute Force

Collect all values into an array, rebuild in reverse → O(n) time but O(n) space.

---

## Core Observation

Three-pointer iterative reversal: maintain `prev`, `current`, `tmp`. At each step, redirect `current.next` to `prev`, advance both. When `current == null`, `prev` is the new head.

---

## Thinking Process

1. `prev = new ListNode(-100)` (dummy), `t = head`.

   Actually `submission-0` initializes `prev` to a dummy node — this is unusual. The standard approach initializes `prev = null`.
   
   Standard clean version:
   - `prev = null`, `curr = head`
   - While `curr != null`: `tmp = curr.next; curr.next = prev; prev = curr; curr = tmp`
   - Return `prev`

2. `submission-0` then sets `head.next = null` to cut the dummy — same result, just less clean.

---

## Why the Approach Works

Each node's `next` pointer is redirected to `prev`. Moving forward: the old `next` is saved in `tmp` before redirection. After all nodes are processed, `prev` = last node = new head.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Three-pointer reversal (prev, curr, tmp) |
| Alternative | Recursive reversal — elegant, O(n) stack |
| Use case | Foundation for reverse-linked-list-ii and reorder-linked-list |

### Pattern Recognition Clues

- "Reverse a linked list"
- Any linked list restructuring often starts with reversing a portion

Cross-ref: [Linked List](../Linked%20List/README.md)

---

## Alternative Approaches

**Recursive:** `reverseList(head.next).next = head` — elegant but O(n) stack. Risk of stack overflow for large lists.

---

## Critical Implementation Details

- Must save `curr.next` into `tmp` before overwriting `curr.next`
- After the loop `prev` is the new head; `curr` is null
- Return `prev` not `curr`
- `submission-0`'s dummy `prev` causes `head.next = null` cleanup — prefer `prev = null` instead

---

## Edge Cases

- Empty list → return `null`
- Single node → return as-is
- Two nodes → straightforward swap of pointers

---

## Common Mistakes

- Not saving `tmp = curr.next` before the redirection (infinite loop or data loss)
- Returning `curr` (null) instead of `prev` (new head)
- Not handling null head

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) iterative; O(n) recursive |

---

## Similar Problems

- [reverse-linked-list-ii](../reverse-linked-list-ii/README.md) — reverse a subrange `[l, r]`
- [reorder-linked-list](../reorder-linked-list/README.md) — uses partial reversal

---

## One-line Takeaway

**prev=null, curr=head; tmp=curr.next; curr.next=prev; prev=curr; curr=tmp; return prev.**

---

## Revision Checklist

- [ ] Three-pointer names and roles (prev, curr, tmp)?
- [ ] Why save `tmp` before redirecting `curr.next`?
- [ ] Return `prev` not `curr`?
- [ ] Recursive alternative?

---

## Revision History

| Date | Note |
|------|------|
| — | `submission-0` (dummy prev, needs cleanup); preferred: `prev = null` directly |
