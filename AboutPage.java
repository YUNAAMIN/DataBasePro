package application;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class AboutPage {

	public void show() {
		Stage aboutStage = new Stage();
		aboutStage.setTitle("About Us");
		Image logoImage = new Image("C:\\Users\\Yuna\\eclipse-workspace\\DataBasePro\\src\\application\\logo.png");
		ImageView logoImageView = new ImageView(logoImage);
		logoImageView.setFitHeight(100);
		logoImageView.setPreserveRatio(true);
		
//		Label jawwalLabel = new Label("JAWWAL");
//		jawwalLabel.setFont(Font.font("Arial", FontWeight.BOLD, 40));
//		jawwalLabel.setTextFill(Color.web("#4F7942"));
		HBox headerHBox = new HBox(10);
		headerHBox.setAlignment(Pos.TOP_LEFT);
		headerHBox.getChildren().addAll(logoImageView);
		
		VBox headerVBox = new VBox(10);
		headerVBox.setAlignment(Pos.TOP_LEFT);
		headerVBox.getChildren().addAll(headerHBox);
		
		 String combinedText = 
	                "Throughout this project, we will collaborate closely with Jawwal Company's - Administration department to develop\n" +
	                "a fleet management database.\n\n" +
	                "The primary goal of this database is to streamline the processes and procedures associated with organizing\n" +
	                "and coordinating the company's work vehicles.\n\n" +
	                "In recent times, Jawwal Company has encountered challenges concerning driver's license expiration dates,\n" +
	                "insurance policy expirations, tracking kilometers driven, and monitoring fuel consumption during each trip.\n\n" +
	                "To address these issues and enhance operational efficiency, the company is determined\n" +
	                "to establish a comprehensive data management system.\n\n" +
	                "This system will efficiently sort and organize all of this critical data, making it easily accessible.\n\n" +
	                "Through the implementation of this system, we will systematically record and organize all information related to employees and their respective vehicles.\n\n" +
	                "This data will not only help in resolving current challenges but also serve as a valuable resource for future reference and informed decision-making.";

	        Text text = new Text(combinedText);
	       // text.setStyle("-fx-text-fill: white;");
	       text.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 15));
	        text.setFill(Color.WHITE);
	        
	        
//		Label paragraph1 = createStyledLabel(
//				" Throughout this project, we will collaborate closely with Jawwal Company's - Administration department to develop\n a fleet management database.");
//		Label paragraph2 = createStyledLabel(
//				"The primary goal of this database is to streamline the processes and procedures associated with organizing\nand coordinating the company's work vehicles.");
//		Label paragraph3 = createStyledLabel(
//				"In recent times, Jawwal Company has encountered challenges concerning driver's license expiration dates,\ninsurance policy expirations, tracking kilometers driven, and monitoring fuel consumption during each trip.");
//		Label paragraph4 = createStyledLabel(
//				"To address these issues and enhance operational efficiency, the company is determined\n to establish a comprehensive data management system.");
//		Label paragraph5 = createStyledLabel(
//				"This system will efficiently sort and organize all of this critical data, making it easily accessible.");
//		Label paragraph6 = createStyledLabel(
//				"Through the implementation of this system, we will systematically record and organize all information related to employees and their respective vehicles.");
//		Label paragraph7 = createStyledLabel(
//				"This data will not only help in resolving current challenges but also serve as a valuable resource for future reference and informed decision-making.");
//		

		
//		paragraph1.setTextAlignment(TextAlignment.LEFT);
//		paragraph2.setTextAlignment(TextAlignment.LEFT);
//		paragraph3.setTextAlignment(TextAlignment.LEFT);
//		paragraph4.setTextAlignment(TextAlignment.LEFT);
//		paragraph5.setTextAlignment(TextAlignment.LEFT);
//		paragraph6.setTextAlignment(TextAlignment.LEFT);
//		paragraph7.setTextAlignment(TextAlignment.LEFT);
//		
//		paragraph1.setStyle("-fx-text-fill: white;");
//		paragraph2.setStyle("-fx-text-fill: white;");
//		paragraph3.setStyle("-fx-text-fill: white;");
//		paragraph4.setStyle("-fx-text-fill: white;");
//		paragraph5.setStyle("-fx-text-fill: white;");
//		paragraph6.setStyle("-fx-text-fill: white;");
//		paragraph7.setStyle("-fx-text-fill: white;");
//		
		
		VBox aboutVBox = new VBox(10);
		aboutVBox.setAlignment(Pos.CENTER);
		aboutVBox.setStyle("-fx-background-color: #123a4e");
		//paragraph1, paragraph2, paragraph3, paragraph4, paragraph5, paragraph6,paragraph7
		aboutVBox.getChildren().addAll(text);
		aboutVBox.setStyle(" -fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5);\r\n"
				+ "    -fx-border-width: 1px;\r\n" + "    -fx-border-radius: 5px;");
		
		VBox aboutLayout = new VBox(20);
		aboutLayout.setAlignment(Pos.CENTER);
		aboutLayout.setPadding(new Insets(10,10,10,10));
		aboutLayout.setStyle("-fx-background-color: #123a4e");
		aboutLayout.getChildren().addAll(headerVBox, aboutVBox);
		
		Scene aboutScene = new Scene(aboutLayout, 1000, 400);
		aboutStage.setScene(aboutScene);
		aboutStage.show();
	}

	private Label createStyledLabel(String text) {
		Label label = new Label(text);
		label.setFont(Font.font("Arial", FontWeight.BOLD, 16));
		return label;
	}
}
