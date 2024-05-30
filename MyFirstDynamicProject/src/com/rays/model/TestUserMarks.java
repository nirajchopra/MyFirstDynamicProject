package com.rays.model;

import java.sql.SQLException;
import java.util.List;

import com.rays.bean.UserJavaBean;

public class TestUserMarks {
	public static void main(String[] args) throws Exception {

//		testAdd();
//		testUpdate();
//		testDelete();
//		testSearch();
//		testFindByPk();
		testFindByRollNo();

	}

	private static void testFindByRollNo() throws Exception {
		UserMarks marks = new UserMarks();
		UserJavaBean bean = new UserJavaBean();
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

	private static void testFindByPk() {
		UserMarks marks = new UserMarks();
		UserJavaBean beans = new UserJavaBean();

		beans = marks.findByPk(3);

		if (beans != null) {
			System.out.print(beans.getId());
			System.out.print(" " + beans.getFirstName());
			System.out.print(" " + beans.getLastName());
			System.out.print(" " + beans.getRollNo());
			System.out.print(" " + beans.getPhysics());
			System.out.print(" " + beans.getChemistry());
			System.out.print(" " + beans.getMaths());
		} else {
			System.out.println("User not found");
		}

	}

	private static void testSearch() throws Exception {
		UserMarks marks = new UserMarks();
		List<UserJavaBean> list = marks.search();

		if (list != null && !list.isEmpty()) {
			for (UserJavaBean bean : list) {
				System.out.println(
						bean.getId() + " " + bean.getFirstName() + " " + bean.getLastName() + " " + bean.getRollNo()
								+ " " + bean.getChemistry() + " " + bean.getPhysics() + " " + bean.getMaths());
			}
		} else {
			System.out.println("No user marks found.");
		}
	}

	private static void testDelete() throws Exception {
		UserMarks marks = new UserMarks();
		int d = 5;
		marks.delete(d);
	}

	private static void testUpdate() throws Exception {
		UserMarks marks = new UserMarks();
		int i = 8;
		marks.update(i);

	}

	private static void testAdd() throws Exception {
		UserJavaBean beans = new UserJavaBean();
		UserMarks marks = new UserMarks();

		beans.setFirstName("Vishnu");
		beans.setLastName("Prajapati");
		beans.setRollNo(110);
		beans.setChemistry(80);
		beans.setPhysics(85);
		beans.setMaths(90);

		marks.add(beans);
	}

}