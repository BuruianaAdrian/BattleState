package _4ain.battlestate.model;

import java.util.ArrayList;

public class Nemico extends Personaggio{

    public Nemico(String nome, int hp, ArrayList<Attacco> attacchi, boolean inDifesa, int energia) {
        super(nome, hp, attacchi, inDifesa, energia);
    }
    public static ArrayList<Attacco> creaAttacchi() {
        ArrayList<Attacco> lista = new ArrayList<>();
        lista.add(new Attacco("Jab", 20, 12,TipoAttaco.FISICO));
        lista.add(new Attacco("Cross", 30,16,TipoAttaco.FISICO));

        return lista;
    }

}
