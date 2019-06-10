import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    int firstNumber, secondNumber, expected, result;
    char operator;
    public static final char ADDITION = '+';
    public static final char SUBTRACTION = '-';
    public static final char MULTIPLICATION = '*';
    public static final char DIVISION = '/';
    public static final char EQUAL = '=';

    /*    @Test*/
    @DisplayName("Testing addition")
    void testCalculateAdd() {
        firstNumber = 1;
        secondNumber = 1;
        operator = ADDITION;
        expected = 2;

        result = Calculator.calculate(firstNumber, secondNumber, operator);
        assertEquals(expected, result);
    }

    int getResult() {
        return result;
    }

    /*    @Test*/
    @DisplayName("Testing subtraction")
    void testCalculateSub() {
        firstNumber = 2;
        secondNumber = 1;
        operator = SUBTRACTION;
        expected = 1;

        result = Calculator.calculate(firstNumber, secondNumber, operator);
        assertEquals(expected, result);
    }

    /*    @Test*/
    @DisplayName("Testing multiplication")
    void testCalculateMul() {
        firstNumber = 2;
        secondNumber = 2;
        operator = MULTIPLICATION;
        expected = 4;

        result = Calculator.calculate(firstNumber, secondNumber, operator);
        assertEquals(expected, result);
    }

    /*    @Test*/
    @DisplayName("Testing division")
    void testCalculateDiv() {
        firstNumber = 6;
        secondNumber = 3;
        operator = DIVISION;
        expected = 2;

        result = Calculator.calculate(firstNumber, secondNumber, operator);
        assertEquals(expected, result);
    }

    /*    @Test*/
    @DisplayName("Testing division by zero")
    void testCalculateDivByZero() {
        firstNumber = 2;
        secondNumber = 0;
        operator = DIVISION;

        assertThrows(RuntimeException.class,
                () -> {
                    Calculator.calculate(firstNumber, secondNumber, operator);
                });
    }

    /*    @Test*/
    @DisplayName("Testing wrong operator")
    void testCalculateWrongOperator() {
        firstNumber = 2;
        secondNumber = 0;
        operator = EQUAL;

        assertThrows(RuntimeException.class,
                () -> {
                    Calculator.calculate(firstNumber, secondNumber, operator);
                });
    }

    public static void main(String[] args) {
        CalculatorTest calculator = new CalculatorTest();
        calculator.testCalculateAdd();
        System.out.println(calculator.getResult());
        System.out.println();

        calculator.testCalculateSub();
        System.out.println(calculator.getResult());
        System.out.println();

        calculator.testCalculateMul();
        System.out.println(calculator.getResult());
        System.out.println();

        calculator.testCalculateDiv();
        System.out.println(calculator.getResult());
        System.out.println();

        calculator.testCalculateDivByZero();
        calculator.testCalculateWrongOperator();
    }
}
