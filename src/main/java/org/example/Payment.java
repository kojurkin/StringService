package org.example;

import java.util.Objects;

public class Payment {
    private String fullName;
    private int day;
    private int month;
    private int year;
    private int total;

    public Payment(String fullName, int day, int month, int year, int total) {
        this.fullName = fullName;
        this.day = day;
        this.month = month;
        this.year = year;
        this.total = total;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return day == payment.day && month == payment.month && year == payment.year && total == payment.total && Objects.equals(fullName, payment.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, day, month, year, total);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "fullName='" + fullName + '\'' +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", total=" + total +
                '}';
    }


}
