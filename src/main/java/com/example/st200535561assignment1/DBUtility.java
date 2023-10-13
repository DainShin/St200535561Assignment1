package com.example.st200535561assignment1;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.VBox;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBUtility {

    private static final String connectURL = "jdbc:mysql://172.31.22.43:3306/Dain200535561";
    private static final String dbUser = "Dain200535561";
    private static final String password = "Bt57Xh4V6g";

    /**
     * This is for Line chart. Bar Chart will show the US average unemployment rate according to the year group
     */
    public static XYChart.Series<String, Double> getBarChartData() {

        // This is to access to the data in the chart. In the series instance, each value from the data will be stored
        XYChart.Series<String, Double> series = new XYChart.Series<>();

        // Set the legend name
        series.setName("Overall Rate");

        String sql = "SELECT \n" +
                "    CONCAT(\n" +
                "        FLOOR(YEAR(STR_TO_DATE(date, '%Y-%m-%d')) / 10) * 10 + 1, \n" +
                "        '-', \n" +
                "        FLOOR(YEAR(STR_TO_DATE(date, '%Y-%m-%d')) / 10) * 10 + 10\n" +
                "    ) AS decade_group,\n" +
                "    AVG(overall_rate) AS overall_average_rate\n" +
                "FROM\n" +
                "    df_unemployment_rates\n" +
                "GROUP BY\n" +
                "    decade_group\n" +
                "HAVING \n" +
                "    decade_group BETWEEN '1951' AND '2020'\n" +
                "UNION \n" +
                "SELECT YEAR(STR_TO_DATE(date, '%Y-%m-%d')) AS decade_group,\n" +
                "AVG(overall_rate) AS overall_average_rate\n" +
                "FROM\n" +
                "    df_unemployment_rates\n" +
                "GROUP BY\n" +
                "    decade_group\n" +
                "HAVING \n" +
                "    decade_group BETWEEN '2021' AND '2023';";

        // This is try with resource statement to get the data from the database
        try (
                Connection conn = DriverManager.getConnection(connectURL, dbUser, password);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        )
        {
            while (resultSet.next())
            {
                // Stored the data from "decade_group" column and "overall_average_rate" column
                series.getData().add(new XYChart.Data<>(resultSet.getString("decade_group"),
                        resultSet.getDouble("overall_average_rate")));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Returned the data I had from database
        return series;
    }

    /**
     * This is for Line chart. Line Chart will show the US male/female unemployment rate according to the year group
     */

    public static XYChart.Series<String, Double> getLineChartData(String colName) {

        XYChart.Series<String, Double> series = new XYChart.Series<>();

        if(colName.equals("men_rate"))
            series.setName("Man Rate");
        else
            series.setName("Women Rate");

        String sql = "SELECT \n" +
                "    CONCAT(\n" +
                "        FLOOR(YEAR(STR_TO_DATE(date, '%Y-%m-%d')) / 10) * 10 + 1, \n" +
                "        '-', \n" +
                "        FLOOR(YEAR(STR_TO_DATE(date, '%Y-%m-%d')) / 10) * 10 + 10\n" +
                "    ) AS decade_group,\n" +
                "    AVG(" + colName + ") AS avg_value "  +
                "FROM\n" +
                "    df_sex_unemployment_rates\n" +
                "GROUP BY\n" +
                "    decade_group\n" +
                "HAVING \n" +
                "    decade_group BETWEEN '1951' AND '2020'\n" +
                "UNION \n" +
                "SELECT YEAR(STR_TO_DATE(date, '%Y-%m-%d')) AS decade_group,\n" +
                " AVG(" + colName + ") AS avg_value "  +
                "FROM\n" +
                "    df_sex_unemployment_rates\n" +
                "GROUP BY\n" +
                "    decade_group\n" +
                "HAVING \n" +
                "    decade_group BETWEEN '2021' AND '2023';";

        try (
                Connection conn = DriverManager.getConnection(connectURL, dbUser, password);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            while (resultSet.next()) {
                series.getData().add(new XYChart.Data<>(resultSet.getString("decade_group"), resultSet.getDouble("avg_value")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return series;
    }

    /**
     * This it for the table. The table will show the US unemployment rate by age
     */
    public static ArrayList<AgeGroupUnemployment> getAgeGroupUnemploymentFromDB() {

        // ageGroupUnemployments will store the data for the table chart
        ArrayList<AgeGroupUnemployment> ageGroupUnemployments = new ArrayList<>();

        String sql = "SELECT * FROM df_unemployment_rates;";

        // Used try with resource to get the data from the database
        try (
                Connection conn = DriverManager.getConnection(connectURL, dbUser, password);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                )
        {
            while (resultSet.next())
            {
                // Stored each data from the database
                int id = resultSet.getInt("id");
                LocalDate date = resultSet.getDate("date").toLocalDate();
                double overall_rate = resultSet.getDouble("overall_rate");
                double age_16_17_rate = resultSet.getDouble("age_16_17_rate");
                double age_16_19_rate = resultSet.getDouble("age_16_19_rate");
                double age_18_19_rate = resultSet.getDouble("age_18_19_rate");
                double age_20plus_rate = resultSet.getDouble("age_20plus_rate");
                double age_25plus_rate = resultSet.getDouble("age_25plus_rate");
                double age_55plus_rate = resultSet.getDouble("age_55plus_rate");

                // Created the new AgeGroupUnemployment instance which contains the data
                AgeGroupUnemployment newAgeGroupUnemployments = new AgeGroupUnemployment
                       (id,date,overall_rate,age_16_17_rate,age_16_19_rate,age_18_19_rate,age_20plus_rate,age_25plus_rate,age_55plus_rate);

                // Stored the data in the ArrayList
                ageGroupUnemployments.add(newAgeGroupUnemployments);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Return the ArrayList
        return ageGroupUnemployments;
    }
}
