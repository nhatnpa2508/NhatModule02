/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 8/9/2019                     *
 * Time: 2:56 PM                     *
 *************************************
 */

package com.codegym.service;

import com.codegym.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {

    Page<Employee> findAll(Pageable pageable);

    Employee findById(Long id);

    void save(Employee employee);

    void remove(Long id);

    Page<Employee> findAllByFullNameContaining(String input, Pageable pageable);
}
