package services;

import module.Feedback;
import utils.Baseconnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackService implements InterfaceFeedbackService { //abstraction

    
    private static final int WORD_LIMIT = 20;

    

 // Add Feedback with word limit validation
    public boolean addFeedback(Feedback feedback) throws IllegalArgumentException {
        if (feedback == null || feedback.getContent() == null) {
            throw new IllegalArgumentException("Feedback or content cannot be null.");
        }

        int wordCount = feedback.getContent().trim().split("\\s+").length;
        if (wordCount > WORD_LIMIT) {
            throw new IllegalArgumentException("Content exceeds the word limit of " + WORD_LIMIT + ". Word count: " + wordCount);
        }

        String sql = "INSERT INTO feedbacks (student_id, content, reviewed, type) VALUES (?, ?, false, ?)";
        try (        
        	Connection  conn = Baseconnect.getInstance().getConnection();
        	PreparedStatement ps = conn.prepareStatement(sql)) {
            System.out.println("Adding feedback with SID = " + feedback.getStudentId());
            ps.setInt(1, feedback.getStudentId());
            ps.setString(2, feedback.getContent());
            ps.setString(3, feedback.getType());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error in addFeedback:");
            e.printStackTrace();
            return false;
        }}

    // Get feedbacks (unreviewed or all, based on need)
    public List<Feedback> getUnreviewedFeedbacks(int student_id, String type) {
        List<Feedback> list = new ArrayList<>();
        String sql = "SELECT * FROM feedbacks WHERE student_id = ? AND type = ?";  // remove AND reviewed = false if not used

        try (
        	Connection  conn = Baseconnect.getInstance().getConnection();
        	PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, student_id);
            stmt.setString(2, type);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Feedback fb = new Feedback();
                fb.setId(rs.getInt("id"));
                fb.setStudentId(rs.getInt("student_id"));
                fb.setType(rs.getString("type"));
                fb.setContent(rs.getString("content"));
                fb.setReviewed(rs.getBoolean("reviewed"));
                list.add(fb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Update Feedback
    public boolean updateFeedback(Feedback fb) {
        String sql = "UPDATE feedbacks SET content = ?, type = ? WHERE id = ?";
        try (
        	Connection  conn = Baseconnect.getInstance().getConnection();
        	PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, fb.getContent());
            ps.setString(2, fb.getType());
            ps.setInt(3, fb.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete Feedback
    public boolean deleteFeedback(int id) {
        String sql = "DELETE FROM feedbacks WHERE id = ?";
        try (
        	Connection  conn = Baseconnect.getInstance().getConnection();
        	PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Get Feedback by ID
    public Feedback getFeedbackById(int id) {
        Feedback fb = null;
        String sql = "SELECT * FROM feedbacks WHERE id = ?";
        try (
        	Connection  conn = Baseconnect.getInstance().getConnection();
        	PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                fb = new Feedback();
                fb.setId(rs.getInt("id"));
                fb.setStudentId(rs.getInt("student_id"));
                fb.setContent(rs.getString("content"));
                fb.setType(rs.getString("type"));
                fb.setReviewed(rs.getBoolean("reviewed"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fb;
    }
    
}


