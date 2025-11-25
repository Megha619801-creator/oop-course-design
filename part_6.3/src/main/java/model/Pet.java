package model;

public class Pet {
    private double x;
    private double y;
    private double speed = 2.0; // pixels per update
    private boolean moving = false;
    private double targetX, targetY;
    private double canvasWidth, canvasHeight;
    private double petWidth = 40;  // approximate size for boundaries
    private double petHeight = 40;

    public Pet(double startX, double startY, double canvasWidth, double canvasHeight) {
        this.x = startX;
        this.y = startY;
        this.targetX = startX;
        this.targetY = startY;
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
    }

    public void move() {
        if (!moving) return;

        double dx = targetX - x;
        double dy = targetY - y;
        double distance = Math.sqrt(dx * dx + dy * dy);

        if (distance < speed) { // reached target
            x = targetX;
            y = targetY;
            moving = false;
        } else {
            x += (dx / distance) * speed;
            y += (dy / distance) * speed;
        }

        // Keep pet inside canvas boundaries
        x = Math.max(petWidth/2, Math.min(x, canvasWidth - petWidth/2));
        y = Math.max(petHeight/2, Math.min(y, canvasHeight - petHeight/2));
    }

    public void setTarget(double targetX, double targetY) {
        this.targetX = targetX;
        this.targetY = targetY;
        moving = true;
    }

    public void stopMoving() {
        moving = false;
    }

    public double getX() { return x; }
    public double getY() { return y; }
}
