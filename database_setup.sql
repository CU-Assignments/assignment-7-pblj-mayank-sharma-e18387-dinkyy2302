CREATE TABLE attendance (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id VARCHAR(100),
    course VARCHAR(100),
    attendance_date DATE,
    status VARCHAR(10)
);
