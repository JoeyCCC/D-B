from ultralytics import YOLO
import time

# prediction function
# can deal with images, directories and video streams
class prediction(object):

    def __init__(self,modelpath):
        self.modelabs = "model\\" + modelpath
        self.model = YOLO(self.modelabs)

    def predict(self,imagepath,confidence):

        source=imagepath
        results=self.model.predict(source,save=True,project="DnB3",name="ans",exist_ok=True,conf=confidence)
        return self.objList(results)


    def predictCamera(self,frame,confidence):
        t1 = time.time()
        results=self.model.predict(frame,conf=confidence)
        t2 = time.time()
        print("pre:%fms" % ((t2 - t1) * 1000))
        annFrame=results[0].plot()
        return annFrame,self.objList(results)


    def objList(self,results):
        objDetectedList = []
        if len(results) != 0:
            for item in results:
                book = 0
                cube = 0
                key = 0
                for i in (item.boxes.cls.tolist()):
                    if i == 0:
                        book += 1
                    elif i == 1:
                        cube += 1
                    elif i == 2:
                        key += 1
                objDetectedList.append(book)
                objDetectedList.append(cube)
                objDetectedList.append(key)
        print(objDetectedList)
        return objDetectedList