import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Static check (for simplicity, you can enhance this with database authentication)
        if ("admin".equals(username) && "password123".equals(password)) {
            // Redirect to welcome page if login is successful
            request.setAttribute("username", username);
            RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
            dispatcher.forward(request, response);
        } else {
            // Send error message if login fails
            response.getWriter().println("Invalid credentials, please try again.");
        }
    }
}
