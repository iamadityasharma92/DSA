# Permutation String

| Field | Value |
|-------|-------|
| Topic | Sliding Window |
| Difficulty | Medium |
| Primary Pattern | Sliding Window |
| Secondary Pattern | Hashing |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `permutation-string`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Permutation equals identical multiset—fixed window frequency equality test.

---

## Thinking Process

1. Build c1 from s1
2. Initial window c2 size n1
3. Slide: if match return true
4. Shrink left increment right updating c2

**Best understanding:** Fixed window len s1 on s2; freq arrays match → true

---

## Why the Approach Works

Constant alphabet makes full freq compare O(26) per step.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Sliding Window |
| Secondary | Hashing |

### Pattern Recognition Clues

- s2 contains perm of s1
- Fixed window length

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Sort substrings—slow.

---

## Critical Implementation Details

- Window size exactly len(s1)
- Check last window after loop

---

## Edge Cases

- s2 shorter false
- All same char

---

## Common Mistakes

- Variable window wrong
- Missing final match check

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) alphabet |

---

## Similar Problems

- [minimum-window-with-characters](../minimum-window-with-characters/README.md)
- [is-anagram](../is-anagram/README.md)

---

## One-line Takeaway

**Permutation in s2 → fixed window freq match.**

---

## Revision Checklist

- [ ] len(s1) window
- [ ] matches() helper

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-7 |
