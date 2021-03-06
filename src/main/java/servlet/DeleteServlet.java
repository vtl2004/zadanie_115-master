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

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{
    private final Service service = Service.getInstance();

    public DeleteServlet() throws IOException {
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        User user = null;
        try {
            user = service.findUser(id);
            service.deleteUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/admin");
    }
}
