package com.booksparadise.comunidade.validation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CriticDTO {
    private Integer id;
    private String username;
    private String biography;
    private String bookName;
    private Integer bookRate;
}
