package ru.itis.jdbc.web;

import ru.itis.jdbc.factory.ServiceFactory;
import ru.itis.jdbc.model.User;
import ru.itis.jdbc.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class UsersServlet extends HttpServlet {

    private UserService service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.service = ServiceFactory.getInstance().getUserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) {
            req.setAttribute("users", service.getAll());
            req.getRequestDispatcher("users.jsp").forward(req, resp);

        } else if ("delete".equals(action)) {
            int id = getId(req);
            service.delete(id);
            resp.sendRedirect("users");

        } else if ("create".equals(action) || "update".equals(action)) {
            User user = new User("", 0, "");
            if ("update".equals(action))
                user = service.getUser(getId(req));
            req.setAttribute("user", user);
            req.getRequestDispatcher("edit_user.jsp").forward(req, resp);
        }
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String city = req.getParameter("city");
        if (id.isEmpty()|| Integer.parseInt(id) == 0){
            service.addUser(new User(name, Integer.parseInt(age),city));
        }
        else {
            service.update(new User(Integer.parseInt(id),name,Integer.parseInt(age),city));
        }
        resp.sendRedirect("users");
    }
}
