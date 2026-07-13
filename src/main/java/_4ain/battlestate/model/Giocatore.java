package _4ain.battlestate.model;

import java.util.ArrayList;

public class Giocatore extends Personaggio{


    public Giocatore(String nome, int hp, ArrayList<Attacco> attacchi, boolean inDifesa, int energia) {
        super(nome, hp, attacchi, inDifesa, energia);
    }

    public static ArrayList<Attacco> creaAttacchi() {
        ArrayList<Attacco> lista = new ArrayList<>();
        lista.add(new Attacco("Pugno", 10, 0,TipoAttaco.FISICO));
        lista.add(new Attacco("Calcio", 30, 80,TipoAttaco.FISICO));
        lista.add(new Attacco("Spada", 50, 30,TipoAttaco.FISICO));
        return lista;
    }


}
