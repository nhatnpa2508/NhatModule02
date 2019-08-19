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
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping(value="/books",produces = "application/json;charset=UTF-8")
    public ModelAndView listBooks(){
        Iterable<Book> books = bookService.findAll();
        ModelAndView modelAndView = new ModelAndView("/book/list");
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @GetMapping(value="/book-create",produces = "application/json;charset=UTF-8")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/book/create");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }

    @PostMapping(value="/book-create",produces = "application/json;charset=UTF-8")
    public ModelAndView saveBook(@ModelAttribute("book") Book book){
        bookService.save(book);

        ModelAndView modelAndView = new ModelAndView("/book/create");
        modelAndView.addObject("book", new Book());
        modelAndView.addObject("message", "New book created successfully");
        return modelAndView;
    }

    @GetMapping(value="/book-edit/{id}",produces = "application/json;charset=UTF-8")
    public ModelAndView showEditForm(@PathVariable Long id){
        Book book = bookService.findById(id);
        if(book != null) {
            ModelAndView modelAndView = new ModelAndView("/book/edit");
            modelAndView.addObject("book", book);
            return modelAndView;

        }else {
            return new ModelAndView("/error404");
        }
    }

    @PostMapping(value="/book-edit",produces = "application/json;charset=UTF-8")
    public ModelAndView updateBook(@ModelAttribute("book") Book book){
        bookService.save(book);
        ModelAndView modelAndView = new ModelAndView("/book/edit");
        modelAndView.addObject("book", book);
        modelAndView.addObject("message", "Book updated successfully");
        return modelAndView;
    }

    @GetMapping(value="/book-delete/{id}",produces = "application/json;charset=UTF-8")
    public String deleteBook(@PathVariable Long id){
        Book book = bookService.findById(id);
        if(book != null){
            bookService.remove(id);
            return "redirect:/books";
        } else {
            return "/error404";
        }
    }
}
