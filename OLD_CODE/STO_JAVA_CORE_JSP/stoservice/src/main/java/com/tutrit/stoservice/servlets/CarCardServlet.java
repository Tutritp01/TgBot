package com.tutrit.stoservice.servlets;

import com.tutrit.stoservice.bean.Car;
import com.tutrit.stoservice.repository.CarRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.tutrit.stoservice.context.ApplicationContext.get;

public class CarCardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/carCard.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Car car = new Car();
        car.setId(req.getParameter("id"));
        car.setOwner(req.getParameter("owner"));
        car.setVin(req.getParameter("vin"));
        car.setPlateNumber(req.getParameter("plateNumber"));
        car.setBrand(req.getParameter("brand"));
        car.setModel(req.getParameter("model"));
        car.setGeneration(req.getParameter("generation"));
        car.setModification(req.getParameter("modification"));
        car.setEngine(req.getParameter("engine"));
        car.setYear(Integer.parseInt(req.getParameter("year")));
        get(CarRepository.class).save(car);

        req.getRequestDispatcher("/WEB-INF/view/carCard.jsp").forward(req, resp);
    }
}
