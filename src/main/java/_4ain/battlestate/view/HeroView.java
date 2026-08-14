package _4ain.battlestate.view;

import _4ain.battlestate.view.animation.SpriteAnimation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HeroView {

    private ImageView imageView;
    private SpriteAnimation idleAnimation;

    public HeroView(ImageView imageView, String[] idleFramePaths) {
        this.imageView = imageView;

        this.idleAnimation =
                new SpriteAnimation(imageView, idleFramePaths, 8);
    }

    public void playIdle() {
        idleAnimation.play();
    }

    public ImageView getImageView() {
        return imageView;
    }
}