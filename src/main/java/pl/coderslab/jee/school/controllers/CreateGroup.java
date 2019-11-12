package pl.coderslab.jee.school.controllers;

import pl.coderslab.jee.school.dao.UserGroupDao;
import pl.coderslab.jee.school.model.UserGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createGroup")
public class CreateGroup extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;charset=utf-8");

        getServletContext().getRequestDispatcher("/WEB-INF/views/createGroup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain/charset=utf-8");

        String groupName = req.getParameter("groupName");

        UserGroup newGroup = new UserGroup(groupName);

        UserGroupDao.save(newGroup);

        resp.sendRedirect("/manageGroups");
    }
}
