package com.tutrit.stoservice.servlets;

import com.tutrit.stoservice.context.ApplicationContext;
import com.tutrit.stoservice.repository.CarRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DeleteCardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/carDelete.jsp").forward(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        String id = String.valueOf(req.getAttribute("id"));
        ApplicationContext.get(CarRepository.class).deleteById(id);
        req.getRequestDispatcher("/WEB-INF/view/carTable.jsp");
    }
}
