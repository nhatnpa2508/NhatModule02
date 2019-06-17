/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 6/17/2019                     *
 * Time: 4:51 PM                     *
 *************************************
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomersList {
    private  static Map<Integer, Customer> customers;
    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1,"John","john@codegym.vn","Hanoi"));
        customers.put(2, new Customer(2,"Bill","bill@codegym.vn","Danang"));
        customers.put(3, new Customer(3,"Alex","alex@codegym.vn","Saigon"));
        customers.put(4, new Customer(4,"Adam","adam@codegym.vn","Beijing"));
        customers.put(5, new Customer(5,"Sophia","sophia@codegym.vn","Miami"));
        customers.put(6, new Customer(6,"Rose","rose@codegym.vn","Newyork"));
    }

    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    public void save(Customer customer) {
        customers.put(customer.getId(),customer);
    }

    public Customer findByID(int id) {
        return customers.get(id);
    }

    public void update(int id, Customer customer) {
        customers.put(id,customer);
    }

    public void remove(int id) {
        customers.remove(id);
    }
}