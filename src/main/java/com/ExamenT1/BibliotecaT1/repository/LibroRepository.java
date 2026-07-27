package com.ExamenT1.BibliotecaT1.repository;

import com.ExamenT1.BibliotecaT1.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Integer> {
}