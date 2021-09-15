package sample.controllers;

import java.io.*;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import sample.Order;

public class AddOrderController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea techTaskArea;

    @FXML
    private Button addTechTaskBtn;

    @FXML
    private Button backBtn;

    @FXML
    void addOrderBtn(ActionEvent event) throws IOException {
        if (!techTaskArea.getText().equals("")) {
            Order order = new Order(techTaskArea.getText(), 0, false, false);
            FilesController.writeOrder(order, "orderTable.bin");
            back(event);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Поле с техническим заданием не может быть пустым!");
            alert.showAndWait();
        }

    }

    @FXML
    void back(ActionEvent event) throws IOException {
        Stage stage = (Stage) backBtn.getScene().getWindow();
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
    void initialize() {

    }

}
