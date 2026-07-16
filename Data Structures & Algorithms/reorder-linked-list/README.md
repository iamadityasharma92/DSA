# Reorder Linked List

| Field | Value |
|-------|-------|
| Topic | Linked List |
| Difficulty | Medium |
| Primary Pattern | Fast Slow Pointers |
| Secondary Pattern | Linked List |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `reorder-linked-list`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

L0→L1→…→Ln becomes L0→Ln→L1→Ln-1 by split reverse zip.

---

## Thinking Process

1. Slow/fast mid split
2. Reverse second half
3. Merge two lists alternating
4. Preserve linear time

**Best understanding:** Find mid, reverse second half, merge alternating first and reversed second

---

## Why the Approach Works

Three classic list ops compose target interleaving without extra array.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Fast Slow Pointers |
| Secondary | Linked List |

### Pattern Recognition Clues

- Reorder L0 Ln L1 Ln-1
- O(1) space

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Array store values reorder rebuild.

---

## Critical Implementation Details

- Split after mid correctly on even/odd
- Reverse second before merge

---

## Edge Cases

- Two nodes swap ends
- Odd length mid handling

---

## Common Mistakes

- Merging wrong pointer order
- Not breaking first half tail

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) |

---

## Similar Problems

- [reverse-a-linked-list](../reverse-a-linked-list/README.md)
- [copy-linked-list-with-random-pointer](../copy-linked-list-with-random-pointer/README.md)

---

## One-line Takeaway

**Reorder list → mid split, reverse 2nd, zip merge.**

---

## Revision Checklist

- [ ] Find mid
- [ ] Reverse second

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-0 |
