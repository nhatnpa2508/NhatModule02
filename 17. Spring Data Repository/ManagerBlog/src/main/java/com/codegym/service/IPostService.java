/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/20/2019                     *
 * Time: 9:35 AM                     *
 *************************************
 */

package com.codegym.service;

import com.codegym.model.Category;
import com.codegym.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPostService {
    Page<Post> findAll(Pageable pageable);

    Post findById(Long id);

    void save(Post post);

    void remove(Long id);

    Iterable<Post> findAllByCategory(Category category);

    Page<Post> findAllByNameContaining(String name, Pageable pageable);
}
