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

@WebServlet("/testDB")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> allUsers = UserDao.findAll();
        for(User user : allUsers) {
            resp.getWriter().println(user.getUsername());
        }
    }
}
