package com.tutrit.stoservice.servlets;

import com.tutrit.stoservice.repository.CarRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.tutrit.stoservice.context.ApplicationContext.get;

public class CarTableServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("cars", get(CarRepository.class).findAll());
        req.getRequestDispatcher("/carTable.jsp").forward(req, resp);
    }
}
