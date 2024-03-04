package com.booksparadise.comunidade.validation.repository;

import com.booksparadise.comunidade.validation.entity.Critic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriticRepository extends JpaRepository<Critic, Integer> {
}
