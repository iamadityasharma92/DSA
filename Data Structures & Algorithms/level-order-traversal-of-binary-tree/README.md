# Binary Tree Level Order Traversal

| Field | Value |
|-------|-------|
| Topic | Trees |
| Difficulty | Medium |
| Primary Pattern | BFS level order |
| Secondary Pattern | Level boundary via queue size snapshot |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Return the values of a binary tree's nodes grouped by level: `[[level0], [level1], [level2], …]`.

---

## Constraints (typical)

- `0 ≤ n ≤ 2000`
- Output: list of lists, one per level

---

## Brute Force

DFS with a depth parameter collecting into indexed lists — O(n) time. Valid alternative to BFS.

---

## Core Observation

BFS processes nodes in level order by definition. To separate levels: **snapshot the queue size at the start of each iteration** — process exactly that many nodes before moving to the next level.

---

## Thinking Process

1. `Queue<TreeNode> q = new ArrayDeque<>()`. Add `root` if non-null.
2. While queue not empty:
   - `size = q.size()` (frozen level boundary).
   - Inner loop `i = size` down to 1: poll node, add value to current level list, enqueue non-null children.
   - Add level list to result if non-empty.

---

## Why the Approach Works

At the start of each outer iteration, the queue holds exactly the nodes of the current level. Processing `size` nodes before checking again ensures all next-level nodes are enqueued before the inner loop ends.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | BFS with level-size snapshot |
| Alternative | DFS with depth index into result list |
| Related | Right-side view: last node per level |

### Pattern Recognition Clues

- "Level by level", "floor by floor"
- Group nodes by depth

Cross-ref: [Trees](../Trees/README.md) · [PATTERNS.md](../../PATTERNS.md#bfs-level-order)

---

## Alternative Approaches

**DFS with depth:** `dfs(node, depth, res)` — if `res.size() == depth`, add new list; append `node.val` to `res.get(depth)`. O(n) same complexity, O(h) stack vs O(w) queue.

---

## Critical Implementation Details

- Use `ArrayDeque`, not `LinkedList` — `ArrayDeque` does not allow `null` values; must check children before enqueuing
- Snapshot `q.size()` in `int size = q.size()` before the inner loop; polling changes the queue size
- Skip adding empty lists (can't happen if root is non-null, but defensive check costs nothing)

---

## Edge Cases

- Empty tree → empty list
- Single node → `[[val]]`
- Skewed chain → one node per level

---

## Common Mistakes

- Not snapshotting queue size (using `q.size()` in the loop condition — shrinks as you poll)
- Enqueuing null children into `ArrayDeque` (throws `NullPointerException`)
- Using `LinkedList` queue and forgetting about null permissions

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(w) — max width of tree in queue |

---

## Similar Problems

- [binary-tree-right-side-view](../binary-tree-right-side-view/README.md) — BFS last-per-level
- [depth-of-binary-tree](../depth-of-binary-tree/README.md) — level count as depth

---

## One-line Takeaway

**BFS with size snapshot: process exactly q.size() nodes per iteration to isolate each level.**

---

## Revision Checklist

- [ ] Why snapshot `q.size()` before the inner loop?
- [ ] Why can't we enqueue null children with `ArrayDeque`?
- [ ] DFS alternative with depth parameter?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-1.java` |
