package _4ain.battlestate.view;

import _4ain.battlestate.view.animation.SpriteAnimation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HeroView {

    private ImageView imageView;

    private SpriteAnimation idleAnimation;
    private SpriteAnimation slashAnimation;
    private SpriteAnimation fireAnimation;
    private SpriteAnimation defendAnimation;
    private SpriteAnimation specialAnimation;

    public HeroView(
            ImageView imageView,
            String[] idleFrames,
            String[] slashFrames,
            String[] fireFrames,
            String[] defendFrames,
            String[] specialFrames) {

        this.imageView = imageView;

        idleAnimation =
                new SpriteAnimation(imageView, idleFrames, 8);

        slashAnimation =
                new SpriteAnimation(imageView, slashFrames, 10);

        fireAnimation =
                new SpriteAnimation(imageView, fireFrames, 8);

        defendAnimation =
                new SpriteAnimation(imageView, defendFrames, 2);

        specialAnimation =
                new SpriteAnimation(imageView,specialFrames,8);
    }

    public void playIdle() {
        idleAnimation.playLoop();
    }

    public void playSlash() {

        idleAnimation.stop();

        slashAnimation.playOnce(() -> {
            playIdle();
        });
    }

    public void playFire() {

        idleAnimation.stop();

        fireAnimation.playOnce(() -> {
            playIdle();
        });
    }

    public void playDefend() {

        idleAnimation.stop();

        defendAnimation.playOnce(() -> {
            playIdle();
        });
    }

    public void playSpecial() {

        idleAnimation.stop();

        specialAnimation.playOnce(() -> {
            playIdle();
        });
    }



    public ImageView getImageView() {
        return imageView;
    }
}