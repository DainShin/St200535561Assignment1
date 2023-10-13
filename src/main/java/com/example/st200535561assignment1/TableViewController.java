package com.example.st200535561assignment1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class TableViewController {

    @FXML
    private TableColumn<AgeGroupUnemployment, Integer> idColumn;

    @FXML
    private TableColumn<AgeGroupUnemployment, Double> ageGroup1Column;

    @FXML
    private TableColumn<AgeGroupUnemployment, Double> ageGroup2Column;

    @FXML
    private TableColumn<AgeGroupUnemployment, Double> ageGroup3Column;

    @FXML
    private TableColumn<AgeGroupUnemployment, Double> ageGroup4Column;

    @FXML
    private TableColumn<AgeGroupUnemployment, Double> ageGroup5Column;

    @FXML
    private TableColumn<AgeGroupUnemployment, Double> ageGroup6Column;

    @FXML
    private TableColumn<AgeGroupUnemployment, LocalDate> dateColumn;

    @FXML
    private RadioButton genderRadioButton;

    @FXML
    private TableColumn<AgeGroupUnemployment, Double> overallColumn;

    @FXML
    private RadioButton overallRadioButton;

    @FXML
    private TableView<AgeGroupUnemployment> tableView;

    @FXML
    private RadioButton tableViewRadioButton;
    private int selectedNumber = 1;
    private ToggleGroup toggleGroup;
    private ArrayList<AgeGroupUnemployment> allAgeGroupUnemployment;

    /**
     * This is to check the selected radio button
     */
    @FXML
    void handleRadioButtonAction(ActionEvent event) {
        if(event.getSource() == overallRadioButton)
            selectedNumber = 1;
        else if(event.getSource() == genderRadioButton)
            selectedNumber = 2;
        else if(event.getSource() == tableViewRadioButton)
            selectedNumber = 3;
    }

    /**
     * According to the radio button, each fxml files will be sent to the "SceneChanger.changeScenes" method when the button is clicked
     */
    @FXML
    void viewTable(ActionEvent event)  throws IOException {
        String fxmlFileName = "";

        if(selectedNumber  == 1)
            fxmlFileName = "chart-view.fxml";
        else if(selectedNumber  == 2)
            fxmlFileName = "gender-chart-view.fxml";
        else if(selectedNumber  == 3)
            fxmlFileName ="table-view.fxml";

        SceneChanger.changeScenes(event, fxmlFileName);
    }

    /**
     * Table for unemployment rate by age is called from the DBUtility.getAgeGroupUnemploymentFromDB()
     */
    @FXML
    private void initialize() {
        allAgeGroupUnemployment = DBUtility.getAgeGroupUnemploymentFromDB();

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        ageGroup1Column.setCellValueFactory(new PropertyValueFactory<>("age_16_17_rate"));
        ageGroup2Column.setCellValueFactory(new PropertyValueFactory<>("age_16_19_rate"));
        ageGroup3Column.setCellValueFactory(new PropertyValueFactory<>("age_18_19_rate"));
        ageGroup4Column.setCellValueFactory(new PropertyValueFactory<>("age_20plus_rate"));
        ageGroup5Column.setCellValueFactory(new PropertyValueFactory<>("age_25plus_rate"));
        ageGroup6Column.setCellValueFactory(new PropertyValueFactory<>("age_55plus_rate"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        overallColumn.setCellValueFactory(new PropertyValueFactory<>("overall_rate"));

        tableView.getItems().addAll(allAgeGroupUnemployment);

        // Radio buttons will not be selected in duplicate
        toggleGroup = new ToggleGroup();
        overallRadioButton.setToggleGroup(toggleGroup);
        genderRadioButton.setToggleGroup(toggleGroup);
        tableViewRadioButton.setToggleGroup(toggleGroup);
    }
}
