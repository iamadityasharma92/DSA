# Minimum Size Subarray Sum

| Field | Value |
|-------|-------|
| Topic | Sliding Window |
| Difficulty | Medium |
| Primary Pattern | Sliding Window |
| Secondary Pattern | Two Pointers |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `minimum-size-subarray-sum`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Positive nums → expanding sum monotonic; shrink when valid to minimize.

---

## Thinking Process

1. l=0,sum=0
2. Add nums[r], r++
3. While sum≥target update min, subtract nums[l], l++
4. Return min or 0

**Best understanding:** Expand r adding sum; while sum≥target shrink l tracking min length

---

## Why the Approach Works

Two pointers capture all minimal valid windows without restart.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Sliding Window |
| Secondary | Two Pointers |

### Pattern Recognition Clues

- Subarray sum at least target
- Positive integers

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Prefix sum + BS per index.

---

## Critical Implementation Details

- Positive nums required for shrink logic
- Update min inside while valid

---

## Edge Cases

- No valid window 0
- Single element equals target

---

## Common Mistakes

- Using on negative numbers
- Not shrinking enough

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) |

---

## Similar Problems

- [minimum-window-with-characters](../minimum-window-with-characters/README.md)
- [subarray-sum-equals-k](../subarray-sum-equals-k/README.md)

---

## One-line Takeaway

**Min len subarray ≥ target (positive) → shrinkable sliding window.**

---

## Revision Checklist

- [ ] Expand then shrink
- [ ] Track min len

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-1 |
