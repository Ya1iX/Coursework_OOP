package sample.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.Order;

public class AboutOrderController {

    @FXML
    private TextArea techTask;

    @FXML
    private Label priceLabel;

    @FXML
    private Label payStatusLabel;

    @FXML
    private Button payOrderBtn;

    @FXML
    private Button backBtn;

    @FXML
    private Label regStatusLabel;

    @FXML
    private Button aboutTeamBtn;

    private Order curOrder;

    @FXML
    void aboutTeam(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/fxml/aboutTeamMenu.fxml"));
        Parent root = (Parent) loader.load();
        AboutTeamController aboutTeamController = loader.getController();

        aboutTeamController.setInformation(curOrder);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Просмотр заказа");
        stage.showAndWait();
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
    void payOrder(ActionEvent event) throws IOException {
        curOrder.setPaid(true);
        FilesController.changeOrder(curOrder, "orderTable.bin");
        back(event);
    }

    @FXML
    void initialize() {

    }

    @FXML
    public void setInformation(Order order){
        this.curOrder = order;
        this.techTask.setText(order.getTechTask());
        this.priceLabel.setText(order.getPrice() > 0 ? String.valueOf(order.getPrice()) + " $" : "Не указана");
        this.priceLabel.setTextFill(order.getPrice() > 0 ? Color.LIGHTGREEN : Color.INDIANRED);
        this.payOrderBtn.setDisable(!order.isPaid() & order.isRegistered() ? false : true);
        this.regStatusLabel.setText(order.isRegistered() ? "Зарегистрирован" : "Не зарегистрирован");
        this.regStatusLabel.setTextFill(order.isRegistered() ? Color.LIGHTGREEN : Color.INDIANRED);
        this.payStatusLabel.setText(order.isPaid() ? "Оплачено" : "Не оплачено");
        this.payStatusLabel.setTextFill(order.isPaid() ? Color.LIGHTGREEN : Color.INDIANRED);
        this.aboutTeamBtn.setDisable(order.getTeamSize() > 0 ? false : true);
    }
}
