package com.pbCompass.parkApi.service;

import com.pbCompass.parkApi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor  // inicia a injeção de dependencia via construtor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
}
