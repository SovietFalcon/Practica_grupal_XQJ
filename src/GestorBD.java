import net.xqj.exist.ExistXQDataSource;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.xquery.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorCompletionService;

public class GestorBD {
    XQDataSource xqs;
    XQConnection conn;

    public GestorBD() throws XQException {
        xqs = new ExistXQDataSource();

        xqs.setProperty("serverName", "192.168.56.1");
        xqs.setProperty("port", "8080");
        conn = xqs.getConnection("admin","");
    }



    public void mostrarPokemons() throws XQException { //david
        XQExpression xqe = conn.createExpression();
        Pokemon pkmn = new Pokemon();

        String especie = "doc('/db/practica/pokedex.xml')/pokedex/pokemon/species";
        String nDex = "doc('/db/practica/pokedex.xml')/pokedex/pokemon/species";
        String tipos = "doc('/db/practica/pokedex.xml')/pokedex/pokemon/species";
        String habilidades = "doc('/db/practica/pokedex.xml')/pokedex/pokemon/species";
        String statsBase = "doc('/db/practica/pokedex.xml')/pokedex/pokemon/species";
        String experiencia = "doc('/db/practica/pokedex.xml')/pokedex/pokemon/species";



    }
    //  /db/practica/



    public List<Trainer> mostrarEntrenadores() throws XQException {
        XQExpression xqe = conn.createExpression();
        String expression;
        XQResultSequence xqrs;
        List<Trainer> trainerList = new ArrayList<>();

        //trainers
        expression = "doc('/db/practica/trainerdex.xml')/trainers/trainer/name/string()";
        xqrs = xqe.executeQuery(expression);

        while (xqrs.next()) {
            Trainer trainer = new Trainer();
            trainer.nombre = xqrs.getItemAsString(null);
            trainerList.add(trainer);

        }

        for (int i = 0; i < trainerList.size(); i++) {
            //title
            expression = "doc('/db/practica/trainerdex.xml')/trainers/trainer[name=\""+trainerList.get(i).nombre+"\"]/title/string()";
            xqrs = xqe.executeQuery(expression);
            while (xqrs.next()) {
                trainerList.get(i).titulo = xqrs.getItemAsString(null);
                //System.out.println(xqrs.getItemAsString(null));
            }

            //pokemons
            expression = "doc('/db/practica/trainerdex.xml')/trainers/trainer[name=\""+trainerList.get(i).nombre+"\"]/belt/pokemon/species/string()";
            xqrs = xqe.executeQuery(expression);
            List<String> listapokemons = new ArrayList<>();
            while (xqrs.next()) {
                listapokemons.add(xqrs.getItemAsString(null));
            }

            for (String pok : listapokemons) {
                if (trainerList.get(i).pokemons == null) trainerList.get(i).pokemons = pok + ";";
                else trainerList.get(i).pokemons += pok + ";";

            }



        }

        return trainerList;

    }



    public void mostrarAtaques() throws XQException { //david
    }



    public void mostrarPokemonsconAtaques() throws XQException { //david
    }



    public void cambiarEspeciePokemon() throws XQException { //david
    }



    public void nuevoAtaquePokemonEntrenado() throws XQException {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nombre del entrenador que posee el pokemon: ");
        String entrenador = scanner.nextLine();
        System.out.print("Nombre del pokemon: ");
        String pokemon = scanner.nextLine();
        System.out.print("Nombre del ataque: ");
        String nombreataque = scanner.nextLine();
        System.out.print("Tipo del ataque: ");
        String tipoataque = scanner.nextLine();
        System.out.print("PP del ataque: ");
        String ppataque = scanner.nextLine();

        XQExpression xqe = conn.createExpression();
        String insert = "update insert \n"+
                "<attack>\n" +
                "\t<name>" + nombreataque + "</name>\n" +
                "\t<type>" + tipoataque + "</type>\n" +
                "\t<PP>" + ppataque + "</PP>\n" +
                "</attack>" +
                "preceding doc('/db/practica/trainerdex.xml')/trainers/trainer[name=\""+ entrenador + "\"]/belt/pokemon[name=\""+ pokemon +"\"]/attacks/attack[1]";

        xqe.executeCommand(insert);
    }



    public void olvidaAtaquePokemonEntrenado() throws XQException {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nombre del entrenador que posee el pokemon: ");
        String entrenador = scanner.nextLine();
        System.out.print("Nombre del pokemon: ");
        String pokemon = scanner.nextLine();
        System.out.print("Nombre del ataque: ");
        String nombreataque = scanner.nextLine();


        XQExpression xqe = conn.createExpression();
        String delete = "update delete \n"
                + "doc('/db/practica/trainerdex.xml')/trainers/trainer[name=\""+ entrenador + "\"]/belt/pokemon[name=\""+ pokemon +"\"]/attacks/attack[name=\"" + nombreataque + "\"]";
        xqe.executeCommand(delete);
    }



    public void tancarSessio() throws XQException {
        System.out.println("Tancant sessió . . .");
        conn.close();
    }
}
