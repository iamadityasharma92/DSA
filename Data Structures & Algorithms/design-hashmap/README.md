# Design HashMap

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

Interview problem `design-hashmap`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Hash to bucket; collisions resolved by linked lists per bucket.

---

## Thinking Process

1. Buckets array size M
2. idx = key % M
3. put upserts in chain
4. get/remove scan chain

**Best understanding:** Bucket array with chaining for put/get/remove

---

## Why the Approach Works

Average O(1) with chaining under reasonable load.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Hashing |
| Secondary | Array |

### Pattern Recognition Clues

- Implement map API
- Integer keys

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Open addressing linear probe.

---

## Critical Implementation Details

- Upsert on duplicate key
- Handle missing key

---

## Edge Cases

- put updates value
- get missing -1

---

## Common Mistakes

- Negative key modulo bug
- Append duplicate keys

---

## Complexity

| | |
|--|--|
| Time | O(1) average |
| Space | O(n) |

---

## Similar Problems

- [design-hashset](../design-hashset/README.md)
- [lru-cache](../lru-cache/README.md)

---

## One-line Takeaway

**Design HashMap = buckets + chaining + upsert.**

---

## Revision Checklist

- [ ] Hash bucket
- [ ] Chain scan

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-0 |
