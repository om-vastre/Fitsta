package com.fitsta.fitsta.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Plans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String Name;
    private String Type;
    private String Features;
    private Integer Price;
    private Integer Duration;

    @ManyToOne
    private Trainer planstrainer;

    // @OneToMany
    // private PlansPurchase plansPurchasedplans;

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

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getFeatures() {
        return Features;
    }

    public void setFeatures(String features) {
        Features = features;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public Integer getDuration() {
        return Duration;
    }

    public void setDuration(Integer duration) {
        Duration = duration;
    }

    public Trainer getPlanstrainer() {
        return planstrainer;
    }

    public void setPlanstrainer(Trainer planstrainer) {
        this.planstrainer = planstrainer;
    }

    public Plans() {
    }

    public Plans(Integer id, String name, String type, String features, Integer price, Integer duration,
            Trainer planstrainer) {
        Id = id;
        Name = name;
        Type = type;
        Features = features;
        Price = price;
        Duration = duration;
        this.planstrainer = planstrainer;
    }
    
}