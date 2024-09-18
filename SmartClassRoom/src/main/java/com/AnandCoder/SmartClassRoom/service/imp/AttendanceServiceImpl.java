package com.AnandCoder.SmartClassRoom.service.imp;

import com.AnandCoder.SmartClassRoom.Model.AttendanceRecord;
import com.AnandCoder.SmartClassRoom.Model.User;
import com.AnandCoder.SmartClassRoom.repository.AttendanceRecordRepository;
import com.AnandCoder.SmartClassRoom.repository.UserRepository;
import com.AnandCoder.SmartClassRoom.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRecordRepository attendanceRecordRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public AttendanceRecord recordAttendance(Long studentId,Long classId) {
        // Find the student by their ID
        Optional<User> studentOpt = userRepository.findById(studentId);
        if (studentOpt.isPresent()) {
            User student = studentOpt.get();
            // Create a new attendance record
            AttendanceRecord attendanceRecord = new AttendanceRecord();
            attendanceRecord.setStudent(student);
            attendanceRecord.setClassId(classId);
            attendanceRecord.setCheckInTime(LocalDateTime.now());
            attendanceRecord.setDate(LocalDate.now());
            // Save the attendance record to the database
            return attendanceRecordRepository.save(attendanceRecord);
        }
        return null; // Return null if student is not found
    }

    @Override
    public AttendanceRecord getAttendanceRecordById(Long id) {
        // Retrieve an attendance record by its ID
        Optional<AttendanceRecord> attendanceRecordOpt = attendanceRecordRepository.findById(id);
        return attendanceRecordOpt.orElse(null); // Return the attendance record or null if not found
    }

    @Override
    public List<AttendanceRecord> getAttendanceByStudent(Long studentId) {
        // Retrieve attendance records for a specific student
        return attendanceRecordRepository.findByStudentId(studentId);
    }

    @Override
    public List<AttendanceRecord> getAttendanceByDate(LocalDate date) {
        // Retrieve attendance records for a specific date
        return attendanceRecordRepository.findByDate(date);
    }

    @Override
    public void updateCheckOutTime(Long recordId) {
        // Retrieve the attendance record by its ID
        Optional<AttendanceRecord> attendanceRecordOpt = attendanceRecordRepository.findById(recordId);
        if (attendanceRecordOpt.isPresent()) {
            AttendanceRecord attendanceRecord = attendanceRecordOpt.get();
            // Update the check-out time
            attendanceRecord.setCheckOutTime(LocalDateTime.now());
            // Save the updated attendance record
            attendanceRecordRepository.save(attendanceRecord);
        }
    }

    @Override
    public List<AttendanceRecord> getAllAttendanceRecords() {
        // Retrieve all attendance records from the database
        return attendanceRecordRepository.findAll();
    }

    @Override
    public List<AttendanceRecord> getAttendanceForClass(Long classId, LocalDate date) {
        // Retrieve attendance records for a specific class and date
        return attendanceRecordRepository.findByClassIdAndDate(classId, date);
    }
}
