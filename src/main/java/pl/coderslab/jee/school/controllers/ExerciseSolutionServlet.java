package pl.coderslab.jee.school.controllers;

import pl.coderslab.jee.school.dao.SolutionDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/exerciseSolution")
public class ExerciseSolutionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idParam = req.getParameter("id");

        Integer id = Integer.parseInt(idParam);

        resp.getWriter().println(SolutionDao.loadById(id));

    }
}
