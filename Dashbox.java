package application;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class Dashbox extends StackPane {

	public Dashbox(String s, ImageView im) {
		Font fnormal =Font.font("Arial", FontWeight.MEDIUM, FontPosture.REGULAR, 15);
		Rectangle roundedRectangle = new Rectangle(200, 100);
		roundedRectangle.setArcWidth(20); 
		roundedRectangle.setArcHeight(20); 
		roundedRectangle.setStyle("-fx-background-color: #c0edfa;");
		roundedRectangle.setFill(Color.LIGHTBLUE);

		Label lb = new Label(s);
		lb.setFont(fnormal);
		getChildren().addAll(roundedRectangle,im,lb);

	}

}
