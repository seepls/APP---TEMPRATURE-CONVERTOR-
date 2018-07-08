package com.smriti.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void init() throws Exception {
        System.out.println("init");
        super.init();// initializes the application
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("start"); // starts an application
        FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
        VBox rootNode = loader.load();
        MenuBar menuBar =createMenu();
        rootNode.getChildren().add(0,menuBar);// adds menubar to the vbox at index 0 , as first child

        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temprature Convertor");
        primaryStage.setResizable(false);// makes fixed
        primaryStage.show(); // makes application visible to user

    }


    private MenuBar createMenu(){
        //file menu
        Menu  fileMenu = new Menu ("File");
        MenuItem newMenuItem = new MenuItem("New");
        newMenuItem.setOnAction(event -> System.out.println("new menu item clicked  "));
        // lambda expression , if multiple lines of code put all in {}
        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem quitMenuItem = new MenuItem("Quit");
        quitMenuItem.setOnAction(event -> Platform.exit());

        fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);

        //help menu
        Menu helpMenu =new Menu("Help");
        MenuItem aboutapp = new MenuItem("About");
        aboutapp.setOnAction(event -> aboutapp());

        helpMenu.getItems().addAll(aboutapp); // integrating these with the main
        //Menu bar
        MenuBar menuBar =new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;


    }

    private void aboutapp() {
        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle(" TEMPRATURE ");
        alertDialog.setHeaderText("temprature scaling ");
        alertDialog.setContentText("the app converts the input temprature in one scale to another! :)  ");
        ButtonType yesBtn = new ButtonType("OK");
        //ButtonType noBtn = new ButtonType("no");
        alertDialog.getButtonTypes().setAll(yesBtn);
        // optional class is a container , here contains object of ButtonType
        Optional<ButtonType> clickedBtn =  alertDialog.showAndWait();
        if(clickedBtn.isPresent() && clickedBtn.get() == yesBtn){
            System.out.println("yes clicked ! ");
        }else System.out.println("no botton !");


    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop");
        super.stop();
    }
}
