# Binary Tree Preorder Traversal

| Field | Value               |
|-------|---------------------|
| Topic | Trees               |
| Difficulty | Easy                |
| Primary Pattern | DFS traversal       |
| Secondary Pattern | Node → Left → Right |
| Confidence | HIGH                |
| Last Revision | 17/7/2026           |

---

## Problem Summary

Return values in preorder.

---

## Core Observation / Thinking

Visit, then left, then right. Iterative: stack, push right then left.

---

## Pattern Recognition

Root-first DFS; natural for copying trees / serialization prefixes. See [Trees](../Trees/README.md).

---

## Complexity

O(n) time, O(h) space.

---

## Similar Problems

- [binary-tree-inorder-traversal](../binary-tree-inorder-traversal/README.md)
- [binary-tree-postorder-traversal](../binary-tree-postorder-traversal/README.md)

---

## One-line Takeaway

**Preorder = visit, then left, then right.**

---

## Revision Checklist

- [ ] Iterative stack order (right before left)

---

## Revision History

| Date | Note |
|------|------|
| — | From `submission-0.java` |
