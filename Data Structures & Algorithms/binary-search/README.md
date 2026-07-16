# Binary Search

| Field | Value |
|-------|-------|
| Topic | Binary Search |
| Difficulty | Easy |
| Primary Pattern | Binary Search |
| Secondary Pattern | Half-open interval `[l, r)` |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Sorted ascending array; return index of `target` or `-1`.

---

## Brute Force

Linear scan O(n).

---

## Core Observation

Sorted order ⇒ discard half each step by comparing mid to target.

---

## Thinking Process

Half-open range `l = 0`, `r = n`, while `l < r`:

- `m = l + (r - l) / 2` (overflow-safe; `submission-1` improvement over `(l+r)/2`)
- equal → return `m`
- `nums[m] > target` → `r = m`
- else → `l = m + 1`

---

## Why the Approach Works

Invariant: if target exists, it lies in `[l, r)`. Shrinking maintains the invariant until empty.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Classic binary search |
| Template | Half-open `[l,r)` with `r = m` / `l = m+1` |

See: [Binary Search](../Binary%20Search/README.md), [PATTERNS.md](../../PATTERNS.md#binary-search-templates).

---

## Alternative Approaches

Closed `[l,r]` with `r = m-1` — equally valid if consistent. Final understanding: **half-open + safe mid**.

---

## Critical Implementation Details

- Pick one template and never mix `r = m` with `r = m-1`
- Overflow-safe mid

---

## Edge Cases

- Empty; single element; target at ends; absent

---

## Common Mistakes

- Infinite loop (`l = m` when mid can stick)
- Mixing inclusive/exclusive bounds

---

## Complexity

Time O(log n), Space O(1).

---

## Similar Problems

- [search-insert-position](../search-insert-position/README.md)
- [guess-number-higher-or-lower](../guess-number-higher-or-lower/README.md)
- [search-2d-matrix](../search-2d-matrix/README.md)

---

## One-line Takeaway

**Master one binary-search bound template; use overflow-safe mid.**

---

## Revision Checklist

- [ ] Write `[l,r)` template from memory
- [ ] Explain why `l = m` can infinite-loop

---

## Revision History

| Date | Note |
|------|------|
| — | From `submission-0` + `submission-1` (safe mid) |
