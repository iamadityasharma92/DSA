# Reverse String

| Field | Value |
|-------|-------|
| Topic | Two Pointers |
| Difficulty | Easy |
| Primary Pattern | Two Pointers |
| Secondary Pattern | Array |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `reverse-string`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

In-place char array reversal via symmetric swaps.

---

## Thinking Process

1. l=0,r=n-1
2. Swap chars
3. l++,r--
4. Stop when l>=r

**Best understanding:** Swap s[l] and s[r] inward until l>=r

---

## Why the Approach Works

Pairwise swap mirrors string around center O(n/2).

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Two Pointers |
| Secondary | Array |

### Pattern Recognition Clues

- Reverse char array in-place
- O(1) extra space

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

New char array from end.

---

## Critical Implementation Details

- In-place swap
- Stop at middle

---

## Edge Cases

- Length 1
- Palindrome unchanged

---

## Common Mistakes

- Off-by-one loop bounds
- Not in-place

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) |

---

## Similar Problems

- [is-palindrome](../is-palindrome/README.md)
- [valid-palindrome-ii](../valid-palindrome-ii/README.md)

---

## One-line Takeaway

**Reverse string → two-pointer swap inward.**

---

## Revision Checklist

- [ ] l r swap
- [ ] in-place

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-0 |
