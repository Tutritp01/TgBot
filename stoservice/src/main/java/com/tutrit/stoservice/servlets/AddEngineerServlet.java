package com.tutrit.stoservice.servlets;

import com.tutrit.stoservice.context.ApplicationContextLoader;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AddEngineerServlet", value = "/add-engineer")
public class AddEngineerServlet extends HttpServlet {
    static {
        ApplicationContextLoader.run();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/create/add-engineer.jsp");
        requestDispatcher.forward(request, response);
    }
}
