package com.CustomRiders.tienda_principal.Custom.Riders.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.CustomRiders.tienda_principal.Custom.Riders.dto.motorbikeRequest;
import com.CustomRiders.tienda_principal.Custom.Riders.dto.motorbikeResponse;

import com.CustomRiders.tienda_principal.Custom.Riders.service.motorbikeService;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/motorbikes")
public class MotorbikeController {

    private final motorbikeService motorbikeService;

    public MotorbikeController(motorbikeService motorbikeService) {
        this.motorbikeService = motorbikeService;
    }

    @GetMapping
    public ResponseEntity<List<motorbikeResponse>> getMotorbikeEntity() {
        try {
            List<motorbikeResponse> responsives = motorbikeService.getMotorbikeEntity();

            return ResponseEntity.status(HttpStatus.OK).body(responsives);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<motorbikeResponse> createMoto(@RequestBody motorbikeRequest request) {

        try {
            motorbikeResponse response = motorbikeService.createMoto(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMoto(@PathVariable Long id) {
        try {
            motorbikeService.deleteMoto(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/by-brand")
    public ResponseEntity<List<String>> getQuantityByBrand() {
        try {
            List<String> response = motorbikeService.getQuantityByBrand();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}