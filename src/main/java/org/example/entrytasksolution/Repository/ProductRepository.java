package org.example.entrytasksolution.Repository;

import org.example.entrytasksolution.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
