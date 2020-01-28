package am.basic.web.controller;

import am.basic.web.model.User;
import am.basic.web.repository.UserRepositor;
import am.basic.web.repository.UserRepositoryImpl;
import am.basic.web.repository.UserRepositoryImplJdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "StartServlet")
public class StartServlet extends HttpServlet {

    UserRepositor userRepositor = new UserRepositoryImpl();
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getCookies() == null) {
            response.sendRedirect("/index.jsp");
            return;
        }
        String username = null;
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("username")) {
                username = cookie.getValue();
            }
        }
        if (username == null) {
            response.sendRedirect("/index.jsp");
        }else{

            UserRepositor userRepositor =new UserRepositoryImplJdbc();
            try {
                User user = userRepositor.getByUsername(username);
                request.getSession().setAttribute("user",user);
                response.sendRedirect("/secure/home.html");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }


}
