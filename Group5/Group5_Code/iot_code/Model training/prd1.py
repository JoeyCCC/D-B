from ultralytics import YOLO

def main():
    model = YOLO('train\weights\\best.pt')
    source=r'C:\Users\84977\Desktop\testImage\\'
    model.predict(source,save=True,save_txt=True,conf=0.3)


if __name__=="__main__":
    main()