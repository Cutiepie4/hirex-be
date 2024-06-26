package com.ptit.Hirex.controller;

import com.ptit.Hirex.dtos.SchedulesDTO;
import com.ptit.Hirex.entity.Items;
import com.ptit.Hirex.entity.Schedule;
import com.ptit.Hirex.service.impl.ScheduleServiceImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("${api.prefix}")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ScheduleController {
    private final ScheduleServiceImpl scheduleServiceImpl;
    @GetMapping("/schedules")
    public List<Schedule> getAllSchedules() {
        try {
            return scheduleServiceImpl.getALlSchedules();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    @PostMapping("/schedules")
    public ResponseEntity<Schedule> createSchedule(@RequestBody SchedulesDTO schedulesDTO) {
        try {
            System.out.println(schedulesDTO);
            Schedule newSchedule = scheduleServiceImpl.createSchedule(schedulesDTO);
            return ResponseEntity.ok(newSchedule);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // Update an existing item
    @PutMapping("/schedules/{id}")
    public ResponseEntity<Items> updateSchedule(@PathVariable int id, @RequestBody SchedulesDTO schedulesDTO) {
        try {
            Items updatedSchedule = scheduleServiceImpl.updateSchedule(id, schedulesDTO);
            if (updatedSchedule != null) {
                return ResponseEntity.ok(updatedSchedule);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/schedules/{id}")
    public ResponseEntity<?> deleteSchedule(@PathVariable int id) {
        try {
            boolean isDeleted = scheduleServiceImpl.deleteSchedule(id);
            if (isDeleted) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
