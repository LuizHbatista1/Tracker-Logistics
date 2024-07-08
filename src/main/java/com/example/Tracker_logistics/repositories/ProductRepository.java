package com.example.Tracker_logistics.repositories;

import com.example.Tracker_logistics.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findProductById(Long id);
    @Query("SELECT p FROM Product p WHERE p.receiver.id = :receiverId")
    List<Product> findProductsByReceiverId(@Param("receiverId") Long receiverId);

}
