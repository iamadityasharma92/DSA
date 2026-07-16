# LRU Cache

| Field | Value |
|-------|-------|
| Topic | Design |
| Difficulty | Medium |
| Primary Pattern | Hash Map + Doubly Linked List |
| Secondary Pattern | Design |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `lru-cache`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

O(1) get/put needs hash lookup plus constant-time splice in order list.

---

## Thinking Process

1. Dummy head/tail DLL
2. get: move node to MRU side
3. put: update or insert MRU; evict LRU if over cap
4. Map tracks key→node

**Best understanding:** Map key→node; DLL order MRU near head; evict tail.prev on overflow

---

## Why the Approach Works

DLL enables remove/insert in O(1); map finds node for access.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Hash Map + Doubly Linked List |
| Secondary | Design |

### Pattern Recognition Clues

- get/put O(1)
- Evict least recently used

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

LinkedHashMap in Java interviews if allowed.

---

## Critical Implementation Details

- Update on get promotes to MRU
- Remove old key on update put

---

## Edge Cases

- capacity 1
- put same key updates not evict

---

## Common Mistakes

- Forgetting get updates order
- Evicting wrong end

---

## Complexity

| | |
|--|--|
| Time | O(1) get/put |
| Space | O(capacity) |

---

## Similar Problems

- [design-hashmap](../design-hashmap/README.md)
- [time-based-key-value-store](../time-based-key-value-store/README.md)

---

## One-line Takeaway

**LRU = HashMap + DLL; get/put promote to head, evict tail.**

---

## Revision Checklist

- [ ] MRU at head
- [ ] Evict LRU tail

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-0 |
