package _4ain.battlestate.model;

import java.util.ArrayList;

public class Nemico extends Personaggio{

    public Nemico(String nome, int hp, ArrayList<Attacco> attacchi, boolean inDifesa, int energia) {
        super(nome, hp, attacchi, inDifesa, energia);
    }
    public static ArrayList<Attacco> creaAttacchi() {
        ArrayList<Attacco> lista = new ArrayList<>();
        lista.add(new Attacco("Fuoco", 20, 6,TipoAttaco.MAGICO));
        lista.add(new Attacco("Veleno", 30,9 ,TipoAttaco.MAGICO));
        lista.add(new Attacco("BO", 40,10,TipoAttaco.FISICO));
        return lista;
    }

}
