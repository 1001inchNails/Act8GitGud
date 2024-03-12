import java.util.ArrayList;

public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean prestado;
    private String quienloTieneAhora;



    private ArrayList<String> colaSolicitud = new ArrayList();

    public Libro(String titulo, String autor, String isbn,boolean prestado) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.prestado= prestado;
    }


    public ArrayList<String> getColaSolicitud() {return colaSolicitud;}

    public void setcolaSolicitud(String opcion) {
        this.colaSolicitud.add(opcion);
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isPrestado() {
        return this.prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public String getQuienloTieneAhora() {
        return this.quienloTieneAhora;
    }

    public void setQuienloTieneAhora(String quienloTieneAhora) {
        this.quienloTieneAhora = quienloTieneAhora;
    }

    public String toString() {
        return "Libros{titulo='" + this.titulo + "', autor='" + this.autor + "', isbn='" + this.isbn + "', prestado=" + this.prestado + ", quienloTieneAhora='" + this.quienloTieneAhora + "'}";
    }
}