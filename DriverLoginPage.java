package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class DriverLoginPage {
	static Font fnormal = Font.font("Arial", FontWeight.MEDIUM, FontPosture.REGULAR, 15);
	static Font fnorma2 = Font.font("Arial", FontWeight.BLACK, FontPosture.REGULAR, 17);
	static Font fnormalbold = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 20);

	public void show() {
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Driver Login Page");
		Image logo = new Image("C:\\Users\\Yuna\\eclipse-workspace\\DataBasePro\\src\\application\\car1.png");
		ImageView logoImageView = new ImageView(logo);
		logoImageView.setFitHeight(100);
		logoImageView.setPreserveRatio(true);

		Label driverLabel = new Label("Driver Login Page");
		driverLabel.setFont(new Font("Impact", 40));
		driverLabel.setTextFill(Color.web("#f2ffff"));

		HBox headerBox = new HBox(10, logoImageView, driverLabel);
		headerBox.setAlignment(Pos.CENTER);
		Label usernameLabel = new Label("Username:");
		Label passwordLabel = new Label("Password:");
		usernameLabel.setFont(fnormal);
		passwordLabel.setFont(fnormal);

		TextField usernameField = new TextField();
		PasswordField passwordField = new PasswordField();
		Button loginButton = new Button("Login");
		loginButton.setFont(fnormal);
		loginButton.setStyle("-fx-background-color: #B0C4DE;");

		Hyperlink createAccountLink = new Hyperlink("Create New Account");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.add(usernameLabel, 0, 0);
		grid.add(usernameField, 1, 0);
		grid.add(passwordLabel, 0, 1);
		grid.add(passwordField, 1, 1);
		grid.add(loginButton, 1, 2);
		grid.add(createAccountLink, 1, 3);

		Color color1 = Color.web("#2E8B57");
		Color color2 = Color.web("#4682B4");
		// Color.web("#218da4")//CornerRadii.EMPTYInsets.EMPTY
		grid.setBackground(new Background(new BackgroundFill(
				new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, new Stop(0, color1), new Stop(1, color2)),
				new CornerRadii(400), new Insets(10, 10, 10, 10))));

		// grid.setBackground(new Background(new BackgroundFill(Color.web("#2E8B57"),
		// CornerRadii.EMPTY, Insets.EMPTY)));
		usernameLabel.setTextFill(Color.WHITE);
		passwordLabel.setTextFill(Color.WHITE);
		usernameField.setStyle("-fx-background-color: #B0C4DE;");
		passwordField.setStyle("-fx-background-color: #B0C4DE;");

		createAccountLink.setTextFill(Color.WHITE);

		loginButton.setOnAction(e -> {
			if ("1".equals(usernameField.getText()) && "1".equals(passwordField.getText())) {
				System.out.println("Driver Login Successful!");

				DriverHomepage d = new DriverHomepage();
				d.show();

				primaryStage.close();
			} else {
				System.out.println("Invalid username or password");
			}
		});
		createAccountLink.setOnAction(e -> {
			createNewAccountStage();
		});

		VBox vbox = new VBox(headerBox, grid);
		vbox.setAlignment(Pos.CENTER);
		vbox.setStyle(" -fx-background-color: #123a4e;");

		Scene scene = new Scene(vbox, 1000, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void createNewAccountStage() {
		Stage newAccountStage = new Stage();
		newAccountStage.setTitle("Create New Account");
		Image logo = new Image("C:\\Users\\Yuna\\eclipse-workspace\\DataBasePro\\src\\application\\car1.png");
		ImageView logoImageView = new ImageView(logo);
		logoImageView.setFitHeight(100);
		logoImageView.setPreserveRatio(true);
		Label titleLabel = new Label("Create New Account");
		titleLabel.setFont(new Font("Impact", 40));
		titleLabel.setTextFill(Color.web("#f2ffff"));
		HBox headerBox = new HBox(10, logoImageView, titleLabel);
		headerBox.setAlignment(Pos.CENTER);
		Label nameLabel = new Label("Name:");
		Label usernameLabel = new Label("Username:");
		Label passwordLabel = new Label("Password:");
		TextField nameField = new TextField();
		TextField newUsernameField = new TextField();
		PasswordField newPasswordField = new PasswordField();
		Button createAccountButton = new Button("Create Account");
		createAccountButton.setStyle("-fx-background-color: #B0C4DE;");

		GridPane newAccountGrid = new GridPane();
		newAccountGrid.setAlignment(Pos.CENTER);
		newAccountGrid.setHgap(10);
		newAccountGrid.setVgap(10);
		newAccountGrid.setPadding(new Insets(25, 25, 25, 25));
		newAccountGrid.add(nameLabel, 0, 0);
		newAccountGrid.add(nameField, 1, 0);
		newAccountGrid.add(usernameLabel, 0, 1);
		newAccountGrid.add(newUsernameField, 1, 1);
		newAccountGrid.add(passwordLabel, 0, 2);
		newAccountGrid.add(newPasswordField, 1, 2);
		newAccountGrid.add(createAccountButton, 1, 3);
		Color color1 = Color.web("#2E8B57");
		Color color2 = Color.web("#4682B4");
		// Color.web("#218da4")//CornerRadii.EMPTYInsets.EMPTY
		newAccountGrid.setBackground(new Background(new BackgroundFill(
				new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, new Stop(0, color1), new Stop(1, color2)),
				new CornerRadii(400), new Insets(10, 10, 10, 10))));

		// newAccountGrid.setBackground(new Background(new
		// BackgroundFill(Color.web("#2E8B57"), CornerRadii.EMPTY, Insets.EMPTY)));
		nameLabel.setTextFill(Color.WHITE);
		usernameLabel.setTextFill(Color.WHITE);
		passwordLabel.setTextFill(Color.WHITE);
		nameField.setStyle("-fx-background-color: #B0C4DE;");
		newUsernameField.setStyle("-fx-background-color: #B0C4DE;");
		newPasswordField.setStyle("-fx-background-color: #B0C4DE;");
		// createAccountButton.setStyle("-fx-background-color: #008B8B; -fx-text-fill:
		// white;");
		createAccountButton.setOnAction(e -> {
			if (!nameField.getText().isEmpty() && !newUsernameField.getText().isEmpty()
					&& !newPasswordField.getText().isEmpty()) {
				System.out.println("New Account Created!");
				newAccountStage.close();
			} else {
				System.out.println("Please fill in all fields");
			}
		});
		VBox newAccountVBox = new VBox(10);

		newAccountVBox.setStyle(" -fx-background-color: #123a4e;");
		newAccountVBox.setAlignment(Pos.CENTER);
		newAccountVBox.getChildren().addAll(headerBox, newAccountGrid);

		Scene newAccountScene = new Scene(newAccountVBox, 600, 400);
		newAccountStage.setScene(newAccountScene);
		newAccountStage.show();
	}
}
