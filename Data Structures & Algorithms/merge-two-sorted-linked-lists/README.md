# Merge Two Sorted Linked Lists

| Field | Value |
|-------|-------|
| Topic | Linked List |
| Difficulty | Easy |
| Primary Pattern | Dummy head + two-pointer merge |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Merge two sorted linked lists into one sorted linked list and return its head.

---

## Constraints (typical)

- `0 ≤ n, m ≤ 50`
- Both sorted ascending
- Merge in-place (reuse nodes)

---

## Brute Force

Collect all values, sort, build new list → O((m+n) log(m+n)). Wastes sorted property.

---

## Core Observation

A dummy head simplifies pointer bookkeeping. Advance through both lists, attaching the smaller node to the merged list each step. After one list is exhausted, append the remaining tail.

---

## Thinking Process

1. `dummy = new ListNode(-1)`, `res = dummy`.
2. While both `list1 != null && list2 != null`:
   - If `list1.val > list2.val` → attach `list2`, `list2 = list2.next`
   - Else → attach `list1`, `list1 = list1.next`
   - `res = res.next`
3. Attach remaining: `res.next = (list1 != null) ? list1 : list2`.
4. Return `dummy.next`.

---

## Why the Approach Works

Both lists are sorted; at each step, the smaller head is the next element in the merged list. Dummy head eliminates special-casing an empty merged list at the start.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Two-pointer merge with dummy head |
| Contrast | Merge sorted array does this right-to-left in-place |

### Pattern Recognition Clues

- "Merge two sorted sequences"
- Output is sorted

Cross-ref: [Linked List](../Linked%20List/README.md)

---

## Alternative Approaches

**Recursive:** `if list1.val <= list2.val: list1.next = merge(list1.next, list2); return list1`. Elegant but O(m+n) stack depth.

---

## Critical Implementation Details

- Dummy head value doesn't matter (e.g., `-1000`) — it's just a sentinel to simplify `res.next` assignments
- After the loop, exactly one of `list1`/`list2` may have remaining nodes — attach the non-null one directly
- Return `dummy.next`, not `dummy`

---

## Edge Cases

- Either list is empty → return the other
- Identical values → either order fine (use `>`, not `>=`, to preserve stability)
- Lists of very different lengths

---

## Common Mistakes

- Not attaching the remaining tail (leaving merged list truncated)
- Returning `dummy` instead of `dummy.next`
- Using `>=` in comparison when one list should be exhausted first (not wrong, but changes ordering preference)

---

## Complexity

| | |
|--|--|
| Time | O(m + n) |
| Space | O(1) — in-place relinking |

---

## Similar Problems

- [merge-sorted-array](../merge-sorted-array/README.md) — same merge logic, arrays
- [reorder-linked-list](../reorder-linked-list/README.md) — restructuring without merging by value

---

## One-line Takeaway

**Dummy head + advance smaller node; append remaining tail after loop.**

---

## Revision Checklist

- [ ] Purpose of dummy head?
- [ ] How is the remaining tail attached?
- [ ] Return `dummy.next` not `dummy`?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0.java` |
