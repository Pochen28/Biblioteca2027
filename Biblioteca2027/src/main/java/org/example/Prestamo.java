package org.example;

import java.time.LocalDate;

public class Prestamo {
    Libro libroPrest;
    User usuarioPrest;
    LocalDate fechaPrest;
    LocalDate fechaDev;

    public Prestamo(Libro libroPrest, User usuarioPrest, LocalDate fechaPrest, LocalDate fechaDev) {
        this.libroPrest = libroPrest;
        this.usuarioPrest = usuarioPrest;
        this.fechaPrest = fechaPrest;
        this.fechaDev = fechaDev;
    }

    public Libro getLibroPrest() {
        return libroPrest;
    }

    public void setLibroPrest(Libro libroPrest) {
        this.libroPrest = libroPrest;
    }

    public User getUsuarioPrest() {
        return usuarioPrest;
    }

    public void setUsuarioPrest(User usuariaPrest) {
        this.usuarioPrest = usuariaPrest;
    }

    public LocalDate getFechaPrest() {
        return fechaPrest;
    }

    public void setFechaPrest(LocalDate fechaPrest) {
        this.fechaPrest = fechaPrest;
    }

    public LocalDate getFechaDev() {
        return fechaDev;
    }

    public void setFechaDev(LocalDate fechaDev) {
        this.fechaDev = fechaDev;
    }

    @Override
    public String toString() {
        return libroPrest.getTitulo() + " - " + usuarioPrest.getNombre() + " - " + fechaPrest + " - " + fechaDev;
    }
}