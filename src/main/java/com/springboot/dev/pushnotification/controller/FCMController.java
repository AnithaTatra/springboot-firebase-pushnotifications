package com.springboot.dev.pushnotification.controller;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.springboot.dev.pushnotification.model.Note;
import com.springboot.dev.pushnotification.service.FirebaseMessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

public class FCMController {

    @Autowired
    private final FirebaseMessagingService firebaseMessagingService;

    public FCMController(FirebaseMessagingService firebaseMessagingService){

        this.firebaseMessagingService = firebaseMessagingService;
    }
    @PostMapping("/send-notification")
    @ResponseBody
    public String sendNotification(@RequestBody Note note,
                                   @RequestParam String topic) throws FirebaseMessagingException {
        return firebaseMessagingService.sendNotification(note, topic);
    }
}
