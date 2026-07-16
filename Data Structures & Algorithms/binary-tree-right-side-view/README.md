# Binary Tree Right Side View

| Field | Value |
|-------|-------|
| Topic | Trees |
| Difficulty | Medium |
| Primary Pattern | BFS level order |
| Secondary Pattern | Last node per level |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Values of nodes visible from the right (rightmost node at each depth).

---

## Brute Force

N/A — structure dictates level reasoning.

---

## Core Observation

In level-order BFS, the **last** node dequeued in each level is the right-side view.

(`submission-0` / `submission-2`: same BFS; `submission-2` cleans empty-root early return.)

---

## Thinking Process

1. Queue BFS; for each level size `sz`:
2. Poll `sz` nodes; enqueue children left then right.
3. When processing the last index of the level, append its value.

---

## Why the Approach Works

Level order groups depth; rightmost in left-to-right enqueue order is the visible node (children enqueued L then R).

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | BFS by level |
| Alternative | DFS tracking depth, overwrite/res first-seen from right |

See: [Trees](../Trees/README.md), [PATTERNS.md](../../PATTERNS.md#bfs-level-order).

---

## Critical Implementation Details

- Capture `q.size()` before the inner loop
- Record when `i == 1` if counting down, or when `i == sz-1` if counting up

---

## Edge Cases

- Empty; skewed left (still one node per level); single node

---

## Common Mistakes

- Taking the first node of each level (left view)
- Not freezing level size

---

## Complexity

O(n) time, O(w) queue.

---

## Similar Problems

- [level-order-traversal-of-binary-tree](../level-order-traversal-of-binary-tree/README.md)
- Left side view — first node per level

---

## One-line Takeaway

**BFS by level; emit the last node of each level.**

---

## Revision Checklist

- [ ] Level-size loop from memory
- [ ] DFS depth alternative?

---

## Revision History

| Date | Note |
|------|------|
| — | From `submission-0` / `submission-2` (BFS last-per-level) |
