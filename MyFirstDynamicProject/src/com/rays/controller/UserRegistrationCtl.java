package com.rays.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserRegistrationCtl")
public class UserRegistrationCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse responsep) throws ServletException, IOException {
		System.out.println("In do Get method");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse responsep) throws ServletException, IOException {
		System.out.println("In do Post method");
	}

}
