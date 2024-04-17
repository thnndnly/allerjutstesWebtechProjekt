package com.example.potcontroll;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.example.potcontroll.data.PokerGameEntry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// https://spring.io/guides/gs/spring-boot
@RestController
public class HelloController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/sessions")
    public List<PokerGameEntry> greeting() {
        PokerGameEntry entry = new PokerGameEntry(PokerGameEntry.Gametype.CASHGAME, 2, 5, 0, new Date(), 400, 678);
        PokerGameEntry entry1 = new PokerGameEntry(PokerGameEntry.Gametype.TOURNAMENT, 100, 200, 0, new Date(), 500, 0);
        PokerGameEntry entry2 = new PokerGameEntry(PokerGameEntry.Gametype.SPINANDGO, 10, 20, 0, new Date(), 25, 75);
        return List.of(entry, entry1, entry2);
    }
}