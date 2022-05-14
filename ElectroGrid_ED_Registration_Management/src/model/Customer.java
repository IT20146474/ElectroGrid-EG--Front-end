package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Customer {
	// A common method to connect to the DB
	private Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electrogrid", "root", "");

			// For testing
			System.out.print("Successfully connected");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	public String readCustomer() {
		String output = "";

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			// Prepare the html table to be displayed
			output = "<table border='1'><tr><th>Customer Name</th>" + "<th>Customer Email</th><th>Customer Address</th>"
					+ "<th>Customer Phone Number</th>" + "<th>Update</th><th>Delete</th></tr>";

			String query = "select * from customer";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {

				String customerID = Integer.toString(rs.getInt("customerID"));
				String regName = rs.getString("regName");
				String regEmail = rs.getString("regEmail");
				String regAddress = rs.getString("regAddress");
				String regPNo = Integer.toString(rs.getInt("regPNo"));

				// Add into the html table

				output += "<tr><td><input id='hidcustomerIDUpdate' name='hidcustomerIDUpdate' type='hidden' value='"
						+ customerID + "'>" + regName + "</td>";

				output += "<td>" + regEmail + "</td>";
				output += "<td>" + regAddress + "</td>";
				output += "<td>" + regPNo + "</td>";

				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate'></td>"
						+ "<td><input name='btnRemove' type='button' value='Delete' class='btnRemove' data-customerID='"
						+ customerID + "'>" + "</td></tr>";

			}

			con.close();

			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the Customer Details.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	// Insert Customer
	public String insertCustomer(String regName, String regEmail, String regAddress,
			String regPNo) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database";
			}

			// create a prepared statement
			String query = " insert into customer (`customerID`,`regName`,`regEmail`,`regAddress`,`regPNo`)"
					+ " values (?, ?, ?, ?, ?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, regName);
			preparedStmt.setString(3, regEmail);
			preparedStmt.setString(4, regAddress);
			preparedStmt.setString(5, regPNo);

			// execute the statement
			preparedStmt.execute();
			con.close();

			// Create JSON Object to show successful msg.
			String newCustomer = readCustomer();
			output = "{\"status\":\"success\", \"data\": \"" + newCustomer + "\"}";
		} catch (Exception e) {
			// Create JSON Object to show Error msg.
			output = "{\"status\":\"error\", \"data\": \"Error while Inserting Customer.\"}";
			System.err.println(e.getMessage());
		}

		return output;
	}

	// Update Customer
	public String updateCustomer(String customerID, String regName, String regEmail, String regAddress,
			String regPNo) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE customer SET regName=?,regEmail=?,regAddress=?,regPNo=? WHERE customerID=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, regName);
			preparedStmt.setString(2, regEmail);
			preparedStmt.setString(3, regAddress);
			preparedStmt.setInt(4, Integer.parseInt(regPNo));
			preparedStmt.setInt(5, Integer.parseInt(customerID));

			// execute the statement
			preparedStmt.execute();
			con.close();

			// create JSON object to show successful msg
			String newCustomer = readCustomer();
			output = "{\"status\":\"success\", \"data\": \"" + newCustomer + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while Updating Customer Details.\"}";
			System.err.println(e.getMessage());
		}

		return output;
	}

	public String deleteCustomer(String customerID) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "DELETE FROM customer WHERE customerID=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(customerID));
			// execute the statement
			preparedStmt.execute();
			con.close();

			// create JSON Object
			String newCustomer = readCustomer();
			output = "{\"status\":\"success\", \"data\": \"" + newCustomer + "\"}";
		} catch (Exception e) {
			// Create JSON object
			output = "{\"status\":\"error\", \"data\": \"Error while Deleting Customer.\"}";
			System.err.println(e.getMessage());

		}

		return output;
	}

}
