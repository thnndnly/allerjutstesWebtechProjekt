/*
package com.example.potcontroll.controller;

import com.example.potcontroll.data.PokerGameEntry;
import com.example.potcontroll.data.PokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class PokerController {

    private final List<PokerGameEntry> pokerGameEntryList;

    public PokerController() {
        pokerGameEntryList = List.of(
                new PokerGameEntry(PokerGameEntry.Gametype.CASHGAME, 1, 2, 0, new Date(), 100, 200),
                new PokerGameEntry(PokerGameEntry.Gametype.TOURNAMENT, 1, 2, 0, new Date(), 100, 200),
                new PokerGameEntry(PokerGameEntry.Gametype.SPINANDGO, 1, 2, 0, new Date(), 100, 200)
        );
    }

    @GetMapping(path= "/api/pokerGameEntryList")
    public ResponseEntity<List<PokerGameEntry>> getPokerGameEntryList() {
        return ResponseEntity.ok(pokerGameEntryList);
    }

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
*/