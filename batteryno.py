import pandas as pd
from firebase import firebase
import math
df=pd.read_csv("MYDATA.csv")
#y=df.iloc[:,:-1].values
# with open('MYDATA.csv') as csv_file:
#     csv_reader = csv.reader(csv_file)
#     for row in csv_reader :
#         data.append(csv_reader)

sorted=df.sort_values('FREQUENCY')
X=sorted.iloc[:,0].values
y=sorted.iloc[:,1].values

firebase = firebase.FirebaseApplication("https://echarging-f3759.firebaseio.com/")
for i in range(len(X)):
    firebase.patch('/MARKET',{X[i]:math.ceil(y[i]/5)})