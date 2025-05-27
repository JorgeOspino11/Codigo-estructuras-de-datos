import java.util.*;

public class SistemaRecomendacion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TablaHashUsuario tablaUsuarios = new TablaHashUsuario();
        RelacionUsuarioPelicula grafo = new RelacionUsuarioPelicula();
        ListaDinamicaHistorial historial = new ListaDinamicaHistorial();

        while (true) {
            System.out.println("--- Menú de Recomendación de Películas ---");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Agregar relación usuario-película");
            System.out.println("3. Calificar película");
            System.out.println("4. Ver historial de un usuario");
            System.out.println("5. Ver favoritos de un usuario");
            System.out.println("6. Ver usuarios similares");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre del usuario: ");
                    String nombre = scanner.nextLine();
                    Usuario nuevo = new Usuario(nombre);
                    System.out.print("Ingrese sus películas favoritas (separadas por comas): ");
                    String favoritasInput = scanner.nextLine();
                    String[] favoritas = favoritasInput.split(",");
                    for (String fav : favoritas) {
                        nuevo.agregarFavorito(fav.trim());
                    }
                    tablaUsuarios.insertarUsuario(nombre, nuevo);
                    break;
                


                case 2:
                    System.out.print("Nombre del usuario: ");
                    String usuario = scanner.nextLine();
                    System.out.print("Nombre de la película: ");
                    String pelicula = scanner.nextLine();
                    grafo.agregarRelacion(usuario, pelicula);
                    historial.agregarAHistorial(usuario, pelicula);
                    break;

                case 3:
                    System.out.print("Nombre del usuario: ");
                    String user = scanner.nextLine();
                    System.out.print("Película a calificar: ");
                    String pelic = scanner.nextLine();
                    System.out.print("Calificación (1-5): ");
                    int calif = scanner.nextInt();
                    scanner.nextLine();
                    tablaUsuarios.agregarCalificacion(user, pelic, calif);
                    break;

                case 4:
                    System.out.print("Nombre del usuario: ");
                    String usu = scanner.nextLine();
                    System.out.println("Historial: " + historial.mostrarHistorial(usu));
                    break;

                case 5:
                    System.out.print("Nombre del usuario: ");
                    String usuFav = scanner.nextLine();
                    System.out.println("Favoritos: " + tablaUsuarios.obtenerFavoritos(usuFav));
                
                case 6:
                    System.out.print("Nombre del usuario: ");
                    String uSim = scanner.nextLine();
                    System.out.println("Usuarios similares: " + grafo.encontrarUsuariosSimilares(uSim));
                    break;

                case 0:
                    System.out.println("Saliendo del sistema.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}

