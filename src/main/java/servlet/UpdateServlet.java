package servlet;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {
    private final UserService service = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        int id = Integer.parseInt(req.getParameter("id"));
        User user = service.getUserById(id);
        req.setAttribute("user",user);
        req.getRequestDispatcher("/WEB-INF/view/update.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("first_name");
        String surName = req.getParameter("last_name");

        if (service.validId(id) && name != null && surName != null){
            service.updateUser(id,name,surName);
            resp.setStatus(HttpServletResponse.SC_OK);
        }else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        resp.sendRedirect(req.getContextPath() + "/admin");

    }
}
