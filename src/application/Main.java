/*
 * A media Player Built in Java.
 * Coded by Julian Wise, instruction followed from EduOnix Java Tutorial
 */

package application;
import java.io.File;
import java.net.MalformedURLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	
	Player player;
	FileChooser fileChooser;
	public void start(final Stage primaryStage) {
		
		
		//Top Menu
		MenuItem open = new MenuItem("Open");
		Menu file = new Menu("File");
		MenuBar menu = new MenuBar();
		
		file.getItems().add(open);
		menu.getMenus().add(file);
		
		fileChooser = new FileChooser();
		
		//Set Action for menu
		open.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				player.player.pause();
				File file = fileChooser.showOpenDialog(primaryStage);
				
				//Open in new window if file is note empty
				if(file != null){
					try {
						player = new Player(file.toURI().toURL().toExternalForm());
						Scene scene = new Scene(player, 720, 535, Color.BLACK);
						primaryStage.setScene(scene);
					} catch (MalformedURLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		player = new Player("file:///C:/Game.of.Thrones.S05E05.mp4");
		
		//Add Menu to Player
		player.setTop(menu);
		
		
		Scene scene = new Scene(player, 720,525, Color.BLACK);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
