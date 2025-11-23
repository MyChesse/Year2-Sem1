/*package GKservices;

//import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Gkmodel.GKExam;

import Gkutil.GkDBconnect;
public class GKExamservice {
	
	public void exam(GKExam exam) {
		
		try {
			
			String query = "insert into exam values(0, '"+exam.getQuestionid()+"', '"+exam.getQuestion1()+"', '"+exam.getQuestion2()+"', '"+exam.getQuestion3()+"', '"+exam.getQuestion4()+"', '"+exam.getQuestion5()+"')";
			Statement statement = GkDBconnect.getConnection().createStatement();
			statement.executeUpdate(query);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<GKExam> getALLExam() {
	    

	    try {
	    	ArrayList<GKExam> listExam = new ArrayList<>();
	    	
	        String query = "select * from exam";
	        Statement statement = GkDBconnect.getConnection().createStatement();

	        ResultSet rs = statement.executeQuery(query);

	        while (rs.next()) {
	            GKExam exam = new GKExam(); // Create a new object for each record
	            exam.setQuestionid(rs.getString("questionid"));
	            exam.setQuestion1(rs.getString("question1"));
	            exam.setQuestion2(rs.getString("question2"));
	            exam.setQuestion3(rs.getString("question3"));
	            exam.setQuestion4(rs.getString("question4"));
	            exam.setQuestion5(rs.getString("question5"));

	            listExam.add(exam);
	        }
	        return listExam;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }

	    
	}	
} */

package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import module.GKAnswer;
import module.GKExam;
import module.GKLecture;
import utils.Baseconnect;

public class GKExamservice implements GKService{
	
	//login
	public boolean validate(GKLecture lecture) {
        boolean status = false;

        try {
            Connection conn = Baseconnect.getInstance().getConnection();
            String sql = "SELECT * FROM lecture WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, lecture.getUsername());
            stmt.setString(2, lecture.getPassword());

            ResultSet rs = stmt.executeQuery();
            status = rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // Insert a new exam record with validation
    public void addExam(GKExam exam) {

        try {

        	Connection conn = Baseconnect.getInstance().getConnection();
     	    String query = "INSERT INTO exam (questionid, question1, question2, question3, question4, question5) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query); 

            stmt.setString(1, exam.getQuestionid());
            stmt.setString(2, exam.getQuestion1());
            stmt.setString(3, exam.getQuestion2());
            stmt.setString(4, exam.getQuestion3());
            stmt.setString(5, exam.getQuestion4());
            stmt.setString(6, exam.getQuestion5());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Retrieve all exams
    public List<GKExam> getAllExams() {
    	
        List<GKExam> listExam = new ArrayList<>();

        try {
        	
        	Connection conn = Baseconnect.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM exam ORDER BY id DESC";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                GKExam exam = new GKExam();
                
                exam.setId(rs.getInt("id"));
                exam.setQuestionid(rs.getString("questionid"));
                exam.setQuestion1(rs.getString("question1"));
                exam.setQuestion2(rs.getString("question2"));
                exam.setQuestion3(rs.getString("question3"));
                exam.setQuestion4(rs.getString("question4"));
                exam.setQuestion5(rs.getString("question5"));

                listExam.add(exam);
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listExam;
        
    }
    
    // Retrieve exams for student
    public GKExam getExams(GKExam exam) {
        
        try {
        	
        	Connection conn = Baseconnect.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            String query = "SELECT question1, question2, question3, question4, question5 FROM exam ORDER BY id DESC";
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                
                exam.setQuestion1(rs.getString("question1"));
                exam.setQuestion2(rs.getString("question2"));
                exam.setQuestion3(rs.getString("question3"));
                exam.setQuestion4(rs.getString("question4"));
                exam.setQuestion5(rs.getString("question5"));

                return exam;
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        
    }
   
    //update exam
    public void updateExam(GKExam exam){
    	
    	try {
    		
    		Connection conn = Baseconnect.getInstance().getConnection();
        	String query = "UPDATE exam SET question1=?, question2=?, question3=?, question4=?, question5=? WHERE id=?";
        	PreparedStatement stmt = conn.prepareStatement(query);
        	
        	stmt.setString(1, exam.getQuestion1());
            stmt.setString(2, exam.getQuestion2());
            stmt.setString(3, exam.getQuestion3());
            stmt.setString(4, exam.getQuestion4());
            stmt.setString(5, exam.getQuestion5());
            stmt.setInt(6, exam.getId());
            
            stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
    }
    
    //delete exam
    public void deleteExam(int id) {
    	
        try {
            Connection conn = Baseconnect.getInstance().getConnection();
            String query = "DELETE FROM exam WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setInt(1, id);
            
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
 // Insert a new answers
    public void addAnswers(GKAnswer answer) {

        try {

        	Connection conn = Baseconnect.getInstance().getConnection();
     	    String query = "INSERT INTO answer (sid, answer1, answer2, answer3, answer4, answer5) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query); 

            stmt.setString(1, answer.getSid());
            stmt.setString(2, answer.getAnswer1());
            stmt.setString(3, answer.getAnswer2());
            stmt.setString(4, answer.getAnswer3());
            stmt.setString(5, answer.getAnswer4());
            stmt.setString(6, answer.getAnswer5());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Retrieve all answers
    public ArrayList<GKAnswer> getAllAnswers() {
        ArrayList<GKAnswer> listExam = new ArrayList<>();

        try {
        	
        	Connection conn = Baseconnect.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM answer ORDER BY id DESC";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
            	GKAnswer answer = new GKAnswer();
                
            	answer.setId(rs.getInt("id"));
            	answer.setSid(rs.getString("sid"));
            	answer.setAnswer1(rs.getString("answer1"));
            	answer.setAnswer2(rs.getString("answer2"));
            	answer.setAnswer3(rs.getString("answer3"));
            	answer.setAnswer4(rs.getString("answer4"));
            	answer.setAnswer5(rs.getString("answer5"));

                listExam.add(answer);
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listExam;
        
    }
}    
   
    


