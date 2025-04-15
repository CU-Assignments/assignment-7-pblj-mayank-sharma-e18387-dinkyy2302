import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class EmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empId = request.getParameter("empId");

        // JDBC code to fetch employee data
        String url = "jdbc:mysql://localhost:3306/employees";
        String username = "root";
        String password = "password";
        List<Employee> employeeList = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM employees WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, empId);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Employee emp = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getString("email")
                );
                employeeList.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Set the employee list as a request attribute and forward to a JSP page
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employeeList.jsp");
        dispatcher.forward(request, response);
    }
}
