package com.example.st200535561assignment1;

import java.time.LocalDate;

public class AgeGroupUnemployment {

    private LocalDate date;
    private double overall_rate;
    private double age_16_17_rate;
    private double age_16_19_rate;
    private double age_18_19_rate;
    private double age_20plus_rate;
    private double age_25plus_rate;
    private double age_55plus_rate;

    public AgeGroupUnemployment(LocalDate date, double overall_rate, double age_16_17_rate, double age_16_19_rate, double age_18_19_rate, double age_20plus_rate, double age_25plus_rate, double age_55plus_rate) {
        this.date = date;
        this.overall_rate = overall_rate;
        this.age_16_17_rate = age_16_17_rate;
        this.age_16_19_rate = age_16_19_rate;
        this.age_18_19_rate = age_18_19_rate;
        this.age_20plus_rate = age_20plus_rate;
        this.age_25plus_rate = age_25plus_rate;
        this.age_55plus_rate = age_55plus_rate;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getOverall_rate() {
        return overall_rate;
    }

    public void setOverall_rate(double overall_rate) {
        this.overall_rate = overall_rate;
    }

    public double getAge_16_17_rate() {
        return age_16_17_rate;
    }

    public void setAge_16_17_rate(double age_16_17_rate) {
        this.age_16_17_rate = age_16_17_rate;
    }

    public double getAge_16_19_rate() {
        return age_16_19_rate;
    }

    public void setAge_16_19_rate(double age_16_19_rate) {
        this.age_16_19_rate = age_16_19_rate;
    }

    public double getAge_18_19_rate() {
        return age_18_19_rate;
    }

    public void setAge_18_19_rate(double age_18_19_rate) {
        this.age_18_19_rate = age_18_19_rate;
    }

    public double getAge_20plus_rate() {
        return age_20plus_rate;
    }

    public void setAge_20plus_rate(double age_20plus_rate) {
        this.age_20plus_rate = age_20plus_rate;
    }

    public double getAge_25plus_rate() {
        return age_25plus_rate;
    }

    public void setAge_25plus_rate(double age_25plus_rate) {
        this.age_25plus_rate = age_25plus_rate;
    }

    public double getAge_55plus_rate() {
        return age_55plus_rate;
    }

    public void setAge_55plus_rate(double age_55plus_rate) {
        this.age_55plus_rate = age_55plus_rate;
    }
}
