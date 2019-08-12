/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 8/9/2019                     *
 * Time: 3:20 PM                     *
 *************************************
 */

package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.model.Employee;
import com.codegym.service.ICategoryService;
import com.codegym.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping("/employees")
    public ModelAndView listEmployee(@RequestParam("s")Optional <String> s,Pageable pageable){
        Page<Employee> employees;
        if(s.isPresent()){
            employees = employeeService.findAllByFullNameContaining(s.get(), pageable);
        } else {
            employees = employeeService.findAll(pageable);
        }

        ModelAndView modelAndView = new ModelAndView("/employee/list");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }
    @GetMapping("/employee-create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @PostMapping("/employee-create")
    public ModelAndView saveEmployee(@ModelAttribute("employee")Employee employee){
        employeeService.save(employee);

        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employee", new Employee());
        modelAndView.addObject("message","New employee created successfully");
        return modelAndView;
    }
    @GetMapping("/employee-edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Employee employee = employeeService.findById(id);
        if(employee != null){
            ModelAndView modelAndView = new ModelAndView("/employee/edit");
            modelAndView.addObject("employee",employee);
            return modelAndView;
        } else {
            return new ModelAndView("/error404");
        }
    }

    @PostMapping("/employee-edit")
    public ModelAndView updateEmployee(@ModelAttribute("employee")Employee employee){
        employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("/employee/edit");
        modelAndView.addObject("employee",employee);
        modelAndView.addObject("message","Employee updated successfully");
        return modelAndView;
    }
    @GetMapping("/employee-delete/{id}")
    public String showDeleteForm(@PathVariable Long id, Model model){
        Employee employee = employeeService.findById(id);
        if(employee != null){
            employeeService.remove(employee.getId());
            return "redirect:posts";
        } else {
            return "/error404";
        }
    }

    @GetMapping("/employee-view/{id}")
    public ModelAndView showView(@PathVariable Long id){
        Employee employee = employeeService.findById(id);
        if (employee != null){
            ModelAndView modelAndView = new ModelAndView("/employee/view");
            modelAndView.addObject("employee",employee);
            return modelAndView;
        } else {
            return new ModelAndView("/error404");
        }
    }
}
