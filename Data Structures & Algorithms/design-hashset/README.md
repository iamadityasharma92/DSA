# Design HashSet

| Field | Value |
|-------|-------|
| Topic | Design |
| Difficulty | Easy |
| Primary Pattern | Hashing |
| Secondary Pattern | Array |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `design-hashset`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Set membership via hash buckets—duplicate keys ignored on add.

---

## Thinking Process

1. Buckets with lists
2. hash(key) % M
3. add: append if not in chain
4. contains: scan chain

**Best understanding:** Bucket array with chaining; add if absent, contains scans chain

---

## Why the Approach Works

Same collision model as HashMap without value storage.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Hashing |
| Secondary | Array |

### Pattern Recognition Clues

- Unique keys only
- add/contains/remove API

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Boolean array if bounded key range.

---

## Critical Implementation Details

- Skip add if exists
- Remove specific node from chain

---

## Edge Cases

- add duplicate no-op
- contains missing false

---

## Common Mistakes

- Always appending duplicates
- Wrong bucket index

---

## Complexity

| | |
|--|--|
| Time | O(1) average |
| Space | O(n) |

---

## Similar Problems

- [design-hashmap](../design-hashmap/README.md)
- [duplicate-integer](../duplicate-integer/README.md)

---

## One-line Takeaway

**HashSet = HashMap without values; check before add.**

---

## Revision Checklist

- [ ] Dedup on add
- [ ] Chain removal

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-0 |
