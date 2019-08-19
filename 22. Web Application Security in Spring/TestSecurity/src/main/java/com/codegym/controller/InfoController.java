/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/26/2019                     *
 * Time: 4:31 PM                     *
 *************************************
 */

package com.codegym.controller;

import com.codegym.service.IInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
@RequestMapping
public class InfoController {

    @Autowired
    private IInfoService service;
    @RequestMapping("/info")
    public @ResponseBody
    String userInfo(Authentication authentication) {
        String msg = "";
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            String role = authority.getAuthority();
            msg += service.getMsg()+ authentication.getName()+", You have "+ role;
        }
        return msg;
    }
}
