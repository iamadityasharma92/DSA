# Merge Strings Alternately

| Field | Value |
|-------|-------|
| Topic | Two Pointers |
| Difficulty | Easy |
| Primary Pattern | Two Pointers |
| Secondary Pattern | String |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `merge-strings-alternately`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Interleave characters until one string exhausted then tail the rest.

---

## Thinking Process

1. i=0 while i<len1 and i<len2
2. Append both chars
3. Append word1 or word2 leftover
4. Return built string

**Best understanding:** Append word1[i] and word2[i] while both exist; append remainder

---

## Why the Approach Works

Alternation is local merge of two sequences.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Two Pointers |
| Secondary | String |

### Pattern Recognition Clues

- Zip two strings
- Unequal lengths

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Queue chars from both.

---

## Critical Implementation Details

- Handle different lengths
- Order word1 before word2 each step

---

## Edge Cases

- One empty returns other
- Same length only alternation

---

## Common Mistakes

- Index out of bounds
- Wrong alternation order

---

## Complexity

| | |
|--|--|
| Time | O(m+n) |
| Space | O(m+n) output |

---

## Similar Problems

- [concatenation-of-array](../concatenation-of-array/README.md)
- [merge-sorted-array](../merge-sorted-array/README.md)

---

## One-line Takeaway

**Alternate merge → dual index until one ends, append rest.**

---

## Revision Checklist

- [ ] Both indices
- [ ] Tail append

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-1 |
