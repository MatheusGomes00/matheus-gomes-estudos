package com.pbCompass.parkApi.repository;

import com.pbCompass.parkApi.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
