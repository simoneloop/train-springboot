package demo.trainecommerce.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "cart")

public class ProductInCart {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column (name = "id", nullable = false, unique =true)
    private long id;


    @Column (name = "quantityInCart")
    private int quantity;
    


    
}
