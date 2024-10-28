package com.pb.chellangeThree.msUser.service;


import com.pb.chellangeThree.msUser.entity.Address;
import com.pb.chellangeThree.msUser.entity.User;
import com.pb.chellangeThree.msUser.exception.EntityNotFoundException;
import com.pb.chellangeThree.msUser.exception.PasswordViolationException;
import com.pb.chellangeThree.msUser.exception.UserUniqueViolationException;
import com.pb.chellangeThree.msUser.feign.FeignClientSource;
import com.pb.chellangeThree.msUser.repository.UserRepository;
import com.pb.chellangeThree.msUser.web.dto.*;
import com.pb.chellangeThree.msUser.web.dto.mapper.AddressMapper;
import com.pb.chellangeThree.msUser.web.dto.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final FeignClientSource feignClientSource;

    @Transactional
    public ResponseUserDto createUser(UserDto userDto) {
        Optional<User> verifyUser = userRepository.findByUsername(userDto.getUsername());
        if(verifyUser.isEmpty()){
            User user = UserMapper.toUser(userDto);

            AddressDto addressDto = feignClientSource.findAddressByCep(userDto.getCep());
            Address address = AddressMapper.toAddress(addressDto);

            user.setAddress(address);
            userRepository.save(user);

            ResponseUserDto userResponse = UserMapper.toDto(user);
            ResponseAddressDto responseAddressDto = convertResponse(addressDto);
            userResponse.setAddress(responseAddressDto);
            return userResponse;
        } else {
            throw new UserUniqueViolationException(String.format("Username '%s' already registered!", userDto.getUsername()));
        }
    }

    public ResponseAddressDto convertResponse(AddressDto addressDto) {
        ResponseAddressDto responseAddress = new ResponseAddressDto();
        responseAddress.setZipCode(addressDto.getCep());
        responseAddress.setStreet(addressDto.getLogradouro());
        responseAddress.setDistrict(addressDto.getBairro());
        responseAddress.setCity(addressDto.getLocalidade());
        responseAddress.setState(addressDto.getUf());
        return responseAddress;
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
