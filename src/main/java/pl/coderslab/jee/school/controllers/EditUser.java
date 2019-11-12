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

@WebServlet("/editUser")
public class EditUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userIdParam = req.getParameter("id");

        Integer userId = Integer.parseInt(userIdParam);

        User user = UserDao.findById(userId);

        List<UserGroup> allGroups = UserGroupDao.findAll();

        req.setAttribute("allGroups", allGroups);

        req.setAttribute("user", user);

        getServletContext().getRequestDispatcher("/WEB-INF/views/editUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain/charset=utf-8");

        String userIdParam = req.getParameter("userId");
        String newUsername = req.getParameter("username");
        String newEmail = req.getParameter("email");
        String newPassword = req.getParameter("password");
        String groupIdParam = req.getParameter("groupId");

        Integer userId = Integer.parseInt(userIdParam);
        Integer groupId = Integer.parseInt(groupIdParam);

        User user = new User(userId, newUsername, newEmail, newPassword, groupId);

        UserDao.update(user);

        resp.sendRedirect("/manageUsers");
    }
}
