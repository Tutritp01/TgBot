package com.tutrit.stoservice.servlets;

import com.tutrit.stoservice.bean.Car;
import com.tutrit.stoservice.bean.Customer;
import com.tutrit.stoservice.repository.CarRepository;
import com.tutrit.stoservice.repository.CustomerRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.tutrit.stoservice.context.ApplicationContext.get;

public class CustomerCardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/customerCard.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer customer = new Customer();
        customer.setId(req.getParameter("id"));
        customer.setName(req.getParameter("name"));
        customer.setPhoneNumber(req.getParameter("phoneNumber"));
        customer.setCity(req.getParameter("city"));
        customer.setEmail(req.getParameter("email"));
        get(CustomerRepository.class).save(customer);

        req.getRequestDispatcher("/WEB-INF/view/customerCard.jsp").forward(req, resp);
    }
}
