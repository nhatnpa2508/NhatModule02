/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/27/2019                     *
 * Time: 6:32 PM                     *
 *************************************
 */

package com.codegym.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class WelcomeController {
    //inject via application.properties

    @Value("Welcome!")
    private String message = "Welcome!";

    @RequestMapping("/")
    public String welcome(Map<String, Object> model){
        model.put("message",this.message);
        return "welcome";
    }
}
