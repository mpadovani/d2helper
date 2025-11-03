package com.java.d2helper.presentation.controller;
import com.java.d2helper.application.ports.in.TerrorzoneUseCaseInputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TerrorzoneController {
    private TerrorzoneUseCaseInputPort useCase;

    public TerrorzoneController(TerrorzoneUseCaseInputPort useCase) {
        this.useCase = useCase;
    }

    @GetMapping("/terrorzone")
    public ResponseEntity<?> getCurrent() {
        return ResponseEntity.ok(useCase.get());
    }
}
