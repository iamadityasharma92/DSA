# Binary Tree Postorder Traversal

| Field | Value               |
|-------|---------------------|
| Topic | Trees               |
| Difficulty | Easy                |
| Primary Pattern | DFS traversal       |
| Secondary Pattern | Left → Right → Node |
| Confidence | HIGH                |
| Last Revision | 17/7/2026           |

---

## Problem Summary

Return values in postorder.

---

## Core Observation / Thinking

Recurse left, recurse right, then visit. Definition = solution.

---

## Pattern Recognition

DFS walk; iterative needs two stacks or modified preorder reverse. See [Trees](../Trees/README.md).

---

## Critical Implementation Details

Visit **after** both children — used for delete/free and some aggregate-up problems.

---

## Complexity

O(n) time, O(h) space.

---

## Similar Problems

- [binary-tree-inorder-traversal](../binary-tree-inorder-traversal/README.md)
- [binary-tree-preorder-traversal](../binary-tree-preorder-traversal/README.md)

---

## One-line Takeaway

**Postorder = children first, node last.**

---

## Revision Checklist

- [ ] Contrast pre/in/post visit timing
- [ ] Sketch iterative postorder

---

## Revision History

| Date | Note |
|------|------|
| — | From `submission-0.java` |
