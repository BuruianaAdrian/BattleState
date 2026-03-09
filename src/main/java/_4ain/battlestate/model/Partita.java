package _4ain.battlestate.model;

import java.util.ArrayList;

public class Partita {
    private int stato;
    private String display;
    private ArrayList<String> opzioni;

    public Partita(){
        stato = 0;
        display = "------Battle State------";
        opzioni = new ArrayList<>();
        setStato(0);
    }
    Nemico nemico = new Nemico("Miko", 100, Nemico.creaAttacchi(), 100);
    Giocatore giocatore = new Giocatore("Ady", 100, Giocatore.creaAttacchi(), 100);
    public void setStato(int stato){
        opzioni.clear();
        switch(stato){
                //stato1
            case 0:
                opzioni.add("Scegli attacco - turno giocatore");
                int numero = 1;
                for(Attacco a : nemico.getAttacchi()){
                    opzioni.add(numero++ + ". " + a.getNome());
                }
            break;
                //stato2
            case 1:
                opzioni.add("Scegli attacco - turno nemico");
                int numero2 = 1;
                for(Attacco a : giocatore.getAttacchi()){
                    opzioni.add(numero2++ + ". " + a.getNome());
                }
                break;
            default:
                System.out.println("Opzione non valida");
        }
    }

    public ArrayList<String> getOpzioni() {
        return opzioni;
    }
}
