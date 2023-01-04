package com.tutrit.stoservice.servlets;

import com.tutrit.stoservice.bean.Customer;
import com.tutrit.stoservice.repository.CustomerRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.tutrit.stoservice.context.ApplicationContext.get;

public class CustomerFormServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/customerForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = String.valueOf(req.getParameter("id"));
        Customer customer = get(CustomerRepository.class).findById(id);
        if (customer != null) {
            req.setAttribute("id", customer.getId());
            req.setAttribute("name", customer.getName());
            req.setAttribute("city", customer.getCity());
            req.setAttribute("phoneNumber", customer.getPhoneNumber());
            req.setAttribute("email", customer.getEmail());
        }
        req.getRequestDispatcher("/WEB-INF/view/customerForm.jsp").forward(req, resp);
    }
}
