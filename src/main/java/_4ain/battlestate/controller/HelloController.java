package _4ain.battlestate.controller;

import _4ain.battlestate.model.Attacco;
import _4ain.battlestate.model.Nemico;
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
    Nemico miko = new Nemico("Miko", 100, Nemico.creaAttacchi(), 100);
    for(
   Attacco a : miko.getAttacchi()) {
       System.out.println(a.getNome() + " - Danno: " + a.calcolaDanno());
   }
}