package com.projetoWeb.curso.repositories;

import com.projetoWeb.curso.model.entities.Category;
import com.projetoWeb.curso.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
