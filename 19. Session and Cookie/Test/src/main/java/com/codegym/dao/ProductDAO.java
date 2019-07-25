/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/24/2019                     *
 * Time: 1:48 PM                     *
 *************************************
 */

package com.codegym.dao;

import com.codegym.entity.Product;
import com.codegym.model.PaginationResult;
import com.codegym.model.ProductInfo;

public interface ProductDAO {
    public Product findProduct(String code);

    public ProductInfo findProductInfo(String code);

    public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage);

    public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage, String likeName);

    public void save(ProductInfo productInfo);
}
