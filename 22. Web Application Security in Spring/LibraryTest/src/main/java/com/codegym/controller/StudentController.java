/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 8/13/2019                     *
 * Time: 2:57 PM                     *
 *************************************
 */

package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.model.Student;
import com.codegym.service.IBookService;
import com.codegym.service.IStudentService;
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
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private IBookService bookService;

    @ModelAttribute(value="books")
    public Iterable<Book> books(){
        return bookService.findAll();
    }

    @GetMapping(value="/students",produces = "application/json;charset=UTF-8")
    public ModelAndView listEmployee(@RequestParam("string") Optional<String> string, Pageable pageable){
        Page<Student> students;

        if(string.isPresent() && string.get() != ""){
            students = studentService.findAllByFullNameContainingOrBook_BookCode(string.get(),string.get(), pageable);
        } else {
            students = studentService.findAllByBook_Id(pageable);
        }

        ModelAndView modelAndView = new ModelAndView("/student/list");
        modelAndView.addObject("students", students);
        return modelAndView;
    }
    @GetMapping(value="/student-create",produces = "application/json;charset=UTF-8")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/student/create");
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }

    @PostMapping(value="/student-create",produces = "application/json;charset=UTF-8")
    public ModelAndView saveStudent(@Valid @ModelAttribute("student")Student student, BindingResult bindingResult){
        Student studentDB = studentService.findStudentByEmail(student.getEmail());
        if (studentDB != null){
            ModelAndView modelAndView = new ModelAndView("/student/create");
            modelAndView.addObject("student", student);
            modelAndView.addObject("message", "Student has created before");
            return modelAndView;
        }
        if(bindingResult.hasFieldErrors()){
            return new ModelAndView("/student/create");
        } else {
            studentService.save(student);
            ModelAndView modelAndView = new ModelAndView("/student/create");
            modelAndView.addObject("student", new Student());
            modelAndView.addObject("message", "Create successfully");
            return modelAndView;
        }
    }
    @GetMapping(value="/student-edit/{id}",produces = "application/json;charset=UTF-8")
    public ModelAndView showEditForm(@PathVariable Long id){
        Student student = studentService.findById(id);
        if(student != null){
            ModelAndView modelAndView = new ModelAndView("/student/edit");
            modelAndView.addObject("student",student);
            return modelAndView;
        } else {
            return new ModelAndView("/error404");
        }
    }

    @PostMapping(value="/student-edit",produces = "application/json;charset=UTF-8")
    public ModelAndView updateStudent(@Valid @ModelAttribute("student")Student student, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return new ModelAndView("/student/edit");
        } else {
            studentService.save(student);
            ModelAndView modelAndView = new ModelAndView("/student/edit");
            modelAndView.addObject("student", student);
            modelAndView.addObject("message", "Update successfully");
            return modelAndView;
        }
    }
    @GetMapping(value="/student-delete/{id}",produces = "application/json;charset=UTF-8")
    public String showDeleteForm(@PathVariable Long id){
        Student student = studentService.findById(id);
        if(student != null){
            student.setBook(null);
            studentService.save(student);
            return "redirect:/students";
        } else {
            return "/error404";
        }
    }

    @GetMapping(value="/student-view/{id}",produces = "application/json;charset=UTF-8")
    public ModelAndView showView(@PathVariable Long id){
        Student student = studentService.findById(id);
        if (student != null){
            ModelAndView modelAndView = new ModelAndView("/student/view");
            modelAndView.addObject("student",student);
            return modelAndView;
        } else {
            return new ModelAndView("/error404");
        }
    }

}
