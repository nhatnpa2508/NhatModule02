/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/25/2019                     *
 * Time: 11:56 PM                     *
 *************************************
 */

package com.codegym.blog.service;

import com.codegym.blog.controller.model.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();

    Category findById(Long id);

    void save(Category category);

    void remove(Long id);
}
