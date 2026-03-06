package _4ain.battlestate.model;

import java.util.ArrayList;

public class Nemico extends Personaggio{

    public Nemico(String nome, int hp, ArrayList<Attacco> attacchi, int difesa) {
        super(nome, hp, attacchi, difesa);
    }
    public static ArrayList<Attacco> creaAttacchi() {
        ArrayList<Attacco> lista = new ArrayList<>();
        lista.add(new Attacco("Fuoco", 50, TipoAttaco.MAGICO));
        lista.add(new Attacco("Veleno", 50, TipoAttaco.MAGICO));
        return lista;
    }

}
