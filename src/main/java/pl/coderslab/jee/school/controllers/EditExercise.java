package pl.coderslab.jee.school.controllers;

import pl.coderslab.jee.school.dao.ExerciseDao;
import pl.coderslab.jee.school.model.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editExercise")
public class EditExercise extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String exerciseIdParam = req.getParameter("id");

        Integer exerciseId = Integer.parseInt(exerciseIdParam);

        Exercise exercise = ExerciseDao.findById(exerciseId);

        req.setAttribute("exercise", exercise);

        getServletContext().getRequestDispatcher("/WEB-INF/views/editExercise.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain/charset=utf-8");

        String exerciseIdParam = req.getParameter("id");
        String title = req.getParameter("title");
        String description = req.getParameter("description");

        Integer exerciseId = Integer.parseInt(exerciseIdParam);

        Exercise exercise = new Exercise(exerciseId, title, description);

        ExerciseDao.update(exercise);

        resp.sendRedirect("/manageExercises");
    }
}
