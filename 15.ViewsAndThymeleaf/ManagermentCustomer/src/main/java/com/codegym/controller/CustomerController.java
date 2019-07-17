/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/16/2019                     *
 * Time: 9:34 PM                     *
 *************************************
 */

package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerServiceImpl;
import com.codegym.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {
    private ICustomerService customerService = new CustomerServiceImpl();

    //Trang chinh
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("customers", customerService.findAll());
        return "index";
    }
    //Trang khoi tao
    @GetMapping("/customer/create")
    public String create(Model model){
        model.addAttribute("customer", new Customer());
        return "create";
    }
    //Phuong thuc khoi tao
    @PostMapping("/customer/save")
    public String save(Customer customer, RedirectAttributes redirect){
        customer.setId((int)(Math.random() * 10000));
        customerService.save(customer);
        redirect.addFlashAttribute("success", "Saved customer successfully!");
        return "redirect:/";
    }
    //Trang chinh sua
    @GetMapping("/customer/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "edit";
    }
    //Phuong thuc chinh sua
    @PostMapping("/customer/update")
    public String update(Customer customer, RedirectAttributes redirect){
        customerService.update(customer.getId(),customer);
        redirect.addFlashAttribute("success","Modified customer successfully!");
        return "redirect:/";
    }
    //Trang xoa
    @GetMapping("/customer/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "delete";
    }
    //Phuong thuc xoa
    @PostMapping("/customer/delete")
    public String delete(Customer customer, RedirectAttributes redirect){
        customerService.remove(customer.getId());
        redirect.addFlashAttribute("success","Removed customer successfully!");
        return "redirect:/";
    }
    //Trang view
    @GetMapping("/customer/{id}/view")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "view";
    }
}
