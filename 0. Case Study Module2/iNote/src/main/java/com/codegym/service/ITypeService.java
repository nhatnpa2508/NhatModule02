/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/27/2019                     *
 * Time: 9:53 PM                     *
 *************************************
 */

package com.codegym.service;

import com.codegym.model.Type;

public interface ITypeService {

    Iterable<Type> findAll();

    Type findById(Long id);

    void save(Type type);

    void remove(Long id);

}
