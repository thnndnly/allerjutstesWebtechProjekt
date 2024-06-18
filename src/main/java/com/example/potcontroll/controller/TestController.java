package com.example.potcontroll.controller;

import com.example.potcontroll.data.TestEntry;
import jakarta.persistence.PostLoad;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    private final List<TestEntry> testEntryList;

    public TestController() {
        testEntryList = List.of(
                new TestEntry(1L, "Test1", "Description1"),
                new TestEntry(2L, "Test2", "Description2"),
                new TestEntry(3L, "Test3", "Description3")
        );
    }

    @CrossOrigin
    @GetMapping(path= "/api/testEntryList")
    public ResponseEntity<List<TestEntry>> getTestEntryList() {
        return ResponseEntity.ok(testEntryList);
    }
}
