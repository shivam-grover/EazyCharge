
# coding: utf-8

# In[1]:


import csv
from sklearn.ensemble import RandomForestRegressor
from sklearn.preprocessing import LabelBinarizer
from sklearn.preprocessing import OneHotEncoder
import pickle


# In[2]:


fields = []
rows = []
with open("pricepredictdata.csv", 'r') as csvFile:
    reader = csv.reader(csvFile)
    fields = next(reader)
    for r in reader:
        rows.append(r)


# In[4]:


features = [rows[i][0:6] for i in range(len(rows))]
labels = [rows[i][-1] for i in range(len(rows))]

for i in range(len(features)):
    if(features[i][5] == 'T'):
        features[i][5] = 1
    else:
        features[i][5] = 0


# In[6]:


features_train = features[0:10]
features_test = features[11:13]
labels_train = labels[0:10]
labels_test = labels[11:13]


# In[8]:


reg = RandomForestRegressor()
reg.fit(features_train, labels_train)


# In[9]:


reg.predict(features_test)


# In[10]:


pickle.dump(reg, open("priceReg.sav", 'wb'))


# In[11]:


from predictPrice import predict
print(predict(features_test))

