package action;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by GFalcon on 07.07.15.
 */
@WebServlet("/serv")
public class Serv extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().println("<html>" +
                "<body>" +
                "<h2>HelloServlet</h2>" +
                "</body>" +
                "</html>");
    }
}
