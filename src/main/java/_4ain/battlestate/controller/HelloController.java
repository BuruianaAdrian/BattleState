package _4ain.battlestate.controller;

import _4ain.battlestate.view.EnemyView;
import _4ain.battlestate.view.HeroView;
import _4ain.battlestate.view.animation.SpriteAnimation;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.List;

public class HelloController {
    @FXML
    private ImageView heroImage;
    @FXML
    private ImageView enemyImage;

    HeroView heroView;
    List<EnemyView> enemies;

    @FXML
    public void initialize() {
        String[] idleFramesChibi = {
                "/hero/chibi_assassin/animations/IDLE/IDLE1.png",
                "/hero/chibi_assassin/animations/IDLE/IDLE2.png",
                "/hero/chibi_assassin/animations/IDLE/IDLE3.png",
                "/hero/chibi_assassin/animations/IDLE/IDLE4.png"
        };

        HeroView heroView = new HeroView(heroImage, idleFramesChibi);
        heroView.playIdle();

        String[] idleFramesSkeleton = {
                "/enemy/skeleton/animation/IDLE/Animation42.png",
                "/enemy/skeleton/animation/IDLE/Animation43.png",
                "/enemy/skeleton/animation/IDLE/Animation44.png",
                "/enemy/skeleton/animation/IDLE/Animation45.png",
                "/enemy/skeleton/animation/IDLE/Animation46.png",
                "/enemy/skeleton/animation/IDLE/Animation47.png",
                "/enemy/skeleton/animation/IDLE/Animation47.png"
        };

        EnemyView enemyView = new EnemyView(enemyImage, idleFramesSkeleton);
        enemyView.playIdle();

        //"/hero/chibi_assassin/animation/IDLE/IDLE2.png"

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
