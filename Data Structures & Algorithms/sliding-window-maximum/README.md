# Sliding Window Maximum

| Field | Value |
|-------|-------|
| Topic | Sliding Window |
| Difficulty | Hard |
| Primary Pattern | Sliding Window + Max-Heap (lazy deletion) |
| Secondary Pattern | Monotonic Deque (optimal) |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given array `nums` and window size `k`, return the maximum value in each sliding window position. Output has length `n - k + 1`.

---

## Constraints (typical)

- `1 ≤ k ≤ nums.length ≤ 10⁵`
- Values can be negative

---

## Brute Force

For each window, scan all `k` elements → O(n × k). TLE.

---

## Core Observation

**`submission-1` approach (max-heap + lazy deletion):** A max-heap of `{value, index}` pairs. When querying the window max, lazily discard heap tops with indices outside the current window (`index <= i - k`).

**Optimal (monotonic deque):** a deque holds indices in decreasing order of their values. The front is always the max of the current window.

---

## Thinking Process

**Heap approach (`submission-1`):**
1. `maxHeap` of `{value, index}` (descending by value).
2. For each `i`: add `{nums[i], i}`.
3. Once `i >= k-1`: pop from heap while `heap.peek()[1] <= i-k` (stale). Record `heap.peek()[0]`.

**Deque (optimal):**
1. Deque of indices, decreasing by value.
2. Remove front if out of window (`front <= i-k`); remove back while `nums[back] <= nums[i]`.
3. Add `i`. If `i >= k-1`, record `nums[deque.front()]`.

---

## Why the Approach Works

**Heap:** lazy removal ensures only valid-window elements remain at the top when needed. O(log n) per element.

**Deque:** each element pushed/popped once → O(1) amortized. Front is always max of current window because smaller elements behind the new maximum are irrelevant (they'll leave the window before the new max does).

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Sliding window max — monotonic deque |
| Alternative | Max-heap with lazy deletion (simpler code, O(n log n)) |

### Pattern Recognition Clues

- "Maximum in every window of size k"
- Deque/heap for efficient running max

Cross-ref: [Sliding Window](../Sliding%20Window/README.md) · [Heap](../Heap/README.md) · [PATTERNS.md](../../PATTERNS.md#sliding-window-variable--fixed)

---

## Alternative Approaches

Sparse Table (range max in O(1) with O(n log n) precompute) — overkill here.

Segment Tree — O(log n) per query, O(n log n) total.

---

## Critical Implementation Details

**Heap approach:**
- Store index alongside value — needed to check staleness (`index <= i - k`)
- Lazy: only check staleness when reading the max (peek), not proactively

**Deque approach:**
- Remove from deque back while `nums[deque.back()] <= nums[i]` (strictly — smaller values are dominated)
- Remove front when `deque.front() <= i - k` (outside window)
- Output starts at `i = k-1`

---

## Edge Cases

- `k == n` → one window covering all elements
- `k == 1` → each element is its own maximum
- Strictly decreasing array → deque always has one element

---

## Common Mistakes

**Heap:** missing lazy removal → stale indices produce wrong results.
**Deque:** removing back with `<` instead of `<=` → duplicate maximums handled wrong.

---

## Complexity

| | Heap | Deque |
|--|--|--|
| Time | O(n log n) | O(n) amortized |
| Space | O(n) | O(k) |

---

## Similar Problems

- [minimum-stack](../minimum-stack/README.md) — O(1) running min/max with auxiliary structure
- [daily-temperatures](../daily-temperatures/README.md) — monotonic stack

---

## One-line Takeaway

**Monotonic deque: back-pop smaller elements, front-pop stale elements, front = window max.**

---

## Revision Checklist

- [ ] Heap approach: what triggers lazy removal, what's the staleness condition?
- [ ] Deque approach: back removal condition (`<=`), front removal condition?
- [ ] When does output start being recorded?
- [ ] Heap O(n log n) vs Deque O(n) — which does submission use?

---

## Revision History

| Date | Note |
|------|------|
| — | `submission-1` uses max-heap with lazy deletion; optimal is monotonic deque |
