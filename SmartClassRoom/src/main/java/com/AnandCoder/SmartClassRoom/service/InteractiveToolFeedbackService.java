package com.AnandCoder.SmartClassRoom.service;

import com.AnandCoder.SmartClassRoom.Model.InteractiveToolFeedback;

import java.util.List;

public interface InteractiveToolFeedbackService {
    InteractiveToolFeedback addFeedback(InteractiveToolFeedback feedback); // Add new feedback

    InteractiveToolFeedback getFeedbackById(Long id); // Retrieve feedback by ID

    List<InteractiveToolFeedback> getFeedbackByStudent(Long studentId); // Retrieve feedback for a specific student

    List<InteractiveToolFeedback> getFeedbackByTool(String toolName); // Retrieve feedback for a specific tool

    List<InteractiveToolFeedback> getAllFeedback(); // Retrieve all feedback

    List<InteractiveToolFeedback> getFeedbackByEngagementScore(int minScore); // Retrieve feedback with a minimum engagement score

    void updateFeedback(Long id, InteractiveToolFeedback feedback); // Update existing feedback
}

