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
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.SectionService;

/**
 * this servlet delete the section
 * 
 * @author ankit.raghuwanshi
 *
 */
@WebServlet("/DeleteSectionController")
public class DeleteSectionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SectionService sectionService;
	static final Logger LOGGER = Logger.getLogger(DeleteSectionController.class);

	public DeleteSectionController() {
		super();
		sectionService = (SectionService) ObjectFactory.getObject(SectionService.class);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int sectionId = Integer.parseInt(request.getParameter("id"));
		System.out.println(sectionId);
		sectionService.delete(sectionId);
		Map<Section, String> sections = sectionService.listSection();
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("sections", sections);
		response.sendRedirect("sectionList.jsp");
	//	LOGGER.info("delete section successully");
	}

}
