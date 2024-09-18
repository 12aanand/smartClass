package com.AnandCoder.SmartClassRoom.controller;
import com.AnandCoder.SmartClassRoom.Model.InteractiveToolFeedback;
import com.AnandCoder.SmartClassRoom.service.InteractiveToolFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class InteractiveToolFeedbackController {

    @Autowired
    private InteractiveToolFeedbackService feedbackService;

    // API to add new feedback
    @PostMapping
    public ResponseEntity<InteractiveToolFeedback> addFeedback(@RequestBody InteractiveToolFeedback feedback) {
        InteractiveToolFeedback createdFeedback = feedbackService.addFeedback(feedback);
        return new ResponseEntity<>(createdFeedback, HttpStatus.CREATED);
    }

    // API to get feedback by ID
    @GetMapping("/{id}")
    public ResponseEntity<InteractiveToolFeedback> getFeedbackById(@PathVariable Long id) {
        InteractiveToolFeedback feedback = feedbackService.getFeedbackById(id);
        return feedback != null ? new ResponseEntity<>(feedback, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // API to get feedback by student ID
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<InteractiveToolFeedback>> getFeedbackByStudent(@PathVariable Long studentId) {
        List<InteractiveToolFeedback> feedbackList = feedbackService.getFeedbackByStudent(studentId);
        return new ResponseEntity<>(feedbackList, HttpStatus.OK);
    }

    // API to get feedback by tool name
    @GetMapping("/tool/{toolName}")
    public ResponseEntity<List<InteractiveToolFeedback>> getFeedbackByTool(@PathVariable String toolName) {
        List<InteractiveToolFeedback> feedbackList = feedbackService.getFeedbackByTool(toolName);
        return new ResponseEntity<>(feedbackList, HttpStatus.OK);
    }

    // API to get all feedback
    @GetMapping("/all")
    public ResponseEntity<List<InteractiveToolFeedback>> getAllFeedback() {
        List<InteractiveToolFeedback> feedbackList = feedbackService.getAllFeedback();
        return new ResponseEntity<>(feedbackList, HttpStatus.OK);
    }

    // API to get feedback by engagement score
    @GetMapping("/engagement/{minScore}")
    public ResponseEntity<List<InteractiveToolFeedback>> getFeedbackByEngagementScore(@PathVariable int minScore) {
        List<InteractiveToolFeedback> feedbackList = feedbackService.getFeedbackByEngagementScore(minScore);
        return new ResponseEntity<>(feedbackList, HttpStatus.OK);
    }

    // API to update existing feedback
    @PutMapping("/{id}")
    public ResponseEntity<InteractiveToolFeedback> updateFeedback(@PathVariable Long id, @RequestBody InteractiveToolFeedback feedback) {
        feedbackService.updateFeedback(id, feedback);
        return new ResponseEntity<>(feedback, HttpStatus.OK);
    }
}
