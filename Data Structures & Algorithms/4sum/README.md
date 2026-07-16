# 4Sum

| Field | Value |
|-------|-------|
| Topic | Two Pointers |
| Difficulty | Medium |
| Primary Pattern | Two Pointers (k-Sum reduction) |
| Secondary Pattern | Sorting + Deduplication |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Find all unique quadruplets `[a, b, c, d]` such that `a + b + c + d == target`.

Order of quadruplets and order inside a quadruplet do not matter; duplicates must be eliminated.

---

## Constraints (typical)

- `n` up to ~1000 → O(n³) is acceptable; O(n⁴) is not
- Values can be large → use `long` for sums to avoid overflow
- Duplicates in input are allowed

---

## Brute Force

Enumerate all quadruplets → O(n⁴), then dedupe with a set.

Fails on time for interview constraints.

---

## Core Observation

After sorting, **k-Sum reduces to (k−1)-Sum**.

Fix the first two indices, then solve 2-Sum with two pointers on the remaining sorted suffix.

Duplicate answers come from equal adjacent values at any fixed or moving index — skip them.

---

## Thinking Process

1. Sort the array.
2. Fix index `i` (first number); skip if `nums[i] == nums[i-1]`.
3. Fix index `j > i` (second number); skip if `nums[j] == nums[j-1]` (relative to `i`).
4. Two pointers `c, d` on `(j+1 .. n-1)` seeking `target - nums[i] - nums[j]`.
5. On match: record, skip duplicate `c`/`d`, then move both.
6. On sum too small → `c++`; too large → `d--`.

---

## Why the Approach Works

Sorting gives monotonicity for the two-pointer search and makes consecutive duplicates easy to skip.

Each unique ordered quadruplet in sorted order is generated exactly once by the skip rules.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Two Pointers on sorted array |
| Secondary | k-Sum → nested reduction to 2-Sum |
| Alternative | Hash map 2-Sum inside double loop (harder dedupe) |

---

## Pattern Recognition Clues

- “All unique k-tuples that sum to target”
- Input may contain duplicates; output must not
- n is small enough for O(n³) / O(nᵏ⁻¹)

→ Sort + fix (k−2) indices + two pointers.

See also: [Two Pointers](../Two%20Pointers/README.md), [PATTERNS.md](../../PATTERNS.md#two-pointers--k-sum).

---

## Alternative Approaches

| Approach | Notes |
|----------|-------|
| Hash set for pair sums | Can reach O(n²)–O(n³) but dedupe and overflow are messier |
| Recurse general k-Sum | Clean abstraction; same asymptotics |

Final understanding here: **sort → fix two → two-pointer 2-Sum**, with `long` sums.

---

## Critical Implementation Details

- Cast sums to `long` before comparing to `target`
- Skip duplicates at **every** level (`i`, `j`, and after a hit on `c`/`d`)
- After recording a match, skip while `nums[c] == nums[c+1]` / `nums[d] == nums[d-1]`, then `c++`, `d--`
- Early `n == 4` path is optional; the general loop already covers it

---

## Edge Cases

- `n < 4` → empty
- All zeros / many duplicates
- Large positives/negatives near `Integer.MIN/MAX` (overflow)
- Target unreachable

---

## Common Mistakes

- Using `int` sum → silent wrong answers
- Skipping duplicates incorrectly (skip relative to wrong previous index)
- Forgetting to move both pointers after a match
- Returning permutations as separate answers

---

## Complexity

| | |
|--|--|
| Time | O(n³) after O(n log n) sort |
| Space | O(1) extra (excluding output); sort may be O(log n) |

---

## Similar Problems

- [three-integer-sum](../three-integer-sum/README.md) — same pattern, one fewer fixed index
- [two-integer-sum-ii](../two-integer-sum-ii/README.md) — sorted 2-Sum core
- [two-integer-sum](../two-integer-sum/README.md) — hash-map 2-Sum (unsorted)

---

## One-line Takeaway

**k-Sum on duplicates = sort + fix (k−2) + two pointers + skip equals.**

---

## Revision Checklist

- [ ] Can I state why sorting enables two pointers?
- [ ] Can I explain duplicate-skip at each nesting level?
- [ ] Do I remember `long` for the sum?
- [ ] Can I derive 4Sum from 3Sum without looking?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-2.java` |
