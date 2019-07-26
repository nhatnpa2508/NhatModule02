/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/25/2019                     *
 * Time: 11:58 PM                     *
 *************************************
 */

package com.codegym.blog.repository.impl;

import com.codegym.blog.controller.model.Category;
import com.codegym.blog.repository.ICategoryRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CategoryRepositoryImpl implements ICategoryRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Category> findAll() {
        TypedQuery<Category> query = em.createQuery("select c from Category c",Category.class);
        return query.getResultList();
    }

    public Category findById(Long id) {
        TypedQuery<Category> query = em.createQuery("select c from Category c where c.id =:id", Category.class);
        query.setParameter("id",id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void save(Category model) {
        if (model.getId() != null){
            em.merge(model);
        }else {
            em.persist(model);
        }
    }

    public void remove(Long id) {
        Category ca = findById(id);
        if (ca != null){
            em.remove(ca);
        }
    }
}
