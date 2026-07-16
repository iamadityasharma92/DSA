# Rotate Array

| Field | Value |
|-------|-------|
| Topic | Arrays & Hashing |
| Difficulty | Medium |
| Primary Pattern | Triple Reverse |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given an integer array `nums`, rotate it to the right by `k` steps in-place.

---

## Constraints (typical)

- `1 ≤ nums.length ≤ 10⁵`
- `0 ≤ k ≤ 10⁵`
- In-place, O(1) extra space

---

## Brute Force

Rotate one position at a time → O(n × k). Too slow.

---

## Core Observation

Rotating right by `k` is equivalent to three in-place reverses:
1. Reverse the entire array.
2. Reverse first `k` elements.
3. Reverse last `n-k` elements.

---

## Thinking Process

1. `k = k % n` (handle `k ≥ n`).
2. `reverse(nums, 0, n-1)` — reverse all.
3. `reverse(nums, 0, k-1)` — reverse first `k` (now at front).
4. `reverse(nums, k, n-1)` — reverse last `n-k`.

`submission-2` implements this with a helper `reverse(int[], l, r)`.

---

## Why the Approach Works

After the full reverse, the last `k` elements (which should be in front after rotation) are at the front — but in reversed order within that group. Reversing each group again produces the correct order.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Triple reverse for cyclic rotation |
| Foundation | reverse-string as the primitive operation |

### Pattern Recognition Clues

- "Rotate array in-place O(1) space"
- Think: what does rotating look like in reverse?

Cross-ref: [Arrays & Hashing](../Arrays%20%26%20Hashing/README.md)

---

## Alternative Approaches

**Extra array:** copy to `new_nums[(i + k) % n]` — O(n) space, O(n) time. Simple but violates O(1) space.

**Cyclic replacement:** follow the chain of element swaps → O(n) time, O(1) space. Complex to implement correctly.

---

## Critical Implementation Details

- `k = k % n` first — `k ≥ n` would cause out-of-bounds in `reverse(0, k-1)` if not reduced
- `n == 1` early return (though `k % n = 0` makes all reverses no-ops anyway)
- `reverse(0, k-1)` requires `k ≥ 1` after modulo (if `k = 0`, reverse on empty range is safe)

---

## Edge Cases

- `k = 0` → no rotation
- `k = n` → same as original (`k % n = 0`)
- `n = 1` → always unchanged

---

## Common Mistakes

- Forgetting `k = k % n` before reversing (wrong bounds for `reverse`)
- Wrong index ranges: first group `[0, k-1]`, second `[k, n-1]` (not `[k+1, n-1]`)

---

## Complexity

| | |
|--|--|
| Time | O(n) — three full-length passes |
| Space | O(1) |

---

## Similar Problems

- [reverse-string](../reverse-string/README.md) — the primitive reverse operation used here

---

## One-line Takeaway

**Rotate by k = reverse all → reverse [0,k-1] → reverse [k,n-1]; always `k = k%n` first.**

---

## Revision Checklist

- [ ] Three reverse steps in order?
- [ ] `k = k % n` before reversal?
- [ ] Index ranges: `[0, k-1]` and `[k, n-1]`?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-2.java` |
