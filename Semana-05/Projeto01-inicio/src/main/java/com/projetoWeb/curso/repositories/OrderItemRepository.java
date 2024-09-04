package com.projetoWeb.curso.repositories;

import com.projetoWeb.curso.model.entities.OrderItem;
import com.projetoWeb.curso.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
