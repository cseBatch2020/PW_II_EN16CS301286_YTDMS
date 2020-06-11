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

/**
 * Servlet implementation class CategorizeSectionController
 */
@WebServlet("/CategorizeSectionController")
public class CategorizeSectionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       SectionService sectionService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategorizeSectionController() {
        super();
        sectionService=(SectionService) ObjectFactory.getObject(SectionService.class);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Map<Section,String> sections=sectionService.categorizeByCategoyName();
		session.setAttribute("sections", sections);
		response.sendRedirect("sectionList.jsp");
	}

}
