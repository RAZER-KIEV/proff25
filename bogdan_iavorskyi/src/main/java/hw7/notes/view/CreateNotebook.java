package hw7.notes.view;

import hw7.notes.Main;
import hw7.notes.domain.CPU;
import hw7.notes.domain.Memory;
import hw7.notes.domain.Notebook;
import hw7.notes.domain.Vendor;
import hw7.notes.service.NotebookService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


public class CreateNotebook {

    private NotebookService service;
    private VBox box;

    public CreateNotebook() {
        this.service = Main.getService();
        create();
    }

    public void create() {
        box = new VBox();

        List<Vendor> vendorsList = service.listAllVendors();
        List<String> vendorsNamesList = new LinkedList<>();
        vendorsList.forEach(vendor -> vendorsNamesList.add(vendor.getName()));
        List<CPU> cpuList = service.listAllCPUs();
        List<String> cpuStringRepresentationList = new LinkedList<>();
        cpuList.forEach(cpu -> {
            String str = cpu.getVendor().getName() + "/" + cpu.getCodeName() + "/" + cpu.getClockRate();
            cpuStringRepresentationList.add(str);
        });
        List<Memory> memoryList = service.listAllMemories();
        List<String> memoryStringRepresentationList = new LinkedList<>();
        memoryList.forEach(memory -> {
            String str = memory.getVendor().getName() + "/" + memory.getSize();
            memoryStringRepresentationList.add(str);
        });
        ChoiceBox choiceVendorBox = new ChoiceBox(FXCollections.observableArrayList(vendorsNamesList));
        ChoiceBox choiceCPUBox = new ChoiceBox(FXCollections.observableArrayList(cpuStringRepresentationList));
        ChoiceBox choiceMemoryBox = new ChoiceBox(FXCollections.observableArrayList(memoryStringRepresentationList));
        TextField modelName = new TextField();
        modelName.setPromptText("Model name");
        Button button = new Button("Create");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int vendorIndex = choiceVendorBox.getSelectionModel().getSelectedIndex();
                int cpuIndex = choiceCPUBox.getSelectionModel().getSelectedIndex();
                int memoryIndex = choiceMemoryBox.getSelectionModel().getSelectedIndex();
                GregorianCalendar calendar = new GregorianCalendar();
                calendar.get(GregorianCalendar.YEAR);
                LocalDate localDate = LocalDate.now();
                Notebook notebook =
                        new Notebook(vendorsList.get(vendorIndex), modelName.getText(),
                        cpuList.get(cpuIndex), memoryList.get(memoryIndex), localDate
                        );
                service.createNotebook(notebook);
            }
        });
        box.getChildren().addAll(choiceVendorBox, choiceCPUBox, choiceMemoryBox, modelName, button);
    }

    public VBox getIt() {
        return box;
    }
}
