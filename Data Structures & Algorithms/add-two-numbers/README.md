# Add Two Numbers

| Field | Value |
|-------|-------|
| Topic | Linked List |
| Difficulty | Medium |
| Primary Pattern | Linked List traversal |
| Secondary Pattern | Digit DP-style carry |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Digits of two non-negative integers are stored **in reverse order** in linked lists. Return a list for their sum (also reverse order).

---

## Constraints (typical)

- Lists can differ in length
- Final carry may create an extra node
- Node values are single digits `0..9`

---

## Brute Force

Convert both lists to integers/bigints, add, rebuild list.

Fails interview expectations (overflow, not O(n) list thinking) and is unnecessary.

---

## Core Observation

Reverse order means the head is the **least significant digit** — add from the front with a running **carry**, exactly like grade-school addition.

Continue while either list has nodes **or** carry remains.

---

## Thinking Process

1. Dummy head + tail pointer for the result.
2. `carry = 0`.
3. While `l1` or `l2` or `carry`:
   - Read `0` if a list is exhausted.
   - `sum = v1 + v2 + carry`
   - Append `sum % 10`; `carry = sum / 10`
   - Advance non-null inputs.
4. Return `dummy.next`.

---

## Why the Approach Works

Each position is independent given the carry-in; reverse storage aligns positions without reversing lists first.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Single-pass linked list merge-style walk |
| Secondary | Carry propagation |
| Alternative | Reverse → add → reverse (worse if already LSB-first) |

See: [Linked List](../Linked%20List/README.md), [PATTERNS.md](../../PATTERNS.md#linked-list-digit-addition).

---

## Alternative Approaches

| Approach | Notes |
|----------|-------|
| Reverse both, add MSD-first | Extra passes; not needed here |
| Recursion with carry | Elegant but stack depth = list length |

Final understanding: **dummy node + loop until lists and carry done**.

---

## Critical Implementation Details

- Loop condition must include `carry != 0`
- Null-safe value: `node == null ? 0 : node.val`
- Dummy avoids special-casing the first digit

---

## Edge Cases

- One list empty / much longer
- Sum like `5 + 5` → carry creates new node
- Leading zeros in value sense are just trailing list nodes (allowed by problem)

---

## Common Mistakes

- Stopping when the shorter list ends (drop remaining digits/carry)
- Writing `sum` instead of `sum % 10` into the node
- Forgetting the final carry node

---

## Complexity

| | |
|--|--|
| Time | O(max(n, m)) |
| Space | O(max(n, m)) for output; O(1) extra |

---

## Similar Problems

- [merge-two-sorted-linked-lists](../merge-two-sorted-linked-lists/README.md) — dummy + two-list walk
- Add Two Numbers II (MSD first) — reverse or stack first

---

## One-line Takeaway

**LSB-first lists → add in place with carry; loop while nodes or carry remain.**

---

## Revision Checklist

- [ ] Can I write the loop condition without looking?
- [ ] Do I handle unequal lengths with `0`?
- [ ] Do I emit the last carry node?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-1.java` |
