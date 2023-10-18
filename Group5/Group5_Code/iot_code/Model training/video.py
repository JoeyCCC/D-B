from ultralytics import YOLO
import cv2
import time

def main():
    model = YOLO('train\weights\\best.pt')
    cap = cv2.VideoCapture(0)
    while cap.isOpened():
        success, frame = cap.read()

        if success:
            t1=time.time()
            results = model(frame,conf=0.35)
            if len(results) !=0:
                for result in results:
                    print(result.boxes.cls.tolist())

            annotated_frame = results[0].plot()

            cv2.imshow("original",frame)
            cv2.imshow("YOLOv8 Interface", annotated_frame)

            if cv2.waitKey(1) & 0xFF == ord("q"):
                break
            t2=time.time()
            print("%fms" % ((t2 - t1) * 1000))
        else:
            break

    cap.release()
    cv2.destroyAllWindows()


if __name__ == "__main__":
    main()