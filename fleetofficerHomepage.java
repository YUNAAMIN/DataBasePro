package application;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Properties;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class fleetofficerHomepage {
	
	// datepicker=========================================================

	    
		static TextField tfEmployeeID = new TextField();
		static TextField tfFleetOfficersName = new TextField();
		static TextField tfname = new TextField();
		static TextField tfPhoneNumber = new TextField();
		static TextField tfEmail = new TextField();
		static TextField tfDepartmentName = new TextField();
		static TextField tfWorkLocation = new TextField();
		
		static ArrayList<String> e = new ArrayList<>();
		
		//======================================================================
	private static String dbUsername = "root"; // database username
//	private static String dbPassword = "zncyvl2003"; // database password
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

	public static String ExecuteStatementCOUNT(String sql) throws SQLException {

		int count =0 ;
	
		try {
			//Creating the Statement object
	      Statement stmt = con.createStatement();
	      //Query to get the number of rows in a table
	      //String query = "select count(*) from car";
	      //Executing the query
	      ResultSet rs = stmt.executeQuery(sql);
	      //Retrieving the result
	      rs.next();
	      count = rs.getInt(1);
		
			
			
		

		} catch (SQLException m) {
			m.printStackTrace();
			Main.error(sql);
			System.out.println("SQL statement is not executed!");
		}
		return String.valueOf(count);

	}

	public static void ExecuteStatement(String SQL) throws SQLException {

		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(SQL);
			stmt.close();

		} catch (SQLException s) {
			s.printStackTrace();
			Main.error(SQL);
			System.out.println("SQL statement is not executed!");
		}

	}
	static Font fnormal = Font.font("Arial", FontWeight.MEDIUM, FontPosture.REGULAR, 15);
	static Font fnorma2 = Font.font("Arial", FontWeight.BLACK, FontPosture.REGULAR, 17);

	static Font fnormalbold = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 20);
	Font ftittle = Font.font("impact", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 20);
	
	static DBFX dbfx= new DBFX();

//	public static void main(String[] args) {
//		launch(args);
//
//	}

	public fleetofficerHomepage() {

	}

//
//	@Override
//	public void start(Stage stage) throws Exception {
//		// PANES=========================================================
//		VBox root = new VBox(10);
//		root.setPadding(new Insets(10, 10, 10, 10));
//		// root.setStyle(" -fx-background-color: linear-gradient(to bottom, #218da4,
//		// #76b057);");
//		root.setStyle(" -fx-background-color: #123a4e;");
//		Pane panemenu = new Pane();
//
//		StackPane logopane = new StackPane();// has the image
//
//		VBox vbdate = new VBox(5);
//		vbdate.setAlignment(Pos.CENTER_RIGHT);
//
//		HBox hbtop = new HBox(200);
//		hbtop.setAlignment(Pos.CENTER);
//
//		HBox hbdash = new HBox(10);
//		hbdash.setPadding(new Insets(10, 10, 10, 10));
//		hbdash.setStyle(" -fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5);\r\n"
//				+ "    -fx-border-width: 3px;\r\n" + "    -fx-border-radius: 5px;");
//
//	    
//		HBox hbboxes = new HBox(10);
//		hbboxes.setPadding(new Insets(10, 10, 10, 10));
//		
//
//		// menu + menubar ===============================================
//
//		MenuBar menubarMain = new MenuBar();
//	
//		menubarMain.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
//
//		// menubarMain.setStyle("-fx-background-color: transparent; ");
//		// menubarMain.setStyle("-fx-text-fill: white; ");
//
//		Menu M1 = new Menu("M1");
//		Menu M2 = new Menu("M2");
//		
//
//		// M1.setStyle("-fx-text-fill: white;");
//		// M2.setStyle("-fx-text-fill: white;");
//
//		MenuItem mt1 = new MenuItem("click hehe");
//
//		Screen screen = Screen.getPrimary();
//		Rectangle2D bounds = screen.getVisualBounds();
//		menubarMain.setPrefWidth(bounds.getWidth());
//
//		
//		M1.getItems().add(mt1);
//		menubarMain.getMenus().addAll(M1, M2);
//
//		// menubar handlers======================================
////		mt1.setOnAction(e->{
////			Button bt = new Button("hi");
////			System.out.println("worked");
////			
////			Scene sc = new Scene(bt,400,400);
////			stage.setScene(sc);
////		});
//
//		mt1.setOnAction(e -> {
//
//		});
////		
//
//		// images===================================================
//		Image imagelogo = new Image("file:C:/Users/Administrator/eclipse-workspace/BASE_TRY2/src/logo.png");// 270x120
//		Image imagecars = new Image("file:C:/Users/Administrator/eclipse-workspace/BASE_TRY2/src/carShadow.png");
//		Image imageperson = new Image("file:C:/Users/Administrator/eclipse-workspace/BASE_TRY2/src/person.png");
//
//		//imageviews=====================================================
//		ImageView imglogo = new ImageView(imagelogo);
//		imglogo.setFitWidth(101.25);// \67.5
//		imglogo.setFitHeight(45);// 30
//
//		ImageView imgcar = new ImageView(imagecars);
//		imgcar.setFitWidth(150);// \67.5
//		imgcar.setFitHeight(150);// 30
//
//		ImageView imgperson = new ImageView(imageperson);
//		imgperson.setFitWidth(100);// \67.5
//		imgperson.setFitHeight(80);// 30
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
//		String userName = System.getProperty("user.name");
//		int hour = currentTime.getHour();
//		if (hour >= 6 && hour < 12) {
//			lbwelcome.setText("Good Morning, " + userName + "!");
//		} else if (hour >= 12 && hour < 18) {
//			lbwelcome.setText("Good Afternoon, " + userName + "!");
//
//		} else {
//			lbwelcome.setText("Good Evening, " + userName + "!");
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
//
//		// dashboard boxes============================================
//		Dashbox dbnumofdrivers = new Dashbox("# Total Drivers: 0 ", imgcar);
//		Dashbox dbnumofcars = new Dashbox("# Cars : 0 ", imgperson);
//		// dbnumofcars.getChildren().add(imgcar);
//
//		hbdash.getChildren().addAll(dbnumofcars, dbnumofdrivers);
//
//		// ===========================
//		panemenu.getChildren().add(menubarMain);
//
//		logopane.getChildren().add(imglogo);
//
//		vbdate.getChildren().addAll(lbTime, lbDate);
//		hbtop.getChildren().addAll(logopane, lbwelcome, vbdate);
//		
//		hbboxes.getChildren().addAll(vehicleStatusbox(),vehicle2());
//		root.getChildren().addAll(hbtop, panemenu, hbdash,hbboxes);
//
//		Scene s = new Scene(root, 700, 500);
//		stage.setTitle("Admin");
//		stage.setScene(s);
//		stage.show();
//
//	}

//TabPane maintabpain = new TabPane();
//Tab tab1 = new Tab("tab1");
//Tab tab2 = new Tab("tab2");
	public void show() throws SQLException, ClassNotFoundException {

		// maintabpain.getTabs().addAll(tab1,tab2);

		Stage stage = new Stage();

		// PANES=========================================================

		VBox all = new VBox(10);
		all.setStyle(" -fx-background-color: #123a4e;");

		VBox root = new VBox(10);
		root.setPadding(new Insets(10, 10, 10, 10));
		// root.setStyle(" -fx-background-color: linear-gradient(to bottom, #218da4,
		// #76b057);");
		root.setStyle(" -fx-background-color: #123a4e;");
		Pane panemenu = new Pane();

		StackPane logopane = new StackPane();// has the image

		VBox vbdate = new VBox(5);
		vbdate.setAlignment(Pos.CENTER_RIGHT);

		HBox hbtop = new HBox(200);
		hbtop.setAlignment(Pos.CENTER);

		HBox hbdash = new HBox(10);
		hbdash.setPadding(new Insets(10, 10, 10, 10));
		hbdash.setStyle(" -fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5);\r\n"
				+ "    -fx-border-width: 3px;\r\n" + "    -fx-border-radius: 5px;");

		HBox hbboxes = new HBox(10);
		hbboxes.setPadding(new Insets(10, 10, 10, 10));

		// menu + menubar ===============================================

		MenuBar menubarMain = new MenuBar();

		menubarMain.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

		// menubarMain.setStyle("-fx-background-color: transparent; ");
		// menubarMain.setStyle("-fx-text-fill: white; ");
		Menu M0 = new Menu("HOME");
		Menu M1 = new Menu("Car"); // cars , car distribution ,car tickets // total car request
		Menu M3 = new Menu("Trips");// car trips , taxi trips
		Menu M4 = new Menu("Coupon & Cards");// fuel card, fuel coupon, wash coupon
		Menu M5 = new Menu("Requests"); // total car reqest
		Menu M6 = new Menu("Compenies"); // taxi, rental ,fuel,insurance,wash
		Menu M7 = new Menu("Accident & Maintenance");
		Menu M8 = new Menu("Reports");
		Menu M9 = new Menu("Departments");
		Menu M10 = new Menu("Driver");
		Menu M11 = new Menu("Settings");

		// fro m0======================================================================
		MenuItem mt0 = new MenuItem("back to home");
		M0.getItems().add(mt0);

		mt0.setOnAction(e -> {
			all.getChildren().clear();
			all.getChildren().addAll(hbdash, hbboxes,requestlistveiw());

		});

		// for m1=============================================
		MenuItem mt11 = new MenuItem("Cars");
		MenuItem mt12 = new MenuItem("Car Distribution");
		MenuItem mt13 = new MenuItem("Car tickets");
		M1.getItems().addAll(mt11, mt12, mt13);

		mt11.setOnAction(e -> {
			carTableview c = new carTableview();
			all.getChildren().clear();
			all.getChildren().addAll(c.cartable(stage));
			
		});
		mt12.setOnAction(e->{
			all.getChildren().clear();
			all.getChildren().addAll(dbfx.CarDistributiontable(stage));
		});

		mt13.setOnAction(e->{
			table_CarTicket t = new table_CarTicket();
			all.getChildren().clear();
			try {
				all.getChildren().addAll(t.requesttable(stage));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});



		// for m3=================================================
		MenuItem mt31 = new MenuItem("Car trips");
		MenuItem mt32 = new MenuItem("Taxi trips");
		M3.getItems().addAll(mt31, mt32);
		
		mt31.setOnAction(e->{
			table_Cartrip c = new table_Cartrip();
			all.getChildren().clear();
			all.getChildren().add(c.cartable(stage));
		});
		
		mt32.setOnAction(e->{
			table_taxitrip t = new table_taxitrip();
			all.getChildren().clear();
			try {
				all.getChildren().add(t.taxitriptable(stage));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		// foe m4================================================
		MenuItem mt41 = new MenuItem("Fuel card");
		MenuItem mt42 = new MenuItem("Fuel coupon");
		MenuItem mt43 = new MenuItem("wash coupon");
		M4.getItems().addAll(mt41, mt42, mt43);

		// fro m5=====================================================
		MenuItem mt5 = new MenuItem("Total Car request");
		M5.getItems().addAll(mt5);
		
		mt5.setOnAction(e->{
			table_totalCarRequest c = new table_totalCarRequest();
			all.getChildren().clear();
			try {
				all.getChildren().add(c.requesttable(stage));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		mt41.setOnAction(e->{
			all.getChildren().clear();
			all.getChildren().add(dbfx.FuelCardtable(stage));
		});
		mt42.setOnAction(e->{
			all.getChildren().clear();
			all.getChildren().add(dbfx.FuelCoupontable(stage));
		});
		
		mt43.setOnAction(e->{
			all.getChildren().clear();
			all.getChildren().add(dbfx.CarWashestable(stage));
		});

		// fro m6============================================================
		// ("Companies"); // taxi, rental ,fuel,insurance,wash
		MenuItem mt61 = new MenuItem("Taxi Companies");
		MenuItem mt62 = new MenuItem("Car Rental Companies");
		MenuItem mt63 = new MenuItem("Fuel Companies");
		MenuItem mt64 = new MenuItem("Insurance Companies");
		MenuItem mt65 = new MenuItem("wash companies");
		M6.getItems().addAll(mt61, mt62, mt63, mt64, mt65);
		
		mt61.setOnAction(e->{
			all.getChildren().clear();
			all.getChildren().add(dbfx.Taxicompanytable(stage));
		});
		
		mt62.setOnAction(e->{
			rentalcompany_table r = new  rentalcompany_table();
			all.getChildren().clear();
			try {
				all.getChildren().add(r.carrentaltable(stage));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		
		mt63.setOnAction(e->{
			
			all.getChildren().clear();
//			all.getChildren().add(dbfx.fuelcompanytable(stage));
			try {
				all.getChildren().add(dbfx.fuelcompanytable(stage));
				System.out.println("tryyyyyyyyyyyyyy");
			} catch (Exception e1) {
				System.out.println("caaatcheeeeeeeeeeee");
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		mt64.setOnAction(e->{
			all.getChildren().clear();
			all.getChildren().add(dbfx.InsuranceCompanytable(stage));
		});
		mt65.setOnAction(e->{
			all.getChildren().clear();
			all.getChildren().add(dbfx.CarWashCompanytable(stage));
		});

		// for m7============================================================
		MenuItem mt71 = new MenuItem("Accident");
		MenuItem mt72 = new MenuItem("Maintenance");
		M7.getItems().addAll(mt71, mt72);
		
		
		mt71.setOnAction(e->{
			table_AccidentsRecords t = new table_AccidentsRecords();
			all.getChildren().clear();
			all.getChildren().add(t.AccidentsRecordstable(stage));
			
		});
		
		

		mt72.setOnAction(e->{
			table_MaintenanceRecords t = new table_MaintenanceRecords();
			all.getChildren().clear();
			try {
				all.getChildren().add(t.requesttable(stage));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});


		// for m8==================================================================
		MenuItem mt8 = new MenuItem("Reports");
		M8.getItems().addAll(mt8);
		mt8.setOnAction(e->{
			ReportView reportView = new ReportView();
			all.getChildren().clear();
			all.getChildren().add(reportView.secreenreport());
		});

		// for m9 ====================================================
		MenuItem mt9 = new MenuItem("Departmnets");
		M9.getItems().addAll(mt9);
		
		mt9.setOnAction(e->{
			table_department d = new table_department();
			all.getChildren().clear();
			try {
				all.getChildren().add(d.deprartmnet_table(stage));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		// for m10 ====================================================
		MenuItem mt10 = new MenuItem("Drivers");
		M10.getItems().addAll(mt10);
		
		mt10.setOnAction(e->{
			table_driver d = new table_driver();
			all.getChildren().clear();
			try {
				all.getChildren().add(d.drivertable(stage));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		// for m10 ====================================================
		MenuItem mt111 = new MenuItem("settings");
		MenuItem mt112 = new MenuItem("fleet officer");
		MenuItem mt113 = new MenuItem("my profile");
		
		M11.getItems().addAll(mt111,mt112,mt113);
		
		mt111.setOnAction(e->{
			DriverHomepage p = new DriverHomepage();
			System.out.println("printting from fleet: \n\n"+p.getRequest() );
			
		});

		
		mt112.setOnAction(e->{
			table_fleetofficer f = new table_fleetofficer();
			all.getChildren().clear();
			try {
				all.getChildren().add(f.fleettable(stage));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		mt113.setOnAction(e->{
			fleetofficerHomepage fleetofficer = new fleetofficerHomepage();
			all.getChildren().clear();
			all.getChildren().add(fleetofficer.myprofileboxFleet());
			
		});

		

		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();
		menubarMain.setPrefWidth(bounds.getWidth());

		menubarMain.getMenus().addAll(M0, M1, M3, M4, M5, M6, M7, M8, M9, M10, M11);

		// images===================================================
		Image imagelogo = new Image("file:C:/Users/ASUS/eclipse-workspace/DBFMS/src/logo.png");// 270x120
		Image imagecars = new Image("file:C:/Users/ASUS/eclipse-workspace/DBFMS/src/carShadow.png");
		Image imageperson = new Image("file:C:/Users/ASUS/eclipse-workspace/DBFMS/src/person.png");

		// imageviews=====================================================
		ImageView imglogo = new ImageView(imagelogo);
		imglogo.setFitWidth(101.25);// \67.5
		imglogo.setFitHeight(45);// 30

		ImageView imgcar = new ImageView(imagecars);
		imgcar.setFitWidth(150);// \67.5
		imgcar.setFitHeight(150);// 30

		ImageView imgperson = new ImageView(imageperson);
		imgperson.setFitWidth(100);// \67.5
		imgperson.setFitHeight(80);// 30

		// get the date=========================================
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = currentDate.format(dateFormatter);

		LocalTime currentTime = LocalTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
		String formattedTime = currentTime.format(timeFormatter);

		// label===============================================
		Label lbDate = new Label(formattedDate);
		Label lbTime = new Label(formattedTime);
		Label lbwelcome = new Label();

		/////////////
		String userName = System.getProperty("user.name");
		int hour = currentTime.getHour();
		if (hour >= 6 && hour < 12) {
			lbwelcome.setText("Good Morning, " + userName + "!");
		} else if (hour >= 12 && hour < 18) {
			lbwelcome.setText("Good Afternoon, " + userName + "!");

		} else {
			lbwelcome.setText("Good Evening, " + userName + "!");

		}
		///////////////////

		lbDate.setFont(fnormal);
		lbTime.setFont(fnormal);
		lbwelcome.setFont(ftittle);
		lbDate.setStyle("-fx-text-fill: white;");
		lbTime.setStyle("-fx-text-fill: white;");
		lbwelcome.setStyle("-fx-text-fill: white;");

		// dashboard boxes============================================
		connectDB();
		
		Dashbox dbnumofdrivers = new Dashbox("# Total Drivers:  "+ExecuteStatementCOUNT("select COUNT(*) from Drivers  ;") , imgperson);
		Dashbox dbnumofcars = new Dashbox("# Cars : "+ ExecuteStatementCOUNT("select COUNT(*) from Car  ;") , imgcar);
		Dashbox dbnumofcartrips = new Dashbox("# car trips make today: "+ ExecuteStatementCOUNT("select COUNT(*) from CarTrips where StartTripDate = ' "+formattedDate+ "' ;") , imgcar);
		Dashbox dbnumofrequestoftoday = new Dashbox("# of requests today :  "+ ExecuteStatementCOUNT("select COUNT(*) from TotalCarRequests where RequestDate = ' "+formattedDate+ "' ;"), imgcar);

		
		
		
		// dbnumofcars.getChildren().add(imgcar);

		hbdash.getChildren().addAll(dbnumofcars, dbnumofdrivers,dbnumofcartrips,dbnumofrequestoftoday);

		// ===========================
		panemenu.getChildren().add(menubarMain);

		logopane.getChildren().add(imglogo);

		vbdate.getChildren().addAll(lbTime, lbDate);

		// top
		hbtop.getChildren().addAll(logopane, lbwelcome, vbdate);

		hbboxes.getChildren().addAll(vehicleStatusbox(), vehicle2());

		all.getChildren().addAll(hbdash,requestlistveiw());//, hbboxesrequestlistveiw()
		root.getChildren().addAll(hbtop, panemenu, all);
		// tab1.setContent(root);

		Scene s = new Scene(root, 1200,700);
		stage.setTitle("Admin"); 
		stage.setScene(s);
		stage.show();

	}

	public static VBox vehicleStatusbox() throws SQLException {
		VBox vbmain = new VBox(15);
		vbmain.setPadding(new Insets(10, 10, 10, 10));

		VBox vbtittle = new VBox(2);

		HBox hb1 = new HBox(5);
		HBox hb2 = new HBox(5);
		HBox hb3 = new HBox(5);
		VBox vballlb = new VBox(5);

		Label lbtitle = new Label("Vehicles Status");
		Label lbactive = new Label("Active Cars(total): "+ExecuteStatementCOUNT("select count(*) from car where CarStatus = 'Active' ;"));
		Label lbout = new Label("Cars out of order(maintence): "+ExecuteStatementCOUNT("select count(*) from MaintenanceRecords where  RecordStatus = 'open' ;"));



		lbtitle.setFont(fnormalbold);
		lbactive.setFont(fnormal);
		lbout.setFont(fnormal);

		lbtitle.setStyle("-fx-text-fill: white;");
		lbactive.setStyle("-fx-text-fill: white;");
		lbout.setStyle("-fx-text-fill: white;");

		Line line = new Line(50, 100, 200, 100); // x1, y1, x2, y2
		line.setStroke(Color.WHITE);

		Color color1 = Color.web("#69db3b");
		Circle circle1 = new Circle(7, color1);

		Color color2 = Color.web("#ff2121");
		Circle circle2 = new Circle(7, color2);

		Color color3 = Color.web("#54d7ff");
		Circle circle3 = new Circle(7, color3);

		vbtittle.getChildren().addAll(lbtitle, line);

		hb1.getChildren().addAll(circle1, lbactive);
		//hb2.getChildren().addAll(circle2, lbbusy);
		hb3.getChildren().addAll(circle3, lbout);
		vballlb.getChildren().addAll(hb1, hb2, hb3);

		vbmain.setStyle(" -fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5);\r\n"
				+ "    -fx-border-width: 1px;\r\n" + "    -fx-border-radius: 5px;");
		vbmain.getChildren().addAll(vbtittle, vballlb);

		return vbmain;

	}

	public static VBox vehicle2() throws SQLException {
		VBox vbmain = new VBox(15);
		vbmain.setPadding(new Insets(10, 10, 10, 10));

		VBox vbtittle = new VBox(2);

		HBox hb1 = new HBox(5);
		HBox hb2 = new HBox(5);

		VBox vballlb = new VBox(5);

		Label lb1 = new Label("Car busy: #0");
		Label lb2 = new Label("Car parked: #"+ExecuteStatementCOUNT("select count(*) from CarDistribution ;"));


		lb1.setFont(fnormal);
		lb2.setFont(fnormal);

		lb1.setStyle("-fx-text-fill: white;");
		lb2.setStyle("-fx-text-fill: white;");

//		Line line = new Line(50, 100, 200, 100); // x1, y1, x2, y2
//		line.setStroke(Color.WHITE);

		Color color1 = Color.web("#69db3b");
		Circle circle1 = new Circle(7, color1);

		Color color2 = Color.web("#fc7cf0");
		Circle circle2 = new Circle(7, color2);

		// vbtittle.getChildren().addAll(lbtitle,line);

		hb1.getChildren().addAll(circle1, lb1);
		hb2.getChildren().addAll(circle2, lb2);

		vballlb.getChildren().addAll(hb1, hb2);

		vbmain.setStyle(" -fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5);\r\n"
				+ "    -fx-border-width: 1px;\r\n" + "    -fx-border-radius: 5px;");
		vbmain.getChildren().addAll(vbtittle, vballlb);

		return vbmain;

	}
	
	public static VBox myprofileboxFleet() {
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
		hbtotal.setPadding(new Insets(100, 10, 10, 10));
		hbtotal.setAlignment(Pos.CENTER);
		// labels============================================================
		    
		Label lb1 = new Label("EmployeeID");
		Label lb2 = new Label("FleetOfficersName");
		Label lb3 = new Label("Phone number");
		Label lb4 = new Label("Email");
		Label lb5 = new Label("DepartmentName");
		Label lb6 = new Label("WorkLocation");
		
		

		lb1.setFont(fnorma2);
		lb2.setFont(fnorma2);
		lb3.setFont(fnorma2);
		lb4.setFont(fnorma2);
		lb5.setFont(fnorma2);
		lb6.setFont(fnorma2);
		

		lb1.setStyle("-fx-text-fill: white;");
		lb2.setStyle("-fx-text-fill: white;");
		lb3.setStyle("-fx-text-fill: white;");
		lb4.setStyle("-fx-text-fill: white;");
		lb5.setStyle("-fx-text-fill: white;");
		lb6.setStyle("-fx-text-fill: white;");
		
		
		/////////////////////////////////////////////////
		
//		 nonEditableTextField.setEditable(false);
//
//	        // Apply CSS styling to make background transparent and text color white
//	        nonEditableTextField.setStyle("-fx-background-color: transparent; -fx-text-fill: white;"); 

		
		tfEmployeeID.setEditable(false);
		tfFleetOfficersName.setEditable(false);
		tfPhoneNumber.setEditable(true);
		tfEmail.setEditable(true);
		tfDepartmentName.setEditable(false);
		tfWorkLocation.setEditable(false);

		
		tfEmployeeID.setStyle("-fx-background-color: transparent; -fx-text-fill: white;-fx-border-style: hidden hidden solid hidden; -fx-border-color: white;");
		tfFleetOfficersName.setStyle("-fx-background-color: transparent; -fx-text-fill: white;-fx-border-style: hidden hidden solid hidden; -fx-border-color: white;");
		tfDepartmentName.setStyle("-fx-background-color: transparent; -fx-text-fill: white;-fx-border-style: hidden hidden solid hidden; -fx-border-color: white;");
		tfWorkLocation.setStyle("-fx-background-color: transparent; -fx-text-fill: white;-fx-border-style: hidden hidden solid hidden; -fx-border-color: white;");
		
		
		tfEmail.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);-fx-text-fill: white;");
		tfPhoneNumber.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);-fx-text-fill: white;");
		

		// button==============================================================
		Button btupdate = new Button("update");
		btupdate.setAlignment(Pos.BOTTOM_RIGHT);
		btupdate.setFont(fnormal);
		btupdate.setFont(new Font("Arial", 15));
		btupdate.setStyle(" -fx-background-color: linear-gradient(to bottom, #218da4, #76b057);");//-fx-background-color: #4F7942
		btupdate.setTextFill(Color.web("#FFFFFF"));
		
		
		
		btupdate.setOnAction(e->{
			updateFleetOf(Integer.valueOf(tfEmployeeID.getText()), tfPhoneNumber.getText(), tfEmail.getText());
		});
		

//		Button btuploadpic = new Button("Upload license photo");
//		btuploadpic.setFont(fnormal);
//		btuploadpic.setFont(new Font("Arial", 15));
//		btuploadpic.setStyle(" -fx-background-color: linear-gradient(to bottom, #218da4, #76b057);");//-fx-background-color: #4F7942
//		btuploadpic.setTextFill(Color.web("#FFFFFF"));
//		
		
		

//		Button btphoto = new Button("Change photo");
//		btphoto.setFont(fnormal);
//		btphoto.setFont(new Font("Arial", 15));
//		btphoto.setStyle(" -fx-background-color: linear-gradient(to bottom, #218da4, #76b057);");//-fx-background-color: #4F7942
//		btphoto.setTextFill(Color.web("#FFFFFF"));
//		

		// image ==================================================================
		
		//"file:C:/Users/Administrator/eclipse-workspace/BASE_DBM/src/car1.png"HUMAN.jpeg
		Image imageperson = new Image("C:\\Users\\Yuna\\eclipse-workspace\\DataBasePro\\src\\application\\HUMAN.jpeg");
		ImageView imgperson = new ImageView(imageperson);
		imgperson.setFitWidth(150);
		imgperson.setFitHeight(130);
		stackperson.getChildren().add(imgperson);
		vbphoto.getChildren().addAll(stackperson);

		vbphoto.setAlignment(Pos.TOP_RIGHT);

		////////////////////////////////////////////////////////////////
		
//		static TextField tfEmployeeID = new TextField();
//		static TextField tfFleetOfficersName = new TextField();
//		static TextField tfPhoneNumber = new TextField();
//		static TextField tfEmail = new TextField();
//		static TextField tfDepartmentName = new TextField();
//		static TextField tfWorkLocation = new TextField();

		hb1.getChildren().addAll(lb1, tfEmployeeID);
		hb2.getChildren().addAll(lb2, tfFleetOfficersName);

		hb31.getChildren().addAll(lb3, tfPhoneNumber);
		hb32.getChildren().addAll(lb4, tfEmail);
		hb3.getChildren().addAll(hb31, hb32);

		hb.getChildren().addAll(lb5, tfDepartmentName);

		hb41.getChildren().addAll(lb6, tfWorkLocation);
		
		vb43.getChildren().addAll(hb41, hb42);
		hb4.getChildren().addAll(vb43);


		gridpane.addRow(0, hb1);
		gridpane.addRow(1, hb2);
		gridpane.addRow(2, hb3);
		gridpane.addRow(3, hb4);
		gridpane.addRow(4, hb5);
		gridpane.addRow(5, hb6);
		gridpane.addRow(6, hb7);
		gridpane.addRow(7, hb8);
		gridpane.addRow(8, btupdate);

		hbtotal.getChildren().addAll(gridpane, vbphoto);

		main.getChildren().addAll(hbtotal);
		return main;

	}
	
	public  static void updateFleetOf(int officerNum, String phone, String email) {

		try {
//			System.out
//					.println("update  drivers set  PhoneNumber = '" + phone + "' where EmployeeNubber = " + driverNum);
			
//			CREATE TABLE FleetOfficers (
//				    EmployeeID INT PRIMARY KEY,
//				    FleetOfficersName VARCHAR(100) UNIQUE ,
//				    PhoneNumber VARCHAR(10),
//				    Email VARCHAR(255),
//				    DepartmentName VARCHAR(100),
//				    WorkLocation VARCHAR(255),
//				    FOREIGN KEY (DepartmentName) REFERENCES Department(DepartmentName)
//				);
			connectDB();
			ExecuteStatement("update  FleetOfficers set  PhoneNumber = '" + phone + "' where EmployeeID = " + officerNum + ";");
			ExecuteStatement("update  FleetOfficers set  Email = '" + email + "' where EmployeeID = " + officerNum + ";");
			
		
			con.close();
			System.out.println("Connection closed");

		} catch (Exception e) {
	
			e.printStackTrace();
		}
	}

	public static StackPane requestlistveiw() {
		StackPane p = new StackPane();
		
		
		 // primaryStage.setTitle("Dynamic ListView Example");
		DriverHomepage driverRequests = new DriverHomepage();
		//driverRequests.getRequest();

//	        ArrayList<DriverRequestBox> driverRequests = new ArrayList<>();
//	        driverRequests.add(new DriverRequestBox("John Doe", "HR", "Office A", "Client X", "Client X Dropoff", "City A", "Car"));
//	        driverRequests.add(new DriverRequestBox("Jane Smith", "Finance", "Office B", "Client Y", "Client Y Dropoff", "City B", "Taxi"));
//	        driverRequests.add(new DriverRequestBox("Bob Johnson", "IT", "Office C", "Client Z", "Client Z Dropoff", "City C", "Car"));

	        ObservableList<DriverRequestBox> dataList = FXCollections.observableArrayList(driverRequests.getRequest());

	        ListView<DriverRequestBox> listView = new ListView<>(dataList);
	        
	        

	        
	        	// Add a button to each row
	        listView.setCellFactory(e -> new ButtonListCell(dataList));
	       
	        

	        VBox root = new VBox(listView);
	        root.setPadding(new Insets(10));

	   p.getChildren().add(root);
		
		return p;
		
	}
	
	
	//static int selectedIndex = 0;
    // Custom ListCell with a button
	static int index =0;
	
	
    private static class ButtonListCell extends javafx.scene.control.ListCell<DriverRequestBox> {
        private final Button processButton = new Button("Process Request");
        private final ObservableList<DriverRequestBox> dataList;

        public ButtonListCell(ObservableList<DriverRequestBox> dataList) {
            this.dataList = dataList;

            processButton.setOnAction(event -> {
            	int selectedIndex = getIndex();
            	index= selectedIndex;
                if (selectedIndex >= 0 && selectedIndex < dataList.size()) {
                    try {
						openNewStage(dataList.get(selectedIndex));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                   
                    dataList.remove(selectedIndex);
                }
            });
        }

        @Override
        protected void updateItem(DriverRequestBox item, boolean empty) {
            super.updateItem(item, empty);

            if (empty || item == null) {
                setGraphic(null);
            } else {
                setGraphic(processButton);
                setText(item.getName().toString());
            }
        }

        private void openNewStage(DriverRequestBox driverRequestBox) throws SQLException {
            Stage newStage = new Stage();
            newStage.initModality(Modality.APPLICATION_MODAL);
            newStage.setTitle("Details");

            // Add your content to the new stage as needed
            // For demonstration, just show the data in a label
            VBox vBox = new VBox();
            vBox.setPadding(new Insets(10));
            vBox.getChildren().addAll(new javafx.scene.control.Label("Data: " + driverRequestBox),driverinfobox(driverRequestBox),requestbox2());

            vBox.setStyle(" -fx-background-color: #123a4e;");
            Scene scene = new Scene(vBox, 1000, 500);
            newStage.setScene(scene);

            newStage.showAndWait();
        }
       
    }
    
   static TextField tfname1 = new TextField();
   static TextField tfdepartment2 = new TextField();
   static TextField tfdepartuure3 = new TextField();
   static TextField tfdestination4 = new TextField();
   static TextField tfdropoff5 = new TextField();
   static TextField tfcompanylocation6 = new TextField();
   static TextField tftypeoftransport7 = new TextField();
	
    
    public static VBox driverinfobox(DriverRequestBox d) {
		// panes=====================================================

		GridPane gridpane = new GridPane();
		gridpane.setHgap(10);
		gridpane.setVgap(10);

		VBox main = new VBox(15);
		main.setPadding(new Insets(10, 10, 10, 10));
		main.setStyle(" -fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5);\r\n"
				+ "    -fx-border-width: 3px;\r\n" + "    -fx-border-radius: 5px;  -fx-background-color: #123a4e;");

		HBox hbrequest = new HBox(10);

		// labels============================================================

		Label lb1 = new Label("Name");
		Label lb2 = new Label("Department name ");
		Label lb3 = new Label("Departure location");
		Label lb4 = new Label("Destination");
		Label lb5 = new Label("Drop-off location");
		Label lb6 = new Label("Company location");
		Label lb7 = new Label("Type of transport prefrence");// car taxi driver
	

		lb1.setFont(fnormal);
		lb2.setFont(fnormal);
		lb3.setFont(fnormal);
		lb4.setFont(fnormal);
		lb5.setFont(fnormal);
		lb6.setFont(fnormal);
		lb7.setFont(fnormal);
		
		lb1.setStyle("-fx-text-fill: white;");
		lb2.setStyle("-fx-text-fill: white;");
		lb3.setStyle("-fx-text-fill: white;");
		lb4.setStyle("-fx-text-fill: white;");
		lb5.setStyle("-fx-text-fill: white;");
		lb6.setStyle("-fx-text-fill: white;");
		lb7.setStyle("-fx-text-fill: white;");
	

		// textfeild===========================================================

		tfname1.setText(d.getName()); 
		tfdepartment2.setText(d.getDeprtment()); 
		tfdepartuure3.setText(d.getDeprtment());  
		tfdestination4.setText(d.getDestination());
		tfdropoff5.setText(d.getDropoff()); 
		tfcompanylocation6.setText(d.getCompanyloaction());  
		tftypeoftransport7.setText(d.getTypeoftrnasport()); 
		

		tfname1.setStyle("-fx-background-color: transparent; -fx-text-fill: white;-fx-border-style: hidden hidden solid hidden; -fx-border-color: white;");
		tfdepartment2.setStyle("-fx-background-color: transparent; -fx-text-fill: white;-fx-border-style: hidden hidden solid hidden; -fx-border-color: white;");
		tfdepartuure3.setStyle("-fx-background-color: transparent; -fx-text-fill: white;-fx-border-style: hidden hidden solid hidden; -fx-border-color: white;");
		tfdestination4.setStyle("-fx-background-color: transparent; -fx-text-fill: white;-fx-border-style: hidden hidden solid hidden; -fx-border-color: white;");
		tfdropoff5.setStyle("-fx-background-color: transparent; -fx-text-fill: white;-fx-border-style: hidden hidden solid hidden; -fx-border-color: white;");
		tfcompanylocation6.setStyle("-fx-background-color: transparent; -fx-text-fill: white;-fx-border-style: hidden hidden solid hidden; -fx-border-color: white;");
		tftypeoftransport7.setStyle("-fx-background-color: transparent; -fx-text-fill: white;-fx-border-style: hidden hidden solid hidden; -fx-border-color: white;");
		
		
		tfname1.setEditable(false);
		tfdepartment2.setEditable(false);
		tfdepartuure3.setEditable(false);
		tfdestination4.setEditable(false);
		tfdropoff5.setEditable(false);
		tfcompanylocation6.setEditable(false);
		tftypeoftransport7.setEditable(false);
		

		// button==============================================================
		Button btsend = new Button("Send request");
		btsend.setAlignment(Pos.BOTTOM_RIGHT);
		btsend.setFont(fnormal);

		btsend.setStyle(" -fx-background-color: linear-gradient(to bottom, #218da4, #76b057);");// -fx-background-color:
																								// #4F7942
		btsend.setTextFill(Color.web("#FFFFFF"));

		btsend.setOnAction(e -> {
			String radio1 ="";
			String radio2 ="";
			
//			
//			if (rb11.isSelected()) {
//				radio1= rb11.getText();
//			}
//
//			if (rb12.isSelected()) {
//				radio1= rb12.getText();
//			}
//
//			if (rb13.isSelected()) {
//				radio1= rb13.getText();
//			}
//			
//			
//			if (rb21.isSelected()) {
//				radio2= rb21.getText();
//			}
//
//			if (rb22.isSelected()) {
//				radio2= rb22.getText();
//			}
//
//			DriverRequestBox d = new DriverRequestBox(tfname1.getText(), tfdepartment1.getText(), tfdepartuure.getText(), tfdestination.getText(), tfdropoff.getText(), radio1, radio2);
//			request.add(d);
//			System.out.println(request);
			

			

			// System.out.println(group1.getSelectedToggle().toString());
			// request.add(new DriverRequestBox(tfname1.getText()),
			// tfdepartment1.toString(), tfdepartuure.toString(), tfdestination.toString(),
			// tfdropoff.toString(), selectedToggle1.toString() ,selectedToggle2.toString()
			// ));
//System.out.println(request);

		});

		////////////////////////////////////////////////////////////////
		gridpane.addRow(0, lb1, tfname1);
		gridpane.addRow(1, lb2, tfdepartment2);
		gridpane.addRow(2, lb3, tfdepartuure3);
		gridpane.addRow(3, lb4, tfdestination4);
		gridpane.addRow(4, lb5, tfdropoff5);
		gridpane.addRow(5, lb6, tfcompanylocation6);
		gridpane.addRow(6, lb7, tftypeoftransport7);

		

		main.getChildren().addAll(gridpane);
		return main;

	} 
    
     static String rentalCompany ="";
    public static VBox requestbox2() throws SQLException {
    	VBox p =new VBox();
    	p.setPadding(new Insets(10,10,10,10));
    	p.setStyle(" -fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5);\r\n"
				+ "    -fx-border-width: 3px;\r\n" + "    -fx-border-radius: 5px; -fx-background-color: #123a4e;");

    	
    	
    	HBox boxradiobuttons = new HBox(10);
    	boxradiobuttons.setPadding(new Insets(10,10,10,10));
    	HBox boxcombobox = new HBox(10);
    	boxcombobox.setPadding(new Insets(10,10,10,10));
    	
    	HBox boxbuttons = new HBox(10);
    	boxbuttons.setPadding(new Insets(25,10,10,10));
    	
    	
    	Button btapprove = new Button("approve request");
		Button btcancel = new Button("cancel request");
    	//radio buttons========================================================
    	ToggleGroup group1 = new ToggleGroup();
		RadioButton rb21 = new RadioButton("Car");
		RadioButton rb22 = new RadioButton("Taxi");
		RadioButton rb23 = new RadioButton("Personal");
		rb21.setToggleGroup(group1);
		rb22.setToggleGroup(group1);
		rb23.setToggleGroup(group1);
		rb21.setFont(fnormal);
		rb22.setFont(fnormal);
		rb23.setFont(fnormal);
		rb21.setStyle("-fx-text-fill: white;");
		rb22.setStyle("-fx-text-fill: white;");
		rb23.setStyle("-fx-text-fill: white;");
		
		
		ComboBox<String> carsComboBox = new ComboBox<>();
		ComboBox<String> taxiComboBox = new ComboBox<>();
		 carsComboBox.setVisible(false);
		    taxiComboBox.setVisible(false);
		
		   
			carsComboBox.setOnAction(e -> {
			    // Get the selected value from the carsComboBox
			    String selectedValue = carsComboBox.getSelectionModel().getSelectedItem();

			    // Check if the selectedValue is not null and not empty
			    if (selectedValue != null && !selectedValue.isEmpty()) {
			        // Split the selectedValue based on the opening and closing brackets
			        String[] parts = selectedValue.split("\\(");

			        // Check if the split resulted in at least two parts
			        if (parts.length >= 2) {
			            // Extract the rental company part (the part after the opening bracket)
			          rentalCompany = parts[1].replaceAll("\\)", "").trim();

			            // Now you have the rental company in the 'rentalCompany' variable
			            System.out.println("Selected Rental Company: " + rentalCompany);
			        }
			    }
			});
		
		rb21.setOnAction(E->{
			carsComboBox.getItems().clear();
			 String query = "SELECT * FROM Car WHERE CarStatus = 'Active';";

			    try (PreparedStatement preparedStatement = con.prepareStatement(query);
			         ResultSet resultSet = preparedStatement.executeQuery()) {

			        while (resultSet.next()) {
			            int carNumber = resultSet.getInt("CarNumber");
			            String brandName = resultSet.getString("BrandName");
			            String companyName = resultSet.getString("RentalCompanyName");

			           
			            String displayText = carNumber + " - " + brandName + " (" + companyName + ")";
			            
			            System.out.println(displayText);
			           carsComboBox.setValue("select: ");
			            carsComboBox.getItems().add(displayText);
			        }
			    } catch (SQLException e) {
			        e.printStackTrace();
			        
			    }
			    
			    carsComboBox.setVisible(true);
			    taxiComboBox.setVisible(false);
		});

		
		rb22.setOnAction(E->{
			taxiComboBox.getItems().clear();
			
			 String query = "select * from TaxiCompanies;";

			    try (PreparedStatement preparedStatement = con.prepareStatement(query);
			         ResultSet resultSet = preparedStatement.executeQuery()) {

			        while (resultSet.next()) {
			            int number = resultSet.getInt("CompanyNumber");
			            String name = resultSet.getString("CompanyName");
			            String location = resultSet.getString("Location");
			            String phone = resultSet.getString("PhoneNumber");

			           
			            String displayText = number + " - " + name + " - " + location+" (" + phone + ")";
			            taxiComboBox.setValue("select: ");
			            System.out.println(displayText);
			           
			            taxiComboBox.getItems().add(displayText);
			        }
			    } catch (SQLException e) {
			        e.printStackTrace();
			        
			    }
			    
			    carsComboBox.setVisible(false);
			    taxiComboBox.setVisible(true);
			    
			    
			    
			   
			    
		});
		
		 btapprove.setOnAction(e->{
				try {
					
//					 CREATE TABLE TotalCarRequests (
//							    RequestNumber INT PRIMARY KEY,
//							    DriverName VARCHAR(100),
//							    DepartmentName VARCHAR(100),
//							    DepartureLocation VARCHAR(255),
//							    DestinationLocation VARCHAR(255),
//							    RequestStatus VARCHAR(50) CHECK (RequestStatus IN ('approved', 'pending', 'rejected')),
//							    RequestDate DATE,
//							    VehicleType VARCHAR(50) CHECK (VehicleType IN ('owned', 'rental', 'substitute','taxi')),
//							    FleetOfficerName VARCHAR(100),
//							     FOREIGN KEY (DriverName) REFERENCES Drivers(EmployeeName) ON UPDATE CASCADE,
//							    FOREIGN KEY (FleetOfficerName) REFERENCES FleetOfficers(FleetOfficersName) ON UPDATE CASCADE,
//							    FOREIGN KEY (DepartmentName) REFERENCES Department(DepartmentName) ON UPDATE CASCADE
//							     
//							);
	//
	//
					
//							insert  TotalCarRequests values (1,"Ali","HR",'Nablus_jawwal', 'Ramallah_jawwal', 'pending', '2022-01-10', 'owned', 'Sam Johnson');
					String s1 = "";
					if(rentalCompany =="null") {
						s1= "owned";
					}else {
						s1="rental";
					}
					
					
					int count= Integer.valueOf(ExecuteStatementCOUNT("select count(*) from TotalCarRequests;")) +1;
					String date = LocalDate.now().getYear()+"-"+LocalDate.now().getMonthValue()+"-"+LocalDate.now().getDayOfMonth();
					String s = "insert into TotalCarRequests values ( " + count + ",'" + tfname1.getText()+"','" +tfdepartment2.getText()+"','"+tfdepartuure3.getText() +"','"
					+tfdestination4.getText() +"','approved','" +date +"','"+s1+ "','"+tfFleetOfficersName.getText() +"');" ;
					connectDB();
					System.out.println(s);
					 ExecuteStatement(s);
					 
					 
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
			});
		
		
		rb23.setOnAction(e->{
			carsComboBox.setVisible(false);
		    taxiComboBox.setVisible(false);
		
		});
		
		 


		////////////////////////////////////////////////////////////
		
	
		
		btcancel.setOnAction(e->{
			
		});
		
		
//		btapprove.setOnAction(e->{
//			try {
//				
////				 CREATE TABLE TotalCarRequests (
////						    RequestNumber INT PRIMARY KEY,
////						    DriverName VARCHAR(100),
////						    DepartmentName VARCHAR(100),
////						    DepartureLocation VARCHAR(255),
////						    DestinationLocation VARCHAR(255),
////						    RequestStatus VARCHAR(50) CHECK (RequestStatus IN ('approved', 'pending', 'rejected')),
////						    RequestDate DATE,
////						    VehicleType VARCHAR(50) CHECK (VehicleType IN ('owned', 'rental', 'substitute','taxi')),
////						    FleetOfficerName VARCHAR(100),
////						     FOREIGN KEY (DriverName) REFERENCES Drivers(EmployeeName) ON UPDATE CASCADE,
////						    FOREIGN KEY (FleetOfficerName) REFERENCES FleetOfficers(FleetOfficersName) ON UPDATE CASCADE,
////						    FOREIGN KEY (DepartmentName) REFERENCES Department(DepartmentName) ON UPDATE CASCADE
////						     
////						);
////
////
//				
////						insert  TotalCarRequests values (1,"Ali","HR",'Nablus_jawwal', 'Ramallah_jawwal', 'pending', '2022-01-10', 'owned', 'Sam Johnson');
//				String s1 = "";
//				if(rentalCompany =="null") {
//					s1= "owned";
//				}else {
//					s1="rental";
//				}
//				
//				
//				int count= Integer.valueOf(ExecuteStatementCOUNT("select count(*) from TotalCarRequests;")) +1;
//				String date = LocalDate.now().getYear()+"-"+LocalDate.now().getMonthValue()+"-"+LocalDate.now().getDayOfMonth();
//				String s = "insert into TotalCarRequests values ( " + count + ",'" + tfname1.getText()+"','" +tfdepartment2+"','"+tfdepartuure3.getText() +"','"
//				+tfdestination4.getText() +"','approved','" +date +"','"+rentalCompany+ "','"    ") ;
//				connectDB();
//				 ExecuteStatement(URL);
//			} catch (ClassNotFoundException | SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			
//			
//			
//			
//			
//		});
    	
    	
    	boxradiobuttons.getChildren().addAll(rb21,rb22,rb23);
    	boxcombobox.getChildren().addAll(carsComboBox,taxiComboBox);
    	boxbuttons.getChildren().addAll(btapprove,btcancel);
    	
    	
    	p.getChildren().addAll(boxradiobuttons,boxcombobox,boxbuttons);
    	
    	
		return p;
    	
    	
    }
    
    
    public static void getAttributes (String table , ArrayList<String> ar) {
		ar.clear();
		 try {
				connectDB();
			} catch (ClassNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		       
		            String sql = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = ?";
		            
		            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
		                preparedStatement.setString(1, table);
		                
		                try (ResultSet resultSet = preparedStatement.executeQuery()) {
		                    while (resultSet.next()) {
		                        String columnName = resultSet.getString("COLUMN_NAME");
		                        ar.add(columnName);
		                        System.out.println("Column Name: " + columnName);
		                    }
		                }
		            } catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		
	}
    
    
   
    
    
    
    
    


	
	
	
	
}
