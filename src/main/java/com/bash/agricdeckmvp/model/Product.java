package com.bash.agricdeckmvp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private BigDecimal price;
    private int stockQuantity;
    private String category;
    private double rating; // Corresponds to the "rating" field from the prompt
    private String imageUrls; // Stored as a JSONB string

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id", nullable = false)
    private Vendor vendor; // Link to the user who is a vendor

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
