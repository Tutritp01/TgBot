package com.tutrit.stoservice.servlets;

import com.tutrit.stoservice.bean.Order;
import com.tutrit.stoservice.repository.OrderRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.tutrit.stoservice.context.ApplicationContext.get;

public class OrderCardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/orderCard.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order = new Order();
        order.setId(req.getParameter("id"));
        order.setOrderStatus(req.getParameter("orderStatus"));
        get(OrderRepository.class).save(order);

        req.getRequestDispatcher("/WEB-INF/view/orderCard.jsp").forward(req, resp);
    }
}
