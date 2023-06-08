package demo.trainecommerce.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.trainecommerce.entities.Product;
import demo.trainecommerce.repositories.ProductRepository;
import demo.trainecommerce.services.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor


public class ProductController {

    final ProductService productService;
    final ProductRepository productRepository;

    @PostMapping("/addProduct")
    public ResponseEntity addProduct(@RequestBody Product p){
        try {
            productService.addProduct(p);
            return new ResponseEntity("Il prodotto è stato aggiunto",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getClass().getSimpleName(),HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/removeProduct")
    public ResponseEntity removeProduct(@RequestParam ("code")String code){
        try {
            productService.removeProduct(code);
            return new ResponseEntity("Il prodotto è stato rimosso",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getClass().getSimpleName(),HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/modify")
    public ResponseEntity modifyProduct(@RequestBody Product p){
        try {
            return new ResponseEntity(productService.modifyProduct(p),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getClass().getSimpleName(),HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/addQuantityProduct")
    public ResponseEntity addQuantityProduct(@RequestBody Product p){
        try {
            return new ResponseEntity(productService.addQuantityProduct(p),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getClass().getSimpleName(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getAll")
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }


    
}
