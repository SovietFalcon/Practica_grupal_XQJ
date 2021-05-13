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
        expression = "doc('/db/practica/trainerdex.xml')/trainers/trainer";
        xqrs = xqe.executeQuery(expression);

        while (xqrs.next()) {
            Trainer trainer = new Trainer();
            trainerList.add(trainer);

        }

        for (int i = 0; i < trainerList.size(); i++) {
            //name
            expression = "doc('/db/practica/trainerdex.xml')/trainers/trainer/name/string()";
            xqrs = xqe.executeQuery(expression);
            while (xqrs.next()) {
                trainerList.get(i).nombre = xqrs.getItemAsString(null);
            }

            //title
            expression = "doc('/db/practica/trainerdex.xml')/trainers/trainer/title/string()";
            xqrs = xqe.executeQuery(expression);
            while (xqrs.next()) {
                trainerList.get(i).titulo = xqrs.getItemAsString(null);
            }

            //pokemons
            expression = "doc('/db/practica/trainerdex.xml')/trainers/belt/pokemon/species/string()";
            xqrs = xqe.executeQuery(expression);
            while (xqrs.next()) {
                trainerList.get(i).pokemons = xqrs.getItemAsString(null);
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



    public void nuevoAtaquePokemonEntrenado() throws XQException { //te pide entrenador y nombre de pokemon; se piden datos del ataque
    }



    public void olvidaAtaquePokemonEntrenado() throws XQException { //te pide entrenador, nombre de pokemon y nombre del ataque pa borrarlo
    }


    /*
    public List<Emp> treureEmpleats(String codi) throws XQException, ParseException {

        XQExpression xqe = conn.createExpression();
        String expression;
        XQResultSequence xqrs;
        List<Emp> emplist = new ArrayList<>();

        //empleats
        expression = "doc('/db/empresa/empresa.xml')/empresa/empleats/emp[@dept='"+codi+"']/@codi/string()";
        xqrs = xqe.executeQuery(expression);

        while (xqrs.next()) {
            Emp emp = new Emp();
            emp.codi = xqrs.getItemAsString(null);
            emplist.add(emp);

        }

        for (int i = 0; i < emplist.size(); i++) {
            //dept/cap
            emplist.get(i).dept = codi;
            expression = "doc('/db/empresa/empresa.xml')/empresa/empleats/emp[@codi='"+emplist.get(i).codi+"']/@cap/string()";
            xqrs = xqe.executeQuery(expression);
            while (xqrs.next()) {
                emplist.get(i).cap = xqrs.getItemAsString(null);
            }

            //cognom
            expression = "doc('/db/empresa/empresa.xml')/empresa/empleats/emp[@codi='"+emplist.get(i).codi+"']/cognom/string()";
            xqrs = xqe.executeQuery(expression);
            while (xqrs.next()) {
                emplist.get(i).cognom = xqrs.getItemAsString(null);
            }

            //ofici
            expression = "doc('/db/empresa/empresa.xml')/empresa/empleats/emp[@codi='"+emplist.get(i).codi+"']/ofici/string()";
            xqrs = xqe.executeQuery(expression);
            while (xqrs.next()) {
                emplist.get(i).ofici = xqrs.getItemAsString(null);
            }

            //dataalta
            expression = "doc('/db/empresa/empresa.xml')/empresa/empleats/emp[@codi='"+emplist.get(i).codi+"']/dataAlta/string()";
            xqrs = xqe.executeQuery(expression);
            while (xqrs.next()) {
                emplist.get(i).dataAlta = new SimpleDateFormat("yyyy-MM-dd").parse(xqrs.getItemAsString(null));
            }

            //salari
            expression = "doc('/db/empresa/empresa.xml')/empresa/empleats/emp[@codi='"+emplist.get(i).codi+"']/salari/string()";
            xqrs = xqe.executeQuery(expression);
            while (xqrs.next()) {
                emplist.get(i).salari = Integer.parseInt(xqrs.getItemAsString(null));
            }

            //comissio
            expression = "doc('/db/empresa/empresa.xml')/empresa/empleats/emp[@codi='"+emplist.get(i).codi+"']/comissio/string()";
            xqrs = xqe.executeQuery(expression);
            while (xqrs.next()) {
                emplist.get(i).comissio = Integer.parseInt(xqrs.getItemAsString(null));
            }

        }

        return emplist;
    }

     */

    /*
    public List<Emp> editarEmpleats(List<Emp> empList, String codi, String noucodi) throws XQException {

        for (int i = 0; i < empList.size(); i++) {
            empList.get(i).dept = noucodi;
        }

        XQExpression xqe = conn.createExpression();
        String update2 = "update value \n"
                + "doc('/db/empresa/empresa.xml')/empresa/empleats/emp[@dept=\"" + codi + "\"]/@dept \n" +
                "with '"+noucodi+"'";
        xqe.executeCommand(update2);

        return empList;
    }

    public void esborrarEmpleats(String codi) throws XQException {

        XQExpression xqe = conn.createExpression();
        String delete = "update delete \n"
                + "doc('/db/empresa/empresa.xml')/empresa/empleats/emp[@dept=\"" + codi + "\"]";
        xqe.executeCommand(delete);
    }

     */

    public void tancarSessio() throws XQException {
        System.out.println("Tancant sessió . . .");
        conn.close();
    }
}
