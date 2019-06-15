public class Calculator {
    public static float calculate(float firstOperand, float secondOperand, char operator ){
        float result;
        switch (operator){
            case '+':
                result =  firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if(secondOperand != 0)
                    result = firstOperand / secondOperand;
                else
                    throw new RuntimeException("Can't divide by zero");
                break;
            default:
                throw new RuntimeException("Invalid operation");
        }
        return result;
    }
}
