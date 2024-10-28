package com.pb.chellangeThree.msUser.web.dto;

import com.pb.chellangeThree.msUser.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUserDto {

    private String username;

    private String email;

    private ResponseAddressDto address;
}
