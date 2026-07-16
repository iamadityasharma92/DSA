# Longest Substring Without Duplicates

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

Interview problem `longest-substring-without-duplicates`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Window unique while last occurrence of char inside window forces left jump.

---

## Thinking Process

1. l=0 scan r
2. If char seen and index ≥ l set l=last+1
3. Update last index
4. max = max(max,r-l+1)

**Best understanding:** Map char→index; shrink l past last duplicate; track max r-l+1

---

## Why the Approach Works

Jumping l past duplicate restores uniqueness in O(1).

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Sliding Window |
| Secondary | Hashing |

### Pattern Recognition Clues

- Longest unique substring
- Sliding window classic

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Set window eviction—similar.

---

## Critical Implementation Details

- Only shrink if last index inside window
- Update index after check

---

## Edge Cases

- All same char length 1
- Empty string

---

## Common Mistakes

- Always setting l=last+1 even if outside window
- Forgetting max update

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(min(n,alphabet)) |

---

## Similar Problems

- [permutation-string](../permutation-string/README.md)
- [contains-duplicate-ii](../contains-duplicate-ii/README.md)

---

## One-line Takeaway

**Longest unique substring → map last index + conditional l jump.**

---

## Revision Checklist

- [ ] last index map
- [ ] l jump if inside

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-1 |
