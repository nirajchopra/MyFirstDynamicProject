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

@WebServlet("/MarksheetCtl.do")
public class MarksheetCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel marks = new MarksheetModel();

		if (id != null) {
			try {
				bean = marks.findByPk(Integer.parseInt(id));
				req.setAttribute("bean", bean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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

		String fName = req.getParameter("firstName");
		String lName = req.getParameter("lastName");
		String rollNoStr = req.getParameter("rollNo");
		String physicsStr = req.getParameter("physics");
		String chemistryStr = req.getParameter("chemistry");
		String mathsStr = req.getParameter("maths");
		try {
			bean.setFirstName(fName);
			bean.setLastName(lName);

			int rollNo = Integer.parseInt(rollNoStr);
			int physics = Integer.parseInt(physicsStr);
			int chemistry = Integer.parseInt(chemistryStr);
			int maths = Integer.parseInt(mathsStr);
			bean.setRollNo(rollNo);
			bean.setPhysics(physics);
			bean.setChemistry(chemistry);
			bean.setMaths(maths);
		} catch (Exception e) {
			e.printStackTrace();

		}

		if (op.equals("save")) {
			try {
				marks.add(bean);
				req.setAttribute("msg", "user added successfully");
				req.setAttribute("bean", bean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (op.equals("update")) {
			String id = req.getParameter("id");
			bean.setId(Integer.parseInt(id));
			
			try {
				marks.update(bean);
				req.setAttribute("msg", "user Updated successfully");
				req.setAttribute("bean", bean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		RequestDispatcher rd = req.getRequestDispatcher("MarksheetView.jsp");
		rd.forward(req, resp);

	}
}
