package hw6.notes.service;/**
 * Created by ivan on 17.06.15.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import hw6.notes.domain.Notebook;

public class Menu extends Application {

 private NotebookServiceImpl nbsi;

 public NotebookServiceImpl getNbsi() {
  return nbsi;
 }

 public void setNbsi(NotebookServiceImpl nbsi) {
  this.nbsi = nbsi;
 }

/*
main()

void deleteByModel()
void showByVendor()
void showByPriceManufDate()
void showBetweenPriceLtDateByVendor()
     */
   private void checkNotebookServiceImpl(){
      if(nbsi==null){
         nbsi=new NotebookServiceImpl();
      }
   }

   public void deleteNtb(Notebook notebook){
       checkNotebookServiceImpl();
       nbsi.delete(notebook.getId());
   }

    void changePrice(Notebook notebook){
        checkNotebookServiceImpl();
        nbsi.changePrice(notebook.getId(),notebook.getPrice());
    }

    void changeSerialVendor(Notebook notebook){
        checkNotebookServiceImpl();
        nbsi.changeSerialVendor(notebook.getId(),notebook.getSerial(),notebook.getVendor());
    }

    void deleteByModel(){
        checkNotebookServiceImpl();
        System.out.println("Please, type model here:");
        String model="";
        nbsi.deleteByModel(model);
    }

    void showByVendor(){

    }
    void showByPriceManufDate(){

    }
    void showBetweenPriceLtDateByVendor(){

    }

    public static void main(String[] args)
    {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
//        primaryStage.setResizable(false);
//
//        BorderPane borderPane = new BorderPane();
//
//        Scene scene = new Scene(borderPane, 600, 400);
//        primaryStage.setTitle("`NOTEBOOK`shop by ivan");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//
//        TextArea outputInfo = new TextArea();
//        outputInfo.setEditable(false);
//        borderPane.setLeft(outputInfo);
//
//
////        TextField ipText = new TextField("localhost");
//        TextField portText = new TextField("30000");
//        Button connectButton = new Button("Connect");
//        FlowPane connect = new FlowPane(ipText, portText, connectButton);
//        borderPane.setTop(connect);
//
//        TextArea chatText = new TextArea();
//        chatText.setEditable(false);
//        borderPane.setCenter(chatText);
//
//        TextField messageText = new TextField();
//        Button sendMessageButton = new Button("Send");
//
//        Text errorText = new Text(" ");
//        errorText.setFill(Color.RED);
//        FlowPane message = new FlowPane(messageText,sendMessageButton, errorText);
//        borderPane.setBottom(message);

    }
}
