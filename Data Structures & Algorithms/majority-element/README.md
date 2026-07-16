# Majority Element

| Field | Value |
|-------|-------|
| Topic | Arrays & Hashing |
| Difficulty | Easy |
| Primary Pattern | Boyer-Moore Voting Algorithm |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given an array of size `n`, return the element that appears more than `n/2` times. Guaranteed to exist.

---

## Constraints (typical)

- `n ≥ 1`
- Majority element always exists
- Must be O(n) time, O(1) space (ideal)

---

## Brute Force

Sort → middle element is majority → O(n log n). HashMap count → O(n) time, O(n) space.

---

## Core Observation

**Boyer-Moore Voting:** track a candidate and a count. When count reaches 0, switch candidate to the current element. If the current element matches candidate, increment count; else decrement. The true majority element survives all cancellations because it appears > n/2 times.

---

## Thinking Process

1. `cand = nums[0]`, `count = 1`.
2. For `i = 1` to `n-1`:
   - If `nums[i] == cand` → `count++`
   - Else `count--`
   - If `count == 0` → `cand = nums[i]`, `count = 1`
3. Return `cand`.

---

## Why the Approach Works

Each "vote cancellation" between the majority and minority elements costs the majority at most one vote. Since majority appears > n/2 times, it has more votes than the sum of all others combined, so it survives as `cand`.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Boyer-Moore Voting |
| Upgrade | `majority-element-ii`: > n/3 → two candidates |

### Pattern Recognition Clues

- "Majority element (> n/2), O(1) space"

Cross-ref: [Arrays & Hashing](../Arrays%20%26%20Hashing/README.md)

---

## Alternative Approaches

Sort → return `nums[n/2]` — O(n log n).  
HashMap → O(n) time, O(n) space.

---

## Critical Implementation Details

- Reset with `count = 1` (not 0) when switching candidate — the new candidate includes the current element
- The outer `else if (cand != nums[i])` and inner `count == 0` reset can be ordered in multiple ways; key is: zero count → new candidate takes over

---

## Edge Cases

- Single element → return it
- All same → return it
- Two distinct values → majority wins

---

## Common Mistakes

- Resetting `count = 0` instead of `1` when switching (off-by-one, misses counting the new candidate itself)
- Forgetting that result is guaranteed — no need to validate the candidate

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) |

---

## Similar Problems

- [majority-element-ii](../majority-element-ii/README.md) — extended Boyer-Moore for > n/3 threshold

---

## One-line Takeaway

**Boyer-Moore: vote for candidate; cancel on mismatch; when count=0, switch candidate.**

---

## Revision Checklist

- [ ] Why does Boyer-Moore work? (Vote cancellation argument)
- [ ] What happens when count reaches 0?
- [ ] Why guaranteed: no validation pass needed?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0.java` |
