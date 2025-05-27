package Backend;

import java.util.*;

public class ListaDinamicaHistorial {
    private Map<String, List<String>> historial;
    private Map<String, List<String>> favoritos;

    public ListaDinamicaHistorial() {
        historial = new HashMap<>();
        favoritos = new HashMap<>();
    }

    public void agregarAHistorial(String usuario, String pelicula) {
        historial.putIfAbsent(usuario, new ArrayList<>());
        historial.get(usuario).add(pelicula);
    }

    public void agregarAFavoritos(String usuario, String pelicula) {
        favoritos.putIfAbsent(usuario, new ArrayList<>());
        List<String> fav = favoritos.get(usuario);
        if (!fav.contains(pelicula)) {
            fav.add(pelicula);
        }
    }

    public List<String> mostrarHistorial(String usuario) {
        return historial.getOrDefault(usuario, new ArrayList<>());
    }

    public List<String> mostrarFavoritos(String usuario) {
        return favoritos.getOrDefault(usuario, new ArrayList<>());
    }
}

