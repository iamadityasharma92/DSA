# Design Circular Queue

| Field | Value |
|-------|-------|
| Topic | Design |
| Difficulty | Medium |
| Primary Pattern | Array Circular Buffer |
| Secondary Pattern | Queue |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `design-circular-queue`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Wrap indices with modulo; count disambiguates full vs empty when head==tail.

---

## Thinking Process

1. Array[k], head, tail, count
2. Enqueue: write tail, tail=(tail+1)%k, count++
3. Dequeue: read head, head=(head+1)%k, count--
4. isFull count==k, isEmpty count==0

**Best understanding:** Fixed array, head/tail modulo k, size counter for full/empty

---

## Why the Approach Works

Circular reuse with O(1) ops; size avoids ambiguous head==tail.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Array Circular Buffer |
| Secondary | Queue |

### Pattern Recognition Clues

- Bounded queue
- Wraparound indices

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Linked list with capacity cap.

---

## Critical Implementation Details

- Modulo on advance
- Count tracks occupancy

---

## Edge Cases

- Enqueue when full false
- Dequeue empty -1

---

## Common Mistakes

- head==tail for both states
- Modulo off-by-one

---

## Complexity

| | |
|--|--|
| Time | O(1) per op |
| Space | O(k) |

---

## Similar Problems

- [implement-queue-using-stacks](../implement-queue-using-stacks/README.md)
- [design-hashmap](../design-hashmap/README.md)

---

## One-line Takeaway

**Circular queue = modulo indices + size counter.**

---

## Revision Checklist

- [ ] Mod wrap
- [ ] Count full/empty

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-0 |
