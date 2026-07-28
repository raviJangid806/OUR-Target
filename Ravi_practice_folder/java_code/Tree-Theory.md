# Complete Traversal Checklist
| Traversal                      | Category        |
| ------------------------------ | --------------- |
| Preorder                       | DFS (Done)            |
| Inorder                        | DFS (Done)            |
| Postorder                      | DFS (Done)            |
| Level Order                    | BFS (Done)            |
| Reverse Level Order            | BFS             |
| Zigzag (Spiral)                | BFS             |
| Boundary Traversal             | View/Boundary   |
| Vertical Order                 | View            |
| Vertical Sum                   | View            |
| Diagonal Traversal             | View            |
| Diagonal Sum                   | View            |
| Top View                       | View            |
| Bottom View                    | View            |
| Left View                      | View            |
| Right View                     | View            |
| Morris Inorder                 | Space-Optimized |
| Morris Preorder                | Space-Optimized |
| Euler Tour                     | Advanced        |
| Threaded Tree Traversal        | Advanced        |
| Ancestor Traversal             | Path-Based      |
| Leaf Traversal                 | Path-Based      |
| Root-to-Leaf Paths             | Path-Based      |
| Root-to-Node Path              | Path-Based      |
| Specific Level Order           | Special         |
| Alternate Level Order          | Special         |
| Reverse Inorder                | Reverse         |
| Reverse Preorder               | Reverse         |
| Reverse Postorder              | Reverse         |
| N-ary Preorder                 | N-ary           |
| N-ary Postorder                | N-ary           |
| N-ary Level Order              | N-ary           |
| N-ary Zigzag                   | N-ary           |
| Iterative Preorder             | Iterative       |
| Iterative Inorder              | Iterative       |
| Iterative Postorder (1 Stack)  | Iterative       |
| Iterative Postorder (2 Stacks) | Iterative       |
| Iterative Level Order          | Iterative       |
| Recursive Preorder             | Recursive       |
| Recursive Inorder              | Recursive       |
| Recursive Postorder            | Recursive       |



If you're studying **Trees in DSA** for coding interviews (Google, Microsoft, Amazon, LeetCode, etc.), here's a comprehensive list of tree traversals. I've grouped them by category so you don't miss anything.

---

# 1. Depth First Search (DFS) Traversals

DFS explores one branch completely before moving to another.

## A. Preorder Traversal (NLR)

**Order:**

```
Root → Left → Right
```

Example:

```
    1
   / \
  2   3
 / \
4   5
```

Output:

```
1 2 4 5 3
```

Uses:

* Copying a tree
* Serialization
* Expression trees
* Prefix notation

---

## B. Inorder Traversal (LNR)

**Order:**

```
Left → Root → Right
```

Output:

```
4 2 5 1 3
```

Uses:

* Binary Search Tree gives sorted order
* Expression trees

---

## C. Postorder Traversal (LRN)

**Order:**

```
Left → Right → Root
```

Output:

```
4 5 2 3 1
```

Uses:

* Delete tree
* Calculate directory size
* Postfix expressions

---

# 2. Breadth First Search (BFS)

Visits nodes level by level.

## Level Order Traversal

Order:

```
Level 0
Level 1
Level 2
...
```

Output:

```
1 2 3 4 5
```

Uses:

* Shortest path in unweighted tree
* Printing tree
* BFS problems

---

# 3. Reverse Level Order Traversal

Traverse from bottom level to top.

Output:

```
4 5 2 3 1
```

Usually implemented using:

* Queue + Stack

---

# 4. Zigzag Traversal (Spiral Traversal)

Alternate directions every level.

```
Level 0 → Left to Right

Level 1 → Right to Left

Level 2 → Left to Right

...
```

Example:

```
1
3 2
4 5 6 7
```

---

# 5. Boundary Traversal

Traverse:

```
Root

↓

Left Boundary

↓

Leaf Nodes

↓

Right Boundary (Bottom-Up)
```

Example:

```
       1
     /   \
    2     3
   / \   / \
  4  5  6  7
```

Output:

```
1 2 4 5 6 7 3
```

---

# 6. Vertical Order Traversal

Traverse column by column.

```
        1
      /   \
     2     3
    / \   / \
   4  5 6   7
```

Columns:

```
-2 : 4
-1 : 2
 0 : 1 5 6
+1 : 3
+2 : 7
```

---

# 7. Vertical Sum Traversal

Instead of printing nodes, sum each vertical column.

Example:

```
Column -2 = 4

Column -1 = 2

Column 0 = 1+5+6=12

Column +1 = 3

Column +2 = 7
```

---

# 8. Diagonal Traversal

Traverse diagonally.

Example:

```
Diagonal 0:
1 3 7

Diagonal 1:
2 5 6

Diagonal 2:
4
```

---

# 9. Diagonal Sum Traversal

Same as diagonal traversal but sum each diagonal.

---

# 10. Top View Traversal

Print nodes visible from the top.

Example:

```
    1
   / \
  2   3
 /     \
4       5
```

Output:

```
4 2 1 3 5
```

---

# 11. Bottom View Traversal

Nodes visible from the bottom.

Output:

```
4 2 6 3 7
```

(depending on the tree)

---

# 12. Left View Traversal

First node seen from the left at every level.

Output:

```
1 2 4
```

---

# 13. Right View Traversal

First node seen from the right.

Output:

```
1 3 7
```

---

# 14. Morris Inorder Traversal

Special traversal.

Characteristics:

* No recursion
* No stack
* O(1) extra space

Order:

```
Left → Root → Right
```

---

# 15. Morris Preorder Traversal

Also:

* No recursion
* No stack
* O(1) space

Order:

```
Root → Left → Right
```

---

# 16. Euler Tour Traversal

Visit each node multiple times.

Variants:

### Euler Tour 1

```
Visit before left
Visit after left
Visit after right
```

---

### Euler Tour 2

Different recording positions.

---

### Euler Tour 3

Another variation used in advanced algorithms.

Uses:

* Lowest Common Ancestor (LCA)
* Segment Tree
* Tree Flattening

---

# 17. Threaded Tree Traversal

Traversal using threaded binary trees.

Advantages:

* No recursion
* No stack

---

# 18. Ancestor Traversal

Print all ancestors of a node.

Example:

```
Target = 5

Output:
2 1
```

---

# 19. Leaf Traversal

Print only leaf nodes.

Example:

```
4 5 6 7
```

---

# 20. Root to Leaf Traversal

Print every root-to-leaf path.

Example:

```
1→2→4

1→2→5

1→3→6

1→3→7
```

---

# 21. Root to Node Traversal

Print path from root to a specific node.

Example:

```
Target = 6

1→3→6
```

---

# 22. Specific Level Order Traversal

Mainly for **Perfect Binary Trees**.

Traversal order differs from normal level order.

---

# 23. Alternate Level Order Traversal

Print alternate levels only.

Example:

```
Level 0

Level 2

Level 4
```

---

# 24. Reverse Inorder Traversal

Order:

```
Right → Root → Left
```

Useful for:

* Kth largest in BST

---

# 25. Reverse Preorder Traversal

Order:

```
Root → Right → Left
```

---

# 26. Reverse Postorder Traversal

Order:

```
Right → Left → Root
```

---

# 27. N-ary Tree Traversals

For trees where a node can have more than two children:

* Preorder
* Postorder
* Level Order
* Zigzag Level Order

---

# 28. Iterative Traversals

All major traversals can be implemented iteratively:

* Iterative Preorder
* Iterative Inorder
* Iterative Postorder (Two Stacks)
* Iterative Postorder (One Stack)
* Iterative Level Order

---

# 29. Recursive Traversals

Recursive versions of:

* Preorder
* Inorder
* Postorder

---

# 30. BST-Specific Traversal Applications

These are not new traversal algorithms but common traversal patterns on a BST:

* Inorder → Ascending order
* Reverse Inorder → Descending order
* Kth Smallest (Inorder)
* Kth Largest (Reverse Inorder)

---

This list covers the standard traversal techniques and commonly recognized traversal variants used in data structures, algorithms, competitive programming, and technical interviews.

