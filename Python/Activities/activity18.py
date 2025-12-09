import pandas as pd

df = pd.read_csv("Sanju.csv") 


print("Usernames column:")
print(df["Usernames"])


print("\nSecond row username and password:")
print(df.loc[1, ["Usernames", "Passwords"]])


print("\nUsernames sorted ascending:")
print(df["Usernames"].sort_values())


print("\nPasswords sorted descending:")
print(df["Passwords"].sort_values(ascending=False))
