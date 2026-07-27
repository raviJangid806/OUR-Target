a = int(input("Enter first number: "))
b = int(input("Enter second number: "))

# Swapping numbers using bitwise AND and OR operator
print("After swapping: a =", a and b, "b =", a or b)

#swapping numbers using XOR operator
a = a ^ b
b = a ^ b
a = a ^ b
print("After swapping: a =", a, "b =", b)