from PyQt5 import QtWidgets,QtGui

# overriding of QGraphicsView
# a self fitting function
class Graphics(QtWidgets.QGraphicsView):
    def resizeEvent(self, event: QtGui.QResizeEvent) -> None:
        super().resizeEvent(event)
        if self.scene() is not None:
            self.fitInView(self.scene().sceneRect(),1)