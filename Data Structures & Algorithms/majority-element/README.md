# Majority Element

| Field | Value |
|-------|-------|
| Topic | Arrays & Hashing |
| Difficulty | Easy |
| Primary Pattern | Boyer-Moore Voting |
| Secondary Pattern | Hashing |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `majority-element`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Majority survives pairing cancellation—Boyer-Moore finds candidate O(1) space.

---

## Thinking Process

1. count=0,cand=null
2. Same as cand count++ else count--
3. count 0 pick new cand
4. Return cand

**Best understanding:** Candidate vote +/-; final candidate is majority given guarantee

---

## Why the Approach Works

Majority element outvotes all others in cancel pairing.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Boyer-Moore Voting |
| Secondary | Hashing |

### Pattern Recognition Clues

- > n/2 frequency guaranteed
- O(1) space

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Hash count or sort middle—extra space/time.

---

## Critical Implementation Details

- Guarantee avoids recount
- Reset cand when count 0

---

## Edge Cases

- All same element
- Two elements

---

## Common Mistakes

- Running without majority guarantee
- Off-by-one n/2 threshold

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) |

---

## Similar Problems

- [majority-element-ii](../majority-element-ii/README.md)
- [duplicate-integer](../duplicate-integer/README.md)

---

## One-line Takeaway

**Majority > n/2 → Boyer-Moore vote cancel.**

---

## Revision Checklist

- [ ] count/cand loop
- [ ] Guaranteed majority

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-0 |
