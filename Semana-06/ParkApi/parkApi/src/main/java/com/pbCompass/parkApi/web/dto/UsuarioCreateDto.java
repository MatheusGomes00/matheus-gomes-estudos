package com.pbCompass.parkApi.web.dto;

import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsuarioCreateDto implements Serializable {

    private String username;

    private String password;
}
