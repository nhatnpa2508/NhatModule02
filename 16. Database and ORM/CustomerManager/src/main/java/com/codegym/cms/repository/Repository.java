<<<<<<< HEAD
/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/19/2019                     *
 * Time: 2:43 PM                     *
 *************************************
 */

package com.codegym.cms.repository;

import java.util.List;

public interface Repository <T> {
    List<T> findAll();

    T findById(Long id);

    void save(T model);

    void remove(Long id);
}
=======
/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/19/2019                     *
 * Time: 2:43 PM                     *
 *************************************
 */

package com.codegym.cms.repository;

import java.util.List;

public interface Repository <T> {
    List<T> findAll();

    T findById(Long id);

    void save(T model);

    void remove(Long id);
}
>>>>>>> 5f51a86c18aa2e8cb69ea8806d890c307b27259d
