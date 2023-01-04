package com.tutrit.stoservice.servlets;

import com.tutrit.stoservice.bean.Order;
import com.tutrit.stoservice.provider.DemoDataLoader;
import com.tutrit.stoservice.repository.OrderRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

import static com.tutrit.stoservice.context.ApplicationContext.get;

public class OrderTableServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //class.Cast.Exception
        Map<String, Order> orders = (Map<String, Order>) get(OrderRepository.class).findAll();
        if (orders == null || orders.isEmpty()) {
            req.setAttribute("output", "There is no data");
            req.getRequestDispatcher("/WEB-INF/view/header.jsp").forward(req, resp);
        } else {
            req.setAttribute("orders", orders);
            req.getRequestDispatcher("/WEB-INF/view/orderTable.jsp").forward(req, resp);
        }
    }
}
