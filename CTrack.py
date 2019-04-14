
# coding: utf-8

# In[ ]:


import cv2
import numpy as np
import os, time
import io
import time
from firebase import firebase
from random import randint


fbls = []
def loadModel():
    global YOLO
    global labels
    labelsPath = "coco.names"
    labels = open(labelsPath).read().strip().split("\n")
    weightsPath = "yolov3.weights"
    configPath = "yolov3.cfg"
    YOLO = cv2.dnn.readNetFromDarknet(configPath, weightsPath)


def prepareImage(image):
    global ln
    ln = YOLO.getLayerNames()
    ln = [ln[i[0] - 1] for i in YOLO.getUnconnectedOutLayers()]
    blob = cv2.dnn.blobFromImage(image, 1/255.0, (416, 416), swapRB = True, crop = False)
    return blob


def predict():
    num = 0
    vid = cv2.VideoCapture(0)
    
    ret, frame = vid.read()
    vid.release()
    print("Frame Captured")
    blob = prepareImage(frame)
    YOLO.setInput(blob)
    layerOutputs = YOLO.forward(ln)
    boxes = []
    confidences = []
    classIDs = []
    for output in layerOutputs:
        for detection in output:
            scores = detection[5:]
            classID = np.argmax(scores)
            confidence = scores[classID]
            if confidence > 0.6 and labels[classID] == 'car':
                num += 1
    fbls.append(num)
    #

global fb
fb = firebase.FirebaseApplication('https://echarging-f3759.firebaseio.com/')
starttime = time.time()
loadModel()
n_each = 0
ctr = 0
day = 0
while True:
    ctr += 1
    predict()
    print(ctr)
    time.sleep(0.5 - ((time.time() - starttime) % 0.5))
    n_each += 1
    if(n_each % 24) == 0:
        fb.patch('/num_cars/', {day: fbls}) 
        day += 1
        fbls = []
    if(day % 7) == 0:
        starttime = time.time()

