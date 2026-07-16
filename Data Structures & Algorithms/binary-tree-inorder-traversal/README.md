# Binary Tree Inorder Traversal

| Field | Value |
|-------|-------|
| Topic | Trees |
| Difficulty | Easy |
| Primary Pattern | DFS traversal |
| Secondary Pattern | Left → Node → Right |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Return values in inorder: left subtree, node, right subtree.

---

## Brute Force / Core

Recursion is the definition. Iterative stack is the interview follow-up.

---

## Thinking Process

```
inorder(node):
  if null return
  inorder(left)
  visit
  inorder(right)
```

Both submissions use recursive accumulation into a list.

---

## Why the Approach Works

Matches BST sorted order property; for general binary trees it is still a well-defined walk.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Tree DFS recursion |
| Follow-up | Iterative with explicit stack |

See: [Trees](../Trees/README.md).

---

## Alternative Approaches

| Approach | Notes |
|----------|-------|
| Recursive | Used here |
| Iterative stack | Push left spine, pop/visit, go right |
| Morris | O(1) extra space, threaded tree |

---

## Critical Implementation Details

- Visit **between** left and right
- Null base case

---

## Edge Cases

- Empty; single node; skewed

---

## Common Mistakes

- Premature visit (preorder) or late visit (postorder)

---

## Complexity

Time O(n), Space O(h) recursion (+ output).

---

## Similar Problems

- [binary-tree-preorder-traversal](../binary-tree-preorder-traversal/README.md)
- [binary-tree-postorder-traversal](../binary-tree-postorder-traversal/README.md)
- [binary-tree-right-side-view](../binary-tree-right-side-view/README.md) — BFS/DFS by level

---

## One-line Takeaway

**Inorder = left, visit, right; know iterative stack variant.**

---

## Revision Checklist

- [ ] Recite pre/in/post order
- [ ] Sketch iterative inorder

---

## Revision History

| Date | Note |
|------|------|
| — | From `submission-0` / `submission-1` (identical recursive) |
