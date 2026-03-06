package _4ain.battlestate.model;

import java.util.ArrayList;

public class Giocatore extends Personaggio{

    public Giocatore(String nome, int hp, ArrayList<Attacco> attacchi, int difesa) {
        super(nome, hp, attacchi, difesa);
    }
    public static ArrayList<Attacco> creaAttacchi() {
        ArrayList<Attacco> lista = new ArrayList<>();
        lista.add(new Attacco("Spada", 30, TipoAttaco.FISICO));
        lista.add(new Attacco("Pistola", 40, TipoAttaco.FISICO));
        return lista;
    }

    public ArrayList<Attacco> getAttacchi(){
        ArrayList<Attacco> attacchi = creaAttacchi();
        return attacchi;
    }


}
