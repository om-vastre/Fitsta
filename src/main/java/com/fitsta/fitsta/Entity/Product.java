package com.fitsta.fitsta.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String Name;
    private String Image1;
    private String Image2;
    private String Description;
    private String ProductPrice;

    
    public Product(Integer id, String name, String image1, String image2, String desc, String price) {
        Id = id;
        Name = name;
        Image1 = image1;
        Image2 = image2;
        Description = desc;
        ProductPrice = price;
    }

    public Product() {
    }
    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getImage1() {
        return Image1;
    }
    public void setImage1(String image1) {
        Image1 = image1;
    }
    public String getImage2() {
        return Image2;
    }
    public void setImage2(String image2) {
        Image2 = image2;
    }
    public String getDescription() {
        return Description;
    }
    public void setDescription(String desc) {
        Description = desc;
    }
    public String getProductPrice() {
        return ProductPrice;
    }
    public void setProductPrice(String price) {
        ProductPrice = price;
    }


}
