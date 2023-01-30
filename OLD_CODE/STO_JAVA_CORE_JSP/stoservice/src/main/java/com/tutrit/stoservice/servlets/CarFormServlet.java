package com.tutrit.stoservice.servlets;

import com.tutrit.stoservice.bean.Car;
import com.tutrit.stoservice.repository.CarRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.tutrit.stoservice.context.ApplicationContext.get;

public class CarFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/carForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = String.valueOf(req.getParameter("id"));
        Car car = get(CarRepository.class).findById(id);
        if (car != null) {
            req.setAttribute("id", car.getId());
            req.setAttribute("owner", car.getOwner());
            req.setAttribute("vin", car.getVin());
            req.setAttribute("plateNumber", car.getPlateNumber());
            req.setAttribute("brand", car.getBrand());
            req.setAttribute("model", car.getModel());
            req.setAttribute("generation", car.getGeneration());
            req.setAttribute("modification", car.getModification());
            req.setAttribute("engine", car.getEngine());
            req.setAttribute("year", car.getYear());
        }
        req.getRequestDispatcher("/WEB-INF/view/carForm.jsp").forward(req, resp);
    }
}
