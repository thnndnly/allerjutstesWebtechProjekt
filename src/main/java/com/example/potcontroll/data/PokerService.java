package com.example.potcontroll.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokerService {

    @Autowired
    PokerRepository repo;

    public List<PokerGameEntry> save(PokerGameEntry entry) {
        repo.save(entry);
        return (List<PokerGameEntry>) repo.findAll();
    }

    public PokerGameEntry get(Long id) {
        return repo.findById(id).orElseThrow(RuntimeException::new);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<PokerGameEntry> getAllWithoutOwner() {
        Iterable<PokerGameEntry> iterator = repo.findAll();
        List<PokerGameEntry> pokerGameEntryList = new ArrayList<PokerGameEntry>();
        for(PokerGameEntry entry : iterator) {
            if(entry.getOwner() == null || entry.getOwner().isEmpty()) {
                pokerGameEntryList.add(entry);
            }
        }
        return pokerGameEntryList;
    }

    public List<PokerGameEntry> getAllOwnedBy(String owner) {
        Iterable<PokerGameEntry> iterator = repo.findAll();
        List<PokerGameEntry> pokerGameEntryList = new ArrayList<PokerGameEntry>();
        for(PokerGameEntry entry : iterator) {
            if(entry.getOwner() != null) {
                if(entry.getOwner().equals(owner)) {
                    pokerGameEntryList.add(entry);
                }
            }
        }
        return pokerGameEntryList;
    }
}