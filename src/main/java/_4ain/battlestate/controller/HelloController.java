package _4ain.battlestate.controller;

import _4ain.battlestate.model.Attacco;
import _4ain.battlestate.model.Nemico;
import _4ain.battlestate.model.Partita;
import _4ain.battlestate.model.StatoGioco;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

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
            for(String a : partita.getOpzioni()){
                System.out.println(a);
            }
            Scanner key = new Scanner(System.in);
            int scelta = key.nextInt();
            partita.segliOpzione(scelta);

        }
    }
}
