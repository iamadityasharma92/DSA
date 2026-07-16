# Remove Duplicates from Sorted Array

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

Interview problem `remove-duplicates-from-sorted-array`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Sorted duplicates group together—compare to last written unique.

---

## Thinking Process

1. write=1
2. i from 1: if nums[i]!=nums[write-1] nums[write++]=nums[i]
3. Return write
4. In-place overwrite front

**Best understanding:** write pointer places nums[i] if nums[i]!=nums[write-1]; return write

---

## Why the Approach Works

Sorted order lets O(n) unique compaction without extra space.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Two Pointers |
| Secondary | Array |

### Pattern Recognition Clues

- Sorted array unique prefix
- Return k not full array

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

HashSet—breaks order.

---

## Critical Implementation Details

- Compare to write-1 not i-1 always
- write starts 1 if non-empty

---

## Edge Cases

- Empty length 0
- All unique write=n

---

## Common Mistakes

- Using set on sorted
- Wrong compare index

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

**Sorted dedup → write pointer vs last placed.**

---

## Revision Checklist

- [ ] write pointer
- [ ] compare write-1

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-0 |
