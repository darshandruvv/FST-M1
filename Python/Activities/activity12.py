# Recursive sum function
def total(n):
    if n == 0:
        return 0
    return n + total(n - 1)

# Calling the function
result = total(10)

# Output
print(result)
