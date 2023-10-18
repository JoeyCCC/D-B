# Introduction

YOLO WINDOW is a YOLOv8 GUI developed with PyQt5 and qdarkstyle(QSS). 

![](https://pic.imgdb.cn/item/652e7fd0c458853aefb3f8a1.jpg)

YOLO WINDOW is a simple but powerful GUI. YOLO WINDOW has clean user interface and high-integrated functions. Every widget has their special functions and can be easily used. It is designed to integrate many useful functions, such as getting data stream, object detection and database connection. You can start your YOLO prediction easily with the help of YOLO WINDOW!

# Install

Decompress the zip file, and then configure the environment. 

```cmd
pip install -r requirements.txt
```

CAUTION: Please do create a new virtual environment with conda because there are too many items in the requirement.txt and we cannot ensure they will not conflict with the packages you have installed before.

# Start

Run the YOLO_WINDOW.py and everything will start.

# Documentation

## Settings

### model

Pre-trained YOLOv8 models are provided to choose. The "last.pt" model is the default model which used more than 3800 labelled pictures to train. It can detect 3 treasures(book, cube, key) with high precision. There are also may other models you can choose, just click the box and chose you want. 

You can also use self-trained models. Just place you models in the "model" directory, YOLO WINDOW can automatically detect it.

### source

#### image

Choose a single picture to do the prediction. The picture must in jpg or png format. It can also predict a directory, but only last picture will be shown on the UI. Results will be saved to "DnB3/ans" directory.

#### camera

Local camera can be shown on the UI as well as the video that is predicted. All of them are real time! Note that YOLO WINDOW can only invoke the default camera. Other camera need configuration. Notice that no video will be saved.

#### stream*

Stream button is used to connect the robot with WIFI module and get the video stream(will be saved to "images" directory). The default frame per second is 3(due to the restriction of hardware), but is can be changed by users. Results will be saved to "DnB3/ans" directory.

### confidence

This is a parameter that used to do the prediction. You can adjust it with the slide or the double spin box(these 2 widgets can be changed at the same time). Note that please do not make the value too low, because it will do too many wrong predictions and will make the picture in a mess.

### automatically start

With this button on, no clicking on the start button is needed.

### result statistics

Show the number of treasures.

### Information

Important information are shown which are database information & detection results saved.

## View

The pictures before prediction and after prediction.

#### start

start button is used to start a prediction of a single image.

#### stop

Stop button is used to stop the camera stream.

## Connection issues

![](https://pic.imgdb.cn/item/652e92a3c458853aeff31e8f.jpg)

### getting video stream

-- from the robot developed by Telecom members.

We use WIFI module to get video stream. A Python program is written to get stream in a proper speed. The stream can be easily accessed by the given URL.

### connecting to database

-- developed by E-commerce members.

We use PyMySQL module to connect to MySQL database. Use the IP address and all permitted privileges, we can access database developed by E-commerce members. MySQL queries are written to insert data or retrieve data. 



***All contents are produced by group 5(DnB2023)***