package application;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.animation.*;
import javafx.util.Duration;

public class Main extends Application {
	public static void error(String msg) {// display an error message if the number is not between 1 and 100.
		Alert alert = new Alert(Alert.AlertType.ERROR);// create an alert to display the error message.
		alert.setTitle("Error!!!");
		alert.setHeaderText(null);
		alert.setContentText(msg);// set the content of the alert to the error message.
		alert.initModality(Modality.APPLICATION_MODAL);
		alert.showAndWait();// display the alert.
	}
	static Font fnormal = Font.font("Arial", FontWeight.MEDIUM, FontPosture.REGULAR, 15);
	static Font fnorma2 = Font.font("Arial", FontWeight.BLACK, FontPosture.REGULAR, 17);
	static Font fnormalbold = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 20);
	Font ftittle = Font.font("impact", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 20);
	
	Scene scene;
	//main
	VBox vbox = new VBox(10);
	
	public Main() {
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("FLEET MANAGEMENT SYSTEM :)");

		// iamge
		// ================================================================================================
//		Image logoImage = new Image(
//				"file:C:/Users/Administrator/eclipse-workspace/BASE_DBM/src/download-removebg-preview.png");
//		ImageView logoImageView = new ImageView(logoImage);
//		logoImageView.setFitHeight(100);
//		logoImageView.setPreserveRatio(true);
//		"C:\Users\ASUS\Desktop\Eclipse IDE for Java Developers - 2022-09.lnk"
		
		Image logoImage = new Image("C:\\Users\\Yuna\\eclipse-workspace\\DataBasePro\\src\\application\\logo.png");// 270x120
		ImageView logoImageView = new ImageView(logoImage );
		logoImageView.setFitWidth(151.875);
		logoImageView.setFitHeight(67.5);
		
		//C:\Users\Administrator\eclipse-workspace\BASE_DBM\src\car-logo_main.png

//		Image labImage = new Image("file:C:/Users/Administrator/eclipse-workspace/BASE_DBM/src/png-clipart-cartoon-vehicle-car-compact-car-vintage-car-removebg-preview.png");
//		ImageView labImageView = new ImageView(labImage);
//		labImageView.setFitWidth(400);
//		labImageView.setPreserveRatio(true);
		
		Image labImage = new Image("C:\\\\Users\\\\Yuna\\\\eclipse-workspace\\\\DataBasePro\\\\src\\\\application\\\\car1.png");
		ImageView labImageView = new ImageView(labImage);
		labImageView.setFitWidth(400);
		labImageView.setPreserveRatio(true);

		// label===========================================================================
//		Label jawwalLabel = new Label("JAWWAL");
//		jawwalLabel.setFont(Font.font("Arial", FontWeight.BOLD, 40));
//		jawwalLabel.setTextFill(Color.web("#4F7942"));

		Label welcomeLabel = new Label("Welcome to Fleet Management System");
		welcomeLabel.setFont(new Font("Impact", 50));
		//welcomeLabel.setStyle(" -fx-background-color: #cfeccb;");
		welcomeLabel.setTextFill(Color.web("#f2ffff"));//#355E3B
		// Menu====================================================================================

		//create d a contex menu that will open when the the button info is clicked
		ContextMenu mainmenu = new ContextMenu();

		MenuItem aboutItem = new MenuItem("About");
		MenuItem aboutUsItem = new MenuItem("About Us");
		MenuItem exitItem = new MenuItem("Exit");

		mainmenu.getItems().addAll(aboutItem, aboutUsItem, exitItem);

		mainmenu.setStyle(
				"-fx-background-color: rgba(255, 255, 255, 0.7); -fx-background-radius: 5; -fx-border-radius: 5;");
		
		
		aboutItem.setOnAction(e -> showAboutPage());
		aboutUsItem.setOnAction(e -> showAboutUsPage());
		exitItem.setOnAction(e -> primaryStage.close());
		
		//for the button of the main menu
		Image imageinfo = new Image("C:\\\\Users\\\\Yuna\\\\eclipse-workspace\\\\DataBasePro\\\\src\\\\application\\\\icon_white.png");// 270x120
		ImageView imginfo = new ImageView(imageinfo);
		imginfo.setFitWidth(30);
		imginfo.setFitHeight(30);

		Button btinfo = new Button("Info", imginfo);
		btinfo.setFont(fnormalbold);

		btinfo.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-text-fill: white;");
		btinfo.setOnMouseClicked(e -> {
			if (e.getButton().toString().equals("PRIMARY")) { // Right mouse button
				mainmenu.show(btinfo, e.getScreenX() - 50, e.getScreenY());
			}
		});

		// buttons===========================================================================

		Button logButton = new Button("Fleet Officer");
		logButton.setFont(new Font("Arial", 20));
		logButton.setStyle(" -fx-background-color: linear-gradient(to bottom, #218da4, #76b057);");//-fx-background-color: #4F7942
		logButton.setTextFill(Color.web("#FFFFFF"));

		Button resButton = new Button("Driver");
		resButton.setFont(new Font("Arial", 20));
		resButton.setStyle(" -fx-background-color: linear-gradient(to bottom, #218da4, #76b057);");
		resButton.setTextFill(Color.web("#FFFFFF"));

		logButton.setOnAction(e -> openFleetOfficerLoginPage());
		resButton.setOnAction(e -> openDriverLoginPage());
		aboutItem.setOnAction(e -> showAboutPage());
		aboutUsItem.setOnAction(e -> showAboutUsPage());

		// panes=====================================================================================
		HBox headerLeftHBox = new HBox(10);
		headerLeftHBox.setAlignment(Pos.TOP_LEFT);
		headerLeftHBox.getChildren().addAll(logoImageView);

//		// VBox for Logo and Label "JAWWAL"
//		VBox headerLeftVBox = new VBox(10);
//		headerLeftVBox.setAlignment(Pos.TOP_LEFT);
//		headerLeftVBox.getChildren().addAll(headerLeftHBox);

		// VBox for Menu
		VBox headerRightVBox = new VBox(10);
		headerRightVBox.setAlignment(Pos.TOP_RIGHT);
		headerRightVBox.getChildren().addAll(btinfo);// menuBar

		// Main content
		//VBox vbox = new VBox(10);
		vbox.setAlignment(Pos.CENTER);
		// vbox.setStyle("-fx-background-color: #D3E7D3");
		vbox.setStyle(" -fx-background-color: #123a4e;");
		vbox.setPadding(new Insets(10, 10, 10, 10));

		VBox buttonBox = new VBox(10);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.getChildren().addAll(resButton, logButton);
		
		HBox btandimagebox = new HBox(200);
		btandimagebox.setPadding(new Insets(15,15,15,15));
		btandimagebox.setAlignment(Pos.CENTER);
		btandimagebox.getChildren().addAll(buttonBox,labImageView);
		
		vbox.getChildren().addAll(headerLeftHBox, headerRightVBox, welcomeLabel,btandimagebox);
		scene = new Scene(vbox, 1000, 700);
		primaryStage.setScene(scene);

		TranslateTransition translateTransition = new TranslateTransition(Duration.millis(1000), welcomeLabel);
		translateTransition.setFromY(-300);
		translateTransition.setToY(0);
		translateTransition.play();

		primaryStage.show();
	}

	private void openFleetOfficerLoginPage() {
		FleetOfficerLoginPage fleetOfficerLoginPage = new FleetOfficerLoginPage();
		fleetOfficerLoginPage.show();
	}

	private void openDriverLoginPage() {
		DriverLoginPage driverLoginPage = new DriverLoginPage();
		driverLoginPage.show();
	}

	private void showAboutPage() {
		AboutPage aboutPage = new AboutPage();
		aboutPage.show();
	}

	private void showAboutUsPage() {
		AboutUsPage aboutPage = new AboutUsPage();
		aboutPage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
