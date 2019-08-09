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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TypeController {

    @Autowired
    private ITypeService typeService;

    @Autowired
    private INoteService noteService;

    @GetMapping("/types")
    public ModelAndView listType(){
        Iterable<Type> types = typeService.findAll();
        ModelAndView modelAndView = new ModelAndView("/type/list");
        modelAndView.addObject("types",types);
        return modelAndView;
    }

    @GetMapping("type/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/type/create");
        modelAndView.addObject("type",new Type());
        return modelAndView;
    }

    @PostMapping("type/create")
    public ModelAndView saveType(@ModelAttribute("type")Type type){
        typeService.save(type);

        ModelAndView modelAndView = new ModelAndView("/type/create");
        modelAndView.addObject("message","New Type was Created");
        modelAndView.addObject("type",new Type());
        return modelAndView;
    }

    @GetMapping("type/edit/{id}")
    public ModelAndView showEditForm(@PathVariable("id")Long id){
        Type type = typeService.findById(id);
        if (type != null){
            ModelAndView modelAndView = new ModelAndView("/type/edit");
            modelAndView.addObject("type",type);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error404");
            return modelAndView;
        }
    }

    @PostMapping("type/edit")
    public ModelAndView editType(@ModelAttribute("type")Type type){
        ModelAndView modelAndView = new ModelAndView("/type/edit");
        modelAndView.addObject("message","Type was Updated");
        modelAndView.addObject("type",type);
        return modelAndView;
    }
    @GetMapping("type/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable("id")Long id){
        Type type = typeService.findById(id);
        if (type != null){
            ModelAndView modelAndView = new ModelAndView("/type/delete");
            modelAndView.addObject("type",type);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error404");
            return modelAndView;
        }
    }
    @PostMapping("type/delete")
    public String deleteType(@ModelAttribute("type")Type type){
        typeService.remove(type.getId());
        return "redirect:types";
    }

    @GetMapping("type/view/{id}")
    public ModelAndView viewType(@PathVariable("id")Long id){
        Type type = typeService.findById(id);
        if (type == null){
            return new ModelAndView("/error404");
        }
        Iterable<Note> notes = noteService.findAllByType(type);
        ModelAndView modelAndView = new ModelAndView("/type/view");
        modelAndView.addObject("notes",notes);
        modelAndView.addObject("type",type);
        return modelAndView;
    }
}