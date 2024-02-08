package application;

import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.LinearGradient;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

/**
 * A JavaFX ConnectDB Application
 */
public class DBFX extends Application {
	public DBFX() {

	}

	private static final Modality NONE = null;
	/**
	 * @param args the command line arguments
	 * 
	 * 
	 */
	private ArrayList<TaxiComapnies> data;
	private ObservableList<TaxiComapnies> dataList;

	private ArrayList<FuelCompany> FC_data;
	private ObservableList<FuelCompany> FC_dataList;

	private ArrayList<CarDistribution> CD_data;
	private ObservableList<CarDistribution> CD_dataList;

	private ArrayList<FuelCoupon> FCOUP_data;
	private ObservableList<FuelCoupon> FCOUP_dataList;

	private ArrayList<FuelCard> FCARD_data;
	private ObservableList<FuelCard> FCARD_dataList;

	private ArrayList<InsuranceCompany> INC_data;
	private ObservableList<InsuranceCompany> INC_dataList;

	private ArrayList<CarWashCompany> CWC_data;
	private ObservableList<CarWashCompany> CWC_dataList;

	private ArrayList<CarWashes> CW_data;
	private ObservableList<CarWashes> CW_dataList;

	private static String dbUsername = "root"; // database username
	// private static String dbPassword = "zncyvl2003"; // database password
	private static String dbPassword = "yunayuna123";
	private static String URL = "127.0.0.1"; // server location

	private static String port = "3306"; // port that mysql uses
	private static String dbName = "minifleetsystem"; // database on mysql to connect to
	private String dbURL;
	private Connection con;

	public static LinearGradient gradient = new LinearGradient(0, // start X
			0, // start Y
			1, // end X
			1, // end Y
			true, // proportional
			CycleMethod.NO_CYCLE, // cycle method
			new Stop(0, Color.rgb(99, 175, 133)), // start color
			new Stop(1, Color.rgb(78, 163, 178)) // end color
	);

	public static Font fbold = Font.font("Impact", FontWeight.BLACK, FontPosture.REGULAR, 35);
	public static Font normal = Font.font("Arial Narrow", FontWeight.BOLD, FontPosture.REGULAR, 14);

	private void displayIntroImage(Stage stage) {

		String introImageURL = "https://theminers.ps/uploads/images/2023/08/su1M1.png";
		Image introImage = new Image(introImageURL);
		ImageView imageView = new ImageView(introImage);
		imageView.setFitHeight(stage.getHeight());
		imageView.setFitWidth(stage.getWidth());

		Timeline timeline = new Timeline(
				new KeyFrame(Duration.seconds(1.5), new KeyValue(imageView.opacityProperty(), 1)), // Fade in
				new KeyFrame(Duration.seconds(2.5), new KeyValue(imageView.opacityProperty(), 0)) // Fade out after 1
																									// second
		);
		timeline.setOnFinished(event -> imageView.setMouseTransparent(true)); // Make the image transparent to mouse
																				// events after it fades out

		Group root = (Group) stage.getScene().getRoot();
		root.getChildren().add(imageView);

		timeline.play();
	}

	public static void main(String[] stage) {
		Application.launch(stage);

	}

	public Pane table_1(Stage tStage) {
		return null;

	}

	@Override
	public void start(Stage stage) throws Exception {
//		data = new ArrayList<>();
//		FC_data= new ArrayList<>();
//		
//		CD_data = new ArrayList<>();
//		FCOUP_data = new ArrayList<>();
//		FCARD_data = new ArrayList<>();
//		INC_data = new ArrayList<>();
//		CWC_data = new ArrayList<>();

		TabPane tabpane = new TabPane();
		Tab tab1 = new Tab("Taxi Companies Table view");
		Tab tab2 = new Tab("Fuel Companies Table view");

		tabpane.getTabs().addAll(tab1, tab2);

		// tableView(stage, tab1);
		// FC_tableView(stage);
		// CD_tableView(stage, tab1);
		// FCOUP_tableView(stage,tab1);
		// FCARD_tableView(stage,tab1);
		// CWC_tableView(stage,tab1);
		displayIntroImage(stage);
		stage.show();

	}

	@SuppressWarnings("unchecked")
	public Pane Taxicompanytable(Stage stage) {
		data = new ArrayList<>();

		try {

			getData();

			dataList = FXCollections.observableArrayList(data);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return tableView(stage);

	}

	private Pane tableView(Stage stage) {
		Pane p = new Pane();

		// tableveiw=======================================================================

		TableView<TaxiComapnies> tableVeiw = new TableView<TaxiComapnies>();
		tableVeiw.setMinWidth(725);

		TableColumn<TaxiComapnies, Integer> column1 = new TableColumn<TaxiComapnies, Integer>("companyNumber");
		column1.setCellValueFactory(new PropertyValueFactory<TaxiComapnies, Integer>("companyNumber"));

		TableColumn<TaxiComapnies, String> column2 = new TableColumn<TaxiComapnies, String>("CompanyName");
		column2.setCellValueFactory(new PropertyValueFactory<TaxiComapnies, String>("CompanyName"));

		TableColumn<TaxiComapnies, String> column3 = new TableColumn<TaxiComapnies, String>("Location");
		column3.setCellValueFactory(new PropertyValueFactory<TaxiComapnies, String>("Location"));

		TableColumn<TaxiComapnies, String> column4 = new TableColumn<TaxiComapnies, String>("ContactPerson");
		column4.setCellValueFactory(new PropertyValueFactory<TaxiComapnies, String>("ContactPerson"));

		TableColumn<TaxiComapnies, String> column5 = new TableColumn<TaxiComapnies, String>("Email");
		column5.setCellValueFactory(new PropertyValueFactory<TaxiComapnies, String>("Email"));

		TableColumn<TaxiComapnies, String> column6 = new TableColumn<TaxiComapnies, String>("PhoneNumber");
		column6.setCellValueFactory(new PropertyValueFactory<TaxiComapnies, String>("PhoneNumber"));

		TableColumn<TaxiComapnies, LocalDate> column7 = new TableColumn<TaxiComapnies, LocalDate>("EntryDate");
		column7.setCellValueFactory(new PropertyValueFactory<TaxiComapnies, LocalDate>("EntryDate"));

		tableVeiw.getStyleClass().add("column-header-background");
		tableVeiw.getStyleClass().add("table-view");

		// panes===========================================================================================
		VBox vbtittle = new VBox(5);
		final VBox vbox = new VBox();
		HBox hb1 = new HBox(10);

		// labeles==============================================================================================
		Label lbTittle = new Label("Taxi Companies TableVeiw");

		lbTittle.setFont(fbold);
		lbTittle.setStyle("-fx-text-fill: #2d5d7a;");

		Scene scene = new Scene(new Group());

		// Set the linear gradient as the fill for the scene
		scene.setFill(gradient);

		stage.setTitle("Taxi Companies Table");
		stage.setWidth(1200);
		stage.setHeight(700);

		tableVeiw.setEditable(true);
		tableVeiw.setMaxHeight(500);
		tableVeiw.setMaxWidth(600);

		Button btadd = new Button("Add");
		Button btdelete = new Button("Delete");
		Button btclear = new Button("Clear All");
		Button btrefresh = new Button("Refresh");
		btadd.setFont(normal);
		btdelete.setFont(normal);
		btclear.setFont(normal);
		btrefresh.setFont(normal);

		tableVeiw.setItems(dataList);

		tableVeiw.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7);

		// pane=========================================================
		GridPane gridpane = new GridPane();

		// labels============================================================
		Label lb1 = new Label("companyNumber");
		Label lb2 = new Label("CompanyName");
		Label lb3 = new Label("Location");
		Label lb4 = new Label("ContactPerson");
		Label lb5 = new Label("Email");
		Label lb6 = new Label("PhoneNumber");
		Label lb7 = new Label("EntryDate");

		lb1.setTextFill(Color.web("#dadede"));
		lb2.setTextFill(Color.web("#dadede"));
		lb3.setTextFill(Color.web("#dadede"));
		lb4.setTextFill(Color.web("#dadede"));
		lb5.setTextFill(Color.web("#dadede"));
		lb6.setTextFill(Color.web("#dadede"));
		lb7.setTextFill(Color.web("#dadede"));

		lb1.setFont(normal);
		lb2.setFont(normal);
		lb3.setFont(normal);
		lb4.setFont(normal);
		lb5.setFont(normal);
		lb6.setFont(normal);
		lb7.setFont(normal);

		// textfeild====================================================
		TextField tfcompanynum = new TextField();
		TextField tfCompanyName = new TextField();
		TextField tfLocation = new TextField();
		TextField tfContactPerson = new TextField();

		TextField tfEmail = new TextField();
		TextField tfhoneNumber = new TextField();

		// datepicker==============================================
		DatePicker dentrydate = new DatePicker();

		gridpane.addRow(0, lb1, tfcompanynum);
		gridpane.addRow(1, lb2, tfCompanyName);
		gridpane.addRow(2, lb3, tfLocation);
		gridpane.addRow(3, lb4, tfContactPerson);
		gridpane.addRow(4, lb5, tfEmail);
		gridpane.addRow(5, lb6, tfhoneNumber);
		gridpane.addRow(6, lb7, dentrydate);

		gridpane.setPadding(new Insets(10, 10, 10, 10));
		gridpane.setHgap(10);
		gridpane.setVgap(10);

		// button
		// handler=======================================================================================================
		btadd.setOnAction(e -> {
			TaxiComapnies tc = new TaxiComapnies(Integer.valueOf(tfcompanynum.getText()), tfCompanyName.getText(),
					tfLocation.getText(), tfContactPerson.getText(), tfEmail.getText(), tfhoneNumber.getText(),
					dentrydate.getValue());
			if (insertData(tc) != null) {
				dataList.add(tc);
			}

		});

		btdelete.setOnAction(e -> {
			ObservableList<TaxiComapnies> selectedRows = tableVeiw.getSelectionModel().getSelectedItems();
			ArrayList<TaxiComapnies> rows = new ArrayList<>(selectedRows);
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

		// update info in taxicompany
		// table==================================================

		column3.setCellFactory(TextFieldTableCell.forTableColumn());
		column3.setOnEditCommit((TableColumn.CellEditEvent<TaxiComapnies, String> t) -> {
			t.getTableView().getItems().get(t.getTablePosition().getRow()).setLocation(t.getNewValue());
			updateLocation(t.getRowValue().getCompanyNumber(), t.getRowValue().getLocation());
		});
		column4.setCellFactory(TextFieldTableCell.forTableColumn());
		column4.setOnEditCommit((TableColumn.CellEditEvent<TaxiComapnies, String> t) -> {
			t.getTableView().getItems().get(t.getTablePosition().getRow()).setContactPerson(t.getNewValue());
			updateContactPerson(t.getRowValue().getCompanyNumber(), t.getRowValue().getContactPerson());
		});
		column5.setCellFactory(TextFieldTableCell.forTableColumn());
		column5.setOnEditCommit((TableColumn.CellEditEvent<TaxiComapnies, String> t) -> {
			t.getTableView().getItems().get(t.getTablePosition().getRow()).setEmail(t.getNewValue());
			updateEmail(t.getRowValue().getCompanyNumber(), t.getRowValue().getEmail());
		});
		column6.setCellFactory(TextFieldTableCell.forTableColumn());
		column6.setOnEditCommit((TableColumn.CellEditEvent<TaxiComapnies, String> t) -> {
			t.getTableView().getItems().get(t.getTablePosition().getRow()).setPhoneNumber(t.getNewValue());
			updatePhoneNumber(t.getRowValue().getCompanyNumber(), t.getRowValue().getPhoneNumber());

		});

		// =====================================================================================
		HBox hb = new HBox(10);
		hb.setPadding(new Insets(10, 10, 10, 10));
		hb.getChildren().addAll(btadd, btdelete, btrefresh, btclear);
		hb.setAlignment(Pos.CENTER);

		vbox.setSpacing(40);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		hb1.setPadding(new Insets(10, 10, 10, 10));

		vbtittle.getChildren().addAll(lbTittle);
		vbtittle.setAlignment(Pos.CENTER);
		vbox.setAlignment(Pos.CENTER);
		hb1.getChildren().addAll(tableVeiw, gridpane);
		vbox.getChildren().addAll(vbtittle, hb1, hb);

		scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm()); // Add CSS file

		gridpane.setStyle(" -fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5);\r\n"
				+ "    -fx-border-width: 3px;\r\n" + "    -fx-border-radius: 5px;");
		tableVeiw.setStyle("-fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5); "
				+ "-fx-border-width: 3px; " + "-fx-border-radius: 5px; "
				+ "-fx-background-color: linear-gradient(to bottom, #cfeccb, #81dbf5);");

		// ((Group) scene.getRoot()).getChildren().addAll(vbox);
		// stage.setScene(scene);
		p.getChildren().add(vbox);
		return p;
	}

	// =====================================================================================

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

//	public void ExecuteStatement(String SQL) throws SQLException {
//
//		try {
//			Statement stmt = con.createStatement();
//			stmt.executeUpdate(SQL);
//			stmt.close();
//
//		} catch (SQLException s) {
//			s.printStackTrace();
//			System.out.println("SQL statement is not executed!");
//
//		}
//
//	}
	String string = "done";

	public void ExecuteStatement(String SQL) {

		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(SQL);
			stmt.close();
			string = "done";
		} catch (SQLException e) {
			e.printStackTrace();
			showAlert(Alert.AlertType.WARNING, "Error", "Failed to execute SQL statement", e.getMessage());
			string = null;
		}
	}

	private void showAlert(Alert.AlertType alertType, String title, String headerText, String contentText) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);
		alert.showAndWait();
	}

	public void updateContactPerson(int companyNumber, String ContactPerson) {

		try {
			System.out.println("update  TaxiCompanies set ContactPerson = '" + ContactPerson
					+ "' where companyNumber = " + companyNumber);
			connectDB();
			ExecuteStatement("update  TaxiCompanies set  ContactPerson = '" + ContactPerson + "' where companyNumber = "
					+ companyNumber + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updateEmail(int companyNumber, String Email) {

		try {
			System.out.println(
					"update  TaxiCompanies set Email = '" + Email + "' where companyNumber = " + companyNumber);
			connectDB();
			ExecuteStatement(
					"update  TaxiCompanies set  Email = '" + Email + "' where companyNumber = " + companyNumber + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updatePhoneNumber(int companyNumber, String PhoneNumber) {

		try {
			System.out.println("update  TaxiCompanies set PhoneNumber = '" + PhoneNumber + "' where companyNumber = "
					+ companyNumber);
			connectDB();
			ExecuteStatement("update  TaxiCompanies set  PhoneNumber = '" + PhoneNumber + "' where companyNumber = "
					+ companyNumber + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updateLocation(int companyNumber, String Location) {

		try {
			System.out.println(
					"update  TaxiCompanies set  Location = '" + Location + "' where CompanyNumber = " + companyNumber);
			connectDB();
			ExecuteStatement("update  TaxiCompanies set  Location = '" + Location + "' where CompanyNumber = "
					+ companyNumber + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String insertData(TaxiComapnies tc) {

		try {

			System.out.println("INSERT INTO TaxiCompanies VALUES (" + tc.getCompanyNumber() + ",'" + tc.getCompanyName()
					+ "','" + tc.getLocation() + "','" + tc.getContactPerson() + "', '" + tc.getEmail() + "','"
					+ tc.getPhoneNumber() + "','" + tc.getEntryDate() + "');");

			connectDB();

			ExecuteStatement("INSERT INTO TaxiCompanies VALUES (" + tc.getCompanyNumber() + ",'" + tc.getCompanyName()
					+ "','" + tc.getLocation() + "','" + tc.getContactPerson() + "', '" + tc.getEmail() + "','"
					+ tc.getPhoneNumber() + "','" + tc.getEntryDate() + "');");

			con.close();
			System.out.println("Connection closed" + data.size());

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return string;
	}

	private void getData() throws SQLException, ClassNotFoundException {

		String SQL;

		connectDB();
		System.out.println("Connection established");

		SQL = "select * from TaxiCompanies ";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);

		while (rs.next()) {

			data.add(new TaxiComapnies(rs.getInt("companyNumber"), rs.getString("CompanyName"),
					rs.getString("Location"), rs.getString("ContactPerson"), rs.getString("Email"),
					rs.getString("PhoneNumber"), rs.getDate("EntryDate").toLocalDate()));

		}

		rs.close();
		stmt.close();

		con.close();
		System.out.println("Connection closed" + data.size());

	}

	public void deleteRow(TaxiComapnies tc) {
		try {
			System.out.println("delete from TaxiCompanies where CompanyNumber=" + tc.getCompanyNumber() + ";");
			connectDB();
			ExecuteStatement("delete from TaxiCompanies where CompanyNumber=" + tc.getCompanyNumber() + ";");
			con.close();
			System.out.println("Connection closed");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void showDialog(Window owner, Modality modality, TableView<TaxiComapnies> table) {
		Stage stage = new Stage();
		stage.initOwner(owner);
		stage.initModality(modality);
		Button yesButton = new Button("Confirm");
		yesButton.setOnAction(e -> {
			for (TaxiComapnies row : dataList) {
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

// ============================fuel company table===================================
	public Pane fuelcompanytable(Stage stage) {
		FC_data = new ArrayList<>();

		try {

			getData_FC();

			FC_dataList = FXCollections.observableArrayList(FC_data);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return FC_tableView(stage);

	}

	// tableveiw=======================================================================
	private Pane FC_tableView(Stage stage) {
		TableView<FuelCompany> tbv_fuelCompany = new TableView<FuelCompany>();

		Pane p = new Pane();

		tbv_fuelCompany.setMinWidth(725);

		TableColumn<FuelCompany, Integer> cFC1 = new TableColumn<FuelCompany, Integer>("companyNumber");
		cFC1.setCellValueFactory(new PropertyValueFactory<FuelCompany, Integer>("companyNumber"));

		TableColumn<FuelCompany, String> cFC2 = new TableColumn<FuelCompany, String>("CompanyName");
		cFC2.setCellValueFactory(new PropertyValueFactory<FuelCompany, String>("CompanyName"));

		TableColumn<FuelCompany, String> cFC3 = new TableColumn<FuelCompany, String>("Email");
		cFC3.setCellValueFactory(new PropertyValueFactory<FuelCompany, String>("Email"));

		TableColumn<FuelCompany, String> cFC4 = new TableColumn<FuelCompany, String>("ContactPerson");
		cFC4.setCellValueFactory(new PropertyValueFactory<FuelCompany, String>("ContactPerson"));

		TableColumn<FuelCompany, String> cFC5 = new TableColumn<FuelCompany, String>("PhoneNumber");
		cFC5.setCellValueFactory(new PropertyValueFactory<FuelCompany, String>("PhoneNumber"));

		TableColumn<FuelCompany, String> cFC6 = new TableColumn<FuelCompany, String>("Location");
		cFC6.setCellValueFactory(new PropertyValueFactory<FuelCompany, String>("Location"));

		TableColumn<FuelCompany, String> cFC7 = new TableColumn<FuelCompany, String>("PayMethod");
		cFC7.setCellValueFactory(new PropertyValueFactory<FuelCompany, String>("PayMethod"));

		TableColumn<FuelCompany, LocalDate> cFC8 = new TableColumn<FuelCompany, LocalDate>("EntryDate");
		cFC8.setCellValueFactory(new PropertyValueFactory<FuelCompany, LocalDate>("EntryDate"));

		tbv_fuelCompany.setEditable(true);

		tbv_fuelCompany.getStyleClass().add("column-header-background");
		tbv_fuelCompany.getStyleClass().add("table-view");

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
		scene.setFill(Color.web("#123a4e"));

		stage.setTitle("Cars Table");
		stage.setWidth(1400);
		stage.setHeight(900);

		tbv_fuelCompany.setEditable(true);
		tbv_fuelCompany.setMaxHeight(500);
		tbv_fuelCompany.setMaxWidth(700);

		Font normal = Font.font("Arial Narrow", FontWeight.BOLD, FontPosture.REGULAR, 15);

		Button btadd = new Button("Add");
		Button btdelete = new Button("Delete");
		Button btclear = new Button("Clear All");
		Button btrefresh = new Button("Refresh");
		btadd.setFont(normal);
		btdelete.setFont(normal);
		btclear.setFont(normal);
		btrefresh.setFont(normal);

		tbv_fuelCompany.setItems(FC_dataList);

//			tbv_fuelCompany.getColumns().addAll(cFC1, cFC2, cFC3, cFC4, cFC5, cFC6, cFC7);

		// labels============================================================
		Label lbFC1 = new Label("companyNumber");
		Label lbFC2 = new Label("CompanyName");
		Label lbFC3 = new Label("Location");
		Label lbFC4 = new Label("ContactPerson");
		Label lbFC5 = new Label("Email");
		Label lbFC6 = new Label("PhoneNumber");
		Label lbFC7 = new Label("PayMethod");
		Label lbFC8 = new Label("EntryDate");

		lbFC1.setTextFill(Color.web("#dadede"));
		lbFC2.setTextFill(Color.web("#dadede"));
		lbFC3.setTextFill(Color.web("#dadede"));
		lbFC4.setTextFill(Color.web("#dadede"));
		lbFC5.setTextFill(Color.web("#dadede"));
		lbFC6.setTextFill(Color.web("#dadede"));
		lbFC7.setTextFill(Color.web("#dadede"));
		lbFC8.setTextFill(Color.web("#dadede"));

		lbFC1.setFont(normal);
		lbFC2.setFont(normal);
		lbFC3.setFont(normal);
		lbFC4.setFont(normal);
		lbFC5.setFont(normal);
		lbFC6.setFont(normal);
		lbFC7.setFont(normal);

		// textfeild====================================================
		TextField tf_FC_companynum = new TextField();
		TextField tf_FC_CompanyName = new TextField();
		TextField tf_FC_Location = new TextField();
		TextField tf_FC_ContactPerson = new TextField();
		TextField tf_FC_PayMethod = new TextField();
		TextField tf_FC_Email = new TextField();
		TextField tf_FC_PhoneNumber = new TextField();

		// labeles==============================================================================================
		Label lb_FC_Tittle = new Label("Fuel Companies TableVeiw");

		lb_FC_Tittle.setFont(fbold);
		lb_FC_Tittle.setStyle("-fx-text-fill: #2d5d7a;");

		stage.setTitle("Fuel Companies TableVeiw");
		stage.setWidth(1200);
		stage.setHeight(700);

		tbv_fuelCompany.setEditable(true);
		tbv_fuelCompany.setMaxHeight(500);
		tbv_fuelCompany.setMaxWidth(600);

		Button bt_FC_add = new Button("Add");
		Button bt_FC_delete = new Button("Delete");
		bt_FC_add.setFont(normal);
		bt_FC_delete.setFont(normal);

		tbv_fuelCompany.setItems(FC_dataList);

		tbv_fuelCompany.getColumns().addAll(cFC1, cFC2, cFC3, cFC4, cFC5, cFC6, cFC7, cFC8);

		// pane=========================================================
		GridPane gp_FC = new GridPane();

		// datepicker_FC==============================================
		DatePicker dentrydate_FC = new DatePicker();

		gp_FC.addRow(0, lbFC1, tf_FC_companynum);
		gp_FC.addRow(1, lbFC2, tf_FC_CompanyName);
		gp_FC.addRow(2, lbFC3, tf_FC_Location);
		gp_FC.addRow(3, lbFC4, tf_FC_ContactPerson);
		gp_FC.addRow(4, lbFC5, tf_FC_Email);
		gp_FC.addRow(5, lbFC6, tf_FC_PhoneNumber);
		gp_FC.addRow(6, lbFC7, tf_FC_PayMethod);
		gp_FC.addRow(7, lbFC8, dentrydate_FC);

		gp_FC.setPadding(new Insets(10, 10, 10, 10));
		gp_FC.setHgap(10);
		gp_FC.setVgap(10);
		gp_FC.setStyle(" -fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5);\r\n"
				+ "    -fx-border-width: 3px;\r\n" + "    -fx-border-radius: 5px;");

		// =====================================================================================
		HBox hb = new HBox(10);
		hb.setPadding(new Insets(10, 10, 10, 10));
//			hb.getChildren().addAll(btadd, btdelete, btrefresh, btclear);
		hb.setAlignment(Pos.CENTER);

		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		hb1.setPadding(new Insets(10, 10, 10, 10));

//			vbtittle.getChildren().addAll(lbTittle);
//			vbtittle.setAlignment(Pos.CENTER);
//			vbox.setAlignment(Pos.CENTER);
//			hb1.getChildren().addAll(tbv_fuelCompany, gp_FC);
//			hb1.getChildren().toString();
//			hb1.setAlignment(Pos.CENTER);
//			vbox.getChildren().addAll(vbtittle, hb1, hb);
//			

		// handler=======================================================================================================
//			FuelCompany(Integer companyNumber ,String CompanyName, String Email,String ContactPerson,String PhoneNumber,String Location,String PayMethod,LocalDate EntryDate)
		bt_FC_add.setOnAction(e -> {

			FuelCompany fc = new FuelCompany(Integer.valueOf(tf_FC_companynum.getText()), tf_FC_CompanyName.getText(),
					tf_FC_Email.getText(), tf_FC_ContactPerson.getText(), tf_FC_PhoneNumber.getText(),
					tf_FC_Location.getText(), tf_FC_PayMethod.getText(), dentrydate_FC.getValue());
			insertData_FC(fc);
			if (string != null) {
				FC_dataList.add(fc);
			}

		});

		bt_FC_delete.setOnAction(e -> {
			ObservableList<FuelCompany> selectedRows = tbv_fuelCompany.getSelectionModel().getSelectedItems();
			ArrayList<FuelCompany> rows = new ArrayList<>(selectedRows);
			rows.forEach(row -> {
				tbv_fuelCompany.getItems().remove(row);
				deleteRow_FC(row);
				tbv_fuelCompany.refresh();
			});

		});

		// update info in fuel company
		// table==================================================

		cFC3.setCellFactory(TextFieldTableCell.forTableColumn());
		cFC3.setOnEditCommit((TableColumn.CellEditEvent<FuelCompany, String> t) -> {

			updateEmail_FC(t.getRowValue().getCompanyNumber(), t.getRowValue().getEmail());
			if (string != null) {
				t.getTableView().getItems().get(t.getTablePosition().getRow()).setEmail(t.getNewValue());
			}

		});
		cFC4.setCellFactory(TextFieldTableCell.forTableColumn());
		cFC4.setOnEditCommit((TableColumn.CellEditEvent<FuelCompany, String> t) -> {

			updateContactPerson_FC(t.getRowValue().getCompanyNumber(), t.getRowValue().getContactPerson());
			if (string != null) {
				t.getTableView().getItems().get(t.getTablePosition().getRow()).setContactPerson(t.getNewValue());
			}
		});
		cFC5.setCellFactory(TextFieldTableCell.forTableColumn());
		cFC5.setOnEditCommit((TableColumn.CellEditEvent<FuelCompany, String> t) -> {

			updatePhoneNumber_FC(t.getRowValue().getCompanyNumber(), t.getRowValue().getPhoneNumber());
			if (string != null) {
				t.getTableView().getItems().get(t.getTablePosition().getRow()).setEmail(t.getNewValue());
			}

		});
		cFC7.setCellFactory(TextFieldTableCell.forTableColumn());
		cFC7.setOnEditCommit((TableColumn.CellEditEvent<FuelCompany, String> t) -> {

			updatePayMethod_FC(t.getRowValue().getCompanyNumber(), t.getRowValue().getPayMethod());
			if (string != null) {
				t.getTableView().getItems().get(t.getTablePosition().getRow()).setPayMethod(t.getNewValue());
			}

		});

		// =====================================================================================

		hb.setPadding(new Insets(10, 10, 10, 10));
		hb.getChildren().addAll(bt_FC_add, bt_FC_delete, btrefresh, btclear);
		hb.setAlignment(Pos.CENTER);

		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		hb1.setPadding(new Insets(10, 10, 10, 10));

		vbtittle.getChildren().addAll(lb_FC_Tittle);
		vbtittle.setAlignment(Pos.CENTER);
		vbox.setAlignment(Pos.CENTER);
		hb1.getChildren().addAll(tbv_fuelCompany, gp_FC);
		hb1.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(vbtittle, hb1, hb);

		gp_FC.setStyle(" -fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5);\r\n"
				+ "    -fx-border-width: 3px;\r\n" + "    -fx-border-radius: 5px;");
		tbv_fuelCompany.setStyle("-fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5); "
				+ "-fx-border-width: 3px; " + "-fx-border-radius: 5px; "
				+ "-fx-background-color: linear-gradient(to bottom, #cfeccb, #81dbf5);");

		// ((Group) scene.getRoot()).getChildren().addAll(vbox);
		// stage.setScene(scene);
		p.getChildren().add(vbox);
		return p;

	}

//============================ fuel company methods=============================================		
	public String insertData_FC(FuelCompany fc) {
		String string = "";

		try {
			System.out.println("INSERT INTO FuelCompany VALUES (" + fc.getCompanyNumber() + ",'" + fc.getCompanyName()
					+ "','" + fc.getEmail() + "','" + fc.getContactPerson() + "', '" + fc.getPhoneNumber() + "','"
					+ fc.getLocation() + "','" + fc.getPayMethod() + "','" + fc.getEntryDate() + "');");

			connectDB();

			ExecuteStatement("INSERT INTO FuelCompany VALUES (" + fc.getCompanyNumber() + ",'" + fc.getCompanyName()
					+ "','" + fc.getEmail() + "','" + fc.getContactPerson() + "', '" + fc.getPhoneNumber() + "','"
					+ fc.getLocation() + "','" + fc.getPayMethod() + "','" + fc.getEntryDate() + "');");

			con.close();
			System.out.println("Connection closed" + FC_data.size());

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void getData_FC() throws SQLException, ClassNotFoundException {

		String SQL;

		connectDB();
		System.out.println("Connection established");

		SQL = "select * from FuelCompany ";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);

		while (rs.next()) {

			FC_data.add(new FuelCompany(rs.getInt("companyNumber"), rs.getString("CompanyName"), rs.getString("Email"),
					rs.getString("ContactPersonName"), rs.getString("ContactPersonPhoneNumber"),
					rs.getString("Location"), rs.getString("PayMethod"), rs.getDate("EntryDate").toLocalDate()));

		}

		rs.close();
		stmt.close();

		con.close();
		System.out.println("Connection closed" + FC_data.size());
	}

	public void deleteRow_FC(FuelCompany fc) {
		try {
			System.out.println("delete from FuelCompany where CompanyNumber=" + fc.getCompanyNumber() + ";");
			connectDB();
			ExecuteStatement("delete from FuelCompany where CompanyNumber=" + fc.getCompanyNumber() + ";");
			con.close();
			System.out.println("Connection closed");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void showDialog_FC(Window owner, Modality modality, TableView<FuelCompany> table) {
		Stage stage = new Stage();
		stage.initOwner(owner);
		stage.initModality(modality);
		Button yesButton = new Button("Confirm");
		yesButton.setOnAction(e -> {
			for (FuelCompany row : FC_dataList) {
				deleteRow_FC(row);
				table.refresh();
			}
			table.getItems().removeAll(FC_dataList);
			stage.close();

		});
	}

	public void updateContactPerson_FC(int companyNumber, String ContactPerson) {

		try {
			System.out.println("update  FuelCompany set ContactPerson = '" + ContactPerson + "' where companyNumber = "
					+ companyNumber);
			connectDB();
			ExecuteStatement("update  FuelCompany set  ContactPersonName = '" + ContactPerson
					+ "' where companyNumber = " + companyNumber + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updateEmail_FC(int companyNumber, String Email) {

		try {
			System.out
					.println("update  FuelCompany set Email = '" + Email + "' where companyNumber = " + companyNumber);
			connectDB();
			ExecuteStatement(
					"update  FuelCompany set  Email = '" + Email + "' where companyNumber = " + companyNumber + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updatePhoneNumber_FC(int companyNumber, String PhoneNumber) {

		try {
			System.out.println("update  FuelCompany set ContactPersonPhoneNumber = '" + PhoneNumber
					+ "' where companyNumber = " + companyNumber);
			connectDB();
			ExecuteStatement("update  FuelCompany set  ContactPersonPhoneNumber = '" + PhoneNumber
					+ "' where companyNumber = " + companyNumber + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updatePayMethod_FC(int companyNumber, String paymethod) {

		try {
			System.out.println(
					"update  FuelCompany set  PayMethod = '" + paymethod + "' where CompanyNumber = " + companyNumber);
			connectDB();
			ExecuteStatement("update  FuelCompany set  PayMethod = '" + paymethod + "' where CompanyNumber = "
					+ companyNumber + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

// ============================CarDistribution table===================================
//		private Integer CarNumber;	
//		private String Location;
//		private String CarParkingLocation;	
//		private String FleetOfficer;
//		private Integer OdometerOnDropOff;
//		private LocalDate EntryDate;
	// ============================CarDistribution
	// table===================================
	public Pane CarDistributiontable(Stage stage) {
		CD_data = new ArrayList<>();

		try {

			getData_CD();

			CD_dataList = FXCollections.observableArrayList(CD_data);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return CD_tableView(stage);

	}

// tableveiw=======================================================================
	private Pane CD_tableView(Stage stage) {
		Pane p = new Pane();
		TableView<CarDistribution> tbv_CarDistribution = new TableView<CarDistribution>();
		tbv_CarDistribution.setMinWidth(725);

		TableColumn<CarDistribution, Integer> cCD1 = new TableColumn<CarDistribution, Integer>("CarNumber");
		cCD1.setCellValueFactory(new PropertyValueFactory<CarDistribution, Integer>("CarNumber"));

		TableColumn<CarDistribution, String> cCD2 = new TableColumn<CarDistribution, String>("Location");
		cCD2.setCellValueFactory(new PropertyValueFactory<CarDistribution, String>("Location"));

		TableColumn<CarDistribution, String> cCD3 = new TableColumn<CarDistribution, String>("CarParkingLocation");
		cCD3.setCellValueFactory(new PropertyValueFactory<CarDistribution, String>("CarParkingLocation"));

		TableColumn<CarDistribution, String> cCD4 = new TableColumn<CarDistribution, String>("FleetOfficer");
		cCD4.setCellValueFactory(new PropertyValueFactory<CarDistribution, String>("FleetOfficer"));

		TableColumn<CarDistribution, Integer> cCD5 = new TableColumn<CarDistribution, Integer>("OdometerOnDropOff");
		cCD5.setCellValueFactory(new PropertyValueFactory<CarDistribution, Integer>("OdometerOnDropOff"));

		TableColumn<CarDistribution, LocalDate> cCD6 = new TableColumn<CarDistribution, LocalDate>("EntryDate");
		cCD6.setCellValueFactory(new PropertyValueFactory<CarDistribution, LocalDate>("EntryDate"));

		tbv_CarDistribution.setEditable(true);

		tbv_CarDistribution.getStyleClass().add("column-header-background");
		tbv_CarDistribution.getStyleClass().add("table-view");

		// labels============================================================
		Label lbCD1 = new Label("CarNumber");
		Label lbCD2 = new Label("Location");
		Label lbCD3 = new Label("CarParkingLocation");
		Label lbCD4 = new Label("FleetOfficer");
		Label lbCD5 = new Label("OdometerOnDropOff");
		Label lbCD6 = new Label("EntryDate");

		lbCD1.setTextFill(Color.web("#dadede"));
		lbCD2.setTextFill(Color.web("#dadede"));
		lbCD3.setTextFill(Color.web("#dadede"));
		lbCD4.setTextFill(Color.web("#dadede"));
		lbCD5.setTextFill(Color.web("#dadede"));
		lbCD6.setTextFill(Color.web("#dadede"));

		lbCD1.setFont(normal);
		lbCD2.setFont(normal);
		lbCD3.setFont(normal);
		lbCD4.setFont(normal);
		lbCD5.setFont(normal);
		lbCD6.setFont(normal);

		// textfeild====================================================
		TextField tf_CD_CarNumber = new TextField();
		TextField tf_CD_Location = new TextField();
		TextField tf_CD_CarParkingLocation = new TextField();
		TextField tf_CD_FleetOfficer = new TextField();
		TextField tf_CD_OdometerOnDropOff = new TextField();

		// labeles==============================================================================================
		Label lb_CD_Tittle = new Label("Car Distribution TableVeiw");

		lb_CD_Tittle.setFont(fbold);
		lb_CD_Tittle.setStyle("-fx-text-fill: #2d5d7a;");

		Scene scene3 = new Scene(new Group());
		// Set the linear gradient as the fill for the scene
		scene3.setFill(gradient);

		stage.setTitle("Fuel Companies TableVeiw");
		stage.setWidth(1200);
		stage.setHeight(700);

		tbv_CarDistribution.setEditable(true);
		tbv_CarDistribution.setMaxHeight(500);
		tbv_CarDistribution.setMaxWidth(600);

		Button bt_CD_add = new Button("Add");
		Button bt_CD_delete = new Button("Delete");
		bt_CD_add.setFont(normal);
		bt_CD_delete.setFont(normal);

		tbv_CarDistribution.setItems(CD_dataList);
		tbv_CarDistribution.getColumns().addAll(cCD1, cCD2, cCD3, cCD4, cCD5, cCD6);

		// pane=========================================================
		GridPane gp_CD = new GridPane();

		// datepicker_FC==============================================
		DatePicker dentrydate_CD = new DatePicker();

		gp_CD.addRow(0, lbCD1, tf_CD_CarNumber);
		gp_CD.addRow(1, lbCD2, tf_CD_Location);
		gp_CD.addRow(2, lbCD3, tf_CD_CarParkingLocation);
		gp_CD.addRow(3, lbCD4, tf_CD_FleetOfficer);
		gp_CD.addRow(4, lbCD5, tf_CD_OdometerOnDropOff);
		gp_CD.addRow(5, lbCD6, dentrydate_CD);

		gp_CD.setPadding(new Insets(10, 10, 10, 10));
		gp_CD.setHgap(10);
		gp_CD.setVgap(10);

		final VBox vbox_CD = new VBox();
		HBox hb1_CD = new HBox(10);

		// =====================================================================================
		HBox hb_CD = new HBox(10);
		hb_CD.setPadding(new Insets(10, 10, 10, 10));
		hb_CD.getChildren().addAll(bt_CD_add, bt_CD_delete);
		hb_CD.setAlignment(Pos.CENTER);

		vbox_CD.setSpacing(40);
		vbox_CD.setPadding(new Insets(10, 0, 0, 10));
		hb_CD.setPadding(new Insets(10, 10, 10, 10));

		vbox_CD.setAlignment(Pos.CENTER);
		hb1_CD.getChildren().addAll(tbv_CarDistribution, gp_CD);
		vbox_CD.getChildren().addAll(lb_CD_Tittle, hb1_CD, hb_CD);

		scene3.getStylesheets().add(getClass().getResource("styles.css").toExternalForm()); // Add CSS file

		// handler=======================================================================================================
//				public CarDistribution(Integer carNumber, String location, String carParkingLocation, String fleetOfficer,Integer odometerOnDropOff, LocalDate entryDate) {
		bt_CD_add.setOnAction(e -> {
			CarDistribution cd = new CarDistribution(Integer.valueOf(tf_CD_CarNumber.getText()),
					tf_CD_Location.getText(), tf_CD_CarParkingLocation.getText(), tf_CD_FleetOfficer.getText(),
					Integer.valueOf(tf_CD_OdometerOnDropOff.getText()), dentrydate_CD.getValue());

			insertData_CD(cd);
			if (string != null) {
				CD_dataList.add(cd);
			}

		});

		bt_CD_delete.setOnAction(e -> {
			ObservableList<CarDistribution> selectedRows = tbv_CarDistribution.getSelectionModel().getSelectedItems();
			ArrayList<CarDistribution> rows = new ArrayList<>(selectedRows);
			rows.forEach(row -> {
				tbv_CarDistribution.getItems().remove(row);
				deleteRow_CD(row);
				tbv_CarDistribution.refresh();
			});

		});

		// update info in fuel company
		// table==================================================

		cCD2.setCellFactory(TextFieldTableCell.forTableColumn());
		cCD2.setOnEditCommit((TableColumn.CellEditEvent<CarDistribution, String> t) -> {

			updateLocation_CD(t.getRowValue().getCarNumber(), t.getRowValue().getLocation());
			if (string != null) {
				t.getTableView().getItems().get(t.getTablePosition().getRow()).setLocation(t.getNewValue());
			}
		});
		cCD3.setCellFactory(TextFieldTableCell.forTableColumn());
		cCD3.setOnEditCommit((TableColumn.CellEditEvent<CarDistribution, String> t) -> {

			updateCarParkingLocation_CD(t.getRowValue().getCarNumber(), t.getRowValue().getCarParkingLocation());
			if (string != null) {
				t.getTableView().getItems().get(t.getTablePosition().getRow()).setCarParkingLocation(t.getNewValue());
			}
		});
		cCD4.setCellFactory(TextFieldTableCell.forTableColumn());
		cCD4.setOnEditCommit((TableColumn.CellEditEvent<CarDistribution, String> t) -> {

			updateFleetOfficer_CD(t.getRowValue().getCarNumber(), t.getRowValue().getFleetOfficer());
			if (string != null) {
				t.getTableView().getItems().get(t.getTablePosition().getRow()).setFleetOfficer(t.getNewValue());
			}
		});
		Scene scene4 = new Scene(new Group());
		scene4.setFill(gradient);
		tbv_CarDistribution.getStyleClass().add("column-header-background");
		tbv_CarDistribution.getStyleClass().add("table-view");

		gp_CD.setStyle(" -fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5);\r\n"
				+ "    -fx-border-width: 3px;\r\n" + "    -fx-border-radius: 5px;");
		tbv_CarDistribution.setStyle("-fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5); "
				+ "-fx-border-width: 3px; " + "-fx-border-radius: 5px; "
				+ "-fx-background-color: linear-gradient(to bottom, #cfeccb, #81dbf5);");

		p.getChildren().add(vbox_CD);
//				stage.setScene(scene4);
		return p;

	}

//============================ CarDistribution methods=============================================
	public void updateLocation_CD(int CarNumber, String location) {

		try {
			System.out.println(
					"update  CarDistribution set location = '" + location + "' where CarNumber = " + CarNumber);
			connectDB();
			ExecuteStatement(
					"update  CarDistribution set  location = '" + location + "' where CarNumber = " + CarNumber + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

//==============================================================
	public void updateCarParkingLocation_CD(int CarNumber, String CarParkingLocation) {

		try {
			System.out.println("update  CarDistribution set CarParkingLocation = '" + CarParkingLocation
					+ "' where CarNumber = " + CarNumber);
			connectDB();
			ExecuteStatement("update  CarDistribution set  CarParkingLocation = '" + CarParkingLocation
					+ "' where CarNumber = " + CarNumber + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

//==============================================================
	public void updateFleetOfficer_CD(int CarNumber, String FleetOfficer) {

		try {
			System.out.println(
					"update  CarDistribution set FleetOfficer = '" + FleetOfficer + "' where CarNumber = " + CarNumber);
			connectDB();
			ExecuteStatement("update  CarDistribution set  FleetOfficer = '" + FleetOfficer + "' where CarNumber = "
					+ CarNumber + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
//==============================================================		

	public void insertData_CD(CarDistribution cd) {

		try {
			System.out.println("INSERT INTO CarDistribution VALUES (" + cd.getCarNumber() + ",'" + cd.getLocation()
					+ "','" + cd.getCarParkingLocation() + "','" + cd.getFleetOfficer() + "', '"
					+ cd.getOdometerOnDropOff() + "','" + cd.getEntryDate() + "');");

			connectDB();

			ExecuteStatement("INSERT INTO CarDistribution VALUES (" + cd.getCarNumber() + ",'" + cd.getLocation()
					+ "','" + cd.getCarParkingLocation() + "','" + cd.getFleetOfficer() + "', '"
					+ cd.getOdometerOnDropOff() + "','" + cd.getEntryDate() + "');");

			con.close();
			System.out.println("Connection closed" + CD_data.size());

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void getData_CD() throws SQLException, ClassNotFoundException {
		String SQL;
		connectDB();
		System.out.println("Connection established");
		SQL = "select * from CarDistribution ";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);

		while (rs.next()) {

			CD_data.add(new CarDistribution(rs.getInt("CarNumber"), rs.getString("Location"),
					rs.getString("CarParkingLocation"), rs.getString("FleetOfficer"), rs.getInt("OdometerOnDropOff"),
					rs.getDate("EntryDate").toLocalDate()));

		}

		rs.close();
		stmt.close();

		con.close();
		System.out.println("Connection closed" + CD_data.size());
	}

	public void deleteRow_CD(CarDistribution cd) {
		try {
			System.out.println("delete from CarDistribution where CarNumber=" + cd.getCarNumber() + ";");
			connectDB();
			ExecuteStatement("delete from CarDistribution where CarNumber=" + cd.getCarNumber() + ";");
			con.close();
			System.out.println("Connection closed");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

//			private void showDialog_CD(Window owner, Modality modality, TableView<CarDistribution> table) {
//				Stage stage = new Stage();
//				stage.initOwner(owner);
//				stage.initModality(modality);
//				Button yesButton = new Button("Confirm");
//				yesButton.setOnAction(e -> {
//					for (CarDistribution row : CD_dataList) {
//						deleteRow_CD(row);
//						table.refresh();
//					}
//					table.getItems().removeAll(CD_dataList);
//					stage.close();
//
//				});	
//			}

// ============================FuelCoupon table===================================

// tableveiw=======================================================================
	public Pane FuelCoupontable(Stage stage) {
		FCOUP_data = new ArrayList<>();

		try {

			getData_FCOUP();

			FCOUP_dataList = FXCollections.observableArrayList(FCOUP_data);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return FCOUP_tableView(stage);

	}

	private Pane FCOUP_tableView(Stage stage) {
		Pane pane = new Pane();
		TableView<FuelCoupon> tbv_FuelCoupon = new TableView<FuelCoupon>();
		tbv_FuelCoupon.setMinWidth(725);

		TableColumn<FuelCoupon, Integer> cFCOUP1 = new TableColumn<FuelCoupon, Integer>("CouponNumber");
		cFCOUP1.setCellValueFactory(new PropertyValueFactory<FuelCoupon, Integer>("CouponNumber"));

		TableColumn<FuelCoupon, Integer> cFCOUP2 = new TableColumn<FuelCoupon, Integer>("CarNumber");
		cFCOUP2.setCellValueFactory(new PropertyValueFactory<FuelCoupon, Integer>("CarNumber"));

		TableColumn<FuelCoupon, String> cFCOUP3 = new TableColumn<FuelCoupon, String>("DriverName");
		cFCOUP3.setCellValueFactory(new PropertyValueFactory<FuelCoupon, String>("DriverName"));

		TableColumn<FuelCoupon, Integer> cFCOUP4 = new TableColumn<FuelCoupon, Integer>("OdometerOnStarting");
		cFCOUP4.setCellValueFactory(new PropertyValueFactory<FuelCoupon, Integer>("OdometerOnStarting"));

		TableColumn<FuelCoupon, String> cFCOUP5 = new TableColumn<FuelCoupon, String>("DepartmentName");
		cFCOUP5.setCellValueFactory(new PropertyValueFactory<FuelCoupon, String>("DepartmentName"));

		TableColumn<FuelCoupon, Double> cFCOUP6 = new TableColumn<FuelCoupon, Double>("FuelAmount");
		cFCOUP6.setCellValueFactory(new PropertyValueFactory<FuelCoupon, Double>("FuelAmount"));

		TableColumn<FuelCoupon, String> cFCOUP7 = new TableColumn<FuelCoupon, String>("FuelType");
		cFCOUP7.setCellValueFactory(new PropertyValueFactory<FuelCoupon, String>("FuelType"));

		TableColumn<FuelCoupon, Double> cFCOUP8 = new TableColumn<FuelCoupon, Double>("FuelPrice");
		cFCOUP6.setCellValueFactory(new PropertyValueFactory<FuelCoupon, Double>("FuelPrice"));

		TableColumn<FuelCoupon, String> cFCOUP9 = new TableColumn<FuelCoupon, String>("FuelCompanyName");
		cFCOUP7.setCellValueFactory(new PropertyValueFactory<FuelCoupon, String>("FuelCompanyName"));

		TableColumn<FuelCoupon, LocalDate> cFCOUP10 = new TableColumn<FuelCoupon, LocalDate>("EntryDate");
		cFCOUP10.setCellValueFactory(new PropertyValueFactory<FuelCoupon, LocalDate>("EntryDate"));

		tbv_FuelCoupon.setEditable(true);

		tbv_FuelCoupon.getStyleClass().add("column-header-background");
		tbv_FuelCoupon.getStyleClass().add("table-view");

//labels============================================================

		Label lbFCOUP1 = new Label("CarNumber");
		Label lbFCOUP2 = new Label("CarNumber");
		Label lbFCOUP3 = new Label("DriverName");
		Label lbFCOUP4 = new Label("OdometerOnStarting");
		Label lbFCOUP5 = new Label("DepartmentName");
		Label lbFCOUP6 = new Label("FuelAmount");
		Label lbFCOUP7 = new Label("FuelType");
		Label lbFCOUP8 = new Label("FuelPrice");
		Label lbFCOUP9 = new Label("FuelCompanyName");
		Label lbFCOUP10 = new Label("EntryDate");

		lbFCOUP1.setTextFill(Color.web("#dadede"));
		lbFCOUP2.setTextFill(Color.web("#dadede"));
		lbFCOUP3.setTextFill(Color.web("#dadede"));
		lbFCOUP4.setTextFill(Color.web("#dadede"));
		lbFCOUP5.setTextFill(Color.web("#dadede"));
		lbFCOUP6.setTextFill(Color.web("#dadede"));
		lbFCOUP7.setTextFill(Color.web("#dadede"));
		lbFCOUP8.setTextFill(Color.web("#dadede"));
		lbFCOUP9.setTextFill(Color.web("#dadede"));
		lbFCOUP10.setTextFill(Color.web("#dadede"));

		lbFCOUP1.setFont(normal);
		lbFCOUP2.setFont(normal);
		lbFCOUP3.setFont(normal);
		lbFCOUP4.setFont(normal);
		lbFCOUP5.setFont(normal);
		lbFCOUP6.setFont(normal);
		lbFCOUP7.setFont(normal);
		lbFCOUP8.setFont(normal);
		lbFCOUP9.setFont(normal);
		lbFCOUP10.setFont(normal);

		// textfeild====================================================

		TextField tf_FCOUP_CouponNumber = new TextField();
		TextField tf_FCOUP_CarNumber = new TextField();
		TextField tf_FCOUP_DriverName = new TextField();
		TextField tf_FCOUP_OdometerOnStarting = new TextField();
		TextField tf_FCOUP_DepartmentName = new TextField();
		TextField tf_FCOUP_FuelAmount = new TextField();
		TextField tf_FCOUP_FuelType = new TextField();
		TextField tf_FCOUP_FuelPrice = new TextField();
		TextField tf_FCOUP_FuelCompanyName = new TextField();

		// labeles==============================================================================================
		Label lb_FCOUP_Tittle = new Label("Fuel Coupon TableVeiw");

		lb_FCOUP_Tittle.setFont(fbold);
		lb_FCOUP_Tittle.setStyle("-fx-text-fill: #2d5d7a;");

		Scene scene2 = new Scene(new Group());
		// Set the linear gradient as the fill for the scene
		scene2.setFill(gradient);

		stage.setTitle("Fuel Companies TableVeiw");
		stage.setWidth(1200);
		stage.setHeight(700);

		tbv_FuelCoupon.setEditable(true);
		tbv_FuelCoupon.setMaxHeight(500);
		tbv_FuelCoupon.setMaxWidth(600);

		Button bt_FCOUP_add = new Button("Add");
		Button bt_FCOUP_delete = new Button("Delete");
		bt_FCOUP_add.setFont(normal);
		bt_FCOUP_delete.setFont(normal);

		tbv_FuelCoupon.setItems(FCOUP_dataList);

		tbv_FuelCoupon.getColumns().addAll(cFCOUP1, cFCOUP2, cFCOUP3, cFCOUP4, cFCOUP5, cFCOUP6, cFCOUP7, cFCOUP8,
				cFCOUP9, cFCOUP10);
		// pane=========================================================
		GridPane gp_FCOUP = new GridPane();

		// datepicker_FC==============================================
		DatePicker dentrydate_FCOUP = new DatePicker();

		gp_FCOUP.addRow(0, lbFCOUP1, tf_FCOUP_CouponNumber);
		gp_FCOUP.addRow(1, lbFCOUP2, tf_FCOUP_CarNumber);
		gp_FCOUP.addRow(2, lbFCOUP3, tf_FCOUP_DriverName);
		gp_FCOUP.addRow(3, lbFCOUP4, tf_FCOUP_OdometerOnStarting);
		gp_FCOUP.addRow(4, lbFCOUP5, tf_FCOUP_DepartmentName);
		gp_FCOUP.addRow(5, lbFCOUP6, tf_FCOUP_FuelAmount);
		gp_FCOUP.addRow(6, lbFCOUP7, tf_FCOUP_FuelType);
		gp_FCOUP.addRow(7, lbFCOUP8, tf_FCOUP_FuelPrice);
		gp_FCOUP.addRow(8, lbFCOUP9, tf_FCOUP_FuelCompanyName);
		gp_FCOUP.addRow(9, lbFCOUP10, dentrydate_FCOUP);

		gp_FCOUP.setPadding(new Insets(10, 10, 10, 10));
		gp_FCOUP.setHgap(10);
		gp_FCOUP.setVgap(10);

		final VBox vbox_FCOUP = new VBox();
		HBox hb1_FCOUP = new HBox(10);

		// =====================================================================================
		HBox hb_FCOUP = new HBox(10);
		hb_FCOUP.setPadding(new Insets(10, 10, 10, 10));
		hb_FCOUP.getChildren().addAll(bt_FCOUP_add, bt_FCOUP_delete);
		hb_FCOUP.setAlignment(Pos.CENTER);

		vbox_FCOUP.setSpacing(40);
		vbox_FCOUP.setPadding(new Insets(10, 0, 0, 10));
		hb_FCOUP.setPadding(new Insets(10, 10, 10, 10));

		vbox_FCOUP.setAlignment(Pos.CENTER);
		hb1_FCOUP.getChildren().addAll(tbv_FuelCoupon, gp_FCOUP);
		vbox_FCOUP.getChildren().addAll(lb_FCOUP_Tittle, hb1_FCOUP, hb_FCOUP);

		scene2.getStylesheets().add(getClass().getResource("styles.css").toExternalForm()); // Add CSS file
		// handler=======================================================================================================
//				public CarDistribution(Integer carNumber, String location, String carParkingLocation, String fleetOfficer,Integer odometerOnDropOff, LocalDate entryDate) {
		bt_FCOUP_add.setOnAction(e -> {
			FuelCoupon cd = new FuelCoupon(Integer.valueOf(tf_FCOUP_CouponNumber.getText()),
					Integer.valueOf(tf_FCOUP_CarNumber.getText()), tf_FCOUP_DriverName.getText(),
					Integer.valueOf(tf_FCOUP_OdometerOnStarting.getText()), tf_FCOUP_DepartmentName.getText(),
					Double.valueOf(tf_FCOUP_FuelAmount.getText()), tf_FCOUP_FuelType.getText(),
					Double.valueOf(tf_FCOUP_FuelPrice.getText()), tf_FCOUP_FuelCompanyName.getText(),
					dentrydate_FCOUP.getValue());
			insertData_FCOUP(cd);
			if (string != null) {
				FCOUP_dataList.add(cd);
			}

		});

		bt_FCOUP_delete.setOnAction(e -> {
			ObservableList<FuelCoupon> selectedRows = tbv_FuelCoupon.getSelectionModel().getSelectedItems();
			ArrayList<FuelCoupon> rows = new ArrayList<>(selectedRows);
			rows.forEach(row -> {
				tbv_FuelCoupon.getItems().remove(row);
				deleteRow_FCOUP(row);
				tbv_FuelCoupon.refresh();
			});

		});

		gp_FCOUP.setStyle(" -fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5);\r\n"
				+ "    -fx-border-width: 3px;\r\n" + "    -fx-border-radius: 5px;");
		tbv_FuelCoupon.setStyle("-fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5); "
				+ "-fx-border-width: 3px; " + "-fx-border-radius: 5px; "
				+ "-fx-background-color: linear-gradient(to bottom, #cfeccb, #81dbf5);");

		Scene scene4 = new Scene(new Group());
		scene4.setFill(gradient);
		tbv_FuelCoupon.getStyleClass().add("column-header-background");
		tbv_FuelCoupon.getStyleClass().add("table-view");
		pane.getChildren().add(vbox_FCOUP);

		return pane;
	}

	// ==============================================================

	public void insertData_FCOUP(FuelCoupon FCOUP) {

		try {
			System.out.println("INSERT INTO FuelCoupon VALUES (" + FCOUP.getCouponNumber() + "," + FCOUP.getCarNumber()
					+ ",'" + FCOUP.getDriverName() + "'," + FCOUP.getOdometerOnStarting() + ", '"
					+ FCOUP.getDepartmentName() + "'," + FCOUP.getFuelAmount() + ", '" + FCOUP.getFuelType() + "', "
					+ FCOUP.getFuelPrice() + ", '" + FCOUP.getFuelCompanyName() + "', '" + FCOUP.getEntryDate()
					+ "');");
			connectDB();

			ExecuteStatement("INSERT INTO FuelCoupon VALUES (" + FCOUP.getCouponNumber() + "," + FCOUP.getCarNumber()
					+ ",'" + FCOUP.getDriverName() + "'," + FCOUP.getOdometerOnStarting() + ", '"
					+ FCOUP.getDepartmentName() + "'," + FCOUP.getFuelAmount() + ", '" + FCOUP.getFuelType() + "', "
					+ FCOUP.getFuelPrice() + ", '" + FCOUP.getFuelCompanyName() + "', '" + FCOUP.getEntryDate()
					+ "');");

			con.close();
			System.out.println("Connection closed" + FCOUP_data.size());

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void getData_FCOUP() throws SQLException, ClassNotFoundException {
		String SQL;
		connectDB();
		System.out.println("Connection established");
		SQL = "select * from FuelCoupon ";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);

		while (rs.next()) {
			FCOUP_data.add(new FuelCoupon(rs.getInt("couponNumber"), rs.getInt("carNumber"), rs.getString("driverName"),
					rs.getInt("odometerOnStarting"), rs.getString("departmentName"), rs.getDouble("fuelAmount"),
					rs.getString("fuelType"), rs.getDouble("fuelPrice"), rs.getString("fuelCompanyName"),
					rs.getDate("EntryDate").toLocalDate()));

		}

		rs.close();
		stmt.close();

		con.close();
		System.out.println("Connection closed" + FCOUP_data.size());
	}

	public void deleteRow_FCOUP(FuelCoupon FCOUP) {
		try {
			System.out.println("delete from FuelCoupon where couponNumber=" + FCOUP.getCarNumber() + ";");
			connectDB();
			ExecuteStatement("delete from FuelCoupon where couponNumber=" + FCOUP.getCarNumber() + ";");
			con.close();
			System.out.println("Connection closed");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

// ============================FuelCard table===================================
//				private Integer CardNumber;	
//				private Integer CarNumber;	
//				private String FuelType;
//				private String DepartmentName;
//				private String FuelCompany;	
//				private Double FuelAmount;
//				private Double FuelPriceMonthly;
//				private String CarType;
//				private LocalDate DATE;			
// tableveiw=======================================================================
	public Pane FuelCardtable(Stage stage) {
		FCARD_data = new ArrayList<>();

		try {

			getData_FCARD();

			FCARD_dataList = FXCollections.observableArrayList(FCARD_data);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return FCARD_tableView(stage);

	}

	private Pane FCARD_tableView(Stage stage) {
		Pane p = new Pane();
		TableView<FuelCard> tbv_FuelCard = new TableView<FuelCard>();
		tbv_FuelCard.setMinWidth(725);

		TableColumn<FuelCard, Integer> cFCARD1 = new TableColumn<FuelCard, Integer>("CardNumber");
		cFCARD1.setCellValueFactory(new PropertyValueFactory<FuelCard, Integer>("CardNumber"));

		TableColumn<FuelCard, Integer> cFCARD2 = new TableColumn<FuelCard, Integer>("CarNumber");
		cFCARD2.setCellValueFactory(new PropertyValueFactory<FuelCard, Integer>("CarNumber"));

		TableColumn<FuelCard, String> cFCARD3 = new TableColumn<FuelCard, String>("FuelType");
		cFCARD3.setCellValueFactory(new PropertyValueFactory<FuelCard, String>("FuelType"));

		TableColumn<FuelCard, Integer> cFCARD4 = new TableColumn<FuelCard, Integer>("DepartmentName");
		cFCARD4.setCellValueFactory(new PropertyValueFactory<FuelCard, Integer>("DepartmentName"));

		TableColumn<FuelCard, String> cFCARD5 = new TableColumn<FuelCard, String>("FuelCompany");
		cFCARD5.setCellValueFactory(new PropertyValueFactory<FuelCard, String>("FuelCompany"));

		TableColumn<FuelCard, Double> cFCARD6 = new TableColumn<FuelCard, Double>("FuelAmount");
		cFCARD6.setCellValueFactory(new PropertyValueFactory<FuelCard, Double>("FuelAmount"));

		TableColumn<FuelCard, Double> cFCARD7 = new TableColumn<FuelCard, Double>("FuelPriceMonthly");
		cFCARD7.setCellValueFactory(new PropertyValueFactory<FuelCard, Double>("FuelPriceMonthly"));

		TableColumn<FuelCard, String> cFCARD8 = new TableColumn<FuelCard, String>("CarType");
		cFCARD8.setCellValueFactory(new PropertyValueFactory<FuelCard, String>("CarType"));

		TableColumn<FuelCard, LocalDate> cFCARD9 = new TableColumn<FuelCard, LocalDate>("DATE");
		cFCARD9.setCellValueFactory(new PropertyValueFactory<FuelCard, LocalDate>("DATE"));

		tbv_FuelCard.setEditable(true);

		tbv_FuelCard.getStyleClass().add("column-header-background");
		tbv_FuelCard.getStyleClass().add("table-view");

		// labels============================================================

		Label lbFCARD1 = new Label("CardNumber");
		Label lbFCARD2 = new Label("CarNumber");
		Label lbFCARD3 = new Label("FuelType");
		Label lbFCARD4 = new Label("DepartmentName");
		Label lbFCARD5 = new Label("FuelCompany");
		Label lbFCARD6 = new Label("FuelAmount");
		Label lbFCARD7 = new Label("FuelPriceMonthly");
		Label lbFCARD8 = new Label("CarType");
		Label lbFCARD9 = new Label("DATE");

		lbFCARD1.setTextFill(Color.web("#dadede"));
		lbFCARD2.setTextFill(Color.web("#dadede"));
		lbFCARD3.setTextFill(Color.web("#dadede"));
		lbFCARD4.setTextFill(Color.web("#dadede"));
		lbFCARD5.setTextFill(Color.web("#dadede"));
		lbFCARD6.setTextFill(Color.web("#dadede"));
		lbFCARD7.setTextFill(Color.web("#dadede"));
		lbFCARD8.setTextFill(Color.web("#dadede"));
		lbFCARD9.setTextFill(Color.web("#dadede"));

		lbFCARD1.setFont(normal);
		lbFCARD2.setFont(normal);
		lbFCARD3.setFont(normal);
		lbFCARD4.setFont(normal);
		lbFCARD5.setFont(normal);
		lbFCARD6.setFont(normal);
		lbFCARD7.setFont(normal);
		lbFCARD8.setFont(normal);
		lbFCARD9.setFont(normal);

		// textfeild====================================================

		TextField tf_FCARD_CardNumber = new TextField();
		TextField tf_FCARD_CarNumber = new TextField();
		TextField tf_FCARD_FuelType = new TextField();
		TextField tf_FCARD_DepartmentName = new TextField();
		TextField tf_FCARD_FuelCompany = new TextField();
		TextField tf_FCARD_FuelAmount = new TextField();
		TextField tf_FCARD_FuelPriceMonthly = new TextField();
//					TextField tf_FCARD_CarType = new TextField();
		ToggleGroup group2 = new ToggleGroup();
		RadioButton rb21 = new RadioButton("Owned");
		rb21.setTextFill(Color.WHITE);
		RadioButton rb22 = new RadioButton("Rental");
		rb22.setTextFill(Color.WHITE);
		RadioButton rb23 = new RadioButton("Substitute");
		rb23.setTextFill(Color.WHITE);
		group2.getToggles().addAll(rb21, rb22, rb23);
		HBox type_rbs = new HBox(rb21, rb22, rb23);

		// labeles==============================================================================================
		Label lb_FCARD_Tittle = new Label("Fuel Card TableVeiw");

		lb_FCARD_Tittle.setFont(fbold);
		lb_FCARD_Tittle.setStyle("-fx-text-fill: #2d5d7a;");

		Scene scene2 = new Scene(new Group());
		// Set the linear gradient as the fill for the scene
		scene2.setFill(gradient);

		stage.setTitle("Fuel Card TableVeiw");
		stage.setWidth(1200);
		stage.setHeight(700);

		tbv_FuelCard.setEditable(true);
		tbv_FuelCard.setMaxHeight(500);
		tbv_FuelCard.setMaxWidth(600);

		Button bt_FCARD_add = new Button("Add");
		Button bt_FCARD_delete = new Button("Delete");
		bt_FCARD_add.setFont(normal);
		bt_FCARD_delete.setFont(normal);

		tbv_FuelCard.setItems(FCARD_dataList);

		tbv_FuelCard.getColumns().addAll(cFCARD1, cFCARD2, cFCARD3, cFCARD4, cFCARD5, cFCARD6, cFCARD7, cFCARD8,
				cFCARD9);
		// pane=========================================================
		GridPane gp_FCARD = new GridPane();

		// datepicker_FC==============================================
		DatePicker dentrydate_FCARD = new DatePicker();

		gp_FCARD.addRow(0, lbFCARD1, tf_FCARD_CardNumber);
		gp_FCARD.addRow(1, lbFCARD2, tf_FCARD_CarNumber);
		gp_FCARD.addRow(2, lbFCARD3, tf_FCARD_FuelType);
		gp_FCARD.addRow(3, lbFCARD4, tf_FCARD_DepartmentName);
		gp_FCARD.addRow(4, lbFCARD5, tf_FCARD_FuelCompany);
		gp_FCARD.addRow(5, lbFCARD6, tf_FCARD_FuelAmount);
		gp_FCARD.addRow(6, lbFCARD7, tf_FCARD_FuelPriceMonthly);
		gp_FCARD.addRow(7, lbFCARD8, type_rbs);
		gp_FCARD.addRow(8, lbFCARD9, dentrydate_FCARD);

		gp_FCARD.setPadding(new Insets(10, 10, 10, 10));
		gp_FCARD.setHgap(10);
		gp_FCARD.setVgap(10);

		final VBox vbox_FCARD = new VBox();
		HBox hb1_FCARD = new HBox(10);

		// =====================================================================================
		HBox hb_FCARD = new HBox(10);
		hb_FCARD.setPadding(new Insets(10, 10, 10, 10));
		hb1_FCARD.getChildren().addAll(bt_FCARD_add, bt_FCARD_delete);
		hb1_FCARD.setAlignment(Pos.CENTER);

		vbox_FCARD.setSpacing(40);
		vbox_FCARD.setPadding(new Insets(10, 0, 0, 10));
		hb_FCARD.setPadding(new Insets(10, 10, 10, 10));

		vbox_FCARD.setAlignment(Pos.CENTER);
		hb_FCARD.getChildren().addAll(tbv_FuelCard, gp_FCARD);
		vbox_FCARD.getChildren().addAll(lb_FCARD_Tittle, hb_FCARD, hb1_FCARD);

		scene2.getStylesheets().add(getClass().getResource("styles.css").toExternalForm()); // Add CSS file
		// handler=======================================================================================================
//					public CarDistribution(Integer carNumber, String location, String carParkingLocation, String fleetOfficer,Integer odometerOnDropOff, LocalDate entryDate) {
		bt_FCARD_add.setOnAction(e -> {
			RadioButton selectedRadioButton = (RadioButton) group2.getSelectedToggle();
			String selectedText = "";
			if (selectedRadioButton != null) {
				selectedText = selectedRadioButton.getText();
			}
			FuelCard cd = new FuelCard(Integer.valueOf(tf_FCARD_CardNumber.getText()),
					Integer.valueOf(tf_FCARD_CarNumber.getText()), tf_FCARD_FuelType.getText(),
					tf_FCARD_DepartmentName.getText(), tf_FCARD_FuelCompany.getText(),
					Double.valueOf(tf_FCARD_FuelAmount.getText()), Double.valueOf(tf_FCARD_FuelPriceMonthly.getText()),
					selectedText, dentrydate_FCARD.getValue());

			insertData_FCARD(cd);
			if (string != null) {
				FCARD_dataList.add(cd);
			}
		});

//					bt_FCOUP_delete.setOnAction(e -> {
//									ObservableList<FuelCoupon> selectedRows = tbv_FuelCoupon.getSelectionModel().getSelectedItems();
//									ArrayList<FuelCoupon> rows = new ArrayList<>(selectedRows);
//									rows.forEach(row -> {
//										tbv_FuelCoupon.getItems().remove(row);
////										deleteRow_FCOUP(row);
//										tbv_FuelCoupon.refresh();
//									});
		//
//								});

		gp_FCARD.setStyle(" -fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5);\r\n"
				+ "    -fx-border-width: 3px;\r\n" + "    -fx-border-radius: 5px;");
		tbv_FuelCard.setStyle("-fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5); "
				+ "-fx-border-width: 3px; " + "-fx-border-radius: 5px; "
				+ "-fx-background-color: linear-gradient(to bottom, #cfeccb, #81dbf5);");
		Scene scene4 = new Scene(new Group());
		scene4.setFill(gradient);
		tbv_FuelCard.getStyleClass().add("column-header-background");
		tbv_FuelCard.getStyleClass().add("table-view");
		p.getChildren().add(vbox_FCARD);
		return p;
	}
	// ==============================================================

	public void insertData_FCARD(FuelCard FCARD) {
//					insert into FuelCard values( 1,1,"solar","financial","Alhuda",100.5,500,"personal","2024-9-6");

		try {
			System.out.println("INSERT INTO FuelCard VALUES (" + FCARD.getCardNumber() + ",'" + FCARD.getCarNumber()
					+ "','" + FCARD.getFuelType() + "','" + FCARD.getDepartmentName() + "', '" + FCARD.getFuelCompany()
					+ "','" + FCARD.getFuelAmount() + "', '" + FCARD.getFuelPriceMonthly() + "', '" + FCARD.getCarType()
					+ "', '" + FCARD.getDATE() + "');");

			connectDB();

			ExecuteStatement("INSERT INTO FuelCard VALUES (" + FCARD.getCardNumber() + ",'" + FCARD.getCarNumber()
					+ "','" + FCARD.getFuelType() + "','" + FCARD.getDepartmentName() + "', '" + FCARD.getFuelCompany()
					+ "','" + FCARD.getFuelAmount() + "', '" + FCARD.getFuelPriceMonthly() + "', '" + FCARD.getCarType()
					+ "', '" + FCARD.getDATE() + "');");

			con.close();
			System.out.println("Connection closed" + FCARD_data.size());

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void getData_FCARD() throws SQLException, ClassNotFoundException {
		String SQL;
		connectDB();
		System.out.println("Connection established");
		SQL = "select * from FuelCard ";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);

		while (rs.next()) {
			FCARD_data.add(new FuelCard(rs.getInt("CardNumber"), rs.getInt("CarNumber"), rs.getString("FuelType"),
					rs.getString("DepartmentName"), rs.getString("FuelCompany"), rs.getDouble("FuelAmount"),
					rs.getDouble("FuelPriceMonthly"), rs.getString("CarType"), rs.getDate("EntryDate").toLocalDate()));

		}

		rs.close();
		stmt.close();

		con.close();
		System.out.println("Connection closed" + FCARD_data.size());
	}

//				public void deleteRow_FCOUP(FuelCard FCARD) {
//					try {
//						System.out.println("delete from FuelCoupon where CardNumber=" + FCARD.getCardNumber() + ";");
//						connectDB();
//						ExecuteStatement("delete from FuelCoupon where CardNumber=" + FCARD.getCardNumber() + ";");
//						con.close();
//						System.out.println("Connection closed");
//					} catch (SQLException | ClassNotFoundException e) {
//						e.printStackTrace();
//					}
//				}

// ======================================================== Insurance Company tableveiw=======================================================================
// tableveiw=======================================================================
	public Pane InsuranceCompanytable(Stage stage) {
		INC_data = new ArrayList<>();

		try {

			getData_INC();

			INC_dataList = FXCollections.observableArrayList(INC_data);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return INC_tableView(stage);

	}

	private Pane INC_tableView(Stage stage) {
		Pane p = new Pane();

		TableView<InsuranceCompany> INC_tableVeiw = new TableView<InsuranceCompany>();
		INC_tableVeiw.setMinWidth(725);

		TableColumn<InsuranceCompany, Integer> cINC1 = new TableColumn<InsuranceCompany, Integer>("CompanyNumber");
		cINC1.setCellValueFactory(new PropertyValueFactory<InsuranceCompany, Integer>("CompanyNumber"));

		TableColumn<InsuranceCompany, String> cINC2 = new TableColumn<InsuranceCompany, String>("CompanyName");
		cINC2.setCellValueFactory(new PropertyValueFactory<InsuranceCompany, String>("CompanyName"));

		TableColumn<InsuranceCompany, String> cINC3 = new TableColumn<InsuranceCompany, String>("Email");
		cINC3.setCellValueFactory(new PropertyValueFactory<InsuranceCompany, String>("Email"));

		TableColumn<InsuranceCompany, String> cINC4 = new TableColumn<InsuranceCompany, String>("ContactPersonName");
		cINC4.setCellValueFactory(new PropertyValueFactory<InsuranceCompany, String>("ContactPersonName"));

		TableColumn<InsuranceCompany, String> cINC5 = new TableColumn<InsuranceCompany, String>(
				"ContactPersonPhoneNumber");
		cINC5.setCellValueFactory(new PropertyValueFactory<InsuranceCompany, String>("ContactPersonPhoneNumber"));

		TableColumn<InsuranceCompany, String> cINC6 = new TableColumn<InsuranceCompany, String>("Location");
		cINC6.setCellValueFactory(new PropertyValueFactory<InsuranceCompany, String>("Location"));

		TableColumn<InsuranceCompany, LocalDate> cINC7 = new TableColumn<InsuranceCompany, LocalDate>("EntryDate");
		cINC7.setCellValueFactory(new PropertyValueFactory<InsuranceCompany, LocalDate>("EntryDate"));

		INC_tableVeiw.getStyleClass().add("column-header-background");
		INC_tableVeiw.getStyleClass().add("table-view");

		// labels============================================================

		Label lbINC1 = new Label("CompanyNumber");
		Label lbINC2 = new Label("CompanyName");
		Label lbINC3 = new Label("Email");
		Label lbINC4 = new Label("ContactPersonName");
		Label lbINC5 = new Label("ContactPersonPhoneNumber");
		Label lbINC6 = new Label("Location");
		Label lbINC7 = new Label("EntryDate");

		lbINC1.setTextFill(Color.web("#dadede"));
		lbINC2.setTextFill(Color.web("#dadede"));
		lbINC3.setTextFill(Color.web("#dadede"));
		lbINC4.setTextFill(Color.web("#dadede"));
		lbINC5.setTextFill(Color.web("#dadede"));
		lbINC6.setTextFill(Color.web("#dadede"));
		lbINC7.setTextFill(Color.web("#dadede"));

		lbINC1.setFont(normal);
		lbINC2.setFont(normal);
		lbINC3.setFont(normal);
		lbINC4.setFont(normal);
		lbINC5.setFont(normal);
		lbINC6.setFont(normal);
		lbINC7.setFont(normal);

		// textfeild====================================================

		TextField tf_INC_CompanyNumber = new TextField();
		TextField tf_INC_CompanyName = new TextField();
		TextField tf_INC_Email = new TextField();
		TextField tf_INC_ContactPersonName = new TextField();
		TextField tf_INC_ContactPersonPhoneNumber = new TextField();
		TextField tf_INC_Location = new TextField();

		// labeles==============================================================================================
		Label lb_INC_Tittle = new Label("Insurance Companies TableVeiw");

		lb_INC_Tittle.setFont(fbold);
		lb_INC_Tittle.setStyle("-fx-text-fill: #2d5d7a;");

		Scene scene2 = new Scene(new Group());
		// Set the linear gradient as the fill for the scene
		scene2.setFill(gradient);

		stage.setTitle("Insurance Companies TableVeiw");
		stage.setWidth(1200);
		stage.setHeight(700);

		INC_tableVeiw.setEditable(true);
		INC_tableVeiw.setMaxHeight(500);
		INC_tableVeiw.setMaxWidth(600);

		Button bt_INC_add = new Button("Add");
		Button bt_INC_delete = new Button("Delete");
		bt_INC_add.setFont(normal);
		bt_INC_delete.setFont(normal);

		INC_tableVeiw.setItems(INC_dataList);

		INC_tableVeiw.getColumns().addAll(cINC1, cINC2, cINC3, cINC4, cINC5, cINC6, cINC7);
		// pane=========================================================
		GridPane gp_INC = new GridPane();

		// datepicker_FC==============================================
		DatePicker dentrydate_INC = new DatePicker();

		gp_INC.addRow(0, lbINC1, tf_INC_CompanyNumber);
		gp_INC.addRow(1, lbINC2, tf_INC_CompanyName);
		gp_INC.addRow(2, lbINC3, tf_INC_Email);
		gp_INC.addRow(3, lbINC4, tf_INC_ContactPersonName);
		gp_INC.addRow(4, lbINC5, tf_INC_ContactPersonPhoneNumber);
		gp_INC.addRow(5, lbINC6, tf_INC_Location);
		gp_INC.addRow(6, lbINC7, dentrydate_INC);

		gp_INC.setPadding(new Insets(10, 10, 10, 10));
		gp_INC.setHgap(10);
		gp_INC.setVgap(10);

		final VBox vbox_INC = new VBox();
		HBox hb1_INC = new HBox(10);

		// =====================================================================================
		HBox hb_INC = new HBox(10);
		hb_INC.setPadding(new Insets(10, 10, 10, 10));
		hb1_INC.getChildren().addAll(bt_INC_add, bt_INC_delete);
		hb1_INC.setAlignment(Pos.CENTER);

		vbox_INC.setSpacing(40);
		vbox_INC.setPadding(new Insets(10, 0, 0, 10));
		hb_INC.setPadding(new Insets(10, 10, 10, 10));

		vbox_INC.setAlignment(Pos.CENTER);
		hb_INC.getChildren().addAll(INC_tableVeiw, gp_INC);
		vbox_INC.getChildren().addAll(lb_INC_Tittle, hb_INC, hb1_INC);

		scene2.getStylesheets().add(getClass().getResource("styles.css").toExternalForm()); // Add CSS file
		// handler=======================================================================================================
		bt_INC_add.setOnAction(e -> {
			InsuranceCompany inc = new InsuranceCompany(Integer.valueOf(tf_INC_CompanyNumber.getText()),
					tf_INC_CompanyName.getText(), tf_INC_Email.getText(), tf_INC_ContactPersonName.getText(),
					tf_INC_ContactPersonPhoneNumber.getText(), tf_INC_Location.getText(), dentrydate_INC.getValue());

			insertData_INC(inc);
			if (string != null) {
				INC_dataList.add(inc);
			}
		});

		bt_INC_delete.setOnAction(e -> {
			ObservableList<InsuranceCompany> selectedRows = INC_tableVeiw.getSelectionModel().getSelectedItems();
			ArrayList<InsuranceCompany> rows = new ArrayList<>(selectedRows);
			rows.forEach(row -> {
				INC_tableVeiw.getItems().remove(row);
				deleteRow_INC(row);
				INC_tableVeiw.refresh();
			});

		});

		// update info in Insurance Company
		// table==================================================

		cINC3.setCellFactory(TextFieldTableCell.forTableColumn());
		cINC3.setOnEditCommit((TableColumn.CellEditEvent<InsuranceCompany, String> t) -> {
			t.getTableView().getItems().get(t.getTablePosition().getRow()).setEmail(t.getNewValue());
			updateEmail_INC(t.getRowValue().getCompanyNumber(), t.getRowValue().getEmail());
		});

		cINC4.setCellFactory(TextFieldTableCell.forTableColumn());
		cINC4.setOnEditCommit((TableColumn.CellEditEvent<InsuranceCompany, String> t) -> {
			t.getTableView().getItems().get(t.getTablePosition().getRow()).setContactPersonName(t.getNewValue());
			updateContactPersonName_INC(t.getRowValue().getCompanyNumber(), t.getRowValue().getContactPersonName());
		});

		cINC5.setCellFactory(TextFieldTableCell.forTableColumn());
		cINC5.setOnEditCommit((TableColumn.CellEditEvent<InsuranceCompany, String> t) -> {
			t.getTableView().getItems().get(t.getTablePosition().getRow()).setContactPersonPhoneNumber(t.getNewValue());
			updateContactPersonPhoneNumber_INC(t.getRowValue().getCompanyNumber(),
					t.getRowValue().getContactPersonName());
		});
		cINC6.setCellFactory(TextFieldTableCell.forTableColumn());
		cINC6.setOnEditCommit((TableColumn.CellEditEvent<InsuranceCompany, String> t) -> {
			t.getTableView().getItems().get(t.getTablePosition().getRow()).setLocation(t.getNewValue());
			updateLocation_INC(t.getRowValue().getCompanyNumber(), t.getRowValue().getLocation());
		});

		gp_INC.setStyle(" -fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5);\r\n"
				+ "    -fx-border-width: 3px;\r\n" + "    -fx-border-radius: 5px;");
		INC_tableVeiw.setStyle("-fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5); "
				+ "-fx-border-width: 3px; " + "-fx-border-radius: 5px; "
				+ "-fx-background-color: linear-gradient(to bottom, #cfeccb, #81dbf5);");
		Scene scene4 = new Scene(new Group());
		scene4.setFill(gradient);
		INC_tableVeiw.getStyleClass().add("column-header-background");
		INC_tableVeiw.getStyleClass().add("table-view");
		p.getChildren().add(vbox_INC);
		return p;

	}

//=======================methods ===============================	
	public void insertData_INC(InsuranceCompany INC) {
//					insert into InsuranceCompany values (1,"tamkeen","tamkeen@gmail.com","Tamer","058937338","Ramallah","2024-11-4");

		try {
			System.out.println("INSERT INTO InsuranceCompany VALUES (" + INC.getCompanyNumber() + ",'"
					+ INC.getCompanyName() + "','" + INC.getEmail() + "','" + INC.getContactPersonName() + "', '"
					+ INC.getContactPersonPhoneNumber() + "','" + INC.getLocation() + "', '" + INC.getEntryDate()
					+ "');");

			connectDB();

			ExecuteStatement("INSERT INTO InsuranceCompany VALUES (" + INC.getCompanyNumber() + ",'"
					+ INC.getCompanyName() + "','" + INC.getEmail() + "','" + INC.getContactPersonName() + "', '"
					+ INC.getContactPersonPhoneNumber() + "','" + INC.getLocation() + "', '" + INC.getEntryDate()
					+ "');");

			con.close();
			System.out.println("Connection closed" + INC_data.size());

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void getData_INC() throws SQLException, ClassNotFoundException {
		String SQL;
		connectDB();
		System.out.println("Connection established");
		SQL = "select * from InsuranceCompany ";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);
		while (rs.next()) {
			INC_data.add(new InsuranceCompany(rs.getInt("companyNumber"), rs.getString("companyName"),
					rs.getString("email"), rs.getString("contactPersonName"), rs.getString("contactPersonPhoneNumber"),
					rs.getString("location"), rs.getDate("EntryDate").toLocalDate()));

		}

		rs.close();
		stmt.close();

		con.close();
		System.out.println("Connection closed" + INC_data.size());
	}

	public void deleteRow_INC(InsuranceCompany INC) {
		try {
			System.out.println("delete from InsuranceCompany where companyNumber=" + INC.getCompanyNumber() + ";");
			connectDB();
			ExecuteStatement("delete from InsuranceCompany where companyNumber=" + INC.getCompanyNumber() + ";");
			con.close();
			System.out.println("Connection closed");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

//==============================================================
	public void updateEmail_INC(int CompanyNumber, String email) {

		try {
			System.out.println(
					"update  InsuranceCompany set email = '" + email + "' where companyNumber = " + CompanyNumber);
			connectDB();
			ExecuteStatement("update  InsuranceCompany set  email = '" + email + "' where companyNumber = "
					+ CompanyNumber + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

//==============================================================		
	public void updateContactPersonName_INC(int CompanyNumber, String ContactPersonName) {

		try {
			System.out.println("update  InsuranceCompany set ContactPersonName = '" + ContactPersonName
					+ "' where companyNumber = " + CompanyNumber);
			connectDB();
			ExecuteStatement("update  InsuranceCompany set  ContactPersonName = '" + ContactPersonName
					+ "' where companyNumber = " + CompanyNumber + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

//==============================================================	
	public void updateContactPersonPhoneNumber_INC(int CompanyNumber, String ContactPersonPhoneNumber) {

		try {
			System.out.println("update  InsuranceCompany set ContactPersonPhoneNumber = '" + ContactPersonPhoneNumber
					+ "' where companyNumber = " + CompanyNumber);
			connectDB();
			ExecuteStatement("update  InsuranceCompany set  ContactPersonPhoneNumber = '" + ContactPersonPhoneNumber
					+ "' where companyNumber = " + CompanyNumber + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

//==============================================================
	public void updateLocation_INC(int CompanyNumber, String Location) {

		try {
			System.out.println("update  InsuranceCompany set Location = '" + Location + "' where companyNumber = "
					+ CompanyNumber);
			connectDB();
			ExecuteStatement("update  InsuranceCompany set  Location = '" + Location + "' where companyNumber = "
					+ CompanyNumber + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

//==============================================================
// ======================================================== CarWash Company tableveiw=======================================================================
//				private Integer CompanyNumber;
//				private String CompanyName;
//				private String ContactPerson;
//				private String PhoneNumber;
//				private String Email ;
//				private String Location;
//				private LocalDate EntryDate;
// tableveiw=======================================================================
	public Pane CarWashCompanytable(Stage stage) {
		CWC_data = new ArrayList<>();

		try {

			getData_CWC();

			CWC_dataList = FXCollections.observableArrayList(CWC_data);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return CWC_tableView(stage);

	}
//==============================

	private Pane CWC_tableView(Stage stage) {
		Pane P = new Pane();
		TableView<CarWashCompany> CWC_tableVeiw = new TableView<CarWashCompany>();
		CWC_tableVeiw.setMinWidth(725);
		CWC_tableVeiw.setStyle("-fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5); "
				+ "-fx-border-width: 3px; " + "-fx-border-radius: 5px; "
				+ "-fx-background-color: linear-gradient(to bottom, #cfeccb, #81dbf5);");

		TableColumn<CarWashCompany, Integer> cCWC1 = new TableColumn<CarWashCompany, Integer>("CompanyNumber");
		cCWC1.setCellValueFactory(new PropertyValueFactory<CarWashCompany, Integer>("CompanyNumber"));

		TableColumn<CarWashCompany, String> cCWC2 = new TableColumn<CarWashCompany, String>("CompanyName");
		cCWC2.setCellValueFactory(new PropertyValueFactory<CarWashCompany, String>("CompanyName"));

		TableColumn<CarWashCompany, String> cCWC3 = new TableColumn<CarWashCompany, String>("ContactPerson");
		cCWC3.setCellValueFactory(new PropertyValueFactory<CarWashCompany, String>("ContactPerson"));

		TableColumn<CarWashCompany, String> cCWC4 = new TableColumn<CarWashCompany, String>("PhoneNumber");
		cCWC4.setCellValueFactory(new PropertyValueFactory<CarWashCompany, String>("PhoneNumber"));

		TableColumn<CarWashCompany, String> cCWC5 = new TableColumn<CarWashCompany, String>("Email");
		cCWC5.setCellValueFactory(new PropertyValueFactory<CarWashCompany, String>("Email"));

		TableColumn<CarWashCompany, String> cCWC6 = new TableColumn<CarWashCompany, String>("Location");
		cCWC6.setCellValueFactory(new PropertyValueFactory<CarWashCompany, String>("Location"));

		TableColumn<CarWashCompany, LocalDate> cCWC7 = new TableColumn<CarWashCompany, LocalDate>("EntryDate");
		cCWC7.setCellValueFactory(new PropertyValueFactory<CarWashCompany, LocalDate>("EntryDate"));

		CWC_tableVeiw.getStyleClass().add("column-header-background");
		CWC_tableVeiw.getStyleClass().add("table-view");

		// labels============================================================

		Label lbCWC1 = new Label("CompanyNumber");
		Label lbCWC2 = new Label("CompanyName");
		Label lbCWC3 = new Label("ContactPerson");
		Label lbCWC4 = new Label("PhoneNumber");
		Label lbCWC5 = new Label("Email");
		Label lbCWC6 = new Label("Location");
		Label lbCWC7 = new Label("EntryDate");

		lbCWC1.setTextFill(Color.web("#dadede"));
		lbCWC2.setTextFill(Color.web("#dadede"));
		lbCWC3.setTextFill(Color.web("#dadede"));
		lbCWC4.setTextFill(Color.web("#dadede"));
		lbCWC5.setTextFill(Color.web("#dadede"));
		lbCWC6.setTextFill(Color.web("#dadede"));
		lbCWC7.setTextFill(Color.web("#dadede"));

		lbCWC1.setFont(normal);
		lbCWC2.setFont(normal);
		lbCWC3.setFont(normal);
		lbCWC4.setFont(normal);
		lbCWC5.setFont(normal);
		lbCWC6.setFont(normal);
		lbCWC7.setFont(normal);

		// textfeild====================================================

		TextField tf_CWC_CompanyNumber = new TextField();
		TextField tf_CWC_CompanyName = new TextField();
		TextField tf_CWC_ContactPerson = new TextField();
		TextField tf_CWC_PhoneNumber = new TextField();
		TextField tf_CWC_Email = new TextField();
		TextField tf_CWC_Location = new TextField();

		// labeles==============================================================================================
		Label lb_CWC_Tittle = new Label("Car WashCompany TableVeiw");

		lb_CWC_Tittle.setFont(fbold);
		lb_CWC_Tittle.setStyle("-fx-text-fill: #2d5d7a;");

		Scene scene2 = new Scene(new Group());
		// Set the linear gradient as the fill for the scene
		scene2.setFill(gradient);

		stage.setTitle("CarWashCompany TableVeiw");
		stage.setWidth(1200);
		stage.setHeight(700);

		CWC_tableVeiw.setEditable(true);
		CWC_tableVeiw.setMaxHeight(500);
		CWC_tableVeiw.setMaxWidth(600);

		Button bt_CWC_add = new Button("Add");
		Button bt_CWC_delete = new Button("Delete");
		bt_CWC_add.setFont(normal);
		bt_CWC_delete.setFont(normal);

		CWC_tableVeiw.setItems(CWC_dataList);

		CWC_tableVeiw.getColumns().addAll(cCWC1, cCWC2, cCWC3, cCWC4, cCWC5, cCWC6, cCWC7);
		// pane=========================================================
		GridPane gp_CWC = new GridPane();

		// datepicker_FC==============================================
		DatePicker dentrydate_CWC = new DatePicker();

		gp_CWC.addRow(0, lbCWC1, tf_CWC_CompanyNumber);
		gp_CWC.addRow(1, lbCWC2, tf_CWC_CompanyName);
		gp_CWC.addRow(2, lbCWC3, tf_CWC_ContactPerson);
		gp_CWC.addRow(3, lbCWC4, tf_CWC_PhoneNumber);
		gp_CWC.addRow(4, lbCWC5, tf_CWC_Email);
		gp_CWC.addRow(5, lbCWC6, tf_CWC_Location);
		gp_CWC.addRow(6, lbCWC7, dentrydate_CWC);

		gp_CWC.setPadding(new Insets(10, 10, 10, 10));
		gp_CWC.setHgap(10);
		gp_CWC.setVgap(10);

		gp_CWC.setStyle(" -fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5);\r\n"
				+ "    -fx-border-width: 3px;\r\n" + "    -fx-border-radius: 5px;");

		final VBox vbox_CWC = new VBox();
		HBox hb1_CWC = new HBox(10);

		// =====================================================================================
		HBox hb_CWC = new HBox(10);
		hb_CWC.setPadding(new Insets(10, 10, 10, 10));
		hb1_CWC.getChildren().addAll(bt_CWC_add, bt_CWC_delete);
		hb1_CWC.setAlignment(Pos.CENTER);

		vbox_CWC.setSpacing(40);
		vbox_CWC.setPadding(new Insets(10, 0, 0, 10));
		hb_CWC.setPadding(new Insets(10, 10, 10, 10));

		vbox_CWC.setAlignment(Pos.CENTER);
		hb_CWC.getChildren().addAll(CWC_tableVeiw, gp_CWC);
		vbox_CWC.getChildren().addAll(lb_CWC_Tittle, hb_CWC, hb1_CWC);

		scene2.getStylesheets().add(getClass().getResource("styles.css").toExternalForm()); // Add CSS file
		// handler=======================================================================================================
		bt_CWC_add.setOnAction(e -> {
//					public CarWashCompany(Integer companyNumber, String companyName, String contactPerson, String phoneNumber,
//						String email, String location, LocalDate entryDate) {	
			CarWashCompany cwc = new CarWashCompany(Integer.valueOf(tf_CWC_CompanyNumber.getText()),
					tf_CWC_CompanyName.getText(), tf_CWC_ContactPerson.getText(), tf_CWC_PhoneNumber.getText(),
					tf_CWC_Email.getText(), tf_CWC_Location.getText(), dentrydate_CWC.getValue());

			insertData_CWC(cwc);
			if (string != null) {
				CWC_dataList.add(cwc);
			}
		});

		bt_CWC_delete.setOnAction(e -> {
			ObservableList<CarWashCompany> selectedRows = CWC_tableVeiw.getSelectionModel().getSelectedItems();
			ArrayList<CarWashCompany> rows = new ArrayList<>(selectedRows);
			rows.forEach(row -> {
				CWC_tableVeiw.getItems().remove(row);
				deleteRow_CWC(row);
				CWC_tableVeiw.refresh();
			});

		});

		// update info in Insurance Company
		// table==================================================

		cCWC3.setCellFactory(TextFieldTableCell.forTableColumn());
		cCWC3.setOnEditCommit((TableColumn.CellEditEvent<CarWashCompany, String> t) -> {
			t.getTableView().getItems().get(t.getTablePosition().getRow()).setContactPerson(t.getNewValue());
			updateContactPerson_CWC(t.getRowValue().getCompanyNumber(), t.getRowValue().getContactPerson());
		});

		cCWC4.setCellFactory(TextFieldTableCell.forTableColumn());
		cCWC4.setOnEditCommit((TableColumn.CellEditEvent<CarWashCompany, String> t) -> {
			t.getTableView().getItems().get(t.getTablePosition().getRow()).setPhoneNumber(t.getNewValue());
			updatePhoneNumber_CWC(t.getRowValue().getCompanyNumber(), t.getRowValue().getPhoneNumber());
		});

		cCWC5.setCellFactory(TextFieldTableCell.forTableColumn());
		cCWC5.setOnEditCommit((TableColumn.CellEditEvent<CarWashCompany, String> t) -> {
			t.getTableView().getItems().get(t.getTablePosition().getRow()).setEmail(t.getNewValue());
			updateEmail_CWC(t.getRowValue().getCompanyNumber(), t.getRowValue().getEmail());
		});
		cCWC6.setCellFactory(TextFieldTableCell.forTableColumn());
		cCWC6.setOnEditCommit((TableColumn.CellEditEvent<CarWashCompany, String> t) -> {
			t.getTableView().getItems().get(t.getTablePosition().getRow()).setLocation(t.getNewValue());
			updateLocation_INC(t.getRowValue().getCompanyNumber(), t.getRowValue().getLocation());
		});

		Scene scene4 = new Scene(new Group());
		scene4.setFill(gradient);
		CWC_tableVeiw.getStyleClass().add("column-header-background");
		CWC_tableVeiw.getStyleClass().add("table-view");
		P.getChildren().add(vbox_CWC);
		return P;

	}

	// =======================methods ===============================
	public void insertData_CWC(CarWashCompany CWC) {
//					(1,"Best Washer","BestWasher@gmail.com","Bilal","058937648","Ramallah","2019-7-4");
		try {
			System.out.println("INSERT INTO CarWashCompany VALUES (" + CWC.getCompanyNumber() + ",'"
					+ CWC.getCompanyName() + "','" + CWC.getEmail() + "','" + CWC.getContactPerson() + "', '"
					+ CWC.getPhoneNumber() + "','" + CWC.getLocation() + "', '" + CWC.getEntryDate() + "');");

			connectDB();
			ExecuteStatement("INSERT INTO CarWashCompany VALUES (" + CWC.getCompanyNumber() + ",'"
					+ CWC.getCompanyName() + "','" + CWC.getContactPerson() + "','" + CWC.getPhoneNumber() + "', '"
					+ CWC.getEmail() + "','" + CWC.getLocation() + "', '" + CWC.getEntryDate() + "');");

			con.close();
			System.out.println("Connection closed" + CWC_data.size());

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void getData_CWC() throws SQLException, ClassNotFoundException {

		String SQL;
		connectDB();
		System.out.println("Connection established");
		SQL = "select * from CarWashCompany ";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);
		while (rs.next()) {
			CWC_data.add(new CarWashCompany(rs.getInt("CompanyNumber"), rs.getString("CompanyName"),
					rs.getString("ContactPerson"), rs.getString("PhoneNumber"), rs.getString("Email"),
					rs.getString("Location"), rs.getDate("EntryDate").toLocalDate()));

		}

		rs.close();
		stmt.close();

		con.close();
		System.out.println("Connection closed" + CWC_data.size());
	}

	public void deleteRow_CWC(CarWashCompany CWC) {
		try {
			System.out.println("delete from CarWashCompany where CompanyNumber=" + CWC.getCompanyNumber() + ";");
			connectDB();
			ExecuteStatement("delete from CarWashCompany where CompanyNumber=" + CWC.getCompanyNumber() + ";");
			con.close();
			System.out.println("Connection closed");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

//==============================================================
	public void updateEmail_CWC(int CompanyNumber, String Email) {

		try {
			System.out.println(
					"update  CarWashCompany set Email = '" + Email + "' where CompanyNumber = " + CompanyNumber);
			connectDB();
			ExecuteStatement(
					"update  CarWashCompany set  Email = '" + Email + "' where CompanyNumber = " + CompanyNumber + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

//==============================================================		
	public void updateContactPerson_CWC(int CompanyNumber, String ContactPerson) {

		try {
			System.out.println("update  CarWashCompany set ContactPerson = '" + ContactPerson
					+ "' where CompanyNumber = " + CompanyNumber);
			connectDB();
			ExecuteStatement("update  CarWashCompany set  ContactPerson = '" + ContactPerson
					+ "' where CompanyNumber = " + CompanyNumber + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

//==============================================================	
	public void updatePhoneNumber_CWC(int CompanyNumber, String PhoneNumber) {

		try {
			System.out.println("update  CarWashCompany set PhoneNumber = '" + PhoneNumber + "' where CompanyNumber = "
					+ CompanyNumber);
			connectDB();
			ExecuteStatement("update  CarWashCompany set  PhoneNumber = '" + PhoneNumber + "' where CompanyNumber = "
					+ CompanyNumber + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// ==============================================================
	public void updateLocation_CWC(int CompanyNumber, String Location) {

		try {
			System.out.println(
					"update  CarWashCompany set Location = '" + Location + "' where CompanyNumber = " + CompanyNumber);
			connectDB();
			ExecuteStatement("update  CarWashCompany set  Location = '" + Location + "' where CompanyNumber = "
					+ CompanyNumber + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

//=========================================================================================================				
// tableveiw=======================================================================
	public Pane CarWashestable(Stage stage) {
		CW_data = new ArrayList<>();

		try {

			getData_CW();

			CW_dataList = FXCollections.observableArrayList(CW_data);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return CW_tableView(stage);

	}

//==============================================================	
	private Pane CW_tableView(Stage stage) {
		Pane P = new Pane();

		TableView<CarWashes> CW_tableVeiw = new TableView<CarWashes>();
		CW_tableVeiw.setMinWidth(725);
		CW_tableVeiw.setStyle("-fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5); "
				+ "-fx-border-width: 3px; " + "-fx-border-radius: 5px; "
				+ "-fx-background-color: linear-gradient(to bottom, #cfeccb, #81dbf5);");

		TableColumn<CarWashes, Integer> cCWC1 = new TableColumn<CarWashes, Integer>("CouponNumber");
		cCWC1.setCellValueFactory(new PropertyValueFactory<CarWashes, Integer>("CouponNumber"));

		TableColumn<CarWashes, Integer> cCWC2 = new TableColumn<CarWashes, Integer>("CarNumber");
		cCWC2.setCellValueFactory(new PropertyValueFactory<CarWashes, Integer>("CarNumber"));

		TableColumn<CarWashes, Double> cCWC3 = new TableColumn<CarWashes, Double>("ValueFee");
		cCWC3.setCellValueFactory(new PropertyValueFactory<CarWashes, Double>("ValueFee"));

		TableColumn<CarWashes, String> cCWC4 = new TableColumn<CarWashes, String>("DriverName");
		cCWC4.setCellValueFactory(new PropertyValueFactory<CarWashes, String>("DriverName"));

		TableColumn<CarWashes, LocalDate> cCWC5 = new TableColumn<CarWashes, LocalDate>("EntryDate");
		cCWC5.setCellValueFactory(new PropertyValueFactory<CarWashes, LocalDate>("EntryDate"));

		TableColumn<CarWashes, String> cCWC6 = new TableColumn<CarWashes, String>("WashCompanyName");
		cCWC6.setCellValueFactory(new PropertyValueFactory<CarWashes, String>("WashCompanyName"));

		CW_tableVeiw.getStyleClass().add("column-header-background");
		CW_tableVeiw.getStyleClass().add("table-view");

		// labels============================================================

		Label lbCWC1 = new Label("CouponNumber");
		Label lbCWC2 = new Label("CarNumber");
		Label lbCWC3 = new Label("ValueFee");
		Label lbCWC4 = new Label("DriverName");
		Label lbCWC5 = new Label("EntryDate");
		Label lbCWC6 = new Label("WashCompanyName");

		lbCWC1.setTextFill(Color.web("#dadede"));
		lbCWC2.setTextFill(Color.web("#dadede"));
		lbCWC3.setTextFill(Color.web("#dadede"));
		lbCWC4.setTextFill(Color.web("#dadede"));
		lbCWC5.setTextFill(Color.web("#dadede"));
		lbCWC6.setTextFill(Color.web("#dadede"));

		lbCWC1.setFont(normal);
		lbCWC2.setFont(normal);
		lbCWC3.setFont(normal);
		lbCWC4.setFont(normal);
		lbCWC5.setFont(normal);
		lbCWC6.setFont(normal);

		// textfeild====================================================
//					CouponNumber INT PRIMARY KEY,
//				    CarNumber INT,
//				    ValueFee DECIMAL(10, 2),
//				    DriverName VARCHAR(100),
//				    EntryDate DATE,
//				    WashCompanyName VARCHAR(255),

		TextField tf_CWC_CouponNumber = new TextField();
		TextField tf_CWC_CarNumber = new TextField();
		TextField tf_CWC_ValueFee = new TextField();
		TextField tf_CWC_DriverName = new TextField();
		TextField tf_CWC_WashCompanyName = new TextField();

		// labeles==============================================================================================
		Label lb_CWC_Tittle = new Label("Car Washes TableVeiw");

		lb_CWC_Tittle.setFont(fbold);
		lb_CWC_Tittle.setStyle("-fx-text-fill: #2d5d7a;");

		Scene scene2 = new Scene(new Group());
		// Set the linear gradient as the fill for the scene
		scene2.setFill(gradient);

		stage.setTitle("Car Washes TableVeiw");
		stage.setWidth(1200);
		stage.setHeight(700);

		CW_tableVeiw.setEditable(true);
		CW_tableVeiw.setMaxHeight(500);
		CW_tableVeiw.setMaxWidth(600);

		Button bt_CW_add = new Button("Add");
		Button bt_CW_delete = new Button("Delete");
		bt_CW_add.setFont(normal);
		bt_CW_delete.setFont(normal);

		CW_tableVeiw.setItems(CW_dataList);

		CW_tableVeiw.getColumns().addAll(cCWC1, cCWC2, cCWC3, cCWC4, cCWC5, cCWC6);
		// pane=========================================================
		GridPane gp_CWC = new GridPane();

		// datepicker_FC==============================================
		DatePicker dentrydate_CW = new DatePicker();

		gp_CWC.addRow(0, lbCWC1, tf_CWC_CouponNumber);
		gp_CWC.addRow(1, lbCWC2, tf_CWC_CarNumber);
		gp_CWC.addRow(2, lbCWC3, tf_CWC_ValueFee);
		gp_CWC.addRow(3, lbCWC4, tf_CWC_DriverName);
		gp_CWC.addRow(4, lbCWC5, dentrydate_CW);
		gp_CWC.addRow(5, lbCWC6, tf_CWC_WashCompanyName);

		gp_CWC.setPadding(new Insets(10, 10, 10, 10));
		gp_CWC.setHgap(10);
		gp_CWC.setVgap(10);

		gp_CWC.setStyle(" -fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5);\r\n"
				+ "    -fx-border-width: 3px;\r\n" + "    -fx-border-radius: 5px;");

		final VBox vbox_CW = new VBox();
		HBox hb1_CW = new HBox(10);

		// =====================================================================================
		HBox hb_CW = new HBox(10);
		hb_CW.setPadding(new Insets(10, 10, 10, 10));
		hb1_CW.getChildren().addAll(bt_CW_add, bt_CW_delete);
		hb1_CW.setAlignment(Pos.CENTER);

		vbox_CW.setSpacing(40);
		vbox_CW.setPadding(new Insets(10, 0, 0, 10));
		hb_CW.setPadding(new Insets(10, 10, 10, 10));

		vbox_CW.setAlignment(Pos.CENTER);
		hb_CW.getChildren().addAll(CW_tableVeiw, gp_CWC);
		vbox_CW.getChildren().addAll(lb_CWC_Tittle, hb_CW, hb1_CW);

		scene2.getStylesheets().add(getClass().getResource("styles.css").toExternalForm()); // Add CSS file
		// handler=======================================================================================================
		bt_CW_add.setOnAction(e -> {
//						public CarWashes(Integer couponNumber, Integer carNumber, Double valueFee, String driverName, LocalDate entryDate,
//								String washCompanyName) {

			CarWashes cw = new CarWashes(Integer.valueOf(tf_CWC_CouponNumber.getText()),
					Integer.valueOf(tf_CWC_CarNumber.getText()), Double.valueOf(tf_CWC_ValueFee.getText()),
					tf_CWC_DriverName.getText(), dentrydate_CW.getValue(), tf_CWC_WashCompanyName.getText());

			insertData_CW(cw);
			CW_dataList.add(cw);
		});

		bt_CW_delete.setOnAction(e -> {
			ObservableList<CarWashes> selectedRows = CW_tableVeiw.getSelectionModel().getSelectedItems();
			ArrayList<CarWashes> rows = new ArrayList<>(selectedRows);
			rows.forEach(row -> {
				CW_tableVeiw.getItems().remove(row);
				deleteRow_CW(row);
				CW_tableVeiw.refresh();
			});

		});

		// update info in Insurance Company
		// table==================================================
//
//					cCWC3.setCellFactory(TextFieldTableCell.forTableColumn());
//					cCWC3.setOnEditCommit((TableColumn.CellEditEvent<CarWashCompany, String> t) -> {
//						t.getTableView().getItems().get(t.getTablePosition().getRow()).setContactPerson(t.getNewValue());
//						updateContactPerson_CWC(t.getRowValue().getCompanyNumber(), t.getRowValue().getContactPerson());
//					});
//					
//					cCWC4.setCellFactory(TextFieldTableCell.forTableColumn());
//					cCWC4.setOnEditCommit((TableColumn.CellEditEvent<CarWashCompany, String> t) -> {
//						t.getTableView().getItems().get(t.getTablePosition().getRow()).setPhoneNumber(t.getNewValue());
//						updatePhoneNumber_CWC(t.getRowValue().getCompanyNumber(), t.getRowValue().getPhoneNumber());
//					});
//					
//					cCWC5.setCellFactory(TextFieldTableCell.forTableColumn());
//					cCWC5.setOnEditCommit((TableColumn.CellEditEvent<CarWashCompany, String> t) -> {
//						t.getTableView().getItems().get(t.getTablePosition().getRow()).setEmail(t.getNewValue());
//						updateEmail_CWC(t.getRowValue().getCompanyNumber(), t.getRowValue().getEmail());
//					});
//					cCWC6.setCellFactory(TextFieldTableCell.forTableColumn());
//					cCWC6.setOnEditCommit((TableColumn.CellEditEvent<CarWashCompany, String> t) -> {
//						t.getTableView().getItems().get(t.getTablePosition().getRow()).setLocation(t.getNewValue());
//						updateLocation_INC(t.getRowValue().getCompanyNumber(), t.getRowValue().getLocation());
//					});

		Scene scene4 = new Scene(new Group());
		scene4.setFill(gradient);
		CW_tableVeiw.getStyleClass().add("column-header-background");
		CW_tableVeiw.getStyleClass().add("table-view");
		P.getChildren().add(vbox_CW);
		return P;
	}

	// =======================methods ===============================
	public void insertData_CW(CarWashes CW) {

		try {
			System.out.println("INSERT INTO CarWashes VALUES (" + CW.getCouponNumber() + ",'" + CW.getCarNumber()
					+ "','" + CW.getValueFee() + "','" + CW.getDriverName() + "','" + CW.getEntryDate() + "', '"
					+ CW.getWashCompanyName() + "');");

			connectDB();
			ExecuteStatement("INSERT INTO CarWashes VALUES (" + CW.getCouponNumber() + ",'" + CW.getCarNumber() + "','"
					+ CW.getValueFee() + "','" + CW.getDriverName() + "','" + CW.getEntryDate() + "', '"
					+ CW.getWashCompanyName() + "');");

			con.close();
			System.out.println("Connection closed" + CW_data.size());

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void getData_CW() throws SQLException, ClassNotFoundException {

//					CouponNumber INT PRIMARY KEY,
//				    CarNumber INT,
//				    ValueFee DECIMAL(10, 2),
//				    DriverName VARCHAR(100),
//				    EntryDate DATE,
//				    WashCompanyName VARCHAR(255),

		String SQL;
		connectDB();
		System.out.println("Connection established");
		SQL = "select * from CarWashes ";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);
		while (rs.next()) {
			CW_data.add(new CarWashes(rs.getInt("CouponNumber"), rs.getInt("CarNumber"), rs.getDouble("ValueFee"),
					rs.getString("DriverName"), rs.getDate("EntryDate").toLocalDate(),
					rs.getString("WashCompanyName")));

		}

		rs.close();
		stmt.close();

		con.close();
		System.out.println("Connection closed" + CW_data.size());
	}

	public void deleteRow_CW(CarWashes CW) {
		try {
			System.out.println("delete from CarWashes where CouponNumber=" + CW.getCouponNumber() + ";");
			connectDB();
			ExecuteStatement("delete from CarWashes where CouponNumber=" + CW.getCouponNumber() + ";");
			con.close();
			System.out.println("Connection closed");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
