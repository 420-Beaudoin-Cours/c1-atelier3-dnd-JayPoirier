package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;

public class Controller {

    public ComboBox cmbTarget;
    public ImageView imvTarget;

    @FXML
    public void initialize() {

    }

    public void txfSourceDragDetected(MouseEvent mouseEvent) {
        TextField ref = (TextField) mouseEvent.getSource();
        if (!ref.getText().isEmpty()) {
            Dragboard db = ref.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putString(ref.getText());
            db.setContent(content);
        }
    }
    public void txfTargetDragDrop(DragEvent dragEvent) {
        TextField refSource = (TextField) dragEvent.getGestureSource();
        TextField refTarget = (TextField) dragEvent.getGestureTarget();
        if (refTarget != refSource) {
            Dragboard db = dragEvent.getDragboard();
            refTarget.setText(db.getString());
            refSource.clear();
        }
    }

    public void cmbTargetDragDrop(DragEvent dragEvent) {
        TextField refSource = (TextField) dragEvent.getGestureSource();
        Dragboard db = dragEvent.getDragboard();
        cmbTarget.getItems().add(db.getString());
        cmbTarget.getSelectionModel().selectLast();
        refSource.clear();
    }

    public void imvTargetDragDrop(DragEvent dragEvent) {
        TextField refSource = (TextField) dragEvent.getGestureSource();
        Dragboard db = dragEvent.getDragboard();
        db.getString().isBlank();
        refSource.clear();
    }

    public void txfTargetDragOver(DragEvent dragEvent) {
        dragEvent.acceptTransferModes(TransferMode.ANY);
    }
    public void cmbTargetDragOver(DragEvent dragEvent) {
        dragEvent.acceptTransferModes(TransferMode.ANY);
    }
    public void imvTargetDragOver(DragEvent dragEvent) {
        dragEvent.acceptTransferModes(TransferMode.ANY);
    }
}