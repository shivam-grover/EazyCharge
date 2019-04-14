from firebase import firebase
firebase = firebase.FirebaseApplication("https://sih1-341f8.firebaseio.com/")
result = firebase.get('/', None)
print(result)
# # counter = 1
# for i in range(24):
#     while(key in result):
#         a = value()
            
