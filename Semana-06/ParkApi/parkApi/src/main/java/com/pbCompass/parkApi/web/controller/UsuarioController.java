package com.pbCompass.parkApi.web.controller;


import com.pbCompass.parkApi.entity.Usuario;
import com.pbCompass.parkApi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
        Usuario newUser = usuarioService.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
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
}
