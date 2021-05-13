import javax.xml.xquery.XQException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws XQException {

        GestorBD gestorBD = new GestorBD();
        Scanner scanner = new Scanner(System.in);
        boolean open = true;

        while (open) {
            System.out.println("" +
                    "1. a\n" +
                    "2. a\n" +
                    "3. a\n" +
                    "4. a\n");

            String menu = scanner.next();

            switch (menu) {

                case "1":
                    gestorBD.mostrarPokemons();
                    break;
                case "2":
                    gestorBD.mostrarEntrenadores();
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
