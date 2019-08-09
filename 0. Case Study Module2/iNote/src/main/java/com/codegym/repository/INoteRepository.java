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

import com.codegym.model.Note;
import com.codegym.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface INoteRepository extends PagingAndSortingRepository<Note, Long> {
    Iterable<Note> findAllByType(Type type);

    Page<Note> findAllByTitleContaining(String title, Pageable pageable);
}
