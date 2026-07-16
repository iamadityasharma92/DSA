# Remove Element

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

Interview problem `remove-element`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Filter val in-place by overwriting valid elements at front.

---

## Thinking Process

1. k=0 scan i
2. If nums[i]!=val nums[k++]=nums[i]
3. Return k
4. Tail ignored

**Best understanding:** write index; copy nums[i] when nums[i]!=val

---

## Why the Approach Works

Single pass compaction without caring about removed tail order.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Two Pointers |
| Secondary | Array |

### Pattern Recognition Clues

- Remove all occurrences val
- Return new length

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Two pointers swap-from-end variant.

---

## Critical Implementation Details

- k is next write position
- Order preserved for kept elems

---

## Edge Cases

- val not present
- All elements val k=0

---

## Common Mistakes

- Decrementing wrong on match
- Returning array not k

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) |

---

## Similar Problems

- [remove-duplicates-from-sorted-array](../remove-duplicates-from-sorted-array/README.md)
- [sort-colors](../sort-colors/README.md)

---

## One-line Takeaway

**Remove val in-place → write pointer on !=val.**

---

## Revision Checklist

- [ ] k write idx
- [ ] skip equals val

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-1 |
