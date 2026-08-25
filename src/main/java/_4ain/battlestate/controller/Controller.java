package _4ain.battlestate.controller;

import _4ain.battlestate.model.Partita;
import _4ain.battlestate.model.StatoGioco;
import _4ain.battlestate.view.EnemyView;
import _4ain.battlestate.view.HeroView;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private ImageView heroImage;
    @FXML
    private ImageView enemyImage;
    @FXML
    private ImageView fireProjectile;
    @FXML
    private ImageView specialProjectile;
    @FXML
    private ProgressBar heroHpBar;

    @FXML
    private Label heroHpLabel;

    @FXML
    private ProgressBar enemyHpBar;

    @FXML
    private Label enemyHpLabel;

    @FXML
    private ProgressBar heroEnergyBar;

    @FXML
    private Label heroEnergyLabel;

    @FXML
    private ProgressBar enemyEnergyBar;

    @FXML
    private Label enemyEnergyLabel;

    @FXML
    private HBox actionBox;

    @FXML
    private StackPane endGamePane;

    @FXML
    private Label endGameTitle;

    @FXML
    private Label endGameText;

    @FXML
    private TextArea combatLog;

    HeroView heroView;
    EnemyView enemyView;
    private Partita partita;
    //List<EnemyView> enemies;

    @FXML
    public void initialize() {

        partita = new Partita();


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

        String[] deathFramesChibi = {
                "/hero/chibi_assassin/animations/Death/death1.png",
                "/hero/chibi_assassin/animations/Death/death2.png",
                "/hero/chibi_assassin/animations/Death/death3.png",
                "/hero/chibi_assassin/animations/Death/death4.png",
                "/hero/chibi_assassin/animations/Death/death5.png"
        };


        heroView = new HeroView(heroImage, idleFramesChibi,slashFramesChibi,fireFramesChibi,defendFramesChibi,specialFramesChibi,deathFramesChibi);
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

        String[] hurtFramesSkeleton = {
                "/enemy/skeleton/animation/HURT/Animation37.png",
                "/enemy/skeleton/animation/HURT/Animation38.png",
                "/enemy/skeleton/animation/HURT/Animation39.png",
                "/enemy/skeleton/animation/HURT/Animation40.png",
                "/enemy/skeleton/animation/HURT/Animation41.png"
        };

        String[] attack1FramesSkeleton = {
                "/enemy/skeleton/animation/Attack1/Animation7.png",
                "/enemy/skeleton/animation/Attack1/Animation8.png",
                "/enemy/skeleton/animation/Attack1/Animation9.png",
                "/enemy/skeleton/animation/Attack1/Animation10.png",
                "/enemy/skeleton/animation/Attack1/Animation11.png",
                "/enemy/skeleton/animation/Attack1/Animation12.png",
                "/enemy/skeleton/animation/Attack1/Animation13.png",
                "/enemy/skeleton/animation/Attack1/Animation14.png"
        };

        String[] attack2FramesSkeleton = {
                "/enemy/skeleton/animation/Attack2/Animation15.png",
                "/enemy/skeleton/animation/Attack2/Animation16.png",
                "/enemy/skeleton/animation/Attack2/Animation17.png",
                "/enemy/skeleton/animation/Attack2/Animation18.png",
                "/enemy/skeleton/animation/Attack2/Animation19.png",
                "/enemy/skeleton/animation/Attack2/Animation20.png",
                "/enemy/skeleton/animation/Attack2/Animation21.png",
                "/enemy/skeleton/animation/Attack2/Animation22.png"
        };


        String[] deathFramesSkeleton = {
                "/enemy/skeleton/animation/DEATH/Animation23.png",
                "/enemy/skeleton/animation/DEATH/Animation24.png",
                "/enemy/skeleton/animation/DEATH/Animation25.png",
                "/enemy/skeleton/animation/DEATH/Animation26.png",
                "/enemy/skeleton/animation/DEATH/Animation27.png",
                "/enemy/skeleton/animation/DEATH/Animation28.png",
                "/enemy/skeleton/animation/DEATH/Animation29.png",
                "/enemy/skeleton/animation/DEATH/Animation30.png",
                "/enemy/skeleton/animation/DEATH/Animation31.png",
                "/enemy/skeleton/animation/DEATH/Animation32.png",
                "/enemy/skeleton/animation/DEATH/Animation33.png",
                "/enemy/skeleton/animation/DEATH/Animation34.png",
                "/enemy/skeleton/animation/DEATH/Animation35.png",
                "/enemy/skeleton/animation/DEATH/Animation36.png"
        };

        String[] defendFramesSkeleton = {
                "/enemy/skeleton/animation/DEFEND/DEFEND1.png",
                "/enemy/skeleton/animation/DEFEND/DEFEND2.png",
                "/enemy/skeleton/animation/DEFEND/DEFEND3.png",
                "/enemy/skeleton/animation/DEFEND/DEFEND4.png",
                "/enemy/skeleton/animation/DEFEND/DEFEND5.png",
                "/enemy/skeleton/animation/DEFEND/DEFEND6.png"
        };
        enemyView = new EnemyView(enemyImage, idleFramesSkeleton,hurtFramesSkeleton,attack1FramesSkeleton,attack2FramesSkeleton,deathFramesSkeleton,defendFramesSkeleton);
        enemyView.playIdle();

        aggiornaHUD();
    }

    private void aggiornaHUD() {
        int heroHp = partita.getGiocatore().getHp();
        int enemyHp = partita.getNemico().getHp();

        int heroEnergy = partita.getGiocatore().getEnergia();
        int enemyEnergy = partita.getNemico().getEnergia();

        //hp
        heroHpBar.setProgress(heroHp / 100.0);
        enemyHpBar.setProgress(enemyHp / 100.0);

        heroHpLabel.setText(String.valueOf(heroHp));
        enemyHpLabel.setText(String.valueOf(enemyHp));

        //energia
        heroEnergyBar.setProgress(heroEnergy / 100.0);
        enemyEnergyBar.setProgress(enemyEnergy / 100.0);

        heroEnergyLabel.setText(String.valueOf(heroEnergy));
        enemyEnergyLabel.setText(String.valueOf(enemyEnergy));
    }

    private void turnoNemico() {

        if (partita.getStato() == StatoGioco.Vittoria) {

            actionBox.setDisable(true);

            enemyView.playDeath();

            PauseTransition mostraSchermata =
                    new PauseTransition(Duration.millis(1200));

            mostraSchermata.setOnFinished(event -> {
                mostraVittoria();
            });

            mostraSchermata.play();

            return;
        }

        int sceltaBot = partita.scegliOpzioneBot();
        aggiornaLog();

        if (sceltaBot == 1) {

            enemyView.playAttack1();

        } else if (sceltaBot == 2) {

            enemyView.playAttack2();

        } else {

            enemyView.playDefend();
        }

        aggiornaHUD();

        if (partita.getStato() == StatoGioco.Sconfitta) {

            actionBox.setDisable(true);

            PauseTransition pausaMorte =
                    new PauseTransition(Duration.millis(600));

            pausaMorte.setOnFinished(event -> {

                heroView.playDeath();

                PauseTransition mostraSchermata =
                        new PauseTransition(Duration.millis(1200));

                mostraSchermata.setOnFinished(e -> {
                    mostraSconfitta();
                });

                mostraSchermata.play();
            });

            pausaMorte.play();

            return;
        }

        actionBox.setDisable(false);
    }

    private void avviaTurnoNemico() {
        actionBox.setDisable(true);

        PauseTransition pausa =
                new PauseTransition(Duration.millis(900));

        pausa.setOnFinished(event -> {
            turnoNemico();
        });

        pausa.play();
    }

    private void mostraSconfitta() {

        endGameTitle.setText("DEFEAT");
        endGameText.setText("You have been defeated");

        endGamePane.setVisible(true);
        endGamePane.toFront();
    }

    private void mostraVittoria() {

        endGameTitle.setText("VICTORY");
        endGameText.setText("The Skeleton has been defeated!");

        endGamePane.setVisible(true);
        endGamePane.toFront();
    }

    @FXML
    private void onRetry() {

        partita = new Partita();

        endGamePane.setVisible(false);

        actionBox.setDisable(false);

        fireProjectile.setVisible(false);
        specialProjectile.setVisible(false);

        heroView.playIdle();
        enemyView.playIdle();

        aggiornaHUD();
    }

    @FXML
    private void onExit() {
        System.exit(0);
    }

    private void launchFire() {

        fireProjectile.setTranslateX(0);
        fireProjectile.setTranslateY(0);

        fireProjectile.setVisible(true);

        TranslateTransition movement =
                new TranslateTransition(
                        Duration.millis(850),
                        fireProjectile
                );

        movement.setByX(450);

        movement.setOnFinished(event -> {

            fireProjectile.setVisible(false);

            fireProjectile.setTranslateX(0);
            fireProjectile.setTranslateY(0);

            // FIRE HA UCCISO LO SKELETON
            if (partita.getNemico().getHp() <= 0) {

                actionBox.setDisable(true);

                // Prima facciamo vedere la death
                enemyView.playDeath();

                // Poi mostriamo Victory
                PauseTransition pausaVittoria =
                        new PauseTransition(Duration.millis(1200));

                pausaVittoria.setOnFinished(e -> {
                    mostraVittoria();
                });

                pausaVittoria.play();

                return;
            }

            // se skeleton sopravvive
            enemyView.playHurt();

            // Parte il suo turno
            avviaTurnoNemico();
        });

        movement.play();
    }

    private void launchSpecial() {

        specialProjectile.setTranslateX(0);
        specialProjectile.setTranslateY(0);

        specialProjectile.setVisible(true);

        TranslateTransition movement =
                new TranslateTransition(
                        Duration.millis(850),
                        specialProjectile
                );

        movement.setByX(450);

        movement.setOnFinished(event -> {

            specialProjectile.setVisible(false);

            specialProjectile.setTranslateX(0);
            specialProjectile.setTranslateY(0);

            // SPECIAL HA UCCISO LO SKELETON
            if (partita.getNemico().getHp() <= 0) {

                actionBox.setDisable(true);

                // Death Skeleton
                enemyView.playDeath();

                // Dopo la death --- Victory
                PauseTransition pausaVittoria =
                        new PauseTransition(Duration.millis(1200));

                pausaVittoria.setOnFinished(e -> {
                    mostraVittoria();
                });

                pausaVittoria.play();

                return;
            }

            // Skeleton ancora vivo
            enemyView.playHurt();

            // Tocca al nemico
            avviaTurnoNemico();
        });

        movement.play();
    }
    @FXML
    private void onSlash() {
        System.out.println("CLICK SLASH");
        System.out.println("STATO: " + partita.getStato());
        System.out.println("DISABLED: " + actionBox.isDisabled());

        if (partita.getStato() != StatoGioco.TurnoGiocatore) {
            System.out.println("SLASH BLOCCATO DALLO STATO");
            return;
        }

        actionBox.setDisable(true);

        partita.scegliOpzione(1);
        aggiornaLog();

        heroView.playSlash();
        aggiornaHUD();

        if (partita.getStato() == StatoGioco.Vittoria) {
            enemyView.playDeath();
            return;
        }

        enemyView.playHurt();

        avviaTurnoNemico();
    }

    @FXML
    private void onFire() {

        if (partita.getStato() != StatoGioco.TurnoGiocatore) {
            return;
        }

        // Blocca i pulsanti mentre avviene l'azione
        actionBox.setDisable(true);

        // Esegue Fire nel model
        partita.scegliOpzione(2);

        aggiornaLog();

        heroView.playFire();
        launchFire();

        aggiornaHUD();

    }

    @FXML
    private void onDefend() {
        if (partita.getStato() != StatoGioco.TurnoGiocatore) {
            return;
        }

        actionBox.setDisable(true);

        partita.scegliOpzione(4);

        aggiornaLog();

        heroView.playDefend();

        aggiornaHUD();

        avviaTurnoNemico();
    }


    @FXML
    private void onSpecial() {
        if (partita.getStato() != StatoGioco.TurnoGiocatore) {
            return;
        }

        actionBox.setDisable(true);

        partita.scegliOpzione(3);

        aggiornaLog();

        heroView.playSpecial();

        aggiornaHUD();

        launchSpecial();
    }

    private void aggiornaLog() {

        for (String log : partita.getLogs()) {
            combatLog.appendText(log);
        }

        partita.clearLogs();

        combatLog.positionCaret(combatLog.getText().length());
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
