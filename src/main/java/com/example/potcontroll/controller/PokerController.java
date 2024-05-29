package com.example.potcontroll.controller;

import com.example.potcontroll.data.PokerGameEntry;
import com.example.potcontroll.data.PokerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController()
public class PokerController {

    @Autowired
    PokerService service;

    Logger logger = LoggerFactory.getLogger(PokerController.class);

    @CrossOrigin
    @PostMapping("/pokerGameEntries")
    public List<PokerGameEntry> createPokerGameEntry(@RequestBody PokerGameEntry entry) {
        return service.save(entry);
    }

    @CrossOrigin
    @GetMapping("/pokerGameEntry/{id}")
    public PokerGameEntry getPokerGameEntry(@PathVariable String id) {
        logger.info("Getting entry with id: {}", id);
        Long entryId = Long.parseLong(id);
        return service.get(entryId);
    }

    @CrossOrigin
    @GetMapping("/pokerGameEntries")
    public List<PokerGameEntry> getAllPokerGameEntries(@RequestParam("owner") String owner) {
        return owner.isEmpty() ? service.getAllWithoutOwner() : service.getAllOwnedBy(owner);
    }
}