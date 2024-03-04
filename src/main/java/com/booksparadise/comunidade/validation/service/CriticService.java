package com.booksparadise.comunidade.validation.service;

import com.booksparadise.comunidade.validation.dto.CriticDTO;

import java.util.List;

public interface CriticService {
    CriticDTO createValidation(CriticDTO criticDTO);
    List<CriticDTO> findAll();
}
