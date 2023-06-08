package demo.trainecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.trainecommerce.entities.Product;

@Repository

public interface ProductRepository extends JpaRepository<Product, Integer>{

    Product findByCodeProduct(String code);
    boolean existsByCodeProduct(String code);
    
}
