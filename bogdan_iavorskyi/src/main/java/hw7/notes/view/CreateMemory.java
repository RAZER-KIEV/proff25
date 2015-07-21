package hw7.notes.view;

import hw7.notes.Main;
import hw7.notes.domain.Memory;
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


public class CreateMemory {

    private NotebookService service;
    private VBox box;

    public CreateMemory() {
        this.service = Main.getService();
        create();
    }

    public void create() {
        box = new VBox();

        List<Vendor> vendorsList = service.listAllVendors();
        List<String> vendorsNamesList = new LinkedList<>();
        vendorsList.forEach(vendor -> vendorsNamesList.add(vendor.getName()));
        ChoiceBox choiceBox = new ChoiceBox(FXCollections.observableArrayList(vendorsNamesList));
        TextField memorySize = new TextField();
        memorySize.setPromptText("Memory size(in MB)");
        Button button = new Button("Create");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int index = choiceBox.getSelectionModel().getSelectedIndex();
                Memory memory = new Memory(vendorsList.get(index), Integer.parseInt(memorySize.getText()));
                service.createMemory(memory);
            }
        });
        box.getChildren().addAll(choiceBox, memorySize, button);
    }

    public VBox getIt() {
        return box;
    }
}
