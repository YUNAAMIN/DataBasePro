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
public class table_totalCarRequest {
	/**
	 * @param args the command line arguments
	 * 
	 * 
	 */
	private ArrayList<totalcarrequest> data;
	private ObservableList<totalcarrequest> dataList;

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

	public table_totalCarRequest() {

	}

	public Pane requesttable(Stage stage) throws Exception {
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

	@SuppressWarnings("unchecked")

	private Pane tableView(Stage stage) {
		Pane p = new Pane();
		// tableveiw=======================================================================
		TableView<totalcarrequest> tableVeiw = new TableView<totalcarrequest>();
		tableVeiw.setStyle("-fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5); "
				+ "-fx-border-width: 3px; " + "-fx-border-radius: 5px; "
				+ "-fx-background-color: linear-gradient(to bottom, #cfeccb, #81dbf5);");
		TableColumn<totalcarrequest, Integer> column1 = new TableColumn<totalcarrequest, Integer>("RequestNumber");
		column1.setCellValueFactory(new PropertyValueFactory<totalcarrequest, Integer>("RequestNumber"));

		TableColumn<totalcarrequest, String> column2 = new TableColumn<totalcarrequest, String>("DriverName");
		column2.setCellValueFactory(new PropertyValueFactory<totalcarrequest, String>("DriverName"));

		TableColumn<totalcarrequest, String> column4 = new TableColumn<totalcarrequest, String>("DepartmentName");
		column4.setCellValueFactory(new PropertyValueFactory<totalcarrequest, String>("DepartmentName"));

		TableColumn<totalcarrequest, String> column5 = new TableColumn<totalcarrequest, String>("DepartureLocation");
		column5.setCellValueFactory(new PropertyValueFactory<totalcarrequest, String>("DepartureLocation"));

		TableColumn<totalcarrequest, String> column6 = new TableColumn<totalcarrequest, String>("DestinationLocation");
		column6.setCellValueFactory(new PropertyValueFactory<totalcarrequest, String>("DestinationLocation"));

		TableColumn<totalcarrequest, String> column7 = new TableColumn<totalcarrequest, String>("RequestStatus");
		column7.setCellValueFactory(new PropertyValueFactory<totalcarrequest, String>("RequestStatus"));

		TableColumn<totalcarrequest, LocalDate> column8 = new TableColumn<totalcarrequest, LocalDate>("RequestDate");
		column8.setCellValueFactory(new PropertyValueFactory<totalcarrequest, LocalDate>("RequestDate"));

		TableColumn<totalcarrequest, String> column9 = new TableColumn<totalcarrequest, String>("VehicleType");
		column9.setCellValueFactory(new PropertyValueFactory<totalcarrequest, String>("VehicleType"));

		TableColumn<totalcarrequest, String> column10 = new TableColumn<totalcarrequest, String>("FleetOfficerName");
		column10.setCellValueFactory(new PropertyValueFactory<totalcarrequest, String>("FleetOfficerName"));

		// panes===========================================================================================
		VBox vbtittle = new VBox(5);
		final VBox vbox = new VBox();
		HBox hb1 = new HBox(10);

		// labeles==============================================================================================
		Label lbTittle = new Label("totalcarrequest TableVeiw");
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
//
//		// Set the linear gradient as the fill for the scene
//		scene.setFill(gradient);

		scene.setFill(Color.web("#123a4e"));

		stage.setTitle("totalcarrequest Table");
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
		Label lb1 = new Label("request number");
		Label lb2 = new Label("driver name");
		Label lb4 = new Label("department name");
		Label lb5 = new Label("departure location");
		Label lb6 = new Label("destination location");
		Label lb7 = new Label("request status");
		Label lb8 = new Label("RequestDate");
		Label lb9 = new Label("vehicle type");
		Label lb10 = new Label("fleet officer name");

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
		TextField RequestNumber = new TextField();
		TextField DriverName = new TextField();
		TextField DepartmentName = new TextField();
		TextField departureLocation = new TextField();
		TextField DestinationLocation = new TextField();
		TextField VehicleType = new TextField();
		TextField FleetOfficerNameget = new TextField();

		// RequestDatepicker==============================================
		DatePicker RequestDate = new DatePicker();

		// radiobuttons========================================================
		ToggleGroup group1 = new ToggleGroup();
		// 'owned', 'rental', 'substitute','taxi'
		RadioButton rb11 = new RadioButton("owned");
		RadioButton rb12 = new RadioButton("rental");
		RadioButton rb13 = new RadioButton("substitute");
		RadioButton rb14 = new RadioButton("taxi");

		rb11.setToggleGroup(group1);
		rb12.setToggleGroup(group1);
		rb13.setToggleGroup(group1);
		rb14.setToggleGroup(group1);

		rb11.setTextFill(Color.web("#dadede"));
		rb12.setTextFill(Color.web("#dadede"));
		rb13.setTextFill(Color.web("#dadede"));
		rb14.setTextFill(Color.web("#dadede"));

		rb11.setFont(normal);
		rb12.setFont(normal);
		rb13.setFont(normal);
		rb14.setFont(normal);
		//('approved', 'pending', 'rejected
		ToggleGroup group2 = new ToggleGroup();
		// 'owned', 'rental', 'substitute','taxi'
		RadioButton rb1 = new RadioButton("approved");
		RadioButton rb2 = new RadioButton("pending");
		RadioButton rb3 = new RadioButton("rejected");

		rb1.setToggleGroup(group2);
		rb2.setToggleGroup(group2);
		rb3.setToggleGroup(group2);

		rb1.setTextFill(Color.web("#dadede"));
		rb2.setTextFill(Color.web("#dadede"));
		rb3.setTextFill(Color.web("#dadede"));

		rb1.setFont(normal);
		rb2.setFont(normal);
		rb3.setFont(normal);

		gridpane.addRow(0, lb1, RequestNumber);
		gridpane.addRow(1, lb2, DriverName);
		gridpane.addRow(2, lb4, DepartmentName);
		gridpane.addRow(3, lb5, departureLocation);
		gridpane.addRow(4, lb6, DestinationLocation);
		gridpane.addRow(5, lb7, rb1, rb2, rb3);
		gridpane.addRow(6, lb8, RequestDate);
		gridpane.addRow(7, lb9, rb11, rb12, rb13, rb14);
		gridpane.addRow(8, lb10, FleetOfficerNameget);
		gridpane.setPadding(new Insets(10, 10, 10, 10));
		gridpane.setHgap(10);
		gridpane.setVgap(10);
		gridpane.setStyle(" -fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5);\r\n"
				+ "    -fx-border-width: 3px;\r\n" + "    -fx-border-radius: 5px;");

		// button
		// handler=======================================================================================================
		btadd.setOnAction(e -> {

			RadioButton selected1 = (RadioButton) group1.getSelectedToggle();
			RadioButton selected2 = (RadioButton) group2.getSelectedToggle();

			totalcarrequest c = new totalcarrequest(Integer.valueOf(RequestNumber.getText()), // Assuming you have a
																								// TextField named
																								// RequestNumberTextField
					DriverName.getText(), DepartmentName.getText(), departureLocation.getText(),
					DestinationLocation.getText(), selected2.getText(), RequestDate.getValue(), // Assuming you have
					// a
					// RequestDatePicker named
					// RequestDateRequestDatePicker
					selected1.getText(), FleetOfficerNameget.getText());
//			 RequestNumber,
//		    DriverName,
//		    DepartmentName,
//		    DepartureLocation,
//		    DestinationLocation,
//		    RequestStatus,
//		    RequestRequestDate,
//		    VehicleType,
//		    FleetOfficerName
			dataList.add(c);
			insertData(c);

		});

		btdelete.setOnAction(e -> {
			ObservableList<totalcarrequest> selectedRows = tableVeiw.getSelectionModel().getSelectedItems();
			ArrayList<totalcarrequest> rows = new ArrayList<>(selectedRows);
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

		// upRequestDate info in driver
		// table==================================================

		column4.setCellFactory(TextFieldTableCell.forTableColumn());
		column4.setOnEditCommit((TableColumn.CellEditEvent<totalcarrequest, String> t) -> {
			t.getTableView().getItems().get(t.getTablePosition().getRow()).setDepartmentName(t.getNewValue());
			upRequestDatePhone(t.getRowValue().getRequestNumber(), t.getRowValue().getDepartmentName());
		});

		column2.setCellFactory(TextFieldTableCell.forTableColumn());
		column2.setOnEditCommit((TableColumn.CellEditEvent<totalcarrequest, String> t) -> {
			t.getTableView().getItems().get(t.getTablePosition().getRow()).setDriverName(t.getNewValue());
			upRequestDateDriverName(t.getRowValue().getRequestNumber(), t.getRowValue().getDriverName());
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

//		((Group) scene.getRoot()).getChildren().addAll(vbox);
//		stage.setScene(scene);

		p.getChildren().add(vbox);

		return p;
	}

	public void insertData(totalcarrequest c) {
		try {
			connectDB();

			String sql = "INSERT INTO totalcarrequests (RequestNumber, DriverName, DepartmentName, "
					+ "DepartureLocation, DestinationLocation, RequestStatus, RequestDate, VehicleType, FleetOfficerName) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);

			preparedStatement.setInt(1, c.getRequestNumber());
			preparedStatement.setString(2, c.getDriverName());
			preparedStatement.setString(3, c.getDepartmentName());
			preparedStatement.setString(4, c.getDepartureLocation());
			preparedStatement.setString(5, c.getDestinationLocation());
			preparedStatement.setString(6, c.getRequestStatus());
			preparedStatement.setDate(7, java.sql.Date.valueOf(c.getRequestDate()));
			preparedStatement.setString(8, c.getVehicleType());
			preparedStatement.setString(9, c.getFleetOfficerName());

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

		SQL = "select * from totalcarrequests ";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);

		while (rs.next()) {
			data.add(new totalcarrequest(rs.getInt("RequestNumber"), // Correct the column name here
					rs.getString("DriverName"), rs.getString("DepartmentName"), rs.getString("DepartureLocation"),
					rs.getString("DestinationLocation"), rs.getString("RequestStatus"),
					rs.getDate("RequestDate").toLocalDate(), rs.getString("VehicleType"),
					rs.getString("FleetOfficerName")));
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

	public void upRequestDatePhone(int RequestNumber, String phone) {

		try {
			System.out.println("update  totalcarrequests set  DepartmentName = '" + phone + "' where RequestNumber = "
					+ RequestNumber);
			connectDB();
			ExecuteStatement("update  totalcarrequests set  DepartmentName = '" + phone + "' where RequestNumber = "
					+ RequestNumber + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void upRequestDateDriverName(int requestnum, String employeeName) {

		try {
			System.out.println("update  totalcarrequests set  DriverName = '" + employeeName
					+ "' where RequestNumber = " + requestnum);
			connectDB();
			ExecuteStatement("update  totalcarrequests set DriverName = '" + employeeName + "' where RequestNumber = "
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

	public void deleteRow(totalcarrequest c) {
		try {
			System.out.println("delete from totalcarrequests where RequestNumber=" + c.getRequestNumber() + ";");
			connectDB();
			ExecuteStatement("delete from totalcarrequests where RequestNumber=" + c.getRequestNumber() + ";");
			con.close();
			System.out.println("Connection closed");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void showDialog(Window owner, Modality modality, TableView<totalcarrequest> table) {
		// Create a Stage with specified owner and modality
		Stage stage = new Stage();
		stage.initOwner(owner);
		stage.initModality(modality);
		// Label modalityLabel = new Label(modality.toString());

		Button yesButton = new Button("Confirm");
		yesButton.setOnAction(e -> {
			for (totalcarrequest row : dataList) {
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

	private void displayIntroImage(Stage stage) {

		// String introImageURL =
		// "https://mir-s3-cdn-cf.behance.net/projects/404/60bc84144780059.Y3JvcCwxOTIzLDE1MDQsMzgsMzQy.jpg";
		// // Change the path accordingly
		String introImageURL = "https://theminers.ps/uploads/images/2023/08/su1M1.png";
		Image introImage = new Image(introImageURL);
		ImageView imageView = new ImageView(introImage);
		imageView.setFitHeight(stage.getHeight());
		imageView.setFitWidth(stage.getWidth());

		// imageView.setOpacity(0);

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

}
