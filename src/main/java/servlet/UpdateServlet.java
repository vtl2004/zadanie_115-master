package servlet;
import model.User;
import service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet{
    private final Service service = Service.getInstance();

    public UpdateServlet() throws IOException {
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String pass = req.getParameter("password");
        int age = Integer.parseInt(req.getParameter("age"));
        String role = req.getParameter("role");
        User user = null;
        try {
            user = service.findUser(id);
            user .setName(name);
            user .setPassword(pass);
            user.setAge(age);
            user .setRole(role);
            service.updateUser(user);
        } catch (Exception ignored) {}
        resp.sendRedirect("/admin");
    }
}
