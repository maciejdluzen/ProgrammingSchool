package pl.coderslab.jee.school.controllers;

import pl.coderslab.jee.school.dao.UserGroupDao;
import pl.coderslab.jee.school.model.UserGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/manageGroups")
public class ManageGroups extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;charset=utf-8");

        List<UserGroup> allGroups = UserGroupDao.findAll();

        req.setAttribute("allGroups", allGroups);

        getServletContext().getRequestDispatcher("/WEB-INF/views/manageGroups.jsp").forward(req, resp);
    }
}
