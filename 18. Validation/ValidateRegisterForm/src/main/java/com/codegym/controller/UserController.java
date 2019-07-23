/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/23/2019                     *
 * Time: 1:58 PM                     *
 *************************************
 */

package com.codegym.controller;

import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {
    @GetMapping("/")
    public ModelAndView showForm(){
       ModelAndView modelAndView = new ModelAndView("index");
       modelAndView.addObject("user",new User());
       return modelAndView;
    }
    @PostMapping("/")
    public ModelAndView checkUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult){
        new User().validate(user,bindingResult);
        if (bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("index");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("result");
        return modelAndView;
    }

/*    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("phoneNumber",new PhoneNumber());
        return "index";
    }
    @PostMapping("/")
    public String checkValidation(@Valid @ModelAttribute("phoneNumber")PhoneNumber phoneNumber, BindingResult bindingResult, Model model){
        new PhoneNumber().validate(phoneNumber,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "index";
        } else {
            model.addAttribute("phoneNumber",phoneNumber.getNumber());
            return "result";
        }
    }*/
}
