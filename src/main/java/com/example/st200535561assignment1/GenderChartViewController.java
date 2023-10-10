package com.example.st200535561assignment1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.RadioButton;

import java.io.IOException;

public class GenderChartViewController {

    @FXML
    private LineChart<String, Double> lineChart;
    XYChart.Series<String, Double> series = null;

    @FXML
    private RadioButton overallRadioButton;

    @FXML
    private RadioButton genderRadioButton;
    private boolean isOverallChartSelected = false;

    /**
     * If the isOverallChartSelected is true, the bar chart will be shown. If not, the line chart will be shown
     */
    @FXML
    void viewTable(ActionEvent event) throws IOException {
        String fxmlFileName = isOverallChartSelected ? "chart-view.fxml" : "gender-chart-view.fxml";
        SceneChanger.changeScenes(event, fxmlFileName);
    }

    /**
     * This method will check if the radio button is for linechart or not
     */
    @FXML
    void handleRadioButtonAction(ActionEvent event) {
        if(event.getSource() == overallRadioButton) {
            isOverallChartSelected = true;
        } else if (event.getSource() == genderRadioButton) {
            isOverallChartSelected = false;
        }
    }

    /**
     * Linechart for gender unemployment rate is called from the DBUtility.getLineChartData()
     */
    @FXML
    private void initialize() {
       lineChart.getData().addAll(DBUtility.getLineChartData("men_rate"));
       lineChart.getData().addAll(DBUtility.getLineChartData("women_rate"));
    }
}
