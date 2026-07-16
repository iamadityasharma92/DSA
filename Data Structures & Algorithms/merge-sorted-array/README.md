# Merge Sorted Array

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

Interview problem `merge-sorted-array`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Backward merge avoids overwriting unprocessed nums1 elements.

---

## Thinking Process

1. i=m-1,j=n-1,k=m+n-1
2. Place larger at k, decrement pointers
3. Drain nums2 remainder
4. nums1 already in place if i remains

**Best understanding:** Fill from end: compare nums1[i] vs nums2[j] place larger at write k

---

## Why the Approach Works

Tail fill preserves untouched prefix of nums1 during merge.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Two Pointers |
| Secondary | Array |

### Pattern Recognition Clues

- In-place merge into nums1 with extra space at end
- Both sorted

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Forward merge with extra buffer—needs O(m) space.

---

## Critical Implementation Details

- Write from back
- Handle nums2 leftovers

---

## Edge Cases

- nums2 empty
- All nums2 larger

---

## Common Mistakes

- Forward merge overwrite
- Forgetting nums2 tail

---

## Complexity

| | |
|--|--|
| Time | O(m+n) |
| Space | O(1) |

---

## Similar Problems

- [merge-two-sorted-linked-lists](../merge-two-sorted-linked-lists/README.md)
- [merge-strings-alternately](../merge-strings-alternately/README.md)

---

## One-line Takeaway

**Merge into nums1 → backward two pointers from end.**

---

## Revision Checklist

- [ ] Fill from rear
- [ ] Drain nums2

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-2 |
