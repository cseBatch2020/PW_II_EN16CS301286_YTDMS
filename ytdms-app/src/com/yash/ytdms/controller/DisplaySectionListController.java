package com.yash.ytdms.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yash.ytdms.domain.Section;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.SectionService;

/**
 * Servlet implementation class DisplaySectionList
 */
@WebServlet("/DisplaySectionListController")
public class DisplaySectionListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SectionService sectionService;

	/**
	 * @see HttpServlet#HttpServlet()
	 * 
	 * 
	 *      /**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplaySectionListController() {
		super();
		sectionService = (SectionService) ObjectFactory.getObject(SectionService.class);
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		Map<Section, String> sections = sectionService.listSection();
		List<String> catogories=sectionService.listCategories();
		HttpSession httpSession = request.getSession();
		if(request.getParameter("categoryId")!=null) {
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		httpSession.setAttribute("categoryId", categoryId);
		}
		httpSession.setAttribute("sections", sections);
		httpSession.setAttribute("categories", catogories );
		response.sendRedirect("sectionList.jsp");
	}

}
