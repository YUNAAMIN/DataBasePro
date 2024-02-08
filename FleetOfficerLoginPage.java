package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class FleetOfficerLoginPage {
	static Font fnormal = Font.font("Arial", FontWeight.MEDIUM, FontPosture.REGULAR, 15);
	static Font fnorma2 = Font.font("Arial", FontWeight.BLACK, FontPosture.REGULAR, 17);
	static Font fnormalbold = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 20);

	Font ftittle = Font.font("impact", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 20);
	private ArrayList<fleetofficer> data;

	private static String dbUsername = "root"; // database username
	private static String dbPassword = "yunayuna123"; // database password
//	private static String dbPassword = "zncyvl2003"; // database password
	private static String URL = "127.0.0.1"; // server location

	private static String port = "3306"; // port that mysql uses
	private static String dbName = "miniFleetsystem"; // database on mysql to connect to
	private static String dbURL;
	private static Connection con;

	public TextField usernameField = new TextField();
	static PasswordField passwordField = new PasswordField();

	// Assuming you have a method to check login credentials
	private boolean checkLoginCredentials(String username, String password) throws SQLException {
		try {
			connectDB();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String SQL = "SELECT * FROM officersLogin WHERE officer_id = ? AND officerpass = ?";
		try (PreparedStatement pstmt = con.prepareStatement(SQL)) {
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();
			boolean b = rs.next();
			con.close();
			// Check if there is any result
			return b;
		}

	}

	private static void connectDB() throws ClassNotFoundException, SQLException {

		dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName + "?verifyServerCertificate=false";
		Properties p = new Properties();
		p.setProperty("user", dbUsername);
		p.setProperty("password", dbPassword);
		p.setProperty("useSSL", "false");
		p.setProperty("autoReconnect", "true");
		// Class.forName("com.mysql.cj.jdbc.Driver");
		Class.forName("com.mysql.jdbc.Driver");

		con = DriverManager.getConnection(dbURL, p);

	}

	private void getData() throws Exception, ClassNotFoundException {

		String SQL;

		connectDB();
		System.out.println("Connection established");

		SQL = "select * from FleetOfficers where EmployeeID = '" + usernameField.getText() + "' ;"; // only getting user
																									// one cuz we log in
																									// as one
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);

		while (rs.next()) {
			data.add(new fleetofficer(rs.getInt("EmployeeID"), // Correct the column name here
					rs.getString("FleetOfficersName"), rs.getString("PhoneNumber"), rs.getString("Email"),
					rs.getString("DepartmentName"), rs.getString("WorkLocation")));
		}

		System.out.println(data.toString());

		rs.close();
		stmt.close();

		con.close();
		System.out.println("Connection closed" + data.size());

	}

	// Pane paneALL = new Pane();
	// ahs everything on this pane

	public void show() {
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Fleet Officer Login Page");
		ImageView logo = new ImageView(
				new Image("file:C:/Users/Administrator/eclipse-workspace/BASE_DBM/src/car1.png"));
		logo.setFitHeight(100);
		logo.setPreserveRatio(true);
		Label fleetOfficerLabel = new Label("Admin Login Page");
		fleetOfficerLabel.setFont(new Font("Impact", 40));
		fleetOfficerLabel.setTextFill(Color.web("#f2ffff")); // .setTextFill(Color.web("#355E3B")); // Dark Green text
																// color
		HBox headerBox = new HBox(10, logo, fleetOfficerLabel);
		headerBox.setAlignment(Pos.CENTER);
		Label usernameLabel = new Label("Username:");
		Label passwordLabel = new Label("Password:");
		usernameLabel.setFont(fnormal);
		passwordLabel.setFont(fnormal);

//		TextField usernameField = new TextField();
//		PasswordField passwordField = new PasswordField();
		Button loginButton = new Button("Login");
		loginButton.setStyle("-fx-background-color: #B0C4DE;");
		loginButton.setFont(fnormal);

		loginButton.setOnAction(e -> {
			fleetofficerHomepage f = new fleetofficerHomepage();
			data = new ArrayList<>();
			try {
				getData();
			} catch (ClassNotFoundException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			} catch (Exception e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
//			if ("1".equals(usernameField.getText()) && "1".equals(passwordField.getText())) {
//				System.out.println("Driver Login Successful!");
			try {
				if (checkLoginCredentials(usernameField.getText(), passwordField.getText())) {
					f.show();
					System.out.println("Fleet Officer Login Successful!");
					// Proceed with the rest of the login logic
				} else {
					System.out.println("Invalid username or password");
				}
			} catch (SQLException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			String SQL;

			try {
				connectDB();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Connection established");

			SQL = "select * from FleetOfficers where EmployeeID = '" + usernameField.getText() + "' ;"; // only getting
																										// user one cuz
																										// we log in as
																										// one
			Statement stmt = null;
			try {
				stmt = con.createStatement();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				ResultSet rs = stmt.executeQuery(SQL);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				int index = Integer.parseInt(usernameField.getText()) - 1;

				if (index >= 0 && index < data.size()) {
					fleetofficer f1 = data.get(index);

					// Rest of your code here
				} else {
					System.out.println("Invalid index");
				}
			} catch (NumberFormatException e1) {
				System.out.println("Invalid input for index");
			}

//				CREATE TABLE FleetOfficers (
//					    EmployeeID INT PRIMARY KEY,
//					    FleetOfficersName VARCHAR(100) UNIQUE ,
//					    PhoneNumber VARCHAR(10),
//					    Email VARCHAR(255),
//					    DepartmentName VARCHAR(100),
//					    WorkLocation VARCHAR(255),
//					    FOREIGN KEY (DepartmentName) REFERENCES Department(DepartmentName)
//					);

			fleetofficer d1 = data.get(0);
			int EmployeeID = d1.getEmployeeID();
			String FleetOfficersName = d1.getFleetOfficersName();
			String PhoneNumber = d1.getPhoneNumber();
			String Email = d1.getEmail();
			String DepartmentName = d1.getDepartmentName();
			String WorkLocation = d1.getWorkLocation();

			fleetofficerHomepage.tfEmployeeID.setText(EmployeeID + "");
			fleetofficerHomepage.tfFleetOfficersName.setText(FleetOfficersName);
			fleetofficerHomepage.tfPhoneNumber.setText(PhoneNumber);
			fleetofficerHomepage.tfEmail.setText(Email);
			fleetofficerHomepage.tfDepartmentName.setText(DepartmentName);
			fleetofficerHomepage.tfWorkLocation.setText(WorkLocation);

		});

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

		// resButton.setStyle(" -fx-background-color: linear-gradient(to bottom,
		// #218da4, #76b057);");
//#2E8B57

		Color color1 = Color.web("#2E8B57");
		Color color2 = Color.web("#4682B4");
		// Color.web("#218da4")//CornerRadii.EMPTYInsets.EMPTY
		grid.setBackground(new Background(new BackgroundFill(
				new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, new Stop(0, color1), new Stop(1, color2)),
				new CornerRadii(400), new Insets(10, 10, 10, 10))));
		usernameLabel.setTextFill(Color.WHITE);
		passwordLabel.setTextFill(Color.WHITE);
		usernameField.setStyle("-fx-background-color: #B0C4DE;");
		passwordField.setStyle("-fx-background-color: #B0C4DE;");

		VBox vbox1 = new VBox(10);
		// VBox vbox1 = new VBox(10);
		vbox1.getChildren().addAll(headerBox, grid);
		vbox1.setStyle(" -fx-background-color: #123a4e;");

		vbox1.setAlignment(Pos.CENTER);

		// vbox1.getChildren().addAll(headerBox,grid);
		Scene scene = new Scene(vbox1, 1000, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
