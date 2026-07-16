# Valid Sudoku

| Field | Value |
|-------|-------|
| Topic | Arrays & Hashing |
| Difficulty | Medium |
| Primary Pattern | HashSet per row/col/box |
| Secondary Pattern | Box index formula |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Determine if a partially filled 9×9 Sudoku board is valid. Validity: each row, column, and each of the nine 3×3 sub-boxes contains no duplicate digits (1-9). Empty cells are `.`.

---

## Constraints (typical)

- Board is always 9×9
- Only validate — do not solve
- Digits 1-9 only; `.` for empty

---

## Brute Force

`submission-0`: for each non-empty cell, call three separate check functions (row, col, box) scanning all 9 elements each → O(81 × 9 × 3) = O(2187) = O(1) technically, but verbose and slow to write.

---

## Core Observation

Single pass: 27 HashSets — 9 for rows, 9 for columns, 9 for boxes. For each cell, compute its box index, then check/insert into the three relevant sets. Duplicate = invalid.

---

## Thinking Process

**Optimal (single pass with 27 sets):**
1. `Set<String>[] rows = new HashSet[9]`, `cols`, `boxes` similarly.
2. For each `(i, j)`: if `board[i][j] != '.'`:
   - `val = board[i][j]`.
   - `boxIdx = (i/3)*3 + (j/3)`.
   - If `rows[i].contains(val) || cols[j].contains(val) || boxes[boxIdx].contains(val)` → invalid.
   - Add `val` to all three sets.
3. Return `true`.

**`submission-0`:** separate scan functions per cell — correct but O(1) complexity differently achieved.

---

## Why the Approach Works

Each cell's digit must be unique within its row, column, and box. Three sets per dimension track seen digits. On first duplicate → immediately return `false`.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | 27 HashSets for O(1) duplicate detection |
| Box formula | `(row/3)*3 + col/3` maps (i,j) to box index 0-8 |

### Pattern Recognition Clues

- "Validate 9×9 grid with constraints per row/col/box"
- Box index derivation is the key formula to memorize

Cross-ref: [Arrays & Hashing](../Arrays%20%26%20Hashing/README.md)

---

## Alternative Approaches

**Bitmask:** use `int[9]` bitmasks for rows/cols/boxes. Bit `1 << (digit-1)` for each. `(mask & bit) != 0` → duplicate. O(1) per check, O(1) per update. Memory-efficient.

---

## Critical Implementation Details

**Box index formula:** `(row / 3) * 3 + col / 3`
- `row / 3` gives which 3-row band (0, 1, or 2)
- `col / 3` gives which 3-col band (0, 1, or 2)
- Combined: 0-8 for all 9 boxes

**`submission-0`'s `blockCheck` bug:** `if(i != k && j != l)` should be `if(!(i == k && j == l))` — the current check skips the diagonal cells of the box when i and j coordinates both differ, which is wrong. It should only skip the cell itself.

---

## Edge Cases

- All `.` → valid
- A repeated digit in the same row but not column or box → invalid
- A digit appearing in the same box in different rows/columns → invalid

---

## Common Mistakes

- `submission-0`'s `blockCheck` condition: `i != k && j != l` is a bug — should be `!(i == k && j == l)` to skip only the exact current cell
- Not handling `'.'` (treating `.` as a digit)

---

## Complexity

| | |
|--|--|
| Time | O(81) = O(1) — fixed board size |
| Space | O(27 × 9) = O(1) — 27 sets of at most 9 elements each |

---

## Similar Problems

- [two-integer-sum](../two-integer-sum/README.md) — HashSet membership check
- [first-missing-positive](../first-missing-positive/README.md) — presence tracking

---

## One-line Takeaway

**27 sets (9 rows + 9 cols + 9 boxes); box index = `(r/3)*3 + c/3`; single pass, O(81).**

---

## Revision Checklist

- [ ] Box index formula from memory: `(r/3)*3 + c/3`?
- [ ] Skip condition for cells: `board[i][j] != '.'`?
- [ ] `submission-0`'s `blockCheck` condition — what is the bug?

---

## Revision History

| Date | Note |
|------|------|
| — | `submission-0` has a bug in blockCheck condition (`&&` should be `||` in the skip); single-pass 27-set approach is preferred |
