package GKservices;

import java.util.List;

import Gkmodel.GKAnswer;
import Gkmodel.GKExam;

public interface GKService {
	
	void addExam(GKExam exam);
	List<GKExam> getAllExams();
	GKExam getExams(GKExam exam);
	void updateExam(GKExam exam);
	void deleteExam(int id);
	void addAnswers(GKAnswer answer);
	List<GKAnswer> getAllAnswers();

}
