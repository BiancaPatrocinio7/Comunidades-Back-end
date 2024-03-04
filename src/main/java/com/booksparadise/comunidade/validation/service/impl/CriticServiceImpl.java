package com.booksparadise.comunidade.validation.service.impl;

import com.booksparadise.comunidade.validation.dto.CriticDTO;
import com.booksparadise.comunidade.validation.entity.Critic;
import com.booksparadise.comunidade.validation.repository.CriticRepository;
import com.booksparadise.comunidade.validation.service.CriticService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class CriticServiceImpl implements CriticService {
    private final CriticRepository repository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CriticDTO createValidation(CriticDTO criticDTO){
        Critic critic =  modelMapper.map(criticDTO, Critic.class);
        Critic criticPersist = repository.save(critic);
        return modelMapper.map(criticPersist, CriticDTO.class);
    }
    @Override
    public List<CriticDTO> findAll() {
        var validation =repository.findAll();
        List<CriticDTO> listCriticDTO = new ArrayList<>();
        validation.forEach(i->{  CriticDTO criticDTO = new CriticDTO();
            criticDTO.setUsername(i.getUsername());
            criticDTO.setBiography(i.getBiography());
            criticDTO.setBookName(i.getBookName());
            criticDTO.setBookRate(i.getBookRate());
            listCriticDTO.add(criticDTO);
        });
        return listCriticDTO;
    }
}
