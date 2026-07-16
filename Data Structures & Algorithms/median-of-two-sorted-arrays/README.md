# Median of Two Sorted Arrays

| Field | Value |
|-------|-------|
| Topic | Binary Search |
| Difficulty | Hard |
| Primary Pattern | Binary Search Partition |
| Secondary Pattern | Two Pointers |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `median-of-two-sorted-arrays`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Correct partition splits combined sorted halves of equal total left count.

---

## Thinking Process

1. Ensure nums1 is shorter
2. BS mid1 on nums1, mid2 derived
3. Check l1≤r2 and l2≤r1
4. Even: avg max left min right; odd max left

**Best understanding:** BS partition on smaller array; left halves ≤ right halves; median from boundary vals

---

## Why the Approach Works

Partition invariant equals merged order without full merge.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Binary Search Partition |
| Secondary | Two Pointers |

### Pattern Recognition Clues

- Two sorted arrays median
- O(log min(m,n))

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Merge arrays O(m+n)—too slow.

---

## Critical Implementation Details

- Use MIN/MAX sentinels for empty halves
- mid2 = (m+n+1)/2 - mid1

---

## Edge Cases

- One array empty
- Odd/even total length

---

## Common Mistakes

- BS on wrong array size
- Wrong even median formula

---

## Complexity

| | |
|--|--|
| Time | O(log min(m,n)) |
| Space | O(1) |

---

## Similar Problems

- [find-k-closest-elements](../find-k-closest-elements/README.md)
- [merge-two-sorted-linked-lists](../merge-two-sorted-linked-lists/README.md)

---

## One-line Takeaway

**Two-array median → partition BS on smaller array.**

---

## Revision Checklist

- [ ] Partition balance
- [ ] Boundary max/min

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-5 |
