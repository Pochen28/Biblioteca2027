package org.example;

import java.time.LocalDate;

public class Prestamo {
    //Realmente estamos asociando la dirrecion de memoria de Libro a LibroPrest, desde mediante puntos de get y set puedes sacar la información que quieras de los libros.
    //Qué tiene un prestamo?? Un libro, un usuario y una fecha.
    private Libro libroPrest;
    private Usuario usuarioPrest;
    private LocalDate fechaPrest;
    private LocalDate fechaDev;

    public Prestamo(Libro libroPrest, Usuario usuarioPrest, LocalDate fechaPrest, LocalDate fechaDev) {
        this.libroPrest = libroPrest;
        this.usuarioPrest = usuarioPrest;
        this.fechaPrest = fechaPrest;
        this.fechaDev = fechaDev;
    }

    public Libro getLibroPrest() {
        return libroPrest;
    }

    public Usuario getUsuarioPrest() {
        return usuarioPrest;
    }

    public LocalDate getFechaPrest() {
        return fechaPrest;
    }

    public LocalDate getFechaDev() {
        return fechaDev;
    }

    public void setLibroPrest(Libro libroPrest) {
        this.libroPrest = libroPrest;
    }

    public void setUsuarioPrest(Usuario usuarioPrest) {
        this.usuarioPrest = usuarioPrest;
    }

    public void setFechaPrest(LocalDate fechaPrest) {
        this.fechaPrest = fechaPrest;
    }

    public void setFechaDev(LocalDate fechaDev) {
        this.fechaDev = fechaDev;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "libroPrest=" + libroPrest +
                ", usuarioPrest=" + usuarioPrest +
                ", fechaPrest=" + fechaPrest +
                ", fechaDev=" + fechaDev +
                '}';
    }
}
