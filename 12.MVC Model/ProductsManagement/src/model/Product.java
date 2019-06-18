/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 6/17/2019                     *
 * Time: 10:03 PM                     *
 *************************************
 */

package model;

public class Product {
    private int id;
    private String name;
    private float price;
    private String info;
    private String producer;

    public Product(){}

    public Product(int id, String name,float price, String info, String producer){
        this.id = id;
        this.name = name;
        this.price = price;
        this.info = info;
        this.producer = producer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
