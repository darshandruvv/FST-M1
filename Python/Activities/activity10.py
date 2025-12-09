nums = tuple(map(int, input("Enter numbers separated by space: ").split()))

for n in nums:
    if n % 5 == 0:
        print(n)
