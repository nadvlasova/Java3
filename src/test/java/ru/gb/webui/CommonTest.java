package ru.gb.webui;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 1. Показываем, как написать первый unit-тест на функцию
public class CommonTest {
    Functions functions = new Functions();
    private static Logger logger = LoggerFactory.getLogger(CommonTest.class);

    @BeforeAll
    static void beforeAllTests() {
        logger.trace("Trace Before all tests");
        logger.info("Before all tests");
    }

    //два теста - на четную и нечетную цифру в методе isNumberEven(Integer number)
    @Test
    void testGivenEvenNumber__whenCheckingIsNumberEven__thenTrue() {
        boolean result = functions.isNumberEven(8);
        Assertions.assertTrue(result);
    }

    @Test
    void givenOddNumber__whenCheckingIsNumberEven__thenFalseTest() {
        boolean result = functions.isNumberEven(3);
        Assertions.assertFalse(result);
    }

    //ассерт с поясняющим сообщением на другом примере метода
    @Test
    void givenNegativeNumber__whenCheckingIsNumberPositive__thenFalseTest() {
        boolean result = functions.isPositive(-5);
        Assertions.assertFalse(result, "Try a negative number");
    }

    //тест, который должен упасть - сообщение
    @Test
    void FailedTestGivenNegativeNumber__whenCheckingIsNumberPositive__thenTrueTest() {
        boolean result = functions.isPositive(-5);
        Assertions.assertTrue(result, "Try a negative number");
    }

    //аннотация DisplayName
    @Test
    @DisplayName("Позитивный тест на функцию isPrime() с простым числом")
    public void isPrimePositiveTest() {
        Assertions.assertTrue(functions.isPrime(3));
    }

    //как скипать тесты с помощью аннотации Disabled
    @Test
    @Disabled("для демонстрации аннотации @Disabled")
    void testDeleteUser() { }
//    public void isPrimeNegativeTest() {
//        Assertions.assertFalse(true);
//    }

    //параметризованные тесты - аналог DataProvider в TestNG
    @DisplayName("Слово является палиндромом")
    @ParameterizedTest
    @ValueSource(strings = {"racecar", "radar", "able was I ere I saw elba"})
    public void isPalindromeTest(String word) {
        Assertions.assertTrue(functions.isPalindrome(word));
    }

    @AfterAll
    static void afterAllTests() {
        logger.info("After all tests");
    }
}
