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

/**
 * Servlet implementation class AddSectionController
 */
@WebServlet("/AddSectionController")
public class AddSectionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SectionService sectionService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddSectionController() {
		super();
		sectionService = (SectionService) ObjectFactory.getObject(SectionService.class);
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Section section = new Section();
		HttpSession session = request.getSession();
		section.setName(request.getParameter("name"));
		section.setDescription(request.getParameter("description"));
		int categoryId = sectionService.getCategoryId(request.getParameter("categoryName"));
		
		section.setCategoryId(categoryId);
		try {
			session.setAttribute("section", section);
			sectionService.addSection(section);
			Map<Section, String> sections=sectionService.listSection(10);
			session.setAttribute("sections", sections);
			response.sendRedirect("sectionList.jsp");
		} catch (SectionException e) {
			// TODO Auto-generated catch block
			response.sendRedirect("add-section-form.jsp?msg="+e.getMessage());
			e.printStackTrace();			
		}

	

	}

}
