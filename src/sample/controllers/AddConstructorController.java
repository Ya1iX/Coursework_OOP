package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import sample.Constructor;
import sample.Order;

public class AddConstructorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addConstructorBtn;

    @FXML
    private Button backBtn;

    @FXML
    private TextField nameLabel;

    @FXML
    private TextField workExpLabel;

    private Order curOrder;

    @FXML
    void addConstructor(ActionEvent event) throws IOException {
        if(workExpLabel.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Поле со стажем содержит некорректные данные!");
            alert.showAndWait();
            return;
        }
        if (nameLabel.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Поле с именем не может быть пустым!");
            alert.showAndWait();
            return;
        }
        if(Integer.parseInt(workExpLabel.getText()) >= 0 && Integer.parseInt(workExpLabel.getText()) <= 100) {
            Constructor constructor = new Constructor(nameLabel.getText(), Integer.parseInt(workExpLabel.getText()));
            FilesController.writeConstructor(constructor, "constrTable.bin");
            back(event);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Стаж может принимать значения от 0 до 100!");
            alert.showAndWait();
        }
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        Stage stage = (Stage) backBtn.getScene().getWindow();
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
    void initialize() {
        workExpLabel.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));
    }

    @FXML
    public void setInformation(Order order){
        this.curOrder = order;
    }
}
