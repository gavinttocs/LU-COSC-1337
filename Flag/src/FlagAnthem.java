/**
 * Objective: Create an application that will display a combo box, allowing the user to select a nation. Then the nation picked will display a flag and the nations national anthem
 * Algorithm: Create a loop that will search the web for gifs of flags and the anthem associated with them.
 * Input and Output: The user will select a nation, and the program will display that nations flag and play that nation's anthem.
 * Created by: Gavin Scott
 * Date: 04/2/22
 * Version: JDK 16.0.2
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;   
import javafx.scene.control.ComboBox;  
import javafx.scene.control.Label;  
import javafx.scene.image.Image; 
import javafx.scene.image.ImageView;  
import javafx.scene.layout.BorderPane;  
import javafx.scene.layout.HBox; 
import javafx.scene.media.Media;  
import javafx.scene.media.MediaPlayer;

public class FlagAnthem extends Application {    
	private final static int NUMBER_OF_NATIONS = 7;
	private final static String URLBase =      
	"https://liveexample.pearsoncmg.com/common";    
	private int currentIndex = 0;

@Override 
public void start(Stage primaryStage) {      
	Image[] images = new Image[NUMBER_OF_NATIONS];     
	MediaPlayer[] mp = new MediaPlayer[NUMBER_OF_NATIONS];      
	
	for (int i = 0; i < NUMBER_OF_NATIONS; i++) {       
		images[i] = new Image(URLBase +"/image/flag"+ i + ".gif");      
		mp[i] = new MediaPlayer(new Media(URLBase + "/audio/anthem/anthem" + i + ".mp3"));      
		}
	


Button btPlayPause = new Button("||");
btPlayPause.setOnAction(e -> {
	if (btPlayPause.getText().equals(">")) {
		btPlayPause.setText("||");
		mp[currentIndex].play();
	}
	else {
		btPlayPause.setText(">");
		mp[currentIndex].pause();
			}
		});

ImageView imageView = new ImageView(images[currentIndex]);
ComboBox<String> Nation = new ComboBox<>();
ObservableList<String> items = FXCollections.observableArrayList
("Denmark", "Germany", "China", "India", "Norway", "UK", "US");
Nation.getItems().addAll(items);      
Nation.setValue(items.get(0));
Nation.setOnAction(e -> {
	mp[currentIndex].stop();
	currentIndex = items.indexOf(Nation.getValue());
	imageView.setImage(images[currentIndex]);
	mp[currentIndex].play();
});

HBox hBox = new HBox(10);
hBox.getChildren().addAll(btPlayPause,
		new Label("Select a nation: "), Nation);
hBox.setAlignment(Pos.CENTER);


BorderPane pane = new BorderPane();
pane.setCenter(imageView);
pane.setBottom(hBox);

Scene scene = new Scene(pane, 350, 270);
primaryStage.setTitle("FlagAnthem");
primaryStage.setScene(scene);
primaryStage.show();
mp[currentIndex].play();
	}
public static void main(String[] args)
{
	launch(args);
}
}

