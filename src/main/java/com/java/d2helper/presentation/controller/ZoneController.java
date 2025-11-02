package com.java.d2helper.presentation.controller;
import com.java.d2helper.application.ports.in.ZoneUseCaseInputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZoneController {
    private final ZoneUseCaseInputPort useCase;

    public ZoneController(ZoneUseCaseInputPort useCase) {
        this.useCase = useCase;
    }

    @GetMapping("/zone")
    public ResponseEntity<?> getCurrent() {
        return ResponseEntity.ok(useCase.get());
    }
}
