/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 6/17/2019                     *
 * Time: 4:47 PM                     *
 *************************************
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer {
    private int id;
    private String name;
    private String email;
    private String adress;

    public Customer(){}

    public Customer(int id, String name, String email, String adress){
        this.id = id;
        this.name = name;
        this.email = email;
        this.adress = adress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    private static Map<Integer, Customer> customers;
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
}
