/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/20/2019                     *
 * Time: 9:34 AM                     *
 *************************************
 */

package com.codegym.repository;

import com.codegym.model.Category;
import com.codegym.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IPostRepository extends PagingAndSortingRepository<Post, Long> {
    Iterable<Post> findAllByCategory(Category category);

    Page<Post> findAllByNameContaining(String name, Pageable pageable);
}
