/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 8/13/2019                     *
 * Time: 3:01 PM                     *
 *************************************
 */

package com.codegym.Formatter;

import com.codegym.model.Book;
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class BookFormatter implements Formatter<Book> {

    private IBookService bookService;

    @Autowired
    public BookFormatter(IBookService categoryService) {
        this.bookService = categoryService;
    }

    @Override
    public Book parse(String text, Locale locale) throws ParseException {
        return bookService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Book object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
