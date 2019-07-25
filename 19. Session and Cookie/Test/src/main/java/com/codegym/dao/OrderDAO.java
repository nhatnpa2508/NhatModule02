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

import com.codegym.model.CartInfo;
import com.codegym.model.OrderDetailInfo;
import com.codegym.model.OrderInfo;
import com.codegym.model.PaginationResult;

import java.util.List;

public interface OrderDAO {

    public void saveOrder(CartInfo cartInfo);

    public PaginationResult<OrderInfo> listOrderInfo(int page, int maxResult, int maxNavigationPage);

    public OrderInfo getOrderInfo(String orderId);

    public List<OrderDetailInfo> listOrderDetailInfos(String orderId);
}
