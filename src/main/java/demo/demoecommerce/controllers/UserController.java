package demo.demoecommerce.controllers;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.demoecommerce.entities.Users;

@RestController
@RequestMapping("/users")
public class UserController{

    @GetMapping("/test")
    public String test(){
        return "richiesta ricevuta";
    }
    
    @GetMapping("/add")
    public String saveUser(@RequestBody Users u){
        System.out.println(u.getEmail());
        try{
            //System.out.println(users.toString());
            //log.info();
            //return new ResponseEntity(userService.saveUser(users), HttpStatus.OK);
            return u.getEmail()+" ricevuto";
        }
        catch (Exception e){
            return "problema";
            //return new ResponseEntity<>(Support.getExceptionName(e), HttpStatus.BAD_REQUEST);
        }
    }
    
}