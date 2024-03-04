package com.booksparadise.comunidade;

import com.booksparadise.comunidade.validation.dto.CriticDTO;
import com.booksparadise.comunidade.validation.entity.Critic;
import com.booksparadise.comunidade.validation.repository.CriticRepository;
import com.booksparadise.comunidade.validation.service.CriticService;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class CriticServiceTest {

    @SuppressWarnings("java:S6813")
    @Autowired
    private CriticService criticService;

    @MockBean
    private CriticRepository criticRepository;

    @Test
    void testInsertCritic(){
        when(criticRepository.save(any())).thenReturn(new Critic(1, "Amelia", "Sou estudante", "A Culpa é das Estrelas", 5));
        assertDoesNotThrow(()->criticService.createValidation(new CriticDTO(1, "Amelia", "Sou estudante", "A Culpa é das Estrelas", 5)));
    }

    @Test
    void testFindAll() {
        Critic critic1 = new Critic(1, "Amelia", "Sou estudante", "A Culpa é das Estrelas", 5);
        Critic critic2 = new Critic(2, "Juliana", "Sou artista", "Dez Mil Ceus Sobre Você", 8);
        List<Critic> critics = List.of(critic1, critic2);

        List<CriticDTO> criticDTOs = new ArrayList<>();
        for (Critic critic : critics) {
            CriticDTO criticDTO = new CriticDTO();
            criticDTO.setUsername(critic.getUsername());
            criticDTO.setBiography(critic.getBiography());
            criticDTO.setBookName(critic.getBookName());
            criticDTO.setBookRate(critic.getBookRate());
            criticDTOs.add(criticDTO);
        }

        when(criticRepository.findAll()).thenReturn(critics);

        List<CriticDTO> result = criticService.findAll();

        assertEquals(criticDTOs.size(), result.size());
        for (int i = 0; i < criticDTOs.size(); i++) {
            assertEquals(criticDTOs.get(i).getUsername(), result.get(i).getUsername());
            assertEquals(criticDTOs.get(i).getBiography(), result.get(i).getBiography());
            assertEquals(criticDTOs.get(i).getBookName(), result.get(i).getBookName());
            assertEquals(criticDTOs.get(i).getBookRate(), result.get(i).getBookRate());
        }
    }
}
