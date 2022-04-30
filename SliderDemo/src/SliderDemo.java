/**
 * Objective: Create a vertical and horizontal slider to control a line of text's orientation
 * Algorithm: Using lambda expressions, create listeners to control the direction of the line of text
 * Input and Output: The user will move the sliders displayed and the line of text will follow the path placed by the two sliders
 * Created by: Gavin Scott
 * Date: 04/2/22
 * Version: JDK 16.0.2
 */

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class SliderDemo extends Application {

	//Set the stage 
	public void start(Stage primaryStage) {
		Text text = new Text (20, 20, "JavaFX Programming");
		
		//Create horizontal slider
		Slider slHorizontal = new Slider();
		slHorizontal.setShowTickLabels(true);
		slHorizontal.setShowTickMarks(true);
		
		//Create vertical slider
		Slider slVertical = new Slider();
		slVertical.setOrientation(Orientation.VERTICAL);
		slVertical.setShowTickLabels(true);
		slVertical.setShowTickMarks(true);
		slVertical.setValue(100);
		
		Pane paneForText = new Pane();
		paneForText.getChildren().add(text);
		
		BorderPane pane = new BorderPane();
		pane.setCenter(paneForText);
		pane.setBottom(slHorizontal);
		pane.setRight(slVertical);
		
		//Lambda expression for the horizontal slider
		slHorizontal.valueProperty().addListener(ov -> {
			text.setX(slHorizontal.getValue() * paneForText.getWidth() / slHorizontal.getMax());
		});
		//Lambda expression for the vertical slider
		slVertical.valueProperty().addListener(ov -> {
			text.setY(slVertical.getMax() - (slVertical.getValue() * paneForText.getHeight() / slVertical.getMax()));
		});
		//Set the scene
		Scene scene = new Scene(pane, 450, 170);
		primaryStage.setTitle("Slider Demo");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//Main method
	}
	public static void main(String[] args) {
		launch(args);
	}
}
