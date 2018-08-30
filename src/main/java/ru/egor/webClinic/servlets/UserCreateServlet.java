package ru.egor.webClinic.servlets;

import ru.egor.clinic.se.User;
import ru.egor.webClinic.servlets.store.UserCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserCreateServlet extends HttpServlet {


    private final UserCache USER_CACHE = UserCache.getINSTANCE();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.USER_CACHE.add(new User(USER_CACHE.generateId(), req.getParameter("login"), req.getParameter("email")));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/user/view"));
    }
}
