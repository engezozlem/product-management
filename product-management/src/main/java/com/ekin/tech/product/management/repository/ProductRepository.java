package com.ekin.tech.product.management.repository;

import com.ekin.tech.product.management.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> getByProductName(String productName);

}
