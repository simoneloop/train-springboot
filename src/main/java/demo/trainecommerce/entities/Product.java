package demo.trainecommerce.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name= "product")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private long id;
    
    @Column(name= "name_product",nullable = false)
    private String nameProduct;

    @Column(name= "code_product",nullable = false,unique = true)
    private String codeProduct;

    @Column(name="price",nullable = false)
    private double price;

    @Column(name="quantity",nullable= false)
    private int quantity;

    public String toString(){
        return "\nProdotto: "+nameProduct+"\nCodice: "+codeProduct
        +"\nPrezzo: "+price+"\nQuantità: "+quantity;
    }

}
