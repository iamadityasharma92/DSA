# First Missing Positive

| Field | Value |
|-------|-------|
| Topic | Arrays & Hashing |
| Difficulty | Hard |
| Primary Pattern | Index as Hash |
| Secondary Pattern | Array |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `first-missing-positive`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Answer lies in [1,n+1]; only values 1..n matter for marking.

---

## Thinking Process

1. Ignore non-positive and >n
2. Mark seen i at index i-1
3. Scan for first unmarked → i+1
4. All marked → n+1

**Best understanding:** Boolean/mark presence for values in [1,n]; scan for first missing

---

## Why the Approach Works

Pigeonhole: missing positive must be in 1..n+1; in-place marks O(1) space.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Index as Hash |
| Secondary | Array |

### Pattern Recognition Clues

- O(1) extra space
- Unsorted integers

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

HashSet of positives—O(n) space.

---

## Critical Implementation Details

- Only mark 1..n range
- Preserve sign or use swap-to-place

---

## Edge Cases

- All negatives → 1
- Permutation 1..n → n+1

---

## Common Mistakes

- Using O(n) HashSet when space constrained
- Marking wrong indices

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) |

---

## Similar Problems

- [duplicate-integer](../duplicate-integer/README.md)
- [find-duplicate-integer](../find-duplicate-integer/README.md)

---

## One-line Takeaway

**First missing positive → mark presence in [1,n] using array indices.**

---

## Revision Checklist

- [ ] Filter to 1..n
- [ ] Scan marks

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-3 |
