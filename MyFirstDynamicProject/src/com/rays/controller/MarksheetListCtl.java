package com.rays.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.MarksheetBean;
import com.rays.model.MarksheetModel;

@WebServlet("/MarksheetListCtl.do")
public class MarksheetListCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MarksheetBean bean = new MarksheetBean();
		MarksheetModel marks = new MarksheetModel();

		try {
			List list = marks.search();
			req.setAttribute("userList", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher rd = req.getRequestDispatcher("MarksheetListView.jsp");
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MarksheetModel marks = new MarksheetModel();
		String op = req.getParameter("operation");
		if (op.equals("Delete")) {
			String[] ids = req.getParameterValues("ids");
			for (String id : ids) {
				try {
					marks.delete(Integer.parseInt(id));
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			resp.sendRedirect("MarksheetListCtl");
		}
	}

}
