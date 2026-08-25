package _4ain.battlestate.view;

import _4ain.battlestate.view.animation.SpriteAnimation;
import javafx.scene.image.ImageView;

public class EnemyView {

    private final ImageView imageView;

    private final SpriteAnimation idleAnimation;
    private final SpriteAnimation hurtAnimation;
    private final SpriteAnimation attack1Animation;
    private final SpriteAnimation attack2Animation;
    private final SpriteAnimation deathAnimation;
    private final SpriteAnimation defendAnimation;

    public EnemyView(
            ImageView imageView,
            String[] idleFrames,
            String[] hurtFrames,
            String[] attack1Frames,
            String[] attack2Frames,
            String[] deathFrames,
            String[] defendFrames) {

        this.imageView = imageView;

        idleAnimation =
                new SpriteAnimation(imageView, idleFrames, 8);

        hurtAnimation =
                new SpriteAnimation(imageView, hurtFrames, 8);

        attack1Animation =
                new SpriteAnimation(imageView, attack1Frames, 10);

        attack2Animation =
                new SpriteAnimation(imageView, attack2Frames, 10);

        deathAnimation =
                new SpriteAnimation(imageView, deathFrames, 8);

        defendAnimation =
                new SpriteAnimation(imageView, defendFrames, 8);
    }

    public void playIdle() {
        idleAnimation.playLoop();
    }

    public void playHurt() {
        idleAnimation.stop();

        hurtAnimation.playOnce(() -> {
            playIdle();
        });
    }

    public void playAttack1() {
        idleAnimation.stop();

        attack1Animation.playOnce(() -> {
            playIdle();
        });

    }

    public void playAttack2() {
        idleAnimation.stop();

        attack2Animation.playOnce(() -> {
            playIdle();
        });
    }

    public void playDeath() {
        idleAnimation.stop();

        deathAnimation.playOnce(() -> {
            //
        });
    }

    public void playDefend() {

        idleAnimation.stop();

        defendAnimation.playOnce(() -> {
            playIdle();
        });
    }

    public ImageView getImageView() {
        return imageView;
    }
}