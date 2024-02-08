package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AboutUsPage {

	public void show() {
		Stage aboutUsStage = new Stage();
		aboutUsStage.setTitle("About Us");
		Image logoImage = new Image("C:\\Users\\Yuna\\eclipse-workspace\\DataBasePro\\src\\application\\logo.png");
		ImageView logoImageView = new ImageView(logoImage);
		logoImageView.setFitHeight(100);
		logoImageView.setPreserveRatio(true);
		//Label jawwalLabel = new Label("JAWWAL");
		//jawwalLabel.setFont(Font.font("Arial", FontWeight.BOLD, 40));
		//jawwalLabel.setTextFill(Color.web("#4F7942")); 
		HBox headerHBox = new HBox(10);
		headerHBox.setAlignment(Pos.TOP_LEFT);
		headerHBox.getChildren().addAll(logoImageView);
		VBox headerVBox = new VBox(10);
		headerVBox.setAlignment(Pos.TOP_LEFT);
		headerVBox.getChildren().addAll(headerHBox);
		HBox member1Box = createMemberBox("YUNA NAWAHDA", "file.jpg");
		HBox member2Box = createMemberBox("HANEEN SHADI", "file.jpg");
		HBox member3Box = createMemberBox("NOOR AHMAD", "file.jpg");
		HBox membersVBox = new HBox(20);
		membersVBox.setAlignment(Pos.CENTER);
		membersVBox.setStyle("-fx-background-color: #123a4e");
		membersVBox.getChildren().addAll(member1Box, member2Box, member3Box);
		VBox aboutUsLayout = new VBox(20);
		aboutUsLayout.setAlignment(Pos.CENTER);
		aboutUsLayout.setStyle("-fx-background-color: #123a4e");
		aboutUsLayout.getChildren().addAll(headerVBox, membersVBox);
		Scene aboutUsScene = new Scene(aboutUsLayout, 800, 400);
		aboutUsStage.setScene(aboutUsScene);
		aboutUsStage.show();
	}

	private HBox createMemberBox(String memberName, String photoFileName) {
		Image memberImage = new Image("C:\\Users\\Yuna\\eclipse-workspace\\DataBasePro\\src\\application\\file.jpg");
		ImageView memberImageView = new ImageView(memberImage);
		memberImageView.setFitWidth(150);
		memberImageView.setPreserveRatio(true);
		Label memberLabel = new Label(memberName);
		memberLabel.setStyle("-fx-text-fill: white;");
		memberLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
		VBox memberVBox = new VBox(10);
		memberVBox.setAlignment(Pos.CENTER);
		memberVBox.getChildren().addAll(memberImageView, memberLabel);
		HBox memberBox = new HBox(20);
		memberBox.setAlignment(Pos.CENTER);
		memberBox.getChildren().addAll(memberVBox);

		return memberBox;
	}

}
