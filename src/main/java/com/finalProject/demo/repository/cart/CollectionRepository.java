package com.finalProject.demo.repository.cart;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalProject.demo.model.entity.cart.Collection;

public interface CollectionRepository extends JpaRepository<Collection, Long> {

}
