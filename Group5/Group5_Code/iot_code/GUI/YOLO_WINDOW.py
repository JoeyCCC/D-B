import qdarkstyle
from PyQt5 import QtCore, QtGui, QtWidgets
from PyQt5.QtGui import QIcon
from ui6 import *
from uison6 import *

# @author: 2023DnB group5(IoT: Zhili Li(|z|), Jiayi Chen, Boyu Feng. Telecom members, E-commerce members)
# logic operations are totally designed by ourselves.
# QSS is partly from "qdarkstyle"(can be installed by pypi). We appreciate their work.
if __name__ == "__main__":
    import sys
    app = QtWidgets.QApplication(sys.argv)
    MainWindow = QtWidgets.QMainWindow()

    app.setStyleSheet(qdarkstyle.load_stylesheet())
    ui = uiWindow()
    ui.setupUi(MainWindow)
    ui.newUI()
    MainWindow.setWindowTitle(" YOLO WINDOW")
    MainWindow.setWindowIcon(QIcon("yolo.png"))#The icon comes from the Internet(link:https://www.flaticon.com/free-icon/yolo_3770954?term=yolo&page=1&position=5&origin=search&related_id=3770954)

    MainWindow.show()
    sys.exit(app.exec_())

