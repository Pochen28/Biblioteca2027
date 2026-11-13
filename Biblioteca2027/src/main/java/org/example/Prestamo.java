package org.example;

import java.time.LocalDate;

public class Prestamo {
    Libro libroPrest;
    User usuariaPrest;
    LocalDate fechaPrest;
    LocalDate fechaDev;

    public Prestamo(Libro libroPrest, User usuariaPrest, LocalDate fechaPrest, LocalDate fechaDev) {
        this.libroPrest = libroPrest;
        this.usuariaPrest = usuariaPrest;
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
        return usuariaPrest;
    }

    public void setUsuarioPrest(User usuariaPrest) {
        this.usuariaPrest = usuariaPrest;
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
        return libroPrest.getTitulo() + " - " + usuariaPrest.getNombre() + " - " + fechaPrest + " - " + fechaDev;
    }
}