package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Constructor;
import sample.Order;

public class AboutTeamController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Constructor> constrTable;

    @FXML
    private TableColumn<Constructor, String> name;

    @FXML
    private TableColumn<Constructor, Integer> workExp;

    @FXML
    private Button backBtn;

    @FXML
    void back(ActionEvent event) throws IOException {
        Stage stage = (Stage) backBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
    }

    @FXML
    public void setInformation(Order order){
        ObservableList<Constructor> constrArr = FXCollections.observableArrayList(order.getConstrTeam());
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        workExp.setCellValueFactory(new PropertyValueFactory<>("workExp"));
        constrTable.setItems(constrArr);
    }
}
