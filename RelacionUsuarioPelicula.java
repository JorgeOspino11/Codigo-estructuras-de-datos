package Backend;

import java.util.*;

public class RelacionUsuarioPelicula {
    private Map<String, List<String>> grafo;

    public RelacionUsuarioPelicula() {
        grafo = new HashMap<>();
    }

    public void agregarRelacion(String usuario, String pelicula) {
        grafo.putIfAbsent(usuario, new ArrayList<>());
        grafo.putIfAbsent(pelicula, new ArrayList<>());

        grafo.get(usuario).add(pelicula);
        grafo.get(pelicula).add(usuario);
    }

    public Set<String> encontrarUsuariosSimilares(String usuarioInicial) {
        Set<String> similares = new HashSet<>();
        Set<String> visitados = new HashSet<>();
        Queue<String> cola = new LinkedList<>();

        cola.add(usuarioInicial);
        visitados.add(usuarioInicial);

        while (!cola.isEmpty()) {
            String actual = cola.poll();

            for (String vecino : grafo.getOrDefault(actual, new ArrayList<>())) {
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    cola.add(vecino);

                    if (vecino.startsWith("U") && !vecino.equals(usuarioInicial)) {
                        similares.add(vecino);
                    }
                }
            }
        }
        return similares;
    }
}