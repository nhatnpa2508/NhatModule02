/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 8/14/2019                     *
 * Time: 4:38 PM                     *
 *************************************
 */

package com.codegym.service;

import org.springframework.security.access.prepost.PreAuthorize;

public interface IInfoService {
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public String getMsg();
}
