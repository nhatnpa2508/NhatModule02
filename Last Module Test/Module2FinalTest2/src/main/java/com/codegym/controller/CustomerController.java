/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 8/15/2019                     *
 * Time: 1:43 PM                     *
 *************************************
 */

package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping(value="/",produces = "application/json;charset=UTF-8")
    public ModelAndView listCustomers(@RequestParam("string")Optional <String> string, Pageable pageable){
        Page<Customer> customers;
        if (string.isPresent()){
            customers = customerService.findAllByFirstNameContainingOrLastNameContaining(string.get(),string.get(), pageable);
        } else {
            customers = customerService.findAll(pageable);
        }

        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping(value="/customer-create",produces = "application/json;charset=UTF-8")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping(value="/customer-create",produces = "application/json;charset=UTF-8")
    public ModelAndView saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return new ModelAndView("/customer/edit");
        } else {
            customerService.save(customer);

            ModelAndView modelAndView = new ModelAndView("/customer/create");
            modelAndView.addObject("customer", new Customer());
            modelAndView.addObject("message", "New customer created successfully");
            return modelAndView;
        }
    }

    @GetMapping(value="/customer-edit/{id}",produces = "application/json;charset=UTF-8")
    public ModelAndView showEditForm(@PathVariable Long id){
        Customer customer = customerService.findById(id);
        if(customer != null) {
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("customer", customer);
            return modelAndView;

        }else {
            return new ModelAndView("/error404");
        }
    }

    @PostMapping(value="/customer-edit",produces = "application/json;charset=UTF-8")
    public ModelAndView updateCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return new ModelAndView("/customer/edit");
        } else {
            customerService.save(customer);
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("customer", customer);
            modelAndView.addObject("message", "Customer updated successfully");
            return modelAndView;
        }
    }

    @GetMapping(value="/customer-delete/{id}",produces = "application/json;charset=UTF-8")
    public String deleteCustomer(@PathVariable Long id){
        Customer customer = customerService.findById(id);
        if(customer != null){
            customerService.remove(id);
            return "redirect:/";
        } else {
            return "/error404";
        }
    }

    @GetMapping(value="/customer-view/{id}",produces = "application/json;charset=UTF-8")
    public ModelAndView showView(@PathVariable Long id){
        Customer customer = customerService.findById(id);
        if (customer != null){
            ModelAndView modelAndView = new ModelAndView("/customer/view");
            modelAndView.addObject("customer",customer);
            return modelAndView;
        } else {
            return new ModelAndView("/error404");
        }
    }
}
