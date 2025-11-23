package services;

import java.util.List;

import module.GKAnswer;
import module.GKExam;

public interface GKService {
	
	void addExam(GKExam exam);
	List<GKExam> getAllExams();
	GKExam getExams(GKExam exam);
	void updateExam(GKExam exam);
	void deleteExam(int id);
	void addAnswers(GKAnswer answer);
	List<GKAnswer> getAllAnswers();

}
