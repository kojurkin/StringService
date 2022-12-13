package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FinanceReportTest {

    @Test
    void testPaymentsSetOk() throws Exception {
        FinanceReport rep = new FinanceReport("Тестировщик", 0, 0, 0, 10);
        Payment pay = new Payment("Тест", 0, 0, 0, 257);
        rep.setPaymentAt(pay, 0);
        assertEquals(1,rep.paymentsCount());
    }

    @Test
    void testPaymentsSetNegative() throws Exception {
        FinanceReport rep = new FinanceReport("Тестировщик", 0, 0, 0, 10);
        Payment pay = new Payment("Тест", 0, 0, 0, 257);
        assertThrows(Exception.class, () -> rep.setPaymentAt(pay, -1), "Payment with this number does not exist");
        assertEquals(0,rep.paymentsCount());
    }

    @Test
    void testPaymentsSetTooPositive() throws Exception {
        FinanceReport rep = new FinanceReport("Тестировщик", 0, 0, 0, 10);
        Payment pay = new Payment("Тест", 0, 0, 0, 257);
        assertThrows(Exception.class, () -> rep.setPaymentAt(pay, 10), "Payment with this number does not exist");
        assertEquals(0,rep.paymentsCount());
    }

    @Test
    void testPaymentsGetTooPositive() throws Exception {
        FinanceReport rep = new FinanceReport("Тестировщик", 0, 0, 0, 10);
        assertThrows(Exception.class, () -> rep.getPaymentAt(10), "Payment with this number does not exist");
        assertEquals(0,rep.paymentsCount());
    }

    @Test
    void testPaymentsGetNegative() throws Exception {
        FinanceReport rep = new FinanceReport("Тестировщик", 0, 0, 0, 10);
        assertThrows(Exception.class, () -> rep.getPaymentAt(-1), "Payment with this number does not exist");
        assertEquals(0,rep.paymentsCount());
    }

    @Test
    void testPaymentsGetOk() throws Exception {
        FinanceReport rep = new FinanceReport("Тестировщик", 0, 0, 0, 10);
        Payment pay = new Payment("Тест", 0, 0, 0, 257);
        rep.setPaymentAt(pay, 0);
        assertEquals(pay, rep.getPaymentAt(0));
    }

    @Test
    void testNoPaymentsCount() {
        FinanceReport rep = new FinanceReport("Тестировщик", 0, 0, 0, 10);
        assertEquals(0, rep.paymentsCount());
    }

    @Test
    void testReportToString() throws Exception {
        String result = "[Автор: Тестировщик, дата: 0.0.0, Платежи: [\nПлательщик: Тест, дата: 0.0.0, сумма: 2 руб. 57 коп.\n]]";
        FinanceReport rep = new FinanceReport("Тестировщик", 0, 0, 0, 10);
        Payment pay = new Payment("Тест", 0, 0, 0, 257);
        rep.setPaymentAt(pay, 0);
        assertEquals(result, rep.toString());
    }

    @Test
    void testReportCopy() throws Exception {
        FinanceReport repFirst = new FinanceReport("Тестировщик", 0, 0, 0, 10);
        Payment pay = new Payment("Тест", 0, 0, 0, 257);
        FinanceReport repSecond = new FinanceReport("name", 14, 13, 11, 15);
        repSecond.copy(repFirst);
        assertEquals(repFirst.toString(), repSecond.toString());
    }

}