package pl.coderslab.jee.school.controllers;

import pl.coderslab.jee.school.dao.ExerciseDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteExercise")
public class DeleteExercise extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String exerciseIdParam = req.getParameter("id");

        Integer exerciseId = Integer.parseInt(exerciseIdParam);

        ExerciseDao.delete(exerciseId);

        resp.sendRedirect("/manageExercises");
    }
}
