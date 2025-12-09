
def fib(n):
    return n if n < 2 else fib(n-1) + fib(n-2)


count = int(input("How many Fibonacci numbers? "))


for i in range(count):
    print(fib(i), end=" ")
