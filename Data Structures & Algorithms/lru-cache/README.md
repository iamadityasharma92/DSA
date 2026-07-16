# LRU Cache

| Field | Value |
|-------|-------|
| Topic | Design |
| Difficulty | Medium |
| Primary Pattern | HashMap + Doubly Linked List |
| Secondary Pattern | Dummy head/tail sentinels |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Design a data structure that follows the **Least Recently Used (LRU)** cache eviction policy with a fixed capacity. `get(key)` and `put(key, value)` must both run in O(1).

---

## Constraints (typical)

- `1 ≤ capacity ≤ 3000`
- `0 ≤ key, value ≤ 10⁴`
- At most `2 × 10⁵` operations

---

## Brute Force

Sorted/timestamped list with a map — O(n log n) per operation. Too slow.

---

## Core Observation

O(1) access = HashMap. O(1) recency tracking = Doubly Linked List (DLL). The HashMap maps `key → DLL node`; the DLL maintains insertion/access order (head = MRU, tail = LRU). On `get`/`put`, move the accessed node to the head. On overflow, evict from tail.

---

## Thinking Process

1. `HashMap<Integer, Node> cache`, DLL with dummy `left` (head) and `right` (tail) sentinels.
2. `get(key)`: if in cache, `remove(node)` then `insertAfterHead(node)`, return `node.val`. Else `-1`.
3. `put(key, val)`:
   - If key exists: `remove(cache.get(key))`.
   - Create new node, `cache.put(key, node)`, `insertAfterHead(node)`.
   - If `cache.size() > capacity`: evict `right.prev` (LRU node) — remove from map and DLL.

**Helpers:**
- `remove(node)`: wire `node.prev.next = node.next` and `node.next.prev = node.prev`.
- `insertAfterHead(node)`: wire between `left` and `left.next`.

---

## Why the Approach Works

DLL allows O(1) remove and O(1) insert anywhere given a direct node pointer. HashMap gives O(1) lookup. Dummies eliminate null checks at boundaries.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | HashMap + DLL = O(1) LRU |
| Contrast | Java's `LinkedHashMap` implements this internally |

### Pattern Recognition Clues

- "O(1) get, put, with eviction order"
- Must track recency of access

Cross-ref: [Design](../Design/README.md) · [PATTERNS.md](../../PATTERNS.md#design-patterns)

---

## Alternative Approaches

`LinkedHashMap` with `removeEldestEntry` override — one-liner in Java but won't be accepted in an interview asking for from-scratch design.

---

## Critical Implementation Details

- Evict `right.prev` (tail-side = LRU), NOT `left.next` (head-side = MRU)
- On `put` for existing key: **remove old node first**, then insert new node (don't update value in place — keeps dummy pointers clean)
- Dummy sentinels: `left.next = right`, `right.prev = left` — never traverse beyond sentinels
- Node must store the key (needed to remove it from the HashMap on eviction)

---

## Edge Cases

- `put` existing key → update value and promote to MRU
- `get` after eviction → returns -1
- Cache of size 1 — insert one, insert another, first is evicted

---

## Common Mistakes

- Evicting from the wrong end (head instead of tail)
- Not updating `cache` (HashMap) when evicting
- Node not storing the key — can't remove from HashMap on eviction
- Forgetting to move node to MRU on `get`

---

## Complexity

| | |
|--|--|
| Time | O(1) for both `get` and `put` |
| Space | O(capacity) |

---

## Similar Problems

- [design-hashmap](../design-hashmap/README.md) — simpler O(1) map design
- [design-circular-queue](../design-circular-queue/README.md) — DLL-based design

---

## One-line Takeaway

**HashMap(key→node) + DLL(head=MRU, tail=LRU) + dummies = O(1) get/put with LRU eviction.**

---

## Revision Checklist

- [ ] Why dummies at both ends?
- [ ] Which end is MRU and which is LRU?
- [ ] What must the Node store besides key and value?
- [ ] Steps in `put` when key already exists?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0.java` |
