/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/20/2019                     *
 * Time: 9:34 AM                     *
 *************************************
 */

package com.codegym.controller;

import com.codegym.model.Post;
import com.codegym.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PostController {
    @Autowired
    private IPostService postService;

    @GetMapping("/posts")
    public ModelAndView listPost(){
        List<Post> posts = postService.findAll();
        ModelAndView modelAndView = new ModelAndView("/post/list");
        modelAndView.addObject("posts", posts);
        return modelAndView;
    }

    @GetMapping("/post-create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/post/create");
        modelAndView.addObject("post", new Post());
        return modelAndView;
    }

    @PostMapping("/post-create")
    public ModelAndView savePost(@ModelAttribute("post")Post post){
        postService.save(post);

        ModelAndView modelAndView = new ModelAndView("/post/create");
        modelAndView.addObject("post", new Post());
        modelAndView.addObject("message","New post created successfully");
        return modelAndView;
    }

    @GetMapping("/post-edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Post post = postService.findById(id);
        if(post != null){
            ModelAndView modelAndView = new ModelAndView("/post/edit");
            modelAndView.addObject("post",post);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error404");
            return modelAndView;
        }
    }

    @PostMapping("/post-edit")
    public ModelAndView updatePost(@ModelAttribute("post")Post post){
        postService.save(post);
        ModelAndView modelAndView = new ModelAndView("/post/edit");
        modelAndView.addObject("post",post);
        modelAndView.addObject("message","Post updated successfully");
        return modelAndView;
    }

    @GetMapping("/post-delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Post post = postService.findById(id);
        if(post != null){
            ModelAndView modelAndView = new ModelAndView("/post/delete");
            modelAndView.addObject("post",post);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error404");
            return modelAndView;
        }
    }

    @PostMapping("post-delete")
    public String deletePost(@ModelAttribute("post")Post post){
        postService.remove(post.getId());
        return "redirect:posts";
    }

    @GetMapping("/post-view/{id}")
    public ModelAndView showView(@PathVariable Long id){
        Post post = postService.findById(id);
        if (post != null){
            ModelAndView modelAndView = new ModelAndView("/post/view");
            modelAndView.addObject("post",post);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error404");
            return modelAndView;
        }
    }
}
