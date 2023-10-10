package com.example.st200535561assignment1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;

public class ChartViewController {

    @FXML
    private BarChart<String, Double> barChart;

    @FXML
    private RadioButton overallRadioButton;

    @FXML
    private RadioButton genderRadioButton;
    private boolean isGenderChartSelected = false;

    /**
     * If the idGenderChartSelected is true, the line chart will be shown. If not, the bar chart will be shown
     */
    @FXML
    void viewTable(ActionEvent event) throws IOException {
        String fxmlFileName = isGenderChartSelected ? "gender-chart-view.fxml" : "chart-view.fxml";
        SceneChanger.changeScenes(event, fxmlFileName);
    }

    /**
     * This method will check if the radio button is for linechart or not
     */
    @FXML
    void handleRadioButtonAction(ActionEvent event) {
        if(event.getSource() == genderRadioButton) {
            isGenderChartSelected = true;
        } else if (event.getSource() == overallRadioButton) {
            isGenderChartSelected = false;
        }
    }

    /**
     * Barchart for overall unemployment rate is called from the DBUtility.getBarChartData()
     */
    @FXML
    private void initialize() {
        barChart.getData().addAll(DBUtility.getBarChartData());
    }

}
