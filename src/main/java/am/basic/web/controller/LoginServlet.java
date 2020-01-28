package am.basic.web.controller;

import am.basic.web.repository.UserRepositor;
import am.basic.web.repository.UserRepositoryImpl;
import am.basic.web.repository.UserRepositoryImplJdbc;
import am.basic.web.model.User;

import javax.security.sasl.SaslException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {


    UserRepositor userRepositor = new UserRepositoryImpl();


    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, SaslException {
        HttpSession ses=  request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("pass");
        try {
            User user = userRepositor.getByUsername(username);
            if (user!=null) {
                Cookie cookie=new Cookie("username",user.getUsername());
                cookie.setMaxAge(56498794);
                response.addCookie(cookie);
                ses.setAttribute("user",user);
                response.sendRedirect("/secure/home.html");
            } else {
//                PrintWriter printWriter = response.getWriter();
//                printWriter.print("login or password is incorrect");
                request.setAttribute("abcd","brat logind kam parold sxal es hishum hle mi hatel porci");
                request.getRequestDispatcher("/index.jsp").forward(request,response);
            }
        } catch (SQLException | ServletException e) {
            e.printStackTrace();
        }

    }

}
