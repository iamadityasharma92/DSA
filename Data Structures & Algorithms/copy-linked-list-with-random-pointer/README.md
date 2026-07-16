# Copy Linked List with Random Pointer

| Field | Value |
|-------|-------|
| Topic | Linked List |
| Difficulty | Medium |
| Primary Pattern | Hash Map Clone |
| Secondary Pattern | Linked List |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `copy-linked-list-with-random-pointer`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Random pointers need stable mapping from original nodes to their clones.

---

## Thinking Process

1. Iterate list building HashMap old→clone
2. Second pass assign next and random from map
3. Return map.get(head)
4. Null random stays null

**Best understanding:** Map old→new node; pass 1 create clones, pass 2 wire next and random

---

## Why the Approach Works

Clones must exist before random can reference another clone.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Hash Map Clone |
| Secondary | Linked List |

### Pattern Recognition Clues

- Deep copy with arbitrary pointers
- Graph-like structure on list

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Interleave old/new nodes then split—O(1) extra space.

---

## Critical Implementation Details

- Two passes
- Key is node reference not value

---

## Edge Cases

- Empty list
- Random to self

---

## Common Mistakes

- Shallow copy of nodes
- Value-based map keys

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(n) |

---

## Similar Problems

- [reorder-linked-list](../reorder-linked-list/README.md)
- [merge-two-sorted-linked-lists](../merge-two-sorted-linked-lists/README.md)

---

## One-line Takeaway

**Clone linked structure with extra pointers → HashMap old→new.**

---

## Revision Checklist

- [ ] Create all nodes first
- [ ] Wire next and random

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-1 |
