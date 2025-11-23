package services;

import module.Timetable;
import utils.Baseconnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TimetableService {

	@SuppressWarnings("static-access")
	public boolean insertTimetable(Timetable t) {
	    boolean success = false;
	    try {
	        // Access the singleton instance of DBConnection
	        Connection conn = Baseconnect.getInstance().getConnection();

	        String sql = "INSERT INTO timetable (subject, day, start_time, end_time) VALUES (?, ?, ?, ?)";
	        PreparedStatement ps = conn.prepareStatement(sql);

	        ps.setString(1, t.getSubject());
	        ps.setString(2, t.getDay());
	        ps.setString(3, t.getStartTime());
	        ps.setString(4, t.getEndTime());

	        int rowsInserted = ps.executeUpdate();
	        success = (rowsInserted > 0);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return success;
	}
    

    public void deleteTimetable(int id) throws ClassNotFoundException {
        try (Connection conn = Baseconnect.getconnection()) {
            String sql = "DELETE FROM timetable WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Timetable> getAllTimetables() throws ClassNotFoundException {
        List<Timetable> timetables = new ArrayList<>();

        String sql = "SELECT * FROM timetable";

        try (Connection conn = Baseconnect.getconnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Timetable t = new Timetable(
                    rs.getInt("id"),              // Now fetching the 'id'
                    rs.getString("subject"),
                    rs.getString("day"),
                    rs.getString("start_time"),
                    rs.getString("end_time")
                );
                timetables.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return timetables;
    }

    public void updateTimetable(int id, String day, String startTime, String endTime) throws ClassNotFoundException {
        String sql = "UPDATE timetable SET day=?, start_time=?, end_time=? WHERE id=?";

        try (Connection conn = Baseconnect.getconnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, day);
            ps.setString(2, startTime);
            ps.setString(3, endTime);
            ps.setInt(4, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteTimetableBySubject(String subject) throws ClassNotFoundException {
        String sql = "DELETE FROM timetable WHERE subject=?";

        try (Connection conn = Baseconnect.getconnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, subject);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
