package com.finalProject.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersDao extends JpaRepository<Orders, Integer> {

}
