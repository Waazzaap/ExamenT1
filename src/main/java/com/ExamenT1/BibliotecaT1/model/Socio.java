package com.ExamenT1.BibliotecaT1.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_socio")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_socio", discriminatorType = DiscriminatorType.STRING)
public abstract class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_socio")
    private Integer idSocio;

    @Column(name = "nombres", nullable = false, length = 80)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 80)
    private String apellidos;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;

    public Socio() {
    }

    public Socio(String nombres, String apellidos, String email, LocalDate fechaRegistro) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Integer idSocio) {
        this.idSocio = idSocio;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public abstract int getDiasPrestamo();

    public abstract String getTipoSocio();
}