package com.ptit.Hirex.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.ptit.Hirex.dtos.*;
import com.ptit.Hirex.entity.*;
import com.ptit.Hirex.service.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("${api.prefix}/notifications")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class NotificationController {
    private final NotificationService notificationService;
    private final ModelMapper modelMapper;

    @GetMapping("")
    ResponseEntity<?> getNotifications(@AuthenticationPrincipal User currentUser) {
        List<NotificationReceiver> notifications = notificationService.getMyNotifications(currentUser.getId());
        List<NotificationReceiverDTO> notificationDTOs = notifications.stream()
                .map(notification -> modelMapper.map(notification, NotificationReceiverDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(notificationDTOs);
    }

}
