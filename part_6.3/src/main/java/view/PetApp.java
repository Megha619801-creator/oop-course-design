package view;

import controller.PetController;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Pet;

public class PetApp extends Application {

    @Override
    public void start(Stage stage) {
        int width = 600;
        int height = 400;

        Canvas canvas = new Canvas(width, height);
        PetView view = new PetView(canvas); // no need to pass absolute path
        Pet pet = new Pet(width / 2, height / 2, width, height);
        PetController controller = new PetController(pet, view);

        canvas.setOnMouseMoved(e -> controller.setTarget(e.getX(), e.getY()));
        canvas.setOnMouseExited(e -> controller.stopPet());

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, width, height);

        stage.setScene(scene);
        stage.setTitle("Virtual Pet Demo");
        stage.show();

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                controller.update();
            }
        }.start();
    }

    public static void main(String[] args) {
        launch();
    }
}
