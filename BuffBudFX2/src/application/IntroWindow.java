package application;

import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class IntroWindow  {
	public static Pet pet = new Corgi(null);
	
	// Images for pet gender buttons (Might not use!)
	ImageView maleIcon = new ImageView(new Image(this.getClass().getResourceAsStream("/Images/testCorgi.png")/*"file:Images/male.png"*/));
	ImageView femaleIcon = new ImageView(new Image (this.getClass().getResourceAsStream("/Images/testCorgi.png")/*"file:Images/female.png"*/));
	
	// Introductory screen
	FlowPane intro = new FlowPane();
	Scene introScene = new Scene(intro, 375, 500/*100*/);
	Font f = Font.font("Verdana", FontWeight.BOLD, 25);
	Text nameText = new Text("Pet Name: ");
	TextField nameTF = new TextField();
	Button submitButton = new Button("Submit", maleIcon);

	// Background
	 Image introBackgroundImage = new Image(this.getClass().getResourceAsStream("/Images/bg3.png")/*"file:Images/IntroScreen.png"*/);
	BackgroundImage introBgImage = new BackgroundImage(introBackgroundImage, BackgroundRepeat.NO_REPEAT,
			BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
			new BackgroundSize(400, 600, false, false, false, false));

	public IntroWindow(Stage stage) {
		// Setting up the visuals for the intro screen
		intro.setBackground(new Background(introBgImage));
		stage.getIcons().add(new Image(this.getClass().getResourceAsStream("/Images/BuffBudIcon.png")));

		// Setting up Buttons
		submitButton.setOnAction(e -> {
			//Saves and sets variables
			Utility.save();
			pet.setPetName(nameTF.getText());
			
			//Opens up actual application after creating new pet
			GameWindow instance;
			instance = new GameWindow(stage);
			Main.loop = new GameLoop(instance);
			Main.loop.start();
		});

		// Setting up Interface
		nameText.setFont(f);
		intro.setAlignment(Pos.CENTER);
		intro.getChildren().add(nameText);
		intro.getChildren().add(nameTF);
		intro.getChildren().add(submitButton);

		// Display settings
		stage.setResizable(false);
		stage.setTitle("Buff Bud");
		stage.setScene(introScene);
		stage.show();

	}

}