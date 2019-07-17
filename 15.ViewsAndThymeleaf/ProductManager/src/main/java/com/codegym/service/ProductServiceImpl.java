/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/17/2019                     *
 * Time: 11:00 AM                     *
 *************************************
 */

package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements IProductService {

    private static Map<Integer,Product> products;
    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Dog", "Gau Gau", 200000));
        products.put(2, new Product(2, "Cat", "Meo Meo", 100000));
        products.put(3, new Product(3, "Mouse", "Chit Chit", 50000));
        products.put(4, new Product(4, "Panda", "Rap Rap", 500000));
        products.put(5, new Product(5, "Monkey", "Ki Ki", 400000));
        products.put(6, new Product(6, "Turtle", "Ru Ru", 300000));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
