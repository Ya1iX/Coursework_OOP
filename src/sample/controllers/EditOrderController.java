package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import sample.Order;

public class EditOrderController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea techTask;

    @FXML
    private TextField priceField;

    @FXML
    private Button createTeamBtn;

    @FXML
    private Label payStatusLabel;

    @FXML
    private Label regStatusLabel;

    @FXML
    private Button regOrderBtn;

    @FXML
    private Button backBtn;

    private Order curOrder;

    @FXML
    void back(ActionEvent event) throws IOException {
        Stage stage = (Stage) backBtn.getScene().getWindow();
        stage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/fxml/constructorMenu.fxml"));

        Parent root = (Parent) loader.load();
        stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Меню главного конструктора");
        stage.show();
    }

    @FXML
    void createTeam(ActionEvent event) throws IOException{
        Stage stage = (Stage) createTeamBtn.getScene().getWindow();
        stage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/fxml/createTeamMenu.fxml"));
        Parent root = (Parent) loader.load();
        CreateTeamController createTeamController = loader.getController();

        createTeamController.setInformation(curOrder);
        stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Формирование бригады");
        stage.show();
    }

    @FXML
    void regOrder(ActionEvent event) throws IOException{
        if(priceField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Поле с ценой не может быть пустым!");
            alert.showAndWait();
        } else if(Integer.parseInt(priceField.getText()) > 0 && Integer.parseInt(priceField.getText()) < Integer.MAX_VALUE) {
            curOrder.setRegistered(true);
            curOrder.setPrice(Integer.parseInt(priceField.getText()));
            FilesController.changeOrder(curOrder, "orderTable.bin");
            back(event);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("В поле с ценой указаны некорректные данные!");
            alert.showAndWait();
        }

    }

    @FXML
    void initialize() {
        priceField.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));
    }

    @FXML
    public void setInformation(Order order){
        this.curOrder = order;
        this.techTask.setText(order.getTechTask());
        this.priceField.setText(String.valueOf(order.getPrice()));
        this.payStatusLabel.setText(order.isPaid() ? "Оплачено" : "Не оплачено");
        this.payStatusLabel.setTextFill(order.isPaid() ? Color.LIGHTGREEN : Color.INDIANRED);
        this.createTeamBtn.setDisable(order.isPaid() ? false : true);
        this.regOrderBtn.setDisable(order.isRegistered() ? true : false);
        this.priceField.setEditable(order.isRegistered() ? false : true);
        this.regStatusLabel.setText(order.isRegistered() ? "Зарегистрирован" : "Не зарегистрирован");
        this.regStatusLabel.setTextFill(order.isRegistered() ? Color.LIGHTGREEN : Color.INDIANRED);
    }
}
