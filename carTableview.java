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
public class carTableview {
	/**
	 * @param args the command line arguments
	 * 
	 * 
	 */
	private ArrayList<car> data;
	private ObservableList<car> dataList;

	private static String dbUsername = "root"; // database username
	//private static String dbPassword = "yunayuna123"; // database password
	
	private static String dbPassword ="yunayuna123" ;
	private static String URL = "127.0.0.1"; // server location

	private static String port = "3306"; // port that mysql uses
	private static String dbName = "miniFleetsystem"; // database on mysql to connect to
	private String dbURL;
	private Connection con;

	public static void main(String[] args) {

		Application.launch(args);
	}

	public carTableview() {

	}

	// will cal this in the hompage of the fleetofficer menu
	public Pane cartable(Stage stage) {
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

	public Pane table(Stage stage) {

		Pane p = new Pane();
		// tableveiw=======================================================================
		TableView<car> tableVeiw = new TableView<car>();
		tableVeiw.setStyle("-fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5); "
				+ "-fx-border-width: 3px; " + "-fx-border-radius: 5px; "
				+ "-fx-background-color: linear-gradient(to bottom, #cfeccb, #81dbf5);");

		TableColumn<car, Integer> column1 = new TableColumn<car, Integer>("carNumber");
		column1.setCellValueFactory(new PropertyValueFactory<car, Integer>("carNumber"));

		TableColumn<car, String> column2 = new TableColumn<car, String>("brandName");
		column2.setCellValueFactory(new PropertyValueFactory<car, String>("brandName"));

		TableColumn<car, String> column3 = new TableColumn<car, String>("rentalCompanyName");
		column3.setCellValueFactory(new PropertyValueFactory<car, String>("rentalCompanyName"));

		TableColumn<car, BigDecimal> column4 = new TableColumn<car, BigDecimal>("rentFee");
		column4.setCellValueFactory(new PropertyValueFactory<car, BigDecimal>("rentFee"));

		TableColumn<car, LocalDate> column5 = new TableColumn<car, LocalDate>("contractStartDate");
		column5.setCellValueFactory(new PropertyValueFactory<car, LocalDate>("contractStartDate"));

		TableColumn<car, LocalDate> column6 = new TableColumn<car, LocalDate>("contractExpirationDate");
		column6.setCellValueFactory(new PropertyValueFactory<car, LocalDate>("contractExpirationDate"));

		TableColumn<car, LocalDate> column7 = new TableColumn<car, LocalDate>("licenceInsuranceEndDate");
		column7.setCellValueFactory(new PropertyValueFactory<car, LocalDate>("licenceInsuranceEndDate"));

		TableColumn<car, Integer> column8 = new TableColumn<car, Integer>("carMeter");
		column8.setCellValueFactory(new PropertyValueFactory<car, Integer>("carMeter"));

		TableColumn<car, String> column9 = new TableColumn<car, String>("carColor");
		column9.setCellValueFactory(new PropertyValueFactory<car, String>("carColor"));

		TableColumn<car, Integer> column10 = new TableColumn<car, Integer>("motorPower");
		column10.setCellValueFactory(new PropertyValueFactory<car, Integer>("motorPower"));

		TableColumn<car, String> column11 = new TableColumn<car, String>("fuelType");
		column11.setCellValueFactory(new PropertyValueFactory<car, String>("fuelType"));

		TableColumn<car, Integer> column12 = new TableColumn<car, Integer>("fuelTankCapacity");
		column12.setCellValueFactory(new PropertyValueFactory<car, Integer>("fuelTankCapacity"));

		TableColumn<car, String> column13 = new TableColumn<car, String>("contractType");
		column13.setCellValueFactory(new PropertyValueFactory<car, String>("contractType"));

		TableColumn<car, String> column14 = new TableColumn<car, String>("notes");
		column14.setCellValueFactory(new PropertyValueFactory<car, String>("notes"));

		TableColumn<car, String> column15 = new TableColumn<car, String>("carStatus");
		column15.setCellValueFactory(new PropertyValueFactory<car, String>("carStatus"));

		// panes===========================================================================================
		VBox vbtittle = new VBox(5);
		final VBox vbox = new VBox(10);
		HBox hb1 = new HBox(10);

		// labeles==============================================================================================
		Label lbTittle = new Label("Cars TableVeiw");

		Font fbold = Font.font("IMPACT", FontWeight.BLACK, FontPosture.REGULAR, 35);
		lbTittle.setFont(fbold);
		lbTittle.setStyle("-fx-text-fill:linear-gradient(to bottom, #cfeccb, #81dbf5); ");// #2d5d7a;
		// lbTittle.setStyle(" -fx-border-color: linear-gradient(to bottom, #cfeccb,
		// #81dbf5);\r\n"
		// + " -fx-border-width: 3px;\r\n" + " -fx-border-radius: 5px;");

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

		stage.setTitle("Cars Table");
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
				column10, column11, column12, column13, column14, column15);

		// pane=========================================================
		GridPane gridpane = new GridPane();

		// labels============================================================
		Label lb1 = new Label("car number");
		Label lb2 = new Label("brand name");
		Label lb3 = new Label("rental company name");
		Label lb4 = new Label("rent fee");
		Label lb5 = new Label("contract start date");
		Label lb6 = new Label("contract expiration date");
		Label lb7 = new Label("licence insurance end date");
		Label lb8 = new Label("car meter");
		Label lb9 = new Label("car color");
		Label lb10 = new Label("motor power");
		Label lb11 = new Label("fuel type");
		Label lb12 = new Label("fuel tank capacity");
		Label lb13 = new Label("contract type");
		Label lb14 = new Label("notes");
		Label lb15 = new Label("car status");

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
		lb13.setFont(normal);
		lb14.setFont(normal);
		lb15.setFont(normal);

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
		lb13.setTextFill(Color.web("#dadede"));
		lb14.setTextFill(Color.web("#dadede"));
		lb15.setTextFill(Color.web("#dadede"));

		// textfeild====================================================
		TextField tfcarnum = new TextField();
		TextField tfbrandname = new TextField();
		TextField tfrentalname = new TextField();
		TextField tfrent = new TextField();

		TextField tfcarmeter = new TextField();
		TextField tfcarcolor = new TextField();
		TextField tfmotorpower = new TextField();

		TextField tffueltackcap = new TextField();

		TextField tfnotes = new TextField();

		// datepicker==============================================
		DatePicker dcontractstartdate = new DatePicker();
		DatePicker dcontractenddate = new DatePicker();
		DatePicker dlicensedate = new DatePicker();

		// radiobuttons========================================================
		ToggleGroup group1 = new ToggleGroup();
		RadioButton rb11 = new RadioButton("Diesel");
		RadioButton rb12 = new RadioButton("Petrol");
		RadioButton rb13 = new RadioButton("Gasoline");
		rb11.setToggleGroup(group1);
		rb12.setToggleGroup(group1);
		rb13.setToggleGroup(group1);

		ToggleGroup group2 = new ToggleGroup();
		RadioButton rb21 = new RadioButton("Owned");
		RadioButton rb22 = new RadioButton("Rental");
		RadioButton rb23 = new RadioButton("Substitute");
		rb21.setToggleGroup(group2);
		rb22.setToggleGroup(group2);
		rb23.setToggleGroup(group2);

		ToggleGroup group3 = new ToggleGroup();
		RadioButton rb31 = new RadioButton("Active");
		RadioButton rb32 = new RadioButton("Not Active");
		rb31.setToggleGroup(group3);
		rb32.setToggleGroup(group3);

		rb11.setFont(normal);
		rb12.setFont(normal);
		rb13.setFont(normal);
		rb21.setFont(normal);
		rb22.setFont(normal);
		rb23.setFont(normal);
		rb31.setFont(normal);
		rb32.setFont(normal);

		rb11.setTextFill(Color.web("#dadede"));
		rb12.setTextFill(Color.web("#dadede"));
		rb13.setTextFill(Color.web("#dadede"));
		rb21.setTextFill(Color.web("#dadede"));
		rb22.setTextFill(Color.web("#dadede"));
		rb23.setTextFill(Color.web("#dadede"));
		rb31.setTextFill(Color.web("#dadede"));
		rb32.setTextFill(Color.web("#dadede"));

		gridpane.addRow(0, lb1, tfcarnum);
		gridpane.addRow(1, lb2, tfbrandname);
		gridpane.addRow(2, lb3, tfrentalname);
		gridpane.addRow(3, lb4, tfrent);
		gridpane.addRow(4, lb5, dcontractstartdate);
		gridpane.addRow(5, lb6, dcontractenddate);
		gridpane.addRow(6, lb7, dlicensedate);
		gridpane.addRow(7, lb8, tfcarmeter);
		gridpane.addRow(8, lb9, tfcarcolor);
		gridpane.addRow(9, lb10, tfmotorpower);
		gridpane.addRow(10, lb11, rb11, rb12, rb13);
		gridpane.addRow(11, lb12, tffueltackcap);
		gridpane.addRow(12, lb13, rb21, rb22, rb23);
		gridpane.addRow(13, lb14, tfnotes);
		gridpane.addRow(14, lb15, rb31, rb32);

		gridpane.setPadding(new Insets(10, 10, 10, 10));
		gridpane.setHgap(10);
		gridpane.setVgap(10);
		gridpane.setStyle(" -fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5);\r\n"
				+ "    -fx-border-width: 3px;\r\n" + "    -fx-border-radius: 5px;");

		// button
		// handler=======================================================================================================
		btadd.setOnAction((ActionEvent e) -> {

			RadioButton selected1 = (RadioButton) group1.getSelectedToggle();
			RadioButton selected2 = (RadioButton) group2.getSelectedToggle();
			RadioButton selected3 = (RadioButton) group3.getSelectedToggle();

			car c = new car(Integer.valueOf(tfcarnum.getText()), tfbrandname.getText(), tfrentalname.getText(),
					BigDecimal.valueOf(Double.valueOf(tfrent.getText())), dcontractstartdate.getValue(),
					dcontractenddate.getValue(), dlicensedate.getValue(), Integer.valueOf(tfcarmeter.getText()),
					tfcarcolor.getText(), Integer.valueOf(tfmotorpower.getText()), selected1.getText(),
					Integer.valueOf(tffueltackcap.getText()), selected2.getText(), tfnotes.getText(),
					selected3.getText());

			dataList.add(c);
			insertData(c);

		});

		btdelete.setOnAction(e -> {
			ObservableList<car> selectedRows = tableVeiw.getSelectionModel().getSelectedItems();
			ArrayList<car> rows = new ArrayList<>(selectedRows);
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

		// update info in car table==================================================

		column3.setCellFactory(TextFieldTableCell.forTableColumn());
		column3.setOnEditCommit((TableColumn.CellEditEvent<car, String> t) -> {
			t.getTableView().getItems().get(t.getTablePosition().getRow()).setRentalCompanyName(t.getNewValue());
			updaterentCompanyName(t.getRowValue().getCarNumber(), t.getRowValue().getRentalCompanyName());
		});

		column4.setCellFactory(TextFieldTableCell.<car, BigDecimal>forTableColumn(new BigDecimalStringConverter()));
		column4.setOnEditCommit((TableColumn.CellEditEvent<car, BigDecimal> t) -> {
			t.getTableView().getItems().get(t.getTablePosition().getRow()).setRentFee(t.getNewValue());
			updateRentfee(t.getRowValue().getCarNumber(), t.getRowValue().getRentFee());
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

		// ((Group) scene.getRoot()).getChildren().addAll(vbox);
		// stage.setScene(scene);
		p.getChildren().add(vbox);

		return p;

	}

	public void insertData(car c) {

		try {

			System.out.println("INSERT INTO Car VALUES (" + c.getCarNumber() + ",'" + c.getBrandName() + "','"
					+ c.getRentalCompanyName() + "'," + c.getRentFee() + ", '" + c.getContractStartDate() + "','"
					+ c.getContractExpirationDate() + "','" + c.getLicenceInsuranceEndDate() + "'," + c.getCarMeter()
					+ ", '" + c.getCarColor() + "','" + c.getMotorPower() + "','" + c.getFuelType() + "',"
					+ c.getFuelTankCapacity() + ", '" + c.getContractType() + "','" + c.getNotes() + "','"
					+ c.getCarStatus() + "');");

			connectDB();

			ExecuteStatement("INSERT INTO Car VALUES (" + c.getCarNumber() + ",'" + c.getBrandName() + "','"
					+ c.getRentalCompanyName() + "'," + c.getRentFee() + ", '" + c.getContractStartDate() + "','"
					+ c.getContractExpirationDate() + "','" + c.getLicenceInsuranceEndDate() + "'," + c.getCarMeter()
					+ ", '" + c.getCarColor() + "','" + c.getMotorPower() + "','" + c.getFuelType() + "',"
					+ c.getFuelTankCapacity() + ", '" + c.getContractType() + "','" + c.getNotes() + "','"
					+ c.getCarStatus() + "');");

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

		SQL = "select * from car ";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);

		while (rs.next()) {

			data.add(new car(rs.getInt("CarNumber"), rs.getString("BrandName"), rs.getString("RentalCompanyName"),
					rs.getBigDecimal("RentFee"), rs.getDate("ContractStartDate").toLocalDate(),
					rs.getDate("ContractExpirationDate").toLocalDate(),
					rs.getDate("LicenceInsuranceEndDate").toLocalDate(), rs.getInt("CarMeter"),
					rs.getString("CarColor"), rs.getInt("MotorPower"), rs.getString("FuelType"),
					rs.getInt("FuelTankCapacity"), rs.getString("ContractType"), rs.getString("Notes"),
					rs.getString("CarStatus")));

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

	public void updateRentfee(int carNum, BigDecimal rentfee) {

		try {
			System.out.println("update  car set  RentFee = '" + rentfee + "' where CarNumber = " + carNum);
			connectDB();
			ExecuteStatement("update  car set  RentFee = '" + rentfee + "' where CarNumber = " + carNum + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updaterentCompanyName(int carNum, String companyname) {

		try {
			System.out
					.println("update  car set  RentalCompanyName = '" + companyname + "' where CarNumber = " + carNum);
			connectDB();
			ExecuteStatement(
					"update  car set  RentalCompanyName = '" + companyname + "' where CarNumber = " + carNum + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void deleteRow(car c) {
		try {
			System.out.println("delete from Car where CarNumber=" + c.getCarNumber() + ";");
			connectDB();
			ExecuteStatement("delete from Car where CarNumber=" + c.getCarNumber() + ";");
			con.close();
			System.out.println("Connection closed");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void showDialog(Window owner, Modality modality, TableView<car> table) {
		// Create a Stage with specified owner and modality
		Stage stage = new Stage();
		stage.initOwner(owner);
		stage.initModality(modality);

		Button yesButton = new Button("Confirm");
		yesButton.setOnAction(e -> {
			for (car row : dataList) {
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
                new PieChart.Data("Active Cars", 50),
                new PieChart.Data("Inactive Cars", 30),
                new PieChart.Data("Rental Cars", 20));

        PieChart pieChart = new PieChart(pieChartData);
        pieChart.setTitle("Car Status Distribution");

        // Apply styles for PieChart
        pieChart.setStyle("-fx-pie-color: #2196F3, #03A9F4, #00BCD4;");

        return pieChart;
    }

    public static BarChart<String, Number> createStyledBarChart() {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);

        barChart.setTitle("Car Rental Fees");

        // Apply styles for BarChart
        barChart.setStyle("-fx-bar-fill: #2196F3;");

        xAxis.setLabel("Car Brands");
        yAxis.setLabel("Rental Fee");

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("Brand A", 500));
        series.getData().add(new XYChart.Data<>("Brand B", 700));
        series.getData().add(new XYChart.Data<>("Brand C", 600));

        barChart.getData().add(series);

        return barChart;
    }

}

