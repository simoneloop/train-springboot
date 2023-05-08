package demo.trainecommerce.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.trainecommerce.entities.User;
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
    public String saveUser(@RequestBody User pippo){
        try {
            return "utente salvato: "+us.saveUser(pippo).getEmail();
        } catch (Exception e) {
            return e.toString();
        }
        
       
    }
    @GetMapping("/getAll")
    public ArrayList<User> getAll(){
        return us.getAll();
    }
    @GetMapping("/testJPA")
    public void testADD(){
        Users u=new Users(null,"simone","lopez","simo@");
        ur.save(u);
    }
}
