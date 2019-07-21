/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/17/2019                     *
 * Time: 11:42 AM                     *
 *************************************
 */

package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @GetMapping("/")
    public String home(){
        return "index";
    }



    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String register(@RequestParam(value="email")String email)
}
