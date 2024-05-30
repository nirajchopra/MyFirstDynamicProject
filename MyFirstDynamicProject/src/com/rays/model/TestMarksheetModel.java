package com.rays.model;

import java.sql.SQLException;
import java.util.List;

import com.rays.bean.MarksheetBean;


public class TestMarksheetModel {
	public static void main(String[] args) throws Exception {

//		testAdd();
//		testUpdate();
//		testDelete();
//		testSearch();
//		testFindByPk();
//		testFindByRollNo();

	}

	private static void testFindByRollNo() throws Exception {
		MarksheetModel marks = new MarksheetModel();
		MarksheetBean bean = new MarksheetBean();
		bean = marks.findByRollNo1(101);
		if(bean != null) {
			System.out.println(bean.getRollNo());
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getPhysics());
			System.out.println(bean.getChemistry());
			System.out.println(bean.getMaths());
		}else {
			System.out.println("Roll No is not found");
		}
	}

	private static void testFindByPk() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		MarksheetModel marks = new MarksheetModel();
		bean = marks.findByPk(6);

		if (bean != null) {

			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());

		} else {

			System.out.println("user not found");

		}

	}

	private static void testSearch() throws Exception {
		MarksheetModel marks = new MarksheetModel();
		List<MarksheetBean> list = marks.search();

		if (list != null && !list.isEmpty()) {
			for (MarksheetBean bean : list) {
				System.out.println(bean.getRollNo());
				System.out.println(bean.getId());
				System.out.println(bean.getFirstName());
				System.out.println(bean.getLastName());
				System.out.println(bean.getPhysics());
				System.out.println(bean.getChemistry());
				System.out.println(bean.getMaths());
			}
		} else {
			System.out.println("No user marks found.");
		}
	}

	private static void testDelete() throws Exception {
		MarksheetModel marks = new MarksheetModel();
		int d = 5;
		marks.delete(d);
	}

	private static void testUpdate() throws Exception {
		MarksheetModel marks = new MarksheetModel();
		int i = 8;
		marks.update(i);

	}

	private static void testAdd() throws Exception {
		MarksheetBean beans = new MarksheetBean();
		MarksheetModel marks = new MarksheetModel();

		beans.setFirstName("Vishnu");
		beans.setLastName("Prajapati");
		beans.setRollNo(110);
		beans.setChemistry(80);
		beans.setPhysics(85);
		beans.setMaths(90);

		marks.add(beans);
	}

}