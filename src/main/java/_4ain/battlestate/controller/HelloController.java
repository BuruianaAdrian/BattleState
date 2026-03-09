package _4ain.battlestate.controller;

import _4ain.battlestate.model.Attacco;
import _4ain.battlestate.model.Nemico;
import _4ain.battlestate.model.Partita;
import _4ain.battlestate.model.StatoGioco;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    private Partita partita = new Partita();
    @FXML
    public void initialize() {
        for(String a: partita.getOpzioni()){
            System.out.println(a);
        }
    }

    /*
    Stato 0:
        - Inizializza giocatore e nemico (vita, difesa...)

    Stato 1 Turno del giocatore:
        - Il giocatore sceglie un attacco
        - Il danno viene applicato al nemico
        - Se il nemico scende a 0 HP Vittoria

    Stato 2 Turno del nemico:
        - Il nemico sceglie un attacco
        - Il danno viene applicato al giocatore
        - Se il giocatore scende a 0 HP Sconfitta

    Stato 3 – Fine partita:
        - Mostra risultato (vittoria o sconfitta)
*/
}
