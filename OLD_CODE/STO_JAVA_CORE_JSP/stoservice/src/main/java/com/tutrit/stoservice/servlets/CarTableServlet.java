package com.tutrit.stoservice.servlets;

import com.tutrit.stoservice.bean.Car;
import com.tutrit.stoservice.provider.CarProvider;
import com.tutrit.stoservice.repository.CarRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static com.tutrit.stoservice.context.ApplicationContext.get;

public class CarTableServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        List<Car> carList = get(CarProvider.class).getCar();
        get(CarRepository.class).saveAll(carList);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Car> cars = (List<Car>) get(CarRepository.class).findAll();
        if (cars == null || cars.isEmpty()) {
            req.setAttribute("output", "There is no data");
            req.getRequestDispatcher("/WEB-INF/view/header.jsp").forward(req, resp);
        } else {
            req.setAttribute("cars", cars);
            req.getRequestDispatcher("/WEB-INF/view/carTable.jsp").forward(req, resp);
        }
    }
}
