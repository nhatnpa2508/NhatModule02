import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class FizzBuzzTest {
//    @Test
    String testFizz3() {
        int number = 3;
        String expected = "Fizz";

        String result = FizzBuzz.fizzBuzz(number);
        assertEquals(expected, result);
        return result;
    }

//    @Test
    String testFizz6() {
        int number = 6;
        String expected = "Fizz";

        String result = FizzBuzz.fizzBuzz(number);
        assertEquals(expected, result);
        return result;
    }

//    @Test
    String testBuzz5() {
        int number = 5;
        String expected = "Buzz";

        String result = FizzBuzz.fizzBuzz(number);
        assertEquals(expected, result);
        return result;
    }

//    @Test
    String testBuzz10() {
        int number = 10;
        String expected = "Buzz";

        String result = FizzBuzz.fizzBuzz(number);
        assertEquals(expected, result);
        return result;
    }

//    @Test
    String testFizzBuzz15() {
        int number = 15;
        String expected = "FizzBuzz";

        String result = FizzBuzz.fizzBuzz(number);
        assertEquals(expected, result);
        return result;
    }

//    @Test
    String testFizzBuzz30() {
        int number = 30;
        String expected = "FizzBuzz";

        String result = FizzBuzz.fizzBuzz(number);
        assertEquals(expected, result);
        return result;
    }

    public static void main(String[] args) {
        FizzBuzzTest fizzBuzzTest = new FizzBuzzTest();
        System.out.println();
        System.out.println(fizzBuzzTest.testFizz3());
        System.out.println(fizzBuzzTest.testFizz6());
        System.out.println(fizzBuzzTest.testBuzz5());
        System.out.println(fizzBuzzTest.testBuzz10());
        System.out.println(fizzBuzzTest.testFizzBuzz15());
        System.out.println(fizzBuzzTest.testFizzBuzz30());

    }
}
