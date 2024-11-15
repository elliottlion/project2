public enum Pose {
    RIGHT("assets/link-right.png", "assets/link-right2.png"),
    LEFT("assets/link-left.png", "assets/link-left2.png");
    private final Animation animation;
    private Pose(String... images) {
    this.animation = new Animation(images);
    }
    public String getImage() {
    return this.animation.getImage();
    }
    }