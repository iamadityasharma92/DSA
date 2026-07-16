# Find Duplicate Integer

| Field | Value |
|-------|-------|
| Topic | Arrays & Hashing |
| Difficulty | Medium |
| Primary Pattern | Floyd Cycle Detection |
| Secondary Pattern | Two Pointers |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `find-duplicate-integer`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Values 1..n and n+1 cells imply index cycle—duplicate is cycle start.

---

## Thinking Process

1. Phase 1: slow/fast until meet
2. Phase 2: reset slow2, advance both 1 step
3. Meeting point is duplicate
4. O(1) space no mutation

**Best understanding:** Treat array as linked list nums[i]→i; Floyd finds cycle entry = duplicate

---

## Why the Approach Works

Each index points to next index; duplicate value creates indegree 2 → cycle entry.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Floyd Cycle Detection |
| Secondary | Two Pointers |

### Pattern Recognition Clues

- n+1 integers in [1,n]
- O(1) extra space required

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Mark negatives in-place or binary search on value range.

---

## Critical Implementation Details

- Advance slow=nums[slow], fast=nums[nums[fast]]
- Phase 2 both move one step

---

## Edge Cases

- Duplicate at index 0 path
- Single duplicate guaranteed

---

## Common Mistakes

- Using HashSet when O(1) space asked
- Mutating array when forbidden

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) |

---

## Similar Problems

- [linked-list-cycle-detection](../linked-list-cycle-detection/README.md)
- [duplicate-integer](../duplicate-integer/README.md)

---

## One-line Takeaway

**1..n duplicate with O(1) space → Floyd on index-linked list.**

---

## Revision Checklist

- [ ] Two-phase Floyd
- [ ] nums[i] as next pointer

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-4 |
