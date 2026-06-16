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

        while(inGioco){
            System.out.println(partita.getDisplay());
            for(String a : partita.getMessaggi()){
                System.out.println(a);
            }
            Scanner key = new Scanner(System.in);
            int scelta = key.nextInt();
            partita.segliOpzione(scelta);
            if(partita.getStato() == StatoGioco.TurnoNemico){
                partita.scegliOpzioneBot();
            }

            if(partita.getStato() == StatoGioco.Vittoria || partita.getStato() == StatoGioco.Sconfitta){
                inGioco = false;
            }
        }
    }
}
