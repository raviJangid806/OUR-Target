a = int(input("Enter a number: "))
i = int(input("Enter the position of the bit: "))

#method 1
# Check if the ith bit is set or not
# result = a & (2**i)
# if(result > 0):
#       print("The", i, "th bit is set.")
# else:
#     print("The", i, "th bit is not set.")

# method 2

result = a >> (i - 1)
if(result & 1):
    print("The", i, "th bit is set.")
else:
    print("The", i, "th bit is not set.")