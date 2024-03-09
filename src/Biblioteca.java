import java.util.Scanner;

public class Biblioteca {
    public Biblioteca() {
    }

    public void menu() {
        boolean flag = true;
        Modelo.getInstance().identificarUsuario();

        while(flag) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Seleccione opción\n1. Ver libros\n2. Ver libros por devolver\n3. Pedir libro\n4. Devolver libro\n5. Salir");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    Modelo.getInstance().verTodosLibros();
                    break;
                case 2:
                    Modelo.getInstance().verLibrosPrestaDOS();
                    break;
                case 3:
                    Modelo.getInstance().pedirLibro();
                    break;
                case 4:
                    Modelo.getInstance().devolverLibro();
                    break;
                case 5:
                    flag = false;
            }
        }

    }
}
