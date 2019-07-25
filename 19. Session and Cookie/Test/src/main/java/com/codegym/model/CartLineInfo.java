/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/24/2019                     *
 * Time: 11:37 AM                     *
 *************************************
 */

package com.codegym.model;

public class CartLineInfo {

    private ProductInfo productInfo;
    private int quantity;

    public CartLineInfo(){
        this.quantity = 0;
    }

    public ProductInfo getProductInfo(){
        return productInfo;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getAmount() {
        return this.productInfo.getPrice() * this.quantity;
    }
}
