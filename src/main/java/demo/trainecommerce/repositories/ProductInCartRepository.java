package demo.trainecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.trainecommerce.entities.ProductInCart;

@Repository

public interface ProductInCartRepository extends JpaRepository<ProductInCart, Integer>{
    
}
