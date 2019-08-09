/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/27/2019                     *
 * Time: 9:54 PM                     *
 *************************************
 */

package com.codegym.service.impl;

import com.codegym.model.Type;
import com.codegym.repository.ITypeRepository;
import com.codegym.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;

public class TypeServiceImpl implements ITypeService {

    @Autowired
    private ITypeRepository typeRepository;

    @Override
    public Iterable<Type> findAll() {
        return typeRepository.findAll();
    }

    @Override
    public Type findById(Long id) {
        return typeRepository.findOne(id);
    }

    @Override
    public void save(Type type) {
        typeRepository.save(type);
    }

    @Override
    public void remove(Long id) {
        typeRepository.delete(id);
    }
}
