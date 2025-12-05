#Program to print multiplication table from 1 to 10
num = int(input("Enter a number : "))

for i in range (1,11):
    result = num *i
    print (num, "X" , "=", result)
