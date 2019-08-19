/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 8/13/2019                     *
 * Time: 2:57 PM                     *
 *************************************
 */

package com.codegym.service;

import com.codegym.model.Book;

public interface IBookService {

    Iterable<Book> findAll();

    Book findById(Long id);

    void save(Book book);

    void remove(Long id);
}
