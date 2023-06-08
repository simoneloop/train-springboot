package demo.trainecommerce.services;


import java.util.List;

import org.springframework.stereotype.Service;

import demo.trainecommerce.UTILITY.exceptions.DataNotCorrectException;
import demo.trainecommerce.UTILITY.exceptions.UserAlreadyExistException;
import demo.trainecommerce.UTILITY.exceptions.UserDoesNotExistException;
import demo.trainecommerce.entities.Users;
import demo.trainecommerce.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor


public class UserService {

    final UsersRepository usersRepository;

    public boolean controllRegex(Users u){
       /*  String nome = "^[a-zA-Z\s]+$";
        String cognome= "^[a-zA-Z\s]+$";
        String email ="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2.}$";

        boolean a = u.getFirstName().matches(nome);
        boolean b = u.getLastName().matches(cognome);
        boolean c = u.getEmail().matches(email);
        return a&&b&&c; */
        return true;
        
    }



    public Users saveUser(Users u) throws RuntimeException{

        boolean e =usersRepository.existsByEmail(u.getEmail());
        if(controllRegex(u)){
            if(!e){
                System.out.println("arriva in entra nella controll");
                u.setFirstName(u.getFirstName().toUpperCase().strip());
                u.setLastName(u.getLastName().toUpperCase().strip());
                u.setEmail(u.getEmail().toLowerCase().strip());
                return usersRepository.save(u);
            }
            else{throw new UserAlreadyExistException();}
        }else{throw new DataNotCorrectException();}
    }
    public void removeUser(String email)throws RuntimeException{
        boolean e =usersRepository.existsByEmail(email);
        Users u = usersRepository.findByEmail(email);
        if(e){
            usersRepository.delete(u);
        }throw new UserDoesNotExistException();
    }
    public Users modify(Users u)throws RuntimeException{

        Users p =usersRepository.findByEmail(u.getEmail());


        
        if(controllRegex(u)){
            
            p.setFirstName(u.getFirstName().toUpperCase().strip());
            p.setLastName(u.getLastName().toUpperCase().strip());
            
            usersRepository.save(p);
            return p;
        }throw new DataNotCorrectException();

    }
    public List<Users> getAll(){
        return usersRepository.findAll();
    }
}
