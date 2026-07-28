{"id":"web-0","cursor":"none","source":"web","query":"Python bitwise operators AND OR XOR NOT SHIFT","topn":5}## Overview: What you’ll learn

You’re asking about one of the most fun “power tools” in programming: bit manipulation in Python.   
In this session, you’ll learn:

- What bits and binary numbers are
- Python’s bitwise operators (`& | ^ ~ << >>`)
- Common patterns (setting, clearing, toggling, checking bits)
- How this shows up in real problems (masks, flags, etc.)

Let’s start simple and build up.

***

## Step 1: Bits and binary – quick intuition

A **bit** is just a digit that can be 0 or 1.   
A normal integer (like 13) is stored as a sequence of bits, called its binary form. 

Example:  
- Decimal 13 → binary `1101` (which means \( 1\cdot8 + 1\cdot4 + 0\cdot2 + 1\cdot1 = 13 \)) 

In Python, you can see the binary form of a number with `bin()`:

```python
bin(13)   # '0b1101'
bin(6)    # '0b110'
```


Question for you:  
In your own words, what does `bin(13)` show you, and why is that useful for bit manipulation?

***

## Step 2: The main bitwise operators in Python

Python has several **bitwise operators** that work directly on the bits of integers. 

- `&` : bitwise AND  
- `|` : bitwise OR  
- `^` : bitwise XOR (exclusive OR)  
- `~` : bitwise NOT (bitwise complement)  
- `<<` : left shift  
- `>>` : right shift  


These operators compare or move bits, not whole decimal values.   
To understand them, it helps to write numbers in binary using `bin()` as you experiment. 

***

## Step 3: AND, OR, XOR with small examples

Let’s take two numbers:

```python
a = 13   # 0b1101
b = 6    # 0b0110
```


1. **Bitwise AND `&`**

AND gives 1 only when both bits are 1. 

```python
a & b   # 4
bin(a & b)   # '0b100'
```

Binary:

- `a`   = `1101`  
- `b`   = `0110`  
- `&`   = `0100`  → decimal 4  


2. **Bitwise OR `|`**

OR gives 1 if at least one bit is 1. 

```python
a | b   # 15
bin(a | b)   # '0b1111'
```

- `a`   = `1101`  
- `b`   = `0110`  
- `|`   = `1111`  → decimal 15  


3. **Bitwise XOR `^`**

XOR gives 1 only if the bits are different. 

```python
a ^ b   # 11
bin(a ^ b)   # '0b1011'
```

- `a`   = `1101`  
- `b`   = `0110`  
- `^`   = `1011`  → decimal 11  


Question for you:  
Looking at `a = 13 (1101)` and `b = 6 (0110)`, can you explain **why** `a & b` becomes `0100` in binary, using the idea “1 only if both bits are 1”?

***

## Step 4: NOT and bit shifts

1. **Bitwise NOT `~`**

`~x` flips every bit: 0 becomes 1, 1 becomes 0.   
Because Python uses two’s complement for integers, `~x` is equal to `-(x+1)`. 

```python
x = 5       # 0b101
~x          # -6
```


You don’t need to go deep into two’s complement now; just remember `~x = -(x+1)`.

2. **Left shift `<<`**

`x << n` moves all bits to the left by `n` places, filling with zeros on the right.   
This is like multiplying by \( 2^n \) (for non-negative integers). 

```python
x = 3       # 0b11
x << 1      # 6   (0b110)
x << 2      # 12  (0b1100)
```


3. **Right shift `>>`**

`x >> n` moves bits to the right by `n` places.   
For non-negative integers, this is like integer division by \( 2^n \). 

```python
x = 13      # 0b1101
x >> 1      # 6   (0b110)
x >> 2      # 3   (0b11)
```


Question for you:  
If `x = 1`, what are the values of `x << 3` and `x >> 1`, and how would you explain them using “multiply or divide by powers of 2”?

***

## Step 5: Common bit tricks (very important)

These patterns are the “real” bit manipulation:

Assume `n` is an integer, and `k` is the bit position (0 for least significant bit).

1. **Check if k-th bit is set**

```python
is_set = (n & (1 << k)) != 0
```


- `1 << k` creates a number with only the k-th bit = 1.   
- `n & (1 << k)` keeps that bit if it was 1 in `n`. 

2. **Set (turn on) the k-th bit**

```python
n = n | (1 << k)
```


3. **Clear (turn off) the k-th bit**

```python
n = n & ~(1 << k)
```


4. **Toggle (flip) the k-th bit**

```python
n = n ^ (1 << k)
```


These four are used in problems involving **masks** and **flags**, like storing multiple yes/no options inside a single integer. 

Here’s a quick table to compare the main operators:

| Operator | Meaning           | Simple effect on bits                    |
|----------|-------------------|------------------------------------------|
| `&`      | AND               | Keeps bits that are 1 in both numbers   |
| `|`      | OR                | Keeps bits that are 1 in either number  |
| `^`      | XOR               | Keeps bits that differ                   |
| `~`      | NOT               | Flips all bits                           |
| `<<`     | Left shift        | Moves bits left, adds zeros on right     |
| `>>`     | Right shift       | Moves bits right, drops bits on right    |


Question for you:  
Using the patterns above, how would you **check** whether the 2nd bit (k = 1) of `n = 6` is set, and what result do you expect?

***

If you tell your current level (school/college and how comfortable you are with Python), the next explanation can be tuned for you—for example, we can move on to real-world uses like permissions, subsets, or fast algorithms using bit manipulation.