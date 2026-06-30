package com.tejait.notifcation_service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@AllArgsConstructor
@RestController
@RequestMapping("notification")
public class NotificationController {

    NotificationRepository repository;

    @PostMapping("sendNotification")
    public ResponseEntity<Notification> sendNotification(@RequestParam String message){

        Notification notification = new Notification();
        notification.setMessage((message));
        notification.setSentAt(LocalDateTime.now());

        return new ResponseEntity<>(repository.save(notification), HttpStatus.OK);
    }
}
