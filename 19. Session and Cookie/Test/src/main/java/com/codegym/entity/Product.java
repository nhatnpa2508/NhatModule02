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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "products")
public class Product {

    private static final long serialVersionUID = -1000119078147252957L;
    @Id
    @Column(name = "code", length = 20, nullable = false)
    private String code;

    @Column(name = "name", length = 250, nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private double price;

    @Lob
    @Column(name = "image", length = Integer.MAX_VALUE, nullable = true)
    private byte[] image;

    // For sort.
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createDate", nullable = false)
    private Date createDate;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Product() {
    }

    public Product(String code, String name, double price, byte[] image, Date createDate) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.image = image;
        this.createDate = createDate;
    }
}
