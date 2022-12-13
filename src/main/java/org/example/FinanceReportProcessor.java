package org.example;

public class FinanceReportProcessor {
    public static FinanceReport beginWithLetter (FinanceReport report, char letter) throws Exception {
        FinanceReport result = new FinanceReport("", 0, 0, 0, 0);
        result.nameCopy(report);
        int counter = 0;
        for (int i = 0; i < report.getSize(); i++) {
            if(null != report.getPaymentAt(i)) {
                char firstLetter = report.getPaymentAt(i).getFullName().charAt(0);
                if(firstLetter == letter) {
                    result.setPaymentAt(report.getPaymentAt(i), counter);
                    counter++;
                }
            }

        }
        return result;
    }

    public static FinanceReport paymentsLessThan (FinanceReport report, double amount) throws Exception {
        FinanceReport result = new FinanceReport("", 0, 0, 0, 0);
        result.nameCopy(report);
        int counter = 0;
        for(int i = 0; i < report.getSize(); i++) {
            if (null != report.getPaymentAt(i)) {
                if (report.getPaymentAt(i).getTotal() < amount) {
                    result.setPaymentAt(report.getPaymentAt(i), counter);
                    counter++;
                }
            }
        }
        return result;
    }
}
