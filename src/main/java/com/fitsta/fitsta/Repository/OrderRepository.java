package com.fitsta.fitsta.Repository;

import org.springframework.data.repository.CrudRepository;

import com.fitsta.fitsta.Entity.Orders;

public interface OrderRepository extends CrudRepository<Orders, Integer>{
    
}
