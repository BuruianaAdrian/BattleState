package _4ain.battlestate.model;

import java.util.ArrayList;

public class Giocatore extends Personaggio{


    public Giocatore(String nome, int hp, ArrayList<Attacco> attacchi, boolean inDifesa, int energia) {
        super(nome, hp, attacchi, inDifesa, energia);
    }

    public static ArrayList<Attacco> creaAttacchi() {

        ArrayList<Attacco> lista = new ArrayList<>();

        lista.add(
                new Attacco("Slash", 15, 10, TipoAttaco.FISICO)
        );

        lista.add(
                new Attacco("Fire", 21, 20, TipoAttaco.MAGICO)
        );

        lista.add(
                new Attacco("Special", 35, 40, TipoAttaco.SPECIAL)
        );

        return lista;
    }


}
