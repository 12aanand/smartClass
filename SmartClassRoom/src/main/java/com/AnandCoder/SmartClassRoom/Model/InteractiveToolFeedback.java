package com.AnandCoder.SmartClassRoom.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class InteractiveToolFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private User student;

    private String toolName;
    private String feedback;
    private int engagementScore;
    private LocalDateTime feedbackTime;

    public InteractiveToolFeedback()
    {

    }

    public InteractiveToolFeedback(Long id, User student, String toolName, String feedback, int engagementScore, LocalDateTime feedbackTime) {
        this.id = id;
        this.student = student;
        this.toolName = toolName;
        this.feedback = feedback;
        this.engagementScore = engagementScore;
        this.feedbackTime = feedbackTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getEngagementScore() {
        return engagementScore;
    }

    public void setEngagementScore(int engagementScore) {
        this.engagementScore = engagementScore;
    }

    public LocalDateTime getFeedbackTime() {
        return feedbackTime;
    }

    public void setFeedbackTime(LocalDateTime feedbackTime) {
        this.feedbackTime = feedbackTime;
    }
}

