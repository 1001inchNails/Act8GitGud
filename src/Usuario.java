import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private ArrayList<String> librosPrestados = new ArrayList();

    public Usuario(String nombre, String apellido, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }

    public ArrayList<String> getLibrosPrestados() {
        return this.librosPrestados;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLibrosPrestados(String opcion) {
        this.librosPrestados.add(opcion);
    }

    public String toString() {
        return "Usuario{nombre='" + this.nombre + "', apellido='" + this.apellido + "', telefono='" + this.telefono + "', email='" + this.email + "', librosPrestados=" + String.valueOf(this.librosPrestados) + "}";
    }
}