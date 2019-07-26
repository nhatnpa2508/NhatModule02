/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/25/2019                     *
 * Time: 11:54 PM                     *
 *************************************
 */

package com.codegym.blog.controller;

import com.codegym.blog.controller.model.Category;
import com.codegym.blog.controller.model.Post;
import com.codegym.blog.service.ICategoryService;
import com.codegym.blog.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    private IPostService postService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }
//-------------------Retrieve All --------------------------------------------------------

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> listAllPost(){
        List<Post> posts = postService.findAll();
        if (posts.isEmpty()){
            return new ResponseEntity<List<Post>>(HttpStatus.NO_CONTENT);
            //You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
    }

    //-------------------Retrieve Single --------------------------------------------------------

    @GetMapping(value = "/posts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post> getPost(@PathVariable("id")Long id){
        System.out.println("Fetching Post with id " + id);
        Post post = postService.findById(id);
        if (post == null){
            System.out.println("Post with id " + id + " not found");
            return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Post>(post, HttpStatus.OK);
    }

    //-------------------Create --------------------------------------------------------

    @PostMapping("/posts/")
    public ResponseEntity<Void> createPost(@RequestBody Post post,
                                               UriComponentsBuilder ucBuilder){
        System.out.println("Creating Customer " + post.getTitle());
        postService.save(post);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/post/{id}").buildAndExpand(post.getId()).toUri());
        return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
    }
    //------------------- Update  --------------------------------------------------------

    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable("id")Long id,
                                                   @RequestBody Post post){
        System.out.println("Updating Post " + id);
        Post postTerm = postService.findById(id);

        if (postTerm == null){
            System.out.println("Post with id " + id + " not found");
            return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
        }
        postTerm.setId(post.getId());
        postTerm.setAuthor(post.getAuthor());
        postTerm.setContent(post.getContent());
        postTerm.setTitle(post.getTitle());
        postTerm.setCategory(post.getCategory());

        postService.save(postTerm);
        return new ResponseEntity<Post>(postTerm, HttpStatus.OK);
    }
    //------------------- Delete  --------------------------------------------------------

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Post> deleteCustomer(@PathVariable("id")Long id){
        System.out.println("Fetching & Deleting Post with id " + id);

        Post post = postService.findById(id);
        if (post == null){
            System.out.println("Unable to delete. Post with id " + id + " not found");
            return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
        }

        postService.remove(id);
        return new ResponseEntity<Post>(HttpStatus.NO_CONTENT);
    }
}
