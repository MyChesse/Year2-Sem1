package services; //abstraction

import module.Feedback;
import java.util.List;

public interface InterfaceFeedbackService {
    boolean addFeedback(Feedback feedback) throws IllegalArgumentException;
    List<Feedback> getUnreviewedFeedbacks(int studentId, String type);
    boolean updateFeedback(Feedback feedback);
    boolean deleteFeedback(int id);
    Feedback getFeedbackById(int id);
}
