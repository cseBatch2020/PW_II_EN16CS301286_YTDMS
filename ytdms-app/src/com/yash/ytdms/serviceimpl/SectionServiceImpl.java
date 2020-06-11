package com.yash.ytdms.serviceimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.yash.ytdms.dao.SectionDAO;
import com.yash.ytdms.domain.Section;
import com.yash.ytdms.exception.SectionException;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.SectionService;
import com.yash.ytdms.util.JNDIUtil;
import com.yash.ytdms.util.ValidationUtil;

public class SectionServiceImpl extends JNDIUtil implements SectionService {
	private SectionDAO sectionDAO = null;
	static int displayOrderNumber=1;
	static int i=0;

	public SectionServiceImpl() {
		sectionDAO = (SectionDAO) ObjectFactory.getObject(SectionDAO.class);
	}

	@Override
	public void addSection(Section section) throws SectionException {
		if (ValidationUtil.validateSection(section.getName(), 50)) {

			throw new SectionException("Section name must be between 2 and 50 characters");

		} else if (ValidationUtil.validateLength(section.getDescription(), 255)) {

			throw new SectionException("Section Description must be between 2 and 255 characters");

		} else {
            section.setDisplayOrderNumber(displayOrderNumber++);
            section.setDocumentStatus(DOCUMENT_STATUS);
			sectionDAO.save(section);
		}

	}

	@Override
	public List<String> listCategories() {

		return sectionDAO.listCategories();
	}

	@Override
	public Map<Section, String> listSection(int numberOfSections) {
		System.out.println(numberOfSections);
		System.out.println(sectionDAO);
		return sectionDAO.listSection(numberOfSections);

	}

	@Override
	public Map<Section, String> listSection() {

		return sectionDAO.listSection();
	}

	@Override
	public Map<Section, String> getSections(String pageName, int page,int size) {
	     int nextCount=(size/10)+1;
		if(pageName.equalsIgnoreCase("previous")) {
			 i=i-10;
		}else {
		   if(nextCount!=1) {
				i=i+10;		
				nextCount--;
		   }
		}
		return sectionDAO.getSections(pageName, i);
	}
	public Section updateForm(int id) {
		Section section = sectionDAO.updateForm(id);
		return section;
	}

	@Override
	public void update(int id, String name, String description, String category) throws SectionException {
		if (ValidationUtil.validateLength(name, 50)) {
			throw new SectionException("Section name must be between 2 and 50 characters");
		} else if (ValidationUtil.validateLength(description, 255)) {
			throw new SectionException("Section desciption must be between 2 and 255 characters");
		} else {
			sectionDAO.update(id, name, description, category);
		}

	}

	@Override
	public void delete(int id) {
		sectionDAO.delete(id);

	}

	@Override
	public int getCategoryId(String categoryName) {
		int categoryId = 0;
		String sql = "SELECT ID FROM categories WHERE NAME=?";
		try {
			PreparedStatement psmt = preparedStatement(sql);
			psmt.setString(1, categoryName);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				categoryId = rs.getInt("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		return categoryId;
	}

	@Override
	public Map<Section, String> searchSections(String searchItem) {
		Map<Section, String> sections = sectionDAO.search(searchItem);
		return sections;
	}

	@Override
	public Map<Section, String> categorizeByCategoyName() {
		Section section;
		String categoryName;
		Map<Section, String> sections = new LinkedHashMap<Section, String>();
		String sql = "SELECT s.id,s.name,s.description,c.name AS categoryName FROM sections s JOIN categories c WHERE s.categoryId=c.id ORDER BY categoryName";
		PreparedStatement psmt = preparedStatement(sql);
		try {
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				section = new Section();
				section.setId(rs.getInt("id"));
				section.setName(rs.getString("name"));
				section.setDescription(rs.getString("description"));
				categoryName = rs.getString("categoryName");
				sections.put(section, categoryName);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		return sections;
	}

	@Override
	public void changeSectionDisplayOrder(int id) {
		  sectionDAO.changeRecordDisplayOrder(id);
		
	}

	@Override
	public void changeDownSectionDisplayOrder(int id) {
		  sectionDAO.changeRecordDisplayOrder(id);
		
	}

	@Override
	public Map<Section, String> filterbyCategortyName(String categoryName) {
		Map<Section, String> sections=new LinkedHashMap<>();
		Section section=null;
		String newCategoryName;
		String sql="SELECT s.id,s.name,s.description,c.name AS categoryName FROM sections s JOIN categories c ON s.categoryId=c.id WHERE c.name=?";
		PreparedStatement psmt=preparedStatement(sql);
		try {
			psmt.setString(1, categoryName);
			ResultSet rs=psmt.executeQuery();
			while(rs.next()) {
			section=new Section();
			section.setId(rs.getInt("id"));
			section.setName(rs.getString("name"));
			section.setDescription(rs.getString("description"));
			newCategoryName=rs.getString("categoryName");
			sections.put(section, newCategoryName);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sections;
	}

}
