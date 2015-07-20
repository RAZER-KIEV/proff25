package hw7.notes.view;

import hw7.notes.domain.CPU;
import hw7.notes.domain.Notebook;
import hw7.notes.domain.Store;
import hw7.notes.domain.Vendor;
import hw7.notes.service.NotebookService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.LinkedList;
import java.util.List;


public class CreateStore {

    private NotebookService service;
    private VBox box;

    public CreateStore(NotebookService service) {
        this.service = service;
        create();
    }

    public void create() {
        box = new VBox();

        List<Notebook> notebookList = service.listAllNotebooks();
        List<String> notebookNamesList = new LinkedList<>();
        notebookList.forEach(notebook -> {
            String str = notebook.getVendor().getName() + "/" +
                    notebook.getModelName() + "/" +
                    notebook.getCpu().getVendor().getName() + "-" +
                    notebook.getCpu().getCodeName() + "-" +
                    notebook.getCpu().getClockRate() + "/" +
                    notebook.getMemory().getVendor().getName() + "-" +
                    notebook.getMemory().getSize() + "/" +
                    notebook.getDateTime();

            notebookNamesList.add(str);
        });

        ChoiceBox choiceBox = new ChoiceBox(FXCollections.observableArrayList(notebookNamesList));

        TextField quantity = new TextField();
        quantity.setPromptText("Quantity");
        TextField price = new TextField();
        price.setPromptText("Price(in cents)");
        Button button = new Button("Create");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int index =  choiceBox.getSelectionModel().getSelectedIndex();
                service.receive(notebookList.get(index), Integer.parseInt(quantity.getText()), Integer.parseInt(price.getText()));
            }
        });
        box.getChildren().addAll(choiceBox,quantity,price, button);
    }

    public VBox getBox() {
        return box;
    }
}
