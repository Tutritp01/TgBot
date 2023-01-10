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

import static com.tutrit.stoservice.context.ApplicationContext.get;

@WebServlet(name = "EngineerCard", value = "engineerCard")
public class EngineerCardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        var engineer = get(EngineerRepository.class).findById(id);
        if (engineer != null) request.setAttribute("engineer", engineer);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/view/engineerCard.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException("Exception in EngineerCardServlet.doGet " + e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        var engineer = new Engineer();
        engineer.setId(request.getParameter("id"));
        engineer.setFirstName(request.getParameter("firstName"));
        engineer.setLastName(request.getParameter("lastName"));
        engineer.setFunction(request.getParameter("function"));
        engineer.setCategory(request.getParameter("category"));
        engineer.setEducation(request.getParameter("education"));
        engineer.setExperience(Integer.parseInt(request.getParameter("experience")));
        engineer.setGeneralExperience(Integer.parseInt(request.getParameter("generalExperience")));

        get(EngineerRepository.class).update(engineer);
        try {
            response.sendRedirect("/all-engineers");
        } catch (IOException e) {
            throw new RuntimeException("Exception in EngineerCardServlet.doPost " + e);
        }
    }
}
