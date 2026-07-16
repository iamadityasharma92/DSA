# Group Anagrams

| Field | Value |
|-------|-------|
| Topic | Arrays & Hashing |
| Difficulty | Medium |
| Primary Pattern | Hashing by canonical key |
| Secondary Pattern | Sorting as signature |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Group strings that are anagrams of each other. Order of groups/strings usually unrestricted.

---

## Constraints (typical)

- Many strings; each string length modest
- Lowercase letters common (enables count-key optimization)

---

## Brute Force

For each string, compare to all others with sorted equality → roughly O(n² · L log L). Too slow / clumsy.

---

## Core Observation

Anagrams share the same **multiset of characters**. Any injective canonical form of that multiset is a hash key:

- sorted string, or
- frequency tuple / encoded count string

---

## Thinking Process

1. `Map<signature, List<String>>`
2. For each `s`: build signature (here: sort chars → new String)
3. Append `s` to that bucket
4. Return map values

---

## Why the Approach Works

Sorting is a deterministic fingerprint of the character multiset; equal fingerprints ⟺ anagrams (for the same alphabet/length rules).

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Hash map grouping |
| Secondary | Canonicalization |
| Alternative | Count array key `"#2#0#1..."` → O(L) per string |

See: [Arrays & Hashing](../Arrays%20%26%20Hashing/README.md), [PATTERNS.md](../../PATTERNS.md#hashing--canonical-keys).

---

## Alternative Approaches

| Approach | Notes |
|----------|-------|
| Sort key | Simple; O(L log L) per string — **used here** |
| Freq count key | Better when alphabet is small |
| Prime product key | Clever but overflow/collision risk — avoid |

---

## Critical Implementation Details

- `putIfAbsent` / `computeIfAbsent` before add
- Signature must not mutate the original string reference incorrectly (sort a copy)

---

## Edge Cases

- Empty string
- Single character groups
- All identical / all unique

---

## Common Mistakes

- Using unsorted string as key
- Mutating shared char buffers across iterations
- Returning keys instead of grouped lists

---

## Complexity

| | |
|--|--|
| Time | O(n · L log L) with sort keys |
| Space | O(n · L) for map + output |

---

## Similar Problems

- [is-anagram](../is-anagram/README.md) — same fingerprint idea, boolean
- [valid-sudoku](../valid-sudoku/README.md) — hashing constraints
- [permutation-string](../permutation-string/README.md) — freq multiset match in a window

---

## One-line Takeaway

**Group by a canonical character multiset key (sorted string or counts).**

---

## Revision Checklist

- [ ] Can I name two valid signature strategies?
- [ ] When is count-key better than sort-key?
- [ ] Can I implement `computeIfAbsent` cleanly?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0.java` |
