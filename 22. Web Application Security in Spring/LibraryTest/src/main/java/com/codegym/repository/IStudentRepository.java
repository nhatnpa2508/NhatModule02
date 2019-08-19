/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 8/13/2019                     *
 * Time: 2:57 PM                     *
 *************************************
 */

package com.codegym.repository;

import com.codegym.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IStudentRepository extends PagingAndSortingRepository<Student, Long> {

    Page<Student> findAllByFullNameContainingOrBook_BookCode(String fullName, String bookCode, Pageable pageable);

    @Query(value = "SELECT s FROM Student s where s.book is not null")
    Page<Student> findAllByBook_Id(Pageable pageable);

    Student findStudentByEmail(String email);
}
