# Majority Element II

| Field | Value |
|-------|-------|
| Topic | Arrays & Hashing |
| Difficulty | Medium |
| Primary Pattern | Boyer-Moore Voting |
| Secondary Pattern | Hashing |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `majority-element-ii`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

At most two elements can exceed n/3—extended Boyer-Moore finds candidates.

---

## Thinking Process

1. Two cand slots with counts
2. Third distinct cancels both counts
3. Recount cand1/cand2 frequencies
4. Add if count > n/3

**Best understanding:** Two candidates with dual voting; verify counts > n/3

---

## Why the Approach Works

Pigeonhole limits majors to two; verification filters false candidates.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Boyer-Moore Voting |
| Secondary | Hashing |

### Pattern Recognition Clues

- Elements > n/3
- O(1) space

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

HashMap frequency threshold scan.

---

## Critical Implementation Details

- Must verify after voting phase
- Cancel logic with two slots

---

## Edge Cases

- No elements > n/3 empty result
- One element > n/3

---

## Common Mistakes

- Skipping verification pass
- Using single-candidate BM

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) |

---

## Similar Problems

- [majority-element](../majority-element/README.md)
- [top-k-elements-in-list](../top-k-elements-in-list/README.md)

---

## One-line Takeaway

**> n/3 majors → two-slot Boyer-Moore + verify.**

---

## Revision Checklist

- [ ] Dual candidates
- [ ] Recount threshold

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-2 |
