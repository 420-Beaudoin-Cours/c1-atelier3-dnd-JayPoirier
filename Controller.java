package sample;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;

public class Controller {

    public  TextField txfTarget;
    public  TextField txfSource;
    public  ComboBox cmbTarget;
    public ImageView imvTarget;

    public void txfSourceDragDetected(MouseEvent mouseEvent) {
        if (!txfSource.getText().isEmpty()) {
            Dragboard db = txfSource.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putString(txfSource.getText());
            db.setContent(content);
        }
    }

    public void cmbTargetDragDrop(DragEvent dragEvent) {
        Dragboard db = dragEvent.getDragboard();
        cmbTarget.getItems().add( db.getString() );
        cmbTarget.getSelectionModel().selectLast();
        txfSource.clear();
    }

    public void cmbTargetDragOver(DragEvent dragEvent) {
        dragEvent.acceptTransferModes( TransferMode.ANY );
    }

    public void imvTargetDragDrop(DragEvent dragEvent) {
        Dragboard db = dragEvent.getDragboard();
        db.getString().isBlank();
        txfSource.clear();
    }

    public void imvTargetDragOver(DragEvent dragEvent) {
        dragEvent.acceptTransferModes( TransferMode.ANY );
    }
}
