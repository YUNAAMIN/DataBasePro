package application;

import static javafx.stage.Modality.NONE;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
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
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.converter.BigDecimalStringConverter;
import javafx.util.converter.IntegerStringConverter;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * A JavaFX ConnectDB Application
 */
public class table_AccidentsRecords {
	/**
	 * @param args the command line arguments
	 * 
	 * 
	 */
	private ArrayList<AccidentsRecords> data;
	private ObservableList<AccidentsRecords> dataList;

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

	public table_AccidentsRecords() {

	}

	// will cal this in the hompage of the fleetofficer menu
	public Pane AccidentsRecordstable(Stage stage) {
		data = new ArrayList<>();

		try {

			getData();

			dataList = FXCollections.observableArrayList(data);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return table(stage);

	}

	
	 static String selectedText = "";
	 static String selectedText2 = "";
	 static String selectedText3 = "";
	 static String selectedText4 = "";
	 
	public Pane table(Stage stage) {

		Pane p = new Pane();
		// tableveiw=======================================================================
		TableView<AccidentsRecords> tableVeiw = new TableView<AccidentsRecords>();
		tableVeiw.setStyle("-fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5); "
				+ "-fx-border-width: 3px; " + "-fx-border-radius: 5px; "
				+ "-fx-background-color: linear-gradient(to bottom, #cfeccb, #81dbf5);");

		TableColumn<AccidentsRecords, Integer> column1 = new TableColumn<AccidentsRecords, Integer>(
				"AccidentRecordNumber");
		column1.setCellValueFactory(new PropertyValueFactory<AccidentsRecords, Integer>("AccidentRecordNumber"));

		TableColumn<AccidentsRecords, LocalDate> column2 = new TableColumn<AccidentsRecords, LocalDate>("AccidentDate");
		column2.setCellValueFactory(new PropertyValueFactory<AccidentsRecords, LocalDate>("AccidentDate"));

		TableColumn<AccidentsRecords, Integer> column3 = new TableColumn<AccidentsRecords, Integer>("CarNumber");
		column3.setCellValueFactory(new PropertyValueFactory<AccidentsRecords, Integer>("CarNumber"));

		TableColumn<AccidentsRecords, String> column4 = new TableColumn<AccidentsRecords, String>("DriverName");
		column4.setCellValueFactory(new PropertyValueFactory<AccidentsRecords, String>("DriverName"));

		TableColumn<AccidentsRecords, String> column5 = new TableColumn<AccidentsRecords, String>("PoliceReport");
		column5.setCellValueFactory(new PropertyValueFactory<AccidentsRecords, String>("PoliceReport"));

		TableColumn<AccidentsRecords, String> column6 = new TableColumn<AccidentsRecords, String>("NotifyInsurance");
		column6.setCellValueFactory(new PropertyValueFactory<AccidentsRecords, String>("NotifyInsurance"));

		TableColumn<AccidentsRecords, String> column7 = new TableColumn<AccidentsRecords, String>(
				"NotifyRentalCompany");
		column7.setCellValueFactory(new PropertyValueFactory<AccidentsRecords, String>("NotifyRentalCompany"));

		TableColumn<AccidentsRecords, String> column8 = new TableColumn<AccidentsRecords, String>("Injuries");
		column8.setCellValueFactory(new PropertyValueFactory<AccidentsRecords, String>("Injuries"));

		TableColumn<AccidentsRecords, String> column9 = new TableColumn<AccidentsRecords, String>("NeedForMaintenance");
		column9.setCellValueFactory(new PropertyValueFactory<AccidentsRecords, String>("NeedForMaintenance"));

		TableColumn<AccidentsRecords, String> column10 = new TableColumn<AccidentsRecords, String>("Notes");
		column10.setCellValueFactory(new PropertyValueFactory<AccidentsRecords, String>("Notes"));

		TableColumn<AccidentsRecords, Integer> column11 = new TableColumn<AccidentsRecords, Integer>(
				"ReplacementCarNumber");
		column11.setCellValueFactory(new PropertyValueFactory<AccidentsRecords, Integer>("ReplacementCarNumber"));

		TableColumn<AccidentsRecords, LocalDate> column12 = new TableColumn<AccidentsRecords, LocalDate>(
				"StartDateForReplacement");
		column12.setCellValueFactory(new PropertyValueFactory<AccidentsRecords, LocalDate>("StartDateForReplacement"));

		// panes===========================================================================================
		VBox vbtittle = new VBox(5);
		final VBox vbox = new VBox(10);
		HBox hb1 = new HBox(10);

		// labeles==============================================================================================
		Label lbTittle = new Label("AccidentsRecordss TableVeiw");

		Font fbold = Font.font("IMPACT", FontWeight.BLACK, FontPosture.REGULAR, 35);
		lbTittle.setFont(fbold);
		lbTittle.setStyle("-fx-text-fill:linear-gradient(to bottom, #cfeccb, #81dbf5); ");// #2d5d7a;
		// lbTittle.setStyle(" -fx-border-color: linear-gradient(to bottom, #cfeccb,
		// #81dbf5);\r\n"
		// + " -fx-border-width: 3px;\r\n" + " -fx-border-radius: 5px;");

		Scene scene = new Scene(new Group());

		scene.setFill(Color.web("#123a4e"));

		stage.setTitle("AccidentsRecordss Table");
		stage.setWidth(1400);
		stage.setHeight(900);

		tableVeiw.setEditable(true);
		tableVeiw.setMaxHeight(500);
		tableVeiw.setMaxWidth(700);

		Font normal = Font.font("Arial Narrow", FontWeight.BOLD, FontPosture.REGULAR, 15);

		Button btadd = new Button("Add");
		Button btdelete = new Button("Delete");
		Button btclear = new Button("Clear All");
		Button btrefresh = new Button("Refresh");
		btadd.setFont(normal);
		btdelete.setFont(normal);
		btclear.setFont(normal);
		btrefresh.setFont(normal);

		tableVeiw.setItems(dataList);

		tableVeiw.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7, column8, column9,
				column10, column11 ,column12);

		// pane=========================================================
		GridPane gridpane = new GridPane();

		// labels============================================================
		Label lb1 = new Label("Accidents Records number");
		Label lb2 = new Label("Accident Date");
		Label lb3 = new Label("Car Number");
		Label lb4 = new Label("Driver Name");
		Label lb5 = new Label("Police Report");
		Label lb6 = new Label("Notify Insurance");
		Label lb7 = new Label("Notify Rental Company");
		Label lb8 = new Label("Injuries");
		Label lb9 = new Label("Need For Maintenance");
		Label lb10 = new Label("Notes");
		Label lb11 = new Label("Replacement CarNumber");
		Label lb12 = new Label("StartDate For Replacement");

		lb1.setFont(normal);
		lb2.setFont(normal);
		lb3.setFont(normal);
		lb4.setFont(normal);
		lb5.setFont(normal);
		lb6.setFont(normal);
		lb7.setFont(normal);
		lb8.setFont(normal);
		lb9.setFont(normal);
		lb10.setFont(normal);
		lb11.setFont(normal);
		lb12.setFont(normal);

		lb1.setTextFill(Color.web("#dadede"));
		lb2.setTextFill(Color.web("#dadede"));
		lb3.setTextFill(Color.web("#dadede"));
		lb4.setTextFill(Color.web("#dadede"));
		lb5.setTextFill(Color.web("#dadede"));
		lb6.setTextFill(Color.web("#dadede"));
		lb7.setTextFill(Color.web("#dadede"));
		lb8.setTextFill(Color.web("#dadede"));
		lb9.setTextFill(Color.web("#dadede"));
		lb10.setTextFill(Color.web("#dadede"));
		lb11.setTextFill(Color.web("#dadede"));
		lb12.setTextFill(Color.web("#dadede"));

		// textfeild====================================================
		TextField AccidentRecordNumber = new TextField();
		TextField CarNumber = new TextField();
		TextField DriverName = new TextField();
		TextField PoliceReport = new TextField();

		TextField Notes = new TextField();
		TextField ReplacementCarNumber = new TextField();

		// datepicker==============================================
		DatePicker AccidentDate = new DatePicker();
		DatePicker StartDateForReplacement = new DatePicker();

		// radiobuttons========================================================
		ToggleGroup group1 = new ToggleGroup();
		RadioButton rb11 = new RadioButton("yes");
		RadioButton rb12 = new RadioButton("no");
		group1.getToggles().addAll(rb11, rb12);

		rb11.setFont(normal);
		rb12.setFont(normal);

		rb11.setTextFill(Color.web("#dadede"));
		rb12.setTextFill(Color.web("#dadede"));

		ToggleGroup group2 = new ToggleGroup();
		RadioButton rb21 = new RadioButton("yes");
		RadioButton rb22 = new RadioButton("no");
		group2.getToggles().addAll(rb21, rb22);
		rb21.setFont(normal);
		rb22.setFont(normal);
		rb21.setTextFill(Color.web("#dadede"));
		rb22.setTextFill(Color.web("#dadede"));

		ToggleGroup group3 = new ToggleGroup();
		RadioButton rb31 = new RadioButton("yes");
		RadioButton rb32 = new RadioButton("no");
		group3.getToggles().addAll(rb31, rb32);
		rb31.setFont(normal);
		rb32.setFont(normal);
		rb31.setTextFill(Color.web("#dadede"));
		rb32.setTextFill(Color.web("#dadede"));

		ToggleGroup group4 = new ToggleGroup();
		RadioButton rb41 = new RadioButton("yes");
		RadioButton rb42 = new RadioButton("no");
		group4.getToggles().addAll(rb41, rb42);
		rb41.setFont(normal);
		rb42.setFont(normal);
		rb41.setTextFill(Color.web("#dadede"));
		rb42.setTextFill(Color.web("#dadede"));

		gridpane.addRow(0, lb1, AccidentRecordNumber);
		gridpane.addRow(1, lb2, AccidentDate);
		gridpane.addRow(2, lb3, CarNumber);
		gridpane.addRow(3, lb4, DriverName);
		gridpane.addRow(4, lb5, PoliceReport);
		gridpane.addRow(5, lb6, rb11, rb12);
		gridpane.addRow(6, lb7, rb21, rb22);
		gridpane.addRow(7, lb8, rb31, rb32);
		gridpane.addRow(8, lb9, rb41, rb42);
		gridpane.addRow(9, lb10, Notes);
		gridpane.addRow(10, lb11, ReplacementCarNumber);
		gridpane.addRow(11, lb12, StartDateForReplacement);

		gridpane.setPadding(new Insets(10, 10, 10, 10));
		gridpane.setHgap(10);
		gridpane.setVgap(10);
		gridpane.setStyle(" -fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5);\r\n"
				+ "    -fx-border-width: 3px;\r\n" + "    -fx-border-radius: 5px;");

		// button

		// handler=======================================================================================================

			RadioButton selected1 = (RadioButton) group1.getSelectedToggle();
			RadioButton selected2 = (RadioButton) group2.getSelectedToggle();
			RadioButton selected3 = (RadioButton) group3.getSelectedToggle();
			RadioButton selected4 = (RadioButton) group4.getSelectedToggle();
			
		
			
			
		rb11.setOnAction(e->{
			selectedText = rb11.getText();
		});
		
		
		rb12.setOnAction(e->{
			selectedText = rb12.getText();
		});
		
		
		
		rb21.setOnAction(e->{
			selectedText2 = rb21.getText();
		});
		
		
		rb22.setOnAction(e->{
			selectedText2 = rb22.getText();
		});
		
		
		rb31.setOnAction(e->{
			selectedText3 = rb31.getText();
		});
		
		
		rb32.setOnAction(e->{
			selectedText3 = rb32.getText();
		});
		
		
		rb41.setOnAction(e->{
			selectedText4 = rb41.getText();
		});
		
		
		rb42.setOnAction(e->{
			selectedText4 = rb42.getText();
		});
		
		
			
		btadd.setOnAction((ActionEvent e) -> {


			AccidentsRecords c = new AccidentsRecords(Integer.valueOf(AccidentRecordNumber.getText()),
					AccidentDate.getValue(), Integer.valueOf(CarNumber.getText()), DriverName.getText(),
					PoliceReport.getText(), selectedText , selectedText2, selectedText3,
					selectedText4, Notes.getText(), Integer.valueOf(ReplacementCarNumber.getText()),
					StartDateForReplacement.getValue());

			dataList.add(c);
			insertData(c);
		});

		btdelete.setOnAction(e -> {
			ObservableList<AccidentsRecords> selectedRows = tableVeiw.getSelectionModel().getSelectedItems();
			ArrayList<AccidentsRecords> rows = new ArrayList<>(selectedRows);
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

		btadd.setStyle(
				"-fx-border-color: #006400; -fx-border-width: 2px; -fx-background-radius: 30; -fx-border-radius: 30;");
		btdelete.setStyle(
				"-fx-border-color: #006400; -fx-border-width: 2px; -fx-background-radius: 30; -fx-border-radius: 30;");
		btclear.setStyle(
				"-fx-border-color: #006400; -fx-border-width: 2px; -fx-background-radius: 30; -fx-border-radius: 30;");
		btrefresh.setStyle(
				"-fx-border-color: #006400; -fx-border-width: 2px; -fx-background-radius: 30; -fx-border-radius: 30;");

		// update info in AccidentsRecords
		// table==================================================

		column7.setCellFactory(TextFieldTableCell.forTableColumn());
		column7.setOnEditCommit((TableColumn.CellEditEvent<AccidentsRecords, String> t) -> {
			t.getTableView().getItems().get(t.getTablePosition().getRow()).setNotifyRentalCompany(t.getNewValue());
			updaterentCompanyName(t.getRowValue().getAccidentRecordNumber(), t.getRowValue().getNotifyRentalCompany());
		});

		column11.setCellValueFactory(new PropertyValueFactory<>("replacementCarNumber"));
		column11.setOnEditCommit((TableColumn.CellEditEvent<AccidentsRecords, Integer> t) -> {
			t.getTableView().getItems().get(t.getTablePosition().getRow()).setReplacementCarNumber(t.getNewValue());
			updateRentfee(t.getRowValue().getAccidentRecordNumber(), t.getRowValue().getReplacementCarNumber());
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
		hb1.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(vbtittle, hb1, hb);

		p.getChildren().add(vbox);

		return p;

	}

	public void insertData(AccidentsRecords c) {

		try {

			System.out.println("INSERT INTO AccidentsRecords VALUES (" + c.getAccidentRecordNumber() + ",'"
					+ c.getAccidentDate() + "'," + c.getCarNumber() + ",'" + c.getDriverName() + "', '"
					+ c.getPoliceReport() + "','" + c.getNotifyInsurance() + "','" + c.getNotifyRentalCompany() + "','"
					+ c.getInjuries() + "', '" + c.getNeedForMaintenance() + "','" + c.getNotes() + "','"
					+ c.getReplacementCarNumber() + "','" + c.getStartDateForReplacement() + "');");

			connectDB();

			ExecuteStatement("INSERT INTO AccidentsRecords VALUES (" + c.getAccidentRecordNumber() + ",'"
					+ c.getAccidentDate() + "'," + c.getCarNumber() + ",'" + c.getDriverName() + "', '"
					+ c.getPoliceReport() + "','" + c.getNotifyInsurance() + "','" + c.getNotifyRentalCompany() + "','"
					+ c.getInjuries() + "', '" + c.getNeedForMaintenance() + "','" + c.getNotes() + "','"
					+ c.getReplacementCarNumber() + "','" + c.getStartDateForReplacement() + "');");

			con.close();
			System.out.println("Connection closed" + data.size());

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void getData() throws SQLException, ClassNotFoundException {

		String SQL;

		connectDB();
		System.out.println("Connection established");

		SQL = "select * from AccidentsRecords ";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);

		while (rs.next()) {

			data.add(new AccidentsRecords(rs.getInt("AccidentRecordNumber"), rs.getDate("AccidentDate").toLocalDate(),
					rs.getInt("CarNumber"), rs.getString("DriverName"), rs.getString("PoliceReport"),
					rs.getString("NotifyInsurance"), rs.getString("NotifyRentalCompany"), rs.getString("Injuries"),
					rs.getString("NeedForMaintenance"), rs.getString("Notes"), rs.getInt("ReplacementCarNumber"),
					rs.getDate("StartDateForReplacement").toLocalDate()));

		}

		rs.close();
		stmt.close();

		con.close();
		System.out.println("Connection closed" + data.size());

	}

	private void connectDB() throws ClassNotFoundException, SQLException {

		dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName + "?verifyServerCertificate=false";
		Properties p = new Properties();
		p.setProperty("user", dbUsername);
		p.setProperty("password", dbPassword);
		p.setProperty("useSSL", "false");
		p.setProperty("autoReconnect", "true");
		Class.forName("com.mysql.jdbc.Driver");

		con = DriverManager.getConnection(dbURL, p);

	}

	public void ExecuteStatement(String SQL) throws SQLException {

		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(SQL);
			stmt.close();

		} catch (SQLException s) {
			s.printStackTrace();
			System.out.println("SQL statement is not executed!");

		}

	}

	public void updateRentfee(int AccidentsRecordsNum, int i) {

		try {
			System.out.println("update  AccidentsRecords set  ReplacementCarNumber = '" + i
					+ "' where AccidentRecordNumber = " + AccidentsRecordsNum);
			connectDB();
			ExecuteStatement("update  AccidentsRecords set  ReplacementCarNumber = '" + i
					+ "' where AccidentRecordNumber = " + AccidentsRecordsNum + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updaterentCompanyName(int AccidentsRecordsNum, String companyname) {

		try {
			System.out.println("update  AccidentsRecords set  NotifyRentalCompany = '" + companyname
					+ "' where AccidentRecordNumber = " + AccidentsRecordsNum);
			connectDB();
			ExecuteStatement("update  AccidentsRecords set  NotifyRentalCompany = '" + companyname
					+ "' where AccidentRecordNumber = " + AccidentsRecordsNum + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void deleteRow(AccidentsRecords c) {
		try {
			System.out.println(
					"delete from AccidentsRecords where AccidentRecordNumber=" + c.getAccidentRecordNumber() + ";");
			connectDB();
			ExecuteStatement(
					"delete from AccidentsRecords where AccidentRecordNumber=" + c.getAccidentRecordNumber() + ";");
			con.close();
			System.out.println("Connection closed");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void showDialog(Window owner, Modality modality, TableView<AccidentsRecords> table) {
		// Create a Stage with specified owner and modality
		Stage stage = new Stage();
		stage.initOwner(owner);
		stage.initModality(modality);

		Button yesButton = new Button("Confirm");
		yesButton.setOnAction(e -> {
			for (AccidentsRecords row : dataList) {
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

	public static Pane createCharts() {
		VBox chartBox = new VBox(10);
		chartBox.setAlignment(Pos.CENTER);

		PieChart pieChart = createStyledPieChart();// pie chart
		BarChart<String, Number> barChart = createStyledBarChart();// bar chart
		chartBox.getChildren().addAll(pieChart, barChart);

		return chartBox;
	}

	public static PieChart createStyledPieChart() {
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
				new PieChart.Data("Active AccidentsRecords", 50), new PieChart.Data("Inactive AccidentsRecordss", 30),
				new PieChart.Data("Rental AccidentsRecords", 20));

		PieChart pieChart = new PieChart(pieChartData);
		pieChart.setTitle("AccidentsRecords Status Distribution");

		// Apply styles for PieChart
		pieChart.setStyle("-fx-pie-color: #2196F3, #03A9F4, #00BCD4;");

		return pieChart;
	}

	public static BarChart<String, Number> createStyledBarChart() {
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);

		barChart.setTitle("AccidentsRecords Rental Fees");

		// Apply styles for BarChart
		barChart.setStyle("-fx-bar-fill: #2196F3;");

		xAxis.setLabel("AccidentsRecords Brands");
		yAxis.setLabel("Rental Fee");

		XYChart.Series<String, Number> series = new XYChart.Series<>();
		series.getData().add(new XYChart.Data<>("Brand A", 500));
		series.getData().add(new XYChart.Data<>("Brand B", 700));
		series.getData().add(new XYChart.Data<>("Brand C", 600));

		barChart.getData().add(series);

		return barChart;
	}

}
