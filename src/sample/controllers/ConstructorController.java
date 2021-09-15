package sample.controllers;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Order;

public class ConstructorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button constrBackBtn;

    @FXML
    private TableView<Order> orderList;

    @FXML
    private TableColumn<Order, String> techTask;

    @FXML
    private TableColumn<Order, Integer> price;

    @FXML
    private TableColumn<Order, Integer> teamSize;

    @FXML
    private Button selectOrderBtn;

    @FXML
    private void openMainMenu(ActionEvent e) throws IOException {
        Stage stage = (Stage) constrBackBtn.getScene().getWindow();
        stage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/fxml/mainMenu.fxml"));

        Parent root = (Parent) loader.load();
        stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Строительная фирма");
        stage.show();
    }

    @FXML
    private void openEditMenu(ActionEvent e) throws IOException {
        Order selectedOrder = orderList.getSelectionModel().selectedItemProperty().getValue();
        if(selectedOrder != null){
            Stage stage = (Stage) selectOrderBtn.getScene().getWindow();
            stage.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/fxml/editOrderMenu.fxml"));
            Parent root = (Parent) loader.load();
            EditOrderController editOrderController = loader.getController();

            editOrderController.setInformation(selectedOrder);
            stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.setTitle("Просмотр заказа");
            stage.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Вы не выбрали заказ из таблицы!");
            alert.showAndWait();
        }
    }

    @FXML
    void initialize() {
        try {
            ObservableList<Order> orderArr = FXCollections.observableArrayList(FilesController.readOrders("orderTable.bin"));
            techTask.setCellValueFactory(new PropertyValueFactory<>("techTask"));
            price.setCellValueFactory(new PropertyValueFactory<>("price"));
            teamSize.setCellValueFactory(new PropertyValueFactory<>("teamSize"));
            orderList.setItems(orderArr);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Не удалось прочитать файл с заказами!");
            alert.showAndWait();
        }
    }
}
