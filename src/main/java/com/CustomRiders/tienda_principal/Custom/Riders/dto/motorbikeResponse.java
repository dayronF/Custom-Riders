package com.CustomRiders.tienda_principal.Custom.Riders.dto;

import lombok.Data;

@Data
public class motorbikeResponse {
    
    private long id;
    
    private String brand;
   
    private String model;
    
    private Integer cc;
   
    private Integer price;
    
    private Integer quantity;
}
