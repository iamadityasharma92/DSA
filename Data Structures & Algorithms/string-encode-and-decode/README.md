# Encode and Decode Strings

| Field | Value |
|-------|-------|
| Topic | Arrays & Hashing |
| Difficulty | Medium |
| Primary Pattern | Length-prefixed encoding |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Design an algorithm to encode a list of strings into a single string, and decode it back. The strings may contain any characters including the delimiter character. The encode/decode pair must be invertible.

---

## Constraints (typical)

- Strings can contain any byte character (including `/`, `|`, etc.)
- Must handle empty strings
- Encode + decode must be lossless

---

## Brute Force

Join with a delimiter like `#` — fails if any string contains `#`.

---

## Core Observation

Prefix each string with its length and a separator character `|`. On decode, parse the length first (find `|`), then extract exactly that many characters — no need to scan for the delimiter in the content.

---

## Thinking Process

**Encode:**
1. For each `str`: append `len(str) + "|" + str`.
2. Return concatenated result.

**Decode:**
1. `i = 0`.
2. Find `j = indexOf('|', i)`.
3. Parse `l = parseInt(str[i..j])`.
4. Extract `str[j+1..j+1+l]`, add to list.
5. `i = j + 1 + l`.
6. Repeat.

---

## Why the Approach Works

The length prefix + separator scheme means the decoder always knows exactly how many characters to read for each string, regardless of content. The `|` after the length is unambiguous because lengths are always purely numeric.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Length-prefixed protocol encoding |
| Alternative | Escape-based encoding (escape delimiter in strings) — more complex |

### Pattern Recognition Clues

- "Encode/decode strings with arbitrary content"
- Cannot use a fixed delimiter alone — content may contain it

---

## Alternative Approaches

**4-byte length prefix:** binary encoding — 4 bytes for length, then content. More space-efficient, same idea.

**Escaping:** double any `|` in content, then use `|` as delimiter. O(n) but more complex parsing.

---

## Critical Implementation Details

- `str.indexOf('|', i)` finds the `|` **after position `i`** — critical when the string content contains `|`
- Extraction is `substring(j+1, j+1+l)` (exclusive end in Java)
- `i = j + 1 + l` — advance past the consumed string
- `encode` uses `str.trim()` in submission — may truncate strings with trailing spaces; prefer no trim

---

## Edge Cases

- Empty string `""` → encoded as `"0|"`, decoded as `""`
- String containing `|` or digits → length prefix handles correctly
- List with one element
- Empty list → empty encoded string

---

## Common Mistakes

- Not encoding string length (delimiter-only approach fails on arbitrary content)
- Wrong substring bounds (off-by-one on extraction)
- `trim()` in encode — corrupts strings with trailing whitespace

---

## Complexity

| | |
|--|--|
| Time | O(n) where n = total chars |
| Space | O(n) |

---

## Similar Problems

- [subarray-sum-equals-k](../subarray-sum-equals-k/README.md) — prefix sum; similar prefix-based reasoning

---

## One-line Takeaway

**Encode: prepend `len|` before each string. Decode: parse length, extract exactly len chars.**

---

## Revision Checklist

- [ ] Format: `len + "|" + string`?
- [ ] Decode: `indexOf('|', i)` not `indexOf('|')`?
- [ ] Why avoid fixed delimiter alone?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-1.java`; note: `trim()` in encode may corrupt trailing-space strings |
