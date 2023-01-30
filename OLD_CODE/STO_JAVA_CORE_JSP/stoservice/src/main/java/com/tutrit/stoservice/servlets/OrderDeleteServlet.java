package com.tutrit.stoservice.servlets;

import com.tutrit.stoservice.repository.CustomerRepository;
import com.tutrit.stoservice.repository.OrderRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.tutrit.stoservice.context.ApplicationContext.get;

public class OrderDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/orderDelete.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = String.valueOf(req.getParameter("id"));
        get(OrderRepository.class).deleteById(id);
        req.getRequestDispatcher("/WEB-INF/view/orderTable.jsp").forward(req, resp);

    }
}
