# Invert a Binary Tree

| Field | Value |
|-------|-------|
| Topic | Trees |
| Difficulty | Easy |
| Primary Pattern | DFS post-order swap |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Invert a binary tree (mirror it): every node's left and right children are swapped recursively.

---

## Constraints (typical)

- `0 ≤ n ≤ 100`
- Return the root of the inverted tree

---

## Brute Force

No meaningful brute force here — the recursive approach is both the simplest and optimal.

---

## Core Observation

To invert a tree: invert the left subtree, invert the right subtree, then swap the left and right children at the current node (post-order).

---

## Thinking Process

1. Base: `root == null` → return `null`.
2. Recurse: `invertTree(root.left)`, `invertTree(root.right)`.
3. Swap: `temp = root.left; root.left = root.right; root.right = temp`.
4. Return `root`.

---

## Why the Approach Works

Post-order ensures both subtrees are fully inverted before the swap at the current node. The swap at every node produces the mirror image of the full tree.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Post-order DFS — children first, then current node action |
| Alternative | BFS: process level by level, swapping children as nodes dequeue |

### Pattern Recognition Clues

- "Mirror / flip a binary tree"
- Result depends on both subtrees → process children before parent

Cross-ref: [Trees](../Trees/README.md) · [PATTERNS.md](../../PATTERNS.md#tree-dfs--aggregate-up)

---

## Alternative Approaches

**BFS:** use a queue; for each node, swap its children and enqueue both. O(n) time, O(w) space.

---

## Critical Implementation Details

- Swap happens **after** recursion (post-order) — but pre-order also works (swap first, then recurse left and right)
- Null base case is required
- Must return `root` to preserve the tree reference for the parent

---

## Edge Cases

- Empty tree → return `null`
- Single node → unchanged
- Only left or only right subtree

---

## Common Mistakes

- Not returning `root` (caller loses reference)
- Forgetting null base case
- Thinking pre-order doesn't work (it does — the key is swapping at every node)

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(h) recursion stack |

---

## Similar Problems

- [same-binary-tree](../same-binary-tree/README.md) — structural comparison DFS
- [balanced-binary-tree](../balanced-binary-tree/README.md) — DFS with return value

---

## One-line Takeaway

**Recurse both children, then swap left/right at current node — O(n).**

---

## Revision Checklist

- [ ] Post-order vs pre-order — does the swap order matter here?
- [ ] BFS alternative?
- [ ] Why must we return `root`?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0.java` |
