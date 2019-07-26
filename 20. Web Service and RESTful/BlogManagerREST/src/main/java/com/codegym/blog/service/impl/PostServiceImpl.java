/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/25/2019                     *
 * Time: 11:57 PM                     *
 *************************************
 */

package com.codegym.blog.service.impl;

import com.codegym.blog.controller.model.Post;
import com.codegym.blog.repository.IPostRepository;
import com.codegym.blog.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PostServiceImpl implements IPostService {

    @Autowired
    private IPostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void remove(Long id) {
        postRepository.remove(id);
    }
}
