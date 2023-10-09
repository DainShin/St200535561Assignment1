package com.example.st200535561assignment1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;

import java.io.IOException;

public class ChartViewController {

    @FXML
    private BarChart<String, Double> barChart;

    @FXML
    void viewTable(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "gender-chart-view.fxml");
    }

    @FXML
    private void initialize() {
        barChart.getData().addAll(DBUtility.getBarChartData());

    }

}
