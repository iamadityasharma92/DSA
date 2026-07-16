# Duplicate Integer

| Field | Value |
|-------|-------|
| Topic | Arrays & Hashing |
| Difficulty | Easy |
| Primary Pattern | Hashing |
| Secondary Pattern | Array |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `duplicate-integer`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

First repeated insertion proves duplicate exists.

---

## Thinking Process

1. Iterate nums
2. Try set.add
3. add returns false → duplicate
4. Finish → false

**Best understanding:** HashSet; if !set.add(num) return true

---

## Why the Approach Works

Set enforces uniqueness in O(1) average per check.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Hashing |
| Secondary | Array |

### Pattern Recognition Clues

- Any value appears twice
- Return boolean

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Sort then adjacent compare—O(n log n).

---

## Critical Implementation Details

- Use add return value
- Early exit on hit

---

## Edge Cases

- All unique
- Two elements same

---

## Common Mistakes

- Only checking contains not add
- Sorting when O(n) hash works

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(n) |

---

## Similar Problems

- [contains-duplicate-ii](../contains-duplicate-ii/README.md)
- [find-duplicate-integer](../find-duplicate-integer/README.md)

---

## One-line Takeaway

**Any duplicate detection → HashSet add return false.**

---

## Revision Checklist

- [ ] set.add shortcut
- [ ] Early return

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-0 |
