package com.yash.ytdms.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yash.ytdms.domain.Section;
import com.yash.ytdms.service.SectionService;
import com.yash.ytdms.serviceimpl.SectionServiceImpl;

/**
 * Servlet implementation class MoveUpSectionController
 */
@WebServlet("/movedown")
public class MoveDownSectionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SectionService sectionService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MoveDownSectionController() {
		super();
		sectionService = new SectionServiceImpl();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sectionId = request.getParameter("id");
		int id = Integer.parseInt(sectionId);
		sectionService.changeDownSectionDisplayOrder(id);
		HttpSession httpSession = request.getSession();
		getServletContext().getRequestDispatcher("/DisplaySectionListController").forward(request, response);
	}

}