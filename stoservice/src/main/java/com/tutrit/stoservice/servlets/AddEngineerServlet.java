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

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;

@WebServlet(name = "AddEngineerServlet", value = "/add-engineer")
public class AddEngineerServlet extends HttpServlet {
    static {
        ApplicationContextLoader.run();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/create/add-engineer.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException("Exception in AddEngineerServlet.doGet " + e);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        var engineer = new Engineer();
        String value;
        int valueInt;
        Class<? extends Engineer> engineerClass = engineer.getClass();
        Field[] fields = engineer.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                Field engineerField = engineerClass.getDeclaredField(field.getName());
                if (field.getName().equals("id")) continue;
                engineerField.setAccessible(true);
                if (field.getType().equals(String.class)) {
                    value = request.getParameter(field.getName());
                    engineerField.set(engineer, value);
                }
                if (isAnInt(field)) {
                    valueInt = Integer.parseInt(request.getParameter(field.getName()));
                    engineerField.setInt(engineer, valueInt);
                }
                engineerField.setAccessible(false);

            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Exception in AddEngineerServlet.doPost " + e);
            }
        }
        var engineerInRepo = ApplicationContext.get(EngineerRepository.class).save(engineer);
        response.setContentType("text/html");
        PrintWriter writer;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            throw new RuntimeException("Exception in AddEngineerServlet.doPost " + e);
        }
        writer.println(engineerInRepo + " saved in repository");
        writer.println("");
        writer.println("<p><button onclick=\"location.href='/index.html'\">Back to main</button></p>");
    }

    private static boolean isAnInt(Field field) {
        String name = field.getType().getName();
        return name.equals("int");
    }
}
