import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Modelo {
    private static Modelo instance;
    private ArrayList<Usuario> listaUsuarios = new ArrayList();
    private ArrayList<Libro> listaLibros = new ArrayList();
    private int indice_Usuario;

    private Modelo() {  //datos iniciales
        crearUsuario(new Usuario("Pepe", "Martinez", "651 231 555", "PeMart@usuario.com"));
        crearUsuario(new Usuario("Luisa", "Fernandez", "622 321 666", "LuFer@usuario.com"));
        crearUsuario(new Usuario("Agripino", "Babieca", "644 123 777", "AgBab@usuario.com"));
        crearLibro(new Libro("Libro 01", "Autor 01", "0000000000001", false));
        crearLibro(new Libro("Libro 02", "Autor 02", "0000000000002", false));
        crearLibro(new Libro("Libro 03", "Autor 03", "0000000000003", false));
        crearLibro(new Libro("Libro 04", "Autor 04", "0000000000004", false));
        crearLibro(new Libro("Libro 05", "Autor 05", "0000000000005", false));
        crearLibro(new Libro("Libro 06", "Autor 06", "0000000000006", false));
        crearLibro(new Libro("Libro 07", "Autor 07", "0000000000007", true));
    }

    public static Modelo getInstance() {    //instanciación única
        if (instance == null) {
            instance = new Modelo();
        }
        return instance;
    }
    public void crearUsuario(Usuario usuario) {
        this.listaUsuarios.add(usuario);
    }
    public void devolverlistaUsuarios() {
        for(Usuario usuario: this.listaUsuarios){
            System.out.println(usuario);
        }
    }

    public void identificarUsuario() {  //login e indice de usuario
        int index = 0;
        boolean flag = true;
        while(flag) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduzca nombre de usuario: ");
            String opcion = scanner.nextLine();
            for(int i = 0; i < this.listaUsuarios.size(); ++i) {
                if (Objects.equals(this.listaUsuarios.get(i).getNombre(), opcion)) {
                    System.out.println("Bienvenido/a, " + this.listaUsuarios.get(i).getNombre() + " " + this.listaUsuarios.get(i).getApellido() + "\n");
                    index = i;  //con esto identificamos al usuario en los métodos posteriores
                    flag = false;
                }
            }
            if(flag) {
                System.out.println("Nombre no válido\n");
            }
        }
        this.indice_Usuario = index;
    }
    public void crearLibro(Libro libro) {
        this.listaLibros.add(libro);
    }
    public void devolverListaLibros() {
        for(Libro libro: this.listaLibros){
            System.out.println(libro);
        }
    }

    public void pedirLibro() {
        boolean flag = true;
        while(flag) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduzca titulo del libro que quiera: ");
            String opcion = scanner.nextLine();
            for(int i = 0; i < this.listaLibros.size(); ++i) {
                if (Objects.equals(this.listaLibros.get(i).getTitulo(), opcion)) {
                    if(this.listaLibros.get(i).isPrestado()){
                        System.out.println("Este libro está prestado. ¿Quiere reservarlo? (si/no): ");
                        String respuesta=scanner.nextLine();
                        if(Objects.equals(respuesta, "si")){
                            boolean checker=true;
                            for(String libro:this.listaUsuarios.get(this.indice_Usuario).getLibrosPrestados()){
                                if(Objects.equals(libro,this.listaLibros.get(i).getTitulo())){
                                    System.out.println("Ya ha tomado prestado ese libro\n");
                                    flag = false;
                                    checker=false;
                                }
                            }
                            if(checker==true){
                                this.listaLibros.get(i).setcolaSolicitud(this.listaUsuarios.get(this.indice_Usuario).getNombre());
                                System.out.println("Su nombre se ha anhadido a la lista de espera del libro: "+this.listaLibros.get(i).getTitulo());
                                System.out.println("\n");
                                flag = false;
                            }
                        }else{flag=false;}
                    }else{
                        System.out.println(this.listaUsuarios.get(this.indice_Usuario).getNombre() + " ha tomado prestado el libro " + ((Libro)this.listaLibros.get(i)).getTitulo() + "\n");
                        flag = false;
                        this.listaUsuarios.get(this.indice_Usuario).setLibrosPrestados(this.listaLibros.get(i).getTitulo());    //metemos el nombre del libro en la lista de libros prestados de ese usuario
                        this.listaLibros.get(i).setQuienloTieneAhora(this.listaUsuarios.get(this.indice_Usuario).getNombre());  //metemos el nombre del usuario en la propiedad del objeto libro que identifica a quien tiene el libro actualmente
                        this.listaLibros.get(i).setPrestado(true);  //cambiamos el estado del libro a prestado mediante boolean
                    }


                }
            }
            if (flag) {
                System.out.println("Titulo no válido\n");
            }
        }
    }
    public void verTodosLibros() {
        for(Libro libro: this.listaLibros){
            System.out.println("Autor: " + libro.getAutor() + "\nTitulo: " + libro.getTitulo() + "\nISBN: " + libro.getIsbn());
            if (libro.isPrestado()) {
                System.out.println("No disponible\n");
            } else {
                System.out.println("Disponible\n");
            }
            if(libro.getColaSolicitud().size()>0){
                System.out.println("Lista de espera:");
                for(String nombre:libro.getColaSolicitud()){
                    System.out.println(nombre);
                }
            }
            System.out.println("\n");

        }
    }

    public void devolverLibro() {
        boolean flag = true;
        if (this.listaUsuarios.get(this.indice_Usuario).getLibrosPrestados().size() <= 0) {
            System.out.println("No tiene libros por devolver\n");
        } else {
            while(flag) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Introduzca el nombre del libro que quiera devolver: ");
                String opcion = scanner.nextLine();
                for(int i = 0; i < this.listaUsuarios.get(this.indice_Usuario).getLibrosPrestados().size(); ++i) {
                    if (Objects.equals(this.listaUsuarios.get(this.indice_Usuario).getLibrosPrestados().get(i), opcion)) {
                        System.out.println("Libro devuelto\n");
                        flag = false;
                        for(Libro libro:this.listaLibros){
                            if (Objects.equals(opcion, libro.getTitulo())) {
                                libro.setPrestado(false);   //para volver a cambiar el estado del libro a disponible
                            }
                        }
                        this.listaUsuarios.get(this.indice_Usuario).getLibrosPrestados().remove(opcion);    //para borrar el libro de la lista de libros prestados del usuario
                    }
                }
                if (flag) {
                    System.out.println("Titulo no válido\n");
                }
            }
        }
    }
    public void verLibrosPrestaDOS() {
        if (this.listaUsuarios.get(this.indice_Usuario).getLibrosPrestados().size() < 1) {
            System.out.println("No tiene ningún libro en préstamo");
        } else {
            for(String libro:this.listaUsuarios.get(this.indice_Usuario).getLibrosPrestados()){
                System.out.println(libro);
            }
        }
        System.out.println("\n");
    }
}