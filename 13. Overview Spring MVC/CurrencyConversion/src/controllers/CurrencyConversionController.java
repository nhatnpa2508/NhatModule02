/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/10/2019                     *
 * Time: 4:58 PM                     *
 *************************************
 */

package controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConversionController {
    @GetMapping("/")
    public String converter(){
        return "convert";
    }
    @GetMapping("/convert")
    public String conversion(@RequestParam double usd,  Model model) {
        double rate = 23000;
        double vnd = usd * 23000;
        model.addAttribute("usd", usd);
        model.addAttribute("rate", rate);
        model.addAttribute("vnd", vnd);
        return "index";
    }
}
