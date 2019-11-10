package pl.coderslab.jee.school.controllers;

import pl.coderslab.jee.school.dao.SolutionDao;
import pl.coderslab.jee.school.model.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class HomePageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int solutionsCount = Integer.parseInt(getServletContext().getInitParameter("number-solutions"));

       List<Solution> solutions = SolutionDao.findAll(solutionsCount);
       req.setAttribute("solutions", solutions);
       getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);

    }
}
