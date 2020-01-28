package am.basic.web.controller;

import am.basic.web.model.User;
import am.basic.web.repository.UserRepositor;
import am.basic.web.repository.UserRepositoryImpl;
import am.basic.web.repository.UserRepositoryImplJdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletRegiter")
public class ServletRegiter extends HttpServlet {


    UserRepositor userRepositor = new UserRepositoryImpl();
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("pass");
        int age = Integer.parseInt(request.getParameter("age"));

        UserRepositor userRepositor = new UserRepositoryImplJdbc();
        User user = new User();

            user.setAge(age);
            user.setUsername(username);
            user.setPassword(password);
        try {
            userRepositor.add(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

