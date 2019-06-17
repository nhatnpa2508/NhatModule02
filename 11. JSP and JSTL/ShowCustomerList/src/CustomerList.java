/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 6/17/2019                     *
 * Time: 7:50 PM                     *
 *************************************
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerList {
    private  static Map<Integer, Customer> customers;
    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "John", "1/2/1994", "Hanoi","https://st.quantrimang.com/photos/image/2018/01/02/hinh-nen-nhung-chu-cun-cho-may-tinh-9.jpg"));
        customers.put(2, new Customer(2, "Bill", "27/12/1998", "Danang","https://st.quantrimang.com/photos/image/2018/01/02/hinh-nen-nhung-chu-cun-cho-may-tinh-9.jpg"));
        customers.put(3, new Customer(3, "Alex", "5/12/1995", "Saigon","https://st.quantrimang.com/photos/image/2018/01/02/hinh-nen-nhung-chu-cun-cho-may-tinh-9.jpg"));
        customers.put(4, new Customer(4, "Adam", "20/4/1997", "Beijin","https://st.quantrimang.com/photos/image/2018/01/02/hinh-nen-nhung-chu-cun-cho-may-tinh-9.jpg"));
        customers.put(5, new Customer(5, "Sophia", "12/6/1994", "Miami", "https://st.quantrimang.com/photos/image/2018/01/02/hinh-nen-nhung-chu-cun-cho-may-tinh-9.jpg"));
        customers.put(6, new Customer(6, "Rose", "25/9/1989", "Newyork","https://st.quantrimang.com/photos/image/2018/01/02/hinh-nen-nhung-chu-cun-cho-may-tinh-9.jpg"));
    }
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }
}
