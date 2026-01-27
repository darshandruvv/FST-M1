import pandas
dataframe = pandas.read_excel("activity16.xlsx", sheet_name="Sheet1")


rows,cols=dataframe.shape
print("Rows:", rows)
print("Cols:", cols)

print(dataframe["Email"])

print("Data sorted by first Name:")
print(dataframe.sort_values("First Name "))


