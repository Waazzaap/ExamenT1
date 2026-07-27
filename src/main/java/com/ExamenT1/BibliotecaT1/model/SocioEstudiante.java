package com.ExamenT1.BibliotecaT1.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("ESTUDIANTE")
public class SocioEstudiante extends Socio {

    @Column(name = "codigo_estudiante", length = 20)
    private String codigoEstudiante;

    public SocioEstudiante() {
    }

    public SocioEstudiante(String nombres, String apellidos, String email,
                           LocalDate fechaRegistro, String codigoEstudiante) {
        super(nombres, apellidos, email, fechaRegistro);
        this.codigoEstudiante = codigoEstudiante;
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(String codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    @Override
    public int getDiasPrestamo() {
        return 7;
    }

    @Override
    public String getTipoSocio() {
        return "Estudiante";
    }
}