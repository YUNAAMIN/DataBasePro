package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javafx.application.Application;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ReportView extends Application{
	

	public ReportView() {
		
	}
	private static String dbUsername = "root"; // database username
	private static String dbPassword = "yunayuna123"; // database password
	private static String URL = "127.0.0.1"; // server location

	private static String port = "3306"; // port that mysql uses
	private static String dbName = "miniFleetsystem"; // database on mysql to connect to
	private static String dbURL;
	private static Connection con;
	
	private static void connectDB() throws ClassNotFoundException, SQLException {

		try {
			dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName + "?verifyServerCertificate=false";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties p = new Properties();
		p.setProperty("user", dbUsername);
		p.setProperty("password", dbPassword);
		p.setProperty("useSSL", "false");
		p.setProperty("autoReconnect", "true");
		Class.forName("com.mysql.jdbc.Driver");

		con = DriverManager.getConnection(dbURL, p);

	}

	public static String ExecuteStatement(String sql) throws SQLException {

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
	static Font fnormal = Font.font("Arial", FontWeight.MEDIUM, FontPosture.REGULAR, 15);
	static Font fnorma2 = Font.font("Arial", FontWeight.BLACK, FontPosture.REGULAR, 17);

	static Font fnormalbold = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 20);
	Font ftittle = Font.font("impact", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 20);
	static ArrayList<String> ar = new ArrayList<>();
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

	public static Pane secreenreport() {
		//panes=========================================================
		Pane p =new Pane();
		
		//============
		ComboBox<String> combotable = new ComboBox<>();
		combotable.getItems().addAll(
                "Car",
                "CarRentalCompany",
                "Drivers",
                "FuelCompany",
                "Department",
                "InsuranceCompany",
                "CarDistribution",
                "CarWashCompany",
                "CarWashes",
                "CarTicket",
                "TaxiCompanies",
                "FuelCoupon",
                "FuelCard",
                "TotalCarRequests",
                "CarTrips",
                "TaxiTrips",
                "MaintenanceRecords",
                "AccidentsRecords",
                "FleetOfficers",
                "PersonalCarUse"
        );
		
		ComboBox<String> comboorder = new ComboBox<>();
		comboorder.getItems().addAll("ASC","DESC");	
		
		String temp = combotable.getSelectionModel().getSelectedItem().toString();
		
		
		
		ComboBox<String> comboattribute = new ComboBox<>();
		getAttributes(temp, ar);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return p;
		
	}
	
	
	
	
	
	
	
	
	


	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}}
