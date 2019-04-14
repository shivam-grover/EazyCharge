import numpy as np
import pandas as pd

Data=pd.read_csv('MyFile'+str(i)+'.csv')
X=Data.iloc[:,0:1].values
y=Data.iloc[:,1].values

from sklearn.model_selection import train_test_split
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size = 1/3, random_state = 0)

from sklearn.ensemble import RandomForestRegressor
regressor = RandomForestRegressor(n_estimators = 10, random_state = 0)
regressor.fit(X, y)

y_pred = regressor.predict(X_test)