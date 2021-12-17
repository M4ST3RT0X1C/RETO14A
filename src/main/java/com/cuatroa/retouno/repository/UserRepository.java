/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cuatroa.retouno.repository;

import com.cuatroa.retouno.model.User;
import com.cuatroa.retouno.repository.crud.UserCrudrepository;
import com.cuatroa.retouno.repository.crud.UserCrudrepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author David
 */


public class UserRepository {
    @Autowired
    private UserCrudrepository userCrudrepository;
    
    public List<User>getAll(){
        return (List<User>) userCrudrepository.findAll();        
    }
    
    public Optional<User> getUser(int id){
        return userCrudrepository.findById(id);
    }
    
    public User save(User user) {
        return userCrudrepository.save(user);
    }
    
    public boolean existeEmail(String email){
        Optional<User> usuario = userCrudrepository.findByEmail(email);
        return !usuario.isEmpty();
    }
    
    public Optional<User> autenticarUsuario(String email, String password){
        return userCrudrepository .findByEmailAndPassword(email, password);
    }
            
    
    
    
}
