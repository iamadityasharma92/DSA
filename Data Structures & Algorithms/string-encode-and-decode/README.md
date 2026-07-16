# String Encode and Decode

| Field | Value |
|-------|-------|
| Topic | Arrays & Hashing |
| Difficulty | Medium |
| Primary Pattern | Encoding |
| Secondary Pattern | String |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `string-encode-and-decode`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Delimiter must not appear in length prefix scheme—length#payload is unambiguous.

---

## Thinking Process

1. encode: append len+'#'+str for each
2. decode: read digits until #
3. Read next len chars as string
4. Repeat until end

**Best understanding:** Length#delimiter encoding per string; decode reads len then exact chars

---

## Why the Approach Works

Length prefix tells exactly how many chars follow avoiding delimiter collisions.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Encoding |
| Secondary | String |

### Pattern Recognition Clues

- Serialize string list
- Handles any characters including delimiters

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Escape delimiters—fragile.

---

## Critical Implementation Details

- Parse length before #
- Substring exact len after #

---

## Edge Cases

- Empty list
- Empty strings in list

---

## Common Mistakes

- Using comma join without escaping
- Wrong length parse

---

## Complexity

| | |
|--|--|
| Time | O(total chars) |
| Space | O(encoded size) |

---

## Similar Problems

- [merge-strings-alternately](../merge-strings-alternately/README.md)
- [valid-sudoku](../valid-sudoku/README.md)

---

## One-line Takeaway

**Encode string list → length#payload chunks.**

---

## Revision Checklist

- [ ] len#format
- [ ] parse length first

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-1 |
