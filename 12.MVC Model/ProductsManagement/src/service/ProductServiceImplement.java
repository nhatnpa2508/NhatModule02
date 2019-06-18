/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 6/17/2019                     *
 * Time: 10:04 PM                     *
 *************************************
 */

package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImplement implements ProductService {
    private  static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1,"Dog",200000,"Chó con","DogMom"));
        products.put(2, new Product(2,"Cat",100000,"Mèo con","CatMom"));
        products.put(3, new Product(3,"Mouse",50000,"Chuột Lang","MouseMom"));
        products.put(4, new Product(4,"Monkey",500000,"Khỉ con","MonkeyMom"));
        products.put(5, new Product(5,"Panda",2500000,"Gấu trúc con","PandaMom"));
        products.put(6, new Product(6,"Fish",30000,"Cá nhỏ","FishMom"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

}
