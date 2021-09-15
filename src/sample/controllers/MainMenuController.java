package sample.controllers;

import javafx.event.ActionEvent;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button customerBtn;

    @FXML
    private Button constructorBtn;

    @FXML
    private Button clearDataBtn;

    @FXML
    void clearData(ActionEvent event) throws IOException {
        FileWriter file = new FileWriter("orderTable.bin");
        file.close();
        file = new FileWriter("constrTable.bin");
        file.close();
    }

    @FXML
    private void openCustomerMenu(ActionEvent e) throws IOException {
        Stage stage = (Stage) customerBtn.getScene().getWindow();
        stage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/fxml/customerMenu.fxml"));

        Parent root = (Parent) loader.load();
        stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Меню заказчика");
        stage.show();
    }

    @FXML
    private void openConstructorMenu(ActionEvent e) throws IOException {
        Stage stage = (Stage) constructorBtn.getScene().getWindow();
        stage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/fxml/constructorMenu.fxml"));

        Parent root = (Parent) loader.load();
        stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Меню главного конструктора");
        stage.show();
    }
}
