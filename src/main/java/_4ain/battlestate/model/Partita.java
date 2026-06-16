package _4ain.battlestate.model;

import java.util.ArrayList;

public class Partita {
    private StatoGioco stato;
    private ArrayList<String> messaggi;

    public Partita(){
        stato = StatoGioco.TurnoGiocatore;
        messaggi = new ArrayList<>();
        setStato(StatoGioco.TurnoGiocatore);
    }
    Nemico nemico = new Nemico("Miko", 100, Nemico.creaAttacchi(),false,100);
    Giocatore giocatore = new Giocatore("Ady", 100, Giocatore.creaAttacchi(), false, 100);
    public void setStato(StatoGioco stato){
        this.stato = stato;
        messaggi.clear();
        switch(stato){
                //stato0
            case stato.TurnoGiocatore:
                messaggi.add("Scegli attacco - turno giocatore");
                int numero = 1;
                for(Attacco a : giocatore.getAttacchi()){
                    messaggi.add(numero++ + ". " + a.getNome());
                }
            break;
                //stato1
            case stato.TurnoNemico:
                messaggi.add("Scegli attacco - turno nemico");
                break;
            //stato2
            case stato.Vittoria:
                messaggi.add("------Vittoria------\n");
                messaggi.add(giocatore.getNome() + " ha vinto");
                break;
            //stato3
            case stato.Sconfitta:
                messaggi.add("------Sconfitta------\n");
                messaggi.add(nemico.getNome() + " ha vinto");
            break;
        }
    }

    public ArrayList<String> getMessaggi() {
        return messaggi;
    }

    public String getDisplay() {
        return "\n------Battle State------\n" +
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
            messaggi.add(giocatore.getNome() + " attacca.\n" );
            if(nemico.isInDifesa()){
                seDifesa(a);
                nemico.setInDifesa(false);
            }else{
                nemico.riceviDanno(a.calcolaDanno());
                messaggi.add(nemico.getNome() + " perde " + a.calcolaDanno() + " di vita.\n");
            }

        }else{
            giocatore.setInDifesa(true);
            messaggi.add(giocatore.getNome() + " si difende.\n");
            setStato(StatoGioco.TurnoNemico);
        }

        controllaVita();

        if(!partitaFinita()){
            setStato(StatoGioco.TurnoNemico);
        }
    }

    public void controllaVita(){
        if(!nemico.èVivo()){
            setStato(StatoGioco.Vittoria);
        } else if (!giocatore.èVivo()) {
            setStato(StatoGioco.Sconfitta);
        }


    }
    //una funzione che scegle in modo random un attacco.
    public void scegliOpzioneBot(){
        int numero = (int) (Math.random() * (nemico.getAttacchi().size() + 1)) + 1;

        if(numero > nemico.getAttacchi().size()) {
            nemico.setInDifesa(true);
            messaggi.add(nemico.getNome() + " si difende.\n");
            setStato(StatoGioco.TurnoGiocatore);
        }else{
            Attacco a = nemico.getAttacchi().get(numero - 1);
            messaggi.add(nemico.getNome() + " attacca.\n" );
            if(giocatore.isInDifesa()){
                seDifesa(a);
                giocatore.setInDifesa(false);
            }else{
                giocatore.riceviDanno(a.calcolaDanno());
                messaggi.add(giocatore.getNome() + " perde " + a.calcolaDanno() + " di vita.\n");
            }

        }
        controllaVita();

        if(!partitaFinita()){
           setStato(StatoGioco.TurnoGiocatore);
        }
    }
    private boolean partitaFinita(){
        return stato == StatoGioco.Vittoria || stato == StatoGioco.Sconfitta;
    }
    //una funzione che calcola il danno se uno dei due e in difesa
    public void seDifesa(Attacco a){
        int dannoFinale;
        StatoGioco stato1= stato;
        switch (stato1){
            case stato.TurnoGiocatore:
                dannoFinale = a.calcolaDanno()/2;
                nemico.riceviDanno(dannoFinale);
                messaggi.add(nemico.getNome() + " perde " + dannoFinale + " di vita.\n");
                break;
            case TurnoNemico:
                dannoFinale = a.calcolaDanno()/2;
                giocatore.riceviDanno(dannoFinale);
                messaggi.add(giocatore.getNome() + " perde " + dannoFinale + " di vita.\n");
                break;
        }

    }

    public StatoGioco getStato() {
        return stato;
    }

    public Nemico getNemico() {
        return nemico;
    }

    public Giocatore getGiocatore() {
        return giocatore;
    }
}
