# EazyCharge

Winning project for Smart India Hackathon 2019 Software Edition

## **Contributors:** 
Shivam Grover, Harshita Diddee, Divyanshu Sharma, Deepasha Birla, Shitiz Gupta, Nikhil Kalra

EazyCharge is an application for charging operators to maximize their audience without comprimising on the profits. 
We have implemented a dynamic pricing system which takes several parameters, such as the current price, the predicted audience in the near future, the number of users that might be around the station at that time and it comes up with a suggested margin(positive or negative) that the operator may choose for better balance between its audience and profit.

The application uses YOLO object detection to count the number of cars on a station. The number of cars along with other parameters are used to predict the number of cars and hence the number of customers and the price for the upcoming week.

The predictions for the price and number of cars are done by a Random Forest Classifier.


1. Using Firebase for Authentication and Database Management.

2. Using YOLO object detection for Real Time Detection of cars:
[CarTrack Script](https://github.com/divyanshusharma1709/CarTrack/blob/master/YOLOCar.ipynb)

3. Use Random Forest Classifier (Scikit-Learn) for prediction of future audience and price suggestions.


Screenshots:


<img src="https://github.com/shivumgrover/EazyCharge/blob/master/screenshots/a1.png" width="200" title="Login Page">  <img src="https://github.com/shivumgrover/EazyCharge/blob/master/screenshots/A2.png" width="200" title="Location of the station">  <img src="https://github.com/shivumgrover/EazyCharge/blob/master/screenshots/A3.png" width="200" title="Types of ports and number of each type"> <img src="https://github.com/shivumgrover/EazyCharge/blob/master/screenshots/A4_setprice.png" width="200" title="Initial Price"> 

<img src="https://github.com/shivumgrover/EazyCharge/blob/master/screenshots/A5_%20connector_unselected.png" width="200" title="Select Connectors available">  <img src="https://github.com/shivumgrover/EazyCharge/blob/master/screenshots/A6_connectors_selected_5.png" width="200" title="Connectors selected">  <img src="https://github.com/shivumgrover/EazyCharge/blob/master/screenshots/A6_dashboard.png" width="200" title="Dashboard"> <img src="https://github.com/shivumgrover/EazyCharge/blob/master/screenshots/A7_manual_price.png" width="200" title="Update Price"> 

<img src="https://github.com/shivumgrover/EazyCharge/blob/master/screenshots/A7_suggested_Price.png" width="200" title="Suggested Price"> 
