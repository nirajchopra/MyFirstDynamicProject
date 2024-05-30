package com.rays.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.MarksheetBean;
import com.rays.model.MarksheetModel;

@WebServlet("/MarksheetCtl")
public class MarksheetCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		MarksheetModel marks = new MarksheetModel();
		MarksheetBean bean = null;

		if (id != null) {
			try {
				bean = marks.findByPk(Integer.parseInt(id));
				req.setAttribute("bean", bean);
			} catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("error", "An error occurred while fetching the marksheet.");
			}
		}
		RequestDispatcher rd = req.getRequestDispatcher("MarksheetView.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("operation");
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel marks = new MarksheetModel();

		try {
			bean.setFirstName(req.getParameter("firstName"));
			bean.setLastName(req.getParameter("lastName"));
			bean.setRollNo(Integer.parseInt(req.getParameter("rollNo")));
			bean.setPhysics(Integer.parseInt(req.getParameter("physics")));
			bean.setChemistry(Integer.parseInt(req.getParameter("chemistry")));
			bean.setMaths(Integer.parseInt(req.getParameter("maths")));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			req.setAttribute("error", "Invalid input format.");
			RequestDispatcher rd = req.getRequestDispatcher("MarksheetView.jsp");
			rd.forward(req, resp);
			return;
		}

		try {
			if ("save".equals(op)) {
				marks.add(bean);
				req.setAttribute("msg", "Marksheet added successfully.");
			} else if ("update".equals(op)) {
				bean.setId(Integer.parseInt(req.getParameter("id")));
				marks.update(8);
				req.setAttribute("msg", "Marksheet updated successfully.");
			}
			req.setAttribute("bean", bean);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "An error occurred while processing the marksheet.");
		}

		RequestDispatcher rd = req.getRequestDispatcher("MarksheetView.jsp");
		rd.forward(req, resp);
	}
}
