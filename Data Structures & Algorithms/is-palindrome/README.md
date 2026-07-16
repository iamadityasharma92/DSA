# Is Palindrome

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

Interview problem `is-palindrome`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Palindrome reads same forward/back on processed alphanumeric chars.

---

## Thinking Process

1. Two pointers inward
2. Skip non-alphanumeric
3. tolower compare
4. Mismatch → false

**Best understanding:** l=0, r=n-1; skip non-alphanumeric; compare lowercased chars

---

## Why the Approach Works

Only relevant chars matter; two pointers check symmetry O(n).

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Two Pointers |
| Secondary | String |

### Pattern Recognition Clues

- Phrase palindrome ignoring punctuation
- Case insensitive

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Reverse cleaned string.

---

## Critical Implementation Details

- Character classification
- Move pointers past junk

---

## Edge Cases

- Empty after clean
- All symbols → true

---

## Common Mistakes

- Not skipping symbols
- Case-sensitive compare

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) |

---

## Similar Problems

- [valid-palindrome-ii](../valid-palindrome-ii/README.md)
- [reverse-string](../reverse-string/README.md)

---

## One-line Takeaway

**String palindrome → two pointers skip non-alnum, lowercase compare.**

---

## Revision Checklist

- [ ] Skip junk
- [ ] Case fold

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-1 |
