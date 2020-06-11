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
 * Servlet implementation class NextPageController
 */
@WebServlet("/NextPageController")
public class NextPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SectionService sectionService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NextPageController() {
        super();
        sectionService = new SectionServiceImpl();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    String pageName=request.getParameter("page");
	    HttpSession httpSession=request.getSession();
		Map<Section,String> sections= (Map<Section,String>)httpSession.getAttribute("sections");
		
	   	 sections = sectionService.getSections(pageName,10,sections.size());
	
		
		httpSession.setAttribute("sections", sections);
		response.sendRedirect("sectionList.jsp");
	}

}