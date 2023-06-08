package demo.trainecommerce.services;

import java.util.List;

import org.springframework.stereotype.Service;

import demo.trainecommerce.UTILITY.exceptions.DataNotCorrectException;
import demo.trainecommerce.UTILITY.exceptions.PriceAndQuantityCannotBeLess0Exception;
import demo.trainecommerce.UTILITY.exceptions.PriceOrNameSetDifferentException;
import demo.trainecommerce.UTILITY.exceptions.ProductAlreadyExistException;
import demo.trainecommerce.UTILITY.exceptions.ProductDoesNotExistException;
import demo.trainecommerce.entities.Product;
import demo.trainecommerce.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class ProductService {

    final ProductService productService;
    final ProductRepository productRepository;

    public boolean controll(Product p){
        boolean c = p.getQuantity()>=0;
        boolean a = p.getPrice()>=0;

        return a&&c;
    }

    public void addProduct(Product p)throws RuntimeException{
        boolean c=productRepository.existsByCodeProduct(p.getCodeProduct());
        if(!c){
            if(controll(p)){
                productRepository.save(p);
            }throw new PriceAndQuantityCannotBeLess0Exception();
        }throw new ProductAlreadyExistException();
    }
    public void removeProduct(String code)throws RuntimeException{
        boolean c=productRepository.existsByCodeProduct(code);
        Product d = productRepository.findByCodeProduct(code);
        if(c){
            productRepository.delete(d);
        }throw new ProductDoesNotExistException();
        
    }
    public Product addQuantityProduct(Product p)throws RuntimeException{
        boolean c=productRepository.existsByCodeProduct(p.getCodeProduct());
        Product d = productRepository.findByCodeProduct(p.getCodeProduct());
        if(c){
            boolean a= p.getNameProduct().equals(d.getNameProduct());
            boolean b = p.getPrice()==d.getPrice();
            if(a&&b){
                d.setQuantity(d.getQuantity()+p.getQuantity());
                if(d.getQuantity()>=0){
                    productRepository.save(d);
                }throw new PriceAndQuantityCannotBeLess0Exception();
                
            }throw new PriceOrNameSetDifferentException();
        }throw new DataNotCorrectException();

    }
    public Product modifyProduct(Product p)throws RuntimeException{
        boolean c= productRepository.existsByCodeProduct(p.getCodeProduct());
        Product d = productRepository.findByCodeProduct(p.getCodeProduct());
        if(c){
            if(controll(p)){
                d.setNameProduct(p.getNameProduct());
                d.setPrice(p.getPrice());
                d.setQuantity(p.getQuantity());
                productRepository.save(d);
                return d;
            }throw new PriceAndQuantityCannotBeLess0Exception();
            
        }throw new ProductDoesNotExistException();
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
    
}
