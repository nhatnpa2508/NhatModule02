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

import com.codegym.model.Post;

import java.util.List;

public interface IPostService {
    List<Post> findAll();
    Post findById(Long id);
    void save(Post post);
    void remove(Long id);
}
