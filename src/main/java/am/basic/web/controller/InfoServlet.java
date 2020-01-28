package am.basic.web.controller;

import am.basic.web.model.User;
import am.basic.web.repository.UserRepositor;
import am.basic.web.repository.UserRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "InfoServlet")
public class InfoServlet extends HttpServlet {

    UserRepositor userRepositor = new UserRepositoryImpl();
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies=request.getCookies();
        for(Cookie cookie:cookies)
        {
            System.out.println(cookie.getName()+"  "+cookie.getValue());
        }
        HttpSession ses = request.getSession();
        User user = (User) ses.getAttribute("user");
        PrintWriter printWriter = response.getWriter();
        printWriter.println( "<html>" +"<bode>"+ "<H1> <Ii>");
        printWriter.println("name = " + user.getName());
        printWriter.println("password"+user.getPassword());
   printWriter.println("<i>"+"</H1>"+"</body>"+"</HTML>");

    }

}
