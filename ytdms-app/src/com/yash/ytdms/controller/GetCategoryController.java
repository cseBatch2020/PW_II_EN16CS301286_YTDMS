package com.yash.ytdms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.SectionService;

/**
 * Servlet implementation class GetCategoryController
 */
@WebServlet("/GetCategoryController")
public class GetCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SectionService sectionService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCategoryController() {
        super();
        sectionService =(SectionService) ObjectFactory.getObject(SectionService.class);
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		List<String> categories = sectionService.listCategories();
		HttpSession httpSession=request.getSession();
		httpSession.setAttribute("categories", categories);
		response.sendRedirect("add-section-form.jsp");
	}

}
