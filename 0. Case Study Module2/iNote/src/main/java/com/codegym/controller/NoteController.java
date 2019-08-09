/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/27/2019                     *
 * Time: 9:55 PM                     *
 *************************************
 */

package com.codegym.controller;

import com.codegym.model.Note;
import com.codegym.model.Type;
import com.codegym.service.INoteService;
import com.codegym.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class NoteController {
    @Autowired
    private INoteService noteService;

    @Autowired
    private ITypeService typeService;

    @ModelAttribute("types")
    public Iterable<Type> categories(){
        return typeService.findAll();
    }

    @GetMapping("/notes")
    public ModelAndView listNote(@RequestParam("s") Optional<String> s, Pageable pageable){
        Page<Note> notes;
        if(s.isPresent()){
            notes = noteService.findAllByTitleContaining(s.get(), pageable);
        } else {
            notes = noteService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/note/list");
        modelAndView.addObject("notes", notes);
        return modelAndView;
    }

    @GetMapping("/note/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/note/create");
        modelAndView.addObject("note", new Note());
        return modelAndView;
    }

    @PostMapping("/note/create")
    public ModelAndView saveNote(@ModelAttribute("note")Note note){
        noteService.save(note);

        ModelAndView modelAndView = new ModelAndView("/note/create");
        modelAndView.addObject("note", new Note());
        modelAndView.addObject("message","New note created successfully");
        return modelAndView;
    }

    @GetMapping("/note/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Note note = noteService.findById(id);
        if(note != null){
            ModelAndView modelAndView = new ModelAndView("/note/edit");
            modelAndView.addObject("note",note);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error404");
            return modelAndView;
        }
    }

    @PostMapping("/note/edit")
    public ModelAndView updateNote(@ModelAttribute("note")Note note){
        noteService.save(note);
        ModelAndView modelAndView = new ModelAndView("/note/edit");
        modelAndView.addObject("note",note);
        modelAndView.addObject("message","Note updated successfully");
        return modelAndView;
    }

    @GetMapping("/note/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Note note = noteService.findById(id);
        if(note != null){
            ModelAndView modelAndView = new ModelAndView("/note/delete");
            modelAndView.addObject("note",note);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error404");
            return modelAndView;
        }
    }

    @PostMapping("note/delete")
    public String deleteNote(@ModelAttribute("note")Note note){
        noteService.remove(note.getId());
        return "redirect:notes";
    }

    @GetMapping("/note/view/{id}")
    public ModelAndView showView(@PathVariable Long id){
        Note note = noteService.findById(id);
        if (note != null){
            ModelAndView modelAndView = new ModelAndView("/note/view");
            modelAndView.addObject("note",note);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error404");
            return modelAndView;
        }
    }
}
