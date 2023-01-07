package com.tutrit.stoservice.servlets;

import com.tutrit.stoservice.service.InMemoryAuthenticationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;

import static com.tutrit.stoservice.context.ApplicationContext.get;

public class LoginServlet extends HttpServlet {

    private static final String PATH = "/WEB-INF/view/login.jsp";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(PATH).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = String.valueOf(req.getParameter(LOGIN));
        String userPassword = String.valueOf(req.getParameter(PASSWORD));
        HttpSession session = req.getSession();

        if (get(InMemoryAuthenticationService.class).login(username, userPassword)) {
            session.setAttribute(LOGIN, username);
            session.setAttribute(PASSWORD, userPassword);

            resp.addCookie(new Cookie("userLogin", username));
            resp.addCookie(new Cookie("userPassword", userPassword));

            req.setAttribute("output", username);
            req.getRequestDispatcher("/WEB-INF/view/header.jsp").forward(req, resp);
        } else {
            String errorMessage = "Check your username or password";
            session.setAttribute("error", errorMessage);
            req.setAttribute("output", errorMessage);
            req.setAttribute(LOGIN, username);
            doGet(req, resp);
        }
    }
}
