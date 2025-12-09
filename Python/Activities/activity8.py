
numbers = list(map(int, input("Enter numbers separated by space: ").split()))

if len(numbers) > 1 and numbers[0] == numbers[-1]:
    print(True)
else:
    print(False)
