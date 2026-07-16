# Longest Repeating Substring with Replacement

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

Interview problem `longest-repeating-substring-with-replacement`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Window valid if non-dominant chars ≤ k replacements.

---

## Thinking Process

1. Freq array + maxFreq in window
2. Expand r, update maxFreq
3. While (r-l+1)-maxFreq > k shrink l
4. ans = max window size

**Best understanding:** Expand r; while windowLen - maxFreq > k shrink l; track max window

---

## Why the Approach Works

maxFreq char needs no replacements; others fill k budget.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Sliding Window |
| Secondary | Hashing |

### Pattern Recognition Clues

- At most k changes
- Longest substring

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Recompute maxFreq each shrink—slower but safe.

---

## Critical Implementation Details

- Validity: length - maxFreq ≤ k
- maxFreq only increases—lazy shrink ok

---

## Edge Cases

- k=0 reduces to all same char
- k >= length always full string

---

## Common Mistakes

- Recomputing maxFreq every shrink unnecessarily
- Wrong validity formula

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) alphabet |

---

## Similar Problems

- [longest-substring-without-duplicates](../longest-substring-without-duplicates/README.md)
- [minimum-window-with-characters](../minimum-window-with-characters/README.md)

---

## One-line Takeaway

**K replacements window → len - maxFreq ≤ k.**

---

## Revision Checklist

- [ ] maxFreq tracking
- [ ] Shrink when invalid

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-2 |
