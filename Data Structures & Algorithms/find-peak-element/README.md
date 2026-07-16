# Find Peak Element

| Field | Value |
|-------|-------|
| Topic | Binary Search |
| Difficulty | Medium |
| Primary Pattern | Binary Search |
| Secondary Pattern | Greedy Direction |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `find-peak-element`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Climb toward larger neighbor—guaranteed peak exists by boundary -∞.

---

## Thinking Process

1. l=0,r=n-1
2. If nums[mid]<nums[mid+1] l=mid+1
3. Else r=mid
4. Return l

**Best understanding:** BS: if nums[mid]<nums[mid+1] peak in right else peak in left incl mid

---

## Why the Approach Works

Ascending slope to the right means a peak exists on right side.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Binary Search |
| Secondary | Greedy Direction |

### Pattern Recognition Clues

- Any peak index
- nums[i] != nums[i+1]

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Linear scan O(n).

---

## Critical Implementation Details

- mid+1 must exist—r starts n-1
- Any peak acceptable

---

## Edge Cases

- Single element
- Strictly increasing—last peak

---

## Common Mistakes

- Requiring global maximum
- mid-1 compare off bounds

---

## Complexity

| | |
|--|--|
| Time | O(log n) |
| Space | O(1) |

---

## Similar Problems

- [find-in-mountain-array](../find-in-mountain-array/README.md)
- [find-minimum-in-rotated-sorted-array](../find-minimum-in-rotated-sorted-array/README.md)

---

## One-line Takeaway

**Find any peak → BS toward larger adjacent neighbor.**

---

## Revision Checklist

- [ ] Compare mid vs mid+1
- [ ] Return l

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-3 |
