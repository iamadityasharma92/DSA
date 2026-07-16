# Delete Node in a BST

| Field | Value |
|-------|-------|
| Topic | Trees |
| Difficulty | Medium |
| Primary Pattern | BST recursive descent |
| Secondary Pattern | Inorder successor replacement |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given the root of a BST and a `key`, delete the node with that key and return the (possibly new) root. The resulting tree must remain a valid BST.

---

## Constraints (typical)

- Node values unique
- Key may not be in the tree
- `0 ≤ n ≤ 10⁴`

---

## Brute Force

Find the node iteratively, handle removal manually with parent tracking → more code, same complexity, more error-prone than recursive.

---

## Core Observation

There are three cases for the node to delete:
1. **No children** → replace with `null`
2. **One child** → replace with that child
3. **Two children** → replace value with **inorder successor** (leftmost node of right subtree), then recursively delete the successor from the right subtree

---

## Thinking Process

1. BST descent: `root.val < key` → recurse right; `root.val > key` → recurse left.
2. Found (`root.val == key`):
   - `root.right == null` → return `root.left`
   - `root.left == null` → return `root.right`
   - Both exist: find `current = leftmost of root.right`, copy `root.val = current.val`, then `root.right = deleteNode(root.right, root.val)`.
3. Return `root` at each level (assignments propagate up).

---

## Why the Approach Works

The inorder successor is the smallest value in the right subtree, so replacing the deleted node's value with it maintains BST order. Then deleting that successor (which has at most one child) reduces to cases 1 or 2.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | BST recursive descent (find then fix) |
| Alternative | Inorder predecessor (largest of left subtree) — symmetric |

### Pattern Recognition Clues

- "Delete in BST"
- Need to preserve BST property after removal

Cross-ref: [Trees](../Trees/README.md)

---

## Alternative Approaches

**Inorder predecessor:** take the rightmost of `root.left` instead of leftmost of `root.right`. Symmetric; same complexity.

**Iterative:** track parent + which child — more code, O(1) stack space.

---

## Critical Implementation Details

- Must assign recursive calls back to child: `root.right = deleteNode(root.right, key)` — forgetting this loses the subtree
- After value replacement: delete `root.val` (the new value) from `root.right`, **not** from `root.left`
- Missing key: recursion bottoms out at `null`, returns `null` — no crash

---

## Edge Cases

- Key not in tree → tree unchanged
- Delete root with two children
- Delete leaf
- Tree with single node

---

## Common Mistakes

- For the two-child case: trying to physically relink the node instead of swapping values then deleting the simpler successor node
- Forgetting to assign `root.left = ...` or `root.right = ...` from recursive return
- Finding predecessor/successor on the wrong side

---

## Complexity

| | |
|--|--|
| Time | O(h) — O(log n) balanced, O(n) worst skewed |
| Space | O(h) recursion stack |

---

## Similar Problems

- [insert-into-a-binary-search-tree](../insert-into-a-binary-search-tree/README.md) — BST descent same structure, simpler
- [lowest-common-ancestor-in-binary-search-tree](../lowest-common-ancestor-in-binary-search-tree/README.md) — BST property navigation

---

## One-line Takeaway

**BST delete: 0/1 child → splice; 2 children → copy inorder successor's value then delete it.**

---

## Revision Checklist

- [ ] Three cases: 0/1/2 children?
- [ ] Inorder successor = leftmost of right subtree?
- [ ] Why copy the value instead of physically moving the node?
- [ ] Must assign result of recursive calls back to parent pointer?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0.java` |
