package com.tutrit.stoservice.servlets;

import com.tutrit.stoservice.context.ApplicationContext;
import com.tutrit.stoservice.controller.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InputCommandServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contextPath = req.getContextPath();
        String inputCommand = req.getParameter("input");

        RequestDispatcher dispatcher = ApplicationContext.get(RequestDispatcher.class);
        dispatcher.doDispatch(inputCommand);

        req.setAttribute("output", dispatcher.getResp());
        req.getRequestDispatcher(contextPath).forward(req, resp);
    }
}
