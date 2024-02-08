package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Properties;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class DriverHomepage {

	// ====================================
	// datepicker=========================================================
	static DatePicker dpStartdate = new DatePicker();
	static DatePicker dpexperationdate = new DatePicker();
	static TextField tfphone = new TextField();
	static TextField tfemail = new TextField();
	static TextField tflivinglocation = new TextField();
	static TextField tfname = new TextField();
	static TextField tfcompanyid = new TextField();

	static TextField tfidcard = new TextField();

	static TextField tfdepartmnet = new TextField();
	static TextField tfdiroctorate = new TextField();
	static TextField tfcontarcttype = new TextField();
	static TextField tfworkloaction = new TextField();

	///////////////////////////////////////////////////////
	static TextField tfname1 = new TextField();
	static TextField tfdepartment1 = new TextField();

	/////////////////////////////////////////////////////////////

	static ArrayList<DriverRequestBox> request = new ArrayList<>();

	public static ArrayList<DriverRequestBox> getRequest() {
		return request;
	}

	public static void setRequest(ArrayList<DriverRequestBox> request) {
		DriverHomepage.request = request;
	}

	// ======================================================================

	static Font fnormal = Font.font("Arial", FontWeight.MEDIUM, FontPosture.REGULAR, 15);
	static Font fnorma2 = Font.font("Arial", FontWeight.BLACK, FontPosture.REGULAR, 17);
	static Font fnormalbold = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 20);
	Font ftittle = Font.font("impact", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 20);
	private ArrayList<drivers> data;

	private static String dbUsername = "root"; // database username
	private static String dbPassword = "yunayuna123"; // database password
	private static String URL = "127.0.0.1"; // server location

	private static String port = "3306"; // port that mysql uses
	private static String dbName = "miniFleetsystem"; // database on mysql to connect to
	private static String dbURL;
	private static Connection con;

	private static void connectDB() throws ClassNotFoundException, SQLException {

		dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName + "?verifyServerCertificate=false";
		Properties p = new Properties();
		p.setProperty("user", dbUsername);
		p.setProperty("password", dbPassword);
		p.setProperty("useSSL", "false");
		p.setProperty("autoReconnect", "true");
		Class.forName("com.mysql.jdbc.Driver");

		con = DriverManager.getConnection(dbURL, p);

	}

	private void getData() throws Exception, ClassNotFoundException {

		String SQL;

		connectDB();
		System.out.println("Connection established");

		SQL = "select * from Drivers where EmployeeNumber =1"; // only getting user one cuz we log in as one
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);

		while (rs.next()) {
			data.add(new drivers(rs.getInt("EmployeeNumber"), // Correct the column name here
					rs.getString("EmployeeName"), rs.getString("PhoneNumber"), rs.getString("IdentificationCardNumber"),
					rs.getDate("LicenceStartDate").toLocalDate(), rs.getDate("LicenceExpirationDate").toLocalDate(),
					rs.getString("Email"), rs.getString("DepartmentName"), rs.getString("DirectorateName"),
					rs.getString("ContractType"), rs.getString("WorkLocation"), rs.getString("LivingLocation"),
					rs.getDate("EntryDate").toLocalDate()));
		}

		System.out.println(data.toString());

		rs.close();
		stmt.close();

		con.close();
		System.out.println("Connection closed" + data.size());

	}

	public static void ExecuteStatement(String SQL) throws Exception {

		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(SQL);
			stmt.close();

		} catch (SQLException s) {
			s.printStackTrace();
			System.out.println("SQL statement is not executed!");

		}

	}

	public static void updatedriver(int driverNum, String phone, String datestart, String dateexpire, String livingloc,
			String email) {

		try {
//			System.out
//					.println("update  drivers set  PhoneNumber = '" + phone + "' where EmployeeNubber = " + driverNum);
			connectDB();
			ExecuteStatement(
					"update  drivers set  PhoneNumber = '" + phone + "' where EmployeeNumber = " + driverNum + ";");
			ExecuteStatement("update  drivers set  Email = '" + email + "' where EmployeeNumber = " + driverNum + ";");
			ExecuteStatement("update  drivers set  LivingLocation = '" + livingloc + "' where EmployeeNumber = "
					+ driverNum + ";");
			ExecuteStatement("update  drivers set  LicenceStartDate = '" + datestart + "' where EmployeeNumber = "
					+ driverNum + ";");
			ExecuteStatement("update  drivers set  LicenceExpirationDate = '" + dateexpire + "' where EmployeeNumber = "
					+ driverNum + ";");

			con.close();
			System.out.println("Connection closed");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public DriverHomepage() {

	}

//	public static void main(String[] args) {
//		launch(args);
//
//	}

//	@Override
//	public void start(Stage stage) throws Exception {
//		
//		// panes =================================================
//		VBox vbroot = new VBox(10);
//		vbroot.setPadding(new Insets(10, 10, 10, 10));
//		vbroot.setStyle(" -fx-background-color: #123a4e;");
//
//		VBox vbdate = new VBox(5);
//
//		HBox hbtop = new HBox(200);
//		hbtop.setPadding(new Insets(10, 10, 10, 10));
//
//		HBox hbmenu = new HBox(5);
//		hbmenu.setAlignment(Pos.CENTER_RIGHT);
//		
//		StackPane stackpane = new StackPane();
//
//		// images + imageveiw=====================================
//		Image imagelogo = new Image("file:C:/Users/Administrator/eclipse-workspace/BASE_TRY2/src/logo.png");// 270x120
//		ImageView imglogo = new ImageView(imagelogo);
//		imglogo.setFitWidth(101.25);// \67.5
//		imglogo.setFitHeight(45);// 30
//
//		Image imageinfo = new Image("file:C:/Users/Administrator/eclipse-workspace/BASE_TRY2/src/icon_white.png");// 270x120
//		ImageView imginfo = new ImageView(imageinfo);
//		imginfo.setFitWidth(30);
//		imginfo.setFitHeight(30);
//
//		// menu ===============================================
//		ContextMenu mainmenu = new ContextMenu();
//
//		MenuItem mitem1 = new MenuItem("Make Car Request");
//		MenuItem mitem2 = new MenuItem("Mail");
//		MenuItem mitem3 = new MenuItem("My Profile");
//
//		mainmenu.getItems().addAll(mitem1, mitem2, mitem3);
//		
//		
//        mainmenu.setStyle("-fx-background-color: rgba(255, 255, 255, 0.7); -fx-background-radius: 5; -fx-border-radius: 5;");
//
//
//        mitem1.setOnAction(e->{
//        
//        stackpane.getChildren().clear();
//        	
//        	stackpane.getChildren().add(requestbox());
//        	System.out.println("hellp");
//        });
//        
//        mitem2.setOnAction(e->{
//        	 stackpane.getChildren().clear();
//         	//messegesbox()
//         	//vbroot.getChildren().add();
//         	System.out.println("hellp");
//        });
// 
//        mitem3.setOnAction(e->{
//        	 stackpane.getChildren().clear();
//         	
//        	
//         	stackpane.getChildren().add(myprofilebox());
//         	System.out.println("hellp");
//        });
//
//	
//
//		// button ==============================================
//		Button btinfo = new Button("Info", imginfo);
//
//		btinfo.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-text-fill: white;");
//		btinfo.setOnMouseClicked(e -> {
//			if (e.getButton().toString().equals("PRIMARY")) { // Right mouse button
//				mainmenu.show(btinfo, e.getScreenX(), e.getScreenY());
//			}
//		});
//		
//		
//		Button btrequest = new Button("Make car request");
//		btrequest.setOnAction(e->{
//			stackpane.getChildren().clear();
//			stackpane.getChildren().addAll(requestbox());
//			btrequest.setVisible(false);
//		});
//		
//		// labels=================================================
//
//		// get the date=========================================
//		LocalDate currentDate = LocalDate.now();
//		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//		String formattedDate = currentDate.format(dateFormatter);
//
//		LocalTime currentTime = LocalTime.now();
//		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
//		String formattedTime = currentTime.format(timeFormatter);
//
//		// label===============================================
//		Label lbDate = new Label(formattedDate);
//		Label lbTime = new Label(formattedTime);
//		Label lbwelcome = new Label();
//
//		/////////////
//
//		int hour = currentTime.getHour();
//		if (hour >= 6 && hour < 12) {
//			lbwelcome.setText("Good Morning,user!");
//		} else if (hour >= 12 && hour < 18) {
//			lbwelcome.setText("Good Afternoon,uder!");
//
//		} else {
//			lbwelcome.setText("Good Evening,user!");
//
//		}
//		///////////////////
//
//		lbDate.setFont(fnormal);
//		lbTime.setFont(fnormal);
//		lbwelcome.setFont(ftittle);
//		lbDate.setStyle("-fx-text-fill: white;");
//		lbTime.setStyle("-fx-text-fill: white;");
//		lbwelcome.setStyle("-fx-text-fill: white;");
//
//		// ===========================================================
//		vbdate.getChildren().addAll(lbTime, lbDate);
//		hbtop.getChildren().addAll(imglogo, lbwelcome, vbdate);
//		// hbmenu.getChildren().add(menubarMain);
//		hbmenu.getChildren().add(btinfo);
//		vbroot.getChildren().addAll(hbtop, hbmenu,btrequest,stackpane);
//
//		Scene s = new Scene(vbroot, 900, 500);
//		stage.setTitle("Admin");
//		stage.setScene(s);
//		stage.show();
//
//	}

	public void show() {
		// fill the array
		try {
			connectDB();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			data = new ArrayList<>();
			getData();
			System.out.println("size: " + data.size());

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Stage stage = new Stage();
		// panes =================================================
		VBox vbroot = new VBox(10);
		vbroot.setPadding(new Insets(10, 10, 10, 10));
		vbroot.setStyle(" -fx-background-color: #123a4e;");

		VBox vbdate = new VBox(5);

		HBox hbtop = new HBox(200);
		hbtop.setPadding(new Insets(10, 10, 10, 10));

		HBox hbmenu = new HBox(5);
		hbmenu.setAlignment(Pos.CENTER_RIGHT);

		StackPane stackpane = new StackPane();

		// images + imageveiw=====================================
		Image imagelogo = new Image("C:\\Users\\Yuna\\eclipse-workspace\\DataBasePro\\src\\application\\logo.png");// 270x120
		ImageView imglogo = new ImageView(imagelogo);
		imglogo.setFitWidth(101.25);// \67.5
		imglogo.setFitHeight(45);// 30

		Image imageinfo = new Image(
				"C:\\Users\\Yuna\\eclipse-workspace\\DataBasePro\\src\\application\\icon_white.png");// 270x120
		ImageView imginfo = new ImageView(imageinfo);
		imginfo.setFitWidth(30);
		imginfo.setFitHeight(30);

		// menu ===============================================
		ContextMenu mainmenu = new ContextMenu();

		MenuItem mitem1 = new MenuItem("Make Car Request");
		MenuItem mitem2 = new MenuItem("Mail");
		MenuItem mitem3 = new MenuItem("My Profile");

		mainmenu.getItems().addAll(mitem1, mitem2, mitem3);

		mainmenu.setStyle(
				"-fx-background-color: rgba(255, 255, 255, 0.7); -fx-background-radius: 5; -fx-border-radius: 5;");

		mitem1.setOnAction(e -> {

			stackpane.getChildren().clear();

			stackpane.getChildren().add(requestbox());
			drivers d = data.get(0);
			tfname1.setText(d.getEmployeeName());
			tfdepartment1.setText(d.getDepartmentName());

			System.out.println("hellp");
		});

		mitem2.setOnAction(e -> {
			stackpane.getChildren().clear();
			// messegesbox()
			// vbroot.getChildren().add();
			System.out.println("hellp");
		});

		mitem3.setOnAction(e -> {
			stackpane.getChildren().clear();

			stackpane.getChildren().add(myprofilebox());

			try {
				connectDB();
			} catch (ClassNotFoundException | SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				data = new ArrayList<>();
				getData();
				System.out.println("size: " + data.size());

				drivers d = data.get(0);
				int employeeNumber = d.getEmployeeNumber();
				String employeeName = d.getEmployeeName();
				String phoneNumber = d.getPhoneNumber();
				String identificationCardNumber = d.getIdentificationCardNumber();
				LocalDate licenceStartDate = d.getLicenceStartDate();
				LocalDate licencexpire = d.getLicenceExpirationDate();
				String email = d.getEmail();
				String depratment = d.getDepartmentName();
				String diroctrate = d.getDirectorateName();
				String comtracttype = d.getContractType();
				String worklocation = d.getWorkLocation();
				String livinglocation = d.getLivingLocation();

				tfname.setText(employeeName);
				tfcompanyid.setText(employeeNumber + "");
				tfphone.setText(phoneNumber);
				tfidcard.setText(identificationCardNumber);
				dpStartdate.setValue(licenceStartDate);
				dpexperationdate.setValue(licencexpire);
				tfemail.setText(email);
				tfdepartmnet.setText(depratment);
				tfdiroctorate.setText(diroctrate);
				tfcontarcttype.setText(comtracttype);
				tfworkloaction.setText(worklocation);
				tflivinglocation.setText(livinglocation);

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			System.out.println("this is info about 1\n\n" + data.toString());

			System.out.println("profile");
		});

		// button ==============================================
		Button btinfo = new Button("Info", imginfo);

		btinfo.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-text-fill: white;");
		btinfo.setOnMouseClicked(e -> {
			if (e.getButton().toString().equals("PRIMARY")) { // Right mouse button
				mainmenu.show(btinfo, e.getScreenX(), e.getScreenY());
			}
		});

		Button btrequest = new Button("Make car request");
		btrequest.setOnAction(e -> {
			stackpane.getChildren().clear();
			stackpane.getChildren().addAll(requestbox());

			drivers d = data.get(0);
			tfname1.setText(d.getEmployeeName());
			tfdepartment1.setText(d.getDepartmentName());

			btrequest.setVisible(false);
		});

		// labels=================================================

		// get the date=========================================
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String formattedDate = currentDate.format(dateFormatter);

		LocalTime currentTime = LocalTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
		String formattedTime = currentTime.format(timeFormatter);

		// label===============================================
		Label lbDate = new Label(formattedDate);
		Label lbTime = new Label(formattedTime);
		Label lbwelcome = new Label();

		/////////////

		int hour = currentTime.getHour();
		if (hour >= 6 && hour < 12) {
			lbwelcome.setText("Good Morning,user!");
		} else if (hour >= 12 && hour < 18) {
			lbwelcome.setText("Good Afternoon,uder!");

		} else {
			lbwelcome.setText("Good Evening,user!");

		}
		///////////////////

		lbDate.setFont(fnormal);
		lbTime.setFont(fnormal);

		lbwelcome.setFont(ftittle);
		lbDate.setStyle("-fx-text-fill: white;");
		lbTime.setStyle("-fx-text-fill: white;");
		lbwelcome.setStyle("-fx-text-fill: white;");

		// ===========================================================
		vbdate.getChildren().addAll(lbTime, lbDate);
		hbtop.getChildren().addAll(imglogo, lbwelcome, vbdate);
		// hbmenu.getChildren().add(menubarMain);
		hbmenu.getChildren().add(btinfo);

		vbroot.getChildren().addAll(hbtop, hbmenu, btrequest, stackpane);

		Scene s = new Scene(vbroot, 900, 500);
		stage.setTitle("Admin");
		stage.setScene(s);
		stage.show();
	}

	public static VBox requestbox() {
		// panes=====================================================

		GridPane gridpane = new GridPane();
		gridpane.setHgap(10);
		gridpane.setVgap(10);

		VBox main = new VBox(15);
		main.setPadding(new Insets(10, 10, 10, 10));
		main.setStyle(" -fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5);\r\n"
				+ "    -fx-border-width: 3px;\r\n" + "    -fx-border-radius: 5px;");

		HBox hbrequest = new HBox(10);

		// labels============================================================

		Label lb1 = new Label("Name");
		Label lb2 = new Label("Department name ");
		Label lb3 = new Label("Departure location");
		Label lb4 = new Label("Destination");
		Label lb5 = new Label("Drop-off location");
		Label lb6 = new Label("Company location");
		Label lb7 = new Label("Type of transport prefrence");// car taxi driver
		Label lbres = new Label("no request made yet!");

		lb1.setFont(fnormal);
		lb2.setFont(fnormal);
		lb3.setFont(fnormal);
		lb4.setFont(fnormal);
		lb5.setFont(fnormal);
		lb6.setFont(fnormal);
		lb7.setFont(fnormal);
		lbres.setFont(fnormal);

		lb1.setStyle("-fx-text-fill: white;");
		lb2.setStyle("-fx-text-fill: white;");
		lb3.setStyle("-fx-text-fill: white;");
		lb4.setStyle("-fx-text-fill: white;");
		lb5.setStyle("-fx-text-fill: white;");
		lb6.setStyle("-fx-text-fill: white;");
		lb7.setStyle("-fx-text-fill: white;");
		lbres.setStyle("-fx-text-fill: white;");

		// textfeild===========================================================

		TextField tfdepartuure = new TextField();
		TextField tfdestination = new TextField();
		TextField tfdropoff = new TextField();

		tfname1.setStyle(
				"-fx-background-color: transparent; -fx-text-fill: white;-fx-border-style: hidden hidden solid hidden; -fx-border-color: white;");
		tfdepartment1.setStyle(
				"-fx-background-color: transparent; -fx-text-fill: white;-fx-border-style: hidden hidden solid hidden; -fx-border-color: white;");
		tfname1.setEditable(false);
		tfdepartment1.setEditable(false);

		tfdepartuure.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);-fx-text-fill: white;");
		tfdestination.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);-fx-text-fill: white;");
		tfdropoff.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);-fx-text-fill: white;");

		// radiobutton==========================================================
		ToggleGroup group1 = new ToggleGroup();
		RadioButton rb11 = new RadioButton("Rammallah HQ");
		RadioButton rb12 = new RadioButton("Nablus HQ");
		RadioButton rb13 = new RadioButton("Hebron office");
		rb11.setToggleGroup(group1);
		rb12.setToggleGroup(group1);
		rb13.setToggleGroup(group1);
		rb11.setFont(fnormal);
		rb12.setFont(fnormal);
		rb13.setFont(fnormal);
		rb11.setStyle("-fx-text-fill: white;");
		rb12.setStyle("-fx-text-fill: white;");
		rb13.setStyle("-fx-text-fill: white;");

		ToggleGroup group2 = new ToggleGroup();
		RadioButton rb21 = new RadioButton("Car");
		RadioButton rb22 = new RadioButton("Taxi");
		rb21.setToggleGroup(group2);
		rb22.setToggleGroup(group2);
		rb21.setFont(fnormal);
		rb22.setFont(fnormal);
		rb21.setStyle("-fx-text-fill: white;");
		rb22.setStyle("-fx-text-fill: white;");

		// button==============================================================
		Button btsend = new Button("Send request");
		btsend.setAlignment(Pos.BOTTOM_RIGHT);
		btsend.setFont(fnormal);

		btsend.setStyle(" -fx-background-color: linear-gradient(to bottom, #218da4, #76b057);");// -fx-background-color:
																								// #4F7942
		btsend.setTextFill(Color.web("#FFFFFF"));

		btsend.setOnAction(e -> {
			String radio1 = "";
			String radio2 = "";

			if (rb11.isSelected()) {
				radio1 = rb11.getText();
			}

			if (rb12.isSelected()) {
				radio1 = rb12.getText();
			}

			if (rb13.isSelected()) {
				radio1 = rb13.getText();
			}

			if (rb21.isSelected()) {
				radio2 = rb21.getText();
			}

			if (rb22.isSelected()) {
				radio2 = rb22.getText();
			}

			DriverRequestBox d = new DriverRequestBox(tfname1.getText(), tfdepartment1.getText(),
					tfdepartuure.getText(), tfdestination.getText(), tfdropoff.getText(), radio1, radio2);
			request.add(d);
			System.out.println(request);

			// System.out.println(group1.getSelectedToggle().toString());
			// request.add(new DriverRequestBox(tfname1.getText()),
			// tfdepartment1.toString(), tfdepartuure.toString(), tfdestination.toString(),
			// tfdropoff.toString(), selectedToggle1.toString() ,selectedToggle2.toString()
			// ));
//System.out.println(request);

		});

		////////////////////////////////////////////////////////////////
		gridpane.addRow(0, lb1, tfname1);
		gridpane.addRow(1, lb2, tfdepartment1);
		gridpane.addRow(2, lb3, tfdepartuure);
		gridpane.addRow(3, lb4, tfdestination);
		gridpane.addRow(4, lb5, tfdropoff);
		gridpane.addRow(5, lb6, rb11, rb12, rb13);
		gridpane.addRow(6, lb7, rb21, rb22);

		hbrequest.getChildren().addAll(btsend);

		main.getChildren().addAll(gridpane, btsend);
		return main;

	}

	public static VBox myprofilebox() {
		// panes=====================================================

		GridPane gridpane = new GridPane();
		gridpane.setHgap(10);
		gridpane.setVgap(15);
		gridpane.setPadding(new Insets(10, 10, 10, 10));

		VBox main = new VBox(15);
		main.setPadding(new Insets(10, 10, 10, 10));
		main.setStyle(" -fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5);\r\n"
				+ "    -fx-border-width: 3px;\r\n" + "    -fx-border-radius: 5px;");

		HBox hb1 = new HBox(5);
		HBox hb2 = new HBox(5);

		HBox hb31 = new HBox(5);
		HBox hb32 = new HBox(5);
		HBox hb3 = new HBox(15);

		HBox hb41 = new HBox(5);
		HBox hb42 = new HBox(5);
		VBox vb43 = new VBox(10);
		HBox hb4 = new HBox(15);

		HBox hb = new HBox(5);

		HBox hb51 = new HBox(5);
		HBox hb52 = new HBox(5);
		HBox hb5 = new HBox(15);

		HBox hb6 = new HBox(5);
		HBox hb7 = new HBox(5);

		HBox hb8 = new HBox(5);

		StackPane stackperson = new StackPane();
		VBox vbphoto = new VBox(10);
		stackperson.setStyle(" -fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5);\r\n"
				+ "    -fx-border-width: 3px;\r\n" + "    -fx-border-radius: 5px;");

		HBox hbtotal = new HBox(200);
		hbtotal.setPadding(new Insets(10, 10, 10, 10));
		hbtotal.setAlignment(Pos.CENTER);
		// labels============================================================

		Label lb1 = new Label("Name");
		Label lb2 = new Label("Company ID ");
		Label lb3 = new Label("Phone number");
		Label lb4 = new Label("Email");
		Label lb5 = new Label("ID card number");
		Label lb6 = new Label("License start date ");
		Label lb7 = new Label("License experation date");
		Label lb8 = new Label("Department name");
		Label lb9 = new Label("Directorate name ");
		Label lb10 = new Label("Contract type");
		Label lb11 = new Label("Work location");
		Label lb12 = new Label("Living location ");
		Label lbres = new Label("-");

		lb1.setFont(fnorma2);
		lb2.setFont(fnorma2);
		lb3.setFont(fnorma2);
		lb4.setFont(fnorma2);
		lb5.setFont(fnorma2);
		lb6.setFont(fnorma2);
		lb7.setFont(fnorma2);
		lb8.setFont(fnorma2);
		lb9.setFont(fnorma2);
		lb10.setFont(fnorma2);
		lb11.setFont(fnorma2);
		lb12.setFont(fnorma2);
		lbres.setFont(fnorma2);

		lb1.setStyle("-fx-text-fill: white;");
		lb2.setStyle("-fx-text-fill: white;");
		lb3.setStyle("-fx-text-fill: white;");
		lb4.setStyle("-fx-text-fill: white;");
		lb5.setStyle("-fx-text-fill: white;");
		lb6.setStyle("-fx-text-fill: white;");
		lb7.setStyle("-fx-text-fill: white;");
		lb8.setStyle("-fx-text-fill: white;");
		lb9.setStyle("-fx-text-fill: white;");
		lb10.setStyle("-fx-text-fill: white;");
		lb11.setStyle("-fx-text-fill: white;");
		lb12.setStyle("-fx-text-fill: white;");
		lbres.setStyle("-fx-text-fill: white;");

		/////////////////////////////////////////////////

//		 nonEditableTextField.setEditable(false);
//
//	        // Apply CSS styling to make background transparent and text color white
//	        nonEditableTextField.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");

		tfname.setEditable(false);
		tfcompanyid.setEditable(false);
		tfcontarcttype.setEditable(false);
		tfdepartmnet.setEditable(false);
		tfdiroctorate.setEditable(false);
		tfidcard.setEditable(false);
		tfworkloaction.setEditable(false);

		tfname.setStyle(
				"-fx-background-color: transparent; -fx-text-fill: white;-fx-border-style: hidden hidden solid hidden; -fx-border-color: white;");
		tfcompanyid.setStyle(
				"-fx-background-color: transparent; -fx-text-fill: white;-fx-border-style: hidden hidden solid hidden; -fx-border-color: white;");
		tfcontarcttype.setStyle(
				"-fx-background-color: transparent; -fx-text-fill: white;-fx-border-style: hidden hidden solid hidden; -fx-border-color: white;");
		tfdepartmnet.setStyle(
				"-fx-background-color: transparent; -fx-text-fill: white;-fx-border-style: hidden hidden solid hidden; -fx-border-color: white;");
		tfdiroctorate.setStyle(
				"-fx-background-color: transparent; -fx-text-fill: white;-fx-border-style: hidden hidden solid hidden; -fx-border-color: white;");
		tfidcard.setStyle(
				"-fx-background-color: transparent; -fx-text-fill: white;-fx-border-style: hidden hidden solid hidden; -fx-border-color: white;");
		tfworkloaction.setStyle(
				"-fx-background-color: transparent; -fx-text-fill: white;-fx-border-style: hidden hidden solid hidden; -fx-border-color: white;");

		tfphone.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);-fx-text-fill: white;");
		tfemail.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);-fx-text-fill: white;");
		tflivinglocation.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);-fx-text-fill: white;");

		// button==============================================================
		Button btupdate = new Button("update");
		btupdate.setAlignment(Pos.BOTTOM_RIGHT);
		btupdate.setFont(fnormal);
		btupdate.setFont(new Font("Arial", 15));
		btupdate.setStyle(" -fx-background-color: linear-gradient(to bottom, #218da4, #76b057);");// -fx-background-color:
																									// #4F7942
		btupdate.setTextFill(Color.web("#FFFFFF"));

		btupdate.setOnAction(e -> {
			updatedriver(1, tfphone.getText(), dpStartdate.getValue().toString(),
					dpexperationdate.getValue().toString(), tflivinglocation.getText(), tfemail.getText());
		});

		Button btuploadpic = new Button("Upload license photo");
		btuploadpic.setFont(fnormal);
		btuploadpic.setFont(new Font("Arial", 15));
		btuploadpic.setStyle(" -fx-background-color: linear-gradient(to bottom, #218da4, #76b057);");// -fx-background-color:
																										// #4F7942
		btuploadpic.setTextFill(Color.web("#FFFFFF"));

		Button btphoto = new Button("Change photo");
		btphoto.setFont(fnormal);
		btphoto.setFont(new Font("Arial", 15));
		btphoto.setStyle(" -fx-background-color: linear-gradient(to bottom, #218da4, #76b057);");// -fx-background-color:
																									// #4F7942
		btphoto.setTextFill(Color.web("#FFFFFF"));

		// image ==================================================================
		Image imageperson = new Image("C:\\Users\\Yuna\\eclipse-workspace\\DataBasePro\\src\\application\\person.png");
		ImageView imgperson = new ImageView(imageperson);
		imgperson.setFitWidth(150);
		imgperson.setFitHeight(130);
		stackperson.getChildren().add(imgperson);
		vbphoto.getChildren().addAll(stackperson, btphoto);

		vbphoto.setAlignment(Pos.TOP_RIGHT);

		////////////////////////////////////////////////////////////////

		hb1.getChildren().addAll(lb1, tfname);
		hb2.getChildren().addAll(lb2, tfcompanyid);

		hb31.getChildren().addAll(lb3, tfphone);
		hb32.getChildren().addAll(lb4, tfemail);
		hb3.getChildren().addAll(hb31, hb32);

		hb.getChildren().addAll(lb5, tfidcard);

		hb41.getChildren().addAll(lb6, dpStartdate);
		hb42.getChildren().addAll(lb7, dpexperationdate);
		vb43.getChildren().addAll(hb41, hb42);
		hb4.getChildren().addAll(vb43, btuploadpic);

		hb51.getChildren().addAll(lb8, tfdepartmnet);
		hb52.getChildren().addAll(lb9, tfdiroctorate);
		hb5.getChildren().addAll(hb51, hb52);

		hb6.getChildren().addAll(lb10, tfcontarcttype);
		hb7.getChildren().addAll(lb11, tfworkloaction);
		hb8.getChildren().addAll(lb12, tflivinglocation);

		gridpane.addRow(0, hb1);
		gridpane.addRow(1, hb2);
		gridpane.addRow(2, hb3);
		gridpane.addRow(3, hb4);
		gridpane.addRow(4, hb5);
		gridpane.addRow(5, hb6);
		gridpane.addRow(6, hb7);
		gridpane.addRow(7, hb8);
		gridpane.addRow(8, btupdate, lbres);

		hbtotal.getChildren().addAll(gridpane, vbphoto);

		main.getChildren().addAll(hbtotal);
		return main;

	}

	public static void messegesbox() {

	}

}
