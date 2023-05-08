package demo.trainecommerce.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import demo.trainecommerce.UTILITY.exceptions.DataNotCorrectException;
import demo.trainecommerce.UTILITY.exceptions.UserAlreadyExistException;
import demo.trainecommerce.entities.User;

@Service
public class UserService {

    public ArrayList<User> db=new ArrayList<>();
    
    //TODO
    public User saveUser(User u)throws RuntimeException{
       if(!u.getFirstName().contains("@")){
        db.add(u);
        return u;
       }
       else{
        throw new DataNotCorrectException();
       }
       

    }
    public ArrayList<User> getAll(){
        return db;
    }
}
