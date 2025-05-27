package Backend;

import java.util.*;

public class Usuario {
    private String nombre;
    private List<String> favoritos = new ArrayList<>();

    // Constructor
    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarFavorito(String pelicula) {
        favoritos.add(pelicula);
    }

    public List<String> getFavoritos() {
        return favoritos;
    }

    public Map<String, Integer> getCalificaciones() {
        return calificaciones;
    }

    public void agregarAlHistorial(String pelicula) {
        historial.add(pelicula);
    }

    public void agregarAFavoritos(String pelicula) {
        if (!favoritos.contains(pelicula)) {
            favoritos.add(pelicula);
        }
    }

    public void agregarCalificacion(String pelicula, int calificacion) {
        calificaciones.put(pelicula, calificacion);
    }

    public Integer obtenerCalificacion(String pelicula) {
        return calificaciones.getOrDefault(pelicula, null);
    }
}
