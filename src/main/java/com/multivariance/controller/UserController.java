package com.multivariance.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.multivariance.service.UserService;

@RestController
@RequestMapping("user/flag")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

	@GetMapping("string-variation")
    public ResponseEntity<String> getFFStringVariation(@RequestParam String userEmail){
        return ResponseEntity.ok(userService.getFFStringValue(userEmail));
    }

    @GetMapping("json-variation")
    public ResponseEntity<String> getFFJsonVariation(@RequestParam String userEmail){
        return ResponseEntity.ok(userService.getFFJsonValue(userEmail).toString());
    }

    @GetMapping("number-variation")
    public ResponseEntity<String> getFFNumberVariation(@RequestParam String userEmail){
        return ResponseEntity.ok(String.valueOf(userService.getFFNumberValue(userEmail)));
    }

    @GetMapping("percentage-rollout")
    public ResponseEntity<Boolean> getFFBoolVariation(@RequestParam String userEmail){
        return ResponseEntity.ok(userService.getFFBooleanValue(userEmail));
    }
}
