package pl.coderslab.jee.school.controllers;

import pl.coderslab.jee.school.dao.ExerciseDao;
import pl.coderslab.jee.school.model.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/manageExercises")
public class ManageExercises extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;charset=utf-8");

        List<Exercise> allExercises = ExerciseDao.findAll();

        req.setAttribute("allExercises", allExercises);

        getServletContext().getRequestDispatcher("/WEB-INF/views/manageExercises.jsp").forward(req, resp);

    }
}
