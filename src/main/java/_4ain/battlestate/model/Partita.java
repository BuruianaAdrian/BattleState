package _4ain.battlestate.model;

import java.util.ArrayList;

public class Partita {
    private StatoGioco stato;
    private ArrayList<String> menu;
    private ArrayList<String> logs;

    public Partita(){
        stato = StatoGioco.TurnoGiocatore;
        menu = new ArrayList<>();
        logs = new ArrayList<>();
        setStato(StatoGioco.TurnoGiocatore);
        setMenu();
    }
    Nemico nemico = new Nemico("Miko", 100, Nemico.creaAttacchi(),false,100);
    Giocatore giocatore = new Giocatore("Ady", 100, Giocatore.creaAttacchi(), false, 100);

    public void setMenu(){
        menu.clear();
        switch(stato){
            case stato.TurnoGiocatore:
                menu.add("Scegli attacco - turno giocatore");
                int numero = 1;
                for(Attacco a : giocatore.getAttacchi()){
                    menu.add(numero++ + ". " + a.getNome());
                }
                break;
            case stato.TurnoNemico:
                menu.add("Turno nemico");
                break;
            case stato.Vittoria:
                menu.add("------Vittoria------\n");
                menu.add(giocatore.getNome() + " ha vinto");
                break;
            case stato.Sconfitta:
                menu.add("------Sconfitta------\n");
                menu.add(nemico.getNome() + " ha vinto");
                break;
        }
    }

    public void setStato(StatoGioco stato){
        this.stato = stato;
    }

    public ArrayList<String> getMenu() {
        return menu;
    }

    public String aggiornaDisplay(){
        return "\n------Battle State------\n" +
                giocatore.getNome() +
                " HP:" + giocatore.getHp() +
                " EN:" + giocatore.getEnergia() +
                "\n" +
                nemico.getNome() +
                " HP:" + nemico.getHp() +
                " EN:" + nemico.getEnergia();
    }
//    public String getDisplay() {
//        return "\n------Battle State------\n" +
//                giocatore.getNome() +
//                " HP:" + giocatore.getHp() +
//                " EN:" + giocatore.getEnergia() +
//                "\n" +
//                nemico.getNome() +
//                " HP:" + nemico.getHp() +
//                " EN:" + nemico.getEnergia();
//    }

    public void scegliOpzione(int indice){
        if(indice <= giocatore.getAttacchi().size()){
            Attacco a = giocatore.getAttacchi().get(indice - 1);
            logs.add(giocatore.getNome() + " attacca.\n" );
            if(nemico.isInDifesa()){
                seDifesa(a);
                nemico.setInDifesa(false);
            }else{
                nemico.riceviDanno(a.calcolaDanno());
                logs.add(nemico.getNome() + " perde " + a.calcolaDanno() + " di vita.\n");
            }

        }else{
            giocatore.setInDifesa(true);
            logs.add(giocatore.getNome() + " si difende.\n");
        }

        controllaVita();
        if(!partitaFinita()){
            setStato(StatoGioco.TurnoNemico);
            setMenu();
        }
    }

    public void controllaVita(){
        if(!nemico.èVivo()){
            setStato(StatoGioco.Vittoria);
            setMenu();
        } else if (!giocatore.èVivo()) {
            setStato(StatoGioco.Sconfitta);
            setMenu();
        }


    }
    //una funzione che scegle in modo random un attacco.
    public void scegliOpzioneBot(){
        int numero = (int) (Math.random() * (nemico.getAttacchi().size() + 1)) + 1;

        if(numero > nemico.getAttacchi().size()) {
            nemico.setInDifesa(true);
            logs.add(nemico.getNome() + " si difende.\n");
        }else{
            Attacco a = nemico.getAttacchi().get(numero - 1);
            logs.add(nemico.getNome() + " attacca.\n" );
            if(giocatore.isInDifesa()){
                seDifesa(a);
                giocatore.setInDifesa(false);
            }else{
                giocatore.riceviDanno(a.calcolaDanno());
                logs.add(giocatore.getNome() + " perde " + a.calcolaDanno() + " di vita.\n");
            }

        }
        controllaVita();

        if(!partitaFinita()){
           setStato(StatoGioco.TurnoGiocatore);
           setMenu();
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
                logs.add(nemico.getNome() + " perde " + dannoFinale + " di vita.\n");
                break;
            case TurnoNemico:
                dannoFinale = a.calcolaDanno()/2;
                giocatore.riceviDanno(dannoFinale);
                logs.add(giocatore.getNome() + " perde " + dannoFinale + " di vita.\n");
                break;
        }
    }

    public ArrayList<String> getLogs() {
        return logs;
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
    public void clearLogs(){
        logs.clear();
    }
}
