# Lowest Common Ancestor of a BST

| Field | Value |
|-------|-------|
| Topic | Trees |
| Difficulty | Medium |
| Primary Pattern | BST descent using ordering property |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given a BST and two nodes `p` and `q`, find their Lowest Common Ancestor (LCA) — the deepest node that has both `p` and `q` as descendants (a node can be a descendant of itself).

---

## Constraints (typical)

- `p` and `q` are both in the tree
- Values are unique

---

## Brute Force

For a general binary tree: post-order DFS at every node checking if `p` or `q` is in left/right subtrees — O(n). Correct but doesn't use BST property.

---

## Core Observation

In a BST: if both `p.val` and `q.val` are less than `root.val`, LCA is in the left subtree. If both are greater, LCA is in the right subtree. Otherwise (the values split across the root, or one equals root), the current node IS the LCA.

---

## Thinking Process

1. If `p.val < root.val && q.val < root.val` → recurse left.
2. Else if `p.val > root.val && q.val > root.val` → recurse right.
3. Else → return `root` (split here, or root equals p or q).

---

## Why the Approach Works

The BST ordering guarantees that the "split point" is exactly the LCA. Once the two values no longer agree on a direction (or one matches root), the current node is the lowest ancestor of both.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | BST descent — exploit ordering to skip subtrees |
| Contrast | General binary tree LCA uses DFS returning found flags |

### Pattern Recognition Clues

- "LCA in a BST" — always prefer BST property over generic LCA
- If `p` and `q` are on the same side, go deeper; split = answer

Cross-ref: [Trees](../Trees/README.md) · [PATTERNS.md](../../PATTERNS.md#tree-dfs--aggregate-up)

---

## Alternative Approaches

**Iterative:** same logic but with a while loop — O(h) time, O(1) stack space.

**Generic LCA DFS:** works but O(n) and ignores BST structure.

---

## Critical Implementation Details

- No need to check for null (problem guarantees p and q exist in the tree)
- The split check covers: root == p, root == q, or p and q are in different subtrees
- Iterative version: `while(root != null)` with same conditionals

---

## Edge Cases

- `p == q` → return `p`
- One node is ancestor of the other → that ancestor is the LCA
- Root itself is p or q

---

## Common Mistakes

- Applying generic LCA DFS to a BST (wasted opportunity — uses O(n) instead of O(log n))
- Checking `<= ` vs `<` (must be strict for both values on same side)

---

## Complexity

| | |
|--|--|
| Time | O(h) — O(log n) balanced, O(n) worst |
| Space | O(h) recursion |

---

## Similar Problems

- [delete-node-in-a-bst](../delete-node-in-a-bst/README.md) — BST descent same framework
- [insert-into-a-binary-search-tree](../insert-into-a-binary-search-tree/README.md) — same one-direction descent

---

## One-line Takeaway

**BST LCA: both < root → left; both > root → right; else root IS the LCA.**

---

## Revision Checklist

- [ ] Three cases: both left, both right, split/match?
- [ ] Why O(log n) vs O(n) for general tree LCA?
- [ ] What if root equals p or q — is it returned correctly?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-2.java` |
