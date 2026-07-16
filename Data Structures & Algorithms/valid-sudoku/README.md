# Valid Sudoku

| Field | Value |
|-------|-------|
| Topic | Arrays & Hashing |
| Difficulty | Medium |
| Primary Pattern | Hashing |
| Secondary Pattern | Matrix |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `valid-sudoku`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Each filled cell must be unique in its row, column, and box index r/3*3+c/3.

---

## Thinking Process

1. 9 row sets 9 col sets 9 box sets
2. Skip dots
3. If digit in any set false
4. Add to all three sets

**Best understanding:** Sets per row, col, and 3x3 box; reject duplicate digit in any unit

---

## Why the Approach Works

Hash sets give O(1) duplicate detection per constraint unit.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Hashing |
| Secondary | Matrix |

### Pattern Recognition Clues

- Partial board validation
- 3x3 box indexing

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Bitmasks per unit—same idea.

---

## Critical Implementation Details

- box index = (r/3)*3 + c/3
- Only validate filled cells

---

## Edge Cases

- Empty board true
- Duplicates same row

---

## Common Mistakes

- Wrong box index formula
- Validating empty as duplicate

---

## Complexity

| | |
|--|--|
| Time | O(81) |
| Space | O(81) |

---

## Similar Problems

- [is-anagram](../is-anagram/README.md)
- [string-encode-and-decode](../string-encode-and-decode/README.md)

---

## One-line Takeaway

**Sudoku valid → row/col/box hash sets per digit.**

---

## Revision Checklist

- [ ] box index
- [ ] three sets

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-0 |
