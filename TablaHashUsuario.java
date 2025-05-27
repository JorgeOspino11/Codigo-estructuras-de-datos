package Backend;

import java.util.*;

public class TablaHashUsuario {
    private Map<String, Usuario> tabla;

    public TablaHashUsuario() {
        tabla = new HashMap<>();
    }

    public void insertarUsuario(String nombre, Usuario usuario) {
        tabla.put(nombre, usuario);
    }

    public Usuario obtenerUsuario(String nombre) {
        return tabla.get(nombre);
    }

    public void agregarCalificacion(String nombreUsuario, String pelicula, int calificacion) {
        Usuario usuario = tabla.get(nombreUsuario);
        if (usuario != null) {
            usuario.agregarCalificacion(pelicula, calificacion);
        }
    }

    public List<String> obtenerFavoritos(String nombreUsuario) {
        Usuario u = buscarUsuario(nombreUsuario);
        if (u != null) {
            return u.getFavoritos();
        }
        return new ArrayList<>();
    }
    
}