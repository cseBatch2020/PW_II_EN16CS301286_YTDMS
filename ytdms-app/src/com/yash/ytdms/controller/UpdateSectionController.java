package com.yash.ytdms.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.yash.ytdms.domain.Section;
import com.yash.ytdms.exception.SectionException;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.SectionService;
import com.yash.ytdms.serviceimpl.SectionServiceImpl;

/**
 * Servlet implementation class UpdateSectionController
 */
@WebServlet("/UpdateSectionController")
public class UpdateSectionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SectionService sectionService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateSectionController() {
		super();
		sectionService = (SectionService) ObjectFactory.getObject(SectionService.class);
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Section section=new Section();
		int id = (int) session.getAttribute("id");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String category = request.getParameter("category");
		try {
			sectionService.update(id, name, description, category);
			//LOGGER.info("section updated successully");
			getServletContext().getRequestDispatcher("/DisplaySectionListController").forward(request, response);
		} catch (SectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
