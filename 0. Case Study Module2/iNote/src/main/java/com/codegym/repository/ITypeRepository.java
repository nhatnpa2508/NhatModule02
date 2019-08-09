/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/27/2019                     *
 * Time: 9:53 PM                     *
 *************************************
 */

package com.codegym.repository;

import com.codegym.model.Type;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ITypeRepository extends PagingAndSortingRepository<Type,Long> {
}
