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

@WebServlet("/usersFromAGroup")
public class ShowAllUsersFromAGroup extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;charset=utf-8");

        String groupIdParam = req.getParameter("id");

        Integer groupId = Integer.parseInt(groupIdParam);

        List<User> allUsers = UserDao.findAllByGroupId(groupId);

        UserGroup groupName = UserGroupDao.findById(groupId);

        req.setAttribute("allUsers", allUsers);
        req.setAttribute("groupName", groupName);

        getServletContext().getRequestDispatcher("/WEB-INF/views/users.jsp").forward(req, resp);
    }
}

// servlet działajacy