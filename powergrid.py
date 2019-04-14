from firebase import firebase
firebase = firebase.FirebaseApplication("https://sih1-341f8.firebaseio.com/")
result = firebase.get('/', None)
THRESHOLD=
MULTIPLIER=
for(key in result):
    if(result[key]*MULTIPLIER>=THRESHOLD):
        peak = key
        firebase.patch('/POWER_GRID',peak)