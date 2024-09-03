package com.projetoWeb.curso.repositories;

import com.projetoWeb.curso.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
