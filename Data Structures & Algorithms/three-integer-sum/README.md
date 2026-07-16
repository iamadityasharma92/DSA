# Three Integer Sum

| Field | Value |
|-------|-------|
| Topic | Two Pointers |
| Difficulty | Medium |
| Primary Pattern | Two Pointers |
| Secondary Pattern | Sorting |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `three-integer-sum`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

3Sum reduces to 2Sum on sorted tail with duplicate avoidance.

---

## Thinking Process

1. Sort array
2. For each i if i>0 and dup skip
3. l=i+1,r=n-1 target=-nums[i]
4. Move pointers record triplets skip dups

**Best understanding:** Sort; fix i; two-pointer lo/hi on rest for sum zero; skip duplicates

---

## Why the Approach Works

Sorting enables two-pointer O(n²) vs O(n³) brute.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Two Pointers |
| Secondary | Sorting |

### Pattern Recognition Clues

- Triple sum zero
- Return unique triplets

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

HashMap for two-sum complement per i.

---

## Critical Implementation Details

- Skip duplicate i,l,r
- Sort prerequisite

---

## Edge Cases

- Fewer than 3 elements
- All zeros one triplet

---

## Common Mistakes

- Not skipping duplicate triplets
- Wrong pointer movement

---

## Complexity

| | |
|--|--|
| Time | O(n²) |
| Space | O(1) extra |

---

## Similar Problems

- [two-integer-sum](../two-integer-sum/README.md)
- [two-integer-sum-ii](../two-integer-sum-ii/README.md)

---

## One-line Takeaway

**3Sum → sort + fix one + two-pointer with dup skip.**

---

## Revision Checklist

- [ ] sort first
- [ ] skip duplicates

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-1 |
