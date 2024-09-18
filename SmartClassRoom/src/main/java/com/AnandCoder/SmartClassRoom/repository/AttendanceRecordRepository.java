package com.AnandCoder.SmartClassRoom.repository;

import com.AnandCoder.SmartClassRoom.Model.AttendanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRecordRepository extends JpaRepository<AttendanceRecord,Long> {

    List<AttendanceRecord> findByStudentId(Long studentId); // Custom method to find records by student ID

    List<AttendanceRecord> findByDate(LocalDate date); // Custom method to find records by date

    List<AttendanceRecord> findByClassIdAndDate(Long classId, LocalDate date); // Custom method to find records by class ID and date


}
