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
public class table_driver {
	public table_driver() {

	}

	/**
	 * @param args the command line arguments
	 * 
	 * 
	 */
	private ArrayList<drivers> data;
	private ObservableList<drivers> dataList;

	private static String dbUsername = "root"; // database username
	// private static String dbPassword = "yunayuna123"; // database password
	private static String dbPassword = "yunayuna123"; // database password

	private static String URL = "127.0.0.1"; // server location

	private static String port = "3306"; // port that mysql uses
	private static String dbName = "miniFleetsystem"; // database on mysql to connect to
	private String dbURL;
	private Connection con;

	public static void main(String[] args) {

		Application.launch(args);
	}

	public Pane drivertable(Stage stage) throws Exception {
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
		TableView<drivers> tableVeiw = new TableView<drivers>();
		tableVeiw.setStyle("-fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5); "
				+ "-fx-border-width: 3px; " + "-fx-border-radius: 5px; "
				+ "-fx-background-color: linear-gradient(to bottom, #cfeccb, #81dbf5);");

		TableColumn<drivers, Integer> column1 = new TableColumn<drivers, Integer>("employeeNumber");
		column1.setCellValueFactory(new PropertyValueFactory<drivers, Integer>("employeeNumber"));

		TableColumn<drivers, String> column2 = new TableColumn<drivers, String>("EmployeeName");
		column2.setCellValueFactory(new PropertyValueFactory<drivers, String>("EmployeeName"));

		TableColumn<drivers, String> column3 = new TableColumn<drivers, String>("PhoneNumber");
		column3.setCellValueFactory(new PropertyValueFactory<drivers, String>("PhoneNumber"));

		TableColumn<drivers, String> column4 = new TableColumn<drivers, String>("IdentificationCardNumber");
		column4.setCellValueFactory(new PropertyValueFactory<drivers, String>("IdentificationCardNumber"));

		TableColumn<drivers, LocalDate> column5 = new TableColumn<drivers, LocalDate>("licenceStartDate");
		column5.setCellValueFactory(new PropertyValueFactory<drivers, LocalDate>("licenceStartDate"));

		TableColumn<drivers, LocalDate> column6 = new TableColumn<drivers, LocalDate>("LicenceExpirationDate");
		column6.setCellValueFactory(new PropertyValueFactory<drivers, LocalDate>("LicenceExpirationDate"));

		TableColumn<drivers, String> column7 = new TableColumn<drivers, String>("Email");
		column7.setCellValueFactory(new PropertyValueFactory<drivers, String>("Email"));

		TableColumn<drivers, String> column8 = new TableColumn<drivers, String>("DepartmentName");
		column8.setCellValueFactory(new PropertyValueFactory<drivers, String>("DepartmentName"));

		TableColumn<drivers, String> column9 = new TableColumn<drivers, String>("DirectorateName");
		column9.setCellValueFactory(new PropertyValueFactory<drivers, String>("DirectorateName"));

		TableColumn<drivers, String> column10 = new TableColumn<drivers, String>("contractType");
		column10.setCellValueFactory(new PropertyValueFactory<drivers, String>("contractType"));

		TableColumn<drivers, String> column11 = new TableColumn<drivers, String>("WorkLocation");
		column11.setCellValueFactory(new PropertyValueFactory<drivers, String>("WorkLocation"));

		TableColumn<drivers, String> column12 = new TableColumn<drivers, String>("livingLocation");
		column12.setCellValueFactory(new PropertyValueFactory<drivers, String>("livingLocation"));

		TableColumn<drivers, LocalDate> column13 = new TableColumn<drivers, LocalDate>("EntryDate");
		column13.setCellValueFactory(new PropertyValueFactory<drivers, LocalDate>("EntryDate"));

		// panes===========================================================================================
		VBox vbtittle = new VBox(5);
		final VBox vbox = new VBox();
		HBox hb1 = new HBox(10);

		// labeles==============================================================================================
		Label lbTittle = new Label("drivers TableVeiw");
		Font fbold = Font.font("IMPACT", FontWeight.BLACK, FontPosture.REGULAR, 35);
		lbTittle.setFont(fbold);
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

		stage.setTitle("drivers Table");
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

		tableVeiw.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7, column8, column9,
				column10, column11, column12, column13);

		// pane=========================================================
		GridPane gridpane = new GridPane();

		// labels============================================================
		Label lb1 = new Label("employee number");
		Label lb2 = new Label("employee name");
		Label lb3 = new Label("phone number");
		Label lb4 = new Label("identification card number");
		Label lb5 = new Label("licence start date");
		Label lb6 = new Label("licence expiration date");
		Label lb7 = new Label(" Email");
		Label lb8 = new Label("department name");
		Label lb9 = new Label("directorate name");
		Label lb10 = new Label("contract type");
		Label lb11 = new Label("work location");
		Label lb12 = new Label("living location");
		Label lb13 = new Label("entry date");

		lb1.setTextFill(Color.web("#dadede"));
		lb2.setTextFill(Color.web("#dadede"));
		lb3.setTextFill(Color.web("#dadede"));
		lb4.setTextFill(Color.web("#dadede"));
		lb5.setTextFill(Color.web("#dadede"));
		lb7.setTextFill(Color.web("#dadede"));
		lb8.setTextFill(Color.web("#dadede"));
		lb9.setTextFill(Color.web("#dadede"));
		lb10.setTextFill(Color.web("#dadede"));
		lb11.setTextFill(Color.web("#dadede"));
		lb12.setTextFill(Color.web("#dadede"));
		lb13.setTextFill(Color.web("#dadede"));
		lb6.setTextFill(Color.web("#dadede"));

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

		// textfeild====================================================
		TextField employnum = new TextField();
		TextField employname = new TextField();
		TextField phonenum = new TextField();
		TextField identification = new TextField();
		TextField Email = new TextField();
		TextField department = new TextField();
		TextField directorate = new TextField();
		TextField workloc = new TextField();
		TextField livingloc = new TextField();

		// datepicker==============================================
		DatePicker start = new DatePicker();
		DatePicker end = new DatePicker();
		DatePicker entry = new DatePicker();

		// radiobuttons========================================================
		ToggleGroup group1 = new ToggleGroup();
		RadioButton rb11 = new RadioButton("full time");
		RadioButton rb12 = new RadioButton("part time");
		RadioButton rb13 = new RadioButton("training");
		rb11.setToggleGroup(group1);
		rb12.setToggleGroup(group1);
		rb13.setToggleGroup(group1);
		rb11.setTextFill(Color.web("#dadede"));
		rb12.setTextFill(Color.web("#dadede"));
		rb13.setTextFill(Color.web("#dadede"));
		rb11.setFont(normal);
		rb12.setFont(normal);
		rb13.setFont(normal);

		gridpane.addRow(0, lb1, employnum);
		gridpane.addRow(1, lb2, employname);
		gridpane.addRow(2, lb3, phonenum);
		gridpane.addRow(3, lb4, identification);
		gridpane.addRow(4, lb5, start);
		gridpane.addRow(5, lb6, end);
		gridpane.addRow(6, lb7, Email);
		gridpane.addRow(7, lb8, department);
		gridpane.addRow(8, lb9, directorate);
		gridpane.addRow(9, lb10, rb11, rb12, rb13);
		gridpane.addRow(10, lb11, workloc);
		gridpane.addRow(11, lb12, livingloc);
		gridpane.addRow(11, lb13, entry);

		gridpane.setPadding(new Insets(10, 10, 10, 10));
		gridpane.setHgap(10);
		gridpane.setVgap(10);
		gridpane.setStyle(" -fx-border-color: linear-gradient(to bottom, #cfeccb, #81dbf5);\r\n"
				+ "    -fx-border-width: 3px;\r\n" + "    -fx-border-radius: 5px;");

		// button
		// handler=======================================================================================================
		btadd.setOnAction(e -> {

			RadioButton selected1 = (RadioButton) group1.getSelectedToggle();

			drivers c = new drivers(Integer.valueOf(employnum.getText()), employname.getText(), phonenum.getText(),
					identification.getText(), start.getValue(), end.getValue(), Email.getText(), department.getText(),
					directorate.getText(), selected1.getText(), workloc.getText(), livingloc.getText(),
					entry.getValue());

			dataList.add(c);
			insertData(c);

		});

		btdelete.setOnAction(e -> {
			ObservableList<drivers> selectedRows = tableVeiw.getSelectionModel().getSelectedItems();
			ArrayList<drivers> rows = new ArrayList<>(selectedRows);
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

		column3.setCellFactory(TextFieldTableCell.forTableColumn());
		column3.setOnEditCommit((TableColumn.CellEditEvent<drivers, String> t) -> {
			t.getTableView().getItems().get(t.getTablePosition().getRow()).setPhoneNumber(t.getNewValue());
			updatePhone(t.getRowValue().getEmployeeNumber(), t.getRowValue().getPhoneNumber());
		});

		column2.setCellFactory(TextFieldTableCell.forTableColumn());
		column2.setOnEditCommit((TableColumn.CellEditEvent<drivers, String> t) -> {
			t.getTableView().getItems().get(t.getTablePosition().getRow()).setEmployeeName(t.getNewValue());
			updatEmployeeName(t.getRowValue().getEmployeeNumber(), t.getRowValue().getEmployeeName());
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

	public void insertData(drivers c) {
		try {
			connectDB();

			String sql = "INSERT INTO drivers (EmployeeNumber, EmployeeName, PhoneNumber, IdentificationCardNumber, "
					+ "licenceStartDate, LicenceExpirationDate, Email, DepartmentName, DirectorateName, "
					+ "contractType, WorkLocation, livingLocation, EntryDate) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);

			preparedStatement.setInt(1, c.getEmployeeNumber());
			preparedStatement.setString(2, c.getEmployeeName());
			preparedStatement.setString(3, c.getPhoneNumber());
			preparedStatement.setString(4, c.getIdentificationCardNumber());
			preparedStatement.setDate(5, java.sql.Date.valueOf(c.getLicenceStartDate()));
			preparedStatement.setDate(6, java.sql.Date.valueOf(c.getLicenceExpirationDate()));
			preparedStatement.setString(7, c.getEmail());
			preparedStatement.setString(8, c.getDepartmentName());
			preparedStatement.setString(9, c.getDirectorateName());
			preparedStatement.setString(10, c.getContractType());
			preparedStatement.setString(11, c.getWorkLocation());
			preparedStatement.setString(12, c.getLivingLocation());
			preparedStatement.setDate(13, java.sql.Date.valueOf(c.getEntryDate()));

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

		SQL = "select * from drivers ";
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

	public void updatePhone(int driverNum, String phone) {

		try {
			System.out
					.println("update  drivers set  PhoneNumber = '" + phone + "' where EmployeeNumber = " + driverNum);
			connectDB();
			ExecuteStatement(
					"update  drivers set  PhoneNumber = '" + phone + "' where EmployeeNumber = " + driverNum + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updatEmployeeName(int driverNum, String EmployeeName) {

		try {
			System.out.println(
					"update  drivers set  EmployeeName = '" + EmployeeName + "' where EmployeeNumber = " + driverNum);
			connectDB();
			ExecuteStatement("update  drivers set EmployeeName = '" + EmployeeName + "' where EmployeeNumber = "
					+ driverNum + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteRow(drivers c) {
		try {
			System.out.println("delete from drivers where EmployeeNumber=" + c.getEmployeeNumber() + ";");
			connectDB();
			ExecuteStatement("delete from drivers where EmployeeNumber=" + c.getEmployeeNumber() + ";");
			con.close();
			System.out.println("Connection closed");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void showDialog(Window owner, Modality modality, TableView<drivers> table) {
		// Create a Stage with specified owner and modality
		Stage stage = new Stage();
		stage.initOwner(owner);
		stage.initModality(modality);
		// Label modalityLabel = new Label(modality.toString());

		Button yesButton = new Button("Confirm");
		yesButton.setOnAction(e -> {
			for (drivers row : dataList) {
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
