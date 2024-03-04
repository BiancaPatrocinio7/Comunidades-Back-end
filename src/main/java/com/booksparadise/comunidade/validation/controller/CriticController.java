package com.booksparadise.comunidade.validation.controller;

import com.booksparadise.comunidade.validation.dto.CriticDTO;
import com.booksparadise.comunidade.validation.service.CriticService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("validation")
@RequiredArgsConstructor

public class CriticController {
    private final CriticService criticService;

    @PostMapping
    public CriticDTO createValidation(@RequestBody CriticDTO criticDTO){
        return criticService.createValidation(criticDTO);

    }
    @GetMapping
    public List<CriticDTO> findAll(){

        return criticService.findAll();

    }
}
