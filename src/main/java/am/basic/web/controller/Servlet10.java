package am.basic.web.controller;

import am.basic.web.repository.UserRepositor;
import am.basic.web.repository.UserRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet10")
public class Servlet10 extends HttpServlet {

    UserRepositor userRepositor = new UserRepositoryImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         response.sendRedirect("/pages/home.html");

        }
    }

