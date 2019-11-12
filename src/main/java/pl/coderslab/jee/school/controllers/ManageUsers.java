package pl.coderslab.jee.school.controllers;

import pl.coderslab.jee.school.dao.UserDao;
import pl.coderslab.jee.school.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/manageUsers")
public class ManageUsers extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;charset=utf-8");

        List<User> allUsers = UserDao.findAll();

        req.setAttribute("allUsers", allUsers);

        getServletContext().getRequestDispatcher("/WEB-INF/views/manageUsers.jsp").forward(req, resp);

    }
}
