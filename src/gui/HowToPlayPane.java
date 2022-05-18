package gui;

import gui.base.IconButton;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;
import sharedObject.RenderableHolder;

public class HowToPlayPane extends BorderPane {
	private boolean isHidden;
	private Button nextButton;
	private Button prevButton;
	private Button closeButton;

	public HowToPlayPane() {
		super();
		// TODO Auto-generated constructor stub
		this.setStyle("-fx-background-color: black;" + "-fx-border-color: yellow; " + "-fx-border-radius: 30;"
				+ " -fx-border-width: 2px;");
		setMaxSize(600, 400);
		this.isHidden = true;

		this.setTranslateY(600);

		ImageView howToPlayDetails1 = new ImageView(RenderableHolder.howToPlay1PNG);
		ImageView howToPlayDetails2 = new ImageView(RenderableHolder.howToPlay2PNG);

		this.nextButton = new IconButton(RenderableHolder.nextButtonPNG);
		this.nextButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				setCenter(howToPlayDetails2);
				nextButton.setDisable(true);
				prevButton.setDisable(false);
			}
		});

		this.prevButton = new IconButton(RenderableHolder.previousButtonPNG);
		this.prevButton.setDisable(true);
		this.prevButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				setCenter(howToPlayDetails1);
				nextButton.setDisable(false);
				prevButton.setDisable(true);
			}
		});

		Pane buttonPane = new HBox(5);
		buttonPane.setPadding(new Insets(0, 10, 30, 500));
		buttonPane.getChildren().addAll(prevButton, nextButton);

		this.closeButton = new IconButton(RenderableHolder.closeButtonPNG);
		this.closeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				enter();
			}
		});

		Pane closeButtonPane = new HBox();
		closeButtonPane.getChildren().add(closeButton);
		closeButtonPane.setPadding(new Insets(30, 10, 0, 600));

		this.setCenter(howToPlayDetails1);
		this.setBottom(buttonPane);
		this.setTop(closeButtonPane);
	}

	public void enter() {
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(0.3));
		transition.setNode(this);
		if (isHidden) {
			transition.setToY(0);
			transition.setToX(0);
			isHidden = false;
		} else {
			transition.setToY(600);
			isHidden = true;
		}
		transition.play();
	}
}
