/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/25/2019                     *
 * Time: 11:55 PM                     *
 *************************************
 */

package com.codegym.blog.controller;

import com.codegym.blog.controller.model.Category;
import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

//-------------------Retrieve All --------------------------------------------------------

    @GetMapping("/categories/")
    public ResponseEntity<List<Category>> listCategory(){
        List<Category> categories = categoryService.findAll();
        if (categories.isEmpty()){
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Category>>(categories,HttpStatus.OK);
    }
//-------------------Retrieve Single --------------------------------------------------------

    @GetMapping(value = "/categories/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> getCustomer(@PathVariable("id")Long id){
        System.out.println("Fetching Category with id " + id);
        Category category = categoryService.findById(id);
        if (category == null){
            System.out.println("Category with id " + id + " not found");
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }

    //-------------------Create --------------------------------------------------------

    @PostMapping("/categories/")
    public ResponseEntity<Void> saveCategory(@RequestBody Category category,  UriComponentsBuilder ucBuilder){
        System.out.println("Creating Category " + category.getName());
        categoryService.save(category);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/categories/{id}").buildAndExpand(category.getId()).toUri());
        return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
    }

    //------------------- Update  --------------------------------------------------------

    @PutMapping("/categories/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id")Long id,@RequestBody Category category){
        System.out.println("Updating Category " + id);
        Category categoryTemp = categoryService.findById(id);

        if (categoryTemp == null){
            System.out.println("Category with id " + id + " not found");
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
        categoryTemp.setId(category.getId());
        categoryTemp.setName(category.getName());

        categoryService.save(categoryTemp);
        return new ResponseEntity<Category>(categoryTemp,HttpStatus.OK);
    }
    //------------------- Delete  --------------------------------------------------------

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable("id")Long id){
        System.out.println("Fetching & Deleting Category with id " + id);
        Category category = categoryService.findById(id);
        if (category == null){
            System.out.println("Unable to delete Category id: " + id + "not found");
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
        categoryService.remove(id);
        return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
    }
}
