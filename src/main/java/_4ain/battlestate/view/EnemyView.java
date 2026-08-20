package _4ain.battlestate.view;

import _4ain.battlestate.view.animation.SpriteAnimation;
import javafx.scene.image.ImageView;

public class EnemyView {

    private ImageView imageView;
    private SpriteAnimation idleAnimation;

    public EnemyView(ImageView imageView, String[] idleFramePaths) {
        this.imageView = imageView;
        this.idleAnimation = new SpriteAnimation(imageView, idleFramePaths, 8);;
    }

    public void playIdle() {
        idleAnimation.playLoop();
    }

    public ImageView getImageView() {
        return imageView;
    }
}
