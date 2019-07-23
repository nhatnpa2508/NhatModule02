/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/23/2019                     *
 * Time: 8:10 AM                     *
 *************************************
 */

package com.codegym.service;

import com.codegym.model.Category;

public interface ICategoryService {

    Iterable<Category> findAll();

    Category findById(Long id);

    void save(Category category);

    void remove(Long id);
}
