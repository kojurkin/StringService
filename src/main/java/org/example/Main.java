package org.example;

public class Main {
    public static void main(String[] args) throws Exception {
        /*String s = "Ab";
        int N = 0;
        System.out.println(StringProcessor.copyString(s, N));
        System.out.println(StringProcessor.countOfInclusion("AbcaBcabCabc2231gsdhsretuabc","abc"));

        Payment pay = new Payment("Кичибряков Кичибряк Кичибряковичк", 15, 06, 1992, 99999999);
        System.out.println(pay.toString());*/
        Payment pay = new Payment("Кичибряков Кичибряк Кичибряковичк", 15, 6, 1992, 1234);
        FinanceReport report = new FinanceReport("Каюкин Илья", 1, 12, 2022, 1);
        System.out.println(report.getPaymentAt(0) + "\n");
        report.setPaymentAt(pay, 0);
        System.out.println(report.getPaymentAt(0) + "\n");

        System.out.println(report);
        FinanceReport reportCopy = new FinanceReport("Некто", 0, 0, 0, 1);
        reportCopy.copy(report);
        System.out.println(reportCopy);
        System.out.println(report.paymentsCount());
    }
}