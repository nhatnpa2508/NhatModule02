/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/23/2019                     *
 * Time: 8:10 AM                     *
 *************************************
 */

package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.model.Post;
import com.codegym.service.ICategoryService;
import com.codegym.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {
    //Cơ chế tiêm của Bean (tiêm giao diện interface vào,) biến thằng interface thành thằng implement ở ApplicationConfig
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IPostService postService;

    @GetMapping("/categories")
    public ModelAndView listProvinces(){
        Iterable<Category> categories = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/category/list");
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @GetMapping("/category-create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/category-create")
    public ModelAndView saveProvince(@ModelAttribute("Category") Category category){
        categoryService.save(category);

        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Category());
        modelAndView.addObject("message", "New category created successfully");
        return modelAndView;
    }

    @GetMapping("/category-edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Category category = categoryService.findById(id);
        if(category != null) {
            ModelAndView modelAndView = new ModelAndView("/category/edit");
            modelAndView.addObject("category", category);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error404");
            return modelAndView;
        }
    }

    @PostMapping("/category-edit")
    public ModelAndView updateProvince(@ModelAttribute("category") Category category){
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/category/edit");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "Category updated successfully");
        return modelAndView;
    }

    @GetMapping("/category-delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Category category = categoryService.findById(id);
        if(category != null) {
            ModelAndView modelAndView = new ModelAndView("/category/delete");
            modelAndView.addObject("category", category);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error404");
            return modelAndView;
        }
    }

    @PostMapping("/category-delete")
    public String deleteProvince(@ModelAttribute("category") Category category){
        categoryService.remove(category.getId());
        return "redirect:categories";
    }

    @GetMapping("/category-view/{id}")
    public ModelAndView viewCategory(@PathVariable("id") Long id){
        Category category = categoryService.findById(id);
        if(category == null){
            return new ModelAndView("/error404");
        }

        Iterable<Post> posts = postService.findAllByCategory(category);

        ModelAndView modelAndView = new ModelAndView("/category/view");
        modelAndView.addObject("category", category);
        modelAndView.addObject("posts", posts);
        return modelAndView;
    }
}
