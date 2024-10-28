package com.pb.chellangeThree.msUser.service;


import com.pb.chellangeThree.msUser.entity.User;
import com.pb.chellangeThree.msUser.exception.EntityNotFoundException;
import com.pb.chellangeThree.msUser.exception.PasswordViolationException;
import com.pb.chellangeThree.msUser.exception.UserUniqueViolationException;
import com.pb.chellangeThree.msUser.repository.UserRepository;
import com.pb.chellangeThree.msUser.web.dto.ResponseUserDto;
import com.pb.chellangeThree.msUser.web.dto.UpdateUserDto;
import com.pb.chellangeThree.msUser.web.dto.UserDto;
import com.pb.chellangeThree.msUser.web.dto.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public ResponseUserDto createUser(UserDto userDto) {
        Optional<User> verifyUser = userRepository.findByUsername(userDto.getUsername());
        if(verifyUser.isEmpty()){
            User user = UserMapper.toUser(userDto);
            userRepository.save(user);
            return UserMapper.toDto(user);
        } else {
            throw new UserUniqueViolationException(String.format("Username '%s' already registered!", userDto.getUsername()));
        }
    }

    public void updatePassword(UpdateUserDto userDto) {
        String username = userDto.getUsername();
        String oldPassword = userDto.getOldPassword();
        String newPassword = userDto.getNewPassword();

        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()){
            throw new EntityNotFoundException(String.format("Username '%s' not founded!", username));
        }

        User userToUpdate = user.get();

        if (userToUpdate.getPassword().equals(oldPassword)) {
            userToUpdate.setPassword(newPassword);
            userRepository.save(userToUpdate);
        } else {
            throw new PasswordViolationException("Old password doesn't match!");
        }
    }
}
