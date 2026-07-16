# Concatenation of Array

| Field | Value |
|-------|-------|
| Topic | Arrays & Hashing |
| Difficulty | Easy |
| Primary Pattern | Array Traversal |
| Secondary Pattern | Simulation |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `concatenation-of-array`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Concatenation duplicates the full array back-to-back.

---

## Thinking Process

1. Allocate ans[2n]
2. Copy nums to indices 0..n-1
3. Copy nums to indices n..2n-1
4. Return ans

**Best understanding:** Result length 2n; copy nums twice into ans

---

## Why the Approach Works

Definition requires identical sequence twice in order.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Array Traversal |
| Secondary | Simulation |

### Pattern Recognition Clues

- Output length 2n
- Same order repeated

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Append nums to itself via list—same O(n).

---

## Critical Implementation Details

- Preserve order
- Size exactly 2n

---

## Edge Cases

- n = 1
- Large n still linear

---

## Common Mistakes

- Index off-by-one
- Mutating input only

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(n) |

---

## Similar Problems

- [merge-strings-alternately](../merge-strings-alternately/README.md)
- [merge-sorted-array](../merge-sorted-array/README.md)

---

## One-line Takeaway

**Warm-up copy—confirm indexing before harder array work.**

---

## Revision Checklist

- [ ] 2n output
- [ ] Two identical passes

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-1 |
