package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl
    implements UserService
{

    private List<User> users = new ArrayList<>();


    @Autowired
    public UserServiceImpl()
    {
    }

    @PostConstruct
    private void populateSampleData()
    {
        users.add( new User( "test@mail.com", "password", "Andres", "Perez" ) );
    }


    @Override
    public List<User> getUsers()
    {
        return users;
    }

    @Override
    public User getUser( Long id )
    {
        for (User u : users){
            if ( u.getId() == id){
                return u;
            }
        }
        return null;
    }

    @Override
    public User createUser( User user )
    {
        users.add(user);
        return user;
    }

    @Override
    public User findUserByEmail( String email )
    {
        for (User u : users){
            if ( u.getEmail().equals(email) ){
                return u;
            }
        }
        return null;
    }

    @Override
    public User findUserByEmailAndPassword( String email, String password )
    {
        for (User u : users){
            if ( u.getEmail().equals(email) && u.getPassword().equals(password) ){
                return u;
            }
        }
        return null;
    }

}
