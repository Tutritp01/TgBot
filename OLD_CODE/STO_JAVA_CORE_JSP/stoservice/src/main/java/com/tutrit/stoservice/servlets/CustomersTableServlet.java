package com.tutrit.stoservice.servlets;

import com.tutrit.stoservice.bean.Customer;
import com.tutrit.stoservice.repository.CustomerRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashSet;

import static com.tutrit.stoservice.context.ApplicationContext.get;


public class CustomersTableServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashSet<Customer> customers = (HashSet<Customer>) get(CustomerRepository.class).findAll();
        if (customers == null || customers.isEmpty()) {
            req.setAttribute("output", "CustomerRepository is empty");
            req.getRequestDispatcher("/WEB-INF/view/header.jsp").forward(req, resp);
        } else {
            req.setAttribute("customers", customers);
            req.getRequestDispatcher("/WEB-INF/view/customerTable.jsp").forward(req, resp);
        }
    }
}
