package com.example.st200535561assignment1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.io.IOException;

public class GenderChartViewController {

    @FXML
    private LineChart<String, Double> lineChart;
    XYChart.Series<String, Double> series = null;

    @FXML
    void viewTable(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "chart-view.fxml");
    }

    @FXML
    private void initialize() {
       lineChart.getData().addAll(DBUtility.getLineChartData("men_rate"));
       lineChart.getData().addAll(DBUtility.getLineChartData("women_rate"));
    }
}
