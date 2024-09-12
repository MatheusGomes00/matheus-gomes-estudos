package com.pbCompass.parkApi.web.controller;


import com.pbCompass.parkApi.entity.Usuario;
import com.pbCompass.parkApi.service.UsuarioService;
import com.pbCompass.parkApi.web.dto.UsuarioCreateDto;
import com.pbCompass.parkApi.web.dto.UsuarioResponseDto;
import com.pbCompass.parkApi.web.dto.UsuarioSenhaDto;
import com.pbCompass.parkApi.web.dto.mapper.UsuarioMapper;
import jakarta.validation.Valid;
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
    public ResponseEntity<UsuarioResponseDto> create(@Valid @RequestBody UsuarioCreateDto createDto){
        Usuario newUser = usuarioService.salvar(UsuarioMapper.toUsuario(createDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(newUser));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> getById(@PathVariable Long id){
        Usuario newUser = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(UsuarioMapper.toDto(newUser));  // status code 200
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePassword(@PathVariable Long id, @RequestBody UsuarioSenhaDto senhaDto){
        Usuario newUser = usuarioService.editarSenha(id, senhaDto.getSenhaAtual(), senhaDto.getNovaSenha(), senhaDto.getConfirmaSenha());
        return ResponseEntity.noContent().build();  // status code 204
    }

    @GetMapping()
    public ResponseEntity<List<UsuarioResponseDto>> getAll(){
        List<Usuario> users = usuarioService.buscarTodos();
        return ResponseEntity.ok(UsuarioMapper.toListDto(users));
    }
}
