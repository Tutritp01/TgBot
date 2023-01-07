package com.tutrit.stoservice.servlets;

import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.repository.EngineerRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import static com.tutrit.stoservice.context.ApplicationContext.get;

@WebServlet(name = "AddEngineerServlet", value = "/add-engineer")
public class EngineerFormServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/view/engineerForm.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException|IOException e) {
            throw new RuntimeException("Exception in AddEngineerServlet.doGet " + e);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        var engineer = new Engineer();
        HttpSession session = request.getSession();

        if (!session.isNew()) {
            engineer.setFirstName(request.getParameter("firstName"));
            engineer.setLastName(request.getParameter("lastName"));
            engineer.setFunction(request.getParameter("function"));
            engineer.setCategory(request.getParameter("category"));
            engineer.setEducation(request.getParameter("education"));
            engineer.setExperience(Integer.parseInt(request.getParameter("experience")));
            engineer.setGeneralExperience(Integer.parseInt(request.getParameter("generalExperience")));

            get(EngineerRepository.class).save(engineer);
            session.invalidate();
            try {
                response.sendRedirect("/all-engineers");
            } catch (IOException e) {
                throw new RuntimeException("Exception in AddEngineerServlet.doPost " + e);
            }
        }   else {
            try {
                response.sendRedirect("/");
            } catch (IOException e) {
                throw new RuntimeException("Exception in AddEngineerServlet.doPost " + e);
            }
        }
    }
}
