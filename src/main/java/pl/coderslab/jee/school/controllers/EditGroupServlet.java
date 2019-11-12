package pl.coderslab.jee.school.controllers;

import pl.coderslab.jee.school.dao.UserGroupDao;
import pl.coderslab.jee.school.model.UserGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editGroup")
public class EditGroupServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String groupIdParam = req.getParameter("id");

        Integer groupId = Integer.parseInt(groupIdParam);

        UserGroup group = UserGroupDao.findById(groupId);

        req.setAttribute("group", group);

        getServletContext().getRequestDispatcher("/WEB-INF/views/editGroup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain/charset=utf-8");

        String newGroupName = req.getParameter("newGroupName");
        String groupId = req.getParameter("groupId");

        Integer id = Integer.parseInt(groupId);

        UserGroup editedGroup = new UserGroup(id, newGroupName);

        UserGroupDao.update(editedGroup);

        resp.sendRedirect("/manageGroups");

    }
}
