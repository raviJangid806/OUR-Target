Bit manipulation is basically doing math and logic directly on the bits of numbers. In Python this is very powerful for interview‑style problems, even though Python doesn’t have fixed-width ints like Java. [wiki.python](https://wiki.python.org/moin/BitManipulation)

Since you said “advanced”, let’s treat this like a short roadmap and start at the level you’ll actually use in DSA / interview problems:

1. Core bitwise ops and Python’s quirks  
2. Masks: set / clear / toggle / test bits  
3. Classic tricks (count set bits, isolate bits, swap, etc.)  
4. Pattern: designing bit‑based solutions to problems  

In this message, let’s focus on steps 1–2, then move to tricks and patterns after you try a couple of things yourself.

***

## 1. Core bitwise operators in Python

Python supports the usual integer bitwise operators:  
`&` (AND), `|` (OR), `^` (XOR), `~` (NOT), `<<` (left shift), `>>` (right shift).  [medium](https://medium.com/@jivanandham/bit-manipulation-techniques-for-coding-interviews-8af766613a8f)

- AND `a & b`: bit is 1 only if both bits are 1 (used for masking / checking bits). [medium](https://medium.com/@jivanandham/bit-manipulation-techniques-for-coding-interviews-8af766613a8f)
- OR `a | b`: bit is 1 if at least one is 1 (used for setting bits).  [medium](https://medium.com/@jivanandham/bit-manipulation-techniques-for-coding-interviews-8af766613a8f)  
- XOR `a ^ b`: bit is 1 if bits are different (used for toggling, finding unique elements). [medium](https://medium.com/@jivanandham/bit-manipulation-techniques-for-coding-interviews-8af766613a8f)
- NOT `~a`: flips all bits; in Python this is two’s complement, so `~x == -x-1`. [stackoverflow](https://stackoverflow.com/questions/147713/how-do-i-manipulate-bits-in-python)
- Shifts: `a << k` multiplies by `2**k`, `a >> k` divides (floor) by `2**k` for positive numbers. [medium](https://medium.com/@jivanandham/bit-manipulation-techniques-for-coding-interviews-8af766613a8f)

Two important Python‑specific points (they matter in “advanced” use):

- Integers are unbounded (no fixed 32‑bit/64‑bit width). So you must explicitly mask when you want 32‑bit behavior, e.g. `(x << 5) & 0xffffffff`. [stackoverflow](https://stackoverflow.com/questions/147713/how-do-i-manipulate-bits-in-python)
- Negative numbers are stored in two’s complement conceptually; operations like `~x` and right shift preserve sign in that sense. [stackoverflow](https://stackoverflow.com/questions/147713/how-do-i-manipulate-bits-in-python)

Question to think about:  
If `x = 5` (binary `0101`) and `y = 3` (binary `0011`), can you write down (in binary or decimal) what `x & y`, `x | y`, and `x ^ y` should be, and explain what each is doing to the bits?

***

## 2. Bit masks and per‑bit operations

Most “advanced” techniques are just smart usage of **bit masks**: integers like `1 << k` that have a single 1‑bit at position `k`. [codesignal](https://codesignal.com/learn/courses/interview-prep-the-last-mile-in-python/lessons/bit-manipulation-techniques-in-python)

Assume `position` is 0‑based from the right (LSB):

1. **Set a bit (make it 1)**  
   Idea: OR with a mask that has 1 at that position.  
   Pattern:  
   ```python
   n | (1 << position)
   ```  
   This guarantees that the bit at `position` becomes 1, without touching other bits. [medium](https://medium.com/@jivanandham/bit-manipulation-techniques-for-coding-interviews-8af766613a8f)

2. **Clear a bit (make it 0)**  
   Idea: AND with the inverse of the mask (everything 1 except that position).  
   Pattern:  
   ```python
   n & ~(1 << position)
   ```  
   Here `1 << position` has a 1 at that bit, `~(...)` flips it to 0 at that bit and 1 elsewhere, so AND “forces” that bit to 0. [medium](https://medium.com/@jivanandham/bit-manipulation-techniques-for-coding-interviews-8af766613a8f)

3. **Toggle a bit (flip 0 ↔ 1)**  
   Idea: XOR with the mask; XOR with 1 flips a bit.  
   Pattern:  
   ```python
   n ^ (1 << position)
   ```  
   If the bit was 0 it becomes 1; if it was 1 it becomes 0; other bits stay the same. [medium](https://medium.com/@jivanandham/bit-manipulation-techniques-for-coding-interviews-8af766613a8f)

4. **Check if a bit is set**  
   Idea: AND with mask and see if result is non‑zero.  
   Pattern:  
   ```python
   (n & (1 << position)) != 0
   ```  
   If that bit is 1, the AND returns a non‑zero value; otherwise it returns 0. [medium](https://medium.com/@jivanandham/bit-manipulation-techniques-for-coding-interviews-8af766613a8f)

These four patterns (set, clear, toggle, test) are the basis of most advanced bit manipulation techniques in any language, including Python. [codesignal](https://codesignal.com/learn/courses/interview-prep-the-last-mile-in-python/lessons/bit-manipulation-techniques-in-python)

***

## 3. Quick practice (Python + mental model)

Since you’re comfortable with Java backend, just think of Python ints as Java `int`/`long` but “infinite width”, and imagine you mask them to 32 bits when needed.

Try this mentally (or run in Python and then explain):

- Take `n = 0b1010` (decimal 10).  
  1. Use a mask to **set** bit at position 1. What decimal result do you expect?  
  2. From that result, **clear** bit at position 3.  
  3. Then **toggle** bit at position 0.  

Explain your reasoning: for each step, what is the binary of `n`, what is the mask, and what is the final binary?

***

Once you’re comfortable with these basic operations, next we can go into “advanced” tricks like:

- Counting set bits efficiently (`n & (n-1)` trick)  
- Isolating the rightmost set bit (`n & -n`)  
- Using XOR to find single / odd frequency elements  
- Designing bitmasks to represent subsets / states in DP or game problems  

What level do you feel you’re at right now: are you fully comfortable with masks and set/clear/toggle/test, or should we drill those with a few more examples before moving into the interview‑style bit tricks?