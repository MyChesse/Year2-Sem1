package services;

import java.sql.*;
import java.util.ArrayList;

import module.customer;
import module.marks;
import utils.Baseconnect;
import utils.dbconnect;


public class questionService implements questionInterface { //abstraction

	    public marks addQuestion(marks mrk) {
	        try {
	            Statement stmt = Baseconnect.getconnection().createStatement();
	            
	            String sql = "insert into answers(questionid, question1, question2, question3, question4, question5, marks) values(?,?,?,?,?,?,?)";
	            PreparedStatement pstmt = Baseconnect.getconnection().prepareStatement(sql);	 // Insert query
//	            String insert = "INSERT INTO answers(id,questionid, question1, question2, question3, question4, question5, marks) VALUES ('1,"
//	                    + mrk.getQuestionid() + "','" + mrk.getQuestion1() + "','" + mrk.getQuestion2() + "','" + mrk.getQuestion3() + "','" 
//	                    + mrk.getQuestion4() + "','" + mrk.getQuestion5() + "'," + mrk.getMarks() + ")";
//	            stmt.executeUpdate(insert);
	            //passing placeholders 
	            
	            pstmt.setString(1, mrk.getQuestionid());
	            pstmt.setString(2, mrk.getQuestion1());
	            pstmt.setString(3, mrk.getQuestion2());
	            pstmt.setString(4, mrk.getQuestion3());
	            pstmt.setString(5, mrk.getQuestion4());
	            pstmt.setString(6, mrk.getQuestion5());
	            pstmt.setString(7, mrk.getMarks());
	            
	            int res = pstmt.executeUpdate();

	            // Read back inserted row
	           String select = "SELECT * FROM answers WHERE questionid = '" + mrk.getQuestionid() + "'";
	            ResultSet rs = stmt.executeQuery(select);

	            if (rs.next()) {
	                mrk.setQuestionid(rs.getString("questionid"));
	                mrk.setQuestion1(rs.getString("question1"));
	                mrk.setQuestion2(rs.getString("question2"));
	                mrk.setQuestion3(rs.getString("question3"));
	                mrk.setQuestion4(rs.getString("question4"));
	                mrk.setQuestion5(rs.getString("question5"));
	                mrk.setMarks(rs.getString("marks"));
	                
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return mrk;
	    }

	  // Optional: Get all questions
	    
	    public ArrayList<marks> getAllQuestions() {
	        ArrayList<marks> listmrk = new ArrayList<>();
	        try {
	            Statement stmt = Baseconnect.getconnection().createStatement();
	            ResultSet rs = stmt.executeQuery("SELECT * FROM answers");

	            while (rs.next()) {
	                marks mrk = new marks();
	                mrk.setQuestionid(rs.getString("questionid"));
	                mrk.setQuestion1(rs.getString("question1"));
	                mrk.setQuestion2(rs.getString("question2"));
	                mrk.setQuestion3(rs.getString("question3"));
	                mrk.setQuestion4(rs.getString("question4"));
	                mrk.setQuestion5(rs.getString("question5"));
	                mrk.setMarks(rs.getString("marks"));
	                listmrk.add(mrk);
	            }
	            return listmrk;

	        } catch (Exception e) {
	            e.printStackTrace();
	        
	        return null;
	        }
	    }
	    
	    
	    
	    
	    
	    public void updateMarks(marks mrk) {
	    	try {
				String query = "Update answers Set marks ='"+mrk.getMarks()+"' where questionid='"+mrk.getQuestionid()+"' ";
				
				Statement statement = Baseconnect.getconnection().createStatement();
				statement.executeUpdate(query);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	    
	    public void deleteMarks (marks mrk) {
			try {
				String query = "Delete from answers where questionid = '"+mrk.getQuestionid()+"'";
				
				Statement statement =  Baseconnect.getconnection().createStatement(); //get the connection of db
				statement.executeUpdate(query);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	    
	    
	   
	}



