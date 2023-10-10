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

    @FXML
    void viewTable(ActionEvent event) throws IOException {
        String fxmlFileName = isOverallChartSelected ? "chart-view.fxml" : "gender-chart-view.fxml";
        SceneChanger.changeScenes(event, fxmlFileName);
    }
    @FXML
    void handleRadioButtonAction(ActionEvent event) {
        if(event.getSource() == overallRadioButton) {
            isOverallChartSelected = true;
        } else if (event.getSource() == genderRadioButton) {
            isOverallChartSelected = false;
        }
    }

    @FXML
    private void initialize() {
       lineChart.getData().addAll(DBUtility.getLineChartData("men_rate"));
       lineChart.getData().addAll(DBUtility.getLineChartData("women_rate"));
    }
}
