package com.pb.atS7.SpringApi.controller;

import com.pb.atS7.SpringApi.dto.UserEntryDto;
import com.pb.atS7.SpringApi.dto.UserEntryResponseDto;
import com.pb.atS7.SpringApi.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor  // para a injeção de dependencia
@RestController
@RequestMapping("/api/v1")
public class UserController {

    // injeção de dependencia
    private final UserService userService;

    @PostMapping("/verify")
    public ResponseEntity<UserEntryResponseDto> tryAccess(@RequestBody @Valid UserEntryDto dto){
        UserEntryResponseDto response = userService.verifyAge(dto);
        return ResponseEntity.ok().body(response);
    }
}
