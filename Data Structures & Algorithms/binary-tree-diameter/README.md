# Binary Tree Diameter

| Field | Value                                    |
|-------|------------------------------------------|
| Topic | Trees                                    |
| Difficulty | Easy                                     |
| Primary Pattern | Tree DFS / Aggregate Up                  |
| Secondary Pattern | Global max of `leftHeight + rightHeight` |
| Confidence | HIGH                                     |
| Last Revision | 17/7/2026                                |

---

## Problem Summary

Diameter = longest path between any two nodes (edge count). Path need not pass through root.

---

## Brute Force

For each node, height(left)+height(right), take max — O(n²) if heights recomputed.

---

## Core Observation

Same post-order as balanced-tree: return height upward; at each node update global best with `leftH + rightH`.

---

## Thinking Process

DFS returns height; `d = max(d, lm + rm)`; return `1 + max(lm, rm)`.

---

## Why the Approach Works

Any path’s highest node is the “bend”; checking `lm+rm` at every bend covers all paths.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Aggregate-up DFS |
| Contrast | Balance checks `|lm-rm|`; diameter uses `lm+rm` |

See: [Trees](../Trees/README.md), [PATTERNS.md](../../PATTERNS.md#tree-dfs--aggregate-up).

---

## Alternative Approaches

Return pair `(height, diameter)` instead of global field — same asymptotics.

---

## Critical Implementation Details

- Diameter in **edges** = `lm + rm` (not `+1` for nodes unless problem asks nodes)
- Null → height 0

---

## Edge Cases

- Single node → 0
- Skewed chain → n−1

---

## Common Mistakes

- Returning only root’s `lm+rm`
- Confusing node-count vs edge-count

---

## Complexity

Time O(n), Space O(h).

---

## Similar Problems

- [balanced-binary-tree](../balanced-binary-tree/README.md)
- [depth-of-binary-tree](../depth-of-binary-tree/README.md)

---

## One-line Takeaway

**At each node, diameter candidate = leftHeight + rightHeight; DFS returns height.**

---

## Revision Checklist

- [ ] Edges vs nodes
- [ ] Same skeleton as isBalanced?

---

## Revision History

| Date | Note |
|------|------|
| — | From `submission-0.java` |
