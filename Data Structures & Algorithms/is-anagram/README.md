# Is Anagram

| Field | Value |
|-------|-------|
| Topic | Arrays & Hashing |
| Difficulty | Easy |
| Primary Pattern | Hashing |
| Secondary Pattern | Sorting |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `is-anagram`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Equal multisets of characters iff frequency counts match.

---

## Thinking Process

1. Length mismatch → false
2. Count chars in s and t
3. Compare freq arrays
4. All zeros true

**Best understanding:** Freq array size 26; increment s decrement t; all zero → anagram

---

## Why the Approach Works

Character counts fully describe anagram equivalence.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Hashing |
| Secondary | Sorting |

### Pattern Recognition Clues

- Reorder letters
- Same letters same counts

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Sort both strings compare—O(n log n).

---

## Critical Implementation Details

- Length check first
- Lowercase a-z fixed alphabet

---

## Edge Cases

- Empty strings
- Single char

---

## Common Mistakes

- Only checking length
- Unicode vs 26-letter assumption

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) alphabet |

---

## Similar Problems

- [permutation-string](../permutation-string/README.md)
- [valid-sudoku](../valid-sudoku/README.md)

---

## One-line Takeaway

**Anagram → 26-count diff zero.**

---

## Revision Checklist

- [ ] Length equal
- [ ] Freq cancel

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-0 |
