package com.CustomRiders.tienda_principal.Custom.Riders.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "motorbike")
public class motorbikeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "cc")
    private Integer cc;

    @Column(name = "price")
    private Double price; // ✅ cambiado a Double

    @Column(name = "quantity")
    private Integer quantity;
}
