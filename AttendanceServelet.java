import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class AttendanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("studentId");
        String course = request.getParameter("course");
        String attendanceDate = request.getParameter("attendanceDate");
        String status = request.getParameter("status");

        // JDBC code to store attendance data
        String url = "jdbc:mysql://localhost:3306/attendance";
        String username = "root";
        String password = "password";

        try (Connection con = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO attendance (student_id, course, attendance_date, status) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, studentId);
            stmt.setString(2, course);
            stmt.setString(3, attendanceDate);
            stmt.setString(4, status);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Redirect to success page
        response.sendRedirect("attendance-success.jsp");
    }
}
