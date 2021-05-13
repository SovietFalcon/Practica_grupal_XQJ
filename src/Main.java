import javax.xml.xquery.XQException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws XQException {

        GestorBD gestorBD = new GestorBD();
        Scanner scanner = new Scanner(System.in);
        boolean open = true;

        while (open) {
            System.out.println("//////////////////\n// Pokemon App //\nHecho en Java/XQJ por David Álvarez e Iván Campos\n\n" +
                    "1. Mostrar lista de pokemons\n" +
                    "2. Mostrar lista de entrenadores\n" +
                    "3. Mostrar lista de ataques\n" +
                    "4. Mostrar lista de pokemons con ataques\n" +
                    "5. Cambiar especie de pokemon\n" +
                    "6. Crear ataque de pokemon\n" +
                    "7. Borrar ataque de pokemon\n");

            String menu = scanner.next();

            switch (menu) {

                case "1":
                    gestorBD.mostrarPokemons();
                    break;
                case "2":
                    System.out.println(gestorBD.mostrarEntrenadores());
                    break;
                case "3":
                    gestorBD.mostrarAtaques();
                    break;
                case "4":
                    gestorBD.mostrarPokemonsconAtaques();
                    break;
                case "5":
                    gestorBD.cambiarEspeciePokemon();
                    break;
                case "6":
                    gestorBD.nuevoAtaquePokemonEntrenado();
                    break;
                case "7":
                    gestorBD.olvidaAtaquePokemonEntrenado();
                    break;
                case "8":
                    gestorBD.tancarSessio();
                    open = false;
            }

        }

    }
}
