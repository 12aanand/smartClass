package com.AnandCoder.SmartClassRoom.service;

import com.AnandCoder.SmartClassRoom.Model.AttendanceRecord;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceService {
    AttendanceRecord recordAttendance(Long studentId,Long classId); // Record attendance for a student

    AttendanceRecord getAttendanceRecordById(Long id); // Retrieve an attendance record by ID

    List<AttendanceRecord> getAttendanceByStudent(Long studentId); // Retrieve attendance records for a specific student

    List<AttendanceRecord> getAttendanceByDate(LocalDate date); // Retrieve attendance records for a specific date

    void updateCheckOutTime(Long recordId); // Update the check-out time for a specific attendance record

    List<AttendanceRecord> getAllAttendanceRecords(); // Retrieve all attendance records

    List<AttendanceRecord> getAttendanceForClass(Long classId, LocalDate date); // Retrieve attendance for a specific class and date

}
