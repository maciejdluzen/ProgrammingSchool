package pl.coderslab.jee.school.controllers;

import pl.coderslab.jee.school.dao.SolutionDao;
import pl.coderslab.jee.school.dao.UserDao;
import pl.coderslab.jee.school.model.Solution;
import pl.coderslab.jee.school.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userDetails")
public class UserDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;charset=utf-8");

        String userIdParam = req.getParameter("id");

        Integer userID = Integer.parseInt(userIdParam);

        User user = UserDao.findById(userID);

        List<Solution> userSolutions = SolutionDao.findAllByUserId(userID);

        req.setAttribute("userDetails", user);
        req.setAttribute("userSolutions", userSolutions);

        getServletContext().getRequestDispatcher("/WEB-INF/views/userDetails.jsp").forward(req, resp);
    }
}
