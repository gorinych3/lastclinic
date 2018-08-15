package ru.egor.webClinic.servlets;

import ru.egor.webClinic.servlets.store.UserCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;


public class UserDeleteServlet extends HttpServlet {

    final AtomicInteger ids = new AtomicInteger();
    private static final UserCache USER_CACHE = UserCache.getINSTANCE();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        USER_CACHE.delete(Integer.valueOf(req.getParameter("id")));
        resp.sendRedirect(String.format("%s%s",req.getContextPath(),"/user/view"));
    }
}
