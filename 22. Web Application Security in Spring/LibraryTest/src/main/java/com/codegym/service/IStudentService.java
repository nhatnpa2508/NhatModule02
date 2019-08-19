/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 8/13/2019                     *
 * Time: 2:57 PM                     *
 *************************************
 */

package com.codegym.service;

import com.codegym.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface IStudentService {

    Iterable<Student> findAll();

    Page<Student> findAll(Pageable pageable);

    Student findById(Long id);

    void save(Student student);

    void remove(Long id);

    Page<Student> findAllByFullNameContainingOrBook_BookCode(String fullName, String bookCode, Pageable pageable);

    Student findStudentByEmail(String email);

    Page<Student> findAllByBook_Id(Pageable pageable);
}
