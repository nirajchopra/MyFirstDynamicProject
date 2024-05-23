package com.rays.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;

@WebServlet("/UserListCtl")
public class UserListCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int pageNo = 1;
		int pageSize = 5;

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		try {
			List list = model.search(bean);
			List nextList = model.search(null);
			request.setAttribute("userList", list);
			request.setAttribute("nextList", nextList);
			request.setAttribute("pageNo", pageNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("UserListView.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserBean bean = null;
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		int pageSize = 5;

		UserModel model = new UserModel();
		String op = request.getParameter("operation");
		if (op.equals("next")) {
			pageNo++;
		}

		if (op.equals("Delete")) {
			String[] ids = request.getParameterValues("ids");
			for (String id : ids) {
				try {
					model.delete(Integer.parseInt(id));
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			response.sendRedirect("UserListCtl");
		}
		
		try {
			List list = model.search(bean);
			List nextList = model.search(bean);
			request.setAttribute("list", list);
			request.setAttribute("nextList", nextList);
			request.setAttribute("pageNo", pageNo);
			RequestDispatcher rd = request.getRequestDispatcher("UserListView.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}