# Minimum Window With Characters

| Field | Value |
|-------|-------|
| Topic | Sliding Window |
| Difficulty | Hard |
| Primary Pattern | Sliding Window |
| Secondary Pattern | Hashing |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `minimum-window-with-characters`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

need counter tracks required chars; valid when all needs met.

---

## Thinking Process

1. Build need freq for t
2. Expand r updating have/need
3. When valid shrink l record min
4. Return substring from best bounds

**Best understanding:** Expand until cover t; shrink while valid tracking smallest window

---

## Why the Approach Works

Shrink only while still covering minimizes window per right endpoint.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Sliding Window |
| Secondary | Hashing |

### Pattern Recognition Clues

- Smallest substring containing multiset of t
- Character counts

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Filter positions binary search—complex.

---

## Critical Implementation Details

- Track formed count vs required unique
- Update result on valid shrink

---

## Edge Cases

- t longer than s
- No window empty string

---

## Common Mistakes

- Not shrinking after valid
- Wrong have decrement

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) alphabet |

---

## Similar Problems

- [permutation-string](../permutation-string/README.md)
- [minimum-size-subarray-sum](../minimum-size-subarray-sum/README.md)

---

## One-line Takeaway

**Min window covering t → expand-cover then shrink-while-valid.**

---

## Revision Checklist

- [ ] need map
- [ ] shrink on valid

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-1 |
