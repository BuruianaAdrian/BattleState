package _4ain.battlestate.view.animation;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SpriteAnimation {

    private final ImageView imageView;
    private final Image[] frames;
    private final Timeline timeline;

    private int currentFrame = 0;

    // Dice se l'animazione deve ricominciare dall'inizio
    private boolean looping = false;


    public SpriteAnimation(ImageView imageView, String[] framePaths, double fps) {

        this.imageView = imageView;

        frames = new Image[framePaths.length];

        // Carica tutti i frame
        for (int i = 0; i < framePaths.length; i++) {

            frames[i] = new Image(
                    getClass().getResourceAsStream(framePaths[i])
            );
        }

        // Mostra il primo frame
        imageView.setImage(frames[0]);

        // Crea l'animazione
        timeline = new Timeline(
                new KeyFrame(
                        Duration.seconds(1.0 / fps),
                        event -> nextFrame()
                )
        );
    }


    private void nextFrame() {

        currentFrame++;

        // Se siamo arrivati oltre l'ultimo frame
        if (currentFrame >= frames.length) {

            if (looping) {

                // IDLE → ricomincia
                currentFrame = 0;

            } else {

                // SLASH / FIRE / DEFEND ecc.
                // Rimane sull'ultimo frame
                currentFrame = frames.length - 1;
            }
        }

        imageView.setImage(frames[currentFrame]);
    }


    // IDLE → continua all'infinito
    public void playLoop() {

        timeline.stop();

        looping = true;
        currentFrame = 0;

        imageView.setImage(frames[0]);

        timeline.setOnFinished(null);
        timeline.setCycleCount(Animation.INDEFINITE);

        timeline.playFromStart();
    }


    // SLASH / FIRE / DEFEND / SPECIAL → una sola volta
    public void playOnce(Runnable onFinished) {

        timeline.stop();

        looping = false;
        currentFrame = 0;

        imageView.setImage(frames[0]);

        /*
         * frames.length e NON frames.length - 1.
         *
         * In questo modo anche l'ultimo frame rimane
         * visibile per la durata corretta.
         */
        timeline.setCycleCount(frames.length);

        timeline.setOnFinished(event -> {

            if (onFinished != null) {
                onFinished.run();
            }
        });

        timeline.playFromStart();
    }


    public void stop() {
        timeline.stop();
    }


    public void pause() {
        timeline.pause();
    }
}