package view;

import controller.CurrencyController;
import model.Currency;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CurrencyView extends Application {

    private CurrencyController controller;

    @Override
    public void init() {
        controller = new CurrencyController();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Currency Converter");

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));

        // Top: Instructions
        Label instructions = new Label("Enter an amount and choose currencies to convert.");
        root.setTop(instructions);
        BorderPane.setAlignment(instructions, Pos.CENTER);

        // Center: Form (GridPane)
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);

        Label amountLabel = new Label("Amount:");
        TextField amountField = new TextField();

        Label fromLabel = new Label("From Currency:");
        ComboBox<Currency> fromBox = new ComboBox<>();
        fromBox.getItems().addAll(controller.getModel().getCurrencies());

        Label toLabel = new Label("To Currency:");
        ComboBox<Currency> toBox = new ComboBox<>();
        toBox.getItems().addAll(controller.getModel().getCurrencies());

        Label resultLabel = new Label("Result:");
        TextField resultField = new TextField();
        resultField.setEditable(false);

        grid.add(amountLabel, 0, 0);
        grid.add(amountField, 1, 0);
        grid.add(fromLabel, 0, 1);
        grid.add(fromBox, 1, 1);
        grid.add(toLabel, 0, 2);
        grid.add(toBox, 1, 2);
        grid.add(resultLabel, 0, 3);
        grid.add(resultField, 1, 3);

        root.setCenter(grid);

        // Bottom: Convert button
        Button convertBtn = new Button("Convert");
        convertBtn.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                Currency from = fromBox.getValue();
                Currency to = toBox.getValue();

                if (from == null || to == null) {
                    resultField.setText("Select both currencies!");
                    return;
                }

                double result = controller.convert(amount, from, to);
                resultField.setText(String.format("%.2f", result));
            } catch (Exception ex) {
                resultField.setText("Invalid amount!");
            }
        });

        root.setBottom(convertBtn);
        BorderPane.setAlignment(convertBtn, Pos.CENTER);

        Scene scene = new Scene(root, 400, 300);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.show();
    }
}
