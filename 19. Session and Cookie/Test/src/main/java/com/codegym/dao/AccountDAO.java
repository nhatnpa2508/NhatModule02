/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/24/2019                     *
 * Time: 1:48 PM                     *
 *************************************
 */

package com.codegym.dao;

import com.codegym.entity.Account;

public interface AccountDAO {
    public Account findAccount(String userName);
}
