package servlet;

import com.google.gson.Gson;
import model.User;
import service.Service;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.*;


@WebFilter("/admin/*")
public class FilterUser implements Filter {
    private final Service service = Service.getInstance();


    public FilterUser() throws IOException {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        User user = (User) request.getSession().getAttribute("user");
        if (user != null){
              switch (user.getRole()){
                case "admin":
                    filterChain.doFilter(request, response);
                    break;
                case "user":

                    response.sendRedirect("/user");
                    break;
                default:

                    response.sendRedirect("/index.jsp");
            }
        } else {
            response.sendRedirect("/index.jsp");
        }
    }
    @Override
    public void destroy() {}
}
