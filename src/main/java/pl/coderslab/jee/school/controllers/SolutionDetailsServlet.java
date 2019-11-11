package pl.coderslab.jee.school.controllers;

import pl.coderslab.jee.school.dao.SolutionDao;
import pl.coderslab.jee.school.model.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/solutionDetails")
public class SolutionDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;charset=utf-8");

        String solutionIdParam = req.getParameter("id");

        Integer solutionId = Integer.parseInt(solutionIdParam);

        Solution solution = SolutionDao.findById(solutionId);

        req.setAttribute("solutionDetails", solution);

        getServletContext().getRequestDispatcher("/WEB-INF/views/solutionDetails.jsp").forward(req, resp);
    }
}
