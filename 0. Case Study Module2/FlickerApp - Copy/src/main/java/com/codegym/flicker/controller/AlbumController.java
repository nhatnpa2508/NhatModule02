/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/29/2019                     *
 * Time: 3:20 PM                     *
 *************************************
 */

package com.codegym.flicker.controller;

import com.codegym.flicker.model.Album;
import com.codegym.flicker.model.Category;
import com.codegym.flicker.model.Image;
import com.codegym.flicker.model.User;
import com.codegym.flicker.service.IAlbumService;
import com.codegym.flicker.service.ICategoryService;
import com.codegym.flicker.service.IImageService;
import com.codegym.flicker.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@SessionAttributes("user")
public class AlbumController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IAlbumService albumService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IImageService imageService;

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return categoryService.findAll();
    }

    @ModelAttribute("albums")
    public Iterable<Album> albums(User user){
        return albumService.findAllByUser(user);
    }

    @ModelAttribute("user")
    public User getUser() {
        return new User();
    }

    /*--------------------------------------------------- MANAGER ALBUM ----------------------------------------------------*/

    @GetMapping(value="/viewAlbums",produces = "application/json;charset=UTF-8")
    public String listAlbum(@RequestParam("s") Optional<String> s,@ModelAttribute("user") User user, HttpSession session,
                            Pageable pageable, ModelMap model) {
        if (user.getEmail() != null) {
            if(s.isPresent()){
                Page<Album> albums = albumService.findAllByUserAndNameContaining(user, s.get(), pageable);
                model.addAttribute("albums", albums);
                session.setAttribute("user", user);
                model.addAttribute("user", user);
                return "userManager/albumList";
            } else {
                Page<Album> albums = albumService.findAllByUserAndDelete(user, pageable);
                model.addAttribute("albums", albums);
                session.setAttribute("user", user);
                model.addAttribute("user", user);
                return "userManager/albumList";
            }
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping(value ="/createAlb",produces = "application/json;charset=UTF-8")
    public ModelAndView showCreateForm(@ModelAttribute("user") User user, HttpSession session) {
        session.setAttribute("user", user);
        ModelAndView modelAndView = new ModelAndView("userManager/createAlbum");
        modelAndView.addObject("album", new Album());
        return modelAndView;
    }

    @PostMapping(value="/createAlb",produces = "application/json;charset=UTF-8")
    public ModelAndView saveAlbum(@ModelAttribute("album") Album album, @ModelAttribute("user") User user) {
        album.setUser(user);
        albumService.save(album);
        Image image = new Image();
        image.setPhoto(album.getAvatar());
        image.setAuthor(user.getEmail().substring(0,10));
        image.setTitle("Image");
        image.setAlbum(album);
        imageService.save(image);
        ModelAndView modelAndView = new ModelAndView("userManager/createAlbum");
        modelAndView.addObject("album", new Album());
        modelAndView.addObject("message", "New album created successfully");
        return modelAndView;
    }

    @GetMapping(value="/editAlb/{id}",produces = "application/json;charset=UTF-8")
    public ModelAndView viewEditForm(@PathVariable("id") Long id, @ModelAttribute("user") User user, HttpSession session) {
        user = userService.getUserByEmail(user.getEmail());
        if (user != null) {
            session.setAttribute("user", user);
            Album album = albumService.findById(id);
            ModelAndView modelAndView = new ModelAndView("/userManager/editAlb");
            modelAndView.addObject("user",user);
            modelAndView.addObject("album",album);
            return modelAndView;
        } else {
            return new ModelAndView("redirect:/login");
        }
    }

    @PostMapping(value="/editAlb",produces = "application/json;charset=UTF-8")
    public ModelAndView updateAlbum(@ModelAttribute("album")Album album, @ModelAttribute("user") User user, HttpSession session) {
        User userOfAlbum = album.getUser();
        user = userService.getUserByEmail(user.getEmail());
        if (user != null && (user.getId().equals(userOfAlbum.getId()))) {
            session.setAttribute("user", user);
            Album albumDB = albumService.findById(album.getId());
            albumDB.setName(album.getName());
            albumDB.setContent(album.getContent());
            albumDB.setPublic(album.isPublic());
            albumDB.setCategory(album.getCategory());
            albumDB.setAvatar(album.getAvatar());
            albumService.save(albumDB);
            ModelAndView modelAndView = new ModelAndView("/userManager/editAlb");
            modelAndView.addObject("user",user);
            modelAndView.addObject("album",album);
            modelAndView.addObject("message", "Album updated successfully");
            return modelAndView;
        } else {
            return new ModelAndView("redirect:/login");
        }
    }

    @GetMapping(value="/deleteAlb/{id}",produces = "application/json;charset=UTF-8")
    public String deleteAlb(@PathVariable("id") Long id, @ModelAttribute("user") User user, HttpSession session,
                            Pageable pageable,ModelMap model) {
        user = userService.getUserByEmail(user.getEmail());
        if (user != null) {
            Album album = albumService.findById(id);
            album.setDelete(true);
            albumService.save(album);
            Page<Album> albums = albumService.findAllByUserAndDelete(user, pageable);
            model.addAttribute("albums", albums);
            model.addAttribute("user", user);
            return "userManager/albumList";
        } else {
            return "redirect:/login";
        }
    }


    @GetMapping(value="/showAlbum/{id}",produces = "application/json;charset=UTF-8")
    public ModelAndView showAlbum(@PathVariable("id") Long id, @ModelAttribute("user") User user, HttpSession session) {
        user = userService.getUserByEmail(user.getEmail());
        if (user != null) {
            session.setAttribute("user",user);
            Album album = albumService.findById(id);
            Iterable<Image> imageList = imageService.findAllByAlbumAndDelete(album.getId());
            ModelAndView modelAndView = new ModelAndView("userManager/showAlbum");
            modelAndView.addObject("user",user);
            modelAndView.addObject("album",album);
            modelAndView.addObject("imageList",imageList);
            return modelAndView;
        } else {
            return new ModelAndView("redirect:/login");
        }
    }
}
