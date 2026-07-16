# Top K Frequent Elements

| Field | Value |
|-------|-------|
| Topic | Heap / Priority Queue |
| Difficulty | Medium |
| Primary Pattern | Frequency count + sort / min-heap |
| Secondary Pattern | Bucket sort (optimal) |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given an integer array and integer `k`, return the `k` most frequent elements. Order of result doesn't matter.

---

## Constraints (typical)

- `k` is always valid (1 ≤ k ≤ distinct element count)
- Answer is guaranteed unique

---

## Brute Force

Count frequencies, sort by frequency descending, take top k → O(n log n). This is what `submission-1` does.

---

## Core Observation

Three approaches:
1. **Sort by frequency:** O(n log n). `submission-1`.
2. **Min-heap of size k:** O(n log k). Maintain k most frequent.
3. **Bucket sort:** O(n). Frequency buckets — each bucket `i` = list of elements with frequency `i`.

---

## Thinking Process

**`submission-1` (sort):**
1. Build `HashMap<val, freq>`.
2. `list = entrySet()`. Sort by `freq` descending.
3. Return first `k` keys.

**Min-heap (O(n log k)):**
1. Build frequency map.
2. For each entry: add to `minHeap`. If `size > k`: poll (removes least frequent).
3. Return remaining `k` elements.

**Bucket sort (O(n)):**
1. Build frequency map.
2. `buckets[freq]` = list of elements with that frequency.
3. Scan buckets from high to low, collect until `k` elements gathered.

---

## Why the Approach Works

Min-heap keeps only the k most frequent elements — heap root is always the k-th most frequent (least among top k). Bucket sort: max possible frequency is `n`, so at most `n+1` buckets; linear scan from high to low gathers top k in O(n).

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| O(n log n) | Sort by frequency (`submission-1`) |
| O(n log k) | Min-heap of size k |
| O(n) | Bucket sort |

### Pattern Recognition Clues

- "Top k by frequency"
- Space vs time trade-off between approaches

Cross-ref: [Heap](../Heap/README.md) · [PATTERNS.md](../../PATTERNS.md#heap--top-k)

---

## Alternative Approaches

**QuickSelect on frequencies:** O(n) expected. Complex to implement.

---

## Critical Implementation Details

**Sort approach:** use `(a, b) -> b.getValue() - a.getValue()` for descending sort on entry values.  
**Min-heap:** `PriorityQueue` by frequency ascending; add all entries, keep size ≤ k by polling.  
**Bucket:** buckets indexed 1 to n; scan n downto 1; gather from each bucket until k elements.

---

## Edge Cases

- `k = 1` → most frequent single element
- All elements unique → any k elements (all freq = 1)
- Single element repeated → it's in top k if k ≥ 1

---

## Common Mistakes

- `submission-1` handles `k == 1 && n == 1` as a special case unnecessarily — standard code handles it
- Min-heap: using max-heap gives most frequent at top (must poll all but k) — O(n log n) same as sort

---

## Complexity

| | |
|--|--|
| Time | O(n log n) sort; O(n log k) heap; O(n) bucket |
| Space | O(n) all approaches |

---

## Similar Problems

- [kth-largest-integer-in-a-stream](../kth-largest-integer-in-a-stream/README.md) — same min-heap-of-k pattern

---

## One-line Takeaway

**Frequency map → bucket sort O(n) or min-heap O(n log k) for top-k by frequency.**

---

## Revision Checklist

- [ ] Three approaches and their complexities?
- [ ] Min-heap: which direction (min not max)?
- [ ] Bucket sort: scan which direction (high to low)?

---

## Revision History

| Date | Note |
|------|------|
| — | `submission-1` uses sort; bucket sort or min-heap preferred in interviews |
