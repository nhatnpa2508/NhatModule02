/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/25/2019                     *
 * Time: 9:09 AM                     *
 *************************************
 */

package com.codegym.models;

import com.codegym.entities.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductModel {

    private static Map<Integer,Product> products;
    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Dog", 200000, "dog.jpg"));
        products.put(2, new Product(2, "Cat", 100000, "dog.jpg"));
        products.put(3, new Product(3, "Mouse", 50000, "dog.jpg"));
        products.put(4, new Product(4, "Panda", 500000, "dog.jpg"));
        products.put(5, new Product(5, "Monkey", 400000, "dog.jpg"));
        products.put(6, new Product(6, "Turtle", 300000, "dog.jpg"));
    }


    public Product findById(int id) {
        return products.get(id);
    }

    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    public void remove(int id) {
        products.remove(id);
    }
}
