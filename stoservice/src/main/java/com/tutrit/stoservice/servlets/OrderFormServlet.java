package com.tutrit.stoservice.servlets;

import com.tutrit.stoservice.bean.Car;
import com.tutrit.stoservice.bean.Order;
import com.tutrit.stoservice.repository.CarRepository;
import com.tutrit.stoservice.repository.OrderRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.tutrit.stoservice.context.ApplicationContext.get;

public class OrderFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/orderForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = String.valueOf(req.getParameter("id"));
        Order order = get(OrderRepository.class).findById(id);
        if (order != null) {
            req.setAttribute("id", order.getId());
            req.setAttribute("orderStatus", order.getOrderStatus());
        }
        req.getRequestDispatcher("/WEB-INF/view/orderForm.jsp").forward(req, resp);
    }
}
