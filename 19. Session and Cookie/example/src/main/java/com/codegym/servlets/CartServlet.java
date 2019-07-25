/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/25/2019                     *
 * Time: 8:45 AM                     *
 *************************************
 */

package com.codegym.servlets;

import com.codegym.entities.Item;
import com.codegym.entities.Product;
import com.codegym.models.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CartServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "buy":
                doGet_buy(request, response);
                break;
            case "remove":
                doGet_Remove(request, response);
                break;
            default:
                doGet_DisplayCart(request, response);
                break;
        }
/*        if (action == null) {
            doGet_DisplayCart(request, response);
        } else {
            if (action.equalsIgnoreCase("buy")) {
                doGet_buy(request, response);
            } else if (action.equalsIgnoreCase("remove")) {
                doGet_Remove(request, response);
            }
        }*/
    }

    private void doGet_buy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductModel productModel = new ProductModel();
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        Item item;
        if (session.getAttribute("cart") == null) {
            List<Item> cart = new ArrayList<>();
            Product product = productModel.findById(id);
            item = new Item(product,1);
            cart.add(item);
            /*cart.add(new Item(product, 1));*/
            session.setAttribute("cart", cart);
        } else {
            List<Item> cart = (List<Item>) session.getAttribute("cart");
            int index = isExisting(id, cart);
            if (index == -1) {
                Product product = productModel.findById(id);
                item = new Item(product,1);
                cart.add(item);
            } else {
                int quantity = cart.get(index).getQuantity() + 1;
                cart.get(index).setQuantity(quantity);
            }
            session.setAttribute("cart", cart);
        }
        response.sendRedirect("cart");
    }

    private void doGet_Remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        int id = Integer.parseInt(request.getParameter("id"));
        int index = isExisting(id, cart);
        cart.remove(index);
        session.setAttribute("cart", cart);
        response.sendRedirect("cart");
    }

    protected void doGet_DisplayCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("cart/index.jsp").forward(request, response);
    }

    private int isExisting(int id, List<Item> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getId() == id) {
                return i;
            }
        }
        return -1;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
