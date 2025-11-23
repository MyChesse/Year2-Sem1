package services;

import module.Student;
import utils.Baseconnect;

import java.sql.*;

public class StudentService {

	public int registerStudent(Student student) {
	    int generatedId = -1;

	    String insertQuery = "INSERT INTO students (name, birthday, email, phone, password, sid) VALUES (?, ?, ?, ?, ?, ?)";

	    try (
	    	Connection  conn = Baseconnect.getInstance().getConnection();
	        PreparedStatement stmt = conn.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)){
	        		
	        stmt.setString(1, student.getName());
	        stmt.setString(2, student.getBirthday());
	        stmt.setString(3, student.getEmail());
	        stmt.setString(4, student.getPhone());
	        stmt.setString(5, student.getPassword());
	        stmt.setInt(6, 0); // temporary SID

	        stmt.executeUpdate();

	        ResultSet rs = stmt.getGeneratedKeys();
	        if (rs.next()) {
	            generatedId = rs.getInt(1);
	            int sid = generatedId + 1000;

	            PreparedStatement updateStmt = conn.prepareStatement("UPDATE students SET sid = ? WHERE id = ?");
	            updateStmt.setInt(1, sid);
	            updateStmt.setInt(2, generatedId);
	            updateStmt.executeUpdate();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return generatedId;
	}


    public Student login(int sid, String password) {
        Student student = null;
        try (Connection  conn = Baseconnect.getInstance().getConnection();) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM students WHERE sid = ? AND password = ?");
            stmt.setInt(1, sid);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setSid(rs.getInt("sid"));
                student.setName(rs.getString("name"));
                student.setBirthday(rs.getString("birthday"));
                student.setEmail(rs.getString("email"));
                student.setPhone(rs.getString("phone"));
                student.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return student;
    }

    // Get student by internal DB ID (not SID)
    public Student getStudentById(int id) throws ClassNotFoundException {
        String sql = "SELECT * FROM students WHERE id = ?";

        try (Connection  conn = Baseconnect.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Student student = new Student();
                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setBirthday(rs.getDate("birthday").toString());
                    student.setEmail(rs.getString("email"));
                    student.setPhone(rs.getString("phone"));
                    student.setPassword(rs.getString("password"));
                    return student;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Update student details (except SID)
    public boolean updateStudent(Student student) throws ClassNotFoundException {
        String sql = "UPDATE students SET name = ?, birthday = ?, email = ?, phone = ?, password = ? WHERE id = ?";
        System.out.println("Updating student ID: " + student.getId());

        try (Connection  conn = Baseconnect.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getName());
            stmt.setDate(2, Date.valueOf(student.getBirthday()));
            stmt.setString(3, student.getEmail());
            stmt.setString(4, student.getPhone());
            stmt.setString(5, student.getPassword());
            stmt.setInt(6, student.getId());

            int rows = stmt.executeUpdate();
            System.out.println("Rows affected: " + rows);

            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    
    

}
