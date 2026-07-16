# Insert into a Binary Search Tree

| Field | Value |
|-------|-------|
| Topic | Trees |
| Difficulty | Medium |
| Primary Pattern | BST Traversal |
| Secondary Pattern | Recursion |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `insert-into-a-binary-search-tree`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

BST insert follows search path—first null child is insertion point.

---

## Thinking Process

1. If root null return new node
2. If val < root.val left = insert(left)
3. Else right = insert(right)
4. Return root

**Best understanding:** Recurse left/right by value; attach new node at null position

---

## Why the Approach Works

BST invariant maintained by inserting at leaf along correct branch.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | BST Traversal |
| Secondary | Recursion |

### Pattern Recognition Clues

- Insert without rebalance
- Standard BST property

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Iterative walk with parent pointer.

---

## Critical Implementation Details

- Return updated subtree root
- Duplicate policy—usually attach right

---

## Edge Cases

- Empty tree new root
- Insert min/max at leaf

---

## Common Mistakes

- Replacing existing node
- Not returning root reference

---

## Complexity

| | |
|--|--|
| Time | O(h) |
| Space | O(h) |

---

## Similar Problems

- [delete-node-in-a-bst](../delete-node-in-a-bst/README.md)
- [lowest-common-ancestor-in-binary-search-tree](../lowest-common-ancestor-in-binary-search-tree/README.md)

---

## One-line Takeaway

**BST insert = search until null then attach leaf.**

---

## Revision Checklist

- [ ] Compare val to root
- [ ] Return root

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-1 |
