package application;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import static javafx.stage.Modality.NONE;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Window;
import javafx.util.Duration;

/**
 * A JavaFX ConnectDB Application
 */
public class table_Cartrip extends Application {
	/**
	 * @param args the command line arguments
	 * 
	 * 
	 */
//	private ArrayList<carTrip> data;
//	private ObservableList<carTrip> dataList;
//
//	private static String dbUsername = "root"; // database username
//	private static String dbPassword = "yunayuna123"; // database password
//	private static String URL = "127.0.0.1"; // server location
//
//	private static String port = "3306"; // port that mysql uses
//	private static String dbName = "carfleet"; // database on mysql to connect to
//	private String dbURL;
//	private Connection con;

	private ArrayList<carTrip> data;
	private ObservableList<carTrip> dataList;

	private static String dbUsername = "root"; // database username
	//private static String dbPassword = "yunayuna123"; // database password
	private static String dbPassword = "yunayuna123"; // database password
	private static String URL = "127.0.0.1"; // server location

	private static String port = "3306"; // port that mysql uses
	private static String dbName = "miniFleetsystem"; // database on mysql to connect to
	private String dbURL;
	private Connection con;

	public static void main(String[] args) {

		Application.launch(args);
	}

	public Pane cartable(Stage stage) {
		data = new ArrayList<>();

		try {
			getData();
			dataList = FXCollections.observableArrayList(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// convert data from arraylist to observable arraylist

		return table(stage);

	}

	public table_Cartrip() {

	}

	private Pane table(Stage stage) {
		Pane p = new Pane();
		// tableveiw=======================================================================
		TableView<carTrip> tableVeiw = new TableView<carTrip>();
		tableVeiw.setStyle("-fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5); "
				+ "-fx-border-width: 3px; " + "-fx-border-radius: 5px; "
				+ "-fx-background-color: linear-gradient(to bottom, #cfeccb, #81dbf5);");

		TableColumn<carTrip, Integer> column1 = new TableColumn<carTrip, Integer>("CarTripNumber");
		column1.setCellValueFactory(new PropertyValueFactory<carTrip, Integer>("CarTripNumber"));

		TableColumn<carTrip, String> column2 = new TableColumn<carTrip, String>("DriverName");
		column2.setCellValueFactory(new PropertyValueFactory<carTrip, String>("DriverName"));

		TableColumn<carTrip, String> column4 = new TableColumn<carTrip, String>("OdometerOnStart");
		column4.setCellValueFactory(new PropertyValueFactory<carTrip, String>("OdometerOnStart"));

		TableColumn<carTrip, String> column5 = new TableColumn<carTrip, String>("CarNumber");
		column5.setCellValueFactory(new PropertyValueFactory<carTrip, String>("CarNumber"));

		TableColumn<carTrip, LocalDate> column6 = new TableColumn<carTrip, LocalDate>("StartTripDate");
		column6.setCellValueFactory(new PropertyValueFactory<carTrip, LocalDate>("StartTripDate"));

		TableColumn<carTrip, LocalDate> column7 = new TableColumn<carTrip, LocalDate>("EndTripDate");
		column7.setCellValueFactory(new PropertyValueFactory<carTrip, LocalDate>("EndTripDate"));

		TableColumn<carTrip, String> column8 = new TableColumn<carTrip, String>("FleetOfficerName");
		column8.setCellValueFactory(new PropertyValueFactory<carTrip, String>("FleetOfficerName"));

		TableColumn<carTrip, String> column9 = new TableColumn<carTrip, String>("Distance");
		column9.setCellValueFactory(new PropertyValueFactory<carTrip, String>("Distance"));

		TableColumn<carTrip, String> column10 = new TableColumn<carTrip, String>("Notes");
		column10.setCellValueFactory(new PropertyValueFactory<carTrip, String>("Notes"));

		// panes===========================================================================================
		VBox vbtittle = new VBox(5);
		final VBox vbox = new VBox();
		HBox hb1 = new HBox(10);

		// labeles==============================================================================================
		Label lbTittle = new Label("carTrip TableVeiw");
		Font fbold = Font.font("IMPACT", FontWeight.BLACK, FontPosture.REGULAR, 35);
		lbTittle.setFont(fbold);
		// lbTittle.setStyle("-fx-text-fill: #2d5d7a;");
		lbTittle.setStyle("-fx-text-fill:linear-gradient(to bottom, #cfeccb, #81dbf5); ");// #2d5d7a;

		Scene scene = new Scene(new Group());
//				LinearGradient gradient = new LinearGradient(0, // start X
//						0, // start Y
//						1, // end X
//						1, // end Y
//						true, // proportional
//						CycleMethod.NO_CYCLE, // cycle method
//						new Stop(0, Color.rgb(99, 175, 133)), // start color
//						new Stop(1, Color.rgb(78, 163, 178)) // end color
//				);

		// Set the linear gradient as the fill for the scene
		// scene.setFill(gradient);
		scene.setFill(Color.web("#123a4e"));

		stage.setTitle("carTrip Table");
		stage.setWidth(1400);
		stage.setHeight(900);

		tableVeiw.setEditable(true);
		tableVeiw.setMaxHeight(500);
		tableVeiw.setMaxWidth(700);

		Font normal = Font.font("Arial Narrow", FontWeight.BOLD, FontPosture.REGULAR, 14);
		Button btadd = new Button("Add");
		Button btdelete = new Button("Delete");
		Button btclear = new Button("Clear All");
		Button btrefresh = new Button("Refresh");
		btadd.setFont(normal);
		btdelete.setFont(normal);
		btclear.setFont(normal);
		btrefresh.setFont(normal);
		btadd.setStyle(
				"-fx-border-color: #006400; -fx-border-width: 2px; -fx-background-radius: 30; -fx-border-radius: 30;");
		btdelete.setStyle(
				"-fx-border-color: #006400; -fx-border-width: 2px; -fx-background-radius: 30; -fx-border-radius: 30;");
		btclear.setStyle(
				"-fx-border-color: #006400; -fx-border-width: 2px; -fx-background-radius: 30; -fx-border-radius: 30;");
		btrefresh.setStyle(
				"-fx-border-color: #006400; -fx-border-width: 2px; -fx-background-radius: 30; -fx-border-radius: 30;");

		tableVeiw.setItems(dataList);

		tableVeiw.getColumns().addAll(column1, column2, column4, column5, column6, column7, column8, column9, column10);

		// pane=========================================================
		GridPane gridpane = new GridPane();

		// labels============================================================
		Label lb1 = new Label("car tripNumber");
		Label lb2 = new Label("driver name");
		Label lb4 = new Label("odometer onStart");
		Label lb5 = new Label("car number");
		Label lb6 = new Label("start trip date");
		Label lb7 = new Label("end trip date");
		Label lb8 = new Label("fleet office name");
		Label lb9 = new Label("Distance");
		Label lb10 = new Label("Notes");

		lb1.setTextFill(Color.web("#dadede"));
		lb2.setTextFill(Color.web("#dadede"));
		lb4.setTextFill(Color.web("#dadede"));
		lb5.setTextFill(Color.web("#dadede"));
		lb7.setTextFill(Color.web("#dadede"));
		lb8.setTextFill(Color.web("#dadede"));
		lb9.setTextFill(Color.web("#dadede"));
		lb10.setTextFill(Color.web("#dadede"));
		lb6.setTextFill(Color.web("#dadede"));

		lb1.setFont(normal);
		lb2.setFont(normal);
		lb4.setFont(normal);
		lb5.setFont(normal);
		lb6.setFont(normal);
		lb7.setFont(normal);
		lb8.setFont(normal);
		lb9.setFont(normal);
		lb10.setFont(normal);

		// textfeild====================================================
		TextField CarTripNumber = new TextField();
		TextField DriverName = new TextField();
		TextField OdometerOnStart = new TextField();
		TextField CarNumber = new TextField();
		TextField Distance = new TextField();
		TextField FleetOfficerName = new TextField();
		TextField Notes = new TextField();

		// datepicker==============================================
		DatePicker date = new DatePicker();
		DatePicker end = new DatePicker();
		// radiobuttons========================================================

		gridpane.addRow(0, lb1, CarTripNumber);
		gridpane.addRow(1, lb2, DriverName);
		gridpane.addRow(2, lb4, OdometerOnStart);
		gridpane.addRow(3, lb5, CarNumber);
		gridpane.addRow(4, lb6, date);
		gridpane.addRow(5, lb7, end);
		gridpane.addRow(6, lb8, FleetOfficerName);
		gridpane.addRow(7, lb9, Distance);
		gridpane.addRow(8, lb10, Notes);
		gridpane.setPadding(new Insets(10, 10, 10, 10));
		gridpane.setHgap(10);
		gridpane.setVgap(10);
		gridpane.setStyle(" -fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5);\r\n"
				+ "    -fx-border-width: 3px;\r\n" + "    -fx-border-radius: 5px;");

		// button
		// handler=======================================================================================================
		btadd.setOnAction(e -> {

			carTrip c = new carTrip(Integer.valueOf(CarTripNumber.getText()), // Assuming you have a
																				// TextField named
																				// requestNumberTextField
					DriverName.getText(), OdometerOnStart.getText(), CarNumber.getText(), date.getValue(),
					end.getValue(), FleetOfficerName.getText(), // Assuming you have a
																// DatePicker named
																// dateDatePicker
					Distance.getText(), Notes.getText());

			dataList.add(c);
			insertData(c);

		});

		btdelete.setOnAction(e -> {
			ObservableList<carTrip> selectedRows = tableVeiw.getSelectionModel().getSelectedItems();
			ArrayList<carTrip> rows = new ArrayList<>(selectedRows);
			rows.forEach(row -> {
				tableVeiw.getItems().remove(row);
				deleteRow(row);
				tableVeiw.refresh();
			});

		});

		btrefresh.setOnAction(e -> {
			tableVeiw.refresh();
		});

		btclear.setOnAction(e -> {
			showDialog(stage, NONE, tableVeiw);
		});

		// update info in driver table==================================================

		column5.setCellFactory(TextFieldTableCell.forTableColumn());
		column5.setOnEditCommit((TableColumn.CellEditEvent<carTrip, String> t) -> {
			t.getTableView().getItems().get(t.getTablePosition().getRow()).setCarNumber(t.getNewValue());
			updatecarnum(t.getRowValue().getCarTripNumber(), t.getRowValue().getCarNumber());
		});

		column2.setCellFactory(TextFieldTableCell.forTableColumn());
		column2.setOnEditCommit((TableColumn.CellEditEvent<carTrip, String> t) -> {
			t.getTableView().getItems().get(t.getTablePosition().getRow()).setDriverName(t.getNewValue());
			updateDriverName(t.getRowValue().getCarTripNumber(), t.getRowValue().getDriverName());
		});

		// =====================================================================================
		HBox hb = new HBox(10);
		hb.setPadding(new Insets(10, 10, 10, 10));
		hb.getChildren().addAll(btadd, btdelete, btrefresh, btclear);
		hb.setAlignment(Pos.CENTER);

		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		hb1.setPadding(new Insets(10, 10, 10, 10));

		vbtittle.getChildren().addAll(lbTittle);
		vbtittle.setAlignment(Pos.CENTER);
		vbox.setAlignment(Pos.CENTER);
		hb1.getChildren().addAll(tableVeiw, gridpane);
		vbox.getChildren().addAll(vbtittle, hb1, hb);
		// vbox.setStyle("-fx-background-color: #d2eac9;");

		// ((Group) scene.getRoot()).getChildren().addAll(vbox);
		// stage.setScene(scene);
		p.getChildren().add(vbox);
		return p;

	}

	@Override
	public void start(Stage stage) {
//		data = new ArrayList<>();
//
//		TabPane tabpane = new TabPane();
//		Tab tab1 = new Tab("carTrip Table view");
//
//		tabpane.getTabs().addAll(tab1);
//
//		try {
//
//			getData();
//
//			// convert data from arraylist to observable arraylist
//			dataList = FXCollections.observableArrayList(data);
//
//			tableView(stage, tab1);
//			//displayIntroImage(stage);
//			stage.show();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@SuppressWarnings("unchecked")

	private void tableView(Stage stage, Tab t1) {

		// tableveiw=======================================================================
		TableView<carTrip> tableVeiw = new TableView<carTrip>();
		tableVeiw.setStyle("-fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5); "
				+ "-fx-border-width: 3px; " + "-fx-border-radius: 5px; "
				+ "-fx-background-color: linear-gradient(to bottom, #cfeccb, #81dbf5);");

		TableColumn<carTrip, Integer> column1 = new TableColumn<carTrip, Integer>("CarTripNumber");
		column1.setCellValueFactory(new PropertyValueFactory<carTrip, Integer>("CarTripNumber"));

		TableColumn<carTrip, String> column2 = new TableColumn<carTrip, String>("DriverName");
		column2.setCellValueFactory(new PropertyValueFactory<carTrip, String>("DriverName"));

		TableColumn<carTrip, String> column4 = new TableColumn<carTrip, String>("OdometerOnStart");
		column4.setCellValueFactory(new PropertyValueFactory<carTrip, String>("OdometerOnStart"));

		TableColumn<carTrip, String> column5 = new TableColumn<carTrip, String>("CarNumber");
		column5.setCellValueFactory(new PropertyValueFactory<carTrip, String>("CarNumber"));

		TableColumn<carTrip, LocalDate> column6 = new TableColumn<carTrip, LocalDate>("StartTripDate");
		column6.setCellValueFactory(new PropertyValueFactory<carTrip, LocalDate>("StartTripDate"));

		TableColumn<carTrip, LocalDate> column7 = new TableColumn<carTrip, LocalDate>("EndTripDate");
		column7.setCellValueFactory(new PropertyValueFactory<carTrip, LocalDate>("EndTripDate"));

		TableColumn<carTrip, String> column8 = new TableColumn<carTrip, String>("FleetOfficerName");
		column8.setCellValueFactory(new PropertyValueFactory<carTrip, String>("FleetOfficerName"));

		TableColumn<carTrip, String> column9 = new TableColumn<carTrip, String>("Distance");
		column9.setCellValueFactory(new PropertyValueFactory<carTrip, String>("Distance"));

		TableColumn<carTrip, String> column10 = new TableColumn<carTrip, String>("Notes");
		column10.setCellValueFactory(new PropertyValueFactory<carTrip, String>("Notes"));

		// panes===========================================================================================
		VBox vbtittle = new VBox(5);
		final VBox vbox = new VBox();
		HBox hb1 = new HBox(10);

		// labeles==============================================================================================
		Label lbTittle = new Label("carTrip TableVeiw");
		Font fbold = Font.font("IMPACT", FontWeight.BLACK, FontPosture.REGULAR, 35);
		lbTittle.setFont(fbold);
		// lbTittle.setStyle("-fx-text-fill: #2d5d7a;");
		lbTittle.setStyle("-fx-text-fill:linear-gradient(to bottom, #cfeccb, #81dbf5); ");// #2d5d7a;

		Scene scene = new Scene(new Group());
//		LinearGradient gradient = new LinearGradient(0, // start X
//				0, // start Y
//				1, // end X
//				1, // end Y
//				true, // proportional
//				CycleMethod.NO_CYCLE, // cycle method
//				new Stop(0, Color.rgb(99, 175, 133)), // start color
//				new Stop(1, Color.rgb(78, 163, 178)) // end color
//		);

		// Set the linear gradient as the fill for the scene
		// scene.setFill(gradient);
		scene.setFill(Color.web("#123a4e"));

		stage.setTitle("carTrip Table");
		stage.setWidth(1200);
		stage.setHeight(700);

		tableVeiw.setEditable(true);
		tableVeiw.setMaxHeight(500);
		tableVeiw.setMaxWidth(500);

		Font normal = Font.font("Arial Narrow", FontWeight.BOLD, FontPosture.REGULAR, 14);
		Button btadd = new Button("Add");
		Button btdelete = new Button("Delete");
		Button btclear = new Button("Clear All");
		Button btrefresh = new Button("Refresh");
		btadd.setFont(normal);
		btdelete.setFont(normal);
		btclear.setFont(normal);
		btrefresh.setFont(normal);
		btadd.setStyle(
				"-fx-border-color: #006400; -fx-border-width: 2px; -fx-background-radius: 30; -fx-border-radius: 30;");
		btdelete.setStyle(
				"-fx-border-color: #006400; -fx-border-width: 2px; -fx-background-radius: 30; -fx-border-radius: 30;");
		btclear.setStyle(
				"-fx-border-color: #006400; -fx-border-width: 2px; -fx-background-radius: 30; -fx-border-radius: 30;");
		btrefresh.setStyle(
				"-fx-border-color: #006400; -fx-border-width: 2px; -fx-background-radius: 30; -fx-border-radius: 30;");

		tableVeiw.setItems(dataList);

		tableVeiw.getColumns().addAll(column1, column2, column4, column5, column6, column7, column8, column9, column10);

		// pane=========================================================
		GridPane gridpane = new GridPane();

		// labels============================================================
		Label lb1 = new Label("car tripNumber");
		Label lb2 = new Label("driver name");
		Label lb4 = new Label("odometer onStart");
		Label lb5 = new Label("car number");
		Label lb6 = new Label("start trip date");
		Label lb7 = new Label("end trip date");
		Label lb8 = new Label("fleet office name");
		Label lb9 = new Label("Distance");
		Label lb10 = new Label("Notes");

		lb1.setTextFill(Color.web("#dadede"));
		lb2.setTextFill(Color.web("#dadede"));
		lb4.setTextFill(Color.web("#dadede"));
		lb5.setTextFill(Color.web("#dadede"));
		lb7.setTextFill(Color.web("#dadede"));
		lb8.setTextFill(Color.web("#dadede"));
		lb9.setTextFill(Color.web("#dadede"));
		lb10.setTextFill(Color.web("#dadede"));
		lb6.setTextFill(Color.web("#dadede"));

		lb1.setFont(normal);
		lb2.setFont(normal);
		lb4.setFont(normal);
		lb5.setFont(normal);
		lb6.setFont(normal);
		lb7.setFont(normal);
		lb8.setFont(normal);
		lb9.setFont(normal);
		lb10.setFont(normal);

		// textfeild====================================================
		TextField CarTripNumber = new TextField();
		TextField DriverName = new TextField();
		TextField OdometerOnStart = new TextField();
		TextField CarNumber = new TextField();
		TextField Distance = new TextField();
		TextField FleetOfficerName = new TextField();
		TextField Notes = new TextField();

		// datepicker==============================================
		DatePicker date = new DatePicker();
		DatePicker end = new DatePicker();
		// radiobuttons========================================================

		gridpane.addRow(0, lb1, CarTripNumber);
		gridpane.addRow(1, lb2, DriverName);
		gridpane.addRow(2, lb4, OdometerOnStart);
		gridpane.addRow(3, lb5, CarNumber);
		gridpane.addRow(4, lb6, date);
		gridpane.addRow(5, lb7, end);
		gridpane.addRow(6, lb8, FleetOfficerName);
		gridpane.addRow(7, lb9, Distance);
		gridpane.addRow(8, lb10, Notes);
		gridpane.setPadding(new Insets(10, 10, 10, 10));
		gridpane.setHgap(10);
		gridpane.setVgap(10);
		gridpane.setStyle(" -fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5);\r\n"
				+ "    -fx-border-width: 3px;\r\n" + "    -fx-border-radius: 5px;");

		// button
		// handler=======================================================================================================
		btadd.setOnAction(e -> {

			carTrip c = new carTrip(Integer.valueOf(CarTripNumber.getText()), // Assuming you have a
																				// TextField named
																				// requestNumberTextField
					DriverName.getText(), OdometerOnStart.getText(), CarNumber.getText(), date.getValue(),
					end.getValue(), FleetOfficerName.getText(), // Assuming you have a
																// DatePicker named
																// dateDatePicker
					Distance.getText(), Notes.getText());

			dataList.add(c);
			insertData(c);

		});

		btdelete.setOnAction(e -> {
			ObservableList<carTrip> selectedRows = tableVeiw.getSelectionModel().getSelectedItems();
			ArrayList<carTrip> rows = new ArrayList<>(selectedRows);
			rows.forEach(row -> {
				tableVeiw.getItems().remove(row);
				deleteRow(row);
				tableVeiw.refresh();
			});

		});

		btrefresh.setOnAction(e -> {
			tableVeiw.refresh();
		});

		btclear.setOnAction(e -> {
			showDialog(stage, NONE, tableVeiw);
		});

		// update info in driver table==================================================

		column5.setCellFactory(TextFieldTableCell.forTableColumn());
		column5.setOnEditCommit((TableColumn.CellEditEvent<carTrip, String> t) -> {
			t.getTableView().getItems().get(t.getTablePosition().getRow()).setCarNumber(t.getNewValue());
			updatecarnum(t.getRowValue().getCarTripNumber(), t.getRowValue().getCarNumber());
		});

		column2.setCellFactory(TextFieldTableCell.forTableColumn());
		column2.setOnEditCommit((TableColumn.CellEditEvent<carTrip, String> t) -> {
			t.getTableView().getItems().get(t.getTablePosition().getRow()).setDriverName(t.getNewValue());
			updateDriverName(t.getRowValue().getCarTripNumber(), t.getRowValue().getDriverName());
		});

		// =====================================================================================
		HBox hb = new HBox(10);
		hb.setPadding(new Insets(10, 10, 10, 10));
		hb.getChildren().addAll(btadd, btdelete, btrefresh, btclear);
		hb.setAlignment(Pos.CENTER);

		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		hb1.setPadding(new Insets(10, 10, 10, 10));

		vbtittle.getChildren().addAll(lbTittle);
		vbtittle.setAlignment(Pos.CENTER);
		vbox.setAlignment(Pos.CENTER);
		hb1.getChildren().addAll(tableVeiw, gridpane);
		vbox.getChildren().addAll(vbtittle, hb1, hb);
		// vbox.setStyle("-fx-background-color: #d2eac9;");

		((Group) scene.getRoot()).getChildren().addAll(vbox);
		stage.setScene(scene);

	}

	public void insertData(carTrip c) {
		try {
			connectDB();

			String sql = "INSERT INTO CarTrips(CarTripNumber, DriverName, OdometerOnStart, "
					+ "CarNumber, StartTripDate, EndTripDate, FleetOfficerName, Distance, Notes) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);

			preparedStatement.setInt(1, c.getCarTripNumber());
			preparedStatement.setString(2, c.getDriverName());
			preparedStatement.setString(3, c.getOdometerOnStart());
			preparedStatement.setString(4, c.getCarNumber());
			preparedStatement.setDate(5, java.sql.Date.valueOf(c.getStartTripDate()));
			preparedStatement.setDate(6, java.sql.Date.valueOf(c.getEndTripDate()));
			preparedStatement.setString(7, c.getFleetOfficerName());
			preparedStatement.setString(8, c.getCarNumber());
			preparedStatement.setString(9, c.getNotes());

			preparedStatement.executeUpdate();

			con.close();
			System.out.println("Connection closed" + data.size());

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getData() throws Exception, ClassNotFoundException {

		String SQL;

		connectDB();
		System.out.println("Connection established");

		SQL = "select * from CarTrips ";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);

		while (rs.next()) {
			data.add(new carTrip(rs.getInt("CarTripNumber"), // Correct the column name here
					rs.getString("DriverName"), rs.getString("OdometerOnStart"), rs.getString("CarNumber"),
					rs.getDate("StartTripDate").toLocalDate(), rs.getDate("EndTripDate").toLocalDate(),
					rs.getString("FleetOfficerName"), rs.getString("Distance"), rs.getString("Notes")));
		}

		rs.close();
		stmt.close();

		con.close();
		System.out.println("Connection closed" + data.size());

	}

	private void connectDB() throws ClassNotFoundException, Exception {

		dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName + "?verifyServerCertificate=false";
		Properties p = new Properties();
		p.setProperty("user", dbUsername);
		p.setProperty("password", dbPassword);
		p.setProperty("useSSL", "false");
		p.setProperty("autoReconnect", "true");
		Class.forName("com.mysql.jdbc.Driver");

		con = DriverManager.getConnection(dbURL, p);

	}

	public void ExecuteStatement(String SQL) throws Exception {

		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(SQL);
			stmt.close();

		} catch (SQLException s) {
			s.printStackTrace();
			System.out.println("SQL statement is not executed!");

		}

	}

	public void updatecarnum(int carTripNum, String phone) {

		try {
			System.out.println("update  CarTrips set  CarNumber = '" + phone + "' where CarTripNumber = " + carTripNum);
			connectDB();
			ExecuteStatement(
					"update  CarTrips set  CarNumber = '" + phone + "' where CarTripNumber = " + carTripNum + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateDriverName(int requestnum, String employeeName) {

		try {
			System.out.println(
					"update  CarTrips set  DriverName = '" + employeeName + "' where CarTripNumber = " + requestnum);
			connectDB();
			ExecuteStatement("update  CarTrips set DriverName = '" + employeeName + "' where CarTripNumber = "
					+ requestnum + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteRow(carTrip c) {
		try {
			System.out.println("delete from CarTrips where CarTripNumber=" + c.getCarTripNumber() + ";");
			connectDB();
			ExecuteStatement("delete from CarTrips where CarTripNumber=" + c.getCarTripNumber() + ";");
			con.close();
			System.out.println("Connection closed");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void showDialog(Window owner, Modality modality, TableView<carTrip> table) {
		// Create a Stage with specified owner and modality
		Stage stage = new Stage();
		stage.initOwner(owner);
		stage.initModality(modality);
		// Label modalityLabel = new Label(modality.toString());

		Button yesButton = new Button("Confirm");
		yesButton.setOnAction(e -> {
			for (carTrip row : dataList) {
				deleteRow(row);
				table.refresh();
			}
			table.getItems().removeAll(dataList);
			stage.close();

		});

		Button noButton = new Button("Cancel");
		noButton.setOnAction(e -> stage.close());

		HBox root = new HBox();
		root.setPadding(new Insets(10, 10, 10, 10));
		root.setAlignment(Pos.CENTER);
		root.setSpacing(10);

		root.getChildren().addAll(yesButton, noButton);
		Scene scene = new Scene(root, 200, 100);
		stage.setScene(scene);
		stage.setTitle("Confirm Delete?");
		stage.show();
	}

//	private void displayIntroImage(Stage stage) {
//
//		// String introImageURL =
//		// "https://mir-s3-cdn-cf.behance.net/projects/404/60bc84144780059.Y3JvcCwxOTIzLDE1MDQsMzgsMzQy.jpg";
//		// // Change the path accordingly
//		String introImageURL = "https://theminers.ps/uploads/images/2023/08/su1M1.png";
//		Image introImage = new Image(introImageURL);
//		ImageView imageView = new ImageView(introImage);
//		imageView.setFitHeight(stage.getHeight());
//		imageView.setFitWidth(stage.getWidth());
//
//		// imageView.setOpacity(0);
//
//		Timeline timeline = new Timeline(
//				new KeyFrame(Duration.seconds(1.5), new KeyValue(imageView.opacityProperty(), 1)), // Fade in
//				new KeyFrame(Duration.seconds(2.5), new KeyValue(imageView.opacityProperty(), 0)) // Fade out after 1
//																									// second
//		);
//		timeline.setOnFinished(event -> imageView.setMouseTransparent(true)); // Make the image transparent to mouse
//																				// events after it fades out
//
//		Group root = (Group) stage.getScene().getRoot();
//		root.getChildren().add(imageView);
//
//		timeline.play();
//	}

}
