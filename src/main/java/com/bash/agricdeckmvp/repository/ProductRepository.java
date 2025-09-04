package com.bash.agricdeckmvp.repository;

import com.bash.agricdeckmvp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByVendorId(long vendorId);
}
