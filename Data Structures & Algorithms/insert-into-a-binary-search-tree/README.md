# Insert into a Binary Search Tree

| Field | Value |
|-------|-------|
| Topic | Trees |
| Difficulty | Medium |
| Primary Pattern | BST recursive descent |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Insert a value into a BST and return the root of the resulting tree. All values are unique. There is always a valid position.

---

## Constraints (typical)

- Values unique; value to insert not already in tree
- BST property must be maintained after insert
- `0 ≤ n ≤ 10⁴`

---

## Brute Force

Iterative descent with parent tracking — correct but more bookkeeping than recursive.

---

## Core Observation

BST ordering tells you exactly which subtree to recurse into. When you hit a `null` node, that's the insertion point — return a new node there. The recursive return propagates the new child back up.

---

## Thinking Process

1. Base: `root == null` → `return new TreeNode(val)`.
2. If `val > root.val` → `root.right = insertIntoBST(root.right, val)`.
3. Else → `root.left = insertIntoBST(root.left, val)`.
4. Return `root`.

`submission-0` and `submission-1` are identical.

---

## Why the Approach Works

BST ordering uniquely determines the path to the null insertion point in at most O(h) steps. Returning and assigning at each level automatically wires the new node into the correct child pointer.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | BST descent: compare, recurse, return |
| Contrast | Delete node: harder because must handle 2-child case |

### Pattern Recognition Clues

- "Insert into BST"
- Must preserve BST property

Cross-ref: [Trees](../Trees/README.md)

---

## Alternative Approaches

**Iterative:** keep `parent` reference; at null child, attach `new TreeNode(val)` directly. O(h) time, O(1) stack space.

---

## Critical Implementation Details

- **Must assign:** `root.right = insertIntoBST(root.right, val)` — without the assignment, the new node is lost
- The base case creates the new node and returns it; the parent level wires it in
- No need to handle equal values (problem guarantees uniqueness)

---

## Edge Cases

- Empty tree → new node becomes root
- Insert smallest or largest → goes to leftmost or rightmost leaf

---

## Common Mistakes

- Forgetting to assign the recursive result: `insertIntoBST(root.right, val)` without `root.right =` discards the new node
- Recursing into wrong side (confusing `>` and `<`)

---

## Complexity

| | |
|--|--|
| Time | O(h) — O(log n) balanced, O(n) worst |
| Space | O(h) recursion stack |

---

## Similar Problems

- [delete-node-in-a-bst](../delete-node-in-a-bst/README.md) — same BST descent, more complex fix-up
- [lowest-common-ancestor-in-binary-search-tree](../lowest-common-ancestor-in-binary-search-tree/README.md) — BST property navigation

---

## One-line Takeaway

**BST insert: recurse right/left per value comparison; assign return at null to wire new node.**

---

## Revision Checklist

- [ ] Why must you assign the recursive return value?
- [ ] Base case: what do you return when `root == null`?
- [ ] Iterative alternative?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0` / `submission-1` (identical) |
