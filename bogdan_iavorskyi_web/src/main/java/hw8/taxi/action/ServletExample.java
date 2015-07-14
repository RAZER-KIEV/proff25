package hw8.taxi.action;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by bosyi on 06.07.15.
 */
@WebServlet("/serv")
public class ServletExample extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        try {
            res.getWriter().print("<h5>ddsds</h5>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
