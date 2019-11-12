package pl.coderslab.jee.school.controllers;

import pl.coderslab.jee.school.dao.UserGroupDao;
import pl.coderslab.jee.school.model.UserGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteGroup")
public class DeleteGroupServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String groupIdParam = req.getParameter("id");

        Integer groupId = Integer.parseInt(groupIdParam);

        UserGroupDao.delete(groupId);

        resp.sendRedirect("/manageGroups");
    }
}
