import pandas
from pandas import ExcelFile
from pandas import ExcelWriter

data ={"First Name ": ["Satvik", "Avinash", "Lahari",],
       "LastName":["Shah", "Kathi","Rath"],
       "Email":["satshah@example.com","avinashk@example.com","lahri.rath@example.com"],
       "PhoneNumber":["4537829158","5892184058","4528727830"]
          
       }

dataframe= pandas.DataFrame(data)

writer = ExcelWriter("activity16.xlsx")
dataframe.to_excel(writer, "Sheet1", index=False)

writer.close()