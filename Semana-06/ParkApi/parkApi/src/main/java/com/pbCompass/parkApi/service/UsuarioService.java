package com.pbCompass.parkApi.service;

import com.pbCompass.parkApi.entity.Usuario;
import com.pbCompass.parkApi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional
    public Usuario editarSenha(Long id, String password) {
        Usuario user = buscarPorId(id);
        user.setPassword(password);  // o próprio hibernate salva na memória cash a alteração de senha e atualiza no banco após o retorno
        return user;
    }

    @Transactional(readOnly = true)
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }
}
