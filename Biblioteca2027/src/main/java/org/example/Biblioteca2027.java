package org.example;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class Biblioteca2027 {

    private ArrayList <Libro> libros=new ArrayList();
    private ArrayList <User> users=new ArrayList();
    private ArrayList <Prestamo> prestamos=new ArrayList();
    private ArrayList <Prestamo> prestamosHist=new ArrayList();

    public static void main(String[] args) {
        Biblioteca2027 b = new Biblioteca2027();
        b.cargaDatos();
        b.menu();

        b.libros.stream().forEach(System.out::println);
        System.out.println("");
        b.users.stream().forEach(System.out::println);
        System.out.println("");
        b.prestamos.stream().forEach(System.out::println);
        System.out.println("");
        b.prestamosHist.stream().forEach(System.out::println);
    }

    public void cargaDatos() {
        libros.add(new Libro("1-11", "El Hobbit", "JRR Tolkien", "Aventuras", 3));
        libros.add(new Libro("1-22", "El Silmarillon", "JRR Tolkien", "Aventuras", 3));
        libros.add(new Libro("1-33", "El Medico", "N. Gordon", "Aventuras", 4));
        libros.add(new Libro("1-44", "Chaman", "N. Gordon", "Aventuras", 3));
        libros.add(new Libro("1-55", "Momo", "M. Ende", "Aventuras", 2));
        libros.add(new Libro("1-66", "Paraiso inhabitado", "A.M.Matute", "Novela", 2));
        libros.add(new Libro("1-77", "Olvidado Rey Gudu", "A.M.Matute", "Novela", 0));
        libros.add(new Libro("1-88", "El ultimo barco", "D.Villar", "Novela Negra", 3));
        libros.add(new Libro("1-99", "Ojos de agua", "D.Villar", "Novela Negra", 0));

        users.add(new User("11", "Ana", "ana@email.com", "621111111"));
        users.add(new User("22", "David", "david@email.com", "622222222"));
        users.add(new User("33", "Bea", "bea@email.com", "623333333"));
        users.add(new User("44", "Lucas", "lucas@email.com", "624444444"));
        users.add(new User("55", "Carlota", "carlota@email.com", "625555555"));
        users.add(new User("66", "Juan", "juan@email.com", "626666666"));

        LocalDate hoy = LocalDate.now(); //OBTENEMOS LA FECHA DE HOY CON EL MÉTODO now()

        //PRESTAMOS "NORMALES" REALIZADOS HOY Y QUE SE HAN DE DEVOLVER EN 15 DÍAS
        prestamos.add(new Prestamo(libros.get(0), users.get(0), hoy, hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(1), users.get(0), hoy, hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(5), users.get(1), hoy, hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(0), users.get(4), hoy, hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(0), users.get(1), hoy, hoy.plusDays(15)));
        //PRESTAMOS QUE YA TENIAN QUE HABER SIDO DEVUELTOS PORQUE SU FECHA DE DEVOLUCIÓN ES ANTERIOR A HOY
        prestamos.add(new Prestamo(libros.get(5), users.get(1), hoy.minusDays(17), hoy.minusDays(2)));
        prestamos.add(new Prestamo(libros.get(1), users.get(2), hoy.minusDays(18), hoy.minusDays(3)));
        prestamos.add(new Prestamo(libros.get(8), users.get(2), hoy.minusDays(18), hoy.minusDays(3)));
        prestamos.add(new Prestamo(libros.get(4), users.get(4), hoy.minusDays(20), hoy.minusDays(5)));
        prestamos.add(new Prestamo(libros.get(7), users.get(4), hoy.minusDays(20), hoy.minusDays(5)));

        //PRESTAMOS HISTORICOS QUE YA HAN SIDO DEVUELTOS Y POR TANTO ESTÁN EN LA COLECCION prestamosHist
        prestamosHist.add(new Prestamo(libros.get(0), users.get(0), hoy.minusDays(20), hoy.minusDays(10)));
        prestamosHist.add(new Prestamo(libros.get(1), users.get(0), hoy.minusDays(20), hoy.minusDays(10)));
        prestamosHist.add(new Prestamo(libros.get(8), users.get(0), hoy.minusDays(20), hoy.minusDays(16)));
        prestamosHist.add(new Prestamo(libros.get(7), users.get(4), hoy.minusDays(30), hoy.minusDays(15)));
        prestamosHist.add(new Prestamo(libros.get(5), users.get(4), hoy.minusDays(20), hoy.minusDays(15)));
        prestamosHist.add(new Prestamo(libros.get(8), users.get(1), hoy.minusDays(20), hoy.minusDays(5)));
        prestamosHist.add(new Prestamo(libros.get(7), users.get(2), hoy.minusDays(15), hoy));
        prestamosHist.add(new Prestamo(libros.get(6), users.get(3), hoy.minusDays(15), hoy));

    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("\n\n\n\n\n\t\t\t\tBIBLIOTECA\n");
            System.out.println("\t\t\t\t1 - LIBROS");
            System.out.println("\t\t\t\t2 - USERS");
            System.out.println("\t\t\t\t3 - PRESTAMOS");
            System.out.println("\t\t\t\t4 - LISTADOS");
            System.out.println("\t\t\t\t9 - SALIR");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1: {
                    menuLibros();
                    break;
                }
                case 2: {
                    menuUsers();
                    break;
                }
                case 3: {
                    menuPrestamos();
                    break;
                }
                case 4: {
                    menuListados();
                    break;
                }
            }
        } while (opcion != 9);
    }

    private void menuLibros() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("\n\n\n\n\n\t\t\t\tLIBROS\n");
            System.out.println("\t\t\t\t1 - NUEVO LIBRO");
            System.out.println("\t\t\t\t2 - ELIMINAR LIBRO");
            System.out.println("\t\t\t\t3 - MODIFICAR LIBRO");
            System.out.println("\t\t\t\t4 - LISTADO GENERAL DE LIBROS");
            System.out.println("\t\t\t\t9 - SALIR");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1: {
                    //nuevoLibro();
                    break;
                }
                case 2: {
                    //eliminarLibro();
                    break;
                }
                case 3: {
                    //modificarLibros();
                    break;
                }
                case 4: {
                    //listaLibros();
                    break;
                }
            }
        } while (opcion != 9);
    }

    private void nuevoLibro () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vamos a  crear un nuevo libro.");
        System.out.println("ISBN:");
        String isbn = sc.nextLine();
        System.out.println("Título:");
        String titulo = sc.nextLine();
        System.out.println("Autor:");
        String autor = sc.nextLine();
        System.out.println("Género:");
        String genero = sc.nextLine();
        System.out.println("Unidades:");
        int unidades = sc.nextInt();

        libros.add(new Libro(isbn, titulo, autor, genero, unidades));
    }

    private void eliminarLibro () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vamos a  eliminar un nuevo libro.");
        System.out.println("Dime el nombre del libro que quieras eliminar: ");
        String nombre = sc.nextLine();

        for (Libro l : libros) {
            if (l.getTitulo().equalsIgnoreCase(nombre)) {
                libros.remove(l);
            }
        }


    }

    private void menuUsers() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("\n\n\n\n\n\t\t\t\tUSERS");
            System.out.println("\t\t\t\t1 - NUEVO USER");
            System.out.println("\t\t\t\t2 - ELIMINAR USERS");
            System.out.println("\t\t\t\t3 - MODIFICAR USER");
            System.out.println("\t\t\t\t4 - LISTADO GENERAL DE USERS");
            System.out.println("\t\t\t\t9 - SALIR");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1: {
                    //nuevoUser();
                    break;
                }
                case 2: {
                    //eliminarUser();
                    break;
                }
                case 3: {
                    //modificarUser();
                    break;
                }
                case 4: {
                    //listaUsers();
                    break;
                }
            }
        } while (opcion != 9);
    }

    private void menuPrestamos() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("\n\n\n\n\n\t\t\t\tPRESTAMOS\n");
            System.out.println("\t\t\t\t1 - NUEVO PRESTAMO");
            System.out.println("\t\t\t\t2 - DEVOLUCION PRESTAMO");
            System.out.println("\t\t\t\t3 - PRORROGAR PRESTAMO");
            System.out.println("\t\t\t\t4 - LISTADO GENERAL DE PRESTAMOS");
            System.out.println("\t\t\t\t9 - SALIR");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1: {
                    //nuevoPrestamo();
                    break;
                }
                case 2: {
                    //devolucion();
                    break;
                }
                case 3: {
                    //prorroga();
                    break;
                }
                case 4: {
                    //listaPrestamos();
                    break;
                }
            }
        } while (opcion != 9);
    }

    private void nuevoPrestamo () {
        Scanner sc = new Scanner (System.in);
        System.out.println("Teclea ISBN libro:");
        String isbn = sc.next();

        System.out.println("Teclea DNI usuario;");
        String dni = sc.next();

        LocalDate hoy = LocalDate.now();
        hoy.plusDays(15);

    }

    private void buscarUser () {
        Scanner sc = new Scanner (System.in);
        String dni = sc.next();
        if (users.contains(dni))
        ;

    }

    private void menuListados() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("\n\n\n\n\n\t\t\t\tLISTADOS\n");
            System.out.println("\t\t\t\t1 - LISTADO 1");
            System.out.println("\t\t\t\t2 - LISTADO 2");
            System.out.println("\t\t\t\t3 - LISTADO 3");
            System.out.println("\t\t\t\t4 - LISTADO 4");
            System.out.println("\t\t\t\t9 - SALIR");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1: {
                    //listaPrestamosUsu();
                    break;
                }
                case 2: {
                    //listaPrestamosLibro();
                    break;
                }
                case 3: {
                    //libroMasLeido();
                    break;
                }
                case 4: {
                    //userMasLector();
                    break;
                }
            }
        } while (opcion != 9);
    }

}