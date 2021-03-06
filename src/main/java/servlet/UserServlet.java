package servlet;

import model.User;
import service.Service;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/*")
public class UserServlet extends HttpServlet {
     private final Service service = Service.getInstance();

    public UserServlet() throws IOException {
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> userList = service.findAllUsers();

        req.setAttribute("userList", userList);
        RequestDispatcher dispatcher = req.getRequestDispatcher(req.getContextPath()+"/listusers.jsp");
        dispatcher.forward(req, resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        int age = 0;
        try {
            age = Integer.parseInt(req.getParameter("age"));
        } catch (NumberFormatException ignored){}
        String pass = req.getParameter("password");
        String role = req.getParameter("role");
        User user = new User(name, pass, age, role);
        if (name != null || pass != null || age == 0 || role != null){
            try {
                service.saveUser(user);
            } catch (Exception ignored) {}
            resp.sendRedirect(req.getContextPath()+"add");
        }
    }
}
