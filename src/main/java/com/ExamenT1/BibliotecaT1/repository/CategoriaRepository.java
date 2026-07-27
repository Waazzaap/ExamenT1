package com.ExamenT1.BibliotecaT1.repository;

import com.ExamenT1.BibliotecaT1.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}