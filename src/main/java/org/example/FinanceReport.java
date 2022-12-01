package org.example;

public class FinanceReport {
    private static Payment[] paymentsArray;
    private final String reporterName;

    private static class Date {
        public static int day;
        public static int month;
        public static int year;
    }

    public FinanceReport(String reporterName, int day, int month, int year) {
        paymentsArray = new Payment[10]; // уточнить размер
        this.reporterName = reporterName;
        Date.day = day;
        Date.month = month;
        Date.year = year;
    }

    public static int paymentsCount() {
        return paymentsArray.length;
    }

    public Payment getPaymentAt(int i) throws Exception {
        if(i >= paymentsArray.length) {
            throw new Exception("Payment with this number does not exist");
        }
        return paymentsArray[i];
    }

    public void setPaymentAt(Payment newPayment, int i) throws Exception {
        if (i >= paymentsArray.length) {
            throw new Exception("Payment with this number does not exist");
        }
        paymentsArray[i - 1] = newPayment;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("");
        result.append("[Автор: ").append(reporterName).append(", дата: ").append(Date.day).append(".").append(Date.month).append(".").append(Date.year).append(", Платежи: [\n");
        for(int i = 0; i < paymentsArray.length; i++) {
            if(paymentsArray[i] != null) {
                result.append("Плательщик: ").append(paymentsArray[i].getFullName()).append(", дата: ").append(paymentsArray[i].getDay()).append(".");
                result.append(paymentsArray[i].getMonth()).append(".").append(paymentsArray[i].getYear()).append(", сумма: ").append(paymentsArray[i].getTotal() / 100);
                result.append(" рублей ").append(paymentsArray[i].getTotal() % 100).append(" копеек.\n");
            }
        }
        result.append("]]");
        String finalResult = result.toString();
        return finalResult;
    }
}
