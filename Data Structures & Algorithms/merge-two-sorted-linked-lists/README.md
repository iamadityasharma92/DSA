# Merge Two Sorted Linked Lists

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

Interview problem `merge-two-sorted-linked-lists`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Sorted merge like merge step in mergesort on linked nodes.

---

## Thinking Process

1. Dummy + tail pointer
2. While both: link smaller advance
3. Attach non-null tail
4. Return dummy.next

**Best understanding:** Dummy head; attach smaller node; advance; link remaining tail

---

## Why the Approach Works

Pointer splice builds sorted list in one pass.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Two Pointers |
| Secondary | Linked List |

### Pattern Recognition Clues

- Two sorted lists
- Return merged head

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Recursive merge—O(n) stack.

---

## Critical Implementation Details

- Dummy simplifies head
- Advance tail each link

---

## Edge Cases

- One list null
- All smaller in list1

---

## Common Mistakes

- Losing rest of list
- Not advancing tail

---

## Complexity

| | |
|--|--|
| Time | O(n+m) |
| Space | O(1) |

---

## Similar Problems

- [merge-sorted-array](../merge-sorted-array/README.md)
- [remove-node-from-end-of-linked-list](../remove-node-from-end-of-linked-list/README.md)

---

## One-line Takeaway

**Sorted list merge → dummy head two-pointer splice.**

---

## Revision Checklist

- [ ] Dummy node
- [ ] Attach remainder

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-0 |
