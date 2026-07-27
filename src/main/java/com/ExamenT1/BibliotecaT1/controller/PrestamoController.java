package com.ExamenT1.BibliotecaT1.controller;

import com.ExamenT1.BibliotecaT1.repository.PrestamoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrestamoController {

    private final PrestamoRepository prestamoRepository;

    public PrestamoController(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("prestamos", prestamoRepository.findAll());
        return "index";
    }
}