# Delete Node in a BST

| Field | Value |
|-------|-------|
| Topic | Trees |
| Difficulty | Medium |
| Primary Pattern | BST Recursion |
| Secondary Pattern | Tree Traversal |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `delete-node-in-a-bst`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

BST order preserved by replacing value with next larger (leftmost of right subtree).

---

## Thinking Process

1. Recurse by key comparison
2. 0 children: return null
3. 1 child: return that child
4. 2 children: copy successor value, delete successor node

**Best understanding:** Find node; 0/1 child splice; two children → swap with inorder successor then delete

---

## Why the Approach Works

Successor is smallest value > node—value swap keeps BST shape.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | BST Recursion |
| Secondary | Tree Traversal |

### Pattern Recognition Clues

- Delete while keeping BST property
- Three structural cases

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Use inorder predecessor from left subtree.

---

## Critical Implementation Details

- Value swap not subtree move for 2-child
- Return new subtree root

---

## Edge Cases

- Delete root
- Delete leaf

---

## Common Mistakes

- Relinking whole subtrees wrongly
- Skipping successor delete

---

## Complexity

| | |
|--|--|
| Time | O(h) |
| Space | O(h) |

---

## Similar Problems

- [insert-into-a-binary-search-tree](../insert-into-a-binary-search-tree/README.md)
- [lowest-common-ancestor-in-binary-search-tree](../lowest-common-ancestor-in-binary-search-tree/README.md)

---

## One-line Takeaway

**BST delete: splice 0/1 child; two children swap with successor then delete it.**

---

## Revision Checklist

- [ ] Three cases
- [ ] Preserve order

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-0 |
