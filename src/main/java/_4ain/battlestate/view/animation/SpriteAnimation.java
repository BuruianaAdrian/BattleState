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

        timeline.setCycleCount(Animation.INDEFINITE);
    }

    private void nextFrame() {

        currentFrame++;

        if (currentFrame >= frames.length) {
            currentFrame = 0;
        }

        imageView.setImage(frames[currentFrame]);
    }

    public void play() {
        timeline.play();
    }

    public void stop() {
        timeline.stop();
    }

    public void pause() {
        timeline.pause();
    }
}
