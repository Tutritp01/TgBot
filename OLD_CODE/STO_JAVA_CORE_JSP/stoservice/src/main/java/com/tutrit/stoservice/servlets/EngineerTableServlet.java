package com.tutrit.stoservice.servlets;

import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.repository.EngineerRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static com.tutrit.stoservice.context.ApplicationContext.get;

@WebServlet(name = "AllEngineers", value = "all-engineers")
public class EngineerTableServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        if (get(EngineerRepository.class).findAll() != null) {
            List<Engineer> listEngineer = (List<Engineer>) get(EngineerRepository.class).findAll();
            request.setAttribute("listEngineers", listEngineer);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/view/engineersTable.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException("Exception in TableEngineerServlet.doGet " + e);
        }
    }
}
