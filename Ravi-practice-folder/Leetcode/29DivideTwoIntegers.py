def divide(dividend: int, divisor: int) -> int:
    INT_MIN, INT_MAX = -2**31, 2**31 - 1
    
    # Edge cases
    if divisor == 0:
        raise ZeroDivisionError("divisor cannot be 0")
    if dividend == 0:
        return 0
    if dividend == INT_MIN and divisor == -1:
        return INT_MAX  # avoid overflow

    # Determine sign
    negative = (dividend < 0) ^ (divisor < 0)

    a, b = abs(dividend), abs(divisor)
    quotient = 0

    while a >= b:
        # Find largest shift so (b << shift) <= a
        shift = 0
        while (b << (shift + 1)) <= a:
            shift += 1
        a -= (b << shift)
        quotient += (1 << shift)

    if negative:
        quotient = -quotient

    # Clamp to 32-bit signed range
    if quotient < INT_MIN:
        return INT_MIN
    if quotient > INT_MAX:
        return INT_MAX
    return quotient