package servlet;

import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserPageServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user != null){
            req.setAttribute("user", user);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/user.jsp");
            dispatcher.forward(req, resp);
        } else {
            resp.sendRedirect("/index.jsp");
        }
    }
}
