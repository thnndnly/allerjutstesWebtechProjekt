package com.example.potcontroll.user;

import com.example.potcontroll.data.PokerGameEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public String save(User user) {
        repo.save(user);
        return user.getUsername();
    }

    public User get(Long id) {
        return repo.findById(id).orElseThrow(RuntimeException::new);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<User> getAll() {
        Iterable<User> iterator = repo.findAll();
        List<User> userList = new ArrayList<User>();
        for(User entry : iterator) {
            userList.add(entry);
        }
        return userList;
    }
}
