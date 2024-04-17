package com.example.potcontroll.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokerService {

    @Autowired
    PokerRepository repo;

    public PokerGameEntry save(PokerGameEntry entry) {
        return repo.save(entry);
    }

    public PokerGameEntry get(Long id) {
        return repo.findById(id).orElseThrow(RuntimeException::new);
    }
}
