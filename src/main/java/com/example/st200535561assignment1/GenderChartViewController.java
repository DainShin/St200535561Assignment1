package com.example.st200535561assignment1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;

public class GenderChartViewController {

    @FXML
    private LineChart<String, Double> lineChart;

    @FXML
    private RadioButton overallRadioButton;

    @FXML
    private RadioButton genderRadioButton;

    @FXML
    private RadioButton tableViewRadioButton;
    private int selectedNumber = 1;
    private ToggleGroup toggleGroup;

    /**
     * This method will check the selected radio button
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
     * According to the radio button, each fxml files will be sent to the "SceneChanger.changeScenes" method
     */
    @FXML
    void viewTable(ActionEvent event) throws IOException {
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
     * Linechart for gender unemployment rate is called from the DBUtility.getLineChartData()
     */
    @FXML
    private void initialize() {
       lineChart.getData().addAll(DBUtility.getLineChartData("men_rate"));
       lineChart.getData().addAll(DBUtility.getLineChartData("women_rate"));

       // Radio buttons will not be selected in duplicate
       toggleGroup = new ToggleGroup();
       overallRadioButton.setToggleGroup(toggleGroup);
       genderRadioButton.setToggleGroup(toggleGroup);
       tableViewRadioButton.setToggleGroup(toggleGroup);
    }
}
