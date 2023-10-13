package com.example.st200535561assignment1;

import java.time.LocalDate;

public class AgeGroupUnemployment {

    // Fields
    private int id;
    private LocalDate date;
    private double overall_rate;
    private double age_16_17_rate;
    private double age_16_19_rate;
    private double age_18_19_rate;
    private double age_20plus_rate;
    private double age_25plus_rate;
    private double age_55plus_rate;

    /**
     * Constructor : this constructor will call setters for each values
     */
    public AgeGroupUnemployment(int id, LocalDate date, double overall_rate, double age_16_17_rate, double age_16_19_rate, double age_18_19_rate, double age_20plus_rate, double age_25plus_rate, double age_55plus_rate) {
        setId(id);
        setDate(date);
        setOverall_rate(overall_rate);
        setAge_16_17_rate(age_16_17_rate);
        setAge_16_19_rate(age_16_19_rate);
        setAge_18_19_rate(age_18_19_rate);
        setAge_20plus_rate(age_20plus_rate);
        setAge_25plus_rate(age_25plus_rate);
        setAge_55plus_rate(age_55plus_rate);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    /**
     * The date should be before the current date
     */
    public void setDate(LocalDate date) {
        if (date.isBefore(LocalDate.now())) {
            this.date = date;
        } else {
            throw new IllegalArgumentException("Date should be before the current date.");
        }
    }

    public double getOverall_rate() {
        return overall_rate;
    }

    /**
     * Setter: Each rate should be between 0 and 100 (for the rate, the validation is same)
     */

    public void setOverall_rate(double overall_rate) {
        if (overall_rate >= 0 && overall_rate <= 100) {
            this.overall_rate = overall_rate;
        } else {
            throw new IllegalArgumentException("The rate should be between 0 and 100.");
        }
    }

    public double getAge_16_17_rate() {
        return age_16_17_rate;
    }

    public void setAge_16_17_rate(double age_16_17_rate) {
        if (age_16_17_rate >= 0 && age_16_17_rate <= 100) {
            this.age_16_17_rate = age_16_17_rate;
        } else {
            throw new IllegalArgumentException("The rate should be between 0 and 100.");
        }
    }

    public double getAge_16_19_rate() {
        return age_16_19_rate;
    }

    public void setAge_16_19_rate(double age_16_19_rate) {
        if (age_16_19_rate >= 0 && age_16_19_rate <= 100) {
            this.age_16_19_rate = age_16_19_rate;
        } else {
            throw new IllegalArgumentException("The rate should be between 0 and 100.");
        }
    }

    public double getAge_18_19_rate() {
        return age_18_19_rate;
    }

    public void setAge_18_19_rate(double age_18_19_rate) {
        if (age_18_19_rate >= 0 && age_18_19_rate <= 100) {
            this.age_18_19_rate = age_18_19_rate;
        } else {
            throw new IllegalArgumentException("The rate should be between 0 and 100.");
        }
    }

    public double getAge_20plus_rate() {
        return age_20plus_rate;
    }

    public void setAge_20plus_rate(double age_20plus_rate) {
        if (age_20plus_rate >= 0 && age_20plus_rate <= 100) {
            this.age_20plus_rate = age_20plus_rate;
        } else {
            throw new IllegalArgumentException("The rate should be between 0 and 100.");
        }
    }

    public double getAge_25plus_rate() {
        return age_25plus_rate;
    }

    public void setAge_25plus_rate(double age_25plus_rate) {
        if (age_25plus_rate >= 0 && age_25plus_rate <= 100) {
            this.age_25plus_rate = age_25plus_rate;
        } else {
            throw new IllegalArgumentException("The rate should be between 0 and 100.");
        }
    }

    public double getAge_55plus_rate() {
        return age_55plus_rate;
    }

    public void setAge_55plus_rate(double age_55plus_rate) {
        if (age_55plus_rate >= 0 && age_55plus_rate <= 100) {
            this.age_55plus_rate = age_55plus_rate;
        } else {
            throw new IllegalArgumentException("The rate should be between 0 and 100.");
        }
    }
}
