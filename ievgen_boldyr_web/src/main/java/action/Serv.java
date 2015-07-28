package action;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by george on 06.07.15.
 */
@WebServlet("/serv")
public class Serv extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest reg, HttpServletResponse resp){
        try {
            resp.getWriter().println("<h2>Java Serv</h2>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
