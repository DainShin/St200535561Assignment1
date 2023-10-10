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

    @FXML
    void viewTable(ActionEvent event) throws IOException {
        String fxmlFileName = isGenderChartSelected ? "gender-chart-view.fxml" : "chart-view.fxml";
        SceneChanger.changeScenes(event, fxmlFileName);
    }

    @FXML
    void handleRadioButtonAction(ActionEvent event) {
        if(event.getSource() == genderRadioButton) {
            isGenderChartSelected = true;
        } else if (event.getSource() == overallRadioButton) {
            isGenderChartSelected = false;
        }
    }
    @FXML
    private void initialize() {
        barChart.getData().addAll(DBUtility.getBarChartData());

    }

}
