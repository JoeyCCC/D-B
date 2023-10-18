
# main logic operations
# connection between different widgets
from PyQt5.QtCore import QTimer
from ui6 import *
from fileoperation import *
from predict import *
from PyQt5.QtGui import QImage, QPixmap,QPalette,QColor
from PyQt5.QtWidgets import QGraphicsPixmapItem, QGraphicsScene
from wdswe import *
import pymysql
import cv2
import time
import os
import requests


class uiWindow(Ui_MainWindow):
    # new attributes
    modellist = getFiles("model");
    image1 = ""
    cap=None
    timer=None
    UIprediction=None
    path=None
    num=1
    # end

    def newUI(self):
        self.comboBox.clear()
        # add combobox items whose amount equals the number of models -- |z|
        for item in range(len(self.modellist)):
            self.comboBox.addItem("")
        # self.comboBox.addItem("")
        self.pushButton.clicked.connect(self.setCamera)
        self.pushButton.clicked.connect(self.videoConn)
        self.pushButton_2.clicked.connect(self.getImageFile)
        self.pushButton_3.clicked.connect(self.setResultImage)
        self.pushButton_3.setDisabled(True)
        self.pushButton_5.clicked.connect(self.getStream)
        # connection -- |z|
        self.horizontalSlider.valueChanged.connect(lambda: self.sliderconn())
        self.doubleSpinBox.valueChanged.connect(lambda: self.spinconn())
        self.doubleSpinBox.setValue(0.3)
        #
        self.label_13.setStyleSheet("color: rgb(255, 106, 87);\nfont: 8pt \"Microsoft YaHei UI\";")
        self.label_13.setText("hello")
        #
        # end
        _translate = QtCore.QCoreApplication.translate
        # rewrite -- |z|
        i = 0
        for item in self.modellist:
            self.comboBox.setItemText(i, _translate("MainWindow", item))
            i += 1

    def getImageFile(self):
        if self.graphicsView_2.scene() is not None:
            self.graphicsView_2.scene().clear()
        self.UIprediction = prediction(self.comboBox.currentText())
        self.path=QtWidgets.QFileDialog.getOpenFileName(self.centralwidget,"choose an image",'.','(*.jpg *.png)')
        self.progressBar.setValue(0)
        print(self.path[0])
        self.image1=self.path[0]
        self.showImage(self.graphicsView,self.image1)
        self.path=self.path[0]
        #self.progressBar.setValue(10)
        if self.radioButton.isChecked():
            self.setResultImage()
        else:
            self.pushButton_3.setEnabled(True)


    def setResultImage(self):
        predRet = self.UIprediction.predict(self.path, self.doubleSpinBox.value())
        self.progressBar.setValue(50)
        start = self.path.rindex('/')
        result = self.path[start + 1:]
        image2 = "DnB3/ans/" + result
        self.progressBar.setValue(70)
        self.showImage(self.graphicsView_2, image2)
        self.progressBar.setValue(80)
        namestart=self.path.rindex('.')
        name=self.path[namestart+1:]
        #self.sqlInput(predRet,name)
        self.progressBar.setValue(90)
        self.updateStatistics(predRet)
        self.progressBar.setValue(100)
        self.num+=1
        #self.showImage(self.graphicsView_3, "MeanByMonth.jpg")
        self.pushButton_3.setDisabled(True)

    def showImage(self,graphicsview,image):
        frame=QImage(image)
        pix=QPixmap.fromImage(frame)
        item=QGraphicsPixmapItem(pix)
        scene=QGraphicsScene()
        scene.addItem(item)
        graphicsview.setScene(scene)
        graphicsview.fitInView(scene.sceneRect(),1)


    def sliderconn(self):
        self.doubleSpinBox.setValue(self.horizontalSlider.value()/100)


    def spinconn(self):
        self.horizontalSlider.setValue(self.doubleSpinBox.value()*100)


    def setCamera(self):
        self.UIprediction=prediction(self.comboBox.currentText())
        self.timer=QTimer()
        self.cap=cv2.VideoCapture(0)
        self.timer.start(20)
        self.pushButton_4.clicked.connect(self.destoryCamera)


    def videoConn(self):
        self.timer.timeout.connect(self.showCamera)


    def showCamera(self):
        flag,img=self.cap.read()

        if flag:
            t1 = time.time()
            img2=img
            img,predRet = self.UIprediction.predictCamera( img, self.doubleSpinBox.value())
            self.cameraPaint(self.graphicsView_2,img)
            self.cameraPaint(self.graphicsView,img2)
            self.updateStatistics(predRet)
            t2 = time.time()
            print("%fms" %((t2-t1)*1000))
        else:
            self.graphicsView_2.scene().clear()
            self.cap.release()
            self.timer.stop()


    def destoryCamera(self):
        self.graphicsView_2.scene().clear()
        self.graphicsView.scene().clear()
        self.cap.release()
        self.timer.stop()


    def updateStatistics(self,predRet):
        self.label_8.clear()
        self.label_9.clear()
        self.label_10.clear()
        self.label_8.setText("book: " + str(predRet[0]))
        self.label_9.setText("cube: " + str(predRet[1]))
        self.label_10.setText("key:   " + str(predRet[2]))
        self.updateInfo(predRet)
        if self.num==1:
            self.label_13.setText("A new row has been written into \nthe database")
            print("A new row has been written into the database")
        else:
            self.label_13.setText(str(self.num)+" new rows have been written into \nthe database")
            print("%d new rows have been written into the database"%(self.num))

    def cameraPaint(self,graphics,img):
        img = cv2.cvtColor(img, cv2.COLOR_BGR2RGB)
        frame = QImage(img.data, img.shape[1], img.shape[0], QImage.Format_RGB888)
        pix = QPixmap.fromImage(frame)
        item = QGraphicsPixmapItem(pix)
        scene = QGraphicsScene()
        scene.addItem(item)
        graphics.setScene(scene)
        graphics.fitInView(scene.sceneRect(), 1)

    def getStream(self):
        # save_dir='images'
        # if not os.path.exists(save_dir):
        #     os.makedirs(save_dir)
        url='http://192.168.8.1:8083/?action=snapshot'
        number=300
        self.UIprediction = prediction(self.comboBox.currentText())
        #self.path = QtWidgets.QFileDialog.getExistingDirectory(self.centralwidget,"select a directory",".")
        self.path="D:/pythonProject/DnB3/images"
        print(self.path)
        absDir=self.path
        #imageList=getFiles(self.path)
        #print(imageList)
        #directoryPath=self.path
        for i in range(number):
            response = requests.get(url, stream=True)
            time.sleep(0.3)
            if response.status_code == 200:
                print(i)
                absPath=save_image(response, absDir, i + 1)
                self.showImage(self.graphicsView,absPath)
                self.path=absPath
                self.setResultImage()
            else:
                print("获取图片失败")
        # for item in imageList:
        #     self.path=directoryPath+"/"+item
        #     self.showImage(self.graphicsView,self.path)
        #     self.setResultImage()
        #     time.sleep(0.6)

    def updateInfo(self,predRet):
        List=[self.label_15,self.label_16,self.label_17,self.label_18,self.label_19]
        flag=False
        for item in List:
            if item.text() is None:
                item.setText(str(predRet))
                flag=True
                break
        if flag is False:
            for i in range(len(List)-1):
                List[i].setText(List[i+1].text().rstrip("--NEW!"))
            List[-1].setText(str(predRet)+"  --NEW!")

    # connection with mysql
    def sqlInput(self,retList,name):
        # db = pymysql.connect(host='localhost',
        #                      user='root',
        #                      password='lzl030805',
        #                      database='yolo8')
        db = pymysql.connect(host='192.168.43.206',
                             port=3306,
                             user='newuser',
                             password='Dajacky1',
                             database='javauser')
        cursor = db.cursor()
        self.label_13.setText("Successfully connected with the databases")
        print("Successfully connected with the databases")
        query = "insert into treasure(time,book,`cube`,`key`) values (%s,%s,%s,%s) "
        # query = "insert into statistics(book,`cube`,`key`) values (%s,%s,%s) "
        values = (name,retList[0], retList[1], retList[2])

        try:
            cursor.execute(query, values)
            db.commit()
            self.label_13.setText("1 row affected")
            print("1 row affected")
        except:
            print("error!")

        cursor.close()
        db.close()

# upload pictures to the cloud(not used)
    def upload(self):
        url = "https://api.superbed.cn/upload"
        resp = requests.post(url, data={"token": "66165ac80d924aed9533b32f9ac2095d"},
                             files={"file": open(self.path, "rb")})
        print(resp.json()['url'])