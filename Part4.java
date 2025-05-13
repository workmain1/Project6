package com.example.project6;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Part4 extends Application {

    private int[] array;
    private HBox arrayBox;
    private Label statusLabel;
    private TextField sizeInput, searchInput, delayInput;

    @Override
    public void start(Stage primaryStage) {
        Label sizeLabel = new Label("Array size:");
        sizeInput = new TextField("20");
        Label searchLabel = new Label("Search value:");
        searchInput = new TextField("15");
        Label delayLabel = new Label("Delay (ms):");
        delayInput = new TextField("500");

        Button generateBtn = new Button("Generate Array");
        generateBtn.setOnAction(e -> generateArray());
        Button searchBtn = new Button("Start Search");
        searchBtn.setOnAction(e -> startSearch());

        statusLabel = new Label("Status");
        arrayBox = new HBox(5);

        VBox controls = new VBox(10, sizeLabel, sizeInput, searchLabel, searchInput, delayLabel, delayInput, generateBtn, searchBtn, statusLabel);
        controls.setMinWidth(200);
        BorderPane root = new BorderPane();
        root.setLeft(controls);
        root.setCenter(arrayBox);

        Scene scene = new Scene(root, 800, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Binary Search Visualizer");
        primaryStage.show();
    }

    private void generateArray() {
        int size = Integer.parseInt(sizeInput.getText());
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        arrayBox.getChildren().clear();
        for (int i : array) {
            Rectangle rect = new Rectangle(20, 40, Color.LIGHTGRAY);
            rect.setStroke(Color.BLACK);
            Label label = new Label(String.valueOf(i));
            VBox vbox = new VBox(rect, label);
            arrayBox.getChildren().add(vbox);
        }
        statusLabel.setText("Array generated.");
    }

    private void highlightArrayPositions(int low, int mid, int high) {
        for (int i = 0; i < arrayBox.getChildren().size(); i++) {
            VBox box = (VBox) arrayBox.getChildren().get(i);
            Rectangle rect = (Rectangle) box.getChildren().get(0);
            if (i == mid) rect.setFill(Color.YELLOW);
            else if (i == low || i == high) rect.setFill(Color.ORANGE);
            else rect.setFill(Color.LIGHTGRAY);
        }
    }

    private void startSearch() {
        if (array == null) {
            statusLabel.setText("Please generate the array first.");
            return;
        }
        int key = Integer.parseInt(searchInput.getText());
        binarySearchWithVisualization(array, key);
    }

    private void binarySearchWithVisualization(int[] array, int key) {
        final int[] low = {0};
        final int[] high = {array.length - 1};
        final int[] iterCount = {0};
        Timeline timeline = new Timeline();
        int duration = Integer.parseInt(delayInput.getText());

        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(duration), event -> {
            if (low[0] > high[0]) {
                statusLabel.setText("Value not found in " + iterCount[0] + " iterations");
                timeline.stop();
                return;
            }

            int mid = (low[0] + high[0]) / 2;
            iterCount[0]++;
            statusLabel.setText("Iteration " + iterCount[0] + ": low=" + low[0] + ", high=" + high[0] + ", mid=" + mid);
            highlightArrayPositions(low[0], mid, high[0]);

            if (array[mid] < key) {
                low[0] = mid + 1;
            } else if (array[mid] > key) {
                high[0] = mid - 1;
            } else {
                statusLabel.setText("Value found at index: " + mid + " in " + iterCount[0] + " iterations");
                highlightArrayPositions(low[0], mid, high[0]);
                timeline.stop();
            }
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
