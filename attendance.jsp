<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Attendance Portal</title>
</head>
<body>
    <h2>Submit Attendance</h2>
    <form action="AttendanceServlet" method="post">
        Student ID: <input type="text" name="studentId" required><br><br>
        Course: <input type="text" name="course" required><br><br>
        Attendance Date: <input type="date" name="attendanceDate" required><br><br>
        Status: <select name="status">
            <option value="Present">Present</option>
            <option value="Absent">Absent</option>
        </select><br><br>
        <input type="submit" value="Submit Attendance">
    </form>
</body>
</html>
