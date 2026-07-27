package com.ExamenT1.BibliotecaT1.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("DOCENTE")
public class SocioDocente extends Socio {

    @Column(name = "departamento", length = 60)
    private String departamento;

    public SocioDocente() {
    }

    public SocioDocente(String nombres, String apellidos, String email,
                        LocalDate fechaRegistro, String departamento) {
        super(nombres, apellidos, email, fechaRegistro);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public int getDiasPrestamo() {
        return 15;
    }

    @Override
    public String getTipoSocio() {
        return "Docente";
    }
}