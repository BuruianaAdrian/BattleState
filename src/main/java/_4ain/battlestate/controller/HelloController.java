package _4ain.battlestate.controller;

import _4ain.battlestate.view.EnemyView;
import _4ain.battlestate.view.HeroView;
import _4ain.battlestate.view.animation.SpriteAnimation;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

import java.util.List;

public class HelloController {
    @FXML
    private ImageView heroImage;
    @FXML
    private ImageView enemyImage;
    @FXML
    private ImageView fireProjectile;
    @FXML
    private ImageView specialProjectile;

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

        String[] slashFramesChibi = {
                "/hero/chibi_assassin/animations/SlashAttack/slash_attack1.png",
                "/hero/chibi_assassin/animations/SlashAttack/slash_attack2.png",
                "/hero/chibi_assassin/animations/SlashAttack/slash_attack3.png",
                "/hero/chibi_assassin/animations/SlashAttack/slash_attack4.png",
                "/hero/chibi_assassin/animations/SlashAttack/slash_attack5.png",
                "/hero/chibi_assassin/animations/SlashAttack/slash_attack6.png"
        };

        String[] fireFramesChibi = {
                "/hero/chibi_assassin/animations/Throw/throw attack1.png",
                "/hero/chibi_assassin/animations/Throw/throw attack2.png",
                "/hero/chibi_assassin/animations/Throw/throw attack3.png",
                "/hero/chibi_assassin/animations/Throw/throw attack4.png"
        };

        String[] defendFramesChibi = {
                "/hero/chibi_assassin/animations/Block/Block1.png",
                "/hero/chibi_assassin/animations/Block/Block2.png"

        };

        String[] specialFramesChibi = {
                "/hero/chibi_assassin/animations/Throw/throw attack1.png",
                "/hero/chibi_assassin/animations/Throw/throw attack2.png",
                "/hero/chibi_assassin/animations/Throw/throw attack3.png",
                "/hero/chibi_assassin/animations/Throw/throw attack4.png"
        };


        heroView = new HeroView(heroImage, idleFramesChibi,slashFramesChibi,fireFramesChibi,defendFramesChibi,specialFramesChibi );
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

    }

    private void launchFire() {

        // Riporta il proiettile alla posizione iniziale
        fireProjectile.setTranslateX(0);
        fireProjectile.setTranslateY(0);

        // Fa comparire il fuoco
        fireProjectile.setVisible(true);

        TranslateTransition movement =
                new TranslateTransition(
                        Duration.millis(850),
                        fireProjectile
                );

        // Per ora facciamolo semplicemente andare verso destra
        movement.setByX(450);

        movement.setOnFinished(event -> {

            // Arrivato a destinazione → sparisce
            fireProjectile.setVisible(false);

            // Torna alla posizione iniziale
            fireProjectile.setTranslateX(0);
            fireProjectile.setTranslateY(0);
        });

        movement.play();
    }

    private void launchSpecial() {

        // Posizione iniziale
        specialProjectile.setTranslateX(0);
        specialProjectile.setTranslateY(0);

        // Fa apparire Ice Dagger
        specialProjectile.setVisible(true);

        TranslateTransition movement =
                new TranslateTransition(
                        Duration.millis(550),
                        specialProjectile
                );

        // Va verso lo Skeleton
        movement.setByX(450);

        movement.setOnFinished(event -> {

            // Arrivato allo Skeleton sparisce
            specialProjectile.setVisible(false);

            // Reset posizione
            specialProjectile.setTranslateX(0);
            specialProjectile.setTranslateY(0);
        });

        movement.play();
    }
    @FXML
    private void onSlash() {
        heroView.playSlash();
    }

    @FXML
    private void onFire() {
        heroView.playFire();
        launchFire();
    }

    @FXML
    private void onDefend() {
        heroView.playDefend();
    }


    @FXML
    private void onSpecial() {
        heroView.playSpecial();
        launchSpecial();
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
