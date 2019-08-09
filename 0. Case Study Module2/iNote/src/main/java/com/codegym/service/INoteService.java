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

import com.codegym.model.Note;
import com.codegym.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface INoteService {
    Page<Note> findAll(Pageable pageable);

    Note findById(Long id);

    void save(Note note);

    void remove(Long id);

    Iterable<Note> findAllByType(Type type);

    Page<Note> findAllByTitleContaining(String title, Pageable pageable);
}
