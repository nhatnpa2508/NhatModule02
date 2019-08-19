/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 8/15/2019                     *
 * Time: 1:41 PM                     *
 *************************************
 */

package com.codegym.repository;

import com.codegym.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    Page<Customer> findAllByFirstNameContainingOrLastNameContaining(String firstName, String lastName, Pageable pageable);
}
