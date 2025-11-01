package com.java.d2helper.presentation.controller;
import com.java.d2helper.application.TerrorzoneUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TerrorzoneController {
    private final TerrorzoneUseCase useCase;

    public TerrorzoneController(TerrorzoneUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping("/terrorzone")
    public ResponseEntity<?> getCurrent() {
        return ResponseEntity.ok(useCase.get());
    }
}
