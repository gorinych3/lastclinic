package ru.egor.webClinic.servlets;

import org.codehaus.jackson.map.ObjectMapper;
import ru.egor.connection.UserDaoImpl;
import ru.egor.pojo.User;
import ru.egor.webClinic.servlets.form.UserForm;
import ru.egor.webClinic.servlets.store.UserCache;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class CreateUserJsonServlet extends HttpServlet {

    private final UserCache USER_CACHE = UserCache.getINSTANCE();
    private UserDaoImpl userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "application/json; charset=utf-8");
        final ServletOutputStream out = resp.getOutputStream();
        out.print(new ObjectMapper().writeValueAsString(USER_CACHE.values()));
        out.flush();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "application/json; charset=utf-8");
        final UserForm form = new ObjectMapper().readValue(req.getInputStream(), UserForm.class);
        try {
            userDao.addUser(new User(form.getLogin(), "0000"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.getOutputStream().write("{'result' : 'true'}".getBytes());
    }
}
