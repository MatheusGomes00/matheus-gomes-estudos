package com.pb.atS7.SpringApi.service;

import com.pb.atS7.SpringApi.dto.UserEntryDto;
import com.pb.atS7.SpringApi.dto.UserEntryResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Service
public class UserService {

    public UserEntryResponseDto verifyAge(UserEntryDto dto) {
        String name = dto.getName();
        int age = dto.getAge();
        if (age >= 18) {
            return new UserEntryResponseDto(name, "Entry Allowed");
        } else {
            return new UserEntryResponseDto(name, "Entry Denied");
        }
    }
}
