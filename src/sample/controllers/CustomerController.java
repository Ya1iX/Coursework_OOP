package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Order;

import java.io.IOException;

public class CustomerController {

    @FXML
    private Button custBackBtn;

    @FXML
    private TableView<Order> orderList;

    @FXML
    private TableColumn<Order, String> techTask;

    @FXML
    private TableColumn<Order, Integer> price;

    @FXML
    private TableColumn<Order, Integer> teamSize;

    @FXML
    private Button addOrderBtn;

    @FXML
    private Button moreBtn;

    @FXML
    void aboutOrder(ActionEvent event) throws IOException{
        Order selectedOrder = orderList.getSelectionModel().selectedItemProperty().getValue();
        if(selectedOrder != null){
            Stage stage = (Stage) moreBtn.getScene().getWindow();
            stage.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/fxml/aboutOrderMenu.fxml"));
            Parent root = (Parent) loader.load();
            AboutOrderController aboutOrderController = loader.getController();

            aboutOrderController.setInformation(selectedOrder);
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
    private void openMainMenu(ActionEvent e) throws IOException {
        Stage stage = (Stage) custBackBtn.getScene().getWindow();
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
    private void addOrder(ActionEvent e) throws IOException {
        Stage stage = (Stage) addOrderBtn.getScene().getWindow();
        stage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/fxml/addOrderMenu.fxml"));

        Parent root = (Parent) loader.load();
        stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Добавление заказа");
        stage.show();
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
