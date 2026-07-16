# Sort Colors

| Field | Value |
|-------|-------|
| Topic | Two Pointers |
| Difficulty | Medium |
| Primary Pattern | Dutch National Flag |
| Secondary Pattern | Two Pointers |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `sort-colors`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Three-way partition in one pass with unknown middle region mid..r.

---

## Thinking Process

1. l=0,r=n-1,i=0
2. 0→swap l++, 2→swap r-- no i++
3. 1→i++
4. Until i>r

**Best understanding:** l,mid,r pointers; 0 swap to l, 2 swap to r, 1 advance mid

---

## Why the Approach Works

Invariant: [0,l) zeros, [l,i) ones, (r,n) twos.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Dutch National Flag |
| Secondary | Two Pointers |

### Pattern Recognition Clues

- Array of 0/1/2 only
- One-pass in-place

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Counting sort two passes O(n).

---

## Critical Implementation Details

- Don't i++ after swapping 2—recheck new i
- i<=r loop

---

## Edge Cases

- All one color
- Single element

---

## Common Mistakes

- i++ on 2 swap skipping unsorted
- Wrong pointer roles

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) |

---

## Similar Problems

- [remove-element](../remove-element/README.md)
- [merge-sorted-array](../merge-sorted-array/README.md)

---

## One-line Takeaway

**0/1/2 sort → Dutch flag l/i/r three-way partition.**

---

## Revision Checklist

- [ ] 0 left 2 right
- [ ] careful i on swap 2

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-3 |
