package org.example;

public class FinanceReport {
    private int size;
    private Payment[] paymentsArray;
    private String reporterName;

    private int day;
    private int month;
    private int year;

    public FinanceReport(String reporterName, int day, int month, int year, int size) {
        this.size = size;
        paymentsArray = new Payment[size]; // уточнить размер
        this.reporterName = reporterName;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getSize() {
        return this.size;
    }

    public int paymentsCount() {
        int payCount = 0;
        for (int i = 0; i < size; i++) {
            if (paymentsArray[i] != null) {
                payCount++;
            }
        }
        return payCount;
    }

    public Payment getPaymentAt(int i) throws Exception {
        if (i >= size || i < 0) {
            throw new Exception("Payment with this number does not exist");
        }
        return paymentsArray[i];
    }


    public void setPaymentAt(Payment newPayment, int i) throws Exception {
        if (i >= size) {
            throw new Exception("Payment with this number does not exist");
        }
        paymentsArray[i] = newPayment;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[Автор: ").append(reporterName).append(", дата: ").append(this.day).append(".").append(this.month).append(".").append(this.year).append(", Платежи: [\n");
        for (Payment payment : paymentsArray) {
            if (payment != null) {
                result.append("Плательщик: ").append(payment.getFullName()).append(", дата: ").append(payment.getDay()).append(".");
                result.append(payment.getMonth()).append(".").append(payment.getYear()).append(", сумма: ").append(payment.getTotal() / 100);
                result.append(" руб. ").append(payment.getTotal() % 100).append(" коп.\n");
            }
        }
        result.append("]]");
        return result.toString();
    }

    public void copy(FinanceReport start) throws Exception {
        this.reporterName = start.reporterName;
        this.day = start.day;
        this.month = start.month;
        this.year = start.year;
        this.size = start.size;
        this.paymentsArray = new Payment[size];
        for (int i = 0; i < start.size; i++) {
            Payment tmpPayment = start.getPaymentAt(i);
            if (tmpPayment != null) {
                this.setPaymentAt(tmpPayment, i);
            }
        }
    }
    public void nameCopy(FinanceReport start) throws Exception {
        this.reporterName = start.reporterName;
        this.day = start.day;
        this.month = start.month;
        this.year = start.year;
        this.size = start.size;
        this.paymentsArray = new Payment[size];
    }
}