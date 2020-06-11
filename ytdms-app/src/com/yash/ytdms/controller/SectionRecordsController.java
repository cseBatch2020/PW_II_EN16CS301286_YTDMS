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
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.SectionService;
import com.yash.ytdms.serviceimpl.SectionServiceImpl;

/**
 * Servlet implementation class SectionRecordsController
 */
@WebServlet("/SectionRecordsController")
public class SectionRecordsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SectionService sectionService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SectionRecordsController() {
        super();
        sectionService =(SectionService) ObjectFactory.getObject(SectionService.class);
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page=request.getParameter("page");
	    response.setContentType("text/html");
	    int numberOfSections=Integer.parseInt(page);
		Map<Section,String> sections = sectionService.listSection(numberOfSections);
		int size=sections.size();
		HttpSession httpSession=request.getSession();
		httpSession.setAttribute("sections", sections);
		httpSession.setAttribute("pages", size);
		getServletContext().getRequestDispatcher("/DisplaySectionListController").forward(request, response);

		    
		
	}

}
