package com.rays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.UserJavaBean;

public class UserMarks {
	public int nextPk() throws Exception {
		int pk = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select max(id) from marks");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
			System.out.println("Max ID: " + pk);
		}

		return pk + 1;
	}

	public void add(UserJavaBean beans) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("insert into marks values(?,?,?,?,?,?,?)");

		pstmt.setInt(1, nextPk());
		pstmt.setString(2, beans.getFirstName());
		pstmt.setString(3, beans.getLastName());
		pstmt.setInt(4, beans.getRollNo());
		pstmt.setInt(5, beans.getChemistry());
		pstmt.setInt(6, beans.getPhysics());
		pstmt.setInt(7, beans.getMaths());

		int i = pstmt.executeUpdate();

		System.out.println("Data inserted successfully." + i);

	}

	public void update(int userId) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");
		PreparedStatement ps = conn
				.prepareStatement("UPDATE marks SET firstname = 'Monti',lastname = 'Singh Pawar' WHERE id = ?");

		ps.setInt(1, userId);

		ps.executeUpdate();
		System.out.println("User with ID " + userId + " updated successfully.");

	}

	public void delete(int userId) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");
		PreparedStatement ps = conn.prepareStatement("DELETE FROM marks WHERE id = ?");

		ps.setInt(1, userId);

		ps.executeUpdate();
		System.out.println("User with ID " + userId + " deleted successfully.");

	}

	public List search() throws Exception {
		String sql = "SELECT * FROM your_table_name";
		List list = new ArrayList();
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				UserJavaBean bean = new UserJavaBean();
				bean.setId(rs.getInt("id"));
				bean.setFirstName(rs.getString("firstName"));
				bean.setLastName(rs.getString("lastName"));
				bean.setRollNo(rs.getInt("rollNo"));
				bean.setChemistry(rs.getInt("chemistry"));
				bean.setPhysics(rs.getInt("physics"));
				bean.setMaths(rs.getInt("maths"));
				list.add(bean);
			}
		}
		return null;
	}

	public UserJavaBean findByRollNo1(int rollNo) throws Exception {

		UserJavaBean bean = new UserJavaBean();

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM marks WHERE rollNo = ?");

		ps.setInt(1, rollNo);

		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			
			
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setRollNo(rs.getInt(4));
			bean.setPhysics(rs.getInt(5));
			bean.setChemistry(rs.getInt(6));
			bean.setMaths(rs.getInt(7));
		}
		return bean;

	}

	private Connection getConnection() {
		return null;
	}

	public UserJavaBean findByPk(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public void findByRollNo(int rollNo) {
		// TODO Auto-generated method stub

	}

}