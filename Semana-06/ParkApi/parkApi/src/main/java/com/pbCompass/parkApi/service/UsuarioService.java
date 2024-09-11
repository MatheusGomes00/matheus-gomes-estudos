package com.pbCompass.parkApi.service;

import com.pbCompass.parkApi.entity.Usuario;
import com.pbCompass.parkApi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor  // inicia a injeção de dependencia via construtor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Transactional  // Inicia uma transação para garantir que o método seja executado de forma atômica
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)  // Indica que este método realiza apenas uma consulta, sem operações de escrita no banco
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado.")
        );
    }
}
