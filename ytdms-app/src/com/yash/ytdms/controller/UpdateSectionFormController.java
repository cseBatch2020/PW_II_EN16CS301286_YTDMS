package com.yash.ytdms.controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class UpdateSectionFormController
 */
@WebServlet("/UpdateSectionFormController")
public class UpdateSectionFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SectionService sectionService; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSectionFormController() {
        super();
        sectionService  =(SectionService) ObjectFactory.getObject(SectionService.class);
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int  sectionId=Integer.parseInt(request.getParameter("id"));
			Section section=sectionService.updateForm(sectionId);
			List<String> categories = sectionService.listCategories();
			HttpSession httpSession=request.getSession();
			httpSession.setAttribute("categories", categories);
			httpSession.setAttribute("id", section.getId());
			httpSession.setAttribute("name", section.getName());
			httpSession.setAttribute("description", section.getDescription());
	        response.sendRedirect("update_section_form.jsp");
	}

}
