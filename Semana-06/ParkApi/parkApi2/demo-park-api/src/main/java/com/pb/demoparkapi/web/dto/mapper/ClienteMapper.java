package com.pb.demoparkapi.web.dto.mapper;

import com.pb.demoparkapi.entity.Cliente;
import com.pb.demoparkapi.web.dto.ClienteCreateDto;
import com.pb.demoparkapi.web.dto.ClienteResponseDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor(access = AccessLevel.PRIVATE)  // não é necessário instanciar a classe, devido uso de métodos estaticos
public class ClienteMapper {

    public static Cliente toCliente(ClienteCreateDto dto){
        return new ModelMapper().map(dto, Cliente.class);
    }

    public static ClienteResponseDto toDto(Cliente cliente){
        return new ModelMapper().map(cliente, ClienteResponseDto.class);
    }
}
