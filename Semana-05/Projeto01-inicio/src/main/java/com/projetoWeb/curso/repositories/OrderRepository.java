package com.projetoWeb.curso.repositories;

import com.projetoWeb.curso.model.entities.Order;
import com.projetoWeb.curso.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
