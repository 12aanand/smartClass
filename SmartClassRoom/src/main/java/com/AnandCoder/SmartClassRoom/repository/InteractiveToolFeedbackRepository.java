package com.AnandCoder.SmartClassRoom.repository;

import com.AnandCoder.SmartClassRoom.Model.InteractiveToolFeedback;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InteractiveToolFeedbackRepository extends JpaRepository<InteractiveToolFeedback,Long> {

    List<InteractiveToolFeedback> findByStudentId(Long studentId);

    List<InteractiveToolFeedback> findByToolName(String toolName);

    List<InteractiveToolFeedback> findByEngagementScoreGreaterThanEqual(int minScore);

}
