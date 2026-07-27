package com.ExamenT1.BibliotecaT1.config;

import com.ExamenT1.BibliotecaT1.model.*;
import com.ExamenT1.BibliotecaT1.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner cargarDatos(
            AutorRepository autorRepository,
            CategoriaRepository categoriaRepository,
            LibroRepository libroRepository,
            SocioRepository socioRepository,
            PrestamoRepository prestamoRepository
    ) {
        return args -> {

            Autor autor1 = new Autor("Gabriel", "García Márquez", "Colombiana");
            Autor autor2 = new Autor("Mario", "Vargas Llosa", "Peruana");
            autorRepository.save(autor1);
            autorRepository.save(autor2);

            Categoria cat1 = new Categoria("Novela", "Literatura narrativa extensa");
            Categoria cat2 = new Categoria("Ensayo", "Textos de análisis y reflexión");
            categoriaRepository.save(cat1);
            categoriaRepository.save(cat2);

            Libro libro1 = new Libro("Cien años de soledad", "978-0307474728", 1967, 3, 3, autor1, cat1);
            Libro libro2 = new Libro("La ciudad y los perros", "978-8420471839", 1963, 2, 2, autor2, cat1);
            libroRepository.save(libro1);
            libroRepository.save(libro2);

            SocioEstudiante estudiante1 = new SocioEstudiante(
                    "Luis", "Ramirez", "luis.ramirez@cibertec.edu.pe",
                    LocalDate.now(), "EST2024001"
            );
            SocioDocente docente1 = new SocioDocente(
                    "Ana", "Torres", "ana.torres@cibertec.edu.pe",
                    LocalDate.now(), "Sistemas"
            );
            socioRepository.save(estudiante1);
            socioRepository.save(docente1);

            LocalDate hoy = LocalDate.now();

            Prestamo prestamo1 = new Prestamo(
                    hoy,
                    hoy.plusDays(estudiante1.getDiasPrestamo()),
                    "ACTIVO",
                    estudiante1,
                    libro1
            );
            prestamoRepository.save(prestamo1);

            libro1.setStockDisponible(libro1.getStockDisponible() - 1);
            libroRepository.save(libro1);

            prestamoRepository.flush();
            libroRepository.flush();

            System.out.println("Préstamo registrado y flush ejecutado correctamente.");

            System.out.println("\n=== LISTA DE PRÉSTAMOS ===");
            prestamoRepository.findAll().forEach(p -> {
                Libro libroCompleto = libroRepository.findById(p.getLibro().getIdLibro()).orElseThrow();
                System.out.println("- " + p.getSocio().getNombres() + " (" + p.getSocio().getDiasPrestamo() + " días) → "
                        + libroCompleto.getTitulo() + " | Devolución: " + p.getFechaDevolucionEsperada());
            });
        };
    }
}