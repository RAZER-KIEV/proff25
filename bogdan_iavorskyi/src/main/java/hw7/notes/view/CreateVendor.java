package hw7.notes.view;

import hw7.notes.domain.Vendor;
import hw7.notes.service.NotebookService;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by bosyi on 29.06.15.
 */
public class CreateVendor {

    private NotebookService service;
    private VBox box;

    public CreateVendor(NotebookService service) {
        this.service = service;
        create();
    }

    public void create() {
        box = new VBox();
        TextField field = new TextField();
        Button button = new Button("Create");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Vendor vendor = new Vendor(field.getText());
                service.createVendor(vendor);
                field.setText("");
            }
        });
        box.getChildren().addAll(field,button);
    }

    public VBox getBox() {
        return box;
    }
}
