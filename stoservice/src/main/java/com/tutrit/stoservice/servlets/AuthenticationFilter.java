package com.tutrit.stoservice.servlets;

import com.tutrit.stoservice.service.InMemoryAuthenticationService;
import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

import static com.tutrit.stoservice.context.ApplicationContext.get;
import static java.util.Objects.nonNull;

public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        boolean loginInCookies = nonNull(getValue(req.getCookies(), "userLogin"));
        boolean passwordInCookies = nonNull(getValue(req.getCookies(), "userPassword"));

        HttpSession session = req.getSession();

        boolean isLogin = get(InMemoryAuthenticationService.class).login((String) session.getAttribute("login"),
                                                                         (String) session.getAttribute("password"));

        if (isLogin) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (loginInCookies && passwordInCookies) {
            Objects.requireNonNull(session).setAttribute("login", req.getParameter("login"));
            session.setAttribute("password", req.getParameter("password"));
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    private static Optional<String> getValue(Cookie[] cookies, String name) {
        if (cookies == null) {
            return Optional.empty();
        }
        return Arrays.stream(cookies)
                .filter(cookie -> cookie.getName().equals(name))
                .map(Cookie::getValue)
                .findFirst();
    }
}
