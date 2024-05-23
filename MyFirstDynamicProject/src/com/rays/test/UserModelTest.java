package com.rays.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;

public class UserModelTest {

	public static void main(String[] args) throws Exception {

		testSearch();

	}

	private static void testSearch() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		List list = new ArrayList();

		list = model.search(bean);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (UserBean) it.next();
			System.out.println(bean.getFirstName());

		}

	}

}
