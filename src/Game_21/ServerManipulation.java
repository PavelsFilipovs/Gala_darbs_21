package Game_21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ServerManipulation {
	
	public int getUserInformation(String user) {
		String userName = null;
		int balance = 0;
		
		Connection conn = null;

		try {

			String url = "jdbc:mysql://localhost:3306/game_21";
			String user1 = "root";
			String pass = "1234";
			conn = DriverManager.getConnection(url, user1, pass);

			Statement st = conn.createStatement();
			String sql = "SELECT * FROM game_21.user;";
			ResultSet result = st.executeQuery(sql);
			while (result.next()) {
				if (user.equals(result.getString(2))) {
					userName = result.getString(2);
					balance = result.getInt(3);
				} 
			}
			
			if (userName == null) {
				String sqlInsert = "INSERT INTO game_21.user (User_name, Balance) VALUES (?, ?);";
				PreparedStatement prepare = conn.prepareStatement(sqlInsert);
				prepare.setString(1, user);
				prepare.setInt(2, 0);
				prepare.execute();
				userName = user;
				balance = 0;
			}

			conn.close();

		} catch (SQLException e) {
			e.getMessage();
		}
		return balance;
	}
	
	public void toppedUpBalance(String user, int upBalance) {
		int balance = 0, userID = 0;
		Connection conn = null;

		try {

			String url = "jdbc:mysql://localhost:3306/game_21";
			String user1 = "root";
			String pass = "1234";
			conn = DriverManager.getConnection(url, user1, pass);

			Statement st = conn.createStatement();
			String sql = "SELECT * FROM game_21.user;";
			ResultSet result = st.executeQuery(sql);
			while (result.next()) {
				if (user.equals(result.getString(2))) {
					userID = result.getInt(1);
					balance = result.getInt(3);
				} 
			}
			balance = upBalance + balance;
			
			String query = "update game_21.user set Balance = ? where User_name = ?;";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt   (1, balance);
			preparedStmt.setString(2, user);
			
			preparedStmt.executeUpdate();
			
			
			conn.close();

		} catch (SQLException e) {
			e.getMessage();
		}
		
	}
	
	public void toppedDownBalance(String user, int upBalance) {
		int balance = 0, userID = 0;
		Connection conn = null;

		try {

			String url = "jdbc:mysql://localhost:3306/game_21";
			String user1 = "root";
			String pass = "1234";
			conn = DriverManager.getConnection(url, user1, pass);

			Statement st = conn.createStatement();
			String sql = "SELECT * FROM game_21.user;";
			ResultSet result = st.executeQuery(sql);
			while (result.next()) {
				if (user.equals(result.getString(2))) {
					userID = result.getInt(1);
					balance = result.getInt(3);
				} 
			}
			balance = balance - upBalance;
			
			String query = "update game_21.user set Balance = ? where User_name = ?;";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt   (1, balance);
			preparedStmt.setString(2, user);
			
			preparedStmt.executeUpdate();
			
			
			conn.close();

		} catch (SQLException e) {
			e.getMessage();
		}
		
	}
	
	public void deleteFromServerUserInformation(String user) {
		Connection conn = null;

		try {

			String url = "jdbc:mysql://localhost:3306/game_21";
			String user1 = "root";
			String pass = "1234";
			conn = DriverManager.getConnection(url, user1, pass);

			Statement st = conn.createStatement();
			
			String query = "DELETE FROM game_21.user WHERE User_name = ?;";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
		    preparedStmt.setString(1, user);
			
			preparedStmt.execute();
			
			
			conn.close();

		} catch (SQLException e) {
			e.getMessage();
		}
	}
}
