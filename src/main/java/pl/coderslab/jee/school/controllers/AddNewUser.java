package pl.coderslab.jee.school.controllers;

import pl.coderslab.jee.school.dao.UserDao;
import pl.coderslab.jee.school.dao.UserGroupDao;
import pl.coderslab.jee.school.model.User;
import pl.coderslab.jee.school.model.UserGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/addNewUser")
public class AddNewUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<UserGroup> allGroups = UserGroupDao.findAll();

        req.setAttribute("allGroups", allGroups);

        getServletContext().getRequestDispatcher("/WEB-INF/views/addNewUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain/charset=utf-8");

        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String groupIdParam = req.getParameter("groupId");

        Integer groupId = Integer.parseInt(groupIdParam);

        User newUser = new User(username, email, password, groupId);

        UserDao.save(newUser);

        resp.sendRedirect("/manageUsers");
    }
}
