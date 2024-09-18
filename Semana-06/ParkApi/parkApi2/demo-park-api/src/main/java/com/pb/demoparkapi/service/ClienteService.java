package com.pb.demoparkapi.service;


import com.pb.demoparkapi.entity.Cliente;
import com.pb.demoparkapi.exception.CpfUniqueViolationException;
import com.pb.demoparkapi.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Transactional
    public Cliente salvar(Cliente cliente){
        try{
            return clienteRepository.save(cliente);
        } catch (DataIntegrityViolationException e){
            throw new CpfUniqueViolationException(String.format("CPF '%s' já cadastrado no sistema.", cliente.getCpf()));
        }

    }

}
