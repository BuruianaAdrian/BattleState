package _4ain.battlestate.controller;

import _4ain.battlestate.view.animation.SpriteAnimation;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HelloController {
    @FXML
    private ImageView heroImage;

    private Image frame1;
    private Image frame2;

    @FXML
    private SpriteAnimation heroIdle;
    private SpriteAnimation heroEnemy;

    @FXML
    public void initialize() {

        String[] idleFramesChibi = {

                "/hero/chibi_assassin/animations/IDLE/IDLE1.png",
                "/hero/chibi_assassin/animations/IDLE/IDLE2.png",
                "/hero/chibi_assassin/animations/IDLE/IDLE3.png",
                "/hero/chibi_assassin/animations/IDLE/IDLE4.png"
        };

        heroIdle = new SpriteAnimation(
                heroImage,
                idleFramesChibi,
                8
        );

        String[] idleFramesBat = {

                "/hero/chibi_assassin/animations/IDLE/IDLE1.png",
                "/hero/chibi_assassin/animations/IDLE/IDLE2.png",
                "/hero/chibi_assassin/animations/IDLE/IDLE3.png",
                "/hero/chibi_assassin/animations/IDLE/IDLE4.png"
        };

        heroIdle = new SpriteAnimation(
                heroImage,
                idleFramesChibi,
                8
        );
        heroIdle.play();
        //"/hero/chibi_assassin/animations/IDLE/IDLE2.png"

    }
//    private Partita partita = new Partita();
//
//    public void initialize() {
//        game();
//    }
//    public void game(){
//        boolean inGioco = true;
//        Scanner key = new Scanner(System.in);
//
//        while(inGioco){
//            System.out.println(partita.aggiornaDisplay());
//            for(String a : partita.getMenu()){
//                System.out.println(a);
//            }
//            int scelta = key.nextInt();
//            partita.scegliOpzione(scelta);
//            for(String a : partita.getLogs()){
//                System.out.println(a);
//            }
//            partita.clearLogs();
//            if(partita.getStato() == StatoGioco.TurnoNemico){
//                partita.scegliOpzioneBot();
//                for(String a : partita.getLogs()){
//                    System.out.println(a);
//                }
//                partita.clearLogs();
//                //System.out.println(partita.getStato());
//            }
//
//            if(partita.getStato() == StatoGioco.Vittoria || partita.getStato() == StatoGioco.Sconfitta ){
//                System.out.println(partita.aggiornaDisplay());
//                for(String a : partita.getMenu()){
//                    System.out.println(a);
//                }
//                inGioco = false;
//            }
//
//        }
//    }
}
