import pickle
from firebase import firebase
def predict(features):
    fb = firebase.FirebaseApplication("https://echarging-f3759.firebaseio.com/")
    for i in range(len(features)):
        if(features[i][5] == 'T'):
            features[i][5] = 1
    else:
        features[i][5] = 0
    p = open("priceReg.sav", 'rb')
    model = pickle.load(p)
    x = model.predict(features)
    fb.patch('/predictions/', {0 : list(x)})
    model.fit(features, x)
    p.close()
    pickle.dump(model, open("priceReg.sav", 'wb'))
    return x
	
