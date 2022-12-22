package com.tutrit.stoservice.servlets;

import com.tutrit.stoservice.repository.CarRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.tutrit.stoservice.context.ApplicationContext.get;

public class CarTableServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("cars", get(CarRepository.class).findAll());
        req.getRequestDispatcher("/WEB-INF/view/carTable.jsp").forward(req, resp);
    }
}
