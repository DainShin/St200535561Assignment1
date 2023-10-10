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
     * If the isOverallChartSelected is true, the bar chart will be shown. If not, the line chart will be shown
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
     * This method will check if the radio button is for linechart or not
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
     * Linechart for gender unemployment rate is called from the DBUtility.getLineChartData()
     */
    @FXML
    private void initialize() {
       lineChart.getData().addAll(DBUtility.getLineChartData("men_rate"));
       lineChart.getData().addAll(DBUtility.getLineChartData("women_rate"));
       toggleGroup = new ToggleGroup();
       overallRadioButton.setToggleGroup(toggleGroup);
       genderRadioButton.setToggleGroup(toggleGroup);
       tableViewRadioButton.setToggleGroup(toggleGroup);
    }
}
