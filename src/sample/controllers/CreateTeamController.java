package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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
import sample.Constructor;
import sample.Order;

public class CreateTeamController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button employBtn;

    @FXML
    private TableView<Constructor> constrTable;

    @FXML
    private TableColumn<Constructor, String> name;

    @FXML
    private TableColumn<Constructor, Integer> workExp;

    @FXML
    private TableColumn<Constructor, String> isEmployed;

    @FXML
    private Button backBtn;

    @FXML
    private Button removeBtn;

    @FXML
    private Button addConstructorBtn;

    private Order curOrder;

    @FXML
    void back(ActionEvent event) throws IOException{
        Stage stage = (Stage) backBtn.getScene().getWindow();
        stage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/fxml/editOrderMenu.fxml"));
        Parent root = (Parent) loader.load();
        EditOrderController editOrderController = loader.getController();

        editOrderController.setInformation(curOrder);
        stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Просмотр заказа");
        stage.show();
    }

    @FXML
    void removeConstructor(ActionEvent event) throws IOException {
        Constructor selectedConstructor = constrTable.getSelectionModel().selectedItemProperty().getValue();
        if(selectedConstructor == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Вы не выбрали конструктора из таблицы!");
            alert.showAndWait();
            return;
        }
        if (selectedConstructor.isEmployed()) {
            int constructorIndex = -1;
            ArrayList<Constructor> constructors = curOrder.getConstrTeam();
            selectedConstructor.setEmployed(false);
            FilesController.changeConstructor(selectedConstructor, "constrTable.bin");
            for (int i = 0; i < constructors.size(); i++) {
                if (constructors.get(i).getConstructorId() == selectedConstructor.getConstructorId()) constructorIndex = i;
            }
            constructors.remove(constructorIndex);
            curOrder.setConstrTeam(constructors);
            FilesController.changeOrder(curOrder, "orderTable.bin");
            initialize();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Конструктор уже свободен!");
            alert.showAndWait();
        }
    }

    @FXML
    void employConstructor(ActionEvent event) throws IOException {
        Constructor selectedConstructor = constrTable.getSelectionModel().selectedItemProperty().getValue();
        if(selectedConstructor == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Вы не выбрали конструктора из таблицы!");
            alert.showAndWait();
            return;
        }
        if (!selectedConstructor.isEmployed()) {
            ArrayList<Constructor> constructors = curOrder.getConstrTeam();
            selectedConstructor.setEmployed(true);
            FilesController.changeConstructor(selectedConstructor, "constrTable.bin");
            constructors.add(selectedConstructor);
            curOrder.setConstrTeam(constructors);
            FilesController.changeOrder(curOrder, "orderTable.bin");
            initialize();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Конструктор уже занят!");
            alert.showAndWait();
        }
    }

    @FXML
    void addConstructor(ActionEvent event) throws IOException{
        Stage stage = (Stage) backBtn.getScene().getWindow();
        stage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/fxml/addConstructorMenu.fxml"));
        Parent root = (Parent) loader.load();
        AddConstructorController addConstructorController = loader.getController();

        addConstructorController.setInformation(curOrder);
        stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Добавление конструктора");
        stage.show();
    }

    @FXML
    void initialize() {
        try {
            ObservableList<Constructor> constrArr = FXCollections.observableArrayList(FilesController.readConstructors("constrTable.bin"));
            name.setCellValueFactory(new PropertyValueFactory<>("name"));
            workExp.setCellValueFactory(new PropertyValueFactory<>("workExp"));
            isEmployed.setCellValueFactory(new PropertyValueFactory<>("isEmployedStr"));
            constrTable.setItems(constrArr);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Не удалось прочитать файл с конструкторами!");
            alert.showAndWait();
        }
    }

    @FXML
    public void setInformation(Order order) {
        this.curOrder = order;
    }
}
