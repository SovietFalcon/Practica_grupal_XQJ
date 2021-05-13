import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    String especie;
    String nDex;
    String tipos;
    String habilidades;
    String statsBase;
    String experiencia;
    List<Attack> attackList = new ArrayList<>();


    @Override
    public String toString() {
        return "Pokemon{" +
                "especie='" + especie + '\'' +
                ", nDex='" + nDex + '\'' +
                ", tipos='" + tipos + '\'' +
                ", habilidades='" + habilidades + '\'' +
                ", statsBase='" + statsBase + '\'' +
                ", experiencia='" + experiencia + '\'' +
                ", attackList=" + attackList +
                '}';
    }
}
