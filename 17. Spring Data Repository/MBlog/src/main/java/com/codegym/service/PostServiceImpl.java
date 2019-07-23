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
import com.codegym.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public class PostServiceImpl implements IPostService {
    @Autowired
    private IPostRepository postRepository;

    @Override
    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findOne(id);
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void remove(Long id) {
        postRepository.delete(id);
    }

    @Override
    public Iterable<Post> findAllByCategory(Category category) {
        return postRepository.findAllByCategory(category);
    }

    @Override
    public Page<Post> findAllByNameContaining(String name, Pageable pageable) {
        return postRepository.findAllByNameContaining(name, pageable);
    }
}
