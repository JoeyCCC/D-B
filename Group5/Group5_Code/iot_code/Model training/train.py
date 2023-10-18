from ultralytics import YOLO

if __name__=='__main__':
  #model = YOLO('yolov8n.yaml')
  model = YOLO('yolov8n.pt')

  model.train(
    data = 'D:\pythonProject\DnB3\datasetsCust5\data\data.yaml',
    epochs =1,
    imgsz = 640,
    workers=2,
    batch=25
  )
