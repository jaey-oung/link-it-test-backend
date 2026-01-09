package com.linkit.backend.controller;

import com.linkit.backend.service.ClickService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/clicks")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ClickController {
    
    private final ClickService clickService;
    
    @PostMapping
    public Map<String, Long> click() {
        Long count = clickService.incrementAndGetCount();
        return Map.of("count", count);
    }
    
    @GetMapping
    public Map<String, Long> getCount() {
        Long count = clickService.getCount();
        return Map.of("count", count);
    }
}