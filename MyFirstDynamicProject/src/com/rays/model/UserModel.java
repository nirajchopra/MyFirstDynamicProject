package com.rays.model;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.rays.bean.UserBean;
import com.rays.util.JDBCDataSource;

public class UserModel {

	public int nextPk() throws Exception {

		int pk = 0;

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("select max(id) from users");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			pk = rs.getInt(1);

			System.out.println("max id = " + pk);

		}
		return pk + 1;
	}


	public void add(UserBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcAdvance", "root", "root");
		PreparedStatement ps = conn.prepareStatement("INSERT INTO jdbc VALUES (?, ?, ?, ?, ?, ?, ?)");

		ps.setInt(1, nextPk());
		ps.setString(2, bean.getFirstName());
		ps.setString(3, bean.getLastName());
		ps.setString(4, bean.getLoginId());
		ps.setString(5, bean.getPassword());
		ps.setString(6, bean.getAddress());

		ps.executeUpdate();
		System.out.println("Data inserted successfully.");

	}

	public void update(int userId) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcAdvance", "root", "root");
				PreparedStatement ps = conn
						.prepareStatement("UPDATE jdbc SET firstname = 'Shiv',lastname = 'Chopra' WHERE id = ?")) {

			ps.setInt(1, userId);

			ps.executeUpdate();
			System.out.println("User with ID " + userId + " updated successfully.");
		}
	}

	public void delete(int userId) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcAdvance", "root", "root");
		PreparedStatement ps = conn.prepareStatement("DELETE FROM jdbc WHERE id = ?");

		ps.setInt(1, userId);

		ps.executeUpdate();
		System.out.println("User with ID " + userId + " deleted successfully.");

	}

	public UserBean findByPk(int id) throws Exception {
		UserBean bean = null;

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcAdvance", "root", "root");
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM jdbc WHERE id = ?");

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));
		}

		return bean;
	}

	public void findByLoginId(String loginId) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcAdvance", "root", "root");
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM jdbc WHERE loginId = ?");

		ps.setString(1, loginId);

		ResultSet rs = ps.executeQuery();
		if (rs.next()) {

			System.out.println("ID: " + rs.getInt("id") + ", First Name: " + rs.getString("firstName") + ", Last Name: "
					+ rs.getString("lastname") + ", LoginId: " + rs.getString("loginId") + ", Password: "
					+ rs.getString("password") + ", Address: " + rs.getString("address"));
		} else {
			System.out.println("User not found for login ID: " + loginId);
		}

	}

	public List search(UserBean bean) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcAdvance", "root", "root");
		StringBuilder sql = new StringBuilder("select * from jdbc where 1=1");

		if (bean != null) {
			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				sql.append(" and firstName like ?");
			}
		}

		System.out.println("sql===> " + sql.toString());
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		int i = 1;
		if (bean != null && bean.getFirstName() != null && bean.getFirstName().length() > 0) {
			pstmt.setString(i++, bean.getFirstName() + "%");
		}

		ResultSet rs = pstmt.executeQuery();
		List list = new ArrayList();

		while (rs.next()) {
			UserBean user = new UserBean();
			user.setId(rs.getInt(1));
			user.setFirstName(rs.getString(2));
			user.setLastName(rs.getString(3));
			user.setLoginId(rs.getString(4));
			user.setPassword(rs.getString(5));
			user.setAddress(rs.getString(6));
			list.add(user);
		}

		// Close resources
		rs.close();
		pstmt.close();
		conn.close();

		return list;
//	public ResultSet search() throws Exception {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcAdvance", "root", "root");
//
//		PreparedStatement ps = conn.prepareStatement("SELECT * FROM jdbc");
//
//		return ps.executeQuery();
	}

	public UserBean authenticate(String login, String pwd) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcAdvance", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("select * from jdbc where LoginId = ? and password = ?");

		pstmt.setString(1, login);
		pstmt.setString(2, pwd);

		ResultSet rs = pstmt.executeQuery();
		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));

		}
		return bean;

	}

}