package com.example.potcontroll.controller;

import com.example.potcontroll.data.PokerGameEntry;
import com.example.potcontroll.data.PokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokerController {

    @Autowired
    PokerService service;

    @PostMapping("/pokerGameEntry")
    public PokerGameEntry createPokerGameEntry(PokerGameEntry entry) {
        return service.save(entry);
    }

    @GetMapping("/pokerGameEntry/{id}")
    public PokerGameEntry getPokerGameEntry(@PathVariable String id) {
        Long entryId = Long.parseLong(id);
        return service.get(entryId);
    }
}
