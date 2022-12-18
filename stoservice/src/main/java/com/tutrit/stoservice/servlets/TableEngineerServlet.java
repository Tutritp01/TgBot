package com.tutrit.stoservice.servlets;

import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.context.ApplicationContext;

import com.tutrit.stoservice.repository.EngineerRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AllEngineers", value = "/all-engineer")
public class TableEngineerServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        if (ApplicationContext.get(EngineerRepository.class).findAll() != null) {
            List<Engineer> listEngineer = (List<Engineer>) ApplicationContext.get(EngineerRepository.class).findAll();
            request.setAttribute("listEngineers", listEngineer);
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/list/all-engineer.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException("Exception in TableEngineerServlet.doGet " + e);
        }
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) {
        doGet(req, resp);
    }
}
