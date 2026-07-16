# Reverse Linked List II

| Field | Value |
|-------|-------|
| Topic | Linked List |
| Difficulty | Medium |
| Primary Pattern | Linked List |
| Secondary Pattern | Pointers |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `reverse-linked-list-ii`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Partial reverse by standard flip within bounds then wire head/tail bridges.

---

## Thinking Process

1. Traverse to left predecessor
2. Reverse nodes left through right
3. Connect pred to new subhead
4. Attach old subhead tail to suffix

**Best understanding:** Reach node before left; reverse subsegment left..right; reconnect bridge

---

## Why the Approach Works

Isolated segment reversal preserves outside list order.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Linked List |
| Secondary | Pointers |

### Pattern Recognition Clues

- 1-indexed left right reverse
- Single sublist flip

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Array values reverse segment rebuild.

---

## Critical Implementation Details

- Save connections before reverse
- 1-based indexing conversion

---

## Edge Cases

- left=right single node
- Full list reverse

---

## Common Mistakes

- Off-by-one on 1-index
- Broken bridge pointers

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) |

---

## Similar Problems

- [reverse-a-linked-list](../reverse-a-linked-list/README.md)
- [reorder-linked-list](../reorder-linked-list/README.md)

---

## One-line Takeaway

**Reverse sublist → find pred, flip segment, reconnect.**

---

## Revision Checklist

- [ ] pred before left
- [ ] bridge ends

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-3 |
