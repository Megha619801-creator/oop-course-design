package view;

import controller.DictionaryController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DictionaryView extends Application {

    private DictionaryController controller;

    public void init() {
        controller = new DictionaryController();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Virtual Dictionary");

        FlowPane pane = new FlowPane();
        pane.setHgap(10);
        pane.setVgap(10);

        Label label = new Label("Enter word:");
        TextField textField = new TextField();
        Button searchButton = new Button("Search");
        Label resultLabel = new Label();

        searchButton.setOnAction(e -> {
            String word = textField.getText();
            String meaning = controller.searchWord(word);
            resultLabel.setText(meaning);
        });

        pane.getChildren().addAll(label, textField, searchButton, resultLabel);

        Scene scene = new Scene(pane, 400, 150);
        stage.setScene(scene);
        stage.show();
    }
}
