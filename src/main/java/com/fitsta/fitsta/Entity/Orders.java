package com.fitsta.fitsta.Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private Date OrderDate;
    private Integer TotalAmount;

    @ManyToOne
    private User orderUser;

    @ManyToOne
    private Product orderProduct;


    public Orders(Integer id, Date orderDate, Integer totalAmount, User orderUser, Product orderProduct) {
        Id = id;
        OrderDate = orderDate;
        TotalAmount = totalAmount;
        this.orderUser = orderUser;
        this.orderProduct = orderProduct;
    }

    public Orders() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date orderDate) {
        OrderDate = orderDate;
    }

    public Integer getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        TotalAmount = totalAmount;
    }

    public User getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(User orderUser) {
        this.orderUser = orderUser;
    }

    public Product getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(Product orderProduct) {
        this.orderProduct = orderProduct;
    }
    
    
}

