/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 8/15/2019                     *
 * Time: 1:50 PM                     *
 *************************************
 */

package com.codegym.service.impl;

import com.codegym.model.Customer;
import com.codegym.repository.ICustomerRepository;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        pageable = new PageRequest(pageable.getPageNumber(),7);
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findOne(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.delete(id);
    }

    @Override
    public Page<Customer> findAllByFirstNameContainingOrLastNameContaining(String firstName, String lastName, Pageable pageable) {
        pageable = new PageRequest(pageable.getPageNumber(),7);
        return customerRepository.findAllByFirstNameContainingOrLastNameContaining(firstName, lastName, pageable);
    }

}
