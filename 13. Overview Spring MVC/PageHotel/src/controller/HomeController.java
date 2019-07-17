/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/15/2019                     *
 * Time: 10:09 PM                     *
 *************************************
 */

package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homepage(){
        return "index";
    }
    @GetMapping("/page1")
    public String page1(){
        return "page1";
    }
    @GetMapping("/page2")
    public String page2(){
        return "page2";
    }
}
