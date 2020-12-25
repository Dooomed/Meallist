package com.prokhorenko.meallist.model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "tableNumber")
    @NonNull
    private int tableNumber;

    @OneToMany(cascade = CascadeType.ALL)
    @NonNull
    private List<Meal> mealList;

    public Order(){

    }

    public Order(int tableNumber, List<Meal> mealMap) {
        this.tableNumber = tableNumber;
        this.mealList = mealMap;
    }

}
