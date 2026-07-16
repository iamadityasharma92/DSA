# Copy Linked List with Random Pointer

| Field | Value |
|-------|-------|
| Topic | Linked List |
| Difficulty | Medium |
| Primary Pattern | HashMap node cloning |
| Secondary Pattern | Two-pass wiring |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

A linked list where each node also has a `random` pointer to any node in the list (or null). Return a **deep copy** — brand new nodes with same values and same structural `next`/`random` relationships.

---

## Constraints (typical)

- `0 ≤ n ≤ 1000`
- `random` can point to any node including itself, or `null`
- Values may repeat — identity matters, not value

---

## Brute Force

Clone all nodes, then for each random pointer walk the original list to find the target's position and index into the copy list → O(n²). Unacceptable.

---

## Core Observation

Random pointers need all copy nodes to **already exist** before they can be wired. Use a map from `originalNode → copyNode` built in pass 1; assign `next`/`random` in pass 2.

---

## Thinking Process

1. Pass 1: walk original list, create `map.put(node, new Node(node.val))` for every node.
2. Pass 2: walk original again:
   - `map.get(current).next = map.get(current.next)`
   - `map.get(current).random = map.get(current.random)`
3. Return `map.get(head)`.

`submission-0` is the clean two-pass. `submission-1` handles `null` pointers inline by pre-inserting `map.put(null, null)` — slightly more verbose but avoids null checks.

---

## Why the Approach Works

The map translates any original node reference (including `null`) to its copy in O(1). Because all copies exist after pass 1, pass 2 can safely assign any pointer.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Two-pass: create all nodes, then wire all edges |
| Alternative | Interleave copies in the list (no extra map, O(1) space) |

### Pattern Recognition Clues

- "Deep copy with cross-referencing pointers"
- Need all destinations to exist before connecting

Cross-ref: [Linked List](../Linked%20List/README.md)

---

## Alternative Approaches

**O(1) space:** interleave copies between original nodes (`1 → 1' → 2 → 2'`), set random pointers, then decouple. More complex to implement.

---

## Critical Implementation Details

- `map.get(null)` in Java returns `null` by default — `submission-0` exploits this for `null` random/next
- `submission-1` explicitly inserts `map.put(null, null)` as a safety guard
- Return `map.get(head)`, **not** the dummy node used in some iterations

---

## Edge Cases

- Empty list (`head == null`) → return `null`
- Node whose `random` points to itself
- All nodes have `random == null`

---

## Common Mistakes

- Wiring `random` in pass 1 before all copy nodes are created (NullPointerException or wrong target)
- Shallow copy: reusing original node references in the copy list
- Using `node.val` as a key instead of identity — breaks on duplicate values

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(n) — the map + output nodes |

---

## Similar Problems

- [reorder-linked-list](../reorder-linked-list/README.md) — multi-step list manipulation
- [reverse-a-linked-list](../reverse-a-linked-list/README.md) — fundamental wiring technique

---

## One-line Takeaway

**Clone all nodes into a map first, then wire next and random via the map in a second pass.**

---

## Revision Checklist

- [ ] Why two passes instead of one?
- [ ] What does `map.get(null)` return — and why does that help?
- [ ] Describe the O(1) space interleaving alternative.

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0` (clean two-pass) and `submission-1` (explicit null guard) |
