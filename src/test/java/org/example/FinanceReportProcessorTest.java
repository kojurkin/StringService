package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FinanceReportProcessorTest {

    @Test
    void beginWithLetterTest() throws Exception {
        FinanceReport rep = new FinanceReport("Тестировщик", 0, 0, 0, 10);
        Payment pay1 = new Payment("Тест", 0, 0, 0, 257);
        Payment pay2 = new Payment("Проверка", 0, 0, 0, 257);
        Payment pay3 = new Payment("Хочу Узнать", 0, 0, 0, 257);
        rep.setPaymentAt(pay1, 0);
        rep.setPaymentAt(pay2, 1);
        rep.setPaymentAt(pay3, 2);
        FinanceReport res1 = new FinanceReport("", 0, 0, 0, 10);
        FinanceReport res2 = new FinanceReport("", 0, 0, 0, 10);
        FinanceReport res3 = new FinanceReport("", 0, 0, 0, 10);
        res1.copy(FinanceReportProcessor.beginWithLetter(rep, 'Т'));
        res2.copy(FinanceReportProcessor.beginWithLetter(rep, 'П'));
        res3.copy(FinanceReportProcessor.beginWithLetter(rep, 'Х'));
        assertEquals("[Автор: Тестировщик, дата: 0.0.0, Платежи: [\nПлательщик: Тест, дата: 0.0.0, сумма: 2 руб. 57 коп.\n]]", res1.toString());
        assertEquals("[Автор: Тестировщик, дата: 0.0.0, Платежи: [\nПлательщик: Проверка, дата: 0.0.0, сумма: 2 руб. 57 коп.\n]]", res2.toString());
        assertEquals("[Автор: Тестировщик, дата: 0.0.0, Платежи: [\nПлательщик: Хочу Узнать, дата: 0.0.0, сумма: 2 руб. 57 коп.\n]]", res3.toString());
    }

    @Test
    void paymentsLessThanTest() throws Exception {
        FinanceReport rep = new FinanceReport("Тестировщик", 0, 0, 0, 10);
        Payment pay1 = new Payment("Тест", 0, 0, 0, 157);
        Payment pay2 = new Payment("Проверка", 0, 0, 0, 257);
        Payment pay3 = new Payment("Хочу Узнать", 0, 0, 0, 357);
        FinanceReport res = new FinanceReport("Тестировщик", 0, 0, 0, 0);
        res.copy(FinanceReportProcessor.paymentsLessThan(rep, 300));
        assertEquals("[Автор: Тестировщик, дата: 0.0.0, Платежи: [\nПлательщик: Тест, дата: 0.0.0, сумма: 1 руб. 57 коп.\n]]", res.toString());
    }
}