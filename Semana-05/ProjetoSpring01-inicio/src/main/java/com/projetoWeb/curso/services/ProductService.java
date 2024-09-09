package com.projetoWeb.curso.services;

import com.projetoWeb.curso.model.entities.Product;
import com.projetoWeb.curso.model.entities.User;
import com.projetoWeb.curso.repositories.ProductRepository;
import com.projetoWeb.curso.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> obj = productRepository.findById(id);
        return obj.get();
    }
}
