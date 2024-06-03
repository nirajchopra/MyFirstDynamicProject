package com.rays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.MarksheetBean;
import com.rays.util.JDBCDataSource;
import com.rays.bean.MarksheetBean;;

public class MarksheetModel {
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

	public void add(MarksheetBean beans) throws Exception {
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

	public void update(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");
		PreparedStatement ps = conn
				.prepareStatement("UPDATE marks SET firstname = 'Monti',lastname = 'Singh Pawar' WHERE id = ?");

		ps.setInt(1, bean.getRollNo());
		ps.setString(2, bean.getFirstName());
		ps.setString(3, bean.getLastName());
		ps.setInt(4, bean.getPhysics());
		ps.setInt(5, bean.getChemistry());
		ps.setInt(6, bean.getMaths());
		ps.setInt(7, bean.getId());

		ps.executeUpdate();
		System.out.println("User with ID " + bean + " updated successfully.");

	}

	public void delete(int userId) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");
		PreparedStatement ps = conn.prepareStatement("delete from marks where id = ?");

		ps.setInt(1, userId);

		ps.executeUpdate();
		System.out.println("User with ID " + userId + " deleted successfully.");

	}

	public List search() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");
		PreparedStatement pstm = conn.prepareStatement("select * from marks");
		System.out.println("connection successfullyyy");
		ResultSet rs = pstm.executeQuery();
		List list = new ArrayList();
		MarksheetBean bean = new MarksheetBean();
		if (rs != null) {

			System.out.println("data get success");

		}
		while (rs.next()) {
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setRollNo(rs.getInt(4));
			bean.setChemistry(rs.getInt(6));
			bean.setPhysics(rs.getInt(5));
			bean.setMaths(rs.getInt(7));
			list.add(bean);

		}
		return list;
	}

	public MarksheetBean findByRollNo1(int rollNo) throws Exception {

		MarksheetBean bean = new MarksheetBean();

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

	public MarksheetBean findByPk(int i) {
		return null;
	}

	public void findByRollNo(int rollNo) {

	}

}