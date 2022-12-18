package com.tutrit.stoservice.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class InputCommandServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String inputCommand = req.getParameter("input");

        PrintWriter writer = resp.getWriter();
        try {
            writer.println("<h2>" + "Ну здравствуй" + "<h2>");
        } finally {
            writer.close();
        }
    }
}
