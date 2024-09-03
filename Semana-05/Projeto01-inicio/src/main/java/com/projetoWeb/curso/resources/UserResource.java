package com.projetoWeb.curso.resources;

import com.projetoWeb.curso.model.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User user = new User(1L, "Pedro", "pedro@teste.com", "888888888", "12345");
        return ResponseEntity.ok().body(user);
    }

}
