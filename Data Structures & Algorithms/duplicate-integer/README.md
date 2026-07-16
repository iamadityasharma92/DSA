# Contains Duplicate

| Field | Value |
|-------|-------|
| Topic | Arrays & Hashing |
| Difficulty | Easy |
| Primary Pattern | HashSet membership |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given an integer array `nums`, return `true` if any value appears **at least twice**; return `false` if every element is distinct.

---

## Constraints (typical)

- `1 ≤ nums.length ≤ 10⁵`
- Values fit in int (can be negative)

---

## Brute Force

Compare every pair → O(n²). Or sort, then scan adjacent — O(n log n). Both exceed the intended O(n).

---

## Core Observation

`HashSet.add(x)` returns `false` if `x` is already present. A single forward pass finds the first duplicate immediately.

---

## Thinking Process

1. Create `HashSet<Integer>`.
2. For each `x` in `nums`: if `!set.add(x)` → return `true`.
3. Return `false` after the loop.

---

## Why the Approach Works

Set membership is O(1) expected. The `add` return value combines the "already seen?" check and the insert into one operation — no double lookup.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | HashSet for seen-before detection |
| Upgrade | Sort + adjacent scan if O(1) space required |

### Pattern Recognition Clues

- "Any value appears more than once?"
- Large input → need O(n) not O(n²)

---

## Alternative Approaches

**Sort:** `Arrays.sort`, then check `nums[i] == nums[i+1]` → O(n log n), O(1) extra space. Valid if space matters.

---

## Critical Implementation Details

- `set.add()` return value: `false` if already present, `true` if newly inserted — use this directly
- No need for `set.contains` + `set.add` (that's two lookups per element)
- Early exit on first duplicate

---

## Edge Cases

- Single element → `false`
- All same values → `true` on second element
- Negative numbers → handled naturally

---

## Common Mistakes

- Calling `contains` then `add` (two lookups instead of one)
- Using sort when hash approach is simpler

---

## Complexity

| | |
|--|--|
| Time | O(n) expected |
| Space | O(n) |

---

## Similar Problems

- [contains-duplicate-ii](../contains-duplicate-ii/README.md) — duplicate within distance k
- [find-duplicate-integer](../find-duplicate-integer/README.md) — unique duplicate in [1..n], O(1) space

---

## One-line Takeaway

**`set.add()` returns false on duplicate — scan once, exit immediately.**

---

## Revision Checklist

- [ ] Why `!set.add(x)` instead of `set.contains(x)` then `set.add(x)`?
- [ ] O(1) space alternative?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0.java` |
