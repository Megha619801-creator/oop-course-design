package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class PetView {
    private Canvas canvas;
    private GraphicsContext gc;
    private Image petImage;

    public PetView(Canvas canvas) {
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();

        // Load image from resources folder
        try {
            // Leading "/" means root of classpath (src/main/resources)
            petImage = new Image(getClass().getResource("/images/Pet.png").toString());
            System.out.println(" Pet image loaded successfully.");
        } catch (Exception e) {
            System.err.println(" Failed to load Pet image!");
            e.printStackTrace();
        }
    }

    public void drawPet(double x, double y) {
        if (petImage == null) return; // safety check
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.drawImage(petImage, x - petImage.getWidth() / 2, y - petImage.getHeight() / 2);
    }
}
