# Subarray Sum Equals K

| Field | Value |
|-------|-------|
| Topic | Prefix Sum |
| Difficulty | Medium |
| Primary Pattern | Prefix Sum |
| Secondary Pattern | Hashing |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `subarray-sum-equals-k`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Subarray sum i..j = prefix[j]-prefix[i-1]; need prior prefix sum-k count.

---

## Thinking Process

1. map{0:1} sum=0 ans=0
2. Add num to sum
3. ans += map.get(sum-k)
4. map[sum]++

**Best understanding:** Running sum; count map of prefix sums; add map.get(sum-k)

---

## Why the Approach Works

Hash of prefix frequencies counts all starts giving target subarray ending here.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Prefix Sum |
| Secondary | Hashing |

### Pattern Recognition Clues

- Count subarrays sum k
- Includes negatives

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Prefix array brute O(n²).

---

## Critical Implementation Details

- Initialize 0:1 for empty prefix
- Add to ans before or after update consistently

---

## Edge Cases

- k=0 empty subarrays
- All negatives

---

## Common Mistakes

- Forgetting map 0:1
- Using only positive window

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(n) |

---

## Similar Problems

- [minimum-size-subarray-sum](../minimum-size-subarray-sum/README.md)
- [range-sum-query-2d-immutable](../range-sum-query-2d-immutable/README.md)

---

## One-line Takeaway

**Count subarrays sum k → prefix sum + hashmap of counts.**

---

## Revision Checklist

- [ ] map 0:1
- [ ] sum-k lookup

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-1 |
