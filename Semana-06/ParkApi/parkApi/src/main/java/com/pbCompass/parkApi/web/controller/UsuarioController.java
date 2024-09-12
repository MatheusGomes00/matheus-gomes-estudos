package com.pbCompass.parkApi.web.controller;


import com.pbCompass.parkApi.entity.Usuario;
import com.pbCompass.parkApi.service.UsuarioService;
import com.pbCompass.parkApi.web.dto.UsuarioCreateDto;
import com.pbCompass.parkApi.web.dto.UsuarioResponseDto;
import com.pbCompass.parkApi.web.dto.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> create(@RequestBody UsuarioCreateDto createDto){
        Usuario newUser = usuarioService.salvar(UsuarioMapper.toUsuario(createDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(newUser));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Long id){
        Usuario newUser = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(newUser);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Usuario> updatePassword(@PathVariable Long id, @RequestBody Usuario usuario){
        Usuario newUser = usuarioService.editarSenha(id, usuario.getPassword());
        return ResponseEntity.ok(newUser);
    }

    @GetMapping()
    public ResponseEntity<List<Usuario>> getAll(){
        List<Usuario> users = usuarioService.buscarTodos();
        return ResponseEntity.ok(users);
    }
}
