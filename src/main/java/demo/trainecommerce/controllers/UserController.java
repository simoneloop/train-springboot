package demo.trainecommerce.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.trainecommerce.entities.Users;
import demo.trainecommerce.repositories.UsersRepository;
import demo.trainecommerce.services.UserService;

//Richieste
//POST:aggiungere
//GET:richiedere
//PUT:aggiornare
//DELETE:rimuovere
@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService us;

    @Autowired
    private UsersRepository ur;
    
    @GetMapping("/test")
    public String test(){
        return "hello world";
    }

    @PostMapping("/add")
    public ResponseEntity saveUser(@RequestBody Users u){
        System.out.println(u);
        try {
            
            return new ResponseEntity(us.saveUser(u),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getClass().getSimpleName(),HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/remove")
    public ResponseEntity removeUser(@RequestParam("email") String email ){
        try {
            us.removeUser(email);
            return new ResponseEntity("L'utente è stato rimosso",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getClass().getSimpleName(),HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/modify")
    public ResponseEntity modifyUser(@RequestBody Users u){
        try {
            return new ResponseEntity(us.modify(u),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getClass().getSimpleName(),HttpStatus.BAD_REQUEST);
        }
    }

    

    @GetMapping("/getAll")
    public List<Users> getAll(){
        return us.getAll();
    }
    
}
