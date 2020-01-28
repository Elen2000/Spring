package am.basic.web.controller;


import com.sun.net.httpserver.HttpsExchange;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthentivationFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession ses = request.getSession();
        if(ses.getAttribute("user")==null){
            response.sendRedirect("/index.jsp");
        }
        else
        {
            filterChain.doFilter(request,servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
