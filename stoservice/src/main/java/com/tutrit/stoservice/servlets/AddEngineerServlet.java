package com.tutrit.stoservice.servlets;

import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.context.ApplicationContext;
import com.tutrit.stoservice.context.ApplicationContextLoader;
import com.tutrit.stoservice.repository.EngineerRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddEngineerServlet", value = "add-engineer")
public class AddEngineerServlet extends HttpServlet {
    static {
        ApplicationContextLoader.run();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/create/add-engineer.jsp");
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

            var engineerInRepo = ApplicationContext.get(EngineerRepository.class).save(engineer);
            response.setContentType("text/html");
            PrintWriter writer;
            try {
                writer = response.getWriter();
            } catch (IOException e) {
                throw new RuntimeException("Exception in AddEngineerServlet.doPost " + e);
            }
            writer.println(engineerInRepo + " saved in repository");
            writer.println("<br");
            writer.println("<p><button onclick=\"location.href='/all-engineer'\">View list of engineers</button></p><br>");
            writer.println("<p><button onclick=\"location.href='/index.html'\">Back to main</button></p>");
            session.invalidate();
        }   else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException|IOException e) {
                throw new RuntimeException("Exception in AddEngineerServlet.doPost " + e);
            }
        }
    }
}
