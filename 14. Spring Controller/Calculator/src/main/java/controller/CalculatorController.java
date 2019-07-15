/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/15/2019                     *
 * Time: 8:30 PM                     *
 *************************************
 */

package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/")
    public String showCalculatorForm() {
        return "index";
    }

    @RequestMapping("/calculator")
    public String calculator(@RequestParam double firstNumber, double secondNumber, char operator, Model model) {
        double result = 0;
        switch (operator) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                result = firstNumber / secondNumber;
                break;
            default:
                break;
        }
        model.addAttribute("firstNumber",firstNumber);
        model.addAttribute("secondNumber",secondNumber);
        model.addAttribute("operator",operator);
        model.addAttribute("result",result);
        return "index";
    }
}
