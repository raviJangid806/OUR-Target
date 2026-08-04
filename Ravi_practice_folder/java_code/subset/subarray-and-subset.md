Great topic. **Subsets** are one of the most important concepts for coding interviews, especially for Microsoft, Google, and LeetCode.

Since you're a **Java developer**, I'll explain everything in **Hinglish**, from basics to interview level.

---

# What is a Subset?

Suppose we have an array

```text
[1,2,3]
```

A **subset** means **any combination of elements while keeping the original order of selection (not necessarily contiguous).**

For this array, all subsets are

```text
[]
[1]
[2]
[3]
[1,2]
[1,3]
[2,3]
[1,2,3]
```

Notice:

We can choose

* nothing
* one element
* two elements
* all elements

Everything is a subset.

---

# Difference Between Subarray and Subset

Array

```text
1 2 3
```

### Subarray

Elements must be continuous.

Examples

```text
[1]
[2]
[3]
[1,2]
[2,3]
[1,2,3]
```

Not allowed

```text
[1,3]
```

because 2 is skipped.

---

### Subset

Continuity doesn't matter.

Allowed

```text
[]
[1]
[2]
[3]
[1,2]
[1,3]
[2,3]
[1,2,3]
```

---

# How many subsets are possible?

Suppose array size is

```
n
```

Every element has only **2 choices**

Take it

or

Don't take it

So

```
2 × 2 × 2 × .... n times

= 2^n
```

Example

```
n = 3

2^3 = 8 subsets
```

```
n = 4

2^4 = 16
```

```
n = 5

2^5 = 32
```

This formula is asked frequently in interviews.

---

# Think Like a Decision Tree

Array

```text
[1,2,3]
```

For first element

```
Take 1

OR

Don't take 1
```

For second element

Again

```
Take 2

Don't take 2
```

Third

```
Take 3

Don't take 3
```

The tree becomes

```text
                    []
              /              \
          Take1            Skip1
          /   \            /    \
      Take2 Skip2      Take2   Skip2
       ...
```

Every path gives one subset.

---

# Recursive Thinking

Suppose

```text
nums = [1,2,3]
```

Start from index 0.

At every index

Option 1

Include current element.

Option 2

Exclude current element.

Move to next index.

Repeat.

When index reaches end

Store current subset.

---

Let's see.

Initially

```
Current subset

[]
```

At index 0

Element

```
1
```

Two choices

### Choice 1

Take it

```
[1]
```

Go ahead.

---

Index 1

Element

```
2
```

Again

Take

```
[1,2]
```

or

Skip

```
[1]
```

---

Eventually

One branch becomes

```
[1,2,3]
```

Another becomes

```
[1,2]
```

Another

```
[1,3]
```

Another

```
[1]
```

After finishing all branches,

Return back (Backtracking).

---

# Backtracking Algorithm

Steps

```
1. Add current subset to answer

2. Loop from current index

3. Choose element

4. Go deeper

5. Remove element (Backtrack)
```

This pattern solves many problems.

---

# Java Code

```java
import java.util.*;

public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, 0, new ArrayList<>(), result);

        return result;
    }

    private static void backtrack(int[] nums,
                                  int index,
                                  List<Integer> current,
                                  List<List<Integer>> result) {

        // Store current subset
        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {

            // Choose
            current.add(nums[i]);

            // Explore
            backtrack(nums, i + 1, current, result);

            // Undo choice
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3};

        System.out.println(subsets(nums));
    }
}
```

Output

```text
[
[],
[1],
[1,2],
[1,2,3],
[1,3],
[2],
[2,3],
[3]
]
```

---

# Dry Run

Array

```text
1 2 3
```

Initially

```
current = []
```

Store

```
[]
```

Loop starts

Take

```
1

current = [1]
```

Store

```
[1]
```

Take

```
2

current=[1,2]
```

Store

```
[1,2]
```

Take

```
3

current=[1,2,3]
```

Store

```
[1,2,3]
```

No more elements.

Backtrack

Remove 3

```
[1,2]
```

Backtrack

Remove 2

```
[1]
```

Take

```
3

[1,3]
```

Store.

Backtrack.

Remove 3.

Remove 1.

Now start from

```
2
```

Continue similarly.

---

# Time Complexity

There are

```
2^n
```

subsets.

Each subset may contain up to

```
n
```

elements.

Therefore

```
Time = O(n × 2^n)
```

Space

```
O(n)
```

for recursion stack (excluding the output list).

---

# Another Method: Bit Manipulation

Every element has two choices:

* `1` → include it
* `0` → exclude it

For `n = 3`, count from `0` to `2^3 - 1 = 7`.

| Binary | Subset  |
| ------ | ------- |
| 000    | []      |
| 001    | [3]     |
| 010    | [2]     |
| 011    | [2,3]   |
| 100    | [1]     |
| 101    | [1,3]   |
| 110    | [1,2]   |
| 111    | [1,2,3] |

This is another common interview approach.

---

# Interview Pattern to Remember

Whenever you hear questions like:

* Subsets
* Power Set
* Combination Sum
* Combination Sum II
* Letter Combinations
* Palindrome Partitioning
* Restore IP Addresses
* Generate Parentheses
* N-Queens

Think immediately:

> **Decision + Backtracking**

The template is usually:

1. Choose
2. Explore (recursive call)
3. Undo the choice (backtrack)

---

## Practice Roadmap

To master subsets and backtracking in the right order, solve these problems:

1. **Subsets** (easy)
2. **Subsets II** (handles duplicates)
3. **Combination Sum**
4. **Combination Sum II**
5. **Letter Combinations of a Phone Number**
6. **Palindrome Partitioning**
7. **Permutations**
8. **Permutations II**
9. **N-Queens**

These problems gradually build the same core backtracking skills used in top-company interviews.
