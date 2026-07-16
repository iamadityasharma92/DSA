# Minimum Window Substring

| Field | Value |
|-------|-------|
| Topic | Sliding Window |
| Difficulty | Hard |
| Primary Pattern | Variable Sliding Window + frequency tracking |
| Secondary Pattern | Distinct character count |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given strings `s` and `t`, find the minimum window in `s` that contains all characters of `t` (including duplicates). Return `""` if no such window exists.

---

## Constraints (typical)

- `1 ≤ s.length ≤ 10⁵`, `1 ≤ t.length ≤ 10⁴`
- Characters: uppercase and lowercase English letters

---

## Brute Force

All O(n²) substrings, check each for containing `t` → O(n² × m). TLE.

---

## Core Observation

Sliding window with a **"satisfied character count"** counter. Track how many distinct characters in `t` are fully satisfied (freq in window ≥ freq in t). When `count == 0` (all satisfied), the window is valid — shrink from left to minimize it.

---

## Thinking Process

1. Build `map(char → freq in t)`, `count = map.size()`.
2. `i = j = 0`, `minLen = INT_MAX`, `startIdx = 0`.
3. Expand `j`:
   - If `s[j]` is in map: decrement `map.get(s[j])`; if result `== 0` → `count--`.
4. While `count == 0` (valid window):
   - Update `minLen`, `startIdx`.
   - Shrink `i`: increment `map.get(s[i])`; if result `> 0` → `count++`; `i++`.
5. Return `""` if `minLen == INT_MAX`, else `s.substring(startIdx, startIdx+minLen)`.

---

## Why the Approach Works

`count` tracks unsatisfied character types. When `count == 0`, all of `t`'s characters are present. The inner while-loop shrinks the window minimally — each shrink invalidates exactly one character type at a time.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Variable sliding window with "all-satisfied" counter |
| Tool | Map for character frequency; count for distinct satisfied types |

### Pattern Recognition Clues

- "Minimum window containing all of t"
- Two-pointer: expand until valid, shrink while valid

Cross-ref: [Sliding Window](../Sliding%20Window/README.md) · [PATTERNS.md](../../PATTERNS.md#sliding-window-variable--fixed)

---

## Alternative Approaches

Two-pointer with frequency array instead of map for lowercase-only problems. Same complexity, lower constant.

---

## Critical Implementation Details

- `count = map.size()` — counts **distinct** characters, not total chars
- On expanding right: only decrement map and potentially count for chars in `t`
- On shrinking left: only increment map and potentially count for chars in `t`
- `map.get(ch) > 0` → count increases (freq went above 0 means this char type is now unsatisfied again)
- Return `s.substring(startIdx, startIdx + minLen)`, not `startIdx + minLen - 1`

---

## Edge Cases

- `t` longer than `s` → return `""`
- `s == t` → return `s`
- `t` has duplicate chars → frequency map correctly tracks need

---

## Common Mistakes

- Using `map.size()` as `count` but including non-`t` chars in count changes
- `count++` when `map.get(ch) == 0` instead of `> 0` (wrong threshold — freq going from 0 to 1 means newly unsatisfied)
- Forgetting to check non-`t` characters (they don't affect count)

---

## Complexity

| | |
|--|--|
| Time | O(|s| + |t|) |
| Space | O(|t|) — frequency map |

---

## Similar Problems

- [minimum-size-subarray-sum](../minimum-size-subarray-sum/README.md) — simpler minimum window (sum constraint)
- [longest-repeating-substring-with-replacement](../longest-repeating-substring-with-replacement/README.md) — variable window with char frequency

---

## One-line Takeaway

**Expand until all of t satisfied (count==0); shrink to minimize; capture window at each valid state.**

---

## Revision Checklist

- [ ] What does `count` represent (distinct types, not total chars)?
- [ ] Shrink trigger: `count == 0`?
- [ ] When does `count++` happen on shrink (freq goes above 0)?
- [ ] Return value: `startIdx + minLen`, not `-1`?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-1.java` |
