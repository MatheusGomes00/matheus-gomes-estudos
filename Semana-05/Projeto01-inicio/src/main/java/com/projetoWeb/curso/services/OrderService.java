package com.projetoWeb.curso.services;

import com.projetoWeb.curso.model.entities.Order;
import com.projetoWeb.curso.model.entities.User;
import com.projetoWeb.curso.repositories.OrderRepository;
import com.projetoWeb.curso.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> obj = orderRepository.findById(id);
        return obj.get();
    }
}
