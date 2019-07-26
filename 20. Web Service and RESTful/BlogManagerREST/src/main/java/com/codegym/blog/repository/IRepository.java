/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/25/2019                     *
 * Time: 10:45 PM                     *
 *************************************
 */

package com.codegym.blog.repository;

import java.util.List;

public interface IRepository<T> {
    List<T> findAll();

    T findById(Long id);

    void save(T model);

    void remove(Long id);
}
