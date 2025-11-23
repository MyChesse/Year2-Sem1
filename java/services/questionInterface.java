package services;

import java.util.ArrayList;

import module.marks;

public interface questionInterface {
	
	 public marks addQuestion(marks mrk);
	 public ArrayList<marks> getAllQuestions();
	 public void updateMarks(marks mrk);
	 public void deleteMarks (marks mrk);
	 

}
