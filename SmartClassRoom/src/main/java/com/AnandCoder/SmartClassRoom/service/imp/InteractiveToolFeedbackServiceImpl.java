package com.AnandCoder.SmartClassRoom.service.imp;



import com.AnandCoder.SmartClassRoom.Model.InteractiveToolFeedback;

import com.AnandCoder.SmartClassRoom.repository.InteractiveToolFeedbackRepository;
import com.AnandCoder.SmartClassRoom.service.InteractiveToolFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class InteractiveToolFeedbackServiceImpl implements InteractiveToolFeedbackService {

    @Autowired
    private InteractiveToolFeedbackRepository feedbackRepository;

    @Override
    public InteractiveToolFeedback addFeedback(InteractiveToolFeedback feedback) {
        // Set the feedback time to the current time when adding feedback
        feedback.setFeedback(feedback.getFeedback());
        feedback.setEngagementScore(feedback.getEngagementScore());
        feedback.setStudent(feedback.getStudent());
        feedback.setToolName(feedback.getToolName());
        feedback.setFeedbackTime(LocalDateTime.now());

        // Save the new feedback to the database
        return feedbackRepository.save(feedback);
    }

    @Override
    public InteractiveToolFeedback getFeedbackById(Long id) {
        // Retrieve feedback by its ID
        Optional<InteractiveToolFeedback> feedbackOpt = feedbackRepository.findById(id);
        return feedbackOpt.orElse(null);
    }

    @Override
    public List<InteractiveToolFeedback> getFeedbackByStudent(Long studentId) {
        // Retrieve feedback for a specific student by their ID
        return feedbackRepository.findByStudentId(studentId);
    }

    @Override
    public List<InteractiveToolFeedback> getFeedbackByTool(String toolName) {
        // Retrieve feedback for a specific interactive tool by its name
        return feedbackRepository.findByToolName(toolName);
    }

    @Override
    public List<InteractiveToolFeedback> getAllFeedback() {
        // Retrieve all feedback records
        return feedbackRepository.findAll();
    }

    @Override
    public List<InteractiveToolFeedback> getFeedbackByEngagementScore(int minScore) {
        // Retrieve feedback with an engagement score equal to or greater than the specified minimum
        return feedbackRepository.findByEngagementScoreGreaterThanEqual(minScore);
    }

    @Override
    public void updateFeedback(Long id, InteractiveToolFeedback feedback) {
        // Update the existing feedback
        Optional<InteractiveToolFeedback> existingFeedbackOpt = feedbackRepository.findById(id);
        if (existingFeedbackOpt.isPresent()) {
            InteractiveToolFeedback existingFeedback = existingFeedbackOpt.get();
            // Update the fields of the existing feedback
            existingFeedback.setToolName(feedback.getToolName());
            existingFeedback.setStudent(feedback.getStudent());
            existingFeedback.setEngagementScore(feedback.getEngagementScore());
            existingFeedback.setFeedback(feedback.getFeedback());
            existingFeedback.setFeedbackTime(LocalDateTime.now()); // Update feedback time to current time
            // Save the updated feedback
            feedbackRepository.save(existingFeedback);
        }
    }
}
