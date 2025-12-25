package com.example.fooddeliveryservice.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "restaurants")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private Double rating;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Dish> menu;

    @OneToMany(mappedBy = "restaurant")
    private List<Review> reviews;
}