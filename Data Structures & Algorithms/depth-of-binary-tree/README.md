# Maximum Depth of Binary Tree

| Field | Value                   |
|-------|-------------------------|
| Topic | Trees                   |
| Difficulty | Easy                    |
| Primary Pattern | DFS (post-order height) |
| Secondary Pattern | BFS level count         |
| Confidence | HIGH                    |
| Last Revision | 17/7/2026               |

---

## Problem Summary

Given the root of a binary tree, return its **maximum depth** — the number of nodes along the longest path from root to a leaf.

---

## Constraints (typical)

- `0 ≤ n ≤ 10⁴`
- Empty tree has depth 0
- Depth counts **nodes**, not edges (so a single-node tree has depth 1)

---

## Brute Force

No separate brute force — the recursive DFS is both natural and optimal at O(n).

---

## Core Observation

The depth of any node equals `1 + max(depth(left), depth(right))`. A `null` node has depth 0. This gives a clean post-order recursion that visits every node exactly once.

---

## Thinking Process

1. Base case: `root == null` → return 0.
2. Recurse: `leftDepth = depth(root.left)`, `rightDepth = depth(root.right)`.
3. Return `1 + Math.max(leftDepth, rightDepth)`.

`submission-0` uses a helper method `depth()` called from `maxDepth()` — functionally identical to a single recursive method.

---

## Why the Approach Works

Post-order: both children are measured before the parent aggregates. The max of two subtree depths picks the longer path; `+1` adds the current node.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Post-order DFS aggregate up |
| Alternative | BFS: count levels as queue processes each level |

### Pattern Recognition Clues

- "Maximum / minimum depth"
- Result depends on both subtrees → post-order

Cross-ref: [Trees](../Trees/README.md) · [PATTERNS.md](../../PATTERNS.md#tree-dfs--aggregate-up)

---

## Alternative Approaches

**BFS:** use a queue; increment a counter for each level processed. O(n), O(w) space. Good when depth coincides with BFS use anyway.

---

## Critical Implementation Details

- Null returns 0 (not -1 or -∞)
- A leaf returns 1 (null children both return 0, so `1 + max(0,0) = 1`)
- Depth = node count along path, not edge count

---

## Edge Cases

- Empty tree → 0
- Single node → 1
- Completely skewed chain → O(n) depth

---

## Common Mistakes

- Returning 0 for a leaf (off-by-one in node vs edge count)
- Mixing depth (node count) and height (edge count) problems

---

## Complexity

| | |
|--|--|
| Time | O(n) — every node visited once |
| Space | O(h) recursion stack |

---

## Similar Problems

- [balanced-binary-tree](../balanced-binary-tree/README.md) — same height DFS, adds `|L−R|` check
- [binary-tree-diameter](../binary-tree-diameter/README.md) — uses `L + R` instead of `max(L, R)`

---

## One-line Takeaway

**depth(node) = 1 + max(depth(left), depth(right)); null → 0.**

---

## Revision Checklist

- [ ] Return value for null node?
- [ ] Return value for a leaf?
- [ ] Node-count vs edge-count distinction?
- [ ] When to prefer BFS alternative?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0.java` |
