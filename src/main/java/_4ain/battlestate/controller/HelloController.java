package _4ain.battlestate.controller;

import _4ain.battlestate.model.*;

import java.util.Scanner;

public class HelloController {
    private Partita partita = new Partita();

    public void initialize() {
        game();
    }
    public void game(){
        boolean inGioco = true;
        Scanner key = new Scanner(System.in);

        while(inGioco){
            System.out.println(partita.aggiornaDisplay());
            for(String a : partita.getMenu()){
                System.out.println(a);
            }
            int scelta = key.nextInt();
            partita.scegliOpzione(scelta);
            for(String a : partita.getLogs()){
                System.out.println(a);
            }
            partita.clearLogs();
            if(partita.getStato() == StatoGioco.TurnoNemico){
                partita.scegliOpzioneBot();
                for(String a : partita.getLogs()){
                    System.out.println(a);
                }
                partita.clearLogs();
                //System.out.println(partita.getStato());
            }

            if(partita.getStato() == StatoGioco.Vittoria || partita.getStato() == StatoGioco.Sconfitta ){
                System.out.println(partita.aggiornaDisplay());
                for(String a : partita.getMenu()){
                    System.out.println(a);
                }
                inGioco = false;
            }

        }
    }
}
