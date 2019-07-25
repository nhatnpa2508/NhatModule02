/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/24/2019                     *
 * Time: 9:29 AM                     *
 *************************************
 */

package com.codegym.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "orders", uniqueConstraints = {@UniqueConstraint(columnNames = "orderNum")})
public class Order {
    private static final long serialVersionUID = -2576670215015463100L;

    @Id
    @Column(name = "id", length = 50)
    private String id;

    @Column(name = "orderDate", nullable = false)
    private Date orderDate;

    @Column(name = "oderNum", nullable = false)
    private int orderNum;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "customerName", length = 245, nullable = false)
    private String customerName;

    @Column(name = "customerAddress", length = 245, nullable = false)
    private String customerAddress;

    @Column(name = "customerEmail", length = 128, nullable = false)
    private String customerEmail;

    @Column(name = "Customer_Phone", length = 128, nullable = false)
    private String customerPhone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public Order() {
    }

    public Order(Date orderDate, int orderNum, double amount, String customerName, String customerAddress, String customerEmail, String customerPhone) {
        this.orderDate = orderDate;
        this.orderNum = orderNum;
        this.amount = amount;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
    }
}
