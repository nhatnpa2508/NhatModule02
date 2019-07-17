/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/17/2019                     *
 * Time: 10:59 AM                     *
 *************************************
 */

package com.codegym.model;

public class Product {
    private int id;
    private String name;
    private String infor;
    private double price;
    public Product(){}

    public Product(int id, String name, String infor, double price) {
        this.id = id;
        this.name = name;
        this.infor = infor;
        this.price = price;
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

    public String getInfor() {
        return infor;
    }

    public void setInfor(String infor) {
        this.infor = infor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
