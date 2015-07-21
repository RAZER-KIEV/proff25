package action;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ivan on 06.07.15.
 */
@WebServlet("/serv")
public class Serv extends HttpServlet {
    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response) {
        try {
            response.getWriter().println("<h2>Hello!</h2>");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
