fruits = {"apple":120, "banana":50, "orange":80}

item = input("Fruit name: ").lower()

if item in fruits:
    print("Available, Price:", fruits[item])
else:
    print("Not available")
