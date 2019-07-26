/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/26/2019                     *
 * Time: 3:01 PM                     *
 *************************************
 */

package com.codegym.controller;

import com.codegym.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class CustomerController {

    @GetMapping("/register")
    public String login(@ModelAttribute("customer") Customer customer) {
        return "index";
    }

    @PostMapping("/result")
    public String dashboard(@ModelAttribute("customer") Customer customer, Model model) {
        model.addAttribute("customer", customer);
        return "result";
    }
}
