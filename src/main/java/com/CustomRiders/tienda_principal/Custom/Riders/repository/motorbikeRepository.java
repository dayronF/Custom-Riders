package com.CustomRiders.tienda_principal.Custom.Riders.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.CustomRiders.tienda_principal.Custom.Riders.entity.motorbikeEntity;

@Repository

public interface motorbikeRepository extends JpaRepository<motorbikeEntity, Long> {
    @Query("SELECT m.brand, SUM(m.quantity) FROM motorbikeEntity m GROUP BY m.brand")
    List<Object[]> findQuantityByBrand();
}
