package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.bean;
import beans.query;

public class SQLconnection {

	static Connection conn = null;
	static PreparedStatement stmt = null;
	static ResultSet rs = null;

	public static boolean connectSQL() {

		try {


			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (Exception ex) {
			System.out.println("Exception Driver " + ex.getMessage());
			return false;
		}

		try {

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_project2", "root", "root");

			return true;

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			return false;
		}

	}

	public static ArrayList<bean> stateSQL(String SearchWordinDatabase, ArrayList<bean> dataAnswer) {

		try {
			String requestQuery = query.getQuery();

			stmt = conn.prepareStatement(requestQuery);

			for (int f = 1; f <= 17; f++) {
				stmt.setString(f, "%" + SearchWordinDatabase + "%");
			}

			rs = stmt.executeQuery();

			while (rs.next()) {

				bean sqlBean = new bean();

				sqlBean.setId(rs.getString("id"));
				sqlBean.setSCP(rs.getString("sCP"));
				sqlBean.setTitle(rs.getString("title"));
				sqlBean.setRating(rs.getString("rating"));
				sqlBean.setClassification(rs.getString("classification"));
				sqlBean.setType(rs.getString("type"));
				sqlBean.setRelated_GOI_s(rs.getString("related_GOI_s"));
				sqlBean.setLocation_Notes(rs.getString("location_Notes"));
				sqlBean.setAuthor(rs.getString("author"));
				sqlBean.setLeaked_info(rs.getString("leaked_info"));
				sqlBean.setHumanoid_or_Structure(rs.getString("humanoid_or_Structure"));
				sqlBean.setAnimal_Computer_or_Extradimensional(rs.getString("animal_Computer_or_Extradimensional"));
				sqlBean.setAutonomous_or_Cognitohazard(rs.getString("autonomous_or_Cognitohazard"));
				sqlBean.setArtifact_Location_or_Sentient(rs.getString("artifact_Location_or_Sentient"));
				sqlBean.setSummary(rs.getString("summary"));
				sqlBean.setGender(rs.getString("gender"));
				sqlBean.setNone(rs.getString("none"));
				sqlBean.setEthnicity_Origins(rs.getString("ethnicity_Origins"));

				dataAnswer.add(sqlBean);

			}
			rs.close();
			conn.endRequest();
			conn.close();

			return dataAnswer;

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		return null;
	}

}