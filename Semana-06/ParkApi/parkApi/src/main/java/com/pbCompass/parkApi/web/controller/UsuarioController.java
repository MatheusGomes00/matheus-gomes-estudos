package com.pbCompass.parkApi.web.controller;


import com.pbCompass.parkApi.entity.Usuario;
import com.pbCompass.parkApi.service.UsuarioService;
import com.pbCompass.parkApi.web.dto.UsuarioCreateDto;
import com.pbCompass.parkApi.web.dto.UsuarioResponseDto;
import com.pbCompass.parkApi.web.dto.UsuarioSenhaDto;
import com.pbCompass.parkApi.web.dto.mapper.UsuarioMapper;
import com.pbCompass.parkApi.web.exception.ErrorMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name= "Usuarios", description = "Contém todoas as operações relativas aos recursos para cadastro, edição e leitura de um usuario.")  // documentação do recurso a ser trabalhado
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Operation(summary = "Criar um novo usuário", description = "Recurso para criar um novo usuário",
        responses = {
            @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UsuarioResponseDto.class))),
                @ApiResponse(responseCode = "409", description = "Usuário  e-mail já cadastrado no sistema",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                        @ApiResponse(responseCode = "422", description = "Recurso não processado por dados de entrada invalidos",
                                content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
        }
    )
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
    public ResponseEntity<Void> updatePassword(@PathVariable Long id, @Valid @RequestBody UsuarioSenhaDto senhaDto){
        Usuario newUser = usuarioService.editarSenha(id, senhaDto.getSenhaAtual(), senhaDto.getNovaSenha(), senhaDto.getConfirmaSenha());
        return ResponseEntity.noContent().build();  // status code 204
    }

    @GetMapping()
    public ResponseEntity<List<UsuarioResponseDto>> getAll(){
        List<Usuario> users = usuarioService.buscarTodos();
        return ResponseEntity.ok(UsuarioMapper.toListDto(users));
    }
}
