package _4ain.battlestate.model;

import java.util.ArrayList;

public class Partita {
    private StatoGioco stato;
    private ArrayList<String> opzioni;

    public Partita(){
        stato = StatoGioco.TurnoGiocatore;
        opzioni = new ArrayList<>();
        setStato(StatoGioco.TurnoGiocatore);
    }
    Nemico nemico = new Nemico("Miko", 100, Nemico.creaAttacchi(),false,100);
    Giocatore giocatore = new Giocatore("Ady", 100, Giocatore.creaAttacchi(), false, 100);
    public void setStato(StatoGioco stato){
        opzioni.clear();
        switch(stato){
                //stato0
            case stato.TurnoGiocatore:
                opzioni.add("Scegli attacco - turno giocatore");
                int numero = 1;
                for(Attacco a : giocatore.getAttacchi()){
                    opzioni.add(numero++ + ". " + a.getNome());
                }
            break;
                //stato1
            case stato.TurnoNemico:
                opzioni.add("Scegli attacco - turno nemico");
                int numero2 = 1;
                for(Attacco a : nemico.getAttacchi()){
                    opzioni.add(numero2++ + ". " + a.getNome());
                }

                break;
            //stato2
            case stato.Vittoria:
                opzioni.add(giocatore.getNome() + "ha vinto");
                break;
            //stato3
            case stato.Sconfitta:
                opzioni.add(nemico.getNome() + "ha vinto");
            break;
        }
    }

    public ArrayList<String> getOpzioni() {
        return opzioni;
    }

    public String getDisplay() {
        return "------Battle State------\n" +
                giocatore.getNome() +
                " HP:" + giocatore.getHp() +
                " EN:" + giocatore.getEnergia() +
                "\n" +
                nemico.getNome() +
                " HP:" + nemico.getHp() +
                " EN:" + nemico.getEnergia();
    }

    public void segliOpzione(int indice){
        if(indice <= giocatore.getAttacchi().size()){
            Attacco a = giocatore.getAttacchi().get(indice - 1);
            nemico.riceviDanno(a.calcolaDanno());
        }else{
            giocatore.setInDifesa(true);
        }
        setStato(StatoGioco.TurnoNemico);
    }
}
