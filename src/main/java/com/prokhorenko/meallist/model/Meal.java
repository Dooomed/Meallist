package com.prokhorenko.meallist.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "meal")
@NoArgsConstructor
@AllArgsConstructor
public class Meal {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "weight")
    @NonNull
    private int weight;

    @Column(name = "price")
    @NonNull
    private BigDecimal price;

    @Column
    @Enumerated(EnumType.STRING)
    @NonNull
    private MealType mealType;

    public Meal(String name, int weight, BigDecimal price, MealType mealType) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.mealType = mealType;
    }
    
    public Meal() {
    	
    }

}
