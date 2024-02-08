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
public class table_fleetofficer {
	public table_fleetofficer() {

	}

	/**
	 * @param args the command line arguments
	 * 
	 * 
	 */
	private ArrayList<fleetofficer> data;
	private ObservableList<fleetofficer> dataList;

	private static String dbUserName = "root"; // database userName
	//private static String dbPassword = "yunayuna123"; // database password
	private static String dbPassword = "yunayuna123"; // database password

	private static String URL = "127.0.0.1"; // server location

	private static String port = "3306"; // port that mysql uses
	private static String dbName = "miniFleetsystem"; // database on mysql to connect to
	private String dbURL;
	private Connection con;

//	private static String dbUserName = "root"; // database userName
//	private static String dbPassword = "yunayuna123"; // database password
//	private static String URL = "127.0.0.1"; // server location
//
//	private static String port = "3306"; // port that mysql uses
//	private static String dbName = "carfleet"; // database on mysql to connect to
//	private String dbURL;
//	private Connection con;

	public static void main(String[] args) {

		Application.launch(args);
	}

	@SuppressWarnings("unchecked")
	public Pane fleettable(Stage stage) throws Exception {
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
		TableView<fleetofficer> tableVeiw = new TableView<fleetofficer>();

		tableVeiw.setStyle("-fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5); "
				+ "-fx-border-width: 3px; " + "-fx-border-radius: 5px; "
				+ "-fx-background-color: linear-gradient(to bottom, #cfeccb, #81dbf5);");
		TableColumn<fleetofficer, Integer> column1 = new TableColumn<fleetofficer, Integer>("EmployeeID");
		column1.setCellValueFactory(new PropertyValueFactory<fleetofficer, Integer>("EmployeeID"));

		TableColumn<fleetofficer, String> column2 = new TableColumn<fleetofficer, String>("FleetOfficersName");
		column2.setCellValueFactory(new PropertyValueFactory<fleetofficer, String>("FleetOfficersName"));

		TableColumn<fleetofficer, String> column4 = new TableColumn<fleetofficer, String>("PhoneNumber");
		column4.setCellValueFactory(new PropertyValueFactory<fleetofficer, String>("PhoneNumber"));

		TableColumn<fleetofficer, String> column5 = new TableColumn<fleetofficer, String>("Email");
		column5.setCellValueFactory(new PropertyValueFactory<fleetofficer, String>("Email"));

		TableColumn<fleetofficer, String> column6 = new TableColumn<fleetofficer, String>("DepartmentName");
		column6.setCellValueFactory(new PropertyValueFactory<fleetofficer, String>("DepartmentName"));

		TableColumn<fleetofficer, String> column7 = new TableColumn<fleetofficer, String>("WorkLocation");
		column7.setCellValueFactory(new PropertyValueFactory<fleetofficer, String>("WorkLocation"));

		// panes===========================================================================================
		VBox vbtittle = new VBox(5);
		final VBox vbox = new VBox();
		HBox hb1 = new HBox(10);

		// labeles==============================================================================================
		Label lbTittle = new Label("fleetofficer TableVeiw");
		Font fbold = Font.font("IMPACT", FontWeight.BLACK, FontPosture.REGULAR, 35);
		lbTittle.setFont(fbold);
		lbTittle.setStyle("-fx-text-fill:linear-gradient(to bottom, #cfeccb, #81dbf5); ");// #2d5d7a;
//
		// lbTittle.setStyle("-fx-text-fill: #2d5d7a;");

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
//		scene.setFill(gradient);
		scene.setFill(Color.web("#123a4e"));

		stage.setTitle("fleetofficer Table");
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

		tableVeiw.getColumns().addAll(column1, column2, column4, column5, column6, column7);

		// pane=========================================================
		GridPane gridpane = new GridPane();

		// labels============================================================
		Label lb1 = new Label(" EmployeeID");
		Label lb2 = new Label("Fleet Officers Name");
		Label lb4 = new Label("phone number");
		Label lb5 = new Label("Email");
		Label lb6 = new Label("department Name");
		Label lb7 = new Label("work location");

		lb1.setTextFill(Color.web("#dadede"));
		lb2.setTextFill(Color.web("#dadede"));
		lb4.setTextFill(Color.web("#dadede"));
		lb5.setTextFill(Color.web("#dadede"));
		lb7.setTextFill(Color.web("#dadede"));
		lb6.setTextFill(Color.web("#dadede"));

		lb1.setFont(normal);
		lb2.setFont(normal);
		lb4.setFont(normal);
		lb5.setFont(normal);
		lb6.setFont(normal);
		lb7.setFont(normal);

		// textfeild====================================================
		TextField EmployeeID = new TextField();
		TextField FleetOfficersName = new TextField();
		TextField PhoneNumber = new TextField();
		TextField Email = new TextField();
		TextField DepartmentName = new TextField();
		TextField WorkLocation = new TextField();

		// radiobuttons========================================================

		gridpane.addRow(0, lb1, EmployeeID);
		gridpane.addRow(1, lb2, FleetOfficersName);
		gridpane.addRow(2, lb4, PhoneNumber);
		gridpane.addRow(3, lb5, Email);
		gridpane.addRow(4, lb6, DepartmentName);
		gridpane.addRow(5, lb7, WorkLocation);
		gridpane.setPadding(new Insets(10, 10, 10, 10));
		gridpane.setHgap(10);
		gridpane.setVgap(10);
		gridpane.setStyle(" -fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5);\r\n"
				+ "    -fx-border-width: 3px;\r\n" + "    -fx-border-radius: 5px;");

		// button
		// handler=======================================================================================================
		btadd.setOnAction(e -> {

			fleetofficer c = new fleetofficer(Integer.valueOf(EmployeeID.getText()), // Assuming you have a
					// TextField Named
					// requestNumberTextField
					FleetOfficersName.getText(), PhoneNumber.getText(), Email.getText(), DepartmentName.getText(),
					WorkLocation.getText());

			dataList.add(c);
			insertData(c);

		});

		btdelete.setOnAction(e -> {
			ObservableList<fleetofficer> selectedRows = tableVeiw.getSelectionModel().getSelectedItems();
			ArrayList<fleetofficer> rows = new ArrayList<>(selectedRows);
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

		column4.setCellFactory(TextFieldTableCell.forTableColumn());
		column4.setOnEditCommit((TableColumn.CellEditEvent<fleetofficer, String> t) -> {
			t.getTableView().getItems().get(t.getTablePosition().getRow()).setPhoneNumber(t.getNewValue());
			updatecarnum(t.getRowValue().getEmployeeID(), t.getRowValue().getPhoneNumber());
		});

		column2.setCellFactory(TextFieldTableCell.forTableColumn());
		column2.setOnEditCommit((TableColumn.CellEditEvent<fleetofficer, String> t) -> {
			t.getTableView().getItems().get(t.getTablePosition().getRow()).setFleetOfficersName(t.getNewValue());
			updatedriverName(t.getRowValue().getEmployeeID(), t.getRowValue().getFleetOfficersName());
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

	public void insertData(fleetofficer c) {
		try {
			connectDB();

			String sql = "INSERT INTO FleetOfficers(EmployeeID, FleetOfficersName, PhoneNumber, "
					+ "Email, DepartmentName, WorkLocation) " + "VALUES (?, ?, ?, ?, ?, ?)";

			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);

			preparedStatement.setInt(1, c.getEmployeeID());
			preparedStatement.setString(2, c.getFleetOfficersName());
			preparedStatement.setString(3, c.getPhoneNumber());
			preparedStatement.setString(4, c.getEmail());
			preparedStatement.setString(5, c.getDepartmentName());
			preparedStatement.setString(6, c.getWorkLocation());
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

		SQL = "select * from FleetOfficers ";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);

		while (rs.next()) {
			data.add(new fleetofficer(rs.getInt("EmployeeID"), // Correct the column Name here
					rs.getString("FleetOfficersName"), rs.getString("PhoneNumber"), rs.getString("Email"),
					rs.getString("DepartmentName"), rs.getString("WorkLocation")));
		}

		rs.close();
		stmt.close();

		con.close();
		System.out.println("Connection closed" + data.size());

	}

	private void connectDB() throws ClassNotFoundException, Exception {

		dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName + "?verifyServerCertificate=false";
		Properties p = new Properties();
		p.setProperty("user", dbUserName);
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

	public void updatecarnum(int fleetofficerNum, String phone) {

		try {
			System.out.println(
					"update  FleetOfficers set  PhoneNumber = '" + phone + "' where EmployeeID = " + fleetofficerNum);
			connectDB();
			ExecuteStatement("update  FleetOfficers set  PhoneNumber = '" + phone + "' where EmployeeID = "
					+ fleetofficerNum + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updatedriverName(int requestnum, String employeeName) {

		try {
			System.out.println("update  FleetOfficers set  FleetOfficersName = '" + employeeName
					+ "' where EmployeeID = " + requestnum);
			connectDB();
			ExecuteStatement("update  FleetOfficers set FleetOfficersName = '" + employeeName + "' where EmployeeID = "
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

	public void deleteRow(fleetofficer c) {
		try {
			System.out.println("delete from FleetOfficers where EmployeeID=" + c.getEmployeeID() + ";");
			connectDB();
			ExecuteStatement("delete from FleetOfficers where EmployeeID=" + c.getEmployeeID() + ";");
			con.close();
			System.out.println("Connection closed");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void showDialog(Window owner, Modality modality, TableView<fleetofficer> table) {
		// Create a Stage with specified owner and modality
		Stage stage = new Stage();
		stage.initOwner(owner);
		stage.initModality(modality);
		// Label modalityLabel = new Label(modality.toString());

		Button yesButton = new Button("Confirm");
		yesButton.setOnAction(e -> {
			for (fleetofficer row : dataList) {
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
