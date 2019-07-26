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

import com.codegym.blog.controller.model.Post;

import java.util.List;

public interface IPostService {

    List<Post> findAll();

    Post findById(Long id);

    void save(Post post);

    void remove(Long id);

}
