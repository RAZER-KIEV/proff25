package hw7.notes.view;

import hw7.notes.domain.CPU;
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


public class CreateCPU {

    private NotebookService service;
    private VBox box;

    public CreateCPU(NotebookService service) {
        this.service = service;
        create();
    }

    public void create() {
        box = new VBox();

        List<Vendor> vendorList = service.listAllVendors();
        List<String> vendorsNamesList = new LinkedList<>();
        vendorList.forEach(vendor -> vendorsNamesList.add(vendor.getName()));

        ChoiceBox choiceBox = new ChoiceBox(FXCollections.observableArrayList(vendorsNamesList));

        TextField codeName = new TextField();
        codeName.setPromptText("Code Name");
        TextField clockRate = new TextField();
        clockRate.setPromptText("Clock Rate");
        Button button = new Button("Create");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int index =  choiceBox.getSelectionModel().getSelectedIndex();
                CPU cpu = new CPU(vendorList.get(index), Integer.parseInt(clockRate.getText()), codeName.getText());
                service.createCPU(cpu);
            }
        });
        box.getChildren().addAll(choiceBox,codeName,clockRate,button);
    }

    public VBox getBox() {
        return box;
    }
}
