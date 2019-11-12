package pl.coderslab.jee.school.controllers;

import pl.coderslab.jee.school.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteUser")
public class DeleteUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userIdParam = req.getParameter("id");

        Integer userId = Integer.parseInt(userIdParam);

        UserDao.delete(userId);

        resp.sendRedirect("/manageUsers");
    }
}
