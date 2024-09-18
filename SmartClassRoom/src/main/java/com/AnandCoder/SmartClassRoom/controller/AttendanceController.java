package com.AnandCoder.SmartClassRoom.controller;


import com.AnandCoder.SmartClassRoom.Model.AttendanceRecord;
import com.AnandCoder.SmartClassRoom.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping("/record")
    public ResponseEntity<AttendanceRecord> recordAttendance(
            @RequestParam Long studentId,
            @RequestParam Long classId) {
        AttendanceRecord attendanceRecord = attendanceService.recordAttendance(studentId, classId);
        if (attendanceRecord != null) {
            return new ResponseEntity<>(attendanceRecord, HttpStatus.CREATED);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // API to get an attendance record by ID
    @GetMapping("/{id}")
    public ResponseEntity<AttendanceRecord> getAttendanceRecordById(@PathVariable Long id) {
        AttendanceRecord attendanceRecord = attendanceService.getAttendanceRecordById(id);
        return attendanceRecord != null ? new ResponseEntity<>(attendanceRecord, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // API to get attendance records for a specific student
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<AttendanceRecord>> getAttendanceByStudent(@PathVariable Long studentId) {
        List<AttendanceRecord> attendanceRecords = attendanceService.getAttendanceByStudent(studentId);
        return new ResponseEntity<>(attendanceRecords, HttpStatus.OK);
    }

    // API to get attendance records for a specific date
    @GetMapping("/date/{date}")
    public ResponseEntity<List<AttendanceRecord>> getAttendanceByDate(@PathVariable LocalDate date) {
        List<AttendanceRecord> attendanceRecords = attendanceService.getAttendanceByDate(date);
        return new ResponseEntity<>(attendanceRecords, HttpStatus.OK);
    }

    // API to update the check-out time for a specific attendance record
    @PutMapping("/update-checkout/{recordId}")
    public ResponseEntity<Void> updateCheckOutTime(@PathVariable Long recordId) {
        attendanceService.updateCheckOutTime(recordId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // API to get all attendance records
    @GetMapping("/all")
    public ResponseEntity<List<AttendanceRecord>> getAllAttendanceRecords() {
        List<AttendanceRecord> attendanceRecords = attendanceService.getAllAttendanceRecords();
        return new ResponseEntity<>(attendanceRecords, HttpStatus.OK);
    }

    // API to get attendance for a specific class and date
    @GetMapping("class/{classId}/date/{date}")
    public ResponseEntity<List<AttendanceRecord>> getAttendanceForClass(@PathVariable Long classId, @PathVariable LocalDate date) {
        List<AttendanceRecord> attendanceRecords = attendanceService.getAttendanceForClass(classId, date);
        return new ResponseEntity<>(attendanceRecords, HttpStatus.OK);
    }
}
